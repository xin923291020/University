package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		Vehicle vehicle = (Vehicle)XMLCarAndRoad.getBean(0);
		Road road = (Road)XMLCarAndRoad.getBean(1);
		road.setCar(vehicle);
		road.Run();
	}
}