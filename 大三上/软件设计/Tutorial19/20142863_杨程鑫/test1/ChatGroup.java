package test1;

import java.util.*;

public class ChatGroup extends AbstractChatRoom
{
	private Hashtable<String,Member> Members = new Hashtable<String,Member>();
	
	public void Register(Member Member)
	{
		if(!Members.contains(Member))
		{
			Members.put(Member.GetName(),Member);
			Member.SetChatRoom(this);
		}
	}
	
   public void SendText(String From,String To,String Message)
   {
   	  Member Member = (Member)Members.get(To);
   	  String newMessage = Message;
   	  newMessage = Message.replaceAll("ÈÕ","*");
	  Member.ReceiveText(From,newMessage);
   }
   
   public void SendImage(String From,String To,String Image)
   {
   	  Member Member = (Member)Members.get(To);
   	  if(Image.length() > 5)
   	  {
   	  	  System.out.println("Í¼Æ¬Ì«´ó£¬·¢ËÍÊ§°Ü£¡");
   	  }
   	  else
   	  {
   	  	  Member.ReceiveImage(From,Image);
   	  }
   }
   
   public void SentEveryMember(String From,String Message)
   {
	   Enumeration<Member> Enum = Members.elements();
	   while(Enum.hasMoreElements())
	   {
		   Member Member = Enum.nextElement();
		   Member.ReceiveText(From,Message);
	   }
   }
}