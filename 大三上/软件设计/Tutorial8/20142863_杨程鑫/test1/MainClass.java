package test1;

public class MainClass
{
	public static void main(String[] args) 
	{
		Adapter cat =  new Adapter(new ConcreteDog());
		cat.wang();
		Adapter dog =  new Adapter(new ConcreteCat());
		dog.catching();
	}
}