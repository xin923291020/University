package test1;

public class BicycleStrategy extends TravelStrategy
{
	public BicycleStrategy(){}
	public void travel()
	{
		System.out.println("您选择了自行车出行。");
	}
}