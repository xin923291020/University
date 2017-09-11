package test1;

public abstract class Road
{
	protected Vehicle vehicle;
	public void setCar(Vehicle vehicle)
	{
		this.vehicle = vehicle;
	}
	public abstract void Run();
}