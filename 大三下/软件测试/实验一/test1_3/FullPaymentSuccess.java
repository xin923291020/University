package test1_3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FullPaymentSuccess extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FullPaymentSuccess(String costType,String roomType)
	{
		setTitle("全额付款");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(540,170,250,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel costTypeLabel = new JLabel("支付类型:" + costType);
		costTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		costTypeLabel.setBounds(35,25,150,20);
		contentPane.add(costTypeLabel);
		
		JLabel roomTypeLabel = new JLabel("房间类型:" + roomType);
		roomTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roomTypeLabel.setBounds(35,70,150,20);
		contentPane.add(roomTypeLabel);
		
		JButton btnNewButton = new JButton("开启客房");
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			private Component frameTemp;

			public void mouseClicked(MouseEvent e)
			{
				JOptionPane.showMessageDialog(frameTemp,"开启成功");
				System.exit(0);
			}
		});
		btnNewButton.setBounds(68, 115, 90, 25);
		contentPane.add(btnNewButton);
	}
}
