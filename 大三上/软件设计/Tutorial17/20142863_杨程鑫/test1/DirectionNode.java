package test1;

public class DirectionNode implements Node
{
	private String direction;
	public DirectionNode(String Direction)
	{
		if(Direction.equals("Up"))
		{
			direction = "����";
		}
		else if(Direction.equals("Down"))
		{
			direction = "����";
		}
		else if(Direction.equals("Left"))
		{
			direction = "����";
		}
		else if(Direction.equals("Right"))
		{
			direction = "����";
		}
		else
		{
			direction = "����ʶ��";
		}
	}
	public String interpret()
	{
		return direction;
	}
}