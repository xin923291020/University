package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBOperator extends DBOperater
{
	public void connDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:login","ycx","19951122");
	}
	public Connection GetConnection() throws SQLException
	{
		if(con == null)
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:login","ycx","19951122");
		}
		return con;
	}
}
