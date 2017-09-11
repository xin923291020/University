package software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public class GradeDatabaseConnection 
{
	  private String url="jdbc:sqlserver://localhost:1433;DatabaseName=Grade";
      private String username="sa";
      private String password="19951122";
      private Connection con=null;
      PreparedStatement ps = null;
      public GradeDatabaseConnection()
      {
    	  try
    	  {
    		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	  }
    	  catch(Exception e)
    	  {  
   
    	  }
      }
      public boolean creatConnection()
      {
    	  try
    	  {
    		  con=DriverManager.getConnection(url,username,password);
    		  con.setAutoCommit(true);
    		  return true;
    	  }
    	  catch(SQLException e)
    	  {
    		  System.out.println("....");
    		  return false;
    	  }
      }
      public boolean executeUpdate(String username,String password,String phone)
      {
    	 if(con==null)
    	 {
    		 creatConnection();
    	 }
    	 try
    	 {
    		 String sql="insert into register values(?,?,?)";
    		 PreparedStatement pstmt=con.prepareStatement(sql);
    		 pstmt.setString(1,username);
    		 pstmt.setString(2, password);
    		 pstmt.setString(3, phone);
    		 pstmt.executeUpdate();
    		 return true;
    	 }
    	 catch(SQLException e)
    	 {
    		 return false;
    	 }
      }
      public boolean executeUpdate(String sql)
      {
    	  if(con==null)
    	  {
    		  creatConnection();
    	  }
    	  try
    	  {
    		  Statement stmt=con.createStatement();
    		  stmt.executeUpdate(sql);
    		  return true;
    	  }
    	  catch(SQLException e)
    	  {
    		  return false;
    	  }
      }
      public int update1(String sql,List<String> al)    //插入数据到数据库中
  	{
    	  if(con==null)
     	 {
     		 creatConnection();
     	 }
  		int flag = -1;
  		try 
  		{
  			ps = con.prepareStatement(sql);
  			
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
  			e.printStackTrace();
  		}
  		al.clear();
  		return flag;
  	}
      
      public  ResultSet executeQuery(String sql)
      {
    	  if(con==null)
     	 {
     		 creatConnection();
     	 }
    	  try
    	  {
    		  Statement stmt=con.createStatement();
    		  ResultSet rs=stmt.executeQuery(sql);
    		  return rs;
    	  }
    	  catch(SQLException e)
    	  {
    		  return null;
    	  }
      }
      public void connectionClose()
      {
    	  try
    	  {
    	       con.close();
    	  }
    	  catch(SQLException e)
    	  {
    		  
    	  }
      }
	
}
