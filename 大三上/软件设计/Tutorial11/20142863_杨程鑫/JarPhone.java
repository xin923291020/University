package test1;

public class JarPhone extends Decorator
{
	public JarPhone(Phone phone)
	{
		super(phone);
		System.out.println("�ұ����JarPhone��");
	}
	public void Vibrate()
	{
		System.out.println("�����ˡ�");
	}
}