package software;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UpdateStudent extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1305665468379501574L;
	// 定义swing组件
	JPanel top,bottom,left;
	JLabel 学号,班级,姓名,博客;
	JTextField ID,Class,name,address;
	JButton save,cancel;

	StudentModel sm = null;
	String values[];

	// 构造函数
	public UpdateStudent(JFrame owner, String title, boolean modal, StudentModel sm)
	{
		super(owner, title, modal);
		// 创建组件
		top = new JPanel(new GridLayout(4,1));
		left = new JPanel(new GridLayout(4,1));
		学号 = new JLabel("学号", JLabel.CENTER);
		班级 = new JLabel("班级", JLabel.CENTER);
		姓名 = new JLabel("姓名", JLabel.CENTER);
		博客 = new JLabel("博客", JLabel.CENTER);
;
		ID = new JTextField(25);
		ID.setText(sm.getValueAt(0,0).toString());
		ID.setEditable(false);

		Class = new JTextField(25);
		Class.setText(sm.getValueAt(0,1).toString());

		name = new JTextField(25);
		name.setText(sm.getValueAt(0,2).toString());
		
		address = new JTextField(25);
		address.setText(sm.getValueAt(0,3).toString());

		top.add(学号);
		top.add(班级);
		top.add(姓名);
		top.add(博客);
		
		left.add(ID);
		left.add(Class);
		left.add(name);
		left.add(address);

		bottom = new JPanel();
		save = new JButton("保存");
		save.addActionListener(this);

		cancel = new JButton("取消");
		cancel.addActionListener(this);
		bottom.add(save);
		bottom.add(cancel);

		this.add(top, BorderLayout.CENTER);
		this.add(left, BorderLayout.EAST);
		this.add(bottom, BorderLayout.SOUTH);

		// 设置窗体属性
		this.setSize(320,200);
		this.setLocation(450,300);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == save)
		{
			String message = "";
			boolean flag = false;
			if(!Match.isClass(Class.getText().trim()))
			{
				message += "班级 ";
				flag = true;
			}
			if(!Match.isName(name.getText().trim()))
			{
				message += "姓名 ";
				flag = true;
			}
			if(flag)
			{
				message += "类型不正确！";
				Component frame = null;
				JOptionPane.showMessageDialog(frame,message);
			}
			else
			{
				String values[] = {Class.getText().trim(),name.getText().trim(),
						address.getText().trim(),ID.getText().trim()};
				String sql = "update student set Class = ?,Name = ?,URL = ? where Sno = ?";
				String sql1 = "update studentgrade set Class = '" + Class.getText().trim() + "',Name = '" + name.getText().trim() + "' where Sno = '" + ID.getText().trim() + "'";
				GradeDatabaseConnection sh1=new GradeDatabaseConnection();
				sh1.executeUpdate(sql1);
				sm = new StudentModel();
				sm.deleteStudent(sql, values);
				this.dispose();
			}
		}
		if(e.getSource() == cancel)
		{
			this.dispose();
		}
	}
}
