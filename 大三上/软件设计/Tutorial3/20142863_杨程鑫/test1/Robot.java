package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Robot implements Person
{
	@SuppressWarnings("unused")
	private String sex = null;
	private String birth = "��������δ���á�";
	public Robot()
	{
		sex = "Robot";
		Component frame = null;
		JOptionPane.showMessageDialog(frame,"����Robot�ɹ�");
	}
	@Override
	public void setBirth(String birth)
	{
		this.birth = birth;
	}
	@Override
	public String getBirth()
	{
		return birth;
	}
}