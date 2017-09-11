package test1;

import javax.swing.JOptionPane;

public class MainClass
{
	public static void main(String args[]) throws Exception
	{
		NvwaPerson NP1 = new NvwaPerson();
		String number = "";
		number = JOptionPane.showInputDialog("请输入生产类型:(M:Man,W:Woman,R:Robot)");
		@SuppressWarnings("unused")
		Person person = NP1.producePerson(number);
	}
}