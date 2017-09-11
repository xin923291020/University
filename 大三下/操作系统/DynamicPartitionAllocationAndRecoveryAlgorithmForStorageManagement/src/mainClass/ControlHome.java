package mainClass;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import nodeHome.NodePartition;
import nodeHome.Partition;
import nodeHome.PartitionList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ControlHome
{
	private static ControlHome controlHome;
	private JFrame frame = new JFrame();
	private JTextArea freeTextArea = new JTextArea("空闲的内存:\n编号\t首址\t终址\t大小\n");
	private JTextArea occupyTextArea = new JTextArea("占用的内存:\n编号\t首址\t终址\t大小\n");
	private JTextField applySizeTextField = new JTextField();
	private JLabel applySizeLabel = new JLabel("\u7533\u8BF7\u5185\u5B58\u5927\u5C0F:");
	private JButton applyButton = new JButton("\u7533\u8BF7");
	private PartitionList freePartition = new PartitionList(0,32768);
	private PartitionList occupyPartition = new PartitionList();
	private JLabel occupyAddressLabel = new JLabel("\u91CA\u653E\u5185\u5B58\u5730\u5740:");
	private JTextField accupyAddressTextField = new JTextField();
	private JTextField accupySizeTextField = new JTextField();
	private JButton AccupyButton = new JButton("\u91CA\u653E");
	private JLabel accupySizeLabel = new JLabel("\u91CA\u653E\u5185\u5B58\u5927\u5C0F:");
	private JRadioButton firstFitRadio = new JRadioButton("first fit");
	private JRadioButton bestFitRadio = new JRadioButton("best fit");
	private int firstOrBestFit = 0;

	public static ControlHome getControlHome()
	{
		if(controlHome == null)
		{
			return new ControlHome();
		}
		return controlHome;
	}
	
	public ControlHome()
	{
		accupySizeTextField.setColumns(10);
		accupyAddressTextField.setColumns(10);
		applySizeTextField.setColumns(10);
		initialize();
	}

	private void initialize()
	{
		frame.setResizable(false);
		getFrame().setBounds(475,100,800,500);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setTitle("存储管理动态分区分配及回收算法");
		
		JPanel actionPanel = new JPanel();
		getFrame().getContentPane().add(actionPanel, BorderLayout.NORTH);
		actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		firstFitRadio.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(firstFitRadio.isSelected())
				{
					firstOrBestFit = 0;
				}
			}
		});
		firstFitRadio.setSelected(true);
		
		actionPanel.add(firstFitRadio);
		bestFitRadio.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				firstOrBestFit = 1;
			}
		});
		actionPanel.add(bestFitRadio);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(firstFitRadio);
		buttonGroup.add(bestFitRadio);
		actionPanel.add(applySizeLabel);
		
		actionPanel.add(applySizeTextField);
		applyButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int applySize;
				try
				{
					applySize = Integer.valueOf(applySizeTextField.getText());
					applySizeTextField.setText("");
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null,"申请内存大小应为数字","温馨提示",1);
					return;
				}
				if(firstOrBestFit == 0)
				{
					Partition applyPartition = freePartition.getSectionBySizeOfFirst(applySize);
					freeTextArea.setText("空闲的内存1:\n" + freePartition.getAllNodePartitionInfo());
					freePartition = sort(freePartition);
					occupyPartition.addNodePartition(applyPartition,false);
					freeTextArea.setText("空闲的内存2:\n" + freePartition.getAllNodePartitionInfo());
					occupyTextArea.setText("占用的内存:\n" + occupyPartition.getAllNodePartitionInfo());
				}
				else if(firstOrBestFit == 1)
				{
					Partition applyPartition = freePartition.getSectionBySizeOfBest(applySize);
					occupyPartition.addNodePartition(applyPartition,false);
					freeTextArea.setText("空闲的内存:\n" + freePartition.getAllNodePartitionInfo());
					occupyTextArea.setText("占用的内存:\n" + occupyPartition.getAllNodePartitionInfo());
				}
			}
		});
		
		actionPanel.add(applyButton);
		
		actionPanel.add(occupyAddressLabel);
		
		actionPanel.add(accupyAddressTextField);
		
		actionPanel.add(accupySizeLabel);
		
		actionPanel.add(accupySizeTextField);
		AccupyButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int accupyAddress;
				try
				{
					accupyAddress = Integer.valueOf(accupyAddressTextField.getText());
					accupyAddressTextField.setText("");
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null,"释放内存地址应为数字","温馨提示",1);
					return;
				}
				int accupySize;
				try
				{
					accupySize = Integer.valueOf(accupySizeTextField.getText());
					accupySizeTextField.setText("");
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null,"释放内存大小应为数字","温馨提示",1);
					return;
				}
				Partition recoveryPartition = occupyPartition.getSectionByAddressAndSizeOfFirst(accupyAddress,accupySize);
				freePartition.addNodePartition(recoveryPartition,true);
				freeTextArea.setText("空闲的内存:\n" + freePartition.getAllNodePartitionInfo());
				occupyTextArea.setText("占用的内存:\n" + occupyPartition.getAllNodePartitionInfo());
			}
		});
		
		actionPanel.add(AccupyButton);
		
		JSplitPane splitPane = new JSplitPane();
		getFrame().getContentPane().add(splitPane, BorderLayout.CENTER);
		freeTextArea.setColumns(56);
		freeTextArea.setEditable(false);
		splitPane.setLeftComponent(freeTextArea);
		freeTextArea.setText("空闲的内存:\n" + freePartition.getAllNodePartitionInfo());
		occupyTextArea.setEditable(false);
		splitPane.setRightComponent(occupyTextArea);
	}

	public PartitionList sort(PartitionList partitionList)
	{
		System.out.println("进行排序");
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		NodePartition currentNodePartition = partitionList.getNodePartition();
		arrayList.add(currentNodePartition.getPartition().getAddress());
		while(partitionList.haveNextNodePartition(currentNodePartition))
		{
			System.out.println("循环1");
			currentNodePartition = partitionList.getNextNodePartition(currentNodePartition);
			arrayList.add(currentNodePartition.getPartition().getAddress());
		}
		PartitionList resultPartitionList = null;
		currentNodePartition = partitionList.getNodePartition();
		System.out.println(arrayList.size());
		Collections.sort(arrayList);
		for(int i = 0;i < arrayList.size();i++)
		{
			if(currentNodePartition.getPartition().getAddress() == arrayList.get(i))
			{
				if(i == 0)
				{
					resultPartitionList = new PartitionList();
					resultPartitionList.setNodePartition(currentNodePartition);
				}
				else
				{
					resultPartitionList.getLastNodePartition().setNext(currentNodePartition);
				}
				continue;
			}
			while(partitionList.haveNextNodePartition(currentNodePartition))
			{
				currentNodePartition = partitionList.getNextNodePartition(currentNodePartition);
				System.out.println("循环2");
				if(currentNodePartition.getPartition().getAddress() == arrayList.get(i))
				{
					if(i == 0)
					{
						resultPartitionList = new PartitionList();
						resultPartitionList.setNodePartition(currentNodePartition);
					}
					else
					{
						resultPartitionList.getLastNodePartition().setNext(currentNodePartition);
					}
					break;
				}
			}
		}
		System.out.println("结束");
		return resultPartitionList;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}

	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
}
