package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class WhiteMan implements Man
{
	String colour = "White";
	private Component frame;
	public WhiteMan()
	{
		JOptionPane.showMessageDialog(frame,"����WhiteMan�ɹ�");
	}
	public void Display()
	{
		JOptionPane.showMessageDialog(frame,"Colour of WhiteMan:" + colour);
	}
}