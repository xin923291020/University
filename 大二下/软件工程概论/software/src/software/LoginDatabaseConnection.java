package software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginDatabaseConnection
{
      private String url = "jdbc:sqlserver://localhost:1433;DatabaseName = Login";    //���ݿ��ʶ��   
      private String username = "sa";    //���ݿ��û�   
      private String password = "19951122";    //���ݿ��û�����  
      private Connection con = null;
      public LoginDatabaseConnection()
      {
    	  try
    	  {
    		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	  }
    	  catch(Exception e){}
      }
      public boolean creatConnection()
      {
    	  try
    	  {
    		  con = DriverManager.getConnection(url,username,password);    //����Login���ݿ⡣
    		  con.setAutoCommit(true);
    		  return true;
    	  }
    	  catch(SQLException e)
    	  {
    		  return false;
    	  }
      }
      public boolean executeUpdate(String username,String password)
      {
    	 if(con == null)
    	 {
    		 creatConnection();
    	 }
    	 try
    	 {
    		 String sql = "insert into register values(?,?)";    //��д���ݿ���䡣
    		 PreparedStatement ps = con.prepareStatement(sql);
    		 ps.setString(1,username);
    		 ps.setString(2,password);
    		 ps.executeUpdate();
    		 return true;
    	 }
    	 catch(SQLException e)
    	 {
    		 return false;
    	 }
      }
      public ResultSet executeQuery(String sql)
      {
    	  if(con == null)
     	  {
    		  System.out.println("00");
     	      creatConnection();
     	  }
    	  try
    	  {
    		  Statement stmt = con.createStatement();
    		  ResultSet rs = stmt.executeQuery(sql);
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
    	  catch(SQLException e){}
      }
	
}

