package test;

public class MainClass
{
	public static void main(String[] args)
	{
		PermissionProxy PP = new PermissionProxy();
		System.out.println("��ʮ�����ʱ��");
		PP.SetAge(17);
		PP.ApplyForAccountNumber();
		System.out.println("��ʮ�����ˡ�");
		PP.SetAge(18);
		PP.ApplyForAccountNumber();
	}
}