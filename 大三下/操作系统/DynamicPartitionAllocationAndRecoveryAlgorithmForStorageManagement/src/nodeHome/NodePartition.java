package nodeHome;

public class NodePartition
{
	protected Partition partition;
	protected NodePartition next;

	public NodePartition(Partition partition)
	{
		this.partition = partition;
	}

	public String display()
    {
         return (partition.getAddress() + "\t" + partition.getEndAddress() + "\t" + partition.getSize() + "\n");
    }
	
	public NodePartition getNext()
	{
		return next;
	}

	public void setNext(NodePartition next)
	{
		this.next = next;
	}

	public Partition getPartition()
	{
		return partition;
	}

	public void setPartition(Partition partition)
	{
		this.partition = partition;
	}
}