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
		System.out.println("执行运算，结果为：" + Command.Execute(value));
	}
	public void Undo()
	{
		System.out.println("执行撤销，结果为：" + Command.Undo());
	}
	public void Redo()
	{
		System.out.println("执行重做，结果为：" + Command.Redo());
	}
}