package test1;

public class ActionValue implements Node
{
	private String action;
	public ActionValue(String Action)
	{
		if(Action.equals("Move") || Action.equals("Run"))
		{
			action = "移动";
		}
		else
		{
			action = "不可识别";
		}
	}
	public String interpret()
	{
		return action;
	}
}