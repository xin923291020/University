package software;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.*;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.BusinessBlueSteelSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

import java.sql.*;
import java.util.Scanner;

public class Login
{
	private JFrame frame;    //���ڡ�
	private JPanel panel;    //����塣
	private JLabel titleLabel,userLabel,PWLabel;    //�����ǩ���û�����ǩ�������ǩ��
	private JTextField userTextField;    //�û��������
	private JPasswordField passwordField;    //���������
	JCheckBox rememberPassWordCheckBox;    //��ס���빴ѡ��
	private JButton loginButton,registerButton;    //��½��ȡ����ť��

	public static void main(String[] args) throws IOException 
	{
		try
		{
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
		
			SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
			SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
			SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
			SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
			SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
			//SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());
		}
		catch (Exception e)
		{
			System.err.println("Something went wrong!");
		}
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					
					LoginDatabaseConnection dc = new LoginDatabaseConnection();
					dc.creatConnection();
					dc.connectionClose();
					Login window = new Login();
					window.frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
	}

	public Login()
	{
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame();    //��ʼ�����ڡ�
		frame.setResizable(false);
		frame.setBounds(100,100,404,286);    //���ô���λ�ô�С��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //�������ڡ�
		frame.getContentPane().setLayout(null);    //����getContentPaneΪ���Բ��֡�
		ImageIcon img = new ImageIcon("F:\\eclipse\\Java eclipse\\software\\src\\software\\icon1.png");
		frame.setIconImage(img.getImage());
		
		titleLabel = new JLabel("������Ϣ����");    //��ʼ��titleLabel��ǩ��
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);    //����titleLabel��ǩΪ���Ĳ��֡�
		titleLabel.setFont(new Font("����", Font.BOLD, 25));    //����titleLabel����ʹ�С��
		titleLabel.setBounds(48,10,295,35);    //���ñ�ǩλ�úʹ�С��
		frame.getContentPane().add(titleLabel);    //��titleLabel��ǩ����frame���ڡ�
		
		panel = new JPanel();    //��ʼ��panel��塣
		panel.setBounds(29,55,312,173);    //�������λ�úʹ�С��
		frame.getContentPane().add(panel);    //��panel������frame�����С�
		panel.setLayout(null);    //���ô���Ϊ���Բ��֡�
		
		userLabel = new JLabel("�û���");    //��ʼ��userLabel��ǩ��
		userLabel.setFont(new Font("����", Font.PLAIN, 15));    //���ñ�ǩ������ʹ�С��
		userLabel.setBounds(23,14,55,30);    //����userLabel��ǩ�Ĵ�С��λ�á�
		panel.add(userLabel);    //��userLabel��ǩ����panel����С�
		
		PWLabel = new JLabel("����");    //��ʼ��PWLabel��ǩ��
		PWLabel.setFont(new Font("����", Font.PLAIN, 15));    //����PWLabel��ǩ�Ĵ�С��λ�á�
		PWLabel.setBounds(25,64,40,30);    //����PWLabel��Ǩ�Ĵ�С��λ��
		panel.add(PWLabel);    //��PWLabel����panel����С�
		
		userTextField = new JTextField();    //��ʼ��userTextField�����
		userTextField.setBounds(100,15,190,30);    //����userTextField������λ�úʹ�С��
		userTextField.setColumns(10);    //����userTextField�ı��ֶε�������
		panel.add(userTextField);    //��userTextField����panel����С�
		
		passwordField = new JPasswordField();    //��ʼ��passwordField���������
		passwordField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				toLogin();
			}
		});
		passwordField.setBounds(100,65,190,30);    //����passwordField������λ�úʹ�С��
		panel.add(passwordField);    //��passwordField����panel����С�
		
		loginButton = new JButton("��½");    //��ʼ��loginButton��½��ť��
		loginButton.setBounds(50,140,90,25);    //����loginButton��ť��λ�úʹ�С��
		panel.add(loginButton);    //��loginButton��ť����panel����С�

		registerButton = new JButton("ע��");    //��ʼ��registerButtonע�ᰴť��
		registerButton.setBounds(180,140,90,25);    //����registerButton��ť�Ĵ�С��λ�á�
		panel.add(registerButton);    //��registerButton��ť�ŵ�panel����С�
		
		rememberPassWordCheckBox = new JCheckBox("��ס����");
		rememberPassWordCheckBox.setBounds(90,105,80,20);
		rememberPassWordCheckBox.setFocusable(false);
		panel.add(rememberPassWordCheckBox);
		rememberPassword();
		loginButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{	
				toLogin();
			}
		});
		registerButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getSource() == registerButton) 
				{
					try
					{
						Register dialog = new Register();    //����ע����档
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
				} 
			}
		});
	}
	private void rememberPassword()
	{
		try 
		{
			@SuppressWarnings("resource")
			Scanner in = new Scanner(new File("F:\\eclipse\\Java eclipse\\software\\src\\software\\config.txt"));
			if(in.nextLine().equals("true"))
			{
				userTextField.setText(in.nextLine());
				passwordField.setText(in.nextLine());
				rememberPassWordCheckBox.setSelected(true);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	private void toLogin()
	{
		Object option[]={"ȷ��"};
		if(userTextField.getText().equals("") && 
					String.copyValueOf(passwordField.getPassword()).equals(""))
		{
			JOptionPane.showOptionDialog(null,"�����û���������Ϊ�ա�","�������",
					JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
			return;
		}
		if(userTextField.getText().equals(""))
		{
			JOptionPane.showOptionDialog(null,"�����û���Ϊ�ա�","�������",
					JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
		}
		if(String.copyValueOf(passwordField.getPassword()).equals(""))
		{
			JOptionPane.showOptionDialog(null,"��������Ϊ�ա�","�������",
				JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
		}
        else
        {
        	String username = userTextField.getText();    //���û�������û����洢��username�С�
        	char[] pw = passwordField.getPassword();    //���û���������봢�浽char����pw[]�С�
        	String password = String.copyValueOf(pw);    //��char����pw[]�������ַ���password�С�
        	String sql = "select * from register";    //��ʼ��sql��䡣
        	LoginDatabaseConnection dc = new LoginDatabaseConnection();    //����Login���ݿ⡣
        	ResultSet rs = dc.executeQuery(sql);    //ִ�в�ѯ��䡣
        	boolean flag = false;
        	try
        	{
				while(rs.next())
				{
					if(rs.getString("�û���").equals(username) && 
							rs.getString("����").equals(password))
					{
						Login.this.frame.dispose();
					    MainInterface MI = new MainInterface();
					    MI.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					    MI.setVisible(true);
					    flag = true;
					    break;
					}
				}
				if(!(flag))
				{
					JOptionPane.showMessageDialog(null,"�û������������",
							"��¼������ʾ",JOptionPane.ERROR_MESSAGE);
				}
				if(rememberPassWordCheckBox.isSelected())
				{
					try
					{
						FileOutputStream fs = new FileOutputStream(new File("F:\\eclipse\\Java eclipse\\software\\src\\software\\config.txt"));
						@SuppressWarnings("resource")
						PrintStream p = new PrintStream(fs);
						p.println("true");
						p.println(userTextField.getText());
						p.println(String.copyValueOf(passwordField.getPassword()));
					}
					catch(IOException e)
					{
					}
				}
				else
				{
					try
					{
						FileOutputStream fs = new FileOutputStream(new File("F:\\eclipse\\Java eclipse\\software\\src\\software\\config.txt"));
						@SuppressWarnings("resource")
						PrintStream p = new PrintStream(fs);
						p.println("false");
					}
					catch(IOException e)
					{
					}
				}
			}
        	catch (SQLException e1)
        	{
				e1.printStackTrace();
			}
        	dc.connectionClose();
        }
	}
}
