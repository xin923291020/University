package oracle.demo.oow.bd.dao;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import com.alibaba.fastjson.JSONObject;

import hbaseTools.HbaseFactory;
import oracle.demo.oow.bd.to.GenreTO;

public class GenreDAO
{

	public final static String TABLE_NAME = "GENRE";

	/** Variables for JSONAvroBinding ***/
	public GenreDAO()
	{
		super();
	}
	
	/**
	 * This method returns all different Genres available in the store
	 * @return List of GenreTO
	 */
	public List<GenreTO> getGenres()
	{
		GenreTO genreTO = null;
		List<GenreTO> genreList = new ArrayList<GenreTO>();
		try
		{
			org.apache.hadoop.hbase.client.Connection connection = HbaseFactory.getHbaseConnection();
			org.apache.hadoop.hbase.client.Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
			Scan scan = new Scan();
			ResultScanner resultScanner = table.getScanner(scan);
			for (Result result : resultScanner)
			{
				JSONObject genreJsonObject = new JSONObject();
				genreJsonObject.put("cid", new String(result.getValue("id".getBytes(), "cid".getBytes())));
				genreJsonObject.put("id",
						Integer.valueOf(new String(result.getValue("id".getBytes(), "id".getBytes()))));
				genreJsonObject.put("name", new String(result.getValue("id".getBytes(), "name".getBytes())));
				genreTO = new GenreTO(genreJsonObject.toJSONString());
				genreList.add(genreTO);
			}
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return genreList;
	}
}