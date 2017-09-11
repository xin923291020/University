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
	private JFrame frame;    //窗口。
	private JPanel panel;    //子面板。
	private JLabel titleLabel,userLabel,PWLabel;    //标题标签，用户名标签，密码标签。
	private JTextField userTextField;    //用户名输入框。
	private JPasswordField passwordField;    //密码输入框。
	JCheckBox rememberPassWordCheckBox;    //记住密码勾选框。
	private JButton loginButton,registerButton;    //登陆，取消按钮。

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
		frame = new JFrame();    //初始化窗口。
		frame.setResizable(false);
		frame.setBounds(100,100,404,286);    //设置窗口位置大小。
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //调出窗口。
		frame.getContentPane().setLayout(null);    //设置getContentPane为绝对布局。
		ImageIcon img = new ImageIcon("F:\\eclipse\\Java eclipse\\software\\src\\software\\icon1.png");
		frame.setIconImage(img.getImage());
		
		titleLabel = new JLabel("博客信息管理");    //初始化titleLabel标签。
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);    //设置titleLabel标签为中心布局。
		titleLabel.setFont(new Font("宋体", Font.BOLD, 25));    //设置titleLabel字体和大小。
		titleLabel.setBounds(48,10,295,35);    //设置标签位置和大小。
		frame.getContentPane().add(titleLabel);    //将titleLabel标签加入frame窗口。
		
		panel = new JPanel();    //初始化panel面板。
		panel.setBounds(29,55,312,173);    //设置面板位置和大小。
		frame.getContentPane().add(panel);    //将panel面板加入frame窗口中。
		panel.setLayout(null);    //设置窗口为绝对布局。
		
		userLabel = new JLabel("用户名");    //初始化userLabel标签。
		userLabel.setFont(new Font("宋体", Font.PLAIN, 15));    //设置标签的字体和大小。
		userLabel.setBounds(23,14,55,30);    //设置userLabel标签的大小和位置。
		panel.add(userLabel);    //将userLabel标签加入panel面板中。
		
		PWLabel = new JLabel("密码");    //初始化PWLabel标签。
		PWLabel.setFont(new Font("宋体", Font.PLAIN, 15));    //设置PWLabel标签的大小和位置。
		PWLabel.setBounds(25,64,40,30);    //设置PWLabel变迁的大小和位置
		panel.add(PWLabel);    //将PWLabel放入panel面板中。
		
		userTextField = new JTextField();    //初始化userTextField输入框。
		userTextField.setBounds(100,15,190,30);    //设置userTextField输入框的位置和大小。
		userTextField.setColumns(10);    //设置userTextField文本字段的列数。
		panel.add(userTextField);    //将userTextField放入panel面板中。
		
		passwordField = new JPasswordField();    //初始化passwordField密码输入框。
		passwordField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				toLogin();
			}
		});
		passwordField.setBounds(100,65,190,30);    //设置passwordField输入框的位置和大小。
		panel.add(passwordField);    //将passwordField放入panel面板中。
		
		loginButton = new JButton("登陆");    //初始化loginButton登陆按钮。
		loginButton.setBounds(50,140,90,25);    //设置loginButton按钮的位置和大小。
		panel.add(loginButton);    //将loginButton按钮放入panel面板中。

		registerButton = new JButton("注册");    //初始化registerButton注册按钮。
		registerButton.setBounds(180,140,90,25);    //设置registerButton按钮的大小和位置。
		panel.add(registerButton);    //将registerButton按钮放到panel面板中。
		
		rememberPassWordCheckBox = new JCheckBox("记住密码");
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
						Register dialog = new Register();    //调用注册界面。
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
		Object option[]={"确定"};
		if(userTextField.getText().equals("") && 
					String.copyValueOf(passwordField.getPassword()).equals(""))
		{
			JOptionPane.showOptionDialog(null,"您的用户名和密码为空。","输入错误",
					JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
			return;
		}
		if(userTextField.getText().equals(""))
		{
			JOptionPane.showOptionDialog(null,"您的用户名为空。","输入错误",
					JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
		}
		if(String.copyValueOf(passwordField.getPassword()).equals(""))
		{
			JOptionPane.showOptionDialog(null,"您的密码为空。","输入错误",
				JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
		}
        else
        {
        	String username = userTextField.getText();    //将用户输入的用户名存储到username中。
        	char[] pw = passwordField.getPassword();    //将用户输入的密码储存到char数组pw[]中。
        	String password = String.copyValueOf(pw);    //将char数组pw[]拷贝到字符创password中。
        	String sql = "select * from register";    //初始化sql语句。
        	LoginDatabaseConnection dc = new LoginDatabaseConnection();    //连接Login数据库。
        	ResultSet rs = dc.executeQuery(sql);    //执行查询语句。
        	boolean flag = false;
        	try
        	{
				while(rs.next())
				{
					if(rs.getString("用户名").equals(username) && 
							rs.getString("密码").equals(password))
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
					JOptionPane.showMessageDialog(null,"用户名或密码错误",
							"登录错误提示",JOptionPane.ERROR_MESSAGE);
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
