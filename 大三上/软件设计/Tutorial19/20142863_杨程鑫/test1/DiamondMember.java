package test1;

public class DiamondMember extends Member
{
	public DiamondMember(String Name)
	{
		super(Name);
	}
	
	public void SendText(String To,String Message)
	{
	    System.out.println("��ʯ��Ա������Ϣ��");
	    ChatRoom.SendText(Name,To,Message);
	}
	
	public void SendImage(String To,String Image)
	{
		System.out.println("��ʯ��Ա����ͼƬ��");
	    ChatRoom.SendImage(Name,To,Image);
	}
	
	public void SendEveryMember(String Message)
	{
		ChatRoom.SentEveryMember(Name,Message);
	}
}