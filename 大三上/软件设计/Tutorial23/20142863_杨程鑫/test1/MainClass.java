package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		Person APerson = new Person();
		TravelStrategy strategy = new AirplaneStrategy();
		APerson.setStrategy(strategy);
		APerson.travel();
	}
}