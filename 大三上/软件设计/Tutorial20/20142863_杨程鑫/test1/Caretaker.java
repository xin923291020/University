package test1;

import java.util.ArrayList;

public class Caretaker
{
	private ArrayList<Memento> MementoHistory = new ArrayList<Memento>();
	int place = -1;
	public Memento GetMemento()
	{
		if(place == -1)
		{
			System.out.println("δ���汸��¼������ִ�г�����");
			return null;
		}
		System.out.println("����¼�ص�״̬" + place);
		place--;
		Memento PreviousMemento = MementoHistory.get(place);
		return PreviousMemento;
	}
	public void SetMemento(Memento Memento)
	{
		for(int i = place + 1;i < MementoHistory.size();i++)
		{
			MementoHistory.remove(i);
		}
		MementoHistory.add(Memento);
		place++;
	}
}