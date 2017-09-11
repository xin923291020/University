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
			System.out.println("���ܾ���" + Name + "����Ա��" + request.GetName() + "�Ĳɹ��������Ϊ��" + request.GetMoney() + "Ԫ��");
			return;
		}
		if(this.leader != null)
		{
			this.leader.HandleRequest(request);
		}
	}
}