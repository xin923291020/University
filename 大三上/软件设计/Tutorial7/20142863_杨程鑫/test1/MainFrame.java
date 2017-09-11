package test1;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame
{

	private JFrame frame;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	private MainFrame()
	{
		frame = new JFrame();
		frame.setTitle("\u4E3B\u7A97\u4F53");
		frame.setBounds(100, 100, 250, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u751F\u6210\u4E00\u4E2A\u5B50\u7A97\u4F53");
		btnNewButton.addActionListener(new ActionListener()
		{
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e)
			{
				SonFrame window = SonFrame.getSonFrame();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 20, 200, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5C1D\u8BD5\u518D\u6B21\u751F\u6210\u65B0\u7A97\u4F53");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e)
			{
				SonFrame window = SonFrame.getSonFrame();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(20, 80, 200, 30);
		frame.getContentPane().add(btnNewButton_1);
	}
}
