package test1_4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainClass
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
					MainClass window = new MainClass();
					window.frame.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MainClass()
	{
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100,100,340,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel airLinePanel = new JPanel();
		airLinePanel.setBounds(33, 22, 260, 48);
		frame.getContentPane().add(airLinePanel);
		airLinePanel.setLayout(null);
		
		JLabel airLineLabel = new JLabel("航线：");
		airLineLabel.setBounds(10, 2, 60, 20);
		airLinePanel.add(airLineLabel);
		
		ButtonGroup airLineButtonGroup = new ButtonGroup();
		JRadioButton airLineType1 = new JRadioButton("欧美");
		airLineType1.setSelected(true);
		airLineType1.setBounds(5, 20, 60, 20);
		airLinePanel.add(airLineType1);
		airLineButtonGroup.add(airLineType1);
		
		JRadioButton airLineType2 = new JRadioButton("国外非欧美");
		airLineType2.setBounds(75, 20, 100, 20);
		airLinePanel.add(airLineType2);
		airLineButtonGroup.add(airLineType2);
		
		JRadioButton airLineType3 = new JRadioButton("国内");
		airLineType3.setBounds(185, 20, 60, 20);
		airLinePanel.add(airLineType3);
		airLineButtonGroup.add(airLineType3);
		
		JPanel typePanel = new JPanel();
		typePanel.setBounds(33, 90, 260, 48);
		frame.getContentPane().add(typePanel);
		typePanel.setLayout(null);
		
		JLabel typeLabel = new JLabel("航位：");
		typeLabel.setBounds(10, 2, 60, 20);
		typePanel.add(typeLabel);

		ButtonGroup typeButtonGroup = new ButtonGroup();
		JRadioButton businessClassRadio = new JRadioButton("商务舱");
		businessClassRadio.setSelected(true);
		businessClassRadio.setBounds(40, 20, 80, 20);
		typeButtonGroup.add(businessClassRadio);
		typePanel.add(businessClassRadio);
		
		JRadioButton touristClassRadio = new JRadioButton("经济舱");
		touristClassRadio.setBounds(140, 20, 80, 20);
		typeButtonGroup.add(touristClassRadio);
		typePanel.add(touristClassRadio);
		
		JPanel timePanel = new JPanel();
		timePanel.setBounds(33, 159, 260, 48);
		frame.getContentPane().add(timePanel);
		timePanel.setLayout(null);
		
		JLabel timeLabel = new JLabel("飞行时间：");
		timeLabel.setBounds(10, 2, 60, 20);
		timePanel.add(timeLabel);

		ButtonGroup timeButtonGroup = new ButtonGroup();
		JRadioButton withinTwoRadio = new JRadioButton("两小时以内");
		withinTwoRadio.setSelected(true);
		withinTwoRadio.setBounds(40, 20, 100, 20);
		timeButtonGroup.add(withinTwoRadio);
		timePanel.add(withinTwoRadio);
		
		JRadioButton moreThanTwoRadio = new JRadioButton("超过两小时");
		moreThanTwoRadio.setBounds(140, 20, 100, 20);
		timeButtonGroup.add(moreThanTwoRadio);
		timePanel.add(moreThanTwoRadio);
		
		JLabel resultLabel = new JLabel("航空服务：");
		resultLabel.setBounds(50, 230, 60, 20);
		frame.getContentPane().add(resultLabel);
		

		JTextField resultTextField = new JTextField();
		resultTextField.setBounds(120, 230, 150, 20);
		frame.getContentPane().add(resultTextField);
		resultTextField.setColumns(10);
		
		JButton selectButton = new JButton("查询");
		selectButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(airLineType1.isSelected())
				{
					resultTextField.setText("有食物供应，可播放电影");
				}
				else if(airLineType2.isSelected())
				{
					if(businessClassRadio.isSelected())
					{
						resultTextField.setText("有食物供应，可播放电影");
					}
					else
					{
						resultTextField.setText("有食物供应");
					}
				}
				else if(airLineType3.isSelected())
				{
					if(businessClassRadio.isSelected())
					{
						resultTextField.setText("有食物供应");
					}
					else if(touristClassRadio.isSelected())
					{
						if(moreThanTwoRadio.isSelected())
						{
							resultTextField.setText("有食物供应");
						}
						else
						{
							resultTextField.setText("无服务");
						}
					}
				}
				else
				{
					resultTextField.setText("无服务");
				}
			}
		});
		selectButton.setBounds(45, 265, 90, 25);
		frame.getContentPane().add(selectButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}
		});
		exitButton.setBounds(180, 265, 90, 25);
		frame.getContentPane().add(exitButton);
	}
}
