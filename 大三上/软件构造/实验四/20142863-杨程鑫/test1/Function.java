package test1;

public class Function
{
	char lookhead = ' ';
	String Words = "";
	String Result = "";
	int index = 0;
	public Function(String words)
	{
		Words = words;
	}
	public char Next()
	{
		index++;
		return Words.charAt(index);
	}
	public void Match(char t)
	{
		Result += t;
		System.out.println("·ÖÎö´®" + Result + "·ÖÎö×Ö·û£º" + t + "Ê£Óà´®£º" + Words.substring(index + 1, Words.length()));
		lookhead = Next();
	}
	public void E()
	{
		lookhead = Words.charAt(0);
		T();G();
	}
	public void G()
	{
		if(lookhead == '+')
		{
			Match('+');
			T();
			G();
		}
		else if(lookhead == '-')
		{
			Match('-');
			T();
			G();
		}
	}
	public void T()
	{
		F();S();
	}
	public void S()
	{
		if(lookhead == '*')
		{
			Match('*');
			F();
			S();
		}
		else if(lookhead == '/')
		{
			Match('/');
			F();
			S();
		}
	}
	public void F()
	{
		if(lookhead == 'i')
		{
			Match('i');
		}
		else if(lookhead == '(')
		{
			Match('(');
			E();
			if(lookhead == ')')
			{
				Match(')');
			}
			else
			{
				Error();
			}
		}
		else
		{
			Error();
		}
	}
	public void Error()
	{
		System.out.println("Error!");
	}
	public static void main(String[] args)
	{
		Function F = new Function("i*(i+i)#");
		F.E();
	}
}