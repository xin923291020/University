package test1_3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DepositPaymentWarning extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public DepositPaymentWarning(String costType,String roomType)
	{

		setTitle("支付提醒");
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
		
		JButton insufficientHousingButton = new JButton("房款不足");
		insufficientHousingButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				dispose();
			}
		});
		insufficientHousingButton.setBounds(68,115,90,25);
		contentPane.add(insufficientHousingButton);
	}

	@Override
	public void dispose()
	{
		super.dispose();
	}
}
