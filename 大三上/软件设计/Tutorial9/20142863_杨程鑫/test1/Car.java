package test1;

public class Car implements Vehicle
{
	public void Drive(Vehicle vehicle,String road)
	{
		System.out.println("小轿车在" + road + "上跑。");
	}
}