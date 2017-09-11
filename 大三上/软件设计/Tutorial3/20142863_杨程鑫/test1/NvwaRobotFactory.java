package test1;
public class NvwaRobotFactory implements NvwaFactory
{
	@Override
	public Person producePerson()
	{
		return new Robot();
	}
}
