package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MainClass
{
	public static void main(String args[])
	{
		ComputerBuilder C = (ComputerBuilder)XMLComputer.getBean();
		ComputerFactory CF = new ComputerFactory();
		CF.setComputerBuilder(C);
		Computer computer = CF.construct();
		
		Component frame = null;
		JOptionPane.showMessageDialog(frame,"计算机组成:\n" + computer.getCPU() + "\n" + computer.getRAM() + "\n" + computer.getHD() + "\n" + computer.getMB());
	}
}