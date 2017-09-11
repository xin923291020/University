package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil
{
	private String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url="jdbc:sqlserver://localhost:1433;DatabaseName=Login";
    private String username="sa";
    private String password="19951122";
    private Connection con = null;
    public DBUtil()
    {
    	try
    	{
   		  Class.forName(dbDriver);
   	    }
   	    catch(Exception e)
   	    {
   	    }
    }
    public Connection getConnection()
    {
    	try
    	{
			con = DriverManager.getConnection(url,username,password);
			con.setAutoCommit(true);
			return con;
		}
    	catch (SQLException e)
    	{
			e.printStackTrace();
			return null;
		}
    }
	public PreparedStatement prepareStatement(String sql)
	{
		if(con == null)
		{
			getConnection();
		}
		PreparedStatement pstmt = null;
		try
		{
			pstmt = con.prepareStatement(sql);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return pstmt;
	}
	public Statement createStatement()
	{
		if(con == null)
		{
			getConnection();
		}
		Statement stmt = null;
		try
		{
			stmt = con.createStatement();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return stmt;
	}
	public void close()
	{
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
}