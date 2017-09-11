package test3;

public class RedSmallPen extends ColorPen implements SmallPen
{
	public String size;
	public RedSmallPen()
	{
		this.setRedPen();
		setSmallPen();
	}
	@Override
	public void setSmallPen()
	{
		size = "Small";
	}
}