package test1;

public abstract class AbstractCommand
{
	public abstract int Execute(int value);
	public abstract int Undo();
	public abstract int Redo();
}