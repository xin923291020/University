package software;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddStudent extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 429875240737530874L;
	JPanel top,bottom,left;
	JLabel ѧ��,�༶,����,����;
	JTextField ID,Class,name,adr;
	JButton save,cancel;
	StudentModel sm = null;

	public AddStudent(JFrame owner,String title,boolean modal)    // ���캯��
	{ 
		super(owner,title,modal);
		
		// �������
		ѧ�� = new JLabel("ѧ��",JLabel.CENTER);
		�༶ = new JLabel("�༶",JLabel.CENTER);
		���� = new JLabel("����",JLabel.CENTER);
		���� = new JLabel("����",JLabel.CENTER);
		top = new JPanel(new GridLayout(4,1));
		top.add(ѧ��);
		top.add(�༶);
		top.add(����);
		top.add(����);
		
		ID = new JTextField(25);
		Class = new JTextField(25);
		name = new JTextField(25);
		adr = new JTextField(25);
		left = new JPanel(new GridLayout(4,1));
		left.add(ID);
		left.add(Class);
		left.add(name);
		left.add(adr);

		bottom = new JPanel();
		save = new JButton("����");
		cancel = new JButton("ȡ��");
		save.addActionListener(this);
		cancel.addActionListener(this);
		bottom.add(save);
		bottom.add(cancel);

		this.add(top,BorderLayout.CENTER);
		this.add(left,BorderLayout.EAST);
		this.add(bottom,BorderLayout.SOUTH);

		// ���ô�������
		this.setSize(320,200);
		this.setLocation(450,300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == save)
		{
			String message = "";
			boolean flag = false;
			if(!Match.isSno(ID.getText().trim()))
			{
				message += "ѧ�� ";
				flag = true;
			}
			if(!Match.isClass(Class.getText().trim()))
			{
				message += "�༶ ";
				flag = true;
			}
			if(!Match.isName(name.getText().trim()))
			{
				message += "���� ";
				flag = true;
			}
			if(flag)
			{
				message += "���Ͳ���ȷ��";
				Component frame = null;
				JOptionPane.showMessageDialog(frame,message);
			}
			else
			{
				String values[] = {ID.getText().trim(),Class.getText().trim(),name.getText().trim(),adr.getText().trim()};
				String sql = "insert into student values(?,?,?,?)";
				String sql1 = "insert into studentgrade(Sno,Class,Name) values('" + ID.getText().trim() + "','" + Class.getText().trim() + "','" + name.getText().trim() + "')";
				GradeDatabaseConnection sh1=new GradeDatabaseConnection();
				sh1.executeUpdate(sql1);
				sm = new StudentModel();
				sm.deleteStudent(sql,values);
				this.dispose();
			}
		}
		if(e.getSource()==cancel)
		{
			this.dispose();
		}
	}

}