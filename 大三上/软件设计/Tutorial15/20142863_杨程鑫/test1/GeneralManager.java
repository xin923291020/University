package test1;

public class GeneralManager extends Leader
{
	public GeneralManager(String name)
	{
		super(name);
	}
	public void HandleRequest(MoneyRequest request)
	{
		if(request.GetMoney() <= 200000)
		{
			System.out.println("总经理" + Name + "审批员工" + request.GetName() + "的采购单，金额为：" + request.GetMoney() + "元。");
			return;
		}
		if(this.leader != null)
		{
			this.leader.HandleRequest(request);
		}
	}
}