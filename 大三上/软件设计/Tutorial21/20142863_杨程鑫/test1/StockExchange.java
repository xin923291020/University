package test1;

public class StockExchange extends MySubject
{
	public void SharesRose()
	{
		System.out.println("֤ȯ�з���������Ϣ�����й�Ʊ����5%��");
		for(MyObserver obs:Observers)
		{
			obs.Response("��Ʊ����5%");
		}
	}

	public void SharesFell()
	{
		System.out.println("֤ȯ�з���������Ϣ�����й�Ʊ�µ�5%��");
		for(MyObserver obs:Observers)
		{
			obs.Response("��Ʊ�µ�5%");
		}
	}
}