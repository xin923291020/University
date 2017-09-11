package test1;

public class WhitePeopleFactory implements PeopleFactory
{
	public Man produceMan()
	{
		return new WhiteMan();
	}
	public Woman produceWoman()
	{
		return new WhiteWoman();
	}
}