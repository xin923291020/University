package test1;

public class PackClerk extends Visitor
{
	public void visit(Apple apple)
	{
		System.out.println("���Ա��ƻ��װ������");
	}
	
	public void visit(Book book)
	{
		System.out.println("���Ա����װ�����ӡ�");
	}
}