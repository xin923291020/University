package test1;

public abstract class Leader
{
	protected String Name = "";
	protected Leader leader;
	public Leader(String name)
	{
		Name = name;
	}
	public void SetLeader(Leader leader)
	{
		this.leader = leader;
	}
	public abstract void HandleRequest(MoneyRequest request);
}