package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		StockExchange StockExchange = new StockExchange();
		
		Investors InvestorOne = new Investors("����һ��");
		Investors InvestorTwo = new Investors("�������");
		Investors InvestorThree = new Investors("��������");
		
		StockExchange.attach(InvestorOne);
		StockExchange.attach(InvestorTwo);
		StockExchange.attach(InvestorThree);

		StockExchange.SharesRose();
		System.out.println();
		StockExchange.SharesFell();
	}
}