package test1;

public class NvwaManFactory implements NvwaFactory
{
	@Override
	public Person producePerson()
	{
		return new Man();
	}
}
