package tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool
{
	public static String getDate()
	{
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(now);
	}
	
	public static String getSuffixDate()
	{
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
		return "_" + simpleDateFormat.format(date);
	}
	
	public static String getYesterdaySuffixDate()
	{
		Calendar calendar = Calendar.getInstance(); 
		Date date = new Date();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1); 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
		return "_" + simpleDateFormat.format(calendar.getTime());
	}
	
	public static String getSuffixYear()
	{
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		return "_" + simpleDateFormat.format(date);
	}
	
	public static String getSuffixMonth()
	{
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM");
		return "_" + simpleDateFormat.format(date);
	}
	
	public static String getLongTime(String time)
	{
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		return simpleDateFormat.format(now);
	}
}
