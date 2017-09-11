package test1;

public class StockExchange extends MySubject
{
	public void SharesRose()
	{
		System.out.println("证券市发布最新消息，所有股票上涨5%。");
		for(MyObserver obs:Observers)
		{
			obs.Response("股票上涨5%");
		}
	}

	public void SharesFell()
	{
		System.out.println("证券市发布最新消息，所有股票下跌5%。");
		for(MyObserver obs:Observers)
		{
			obs.Response("股票下跌5%");
		}
	}
}