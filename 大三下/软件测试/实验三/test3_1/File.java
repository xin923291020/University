package test3_1;

public class File
{
	public static void main(String[] args) throws Exception
	{
			FileTest Test = new FileTest (); //����������ʵ��
			 Test.setUp(); //��ʼ�����Ի���
			 Test.testAbs(); //����ĳ������
			 Test.tearDown(); //������Դ
	}

	public int abs(int n)
	{
		if(n >= 0)
			return n;
		else
			return (-n);
	}
}