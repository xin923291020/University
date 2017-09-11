package test1;

public class MoneyRequest
{
	private String Name = "";
	private int Money = 0;
	public MoneyRequest(String name,int money)
	{
		Name = name;
		Money = money;
	}
	public void SetName(String name)
	{
		Name = name;
	}
	public void SetMoney(int money)
	{
		Money = money;
	}
	public String GetName()
	{
		return(Name);
	}
	public int GetMoney()
	{
		return(Money);
	}
}