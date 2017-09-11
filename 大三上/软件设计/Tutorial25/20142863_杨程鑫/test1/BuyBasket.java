package test1;

import java.util.*;

public class BuyBasket
{
	private ArrayList<Product> list = new ArrayList<Product>();
	
	public void accept(Visitor visitor)
	{
		Iterator<Product> i = list.iterator();
		
		while(i.hasNext())
		{
			((Product)i.next()).accept(visitor);	
		}
	}
	
	public void accept(PackClerk packClerk)
	{
		Iterator<Product> i = list.iterator();
		
		while(i.hasNext())
		{
			((Product)i.next()).accept(packClerk);	
		}
	}
	
	public void addProduct(Product product)
	{
		list.add(product);
	}
	
	public void removeProduct(Product product)
	{
		list.remove(product);
	}
}