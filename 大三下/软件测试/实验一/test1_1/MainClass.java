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
			dataString = JOptionPane.showInputDialog("����������,(00010101)");
			if(dataString == null)
			{
				System.exit(0);
			}
			if(dataString.length() != 8)
			{
				JOptionPane.showMessageDialog(frame ,"�������ڳ���ӦΪ8��");
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
					JOptionPane.showMessageDialog(frame ,"�·ݻ����ڲ��ڷ�Χ��");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(frame ,"�������ڲ������ʽ��");
			}
		}
		Date data = convertTools.convertToDate(dataString);
		String[] info = data.toString().split(" ");
		System.out.println(info[0]);
	}
}