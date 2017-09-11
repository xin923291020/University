package test1;

import java.util.ArrayList;

public class ConcreteCommand extends AbstractCommand
{
	private Adder adder = new Adder();
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private int place = -1;
	public int Execute(int value)
	{
		for(int i = place + 1;i < list.size();i++)
		{
			list.remove(i);
		}
		list.add(value);
		place++;
		return adder.add(value);
	}
	public int Undo()
	{
		int result = adder.add(-list.get(place));
		place--;
		return result;
	}
	public int Redo()
	{
		place++;
		int reulst = adder.add(list.get(place));
		return reulst;
	}
}