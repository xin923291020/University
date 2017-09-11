package test1;

public class YellowPeopleFactory implements PeopleFactory
{
	public Man produceMan()
	{
		return new YellowMan();
	}
	public Woman produceWoman()
	{
		return new YellowWoman();
	}
}