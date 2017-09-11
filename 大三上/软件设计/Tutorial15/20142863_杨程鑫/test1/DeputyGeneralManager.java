package test1;

public class DeputyGeneralManager extends Leader
{
	public DeputyGeneralManager(String name)
	{
		super(name);
	}
	public void HandleRequest(MoneyRequest request)
	{
		if(request.GetMoney() <= 100000)
		{
			System.out.println("副总经理" + Name + "审批员工" + request.GetName() + "的采购单，金额为：" + request.GetMoney() + "元。");
			return;
		}
		if(this.leader != null)
		{
			this.leader.HandleRequest(request);
		}
	}
}