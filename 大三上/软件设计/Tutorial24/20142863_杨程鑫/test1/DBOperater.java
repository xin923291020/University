package test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBOperater
{
	protected Connection con;
	public void connDB() throws ClassNotFoundException, SQLException
	{
	}
	public Connection GetConnection() throws SQLException
	{
		return con;
	}
	public void useDB() throws SQLException
	{
		PreparedStatement SQLServerpstm = con.prepareStatement("Select * From Test");
		ResultSet rs = SQLServerpstm.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
	}
	public void Close() throws SQLException
	{
		con.close();
	}
}