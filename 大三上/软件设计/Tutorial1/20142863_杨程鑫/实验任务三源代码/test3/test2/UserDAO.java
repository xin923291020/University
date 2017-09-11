package test2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UserDAO
{
      DBUtil con = new DBUtil();
      public boolean findUser(String userName,String userPassword)
      {
      	  String sql="select * from register";
    	  try
    	  {
    		  Statement stmt=con.createStatement();
    		  ResultSet rs=stmt.executeQuery(sql);
    		  while(rs.next())
			  {
				  if(rs.getString("”√ªß√˚").equals(userName)&&rs.getString("√‹¬Î").equals(userPassword))
			      {
				        return true;
			      }
		      }
    	  }
    	  catch(SQLException e)
    	  {
    		  return false;
    	  }
		  return false;
      }
      public void connectionClose()
      {
    	  con.close();
      }
	
}

