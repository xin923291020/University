package test1;

public class CommonMember extends Member
{
	public CommonMember(String Name)
	{
		super(Name);
	}
	
	public void SendText(String To,String Message)
	{
	    System.out.println("普通会员发送信息：");
	    ChatRoom.SendText(Name,To,Message);  //发送
	}
	
	public void SendImage(String To,String Image)
	{
		System.out.println("普通会员不能发送图片！");
	}

	public void SendEveryMember(String Message)
	{
		ChatRoom.SentEveryMember(Name,Message);
	}
}