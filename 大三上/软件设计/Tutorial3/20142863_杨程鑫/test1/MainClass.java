package test1;

public class MainClass
{
	@SuppressWarnings("unused")
	public static void main(String args[]) throws Exception
	{
		NvwaFactory PF = (NvwaFactory)XMLPerson.getBean();
		Person P = PF.producePerson();
	}
}