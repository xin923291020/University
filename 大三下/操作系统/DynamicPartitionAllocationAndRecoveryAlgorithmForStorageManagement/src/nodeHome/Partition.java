package nodeHome;

public class Partition
{
	private int address;
	private int size;
	
	public Partition(int address,int size)
	{
		super();
		this.address = address;
		this.size = size;
	}
	
	public int getEndAddress()
	{
		return (address + size - 1);
	}
	
	public int getAddress()
	{
		return address;
	}
	public void setAddress(int address)
	{
		this.address = address;
	}
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
}