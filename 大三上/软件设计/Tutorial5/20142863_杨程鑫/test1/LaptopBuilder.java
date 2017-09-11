package test1;

public class LaptopBuilder extends ComputerBuilder
{
	public void buildCPU()
	{
		computer.setCPU("一个笔记本CPU");
	}
	public void buildRAM()
	{
		computer.setRAM("一个笔记本RAM");
	}
	public void buildHD()
	{
		computer.setHD("一个笔记本HD");
	}
	public void buildMB()
	{
		computer.setMB("一个笔记本MB");
	}
}