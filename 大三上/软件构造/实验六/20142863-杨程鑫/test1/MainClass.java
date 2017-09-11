package test1;

import java.util.ArrayList;

public class MainClass
{
	static ArrayList<String> Grammar = new ArrayList<String>();
	public static void main(String[] args)
	{
		Grammar.add("S->E");
		Grammar.add("E->E+T");
		Grammar.add("E->T");
		Grammar.add("T->T*F");
		Grammar.add("T->F");
		Grammar.add("F->(E)");
		Grammar.add("F->i");
		SLRTable SLR = new SLRTable();
		ArrayList<Integer> StackStatus = new ArrayList<Integer>();
		StackStatus.add(0);
		String Words = "i+i*i#";
		String StackWords = "";
		int index = 0;
		while(true)
		{
			String Result = SLR.SLR[StackStatus.get(StackStatus.size() - 1)][SLR.GetCol(Words.charAt(index))];
			if(Result.equals("acc"))
			{
				System.out.println("acc");
				break;
			}
			else if(Result.length() == 0)
			{
				Result = SLR.SLR[StackStatus.get(StackStatus.size() - 1)][SLR.GetCol(StackWords.charAt(StackWords.length() - 1))];
				StackStatus.add(SLR.GetRow(Result.charAt(0)));
			}
			else if(Result.length() == 2)
			{
				if(Result.charAt(0) == 'S')
				{
					StackWords += Words.charAt(index);
					StackStatus.add(SLR.GetRow(Result.charAt(1)));
					index++;
				}
				else if(Result.charAt(0) == 'r')
				{
					StackWords = GuiYue(SLR.GetRow(Result.charAt(1)),StackWords);
					StackStatus.remove(StackStatus.size() - 1);
					if(SLR.GetRow(Result.charAt(1)) == 3 || SLR.GetRow(Result.charAt(1)) == 1)
					{
						StackStatus.remove(StackStatus.size() - 1);
					}
				}
			}
			else if(Result.length() == 1)
			{
				
			}
			System.out.print(StackWords + "    ");
			for(int i = 0;i < StackStatus.size();i++)
			{
				System.out.print(StackStatus.get(i));
			}
			System.out.println();
		}
	}
	public static String GuiYue(int place,String Words)
	{
		return Words.replace(Grammar.get(place).substring(3,Grammar.get(place).length()),Grammar.get(place).charAt(0) + "");
	}
}