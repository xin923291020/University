package test1;

public class ActionValue implements Node
{
	private String action;
	public ActionValue(String Action)
	{
		if(Action.equals("Move") || Action.equals("Run"))
		{
			action = "�ƶ�";
		}
		else
		{
			action = "����ʶ��";
		}
	}
	public String interpret()
	{
		return action;
	}
}