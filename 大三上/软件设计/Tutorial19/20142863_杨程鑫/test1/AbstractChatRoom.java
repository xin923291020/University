package test1;

public abstract class AbstractChatRoom
{
	public abstract void Register(Member Member);
	public abstract void SendText(String From,String To,String Message);
	public abstract void SendImage(String From,String To,String Message);
	public abstract void SentEveryMember(String From,String Message);
}