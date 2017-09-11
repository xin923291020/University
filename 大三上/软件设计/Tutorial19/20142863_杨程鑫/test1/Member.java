package test1;

public abstract class Member
{
	protected AbstractChatRoom ChatRoom;
	protected String Name;
	
	public Member(String Name)
	{
		this.Name = Name;
	}
	
	public String GetName()
	{
		return Name;
	}
	
	public void SetName(String Name)
	{
		this.Name = Name;
	}
	
	public AbstractChatRoom GetChatroom()
	{
		return ChatRoom;
	}
	
    public void SetChatRoom(AbstractChatRoom ChatRoom)
    {
    	this.ChatRoom = ChatRoom;
    }
	
	public abstract void SendText(String To,String Message);
	public abstract void SendImage(String To,String Image);
	public abstract void SendEveryMember(String Message);

    public void ReceiveText(String From,String Message)
    {
    	System.out.println(From + "发送文本给" + this.Name + "，内容为：" + Message);
    }
    
    public void ReceiveImage(String From,String Image)
    {
    	System.out.println(From + "发送图片给" + this.Name + "，内容为：" + Image);
    }
}