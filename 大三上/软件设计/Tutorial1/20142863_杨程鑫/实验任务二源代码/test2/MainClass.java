package test2;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainClass
{
	private LoginForm frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainClass window = new MainClass();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public MainClass()
	{
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new LoginForm();
		frame.setBounds(480, 180, 430, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}