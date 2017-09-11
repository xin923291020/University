package test1_1;

import java.awt.Component;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;

public class MainClass
{
	private static Component frame = null;

	public static void main(String args[]) throws ParseException
	{
		String dataString = "";
		ConvertTools convertTools = new ConvertTools();
		while(true)
		{
			dataString = JOptionPane.showInputDialog("请输入日期,(00010101)");
			if(dataString == null)
			{
				System.exit(0);
			}
			if(dataString.length() != 8)
			{
				JOptionPane.showMessageDialog(frame ,"输入日期长度应为8。");
				continue;
			}
			if(convertTools.IsGreaterThanFiveNumber(dataString))
			{
				if(convertTools.isDate(dataString))
				{
					break;
				}
				else
				{
					JOptionPane.showMessageDialog(frame ,"月份或日期不在范围。");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame ,"输入日期不满足格式。");
			}
		}
		Date data = convertTools.convertToDate(dataString);
		String[] info = data.toString().split(" ");
		System.out.println(info[0]);
	}
}