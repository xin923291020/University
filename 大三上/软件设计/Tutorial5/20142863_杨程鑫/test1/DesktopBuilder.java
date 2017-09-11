package test1;

public class DesktopBuilder extends ComputerBuilder
{
	public void buildCPU()
	{
		computer.setCPU("一个台式机CPU");
	}
	public void buildRAM()
	{
		computer.setRAM("一个台式机RAM");
	}
	public void buildHD()
	{
		computer.setHD("一个台式机HD");
	}
	public void buildMB()
	{
		computer.setMB("一个台式机MB");
	}
}