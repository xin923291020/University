package test1;

public class ComputerFactory
{
	private ComputerBuilder CB;
	public void setComputerBuilder(ComputerBuilder cb)
	{
		CB = cb;
	}
	public Computer construct()
	{
		CB.buildCPU();
		CB.buildRAM();
		CB.buildHD();
		CB.buildMB();
		return CB.getComputer();
	}
}