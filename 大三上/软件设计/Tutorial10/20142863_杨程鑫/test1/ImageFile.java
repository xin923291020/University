package test1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ImageFile extends AbstractFile
{
	public boolean flag = false;
	public String name = "Пе";
	public String outString = "Пе";
	public ArrayList<AbstractFile> list = new ArrayList<AbstractFile>();
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public boolean getFlag()
	{
		return this.flag;
	}
	public AbstractFile operation()
	{
		if(list.size() != 0)
		{
			outString = "";
		}
		for(int i = 0;i < list.size();i++)
		{
			outString += i + "." + list.get(i).getName() + "  ";
		}
		String numberString = "";
		int number = 0;
		try
		{
			numberString = JOptionPane.showInputDialog(outString);
			number = Integer.valueOf(numberString);
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		if(this.getChild(number).getFlag())
		{
			return this.getChild(number);
		}
		else if(!this.getChild(number).getFlag())
		{
			return this;
		}
		return this;
	}
	public void add(AbstractFile C)
	{
		list.add(C);
	}
	public void remove(AbstractFile C)
	{
		list.remove(C);
	}
	public AbstractFile getChild(int i)
	{
		return null;
	}
}