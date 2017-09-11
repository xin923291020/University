package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerDBOperator extends DBOperater
{
	public void connDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=annual","sa","19951122");
	}
	public Connection GetConnection() throws SQLException
	{
		if(con == null)
		{
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=DCS_User","sa","19951122");
		}
		return con;
	}
}
