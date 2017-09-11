package test3;

public class GreenMiddlePen extends ColorPen implements MiddlePen
{
	public String size;
	public GreenMiddlePen()
	{
		this.setGreenPen();
		setMiddlePen();
	}
	@Override
	public void setMiddlePen()
	{
		size = "Middle";
	}
}