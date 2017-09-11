package software;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
@SuppressWarnings("serial")
public class Register extends JFrame
{
	private JPanel contentPane;    //������塣
	private JLabel registerLabel;    //ע���ǩ��
	private JLabel userLabel,PWLabel,PWConfirmLabel;    //�û��������룬�ֻ��ű�ǩ��
	private JLabel noUserWarnLabel,noPWWarnLabel,noPhoneWarnLabel;    //���û��������룬�ֻ��ž����ǩ��
	private JTextField userTextField;
	private JPasswordField PWTextField,PWConfirmTextField;    //�˺ţ����룬�ֻ��������
	private JButton confirmButton,canelButton;    //ȷ��ȡ����ť��

	public Register()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //���ô��ڹرհ�ť��
		setBounds(100,100,490,330);    //���ô��ڵĴ�С��λ�á�
		contentPane = new JPanel();    //��ʼ��������塣
		contentPane.setBorder(new EmptyBorder(5,5,5,5));    //Ϊ����������ñ߿��С��
		setContentPane(contentPane);    //����������塣
		contentPane.setLayout(null);    //�����������Ϊ���Բ��֡�
		
		registerLabel = new JLabel("ע��");    //��ʼ��registerLabelע���ǩ��
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);    //����registerLabelע���ǩΪ���Ĳ��֡�
		registerLabel.setFont(new Font("����", Font.BOLD, 25));   //���������ͺŴ�С��
		registerLabel.setBounds(65,20,335,40);    //����registerLabeע���ǩ��λ�ô�С��
		contentPane.add(registerLabel);    //��registerLabel�û���ǩ����contentPane����С�
		
		userLabel = new JLabel("�û���");    //��ʼ��userLabel�û���ǩ��
		userLabel.setForeground(new Color(0,0,0));    //����userLabel�û���ǩ������ɫ��
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);    //����userLabel�û���ǩΪ���Ĳ��֡�
		userLabel.setBounds(15,70,135,40);    //����userLabel�û���ǩ��λ�ô�С��
		contentPane.add(userLabel);    //��userLabel�û���ǩ����contentPane����С�
		
		PWLabel = new JLabel("����");    //��ʼ��PWLabel�����ǩ��
		PWLabel.setHorizontalAlignment(SwingConstants.CENTER);    //����PWLabel�����ǩΪ���Ĳ��֡�
		PWLabel.setBounds(15,115,135,40);    //����PWLabel�����ǩ��λ�ô�С��
		contentPane.add(PWLabel);    //��PWLabel�������contentPane����С�
		
		PWConfirmLabel = new JLabel("ȷ������");    //��ʼ��PWConfirmLabel����ȷ�ϱ�ǩ��
		PWConfirmLabel.setHorizontalAlignment(SwingConstants.CENTER);    //����PWConfirmLabel����ȷ�ϱ�ǩΪ���Ĳ��֡�
		PWConfirmLabel.setBounds(15,160,135,40);    //����PWConfirmLabel����ȷ�ϱ�ǩ��λ�ô�С��
		contentPane.add(PWConfirmLabel);    //��PWConfirmLabel����ȷ�Ϸ���contentPane����С�
		
		noUserWarnLabel = new JLabel("");    //��ʼ��noUserWarnLabel���û��������ǩ��
		noUserWarnLabel.setForeground(new Color(255,0,0));    //����noUserWarnLabel���û�������������ɫ��
		noUserWarnLabel.setBounds(335,70,120,40);    //����noUserWarnLabel���û��������ǩ��λ�ô�С��
		contentPane.add(noUserWarnLabel);    //��noUserWarnLabel���û����������contentPane����С�
		
		noPWWarnLabel = new JLabel("");    //��ʼ��noPWWarnLabel�����뾯���ǩ��
		noPWWarnLabel.setForeground(new Color(255,0,0));    //����noPWWarnLabel�����뾯��������ɫ��
		noPWWarnLabel.setBounds(335,120,120,40);    //����noPWWarnLabel�����뾯���ǩ��λ�ô�С��
		contentPane.add(noPWWarnLabel);    //��noPWWarnLabel�����뾯�����contentPane����С�
		
		noPhoneWarnLabel = new JLabel("");    //��ʼ��noPhoneWarnLabel���ֻ��ž����ǩ��
		noPhoneWarnLabel.setForeground(new Color(255,0,0));    //����noPhoneWarnLabel���ֻ��ž���������ɫ��
		noPhoneWarnLabel.setBounds(335,160,120,40);    //����noPhoneWarnLabel���ֻ��ž����ǩ��λ�ô�С��
		contentPane.add(noPhoneWarnLabel);    //��noPhoneWarnLabel���ֻ��ž������contentPane����С�
		
		userTextField = new JTextField();    //��ʼ��userTextField�û��������
		userTextField.setBounds(140,75,180,30);    //����userTextField�û���������λ�úʹ�С��
		userTextField.setColumns(10);    //����userTextField�û���������ı��ֶε�������
		
		PWTextField = new JPasswordField();    //��ʼ��PWTextField���������
		PWTextField.setBounds(140,120,180,30);    //����PWTextField����������λ�úʹ�С��
		PWTextField.setColumns(10);    //����PWTextField����������ı��ֶε�������
		contentPane.add(PWTextField);    //��PWTextField���������ŵ�contentPane����С�
		
		PWConfirmTextField = new JPasswordField();    //��ʼ��PWConfirmTextFiel����ȷ�������
		PWConfirmTextField.setBounds(140,165,180,30);    //����PWConfirmTextField����ȷ��������λ�úʹ�С��
		PWConfirmTextField.setColumns(10);    //����PWConfirmTextField����ȷ��������ı��ֶε�������
		contentPane.add(PWConfirmTextField);    //��PWConfirmTextField����ȷ�������ŵ�contentPane����С�
		
		confirmButton = new JButton("ȷ��");    //��ʼ��confirmButtonȷ�ϰ�ť��
		confirmButton.setBounds(110,225,90,25);    //����confirmButtonȷ�ϰ�ť��λ�úʹ�С��
		contentPane.add(confirmButton);    //��uconfirmButtonȷ�ϰ�ť�ŵ�contentPane����С�
		
		canelButton = new JButton("ȡ��");    //��ʼ��canelButtonȡ����ť��
		canelButton.setBounds(250,225,90,25);    //����canelButtonȡ����ť��λ�úʹ�С��
		contentPane.add(canelButton);    //��canelButtonȡ����ť�ŵ�contentPane����С�
		
		userTextField.addFocusListener(new FocusAdapter()    //�û�������򽹵�����¼���
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				LoginDatabaseConnection dc = new LoginDatabaseConnection();    //�������ݿ⡣
				ResultSet rs = dc.executeQuery("select �û��� from register");    //���������û����ݡ�
				if(e.getSource() == userTextField)
				{
					if(!(userTextField.getText().equals("")))
					{
						noUserWarnLabel.setText("");
					}
					if(userTextField.getText().equals(""))
					{
						noUserWarnLabel.setText("�û�������Ϊ�ա�");
					}
					else
					{
						try
						{
							while(rs.next())
							{
								if(rs.getString("�û���").equals(userTextField.getText()))
								{
									noUserWarnLabel.setText("���û����Ѿ�ע���");
								}
							}
						}
						catch (SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					
				}
				dc.connectionClose();
			}
		});

		contentPane.add(userTextField);    //��userTextField�û��������ŵ�contentPane����С�
		PWTextField.addFocusListener(new FocusAdapter()    //��������򽹵�����¼���
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				if(e.getSource() == PWTextField)
				{
					if(String.copyValueOf(PWTextField.getPassword()).equals(""))
					{
						noPWWarnLabel.setText("���������롣");
					}
					else
					{
						noPWWarnLabel.setText("");
					}
				}
			}
		});
		PWConfirmTextField.addFocusListener(new FocusAdapter()    //����ȷ������򽹵�����¼���
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				if(e.getSource() == PWConfirmTextField)
				{
					if(!(String.copyValueOf(PWConfirmTextField.getPassword()).equals(String.copyValueOf(PWTextField.getPassword()))))
					{
						noPhoneWarnLabel.setText("���벻һ�¡�");
					}
					else
					{
						noPhoneWarnLabel.setText("");
					}
				}
			}
		});
		confirmButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(userTextField.getText().equals("") || String.copyValueOf(PWTextField.getPassword()).equals(""))
				{
					JOptionPane.showMessageDialog(null, "�������Ϊ�ա�",
							"������ʾ",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(!(String.copyValueOf(PWConfirmTextField.getPassword()).equals(String.copyValueOf(PWTextField.getPassword()))))
				{
					JOptionPane.showMessageDialog(null, "���벻һ�¡�",
							"������ʾ",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					LoginDatabaseConnection dc = new LoginDatabaseConnection();
					dc.executeUpdate(userTextField.getText(),String.copyValueOf(PWTextField.getPassword()));
					Register.this.dispose();
					dc.connectionClose();
				}
			}
		});
		canelButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource() == canelButton)
				{
					Register.this.dispose();
				}
			}
		});
	}
}