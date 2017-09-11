package oracle.demo.oow.bd.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import hbaseTools.HbaseFactory;
import oracle.demo.oow.bd.to.CastCrewTO;
import oracle.demo.oow.bd.to.CastMovieTO;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.StringUtil;

public class CastDAO
{
	public final static String TABLE_NAME = "CAST";

	public CastDAO()
	{
		super();

	}

	/**
	 * This method returns a list of Casts for the movieId passed Key=/MV/movieId/-/cc
	 * @param movieId - Unique Id of the movie
	 * @return List of CastTO
	 */
	public List<CastTO> getMovieCasts(int movieId)
	{
		List<CastTO> castList = null;
		CastCrewTO castCrewTO = null;
		String jsonTxt = null;
		//PrimaryKey key = null;

		if (movieId > -1)
		{
			/*key = KeyUtil.getMovieCastCrewKey(movieId, movieId, movieTable);
			Row row = getKVStore().getTableAPI().get(key, null);
			if (row != null)
			{
				jsonTxt = row.toJsonString(true);
			}*/
			jsonTxt = getCastAndList(movieId);
			if (StringUtil.isNotEmpty(jsonTxt))
			{
				castCrewTO = new CastCrewTO(jsonTxt.trim());
				castList = castCrewTO.getCastList();
				Collections.sort(castList);
			}
		}

		return castList;
	} // getMovieCasts

	/**
	 * This method returns all the movies that Cast worked in.
	 * @param castId
	 * @return List of MovieTO
	 */
	public List<MovieTO> getMoviesByCast(int castId)
	{
		List<CastMovieTO> castMovieList = null;
		List<MovieTO> movieList = new ArrayList<MovieTO>();
		int movieId = 0;
		CastTO castTO = null;
		MovieTO movieTO = null;
		MovieDAO movieDAO = new MovieDAO();

		//PrimaryKey key = KeyUtil.getCastInfoKey(castId, castTable);
		//Row vv = getKVStore().getTableAPI().get(key, null);
		Result result = null;
		try
		{
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Scan scan = new Scan();
			Filter rowFilter = new RowFilter(CompareOp.EQUAL,new BinaryComparator(Bytes.toBytes(String.valueOf(castId))));
			scan.setFilter(rowFilter);
			ResultScanner resultScanner = table.getScanner(scan);
			result = resultScanner.next();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if(result != null)
		{
			JSONObject castJsonObject = new JSONObject();
			castJsonObject.put("id", Integer.valueOf(new String(result.getValue("info".getBytes(), "id".getBytes()))));
			JSONArray jsonArray = (JSONArray) JSON.parse(new String(result.getValue("info".getBytes(), "movies".getBytes())));
			castJsonObject.put("movies", jsonArray);
			castJsonObject.put("name", new String(result.getValue("info".getBytes(), "name".getBytes())));
			//System.out.println(castJsonObject.toJSONString());
			//System.out.println(vv.toJsonString(true));
			castTO = new CastTO(castJsonObject.toJSONString());
			if (castTO != null)
			{
				castMovieList = castTO.getCastMovieList();
				for (CastMovieTO castMovieTO : castMovieList)
				{
					movieId = castMovieTO.getId();
					movieTO = movieDAO.getMovieById(movieId);
	
					if (movieTO != null)
					{
						movieList.add(movieTO);
					}
				}
			}
		}
		return movieList;
	}
	
	public static String getCastAndList(int movieId)
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", movieId);
		jsonObject.put("mid", movieId);
		try
		{
			jsonObject.put("cast", getCastJsonArray(movieId));
			jsonObject.put("crew", CrewDAO.getCrewJsonArray(movieId));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return jsonObject.toJSONString();
	}
	
	private static JSONArray getCastJsonArray(int movieId) throws IOException
	{
		JSONArray jsonArray = new JSONArray();
		org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
		org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
		String substring = "{\"character\":\"\",\"id\":" + movieId + ",\"order\":1}";
		Filter singleColumnValueFilter = new SingleColumnValueFilter(
				Bytes.toBytes("info"), Bytes.toBytes("movies"),CompareOp.EQUAL, new SubstringComparator(substring));
		Scan scan = new Scan();
		scan.setFilter(singleColumnValueFilter);
		ResultScanner resultScanner = table.getScanner(scan);
		for(Result result : resultScanner)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", Integer.valueOf(new String(result.getValue(Bytes.toBytes("info"),Bytes.toBytes("id")))));
			byte[] nameBytes = result.getValue(Bytes.toBytes("info"), Bytes.toBytes("name"));
			if(nameBytes == null)
			{
				jsonObject.put("name","null");
			}
			else
			{
				jsonObject.put("name", new String(nameBytes));
			}
			byte[] moviesBytes = result.getValue(Bytes.toBytes("info"), Bytes.toBytes("movies"));
			if(moviesBytes == null)
			{
				jsonObject.put("movies", "null");
			}
			else
			{
				jsonObject.put("movies", new String(moviesBytes));
			}
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
	}
}