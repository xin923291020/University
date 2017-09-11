package software;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
@SuppressWarnings("serial")
public class Register extends JFrame
{
	private JPanel contentPane;    //容器面板。
	private JLabel registerLabel;    //注册标签。
	private JLabel userLabel,PWLabel,PWConfirmLabel;    //用户名，密码，手机号标签。
	private JLabel noUserWarnLabel,noPWWarnLabel,noPhoneWarnLabel;    //无用户名，密码，手机号警告标签。
	private JTextField userTextField;
	private JPasswordField PWTextField,PWConfirmTextField;    //账号，密码，手机号输入框。
	private JButton confirmButton,canelButton;    //确认取消按钮。

	public Register()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置窗口关闭按钮。
		setBounds(100,100,490,330);    //设置窗口的大小和位置。
		contentPane = new JPanel();    //初始化容器面板。
		contentPane.setBorder(new EmptyBorder(5,5,5,5));    //为容器面板设置边框大小。
		setContentPane(contentPane);    //设置容器面板。
		contentPane.setLayout(null);    //设置容器面板为绝对布局。
		
		registerLabel = new JLabel("注册");    //初始化registerLabel注册标签。
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);    //设置registerLabel注册标签为中心布局。
		registerLabel.setFont(new Font("宋体", Font.BOLD, 25));   //设置字体型号大小。
		registerLabel.setBounds(65,20,335,40);    //设置registerLabe注册标签的位置大小。
		contentPane.add(registerLabel);    //将registerLabel用户标签放入contentPane面板中。
		
		userLabel = new JLabel("用户名");    //初始化userLabel用户标签。
		userLabel.setForeground(new Color(0,0,0));    //设置userLabel用户标签字体颜色。
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);    //设置userLabel用户标签为中心布局。
		userLabel.setBounds(15,70,135,40);    //设置userLabel用户标签的位置大小。
		contentPane.add(userLabel);    //将userLabel用户标签放入contentPane面板中。
		
		PWLabel = new JLabel("密码");    //初始化PWLabel密码标签。
		PWLabel.setHorizontalAlignment(SwingConstants.CENTER);    //设置PWLabel密码标签为中心布局。
		PWLabel.setBounds(15,115,135,40);    //设置PWLabel密码标签的位置大小。
		contentPane.add(PWLabel);    //将PWLabel密码放入contentPane面板中。
		
		PWConfirmLabel = new JLabel("确认密码");    //初始化PWConfirmLabel密码确认标签。
		PWConfirmLabel.setHorizontalAlignment(SwingConstants.CENTER);    //设置PWConfirmLabel密码确认标签为中心布局。
		PWConfirmLabel.setBounds(15,160,135,40);    //设置PWConfirmLabel密码确认标签的位置大小。
		contentPane.add(PWConfirmLabel);    //将PWConfirmLabel密码确认放入contentPane面板中。
		
		noUserWarnLabel = new JLabel("");    //初始化noUserWarnLabel无用户名警告标签。
		noUserWarnLabel.setForeground(new Color(255,0,0));    //设置noUserWarnLabel无用户名警告字体颜色。
		noUserWarnLabel.setBounds(335,70,120,40);    //设置noUserWarnLabel无用户名警告标签的位置大小。
		contentPane.add(noUserWarnLabel);    //将noUserWarnLabel无用户名警告放入contentPane面板中。
		
		noPWWarnLabel = new JLabel("");    //初始化noPWWarnLabel无密码警告标签。
		noPWWarnLabel.setForeground(new Color(255,0,0));    //设置noPWWarnLabel无密码警告字体颜色。
		noPWWarnLabel.setBounds(335,120,120,40);    //设置noPWWarnLabel无密码警告标签的位置大小。
		contentPane.add(noPWWarnLabel);    //将noPWWarnLabel无密码警告放入contentPane面板中。
		
		noPhoneWarnLabel = new JLabel("");    //初始化noPhoneWarnLabel无手机号警告标签。
		noPhoneWarnLabel.setForeground(new Color(255,0,0));    //设置noPhoneWarnLabel无手机号警告字体颜色。
		noPhoneWarnLabel.setBounds(335,160,120,40);    //设置noPhoneWarnLabel无手机号警告标签的位置大小。
		contentPane.add(noPhoneWarnLabel);    //将noPhoneWarnLabel无手机号警告放入contentPane面板中。
		
		userTextField = new JTextField();    //初始化userTextField用户名输入框。
		userTextField.setBounds(140,75,180,30);    //设置userTextField用户名输入框的位置和大小。
		userTextField.setColumns(10);    //设置userTextField用户名输入框文本字段的列数。
		
		PWTextField = new JPasswordField();    //初始化PWTextField密码输入框。
		PWTextField.setBounds(140,120,180,30);    //设置PWTextField密码输入框的位置和大小。
		PWTextField.setColumns(10);    //设置PWTextField密码输入框文本字段的列数。
		contentPane.add(PWTextField);    //将PWTextField密码输入框放到contentPane面板中。
		
		PWConfirmTextField = new JPasswordField();    //初始化PWConfirmTextFiel密码确认输入框。
		PWConfirmTextField.setBounds(140,165,180,30);    //设置PWConfirmTextField密码确认输入框的位置和大小。
		PWConfirmTextField.setColumns(10);    //设置PWConfirmTextField密码确认输入框文本字段的列数。
		contentPane.add(PWConfirmTextField);    //将PWConfirmTextField密码确认输入框放到contentPane面板中。
		
		confirmButton = new JButton("确认");    //初始化confirmButton确认按钮。
		confirmButton.setBounds(110,225,90,25);    //设置confirmButton确认按钮的位置和大小。
		contentPane.add(confirmButton);    //将uconfirmButton确认按钮放到contentPane面板中。
		
		canelButton = new JButton("取消");    //初始化canelButton取消按钮。
		canelButton.setBounds(250,225,90,25);    //设置canelButton取消按钮的位置和大小。
		contentPane.add(canelButton);    //将canelButton取消按钮放到contentPane面板中。
		
		userTextField.addFocusListener(new FocusAdapter()    //用户名输入框焦点监听事件。
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				LoginDatabaseConnection dc = new LoginDatabaseConnection();    //连接数据库。
				ResultSet rs = dc.executeQuery("select 用户名 from register");    //返回所有用户数据。
				if(e.getSource() == userTextField)
				{
					if(!(userTextField.getText().equals("")))
					{
						noUserWarnLabel.setText("");
					}
					if(userTextField.getText().equals(""))
					{
						noUserWarnLabel.setText("用户名不能为空。");
					}
					else
					{
						try
						{
							while(rs.next())
							{
								if(rs.getString("用户名").equals(userTextField.getText()))
								{
									noUserWarnLabel.setText("该用户名已经注册过");
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

		contentPane.add(userTextField);    //将userTextField用户名输入框放到contentPane面板中。
		PWTextField.addFocusListener(new FocusAdapter()    //密码输入框焦点监听事件。
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				if(e.getSource() == PWTextField)
				{
					if(String.copyValueOf(PWTextField.getPassword()).equals(""))
					{
						noPWWarnLabel.setText("请设置密码。");
					}
					else
					{
						noPWWarnLabel.setText("");
					}
				}
			}
		});
		PWConfirmTextField.addFocusListener(new FocusAdapter()    //密码确认输入框焦点监听事件。
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				if(e.getSource() == PWConfirmTextField)
				{
					if(!(String.copyValueOf(PWConfirmTextField.getPassword()).equals(String.copyValueOf(PWTextField.getPassword()))))
					{
						noPhoneWarnLabel.setText("密码不一致。");
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
					JOptionPane.showMessageDialog(null, "输入项不可为空。",
							"输入提示",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else if(!(String.copyValueOf(PWConfirmTextField.getPassword()).equals(String.copyValueOf(PWTextField.getPassword()))))
				{
					JOptionPane.showMessageDialog(null, "密码不一致。",
							"输入提示",JOptionPane.WARNING_MESSAGE);
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