package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class YellowWoman implements Woman
{
	String colour = "Yellow";
	private Component frame;
	public YellowWoman()
	{
		JOptionPane.showMessageDialog(frame,"����YellowWoman�ɹ�");
	}
	public void Display()
	{
		JOptionPane.showMessageDialog(frame,"Colour of YellowWoman:" + colour);
	}
}