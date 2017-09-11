package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		Calculator C = new Calculator();
		AbstractCommand AC = new ConcreteCommand();
		C.SetCommand(AC);
		
		C.Compute(1);
		C.Compute(2);
		C.Compute(3);
		C.Compute(4);
		C.Undo();
		C.Redo();
		C.Undo();
		C.Compute(5);
		C.Undo();
		C.Undo();
		C.Redo();
	}
}