package test3;

public class RedMiddlePen extends ColorPen implements MiddlePen
{
	public String size;
	public RedMiddlePen()
	{
		this.setRedPen();
		setMiddlePen();
	}
	@Override
	public void setMiddlePen()
	{
		size = "Middle";
	}
}