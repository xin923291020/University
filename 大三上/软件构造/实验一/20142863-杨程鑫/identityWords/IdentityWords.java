package identityWords;

public class IdentityWords
{
	static int statement = -1;
	static String outputWords = "";
	public void getIdentityWords(String Words)
	{
		String[] ReservedWords  = {"if","int","for","while","do","return","break","continue"};
		//String Words = JOptionPane.showInputDialog("��������Ҫʶ��ĵ��ʡ�");
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
			case 2:outputWords += "��ʶ��(" + statement + "," + Words + ")\n";break;
			case 3:outputWords += "����(" + statement + "," + Words + ")\n";break;
			case 4:outputWords += "�����(" + statement + "," + Words + ")\n";break;
			case 5:outputWords += "�ָ���(" + statement + "," + Words + ")\n";break;
			default:outputWords += "δʶ��(" + 6 + "," + Words + ")\n";break;
		}
	}
	public static boolean IsReservedWords(String Words,String []ReservedWords)
	{
		for(int i = 0; i < ReservedWords.length;i++)
		{
			if(Words.equals(ReservedWords[i]))
			{
				outputWords += "������(" + statement + "," + Words + ")\n";
				return true;
			}
		}
		statement = 2;
		return false;
	}
}