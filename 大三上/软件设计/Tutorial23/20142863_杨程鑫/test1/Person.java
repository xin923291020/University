package test1;

public class Person
{
	private TravelStrategy strategy;
	public Person()
	{
	}
	public void setStrategy(TravelStrategy strategy)
	{
		this.strategy = strategy;
	}
	public void travel()
	{
		strategy.travel();
	}
}