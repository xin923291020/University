package test1;

public class ComplexPhone extends Decorator
{
	public ComplexPhone(Phone phone)
	{
		super(phone);
		System.out.println("我变成了JComplexPhone。");
	}
	public void Vibrate()
	{
		System.out.println("我振动了。");
	}
	public void Flash()
	{
		System.out.println("我闪烁了。");
	}
}