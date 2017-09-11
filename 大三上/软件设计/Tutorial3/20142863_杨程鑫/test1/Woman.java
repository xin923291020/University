package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Woman implements Person
{
	@SuppressWarnings("unused")
	private String sex = null;
	private String birth = "生日未设置。";
	public Woman()
	{
		sex = "Woman";
		Component frame = null;
		JOptionPane.showMessageDialog(frame,"生产Woman成功");
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