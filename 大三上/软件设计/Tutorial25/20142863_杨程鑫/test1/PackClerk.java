package test1;

public class PackClerk extends Visitor
{
	public void visit(Apple apple)
	{
		System.out.println("打包员把苹果装进袋子");
	}
	
	public void visit(Book book)
	{
		System.out.println("打包员把书装进袋子。");
	}
}