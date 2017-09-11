package test1;

public class BlackPeopleFactory implements PeopleFactory
{
	public Man produceMan()
	{
		return new BlackMan();
	}
	public Woman produceWoman()
	{
		return new BlackWoman();
	}
}