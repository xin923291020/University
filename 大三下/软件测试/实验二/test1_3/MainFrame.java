package test1_3;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame()
	{
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("�ͷ�Ԥ��ϵͳ");
		frame.setBounds(450,170,420,275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel costTypeLabel = new JLabel("����֧��");
		costTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		costTypeLabel.setBounds(250,40,60,20);
		frame.getContentPane().add(costTypeLabel);

		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton fullPaymentRadio = new JRadioButton("֧��ȫ��");
		fullPaymentRadio.setHorizontalAlignment(SwingConstants.CENTER);
		fullPaymentRadio.setBounds(180,75,100,25);
		buttonGroup.add(fullPaymentRadio);
		frame.getContentPane().add(fullPaymentRadio);

		JRadioButton depositPaymentRadio = new JRadioButton("֧������");
		depositPaymentRadio.setBounds(300,75,100,25);
		buttonGroup.add(depositPaymentRadio);
		frame.getContentPane().add(depositPaymentRadio);


		JLabel roomTypeLabel = new JLabel("��������");
		roomTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roomTypeLabel.setBounds(175,145,60,20);
		frame.getContentPane().add(roomTypeLabel);

		JButton singleRoomButton = new JButton("���˼�");
		singleRoomButton.addMouseListener(new MouseAdapter()
		{
			private Component frameTemp;

			public void mouseClicked(MouseEvent e)
			{
				if(fullPaymentRadio.isSelected())
				{
					FullPaymentSuccess fullPaymentSuccess = new FullPaymentSuccess
							(fullPaymentRadio.getText(),singleRoomButton.getText());
					fullPaymentSuccess.setVisible(true);
				}
				else if(depositPaymentRadio.isSelected())
				{
					DepositPaymentWarning depositPaymentWarning = new DepositPaymentWarning
							(depositPaymentRadio.getText(),singleRoomButton.getText());
					depositPaymentWarning.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(frameTemp,"��ѡ��֧������");
				}
			}
		});
		singleRoomButton.setBounds(40,180,90,25);
		frame.getContentPane().add(singleRoomButton);

		JButton doubleRoomButton = new JButton("˫�˼�");
		doubleRoomButton.addMouseListener(new MouseAdapter()
		{
			private Component frameTemp;

			public void mouseClicked(MouseEvent e)
			{
				if(fullPaymentRadio.isSelected())
				{
					FullPaymentSuccess fullPaymentSuccess = new FullPaymentSuccess(
							fullPaymentRadio.getText(),doubleRoomButton.getText());
					fullPaymentSuccess.setVisible(true);
				}
				else if(depositPaymentRadio.isSelected())
				{
					DepositPaymentWarning depositPaymentWarning = new DepositPaymentWarning
							(depositPaymentRadio.getText(),singleRoomButton.getText());
					depositPaymentWarning.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(frameTemp,"��ѡ��֧������");
				}
			}
		});
		doubleRoomButton.setBounds(160,180,90,25);
		frame.getContentPane().add(doubleRoomButton);

		JButton DeluxeRoomButton = new JButton("������");
		DeluxeRoomButton.addMouseListener(new MouseAdapter()
		{
			private Component frameTemp;

			public void mouseClicked(MouseEvent e)
			{
				if(fullPaymentRadio.isSelected())
				{
					FullPaymentSuccess fullPaymentSuccess = new FullPaymentSuccess(
							fullPaymentRadio.getText(),DeluxeRoomButton.getText());
					fullPaymentSuccess.setVisible(true);
				}
				else if(depositPaymentRadio.isSelected())
				{
					DepositPaymentWarning depositPaymentWarning = new DepositPaymentWarning
							(depositPaymentRadio.getText(),singleRoomButton.getText());
					depositPaymentWarning.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(frameTemp,"��ѡ��֧������");
				}
			}
		});
		DeluxeRoomButton.setBounds(280,180,90,25);
		frame.getContentPane().add(DeluxeRoomButton);

		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g)
			{
				g.drawImage(Toolkit.getDefaultToolkit().getImage("src\\test1_3\\image.png"),0,0,this);
			}
		};
		panel.setBounds(44,30,116,89);
		frame.getContentPane().add(panel);
	}
}