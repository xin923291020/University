package test1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class SonFrame extends JFrame
{
	static SonFrame frame = null;
	public SonFrame(){}
	public static SonFrame getSonFrame()
	{
		if(frame == null)
		{
			frame = new SonFrame();
			frame.addWindowListener(new WindowAdapter()
			{
				@SuppressWarnings("static-access")
				@Override
				public void windowClosing(WindowEvent e)
				{
					SonFrame.this.frame.dispose();
				}
			});
			frame.setTitle("\u5B50\u7A97\u4F53");
			frame.setBounds(100, 100, 250, 180);
		}
		else
		{
			Object option[]={"ȷ��"};
			JOptionPane.showOptionDialog(null,"�һ����Ǹ��Ӵ��塣","��ʾ",
					JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
		}
		return frame;
	}
}
