package test3;

public class GreenBigPen extends ColorPen implements BigPen
{
	public String size;
	public GreenBigPen()
	{
		this.setGreenPen();
		setBigPen();
	}
	@Override
	public void setBigPen()
	{
		size = "Big";
	}
}