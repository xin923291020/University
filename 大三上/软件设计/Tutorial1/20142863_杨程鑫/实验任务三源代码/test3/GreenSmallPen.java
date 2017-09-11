package test3;

public class GreenSmallPen extends ColorPen implements SmallPen
{
	public String size;
	public GreenSmallPen()
	{
		this.setGreenPen();
		setSmallPen();
	}
	@Override
	public void setSmallPen()
	{
		size = "Small";
	}
}