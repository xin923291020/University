package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class BlackMan implements Man
{
	String colour = "Black";
	private Component frame;
	public BlackMan()
	{
		JOptionPane.showMessageDialog(frame,"����BlackMan�ɹ�");
	}
	public void Display()
	{
		JOptionPane.showMessageDialog(frame,"Colour of BlackMan:" + colour);
	}
}