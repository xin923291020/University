package test1;

public class WorkersAssembly extends Leader
{
	public WorkersAssembly(String name)
	{
		super(name);
	}
	public void HandleRequest(MoneyRequest request)
	{
		if(true)
		{
			System.out.println(Name + "审批员工" + request.GetName() + "的采购单，金额为：" + request.GetMoney() + "元。");
			return;
		}
	}
}