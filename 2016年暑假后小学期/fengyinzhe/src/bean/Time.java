package bean;

public class Time
{
	public String GetTime()
	{
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date currentTime = new java.util.Date();
		String time = formatter.format(currentTime);
		
		return time;
	}
}