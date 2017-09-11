package software;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class StudentDatabaseConnection
{
	PreparedStatement ps = null;
	Connection cno = null;
	ResultSet rs = null;
	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName = StudentManagement";
	String username = "sa";
	String password = "19951122";
	
	public StudentDatabaseConnection()
	{
		try
		{
			Class.forName(driverName);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			cno = DriverManager.getConnection(url,username,password);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public int update(String sql,List<String> al)    //插入数据到数据库中
	{
		int flag = -1;
		try 
		{
			ps = cno.prepareStatement(sql);
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		for(int i = 0;i < al.size();i++)    //给sql语句赋值
		{
			try
			{
				String str = al.get(i);
				ps.setString(i+1, str.toString());
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		}
		try 
		{
			flag = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			//e.printStackTrace();
		}
		al.clear();
		return flag;
	}
	public boolean deleteFromSQL(String sql,String[] args)
	{
		boolean b = true;
		try
		{
			ps = cno.prepareStatement(sql);
			for(int i = 0; i < args.length; i++)
			{
				ps.setString((i + 1), args[i]);
			}
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		this.close();
		return b;
	}
	public ResultSet query(String sql, String[] args)
	{
		
		try
		{
			ps = cno.prepareStatement(sql);
			if (args == null)
			{
				rs = ps.executeQuery();
			}
			else
			{
				for (int i = 0; i < args.length; i++)
				{
					ps.setString((i + 1), args[i]);
				}
				rs = ps.executeQuery();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public void close()// 关闭资源
	{
		try 
		{
			if(rs != null)
			{
				rs.close();
			}
			if(ps != null)
			{
				ps.close();
			}
			if(cno != null)
			{
				cno.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}