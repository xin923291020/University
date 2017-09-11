package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		StockExchange StockExchange = new StockExchange();
		
		Investors InvestorOne = new Investors("股民一号");
		Investors InvestorTwo = new Investors("股民二号");
		Investors InvestorThree = new Investors("股民三号");
		
		StockExchange.attach(InvestorOne);
		StockExchange.attach(InvestorTwo);
		StockExchange.attach(InvestorThree);

		StockExchange.SharesRose();
		System.out.println();
		StockExchange.SharesFell();
	}
}