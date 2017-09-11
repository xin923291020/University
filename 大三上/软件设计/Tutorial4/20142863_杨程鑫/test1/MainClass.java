package test1;

public class MainClass
{
	public static void main(String args[]) throws Exception
	{
		PeopleFactory PF = (PeopleFactory)XMLPerson.getBean();
		Man W = PF.produceMan();
		W.Display();
		Woman WM = PF.produceWoman();
		WM.Display();
	}
}