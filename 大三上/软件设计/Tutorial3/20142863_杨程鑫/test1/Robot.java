package test1;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Robot implements Person
{
	@SuppressWarnings("unused")
	private String sex = null;
	private String birth = "生产日期未设置。";
	public Robot()
	{
		sex = "Robot";
		Component frame = null;
		JOptionPane.showMessageDialog(frame,"生产Robot成功");
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