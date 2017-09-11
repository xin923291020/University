package test1;

public class Calculator
{
	private AbstractCommand Command;
	public void SetCommand(AbstractCommand command)
	{
		Command = command;
	}
	public void Compute(int value)
	{
		System.out.println("ִ�����㣬���Ϊ��" + Command.Execute(value));
	}
	public void Undo()
	{
		System.out.println("ִ�г��������Ϊ��" + Command.Undo());
	}
	public void Redo()
	{
		System.out.println("ִ�����������Ϊ��" + Command.Redo());
	}
}