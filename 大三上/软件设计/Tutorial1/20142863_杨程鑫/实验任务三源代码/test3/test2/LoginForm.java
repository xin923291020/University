package test2;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LoginForm extends JFrame
{
	JPanel panel;
	JLabel nameLabel,accountLabel,passwordLabel;
	JButton landButton,cancelButton;
	private JTextField textField;
	private JPasswordField passwordField;
	public LoginForm()
	{
		getContentPane().setLayout(null);
		
		nameLabel = new JLabel("��½����");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("����", Font.BOLD, 36));
		nameLabel.setBounds(55, 48, 309, 51);
		getContentPane().add(nameLabel);
		
		panel = new JPanel();
		panel.setBounds(53, 112, 322, 180);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		accountLabel = new JLabel("\u7528\u6237\u540D");
		accountLabel.setFont(new Font("����", Font.PLAIN, 23));
		accountLabel.setBounds(14, 13, 72, 32);
		panel.add(accountLabel);
		
		passwordLabel = new JLabel("\u5BC6\u7801");
		passwordLabel.setFont(new Font("����", Font.PLAIN, 23));
		passwordLabel.setBounds(14, 63, 72, 32);
		panel.add(passwordLabel);
		
		textField = new JTextField();
		textField.setToolTipText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		textField.setBounds(100, 13, 188, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 63, 188, 32);
		panel.add(passwordField);
		
		landButton = new JButton("\u767B\u5F55");
		landButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				validate(e);
			}
		});
		landButton.setBounds(14, 122, 113, 27);
		panel.add(landButton);
		
		cancelButton = new JButton("ȡ��");
		cancelButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if(arg0.getSource() == cancelButton) 
				{
					dispose();
				} 
			}
		});
		cancelButton.setBounds(158, 122, 113, 27);
		panel.add(cancelButton);
	}
	public void validate(MouseEvent e)
	{
		if(textField.getText().equals("") || String.copyValueOf(passwordField.getPassword()).equals(""))
		{
			if(e.getSource() == landButton)
			{
				Object option[] = {"ȷ��","ȡ��"};
				JOptionPane.showOptionDialog(null, "��������û���������Ϊ�գ��������û���������", "�������", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, option, option[0]);
			}
		}
        else
        {
        	String username = textField.getText();
        	char[] pw = passwordField.getPassword();
        	String password = String.copyValueOf(pw);
        	UserDAO dc = new UserDAO();
        	boolean bool = dc.findUser(username,password);
        	if(e.getSource() == landButton)
        	{
        		if(bool)
        		{
        			JOptionPane.showMessageDialog(null, "��¼�ɹ�", "��¼��ʾ", JOptionPane.INFORMATION_MESSAGE);
        		}
        		else
        		{
        			JOptionPane.showMessageDialog(null, "�û������������", "��¼������ʾ", JOptionPane.ERROR_MESSAGE);
        		}  	
        		dc.connectionClose();
        	}
        }
	}
}
