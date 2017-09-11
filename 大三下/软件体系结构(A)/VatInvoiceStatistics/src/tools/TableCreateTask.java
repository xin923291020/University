package tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TableCreateTask
{
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

	public TableCreateTask()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();
		
		if (date.before(new Date()))
		{
			try
			{
				create();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			date = this.addDay(date,1);
		}

		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				try
				{
					create();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}, date, PERIOD_DAY);
	}
	
	public Date addDay(Date date, int num)
	{
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(date);
		startDate.add(Calendar.DAY_OF_MONTH, num);
		return startDate.getTime();
	}
	
	public boolean create() throws SQLException
	{
		String sql = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES Where TABLE_NAME = 'invoice" + DateTool.getSuffixDate() + "'";
		ResultSet rs = ApplicationContextFactory.getResultSet(sql);
		rs.next();
		int number = rs.getInt(1);
		if(number == 0)
		{
			sql = "CREATE TABLE invoice" + DateTool.getSuffixDate();
			sql += "(";
			sql += "invoiceCode varchar(40) NOT NULL,";
			sql += "buyer varchar(20) NULL,";
			sql += "seller varchar(20) NULL,";
			sql += "totalAmount numeric(18, 2) NULL,";
			sql += "totalTax numeric(18, 2) NULL,";
			sql += "createTime varchar(30) NULL,";
			sql += "PRIMARY KEY(invoiceCode)"; 
			sql += ")";
			ApplicationContextFactory.executeUpdate(sql);
		}
		sql = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES Where TABLE_NAME = 'invoiceDetails" + DateTool.getSuffixDate() + "'";
		rs = ApplicationContextFactory.getResultSet(sql);
		rs.next();
		number = rs.getInt(1);
		if(number == 1)
		{
			return false;
		}
		else if(number == 0)
		{
			sql = "CREATE TABLE invoiceDetails" + DateTool.getSuffixDate();
			sql += "(";
			sql += "id int IDENTITY(1,1) NOT NULL,";
			sql += "invoiceCode varchar(40) NOT NULL,";
			sql += "serviceName varchar(200) NULL,";
			sql += "specificationModel varchar(20) NULL,";
			sql += "unit varchar(20) NULL,";
			sql += "number int NULL,";
			sql += "unitPrice numeric(18, 2) NULL,";
			sql += "amount numeric(18, 2) NULL,";
			sql += "taxRate numeric(2, 2) NULL,";
			sql += "tax numeric(18, 2) NULL,";
			sql += "FOREIGN KEY (invoiceCode) REFERENCES invoice" + DateTool.getSuffixDate() + "(invoiceCode)"; 
			sql += ")";
			System.out.println(sql);
			int i = ApplicationContextFactory.executeUpdate(sql);
			if(i == 0)
			{
				return false;
			}
		}
		return true;
	}
}