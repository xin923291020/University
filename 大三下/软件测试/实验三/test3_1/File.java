package test3_1;

public class File
{
	public static void main(String[] args) throws Exception
	{
			FileTest Test = new FileTest (); //建立测试类实例
			 Test.setUp(); //初始化测试环境
			 Test.testAbs(); //测试某个方法
			 Test.tearDown(); //清理资源
	}

	public int abs(int n)
	{
		if(n >= 0)
			return n;
		else
			return (-n);
	}
}