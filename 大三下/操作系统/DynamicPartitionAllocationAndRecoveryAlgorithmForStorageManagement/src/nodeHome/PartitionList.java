package nodeHome;

public class PartitionList
{
	public NodePartition nodePartition;

	public PartitionList(int address,int size)
	{
		this.nodePartition = new NodePartition(new Partition(address,size));
	}

	public PartitionList()
	{
		this.nodePartition = null;
	}

	// 得到所有的节点信息
	public String getAllNodePartitionInfo()
	{
		String result = "编号\t首址\t终址\t大小\n";
		NodePartition nodePartition = this.nodePartition;
		int i = 0;
		while(nodePartition != null)
		{
			result += i + "\t" + nodePartition.display();
			nodePartition = getNextNodePartition(nodePartition);
			i++;
		}
		return result;
	}

	// 最先算法根据大小得到一段存储区
	public Partition getSectionBySizeOfFirst(int size)
	{
		NodePartition current = this.nodePartition;
		while(true)
		{
			if(current.getPartition().getSize() > size)
			{
				Partition resultPartition = new Partition(current.getPartition().getAddress(),size);
				deleteNodePartitionByAddress(current.getPartition().getAddress());
				Partition remainingPartition = new Partition(current.getPartition().getAddress() + size,
						current.getPartition().getSize() - size);
				addNodePartition(remainingPartition,false);
				return resultPartition;
			}
			else if(current.getPartition().getSize() == size)
			{
				Partition resultPartition = current.getPartition();
				deleteNodePartitionByAddress(current.getPartition().getAddress());
				return resultPartition;
			}
			else if(haveNextNodePartition(current))
			{
				current = current.getNext();
			}
			else
			{
				return null;
			}
		}
	}
	
	// 最优算法根据大小得到一段存储区
	public Partition getSectionBySizeOfBest(int size)
	{
		int deviationOfSize = -1;
		Partition resultPartition = null;
		NodePartition current = this.nodePartition;
		while(true)
		{
			if(current.getPartition().getSize() == size)
			{
				resultPartition = current.getPartition();
				deleteNodePartitionByAddress(current.getPartition().getAddress());
				return resultPartition;
			}
			else if(current.getPartition().getSize() - size < deviationOfSize && deviationOfSize == -1)
			{
				deviationOfSize = current.getPartition().getSize() - size;
			}
			else if(current.getPartition().getSize() - size < deviationOfSize && !haveNextNodePartition(current))
			{
				deviationOfSize = current.getPartition().getSize() - size;
				break;
			}
			else if(haveNextNodePartition(current))
			{
				current = current.getNext();
			}
			else
			{
				break;
			}
		}
		resultPartition = new Partition(current.getPartition().getAddress(),size);
		deleteNodePartitionByAddress(current.getPartition().getAddress());
		Partition remainingPartition = new Partition(current.getPartition().getAddress() + size,
				current.getPartition().getSize() - size);
		addNodePartition(remainingPartition,false);
		return resultPartition;
	}

	// 根据地址和大小得到一段存储区
	public Partition getSectionByAddressAndSizeOfFirst(int address,int size)
	{
		NodePartition current = this.nodePartition;
		while(true)
		{
			// 申请和某一个一致时
			if(current.getPartition().getAddress() == address && current.getPartition().getSize() == size)
			{
				Partition resultPartition = new Partition(address,size);
				deleteNodePartitionByAddress(current.getPartition().getAddress());
				return resultPartition;
			}
			// 地址一致，但长度较小时
			else if(current.getPartition().getAddress() == address && current.getPartition().getSize() > size)
			{
				Partition resultPartition = new Partition(address,size);
				deleteNodePartitionByAddress(current.getPartition().getAddress());
				Partition remainingPartition = new Partition(current.getPartition().getAddress() + size,
						current.getPartition().getSize() - size);
				addNodePartition(remainingPartition,false);
				return resultPartition;
			}
			// 地址较大，但从该地址开始长度满足时
			else if(current.getPartition().getAddress() < address && current.getPartition().getEndAddress() - address > size)
			{
				Partition resultPartition = new Partition(address,size);
				deleteNodePartitionByAddress(current.getPartition().getAddress());
				
				Partition remainingPartition = new Partition(current.getPartition().getAddress(),
						address - current.getPartition().getAddress());
				addNodePartition(remainingPartition,false);
				
				remainingPartition = new Partition(address + size,
						current.getPartition().getEndAddress() - address - size + 1);
				addNodePartition(remainingPartition,false);
				return resultPartition;
			}
			//地址较大，但从该改地址开始长度刚好时
			else if(current.getPartition().getAddress() < address && current.getPartition().getEndAddress() - address == size)
			{
				Partition resultPartition = new Partition(address,size);
				deleteNodePartitionByAddress(current.getPartition().getAddress());
				Partition remainingPartition = new Partition(current.getPartition().getAddress(),address);
				addNodePartition(remainingPartition,false);
				return resultPartition;
			}
			else if(haveNextNodePartition(current))
			{
				current = current.getNext();
			}
			else
			{
				return null;
			}
		}
	}

	// 根据地址删除一个节点
	public void deleteNodePartitionByAddress(int address)
	{
		NodePartition previous = this.nodePartition;
		NodePartition current = this.nodePartition;
		while(current.getPartition().getAddress() != address)
		{
			if(current.getNext() == null)
			{
				return;
			}
			previous = current;
			current = current.getNext();
		}
		if(current == this.nodePartition)
		{
			this.nodePartition = this.nodePartition.getNext();
		}
		else
		{
			previous.setNext(current.getNext());
		}
	}

	// 插入一个尾节点或合并一个节点
	public void addNodePartition(Partition partition,boolean isOccupy)
	{
		NodePartition nodePartition = new NodePartition(partition);
		if(isOccupy)
		{
			if(this.nodePartition == null)
			{
				this.nodePartition = nodePartition;
			}
			else
			{
				if(this.nodePartition.getPartition().getAddress() - 1 == partition.getEndAddress())
				{
					int size = this.nodePartition.getPartition().getSize() + partition.getSize();
					deleteNodePartitionByAddress(this.nodePartition.getPartition().getAddress());
					addNodePartition(new Partition(partition.getAddress(),size),true);
					return;
				}
				else if(this.nodePartition.getPartition().getEndAddress() + 1 == partition.getAddress())
				{
					int address = this.nodePartition.getPartition().getAddress();
					int size = this.nodePartition.getPartition().getSize() + partition.getSize();
					deleteNodePartitionByAddress(this.nodePartition.getPartition().getAddress());
					addNodePartition(new Partition(address,size),true);
					return;
				}
				nodePartition = this.nodePartition;
				while(haveNextNodePartition(nodePartition))
				{
					nodePartition = nodePartition.getNext();
					if(nodePartition.getPartition().getAddress() - 1 == partition.getEndAddress())
					{
						int size = nodePartition.getPartition().getSize() + partition.getSize();
						deleteNodePartitionByAddress(nodePartition.getPartition().getAddress());
						addNodePartition(new Partition(partition.getAddress(),size),true);
						return;
					}
					else if(nodePartition.getPartition().getEndAddress() + 1 == partition.getAddress())
					{
						int address = nodePartition.getPartition().getAddress();
						int size = nodePartition.getPartition().getSize() + partition.getSize();
						deleteNodePartitionByAddress(nodePartition.getPartition().getAddress());
						addNodePartition(new Partition(address,size),true);
						return;
					}
				}
				getLastNodePartition().setNext(new NodePartition(partition));
			}
		}
		else
		{
			if(this.nodePartition == null)
			{
				this.nodePartition = nodePartition;
			}
			else
			{
				getLastNodePartition().setNext(nodePartition);
			}
		}
	}

	// 得到最后一个节点
	public NodePartition getLastNodePartition()
	{
		NodePartition nodePartition = this.nodePartition;
		while(haveNextNodePartition(nodePartition))
		{
			nodePartition = getNextNodePartition(nodePartition);
		}
		return nodePartition;
	}

	// 得到下一个节点
	public NodePartition getNextNodePartition(NodePartition nodePartition)
	{
		return nodePartition.getNext();
	}

	// 是否有下一个节点
	public boolean haveNextNodePartition(NodePartition NodePartition)
	{
		if(NodePartition.getNext() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	// 是否还含有节点
	public boolean isHaveNodePartition()
	{
		if(this.nodePartition == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public NodePartition getNodePartition()
	{
		return nodePartition;
	}

	public void setNodePartition(NodePartition nodePartition)
	{
		this.nodePartition = nodePartition;
	}

}