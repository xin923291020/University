package test1;

public class MainClass
{
	public static void main(String a[])
	{
		Product b1 = new Book();
		Product b2 = new Book();
		Product a1 = new Apple();
		
        BuyBasket basket = new BuyBasket();
        basket.addProduct(b1);
        basket.addProduct(b2);
        basket.addProduct(a1);

		Visitor visitor = new Customer();
        visitor.setName("张三");
        
        Visitor packClerk = new PackClerk();
        packClerk.setName("打包员");
        	
        basket.accept(visitor);
        basket.accept(packClerk);
	}
}