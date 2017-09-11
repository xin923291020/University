package test1;

public class Bus implements Vehicle
{
	public void Drive(Vehicle vehicle,String road)
	{
		System.out.println("公共汽车在" + road + "上跑。");
	}
}