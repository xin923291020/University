package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class YellowMan implements Man
{
	String colour = "Yellow";
	private Component frame;
	public YellowMan()
	{
		JOptionPane.showMessageDialog(frame,"����YellowMan�ɹ�");
	}
	public void Display()
	{
		JOptionPane.showMessageDialog(frame,"Colour of YellowMan:" + colour);
	}
}