package test1;

public class ComplexPhone extends Decorator
{
	public ComplexPhone(Phone phone)
	{
		super(phone);
		System.out.println("�ұ����JComplexPhone��");
	}
	public void Vibrate()
	{
		System.out.println("�����ˡ�");
	}
	public void Flash()
	{
		System.out.println("����˸�ˡ�");
	}
}