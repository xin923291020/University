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
		
		JLabel airLineLabel = new JLabel("���ߣ�");
		airLineLabel.setBounds(10, 2, 60, 20);
		airLinePanel.add(airLineLabel);
		
		ButtonGroup airLineButtonGroup = new ButtonGroup();
		JRadioButton airLineType1 = new JRadioButton("ŷ��");
		airLineType1.setSelected(true);
		airLineType1.setBounds(5, 20, 60, 20);
		airLinePanel.add(airLineType1);
		airLineButtonGroup.add(airLineType1);
		
		JRadioButton airLineType2 = new JRadioButton("�����ŷ��");
		airLineType2.setBounds(75, 20, 100, 20);
		airLinePanel.add(airLineType2);
		airLineButtonGroup.add(airLineType2);
		
		JRadioButton airLineType3 = new JRadioButton("����");
		airLineType3.setBounds(185, 20, 60, 20);
		airLinePanel.add(airLineType3);
		airLineButtonGroup.add(airLineType3);
		
		JPanel typePanel = new JPanel();
		typePanel.setBounds(33, 90, 260, 48);
		frame.getContentPane().add(typePanel);
		typePanel.setLayout(null);
		
		JLabel typeLabel = new JLabel("��λ��");
		typeLabel.setBounds(10, 2, 60, 20);
		typePanel.add(typeLabel);

		ButtonGroup typeButtonGroup = new ButtonGroup();
		JRadioButton businessClassRadio = new JRadioButton("�����");
		businessClassRadio.setSelected(true);
		businessClassRadio.setBounds(40, 20, 80, 20);
		typeButtonGroup.add(businessClassRadio);
		typePanel.add(businessClassRadio);
		
		JRadioButton touristClassRadio = new JRadioButton("���ò�");
		touristClassRadio.setBounds(140, 20, 80, 20);
		typeButtonGroup.add(touristClassRadio);
		typePanel.add(touristClassRadio);
		
		JPanel timePanel = new JPanel();
		timePanel.setBounds(33, 159, 260, 48);
		frame.getContentPane().add(timePanel);
		timePanel.setLayout(null);
		
		JLabel timeLabel = new JLabel("����ʱ�䣺");
		timeLabel.setBounds(10, 2, 60, 20);
		timePanel.add(timeLabel);

		ButtonGroup timeButtonGroup = new ButtonGroup();
		JRadioButton withinTwoRadio = new JRadioButton("��Сʱ����");
		withinTwoRadio.setSelected(true);
		withinTwoRadio.setBounds(40, 20, 100, 20);
		timeButtonGroup.add(withinTwoRadio);
		timePanel.add(withinTwoRadio);
		
		JRadioButton moreThanTwoRadio = new JRadioButton("������Сʱ");
		moreThanTwoRadio.setBounds(140, 20, 100, 20);
		timeButtonGroup.add(moreThanTwoRadio);
		timePanel.add(moreThanTwoRadio);
		
		JLabel resultLabel = new JLabel("���շ���");
		resultLabel.setBounds(50, 230, 60, 20);
		frame.getContentPane().add(resultLabel);
		

		JTextField resultTextField = new JTextField();
		resultTextField.setBounds(120, 230, 150, 20);
		frame.getContentPane().add(resultTextField);
		resultTextField.setColumns(10);
		
		JButton selectButton = new JButton("��ѯ");
		selectButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(airLineType1.isSelected())
				{
					resultTextField.setText("��ʳ�﹩Ӧ���ɲ��ŵ�Ӱ");
				}
				else if(airLineType2.isSelected())
				{
					if(businessClassRadio.isSelected())
					{
						resultTextField.setText("��ʳ�﹩Ӧ���ɲ��ŵ�Ӱ");
					}
					else
					{
						resultTextField.setText("��ʳ�﹩Ӧ");
					}
				}
				else if(airLineType3.isSelected())
				{
					if(businessClassRadio.isSelected())
					{
						resultTextField.setText("��ʳ�﹩Ӧ");
					}
					else if(touristClassRadio.isSelected())
					{
						if(moreThanTwoRadio.isSelected())
						{
							resultTextField.setText("��ʳ�﹩Ӧ");
						}
						else
						{
							resultTextField.setText("�޷���");
						}
					}
				}
				else
				{
					resultTextField.setText("�޷���");
				}
			}
		});
		selectButton.setBounds(45, 265, 90, 25);
		frame.getContentPane().add(selectButton);
		
		JButton exitButton = new JButton("�˳�");
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
