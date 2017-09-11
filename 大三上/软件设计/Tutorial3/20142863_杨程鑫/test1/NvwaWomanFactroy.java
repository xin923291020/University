package test1;

public class NvwaWomanFactroy implements NvwaFactory
{
	@Override
	public Person producePerson()
	{
		return new Woman();
	}
}
