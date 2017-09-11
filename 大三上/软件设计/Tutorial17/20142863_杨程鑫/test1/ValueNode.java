package test1;

public class ValueNode implements Node
{
	private int value;
	public ValueNode(int value)
	{
		this.value = value;
	}
	public String interpret()
	{
		return value + "¸öµ¥Î»";
	}
}