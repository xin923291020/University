package oracle.demo.oow.bd.dao;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import oracle.demo.oow.bd.constant.KeyConstant;
import oracle.demo.oow.bd.pojo.ActivityType;
import oracle.demo.oow.bd.pojo.BooleanType;
import oracle.demo.oow.bd.pojo.RatingType;
import oracle.demo.oow.bd.to.ActivityTO;
import oracle.demo.oow.bd.to.MovieTO;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import hbaseTools.HbaseFactory;

public class ActivityDAO
{

	MovieDAO movieDAO = null;

	public final static String TABLE_NAME = "ACTIVITY";

	public ActivityDAO()
	{
		super();
		movieDAO = new MovieDAO();
	}

	/**
	 * This method returns the ActivityTO for the movie saved in the Currently
	 * watching list. When a user pause a movie they were watching the position
	 * of the movie is saved as ActivityTO, so if you want to find out what
	 * position the movie was paused at you need to get the object from the same
	 * currently watching list. If ActivityTO is null that means movie has not
	 * been started yet.
	 * 
	 * @param custId
	 * @param movieId
	 * @return ActivityTO
	 */
	public ActivityTO getActivityTO(int custId, int movieId)
	{
		// update the current position of the movie into current watch list
		ActivityTO activityTO = null;
		/*PrimaryKey key = KeyUtil.getCustomerCurrentWatchListKey(custId, movieId, activityTable);
		Row vv = BaseDAO.getKVStore().getTableAPI().get(key, null);
		if (vv != null)
		{
			System.out.println("我要的" + vv.toJsonString(true));
			activityTO = new ActivityTO(vv.toJsonString(true));
		}*/

		String rowKey = String.valueOf(custId) + "-" + String.valueOf(movieId) + "-" + KeyConstant.CUSTOMER_CURRENT_WATCH_LIST;
		try
		{
			JSONObject jsonObject = getActivityTOJSONObject(rowKey);
			if(jsonObject != null)
			{
				activityTO = new ActivityTO(jsonObject.toJSONString());
			}
			else
			{
				return null;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return activityTO;
	}

	public static JSONObject getActivityTOJSONObject(String rowKey) throws IOException
	{
		Connection connection = HbaseFactory.getHbaseConnection();
		Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
		Scan scan = new Scan();
		Filter rowFilter = new RowFilter(CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes(rowKey)));
		scan.setFilter(new FilterList(rowFilter));
		ResultScanner resultScanner = table.getScanner(scan);
		Result result = resultScanner.next();
		if(result != null)
		{
			int custId = Integer.valueOf(new String(result.getValue(Bytes.toBytes("id"), Bytes.toBytes("custId"))));
			int movieId = Integer.valueOf(new String(result.getValue(Bytes.toBytes("id"), Bytes.toBytes("movieId"))));
			String position = new String(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("position")));
			String price = new String(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("price")));
			String rating = new String(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("rating")));
			String time = new String(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("time")));
			String activity = new String(result.getValue(Bytes.toBytes("type"), Bytes.toBytes("activity")));
			String genreId = new String(result.getValue(Bytes.toBytes("type"), Bytes.toBytes("genreId")));
			String recommended = new String(result.getValue(Bytes.toBytes("type"), Bytes.toBytes("recommended")));
			JSONObject activityJsonObject = new JSONObject();
			activityJsonObject.put("custId", custId);
			activityJsonObject.put("movieId", movieId);
			activityJsonObject.put("tableId", KeyConstant.CUSTOMER_CURRENT_WATCH_LIST);
			activityJsonObject.put("position", Integer.valueOf(position));
			activityJsonObject.put("price", Double.valueOf(price));
			activityJsonObject.put("rating", RatingType.getType(Integer.valueOf(rating)));
			activityJsonObject.put("time",time);
			activityJsonObject.put("activity",ActivityType.getType(Integer.valueOf(activity)));
			activityJsonObject.put("genreId", Integer.valueOf(genreId));
			activityJsonObject.put("recommended", BooleanType.getType(recommended));
			
			return activityJsonObject;
		}
		else
		{
			return null;
		}
	}
	
	public List<MovieTO> getCustomerCurrentWatchList(int custId)
	{
		return getMovieTOList(custId, KeyConstant.CUSTOMER_CURRENT_WATCH_LIST);
		// PrimaryKey key = KeyUtil.getCustomerCurrentWatchListKey(custId, 0,
		// activityTable);
		// List<MovieTO> movieList = movieDAO.getMoviesByKey(key);W
	}

	public List<MovieTO> getCustomerBrowseList(int custId)
	{
		return getMovieTOList(custId, KeyConstant.CUSTOMER_BROWSE_LIST);
	}

	public List<MovieTO> getCustomerHistoricWatchList(int custId)
	{
		/*PrimaryKey key = KeyUtil.getCustomerHistoricalWatchListKey(custId, 0, activityTable);
		List<MovieTO> movieList = movieDAO.getMoviesByKey(key);
		return movieList;*/
		return getMovieTOList(custId, KeyConstant.CUSTOMER_HISTORICAL_WATCH_LIST);
	}

	public List<MovieTO> getCommonPlayList()
	{
		//IndexKey key = KeyUtil.getCommonWatchListKey(activityTable);
		//List<MovieTO> movieList = movieDAO.getMoviesByKey(key);
		List<MovieTO> movieList = null;
		try
		{
			movieList = new ArrayList<MovieTO>();
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Scan scan = new Scan();
			List<Filter> filters = new ArrayList<Filter>();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String prefixTime = formatter.format(new Date());
			Filter timeSingleColumnValueFilter = new SingleColumnValueFilter(Bytes.toBytes(prefixTime),
					Bytes.toBytes("tableId"), CompareOp.EQUAL, new SubstringComparator(KeyConstant.COMMON_CURRENT_WATCH_LIST));
			Filter tableIdsingleColumnValueFilter = new SingleColumnValueFilter(Bytes.toBytes("id"),
					Bytes.toBytes("tableId"), CompareOp.EQUAL, new SubstringComparator(KeyConstant.COMMON_CURRENT_WATCH_LIST));
			filters.add(timeSingleColumnValueFilter);
			filters.add(tableIdsingleColumnValueFilter);
			scan.setFilter(new FilterList(filters));
			ResultScanner resultScanner = table.getScanner(scan);
			MovieDAO movieDAO = new MovieDAO();
			for (Result result : resultScanner)
			{
				if(result != null)
				{
					String movieId = new String(result.getValue("id".getBytes(), "movieId".getBytes()));
					String timeStamp = new String(result.getValue("info".getBytes(), "time".getBytes()));
					MovieTO movieTO = movieDAO.getMovieById(Integer.valueOf(movieId));
					if (movieTO != null)
					{
						movieTO.setOrder(praseTime(timeStamp));
						movieList.add(movieTO);
					}
				}
			}
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		Collections.sort(movieList);
		return movieList;
	}

	public void insertCustomerActivity(ActivityTO activityTO)
	{
		int custId = 0;
		int movieId = 0;
		ActivityType activityType = null;
		String jsonTxt = null;

		if (activityTO != null)
		{
			jsonTxt = activityTO.getJsonTxt();
			System.out.println("User Activity| " + jsonTxt);

			// FileWriterUtil.writeOnFile(activityTO.getActivityJsonOriginal().toString());
			custId = activityTO.getCustId();
			movieId = activityTO.getMovieId();

			if (custId > 0 && movieId > 0)
			{
				activityType = activityTO.getActivity();
				switch (activityType)
				{
				case STARTED_MOVIE:// insert movie entry into customer's currently watching
					activityTO.setTableId(KeyConstant.CUSTOMER_CURRENT_WATCH_LIST);
					JSONObject startedActivityTOJsonObject = JSON.parseObject(activityTO.getJsonTxt());
					insertActivityTO(startedActivityTOJsonObject);
					// delete movie from the browse list
					deleteActivityTO(custId + movieId + KeyConstant.CUSTOMER_BROWSE_LIST);
					break;
				case PAUSED_MOVIE:// update the current position of the movie into current watch list
					activityTO.setTableId(KeyConstant.CUSTOMER_CURRENT_WATCH_LIST);
					JSONObject pausedActivityTOJsonObject = JSON.parseObject(activityTO.getJsonTxt());
					insertActivityTO(pausedActivityTOJsonObject);
					break;
				case COMPLETED_MOVIE:// inset movie entry into historical play list
					activityTO.setTableId(KeyConstant.CUSTOMER_HISTORICAL_WATCH_LIST);
					JSONObject completedActivityTOJsonObject = JSON.parseObject(activityTO.getJsonTxt());
					insertActivityTO(completedActivityTOJsonObject);
					// delete movie entry from currently watching list
					deleteActivityTO(custId + movieId + KeyConstant.CUSTOMER_BROWSE_LIST);
					//key = KeyUtil.getCustomerBrowseListKey(custId, movieId, activityTable);
					//super.getKVStore().getTableAPI().delete(key, null, null);
					break;
				case RATE_MOVIE:// insert user rating for the movie in the CT_MV table
					JSONObject rateActivityTOJsonObject = JSON.parseObject(activityTO.getJsonTxt());
					insertActivityTO(rateActivityTOJsonObject);
					break;
				case BROWSED_MOVIE://insert browse information
					activityTO.setTableId(KeyConstant.CUSTOMER_BROWSE_LIST);
					JSONObject browsedActivityTOJsonObject = JSON.parseObject(activityTO.getJsonTxt());
					insertActivityTO(browsedActivityTOJsonObject);
					break;
				default:
					break;
				}
			}
		}
	}
	
	private List<MovieTO> getMovieTOList(int custId, String type)
	{
		List<MovieTO> movieList = null;
		try
		{
			movieList = new ArrayList<MovieTO>();
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Scan scan = new Scan();
			List<Filter> filters = new ArrayList<Filter>();
			Filter prefixFilter = new PrefixFilter(Bytes.toBytes(String.valueOf(custId)));
			Filter singleColumnValueFilter = new SingleColumnValueFilter(Bytes.toBytes("id"),
					Bytes.toBytes("tableId"), CompareOp.EQUAL, new SubstringComparator(type));
			filters.add(prefixFilter);
			filters.add(singleColumnValueFilter);
			scan.setFilter(new FilterList(filters));
			ResultScanner resultScanner = table.getScanner(scan);
			MovieDAO movieDAO = new MovieDAO();
			for (Result result : resultScanner)
			{
				String movieId = new String(result.getValue("id".getBytes(), "movieId".getBytes()));
				String timeStamp = new String(result.getValue("info".getBytes(), "time".getBytes()));
				MovieTO movieTO = movieDAO.getMovieById(Integer.valueOf(movieId));
				if (movieTO != null)
				{
					movieTO.setOrder(praseTime(timeStamp));
					movieList.add(movieTO);
				}
			}
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		Collections.sort(movieList);
		return movieList;
	}
	
	public long praseTime(String time)
	{
		Date date = null;
		try
		{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = simpleDateFormat.parse(time);
		}
		catch (ParseException e)
		{
			System.out.println("时间转换错误");
			e.printStackTrace();
		}
		
		return date.getTime();
	}
	
	private boolean insertActivityTO(JSONObject activityTOJsonObject)
	{
		boolean flag = false;

		Connection connection = HbaseFactory.getHbaseConnection();
		try
		{
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Put put = new Put(Bytes.toBytes(activityTOJsonObject.getString("custId") + "-"
					+ activityTOJsonObject.getString("movieId") + "-" + activityTOJsonObject.getString("tableId")));
			put.addColumn(Bytes.toBytes("id"), Bytes.toBytes("tableId"),
					Bytes.toBytes(activityTOJsonObject.getString("tableId")));
			put.addColumn(Bytes.toBytes("id"), Bytes.toBytes("custId"),
					Bytes.toBytes(activityTOJsonObject.getString("custId")));
			put.addColumn(Bytes.toBytes("id"), Bytes.toBytes("movieId"),
					Bytes.toBytes(activityTOJsonObject.getString("movieId")));
			String genreId = activityTOJsonObject.getString("genreId");
			if (genreId == null)
			{
				genreId = "undefined";
			}
			put.addColumn(Bytes.toBytes("type"), Bytes.toBytes("genreId"), Bytes.toBytes(genreId));
			put.addColumn(Bytes.toBytes("type"), Bytes.toBytes("activity"),
					Bytes.toBytes(activityTOJsonObject.getString("activity")));
			put.addColumn(Bytes.toBytes("type"), Bytes.toBytes("recommended"),
					Bytes.toBytes(activityTOJsonObject.getString("recommended")));
			put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("time"),
					Bytes.toBytes(activityTOJsonObject.getString("time")));
			put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rating"),
					Bytes.toBytes(activityTOJsonObject.getString("rating")));
			put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("price"),
					Bytes.toBytes(activityTOJsonObject.getString("price")));
			put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("position"),
					Bytes.toBytes(activityTOJsonObject.getString("position")));
			table.put(put);
			table.close();
			flag = true;
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean deleteActivityTO(String rowKey)
	{
		boolean flag = false;
		try
		{
			Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Delete delete = new Delete(Bytes.toBytes("1255601-93-CT_BL"));
			table.delete(delete);
			table.close();
			flag = true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
}
