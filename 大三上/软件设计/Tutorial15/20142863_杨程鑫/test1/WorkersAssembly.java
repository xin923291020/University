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
			System.out.println(Name + "����Ա��" + request.GetName() + "�Ĳɹ��������Ϊ��" + request.GetMoney() + "Ԫ��");
			return;
		}
	}
}