package test1;

public class CommonMember extends Member
{
	public CommonMember(String Name)
	{
		super(Name);
	}
	
	public void SendText(String To,String Message)
	{
	    System.out.println("��ͨ��Ա������Ϣ��");
	    ChatRoom.SendText(Name,To,Message);  //����
	}
	
	public void SendImage(String To,String Image)
	{
		System.out.println("��ͨ��Ա���ܷ���ͼƬ��");
	}

	public void SendEveryMember(String Message)
	{
		ChatRoom.SentEveryMember(Name,Message);
	}
}