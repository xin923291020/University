package identityWords;

public class IdentityWords
{
	static int statement = -1;
	static String outputWords = "";
	public void getIdentityWords(String Words)
	{
		String[] ReservedWords  = {"if","int","for","while","do","return","break","continue"};
		//String Words = JOptionPane.showInputDialog("请输入需要识别的单词。");
		StringNextToken a = new StringNextToken();
		char LookHead = ' ';
		for(int i = 0;i < Words.length();i++)
		{
			LookHead = a.getLookHead(Words,i);
			if(statement == -1 && (LookHead == '+' || LookHead == '-' || LookHead == '*' || LookHead == '/' || LookHead == '='))
			{
				statement = 4;
				break;
			}
			else if(statement == -1 && (LookHead == ';' || LookHead == ';' || LookHead == '{' || LookHead == '}' || LookHead == '(' || LookHead == ')'))
			{
				statement = 5;
				break;
			}
			else if((LookHead >= 'a' && LookHead <= 'z') || (LookHead >= 'A' && LookHead <= 'Z'))
			{
				statement = 1;
			}
			else if(statement == 2 || (statement == 1 && (LookHead >= '0' && LookHead <= '9')))
			{
				statement = 2;
			}
			else if(LookHead >= '0' && LookHead <= '9')
			{
				statement = 3;
			}
		}
		switch(statement)
		{
			case 1:if(IsReservedWords(Words,ReservedWords)){break;}
			case 2:outputWords += "标识符(" + statement + "," + Words + ")\n";break;
			case 3:outputWords += "常数(" + statement + "," + Words + ")\n";break;
			case 4:outputWords += "运算符(" + statement + "," + Words + ")\n";break;
			case 5:outputWords += "分隔符(" + statement + "," + Words + ")\n";break;
			default:outputWords += "未识别(" + 6 + "," + Words + ")\n";break;
		}
	}
	public static boolean IsReservedWords(String Words,String []ReservedWords)
	{
		for(int i = 0; i < ReservedWords.length;i++)
		{
			if(Words.equals(ReservedWords[i]))
			{
				outputWords += "保留字(" + statement + "," + Words + ")\n";
				return true;
			}
		}
		statement = 2;
		return false;
	}
}