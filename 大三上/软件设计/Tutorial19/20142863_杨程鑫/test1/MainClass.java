package test1;

public class MainClass
{
	public static void main(String args[])
	{
		AbstractChatRoom HappyChat = new ChatGroup();
		Member Member1 = new DiamondMember("张三");
		Member Member2 = new DiamondMember("李四");
		Member Member3 = new CommonMember("王五");
		Member Member4 = new CommonMember("小芳");
		Member Member5 = new CommonMember("小红");
		
		HappyChat.Register(Member1);
		HappyChat.Register(Member2);
		HappyChat.Register(Member3);
		HappyChat.Register(Member4);
		HappyChat.Register(Member5);
		
		Member1.SendEveryMember("你好！");
		/*Member2.SendText("张三","张三，你好！");
		Member1.SendText("李四","今天天气不错，有日！");
		Member2.SendText("张三","一个很大很大的太阳");
		Member2.SendText("张三","太阳");
		Member3.SendText("小芳","还有问题吗？");
		Member3.SendText("小红","还有问题吗？");
		Member4.SendText("王五","没有了，谢谢！");
		Member5.SendText("王五","我也没有了！");
		Member5.SendImage("王五","谢谢");*/
	}
}