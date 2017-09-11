package test1;

public class MainFrame
{
	private Memory memory = new Memory();
	private CPU cpu = new CPU();
	private HardDisk harddisk = new HardDisk();
	private OperationSystem operationsystem = new OperationSystem();
	public boolean On()
	{
		try
		{
			memory.check();
			cpu.run();
			harddisk.read();
			operationsystem.load();
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		System.out.println("开机成功。");
		return true;
	}
}