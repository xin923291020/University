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
			System.out.println("����" + Name + "����Ա��" + request.GetName() + "�Ĳɹ��������Ϊ��" + request.GetMoney() + "Ԫ��");
			return;
		}
		if(this.leader != null)
		{
			this.leader.HandleRequest(request);
		}
	}
}