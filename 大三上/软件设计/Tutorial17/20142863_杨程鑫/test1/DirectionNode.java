package test1;

public class DirectionNode implements Node
{
	private String direction;
	public DirectionNode(String Direction)
	{
		if(Direction.equals("Up"))
		{
			direction = "向上";
		}
		else if(Direction.equals("Down"))
		{
			direction = "向下";
		}
		else if(Direction.equals("Left"))
		{
			direction = "向左";
		}
		else if(Direction.equals("Right"))
		{
			direction = "向右";
		}
		else
		{
			direction = "不可识别";
		}
	}
	public String interpret()
	{
		return direction;
	}
}