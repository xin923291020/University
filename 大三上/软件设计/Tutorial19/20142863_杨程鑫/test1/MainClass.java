package test1;

public class MainClass
{
	public static void main(String args[])
	{
		AbstractChatRoom HappyChat = new ChatGroup();
		Member Member1 = new DiamondMember("����");
		Member Member2 = new DiamondMember("����");
		Member Member3 = new CommonMember("����");
		Member Member4 = new CommonMember("С��");
		Member Member5 = new CommonMember("С��");
		
		HappyChat.Register(Member1);
		HappyChat.Register(Member2);
		HappyChat.Register(Member3);
		HappyChat.Register(Member4);
		HappyChat.Register(Member5);
		
		Member1.SendEveryMember("��ã�");
		/*Member2.SendText("����","��������ã�");
		Member1.SendText("����","���������������գ�");
		Member2.SendText("����","һ���ܴ�ܴ��̫��");
		Member2.SendText("����","̫��");
		Member3.SendText("С��","����������");
		Member3.SendText("С��","����������");
		Member4.SendText("����","û���ˣ�лл��");
		Member5.SendText("����","��Ҳû���ˣ�");
		Member5.SendImage("����","лл");*/
	}
}