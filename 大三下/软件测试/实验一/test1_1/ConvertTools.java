package test1_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertTools
{
	public boolean IsGreaterThanFiveNumber(String dataString)
	{
		try
		{
			int number = Integer.valueOf(dataString);
			if(number >= 10000 && number < 100000000)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean isNumber(String numberString)
	{
		try
		{
			Integer.valueOf(numberString);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public boolean isDate(String dataString)
	{
		boolean convertSuccess = false;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		try
		{
			simpleDateFormat.setLenient(false);
			simpleDateFormat.parse(dataString);
			return true;
		}
		catch (Exception e)
		{
			convertSuccess = false;
		}
		return convertSuccess;
	}
	
	public Date convertToDate(String dataString) throws ParseException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		simpleDateFormat.setLenient(false);
		return simpleDateFormat.parse(dataString);
	}
}