package test1;

public class Decorator implements Phone
{
	public Phone phone;
	public Decorator(Phone phone)
	{
		this.phone = phone;
	}
	public void Sound()
	{
		System.out.println("我发出了声音。");
	}
}