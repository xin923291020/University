package test1;

public class JarPhone extends Decorator
{
	public JarPhone(Phone phone)
	{
		super(phone);
		System.out.println("我变成了JarPhone。");
	}
	public void Vibrate()
	{
		System.out.println("我振动了。");
	}
}