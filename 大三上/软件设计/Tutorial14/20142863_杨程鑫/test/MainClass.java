package test;

public class MainClass
{
	public static void main(String[] args)
	{
		PermissionProxy PP = new PermissionProxy();
		System.out.println("我十七岁的时候。");
		PP.SetAge(17);
		PP.ApplyForAccountNumber();
		System.out.println("我十八岁了。");
		PP.SetAge(18);
		PP.ApplyForAccountNumber();
	}
}