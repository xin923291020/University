package test1_2;

import java.awt.Component;

import javax.swing.JOptionPane;

import test1_1.ConvertTools;

public class MainClass
{
	private static Component frame;

	public static void main(String[] args)
	{
		int cost = 0;
		int money = 0;
		ConvertTools convertTools = new ConvertTools();
		while(true)
		{
			String costString = JOptionPane.showInputDialog("�����뻨��,(1-100)");
			if(costString == null)
			{
				System.exit(0);
			}
			if(!convertTools.isNumber(costString))
			{
				JOptionPane.showMessageDialog(frame,"��������ȷ����");
				continue;
			}
			cost = Integer.valueOf(costString);
			if(cost >= 1 && cost <= 100)
			{
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"�������ڷ�Χ");
			}
		}
		while(true)
		{
			String moneyString = JOptionPane.showInputDialog("������Ǯ��,(1-100)");
			if(moneyString == null)
			{
				System.exit(0);
			}
			if(!convertTools.isNumber(moneyString))
			{
				JOptionPane.showMessageDialog(frame,"��������ȷǮ��");
			}
			money = Integer.valueOf(moneyString);
			if(money >= 1 && money <= 100)
			{
				if(money >= cost)
				{
					break;
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Ǯ��Ӧ���ڻ���");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"Ǯ�����ڷ�Χ");
			}
		}
		int change = money - cost;
		int numberOfN50 = 0;
		int numberOfN10 = 0;
		int numberOfN5 = 0;
		int numberOfN1 = 0;
		boolean isOver = false;
		if(change >= 50 && !isOver)
		{
			numberOfN50 = change / 50;
			change %= 50;
			if(change == 0)
			{
				isOver = true;
			}
		}
		if(change >= 10 && !isOver)
		{
			numberOfN10 = change / 10;
			change %= 10;
			if(change == 0)
			{
				isOver = true;
			}
		}
		if(change >= 5 && !isOver)
		{
			numberOfN5 = change / 5;
			change %= 5;
			if(change == 0)
			{
				isOver = true;
			}
		}
		if(change >= 1 && !isOver)
		{
			numberOfN1 = change / 1;
			change %= 1;
			if(change == 0)
			{
				isOver = true;
			}
		}
		if(change == 0)
		{
			isOver = true;
		}
		if(isOver)
		{
			System.out.print("50Ԫ:\t" + numberOfN50 + "��\n"
					+ "10Ԫ:\t" + numberOfN10 + "��\n"
					+ "5Ԫ:\t" + numberOfN5 + "��\n"
					+ "1Ԫ:\t" + numberOfN1 + "��");
		}
	}
}