package test3;

public class RedBigPen extends ColorPen implements BigPen
{
	public String size;
	public RedBigPen()
	{
		this.setRedPen();
		setBigPen();
	}
	@Override
	public void setBigPen()
	{
		size = "Big";
	}
}