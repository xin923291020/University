package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class BlackWoman implements Woman
{
	String colour = "Black";
	private Component frame;
	public BlackWoman()
	{
		JOptionPane.showMessageDialog(frame,"����BlackWoman�ɹ�");
	}
	public void Display()
	{
		JOptionPane.showMessageDialog(frame,"Colour of BlackWoman:" + colour);
	}
}