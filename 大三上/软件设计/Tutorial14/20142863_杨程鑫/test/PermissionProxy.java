package test;

public class PermissionProxy implements AbstractPermission
{
	private RealPermission permission = new RealPermission();
	private int Age = -1;
	public boolean JudgeAge()
	{
		if(Age >= 18)
		{
			return true;
		}
		return false;
	}
	public void ApplyForAccountNumber()
	{
		if(JudgeAge())
		{
			permission.ApplyForAccountNumber();
		}
		else
		{
			System.out.println("对不起，不能早恋！");
		}
	}
	public void SetAge(int age)
	{
		Age = age;
	}
}