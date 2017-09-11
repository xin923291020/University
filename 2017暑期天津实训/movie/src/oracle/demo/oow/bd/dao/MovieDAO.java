package oracle.demo.oow.bd.dao;

import java.io.IOException;
import java.util.List;

import oracle.demo.oow.bd.to.MovieTO;

import oracle.demo.oow.bd.to.CastCrewTO;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.util.parser.URLReader;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import hbaseTools.HbaseFactory;

public class MovieDAO
{
	public final static String TABLE_NAME = "MOVIE";
	public final static String CHILD_TABLE = "CastCrew";

	public MovieDAO()
	{
		super();
	}

	/**
	 * This method fetches movie information for the movieId
	 * @param movieId - unique id of the movie
	 * @return MovieTO
	 */
	public MovieTO getMovieById(int movieId)
	{

		List<CastTO> castList = null;
		List<CrewTO> crewList = null;
		CastDAO castDAO = new CastDAO();
		CrewDAO crewDAO = new CrewDAO();
		CastCrewTO castCrewTO = new CastCrewTO();
		MovieTO movieTO = null;
		Result result = null;
		try
		{
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Scan scan = new Scan();
			Filter rowFilter = new RowFilter(CompareOp.EQUAL,new BinaryComparator(Bytes.toBytes(String.valueOf(movieId))));
			scan.setFilter(rowFilter);
			ResultScanner resultScanner = table.getScanner(scan);
			result = resultScanner.next();
		}
		catch (NumberFormatException | IOException e)
		{
			e.printStackTrace();
		}

		//PrimaryKey key = KeyUtil.getMovieIdKey(movieId, movieTable);
		//Row row = super.getKVStore().getTableAPI().get(key, null);
		if (result != null)
		{
			JSONObject moiveJsonObject = new JSONObject();
			moiveJsonObject.put("id", Integer.valueOf(new String(result.getValue("info".getBytes(), "id".getBytes()))));
			moiveJsonObject.put("original_title", new String(result.getValue("info".getBytes(), "original_title".getBytes())));
			moiveJsonObject.put("overview", new String(result.getValue("info".getBytes(), "overview".getBytes())));
			moiveJsonObject.put("poster_path", new String(result.getValue("info".getBytes(), "poster_path".getBytes())));
			moiveJsonObject.put("release_date", new String(result.getValue("info".getBytes(), "release_date".getBytes())));
			moiveJsonObject.put("vote_count", new String(result.getValue("info".getBytes(), "vote_count".getBytes())));
			moiveJsonObject.put("runtime", new String(result.getValue("info".getBytes(), "runtime".getBytes())));
			moiveJsonObject.put("popularity", new String(result.getValue("info".getBytes(), "popularity".getBytes())));
			String genres = new String(result.getValue("info".getBytes(), "genres".getBytes()));
			JSONArray jsonArray = (JSONArray) JSON.parse(genres);
			moiveJsonObject.put("genres", jsonArray);
			movieTO = new MovieTO(moiveJsonObject.toJSONString());
			// Deserialize the movie avro object
			//System.out.println("movieTo对象属性" + row.toJsonString(true));
			//抓取kvstroe数据库中的数据。
			/*try
			{
				org.apache.hadoop.hbase.client.Table table = HbaseFactory.getHbaseConnection().getTable(TableName.valueOf("MOVIE"));
				TableUtils.insertInToMovie(table,row.toJsonString(true));
				table.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			movieTO = new MovieTO(row.toJsonString(true));*/
			// If internet connection is not successful then reset the
			// movie-poster
			if (movieTO != null && !URLReader.isInternetReachable())
			{
				movieTO.setPosterPath("");
			}
			// Get Cast Inforamtion and set it to castCrewTO
			castList = castDAO.getMovieCasts(movieId);
			castCrewTO.setCastList(castList);
			// Get Crew Inforamtion and set it to castCrewTO
			crewList = crewDAO.getMovieCrews(movieId);
			castCrewTO.setCrewList(crewList);
			movieTO.setCastCrewTO(castCrewTO);
		}
		return movieTO;
	}
}