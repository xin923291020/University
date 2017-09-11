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
			String costString = JOptionPane.showInputDialog("请输入花销,(1-100)");
			if(costString == null)
			{
				System.exit(0);
			}
			if(!convertTools.isNumber(costString))
			{
				JOptionPane.showMessageDialog(frame,"请输入正确花销");
				continue;
			}
			cost = Integer.valueOf(costString);
			if(cost >= 1 && cost <= 100)
			{
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"花销不在范围");
			}
		}
		while(true)
		{
			String moneyString = JOptionPane.showInputDialog("请输入钱数,(1-100)");
			if(moneyString == null)
			{
				System.exit(0);
			}
			if(!convertTools.isNumber(moneyString))
			{
				JOptionPane.showMessageDialog(frame,"请输入正确钱数");
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
					JOptionPane.showMessageDialog(frame,"钱数应大于花销");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame,"钱数不在范围");
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
			System.out.print("50元:\t" + numberOfN50 + "张\n"
					+ "10元:\t" + numberOfN10 + "张\n"
					+ "5元:\t" + numberOfN5 + "张\n"
					+ "1元:\t" + numberOfN1 + "张");
		}
	}
}