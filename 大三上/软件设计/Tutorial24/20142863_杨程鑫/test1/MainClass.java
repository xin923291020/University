package test1;

import java.sql.SQLException;

public class MainClass
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		DBOperater DB = new SQLServerDBOperator();
		DB.connDB();
		DB.useDB();
		DB.Close();
		DB = new OracleDBOperator();
		DB.connDB();
		DB.useDB();
		DB.Close();
	}
}