package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class WhiteWoman implements Woman
{
	String colour = "White";
	private Component frame;
	public WhiteWoman()
	{
		JOptionPane.showMessageDialog(frame,"生产WhiteWoman成功");
	}
	public void Display()
	{
		JOptionPane.showMessageDialog(frame,"Colour of WhiteWoman:" + colour);
	}
}