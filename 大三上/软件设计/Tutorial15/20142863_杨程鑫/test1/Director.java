package test1;

public class Director extends Leader
{
	public Director(String name)
	{
		super(name);
	}
	public void HandleRequest(MoneyRequest request)
	{
		if(request.GetMoney() <= 10000)
		{
			System.out.println("主任" + Name + "审批员工" + request.GetName() + "的采购单，金额为：" + request.GetMoney() + "元。");
			return;
		}
		if(this.leader != null)
		{
			this.leader.HandleRequest(request);
		}
	}
}