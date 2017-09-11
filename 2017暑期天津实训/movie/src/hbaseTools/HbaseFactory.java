package hbaseTools;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import oracle.demo.oow.bd.dao.ActivityDAO;
import oracle.demo.oow.bd.dao.CastDAO;
import oracle.demo.oow.bd.dao.CrewDAO;
import oracle.demo.oow.bd.dao.CustomerDAO;
import oracle.demo.oow.bd.dao.GenreDAO;
import oracle.demo.oow.bd.dao.MovieDAO;

public class HbaseFactory
{
	private static String ZOOKEEPER_QUORUM_KEY = "hbase.zookeeper.quorum";
	private static String ROOTDIR_KEY = "hbase.rootdir";
	private static String ZOOKEEPER_QUORUM_VALUE = "shenshenxin";
	private static String ROOTDIR_VALUE = "hdfs://shenshenxin:9000/hbase";
	
	private static Configuration configuration = null;
	private static Connection connection = null;
	private static Table activityTable = null;
	private static Table castTable = null;
	private static Table customerGenresTable = null;
	private static Table customerGenreMovieTable = null;
	private static Table customerTable = null;
	private static Table crewTable = null;
	private static Table movieTable = null;
	private static Table genreTable = null;
	
	public static Connection getHbaseConnection()
	{
		if(connection == null)
		{
			if(configuration == null)
			{
				configuration = HBaseConfiguration.create();
				configuration.set(ZOOKEEPER_QUORUM_KEY,ZOOKEEPER_QUORUM_VALUE);
				configuration.set(ROOTDIR_KEY,ROOTDIR_VALUE);
			}
			try
			{
				System.out.println("尝试连接hbase");
				connection = ConnectionFactory.createConnection(configuration);
				System.out.println("连接成功");
			}
			catch(IOException e)
			{
				System.out.println("连接HBase失败");
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static Table getTable(String tableName) throws IOException
	{
		if(tableName.equals(ActivityDAO.TABLE_NAME))
		{
			if(activityTable == null)
			{
				activityTable = getHbaseConnection().getTable(TableName.valueOf(tableName));
			}
			return activityTable;
		}
		else if(tableName.equals(CastDAO.TABLE_NAME))
		{
			if(castTable == null)
			{
				castTable = getHbaseConnection().getTable(TableName.valueOf(tableName));
			}
			return castTable;
		}
		else if(tableName.equals(CustomerDAO.TABLE_NAME))
		{
			if(customerTable == null)
			{
				customerTable = getHbaseConnection().getTable(TableName.valueOf(tableName));
			}
			return customerTable;
		}
		else if(tableName.equals(CustomerDAO.CHILD_TABLE))
		{
			if(customerGenresTable == null)
			{
				customerGenresTable = getHbaseConnection().getTable(TableName.valueOf(tableName));
			}
			return customerGenresTable;
		}
		else if(tableName.equals(CustomerDAO.CUSTOMER_GENRE_MOVIE_TABLE))
		{
			if(customerGenreMovieTable == null)
			{
				customerGenreMovieTable = getHbaseConnection().getTable(TableName.valueOf(tableName));
			}
			return customerGenreMovieTable;
		}
		else if(tableName.equals(CrewDAO.TABLE_NAME))
		{
			if(crewTable == null)
			{
				crewTable = getHbaseConnection().getTable(TableName.valueOf(tableName));
			}
			return crewTable;
		}
		else if(tableName.equals(MovieDAO.TABLE_NAME))
		{
			if(movieTable == null)
			{
				movieTable = getHbaseConnection().getTable(TableName.valueOf(tableName));
			}
			return movieTable;
		}
		else if(tableName.equals(GenreDAO.TABLE_NAME))
		{
			if(genreTable == null)
			{
				genreTable = getHbaseConnection().getTable(TableName.valueOf(tableName));
			}
			return genreTable;
		}
		return null;
	}

	public static void setZOOKEEPER_QUORUM_KEY(String zOOKEEPER_QUORUM_KEY)
	{
		ZOOKEEPER_QUORUM_KEY = zOOKEEPER_QUORUM_KEY;
	}

	public static void setROOTDIR_KEY(String rOOTDIR_KEY)
	{
		ROOTDIR_KEY = rOOTDIR_KEY;
	}

	public static void setZOOKEEPER_QUORUM_VALUE(String zOOKEEPER_QUORUM_VALUE)
	{
		ZOOKEEPER_QUORUM_VALUE = zOOKEEPER_QUORUM_VALUE;
	}

	public static void setROOTDIR_VALUE(String rOOTDIR_VALUE)
	{
		ROOTDIR_VALUE = rOOTDIR_VALUE;
	}
}