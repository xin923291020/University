package test1;

import javax.swing.JOptionPane;

public class MainClass
{
	public static void main(String args[]) throws Exception
	{
		NvwaPerson NP1 = new NvwaPerson();
		String number = "";
		number = JOptionPane.showInputDialog("��������������:(M:Man,W:Woman,R:Robot)");
		@SuppressWarnings("unused")
		Person person = NP1.producePerson(number);
	}
}