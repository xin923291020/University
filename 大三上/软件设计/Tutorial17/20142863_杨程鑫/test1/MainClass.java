package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		String Expression = "Down Run 10 And Left Move 20";
		String FeedBack = "";
		String[] E = Expression.split(" ");
		for(int i = 0;i < E.length;i++)
		{
			if(E[i].equals("Up") || E[i].equals("Down") || E[i].equals("Left") || E[i].equals("Right"))
			{
				DirectionNode DN = new DirectionNode(E[i]);
				FeedBack += DN.interpret();
			}
			else if(E[i].equals("Move") || E[i].equals("Run"))
			{
				ActionValue AV = new ActionValue(E[i]);
				FeedBack += AV.interpret();
			}
			else if(IsValue(E[i]))
			{
				ValueNode VN = new ValueNode(Integer.valueOf(E[i]));
				FeedBack += VN.interpret();
			}
			else if(E[i].equals("And"))
			{
				FeedBack += "ты";
			}
		}
		System.out.println(FeedBack);
	}
	public static boolean IsValue(String Number)
	{
		try
		{
			Integer.valueOf(Number);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}