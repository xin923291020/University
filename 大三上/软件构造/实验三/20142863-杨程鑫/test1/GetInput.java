package test1;

import java.io.IOException;
/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;*/

public class GetInput
{
	public static void main(String[] args) throws IOException
	{
		/*File file = new File("C:\\Users\\asus1\\Desktop\\main.txt");
		InputStreamReader read = new InputStreamReader(new FileInputStream(file));
		@SuppressWarnings("resource")
		BufferedReader BR = new BufferedReader(read);
		String TextLine = BR.readLine();*/
		String TextLine = "a+a*a+a$";
		AnalysisTable AT = new AnalysisTable();
		String Stack = "$A";
		String yishibie = "";
		int i = 0;
		while(true)
		{
			char StackTop = Stack.charAt(Stack.length() - 1);
			System.out.println();
			System.out.println("当前栈顶元素" + StackTop);
			char PresentChar = TextLine.charAt(i);
			Stack = Stack.substring(0,Stack.length() - 1);
			String Result = AT.getResult(StackTop,PresentChar);
			for(int j = Result.length() - 1;j >= 0 ;j--)
			{
				Stack += Result.charAt(j);
			}
			if(Stack.charAt(Stack.length() - 1) == 'ε')
			{
				Stack = Stack.substring(0,Stack.length() - 1);
			}
			if(Stack.charAt(Stack.length() - 1) == PresentChar)
			{
				Stack = Stack.substring(0,Stack.length() - 1);
				yishibie += PresentChar;
				i++;
			}
			System.out.println("已识别" + yishibie);
			System.out.println(Stack);
			if(Stack.equals(""))
			{
				break;
			}
		}
	}
}