package test1;

public class Adapter implements Dog,Cat
{
	Dog dog;
	Cat cat;
	public void wang()
	{
		System.out.print("Ã¨Ä£·Â");
		dog.wang();
	}
	public void catching()
	{
		System.out.print("¹·Ä£·Â");
		cat.catching();
	}
	public Adapter (Dog dog)
	{
		this.dog = dog;
	}
	
	public Adapter(Cat cat)
	{
		this.cat = cat;
	}
}