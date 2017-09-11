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
	// ����swing���
	JPanel top,bottom,left;
	JLabel ѧ��,�༶,����,����;
	JTextField ID,Class,name,address;
	JButton save,cancel;

	StudentModel sm = null;
	String values[];

	// ���캯��
	public UpdateStudent(JFrame owner, String title, boolean modal, StudentModel sm)
	{
		super(owner, title, modal);
		// �������
		top = new JPanel(new GridLayout(4,1));
		left = new JPanel(new GridLayout(4,1));
		ѧ�� = new JLabel("ѧ��", JLabel.CENTER);
		�༶ = new JLabel("�༶", JLabel.CENTER);
		���� = new JLabel("����", JLabel.CENTER);
		���� = new JLabel("����", JLabel.CENTER);
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

		top.add(ѧ��);
		top.add(�༶);
		top.add(����);
		top.add(����);
		
		left.add(ID);
		left.add(Class);
		left.add(name);
		left.add(address);

		bottom = new JPanel();
		save = new JButton("����");
		save.addActionListener(this);

		cancel = new JButton("ȡ��");
		cancel.addActionListener(this);
		bottom.add(save);
		bottom.add(cancel);

		this.add(top, BorderLayout.CENTER);
		this.add(left, BorderLayout.EAST);
		this.add(bottom, BorderLayout.SOUTH);

		// ���ô�������
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
