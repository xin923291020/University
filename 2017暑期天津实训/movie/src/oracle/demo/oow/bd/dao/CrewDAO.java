package oracle.demo.oow.bd.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import hbaseTools.HbaseFactory;
import oracle.demo.oow.bd.to.CastCrewTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.StringUtil;

public class CrewDAO
{

	public final static String TABLE_NAME = "CREW";

	public CrewDAO()
	{
		super();
	}

	/**
	 * This method returns all the movies that Crew worked in.
	 * @param crewId
	 * @return List of MovieTO
	 */
	public List<MovieTO> getMoviesByCrew(int crewId)
	{
		List<String> movieIdList = null;
		List<MovieTO> movieList = new ArrayList<MovieTO>();
		CrewTO crewTO = null;
		MovieTO movieTO = null;
		MovieDAO movieDAO = new MovieDAO();
		//PrimaryKey key = KeyUtil.getCrewInfoKey(crewId, crewTable);
		//Row vv = super.getKVStore().getTableAPI().get(key, null);
		
		Result result = null;
		try
		{
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Scan scan = new Scan();
			Filter rowFilter = new RowFilter(CompareOp.EQUAL,new BinaryComparator(Bytes.toBytes(String.valueOf(crewId))));
			scan.setFilter(rowFilter);
			ResultScanner resultScanner = table.getScanner(scan);
			result = resultScanner.next();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		if (result != null)
		{
			//value = vv.toJsonString(true);
			//System.out.println(value);
			JSONObject crewJsonObject = new JSONObject();
			crewJsonObject.put("id", Integer.valueOf(new String(result.getValue("info".getBytes(), "id".getBytes()))));
			crewJsonObject.put("job", new String(result.getValue("info".getBytes(), "job".getBytes())));
			crewJsonObject.put("name", new String(result.getValue("info".getBytes(), "name".getBytes())));
			JSONArray jsonArray = (JSONArray) JSON.parse(new String(result.getValue("info".getBytes(), "movies".getBytes())));
			crewJsonObject.put("movies", jsonArray);
			crewTO = new CrewTO(crewJsonObject.toJSONString());
			movieIdList = crewTO.getMovieList();
			for (String movieIdStr : movieIdList)
			{
				movieTO = movieDAO.getMovieById(Integer.valueOf(movieIdStr));
				if (movieTO != null)
				{
					movieList.add(movieTO);
				}
			}
		}
		return movieList;
	}

	/**
	 * This method returns a list of Casts for the movieId passed Key=
	 * /MV_CW/movieId/-/crewId
	 * @param movieId - Unique Id of the movie
	 * @return List of CrewTO
	 */
	public List<CrewTO> getMovieCrews(int movieId)
	{
		List<CrewTO> crewList = null;
		CastCrewTO castCrewTO = null;
		String jsonTxt = null;
		//PrimaryKey key = null;
		if (movieId > -1)
		{
			/*key = KeyUtil.getMovieCastCrewKey(movieId, movieId, movieTable);
			Row row = getTableAPI().get(key, null);
			if (row != null)
			{
				jsonTxt = row.toJsonString(true);
			}*/
			jsonTxt = CastDAO.getCastAndList(movieId);
			if (StringUtil.isNotEmpty(jsonTxt))
			{
				castCrewTO = new CastCrewTO(jsonTxt.trim());
				crewList = castCrewTO.getCrewList();
			}
		}
		return crewList;
	}

	public static JSONArray getCrewJsonArray(int movieId) throws IOException
	{
		JSONArray jsonArray = new JSONArray();
		org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
		org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
		String substring = "{\"id\":" + movieId + "}";
		Filter singleColumnValueFilter = new SingleColumnValueFilter(Bytes.toBytes("info"), Bytes.toBytes("movies"),
				CompareOp.EQUAL, new SubstringComparator(substring));
		Scan scan = new Scan();
		scan.setFilter(singleColumnValueFilter);
		ResultScanner resultScanner = table.getScanner(scan);
		for (Result result : resultScanner)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", Integer.valueOf(new String(result.getValue("info".getBytes(), "id".getBytes()))));
			jsonObject.put("name", new String(result.getValue("info".getBytes(), "name".getBytes())));
			jsonObject.put("movies", "null");
			jsonObject.put("job", new String(result.getValue("info".getBytes(), "job".getBytes())));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
}