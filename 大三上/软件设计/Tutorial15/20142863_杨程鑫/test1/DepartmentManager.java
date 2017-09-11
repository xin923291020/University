package test1;

public class DepartmentManager extends Leader
{
	public DepartmentManager(String name)
	{
		super(name);
	}
	public void HandleRequest(MoneyRequest request)
	{
		if(request.GetMoney() <= 50000)
		{
			System.out.println("���ž���" + Name + "����Ա��" + request.GetName() + "�Ĳɹ��������Ϊ��" + request.GetMoney() + "Ԫ��");
			return;
		}
		if(this.leader != null)
		{
			this.leader.HandleRequest(request);
		}
	}
}