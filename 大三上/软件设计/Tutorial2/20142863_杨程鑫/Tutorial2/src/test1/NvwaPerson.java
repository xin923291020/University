package test1;

public class NvwaPerson
{
	public Person producePerson(String parameter) throws Exception
	{
		if(parameter.equals("M"))
		{
			return new Man();
		}
		else if(parameter.equals("W"))
		{
			return new Woman();
		}
		else if(parameter.equals("R"))
		{
			return new Robot();
		}
		else
		{
			throw new Exception("Sorry,accept only input M,W,R");
		}
	}
}