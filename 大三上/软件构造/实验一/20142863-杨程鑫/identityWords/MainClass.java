package identityWords;

import java.io.IOException;
/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;*/

import javax.swing.JOptionPane;

public class MainClass
{
	public static void main(String[] args) throws IOException
	{
		/*File file = new File("C:\\Users\\asus1\\Desktop\\main.txt");
		InputStreamReader read = new InputStreamReader(new FileInputStream(file));
		@SuppressWarnings("resource")
		BufferedReader BR = new BufferedReader(read);
		String TextLine = "";String Text = "";
		while(TextLine != null)
		{
			TextLine = BR.readLine();
			Text += TextLine;
		}*/
		String Text = "void main ( ) { int i = 1 ; int j = 2 }";
		IdentityWords IW = new IdentityWords();
		String Words = "";
		for(int i = 0;i < Text.length();i++)
		{
			if(Text.charAt(i) == ' ')
			{
				IW.getIdentityWords(Words);
				IdentityWords.statement = -1;
				Words = "";
			}
			else
			{
				Words += Text.charAt(i);
			}
		}
		JOptionPane.showMessageDialog(null,IdentityWords.outputWords);
	}
}