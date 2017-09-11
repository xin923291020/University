package tools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class InvoiceCreater
{
	public static void doCreate()
	{
		try
		{
			String sql = "insert into invoice" + DateTool.getSuffixDate() + " values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = ApplicationContextFactory.getPreparedStatement(sql);
			preparedStatement.setString(1,getInvoiceCode());
			preparedStatement.setString(2,"个人");
			preparedStatement.setString(3,"石家庄铁道大学超市");
			String totalAmount = getTotalAmount();
			preparedStatement.setString(4,totalAmount);
			preparedStatement.setString(5,getTotalTax(totalAmount));
			preparedStatement.setString(6,getCurrentTime());
			preparedStatement.execute();
			
			sql = "insert into invoice" + DateTool.getSuffixDate() + " values(?,?,?,?,?,?)";
			preparedStatement = ApplicationContextFactory.getPreparedStatement(sql);
			preparedStatement.setString(1,getInvoiceCode());
			preparedStatement.setString(2,"石家庄铁道大学超市");
			preparedStatement.setString(3,"个人");
			totalAmount = getTotalAmount();
			preparedStatement.setString(4,totalAmount);
			preparedStatement.setString(5,getTotalTax(totalAmount));
			preparedStatement.setString(6,getCurrentTime());
			preparedStatement.execute();
			
			preparedStatement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getInvoiceCode()
	{
		String invoiceCode = "0000000000000000000";
		try
		{
			String sql = "select MAX(invoiceCode) from invoice" + DateTool.getSuffixDate();
			ResultSet rs = ApplicationContextFactory.getResultSet(sql);
			rs.next();
			invoiceCode = rs.getString(1);
			int invoiceNumber = 0;
			if(invoiceCode == null)
			{
				invoiceCode = "0000000000000000000";
			}
			else
			{
				invoiceNumber = Integer.valueOf(invoiceCode) + 1;
				invoiceCode = String.format("%019d", invoiceNumber);
			}
			rs.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return invoiceCode;
	}
	
	public static String getCurrentTime()
	{
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(now);
	}
	
	public static String getTotalAmount()
	{
		Random random = new Random();
        double number = Double.valueOf(Math.floor(random.nextDouble() * 100));
        return String.format("%.2f", number);
	}
	
	public static String getTotalTax(String totalAmount)
	{
		return String.format("%.2f",(Double.valueOf(totalAmount) * 0.17));
	}
}
