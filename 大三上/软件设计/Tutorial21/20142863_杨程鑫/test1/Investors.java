package test1;

public class Investors implements MyObserver
{
	public String Name = "";
	public Investors(String Name)
	{
		this.Name = Name;
	}
	public void Response(String Message)
	{
		if(Message.equals("��Ʊ����5%"))
		{
			System.out.println(Name + "�ֹ����˺ܶ��Ʊ��");
		}
		else if(Message.equals("��Ʊ�µ�5%"))
		{
			System.out.println(Name + "���ˣ������Ŷ���¥��");
		}
	}
}