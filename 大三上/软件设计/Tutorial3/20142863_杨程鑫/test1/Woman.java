package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Woman implements Person
{
	@SuppressWarnings("unused")
	private String sex = null;
	private String birth = "����δ���á�";
	public Woman()
	{
		sex = "Woman";
		Component frame = null;
		JOptionPane.showMessageDialog(frame,"����Woman�ɹ�");
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