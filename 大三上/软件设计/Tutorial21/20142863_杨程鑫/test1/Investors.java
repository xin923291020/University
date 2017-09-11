package test1;

public class Investors implements MyObserver
{
	public String Name = "";
	public Investors(String Name)
	{
		this.Name = Name;
	}
	public void Response(String Message)
	{
		if(Message.equals("股票上涨5%"))
		{
			System.out.println(Name + "又购买了很多股票。");
		}
		else if(Message.equals("股票下跌5%"))
		{
			System.out.println(Name + "哭了，正在排队跳楼。");
		}
	}
}