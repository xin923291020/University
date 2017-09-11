package test1;

import java.util.*;

public abstract class MySubject
{
	protected ArrayList<MyObserver> Observers = new ArrayList<MyObserver>();
	
	public void attach(MyObserver Observer)
	{
		Observers.add(Observer);
	} 
	
	public void detach(MyObserver Observer)
	{
		Observers.remove(Observer);
	}
	
	public abstract void SharesRose();
	public abstract void SharesFell();
}