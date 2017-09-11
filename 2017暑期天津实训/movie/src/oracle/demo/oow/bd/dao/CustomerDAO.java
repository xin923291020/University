package oracle.demo.oow.bd.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import hbaseTools.HbaseFactory;
import oracle.demo.oow.bd.to.ActivityTO;
import oracle.demo.oow.bd.to.CustomerGenreMovieTO;
import oracle.demo.oow.bd.to.CustomerGenreTO;
import oracle.demo.oow.bd.to.CustomerTO;
import oracle.demo.oow.bd.to.GenreMovieTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.to.ScoredGenreTO;
import oracle.demo.oow.bd.util.StringUtil;

public class CustomerDAO
{
	public final static String TABLE_NAME = "CUSTOMER";
	public final static String CHILD_TABLE = "CustomerGenres";
	public final static String CUSTOMER_GENRE_MOVIE_TABLE = "CustomerGenreMovie";

	private static int MOVIE_MAX_COUNT = 25;
	public CustomerDAO()
	{
		super();
	}
	
	/**
	 * Overloaded method that defaults max number of movies to MAX_COUNT limit.
	 * This method fetches recommended movies for the customer. If the
	 * recommendation is not yet made for the customer for the genreId then
	 * DEFAULT recommendation is used.
	 * @param custId
	 * @param genreId
	 * @return
	 */
	public List<MovieTO> getMovies4CustomerByGenre(int custId, int genreId)
	{
		return getMovies4CustomerByGenre(custId, genreId, MOVIE_MAX_COUNT);
	}

	/**
	 * This method fetches recommended movies for the customer. If the
	 * recommendation is not yet made for the customer for the genreId then
	 * DEFAULT recommendation is used.
	 * 
	 * @param custId
	 * @param genreId
	 *            * @param maxCount
	 * @return List of MovieTO
	 */
	public List<MovieTO> getMovies4CustomerByGenre(int custId, int genreId, int maxCount)
	{
		List<MovieTO> movieList = new ArrayList<MovieTO>();
		MovieTO movieTO = null;
		ActivityTO activityTO = null;
		MovieDAO movieDAO = new MovieDAO();
		String value = null;
		int movieId = 0;
		int count = 0;

		try
		{
			ResultScanner resultScanner = getResultScanner(custId, genreId, movieId);
			Iterator<Result> resultIterator = resultScanner.iterator();
			if(!resultIterator.hasNext())
			{
				resultScanner = getResultScanner(custId, genreId, 0);
				resultIterator = resultScanner.iterator();
			}
			while(resultIterator.hasNext())
			{
				Result result = resultIterator.next();
				String custIdString = new String(result.getValue(Bytes.toBytes("id"), Bytes.toBytes("id")));
				String genreIdString = new String(result.getValue(Bytes.toBytes("id"), Bytes.toBytes("genreId")));
				String movieIdString = new String(result.getValue(Bytes.toBytes("id"), Bytes.toBytes("movieId")));
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", Integer.valueOf(custIdString));
				jsonObject.put("genreId", Integer.valueOf(genreIdString));
				jsonObject.put("movieId", Integer.valueOf(movieIdString));
				value = jsonObject.toJSONString();
				System.out.println(value);
				CustomerGenreMovieTO custGM = new CustomerGenreMovieTO(value);
				movieId = custGM.getMovieId();
				
				movieTO = movieDAO.getMovieById(movieId);
				if (movieTO != null)
				{
					if (StringUtil.isNotEmpty(movieTO.getPosterPath()))
					{
						movieTO.setOrder(100);
					}
					else
					{
						movieTO.setOrder(0);
					}
					// Check to see if user has already rated this movie
					activityTO = this.getMovieRating(custId, movieId);
					if (activityTO != null)
					{
						movieTO.setUserRating(activityTO.getRating());
					}
					movieList.add(movieTO);
					if (++count >= maxCount)
					{
						System.out.println(count);
						break;
					}
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		Collections.sort(movieList);
		return movieList;
	}
	
	public ResultScanner getResultScanner(int custId,int genreId,int movieId) throws IOException
	{
		org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
		org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf("CustomerGenreMovie"));
		Scan scan = new Scan();
		if(movieId > 0)
		{
			Filter filter = new PrefixFilter(Bytes.toBytes(custId + "-" + genreId + "-" + movieId));
			scan.setFilter(new FilterList(filter));
		}
		else
		{
			Filter filter = new PrefixFilter(Bytes.toBytes(custId + "-" + genreId));
			scan.setFilter(new FilterList(filter));
		}
		return table.getScanner(scan);
	}

	/**
	 * This method returns top N movies for M ordered genres recommended to the customer.
	 * @param custId
	 * @param movieMaxCount
	 * @param genreMaxCount
	 * @return
	 */
	public List<GenreMovieTO> getMovies4Customer(int custId, int movieMaxCount, int genreMaxCount)
	{
		List<GenreMovieTO> genreMovieList = new ArrayList<GenreMovieTO>();
		int genreId = 0;
		String name = null;
		GenreMovieTO genreMovieTO = null;
		GenreTO genreTO = null;
		List<MovieTO> movieList = null;
		int count = 0;
		//PrimaryKey key = KeyUtil.getCustomerGenresKey(custId, customerTable);
		//Row row = getKVStore().getTableAPI().get(key, null);
		// If there is no ordered list of genres available for the customer
		// get the default ordered list
		JSONObject jsonObject = getJsonObject(custId);
		String jsonTxt = null;
		if(jsonObject != null)
		{
			jsonTxt = jsonObject.toJSONString();
		}
		/*if (row != null)
		{
			jsonTxt = row.toJsonString(true);
		}*/
		if (StringUtil.isEmpty(jsonTxt))
		{
			jsonObject = getJsonObject(0);
			jsonTxt = (jsonObject != null ? jsonObject.toJSONString() : null);
		}
		System.out.println("×îÖÕ½á¹û~~~~~~~~~" + jsonTxt);
		if (StringUtil.isNotEmpty(jsonTxt))
		{
			CustomerGenreTO customerGenreTO = new CustomerGenreTO(jsonTxt);
			for (ScoredGenreTO scoredGenreTO : customerGenreTO.getScoredGenreList())
			{
				count++;
				genreMovieTO = new GenreMovieTO();
				genreId = scoredGenreTO.getId();
				name = scoredGenreTO.getName();

				genreTO = new GenreTO();
				genreTO.setId(genreId);
				genreTO.setName(name);
				// get Movie list by genre
				movieList = this.getMovies4CustomerByGenre(custId, genreId, movieMaxCount);
				// set GenreTO & MovieTO list to GenreMovieTO
				genreMovieTO.setGenreTO(genreTO);
				genreMovieTO.setMovieList(movieList);
				// add genreMovieTO to the list
				genreMovieList.add(genreMovieTO);
				// Break the loop if you have got M top genres from the list
				if (count >= genreMaxCount)
				{
					break;
				}
			}
		} 
		else
		{
			System.out.println(
					"Error: Default recommendation data is not fed into DB yet:\nPlease run MovieDAO.insertTopMoviesPerGenre() method first to seed the default recommendation.");
		}
		return genreMovieList;
	}

	private JSONObject getJsonObject(int custId)
	{
		JSONObject jsonObject = new JSONObject();
		try
		{
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf("CustomerGenres"));
			Scan scan = new Scan();
			Filter rowFilter = new RowFilter(CompareOp.EQUAL,new BinaryComparator(Bytes.toBytes(String.valueOf(custId))));
			scan.setFilter(rowFilter);
			ResultScanner resultScanner = table.getScanner(scan);
			Result result = resultScanner.next();
			if(result != null)
			{
				jsonObject.put("id", custId);
				jsonObject.put("cid", custId);
				JSONArray jsonArray = JSON.parseArray(new String(result.getValue("info".getBytes(), "genres".getBytes())));
				jsonObject.put("genres", jsonArray);
			}
			else
			{
				return null;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * This method returns ActivitTO that has customer's movie rating
	 * @param custId
	 * @param movieId
	 * @return ActivityTO
	 */
	public ActivityTO getMovieRating(int custId, int movieId)
	{
		String jsonTxt = null;
		String rowKey = custId + movieId + "CLICK";
		try
		{
			JSONObject jsonObject = ActivityDAO.getActivityTOJSONObject(rowKey);
			if(jsonObject != null)
			{
				jsonTxt = jsonObject.toJSONString();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		ActivityTO activityTO = null;
		if (StringUtil.isNotEmpty(jsonTxt))
		{
			activityTO = new ActivityTO(jsonTxt);
		}
		return activityTO;
	}

	/**
	 * This method validates if username and password are valid. If they are
	 * then it return CustomerTO otherwise null.
	 * @param username
	 * @param password
	 * @return CustomerTO
	 */
	public CustomerTO getCustomerByCredential(String username, String password)
	{
		CustomerTO customerTO = null;
		try
		{
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Scan scan = new Scan();
			Filter rowFilter = new RowFilter(CompareOp.EQUAL,new BinaryComparator(Bytes.toBytes(username)));
			scan.setFilter(rowFilter);
			ResultScanner resultScanner = table.getScanner(scan);
			Result result = resultScanner.next();
			JSONObject customerJsonObject = new JSONObject();
			customerJsonObject.put("id", Integer.valueOf(new String(result.getValue("user".getBytes(), "id".getBytes()))));
			customerJsonObject.put("username", new String(result.getValue("user".getBytes(), "username".getBytes())));
			customerJsonObject.put("password", new String(result.getValue("user".getBytes(), "password".getBytes())));
			customerJsonObject.put("name", new String(result.getValue("info".getBytes(), "name".getBytes())));
			customerJsonObject.put("email", new String(result.getValue("info".getBytes(), "email".getBytes())));
			System.out.println(customerJsonObject.toJSONString());
			customerTO = new CustomerTO(customerJsonObject.toJSONString());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return customerTO;
	}
	
	public List<Integer> getAllCustomerId()
	{
		List<Integer> customerIdList = new ArrayList<Integer>();
		try
		{
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Scan scan = new Scan();
			ResultScanner resultScanner = table.getScanner(scan);
			for(Result result : resultScanner)
			{
				customerIdList.add(Integer.valueOf(new String(result.getValue("user".getBytes(), "id".getBytes()))));	
			}
			table.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return customerIdList;
	}
}
