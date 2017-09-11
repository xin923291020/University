package test1;

public abstract class ComputerBuilder
{
	protected Computer computer = new Computer();
	public abstract void buildCPU();
	public abstract void buildRAM();
	public abstract void buildHD();
	public abstract void buildMB();
	public Computer getComputer()
	{
		return computer;
	}
}