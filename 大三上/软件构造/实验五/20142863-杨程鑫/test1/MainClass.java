package test1;

import java.util.ArrayList;

public class MainClass
{
	public static void main(String[] args)
	{
		ArrayList<String> GrammarList = new ArrayList<String>();
		String[] Grammar = {"E->T+E T","T->P*T P","P->(E) i"};
		for(int i = 0;i < Grammar.length;i++)
		{
			String[] G = Grammar[i].split("->");
			String Start = G[0];
			String[] Finish = G[1].split(" ");
			for(int j = 0;j < Finish.length;j++)
			{
				GrammarList.add(Start + "->" + Finish[j]);
			}
		}
		System.out.println("整合后的算法。");
		for(int i = 0;i < GrammarList.size();i++)
		{
			System.out.println(GrammarList.get(i));
		}
		System.out.println();
		System.out.println("FirstVT集合");
		//初始化FirstVT集，FirstVTHead用于储存B的FirstVT集是否是A的FirstVT集的子集。
		ArrayList<String> FirstVT = new ArrayList<String>();
		ArrayList<String> FirstVTHead = new ArrayList<String>();
		for(int i = 0;i < GrammarList.size();i++)
		{
			if(FirstVT.size() == 0)
			{
				FirstVT.add(GrammarList.get(i).charAt(0) + ":");
				FirstVTHead.add(GrammarList.get(i).charAt(0) + "");
			}
			else
			{
				if(!FirstVTHead.contains(GrammarList.get(i).charAt(0) + ""))
				{
					FirstVT.add(GrammarList.get(i).charAt(0) + ":");
					FirstVTHead.add(GrammarList.get(i).charAt(0) + "");
				}
			}
		}
		//求出一次推导结果的FirstVT集。
		for(int i = 0;i < FirstVTHead.size();i++)
		{
			for(int j = 0;j < GrammarList.size();j++)
			{
				if((GrammarList.get(j).charAt(0) + "").equals(FirstVTHead.get(i)))
				{
					for(int k = 3;k < GrammarList.get(j).length();k++)
					{
						if(!IsUpper(GrammarList.get(j).charAt(k)))
						{
							FirstVT.set(i,FirstVT.get(i) + GrammarList.get(j).charAt(k));
							break;
						}
					}
				}
			}
		}
		//求出哪些式子可以使FirstVT集增加。
		ArrayList<String> FirstVTPK = new ArrayList<String>();
		for(int i = 0;i < GrammarList.size();i++)
		{
			boolean flag = true;
			for(int j = 3;j < GrammarList.get(i).length();j++)
			{
				if(!IsUpper((GrammarList.get(i).charAt(j))))
				{
					flag = false;
				}
			}
			if(flag)
			{
				for(int k = 0;k < FirstVTHead.size();k++)
				{
					if((GrammarList.get(i).charAt(0) + "").equals(FirstVTHead.get(k)))
					{
						FirstVTPK.add(GrammarList.get(i));
						FirstVTHead.set(k,FirstVTHead.get(k) + "0");
					}
				}
			}
		}
		//根据PK求出所有FirstVT集。
		while(FirstVTPK.size() != 0)
		{
			for(int i = 0;i < FirstVTHead.size();i++)
			{
				if(FirstVTHead.get(i).length() == 1)
				{
					for(int j = 0;j < FirstVTPK.size();j++)
					{
						if((FirstVTPK.get(j).charAt(3) + "").equals(FirstVTHead.get(i)))
						{
							for(int k = 0;k < FirstVTHead.size();k++)
							{
								if((FirstVTPK.get(j).charAt(0) + "").equals((FirstVTHead.get(k).charAt(0) + "")))
								{
									FirstVT.set(k, FirstVT.get(k) + FirstVT.get(i).substring(2, FirstVT.get(i).length()));
									FirstVTHead.set(k,FirstVTHead.get(k).charAt(0) + "");
									FirstVTHead.set(i,FirstVTHead.get(i).charAt(0) + "0");
								}
							}
							FirstVTPK.remove(FirstVTPK.get(j));
						}
					}
				}
			}
		}
		for(int i = 0;i < FirstVT.size();i++)
		{
			System.out.println(FirstVT.get(i));
		}
		System.out.println();
		System.out.println("LastVT集合");
		//初始化LastVT集，LastVTHead用于储存B的LastVT集是否是A的LastVT集的子集。
		ArrayList<String> LastVT = new ArrayList<String>();
		ArrayList<String> LastVTHead = new ArrayList<String>();
		for(int i = 0;i < GrammarList.size();i++)
		{
			if(LastVT.size() == 0)
			{
				LastVT.add(GrammarList.get(i).charAt(0) + ":");
				LastVTHead.add(GrammarList.get(i).charAt(0) + "");
			}
			else
			{
				if(!LastVTHead.contains(GrammarList.get(i).charAt(0) + ""))
				{
					LastVT.add(GrammarList.get(i).charAt(0) + ":");
					LastVTHead.add(GrammarList.get(i).charAt(0) + "");
				}
			}
		}
		//求出一次推导结果的LastVT集。
		for(int i = 0;i < LastVTHead.size();i++)
		{
			for(int j = 0;j < GrammarList.size();j++)
			{
				if((GrammarList.get(j).charAt(0) + "").equals(LastVTHead.get(i)))
				{
					for(int k = GrammarList.get(j).length() - 1;k >= 3;k--)
					{
						if(!IsUpper((GrammarList.get(j).charAt(k))))
						{
							LastVT.set(i,LastVT.get(i) + GrammarList.get(j).charAt(k));
							break;
						}
					}
				}
			}
		}
		//求出哪些式子可以使LastVT集增加。
		ArrayList<String> LastVTPK = new ArrayList<String>();
		for(int i = 0;i < GrammarList.size();i++)
		{
			boolean flag = true;
			for(int j = 3;j < GrammarList.get(i).length();j++)
			{
				if(!IsUpper((GrammarList.get(i).charAt(j))))
				{
					flag = false;
				}
			}
			if(flag)
			{
				for(int k = 0;k < LastVTHead.size();k++)
				{
					if((GrammarList.get(i).charAt(0) + "").equals(LastVTHead.get(k)))
					{
						LastVTPK.add(GrammarList.get(i));
						LastVTHead.set(k,LastVTHead.get(k) + "0");
					}
				}
			}
		}
		//根据PK求出所有LastVT集。
		while(LastVTPK.size() != 0)
		{
			for(int i = 0;i < LastVTHead.size();i++)
			{
				if(LastVTHead.get(i).length() == 1)
				{
					for(int j = 0;j < LastVTPK.size();j++)
					{
						if((LastVTPK.get(j).charAt(3) + "").equals(LastVTHead.get(i)))
						{
							for(int k = 0;k < LastVTHead.size();k++)
							{
								if((LastVTPK.get(j).charAt(0) + "").equals((LastVTHead.get(k).charAt(0) + "")))
								{
									LastVT.set(k, LastVT.get(k) + LastVT.get(i).substring(2, FirstVT.get(i).length()));
									LastVTHead.set(k,LastVTHead.get(k).charAt(0) + "");
									LastVTHead.set(i,LastVTHead.get(i).charAt(0) + "0");
								}
							}
							LastVTPK.remove(LastVTPK.get(j));
						}
					}
				}
			}
		}
		for(int i = 0;i < LastVT.size();i++)
		{
			System.out.println(LastVT.get(i));
		}
		
		GrammarList.add("F->#E#");
		System.out.println();
		System.out.println("拓展后的文法");
		for(int i = 0;i < GrammarList.size();i++)
		{
			System.out.println(GrammarList.get(i));
		}
		char[][] Form = new char[7][7];
		for(int i = 0;i < 7;i++)
		{
			for(int j = 0;j < 7;j++)
			{
				Form[i][j] = ' ';
			}
		}
		Form[1][0] = '+';Form[0][1] = '+';
		Form[2][0] = '*';Form[0][2] = '*';
		Form[3][0] = '(';Form[0][3] = '(';
		Form[4][0] = ')';Form[0][4] = ')';
		Form[5][0] = 'i';Form[0][5] = 'i';
		Form[6][0] = '#';Form[0][6] = '#';
		for(int i = 0;i < GrammarList.size();i++)
		{
			for(int j = 4;j < GrammarList.get(i).length();j++)
			{
				if(IsUpper(GrammarList.get(i).charAt(j)) && !IsUpper(GrammarList.get(i).charAt(j - 1)))
				{
					for(int k = 0;k < FirstVT.size();k++)
					{
						if((GrammarList.get(i).charAt(j) + "").equals((FirstVT.get(k).charAt(0) + "")))
						{
							//System.out.println(GrammarList.get(i).charAt(j - 1) + "" + GrammarList.get(i).charAt(j));
							for(int l = 2;l < FirstVT.get(k).length();l++)
							{
								Form[GetPlace(GrammarList.get(i).charAt(j - 1))][GetPlace(FirstVT.get(k).charAt(l))] = '<';
							}
						}
					}
				}
			}
		}
		for(int i = 0;i < GrammarList.size();i++)
		{
			for(int j = 4;j < GrammarList.get(i).length();j++)
			{
				if(IsUpper(GrammarList.get(i).charAt(j - 1)) && !IsUpper(GrammarList.get(i).charAt(j)))
				{
					for(int k = 0;k < LastVT.size();k++)
					{
						if((GrammarList.get(i).charAt(j - 1) + "").equals((LastVT.get(k).charAt(0) + "")))
						{
							//System.out.println(GrammarList.get(i).charAt(j - 1) + "" + GrammarList.get(i).charAt(j));
							for(int l = 2;l < LastVT.get(k).length();l++)
							{
								Form[GetPlace(LastVT.get(k).charAt(l))][GetPlace(GrammarList.get(i).charAt(j))] = '>';
							}
						}
					}
				}
			}
		}
		ArrayList<String> Equals = new ArrayList<String>();
		for(int i = 0;i < GrammarList.size();i++)
		{
			String Sign = "";
			for(int j = 3;j < GrammarList.get(i).length();j++)
			{
				if(!IsUpper(GrammarList.get(i).charAt(j)))
				{
					Sign += GrammarList.get(i).charAt(j);
				}
			}
			Equals.add(Sign);
		}
		for(int i = 0;i < Equals.size();i++)
		{
			if(Equals.get(i).length() == 2)
			{
				Form[GetPlace(Equals.get(i).charAt(0))][GetPlace(Equals.get(i).charAt(1))] = '=';
			}
		}

		System.out.println();
		System.out.println("算符优先分析表");
		for(int i = 0;i < 7;i++)
		{
			for(int j = 0;j < 7;j++)
			{
				System.out.print(Form[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("开始识别#i*i+i#");
		String Words = "#i*i+i#";
		String HadIdentification = "";
		int Place = 0;
		while(!Words.substring(Place).equals(""))
		{
			if(HadIdentification.length() == 0)
			{
				HadIdentification += Words.charAt(Place);
				Place++;
			}
			else
			{
				System.out.println(HadIdentification + "    " + Words.substring(Place));
				int time = 1;
				while(IsUpper(HadIdentification.charAt(HadIdentification.length() - time)))
				{
					time++;
				}
				char Symbol = Match(Form,HadIdentification.charAt(HadIdentification.length() - time),Words.charAt(Place));
				if(Symbol == '<')
				{
					HadIdentification += Words.charAt(Place);
					Place++;
				}
				else if(Symbol == '>')
				{
					HadIdentification = GuiYue(GrammarList,HadIdentification);
				}
				else if(Symbol == '=')
				{
					HadIdentification += Words.charAt(Place);
					Place++;
				}
			}
		}
	}
	public static boolean IsUpper(char c)
	{
		if(c > 'A' && c < 'Z')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int GetPlace(char c)
	{
		if(c == '+')
		{
			return 1;
		}
		else if(c == '*')
		{
			return 2;
		}
		else if(c == '(')
		{
			return 3;
		}
		else if(c == ')')
		{
			return 4;
		}
		else if(c == 'i')
		{
			return 5;
		}
		else
		{
			return 6;
		}
	}
	public static char Match(char[][] form,char c1,char c2)
	{
		return form[GetPlace(c1)][GetPlace(c2)];
	}
	public static String GuiYue(ArrayList<String> GrammarList,String Words)
	{
		int Place = 1; 
		while(true)
		{
			for(int i = 0;i < GrammarList.size();i++)
			{
				if(GrammarList.get(i).substring(3).equals(Words.substring(Place,Words.length())))
				{
					Words = Words.substring(0,Place) + GrammarList.get(i).charAt(0);
					return Words;
				}
			}
			Place++;
		}
	}
}