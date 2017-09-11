package test1;

public class AnalysisTable
{
	private String[][] AnalysisTable = new String[5][6];
	public AnalysisTable()
	{
		for(int i = 0;i < 5;i++)
		{
			for(int j = 0;j < 6;j++)
			{
				AnalysisTable[i][j] = "null";
			}
		}
		AnalysisTable[0][0] = "CB";
		AnalysisTable[0][3] = "CB";
		AnalysisTable[1][1] = "+CB";
		AnalysisTable[1][4] = "¦Å";
		AnalysisTable[1][5] = "¦Å";
		AnalysisTable[2][0] = "ED";
		AnalysisTable[2][3] = "ED";
		AnalysisTable[3][1] = "¦Å";
		AnalysisTable[3][2] = "*ED";
		AnalysisTable[3][4] = "¦Å";
		AnalysisTable[3][5] = "¦Å";
		AnalysisTable[4][0] = "a";
		AnalysisTable[4][3] = "(A)";
	}
	public String getResult(char row,char col)
	{
		if(row == 'A' && col == 'a')
		{
			return AnalysisTable[0][0];
		}
		else if(row == 'A' && col == ')')
		{
			return AnalysisTable[0][3];
		}
		else if(row == 'B' && col == '+')
		{
			return AnalysisTable[1][1];
		}
		else if(row == 'B' && col == ')')
		{
			return AnalysisTable[1][4];
		}
		else if(row == 'B' && col == '$')
		{
			return AnalysisTable[1][5];
		}
		else if(row == 'C' && col == 'a')
		{
			return AnalysisTable[2][0];
		}
		else if(row == 'C' && col == '(')
		{
			return AnalysisTable[2][3];
		}
		else if(row == 'D' && col == '+')
		{
			return AnalysisTable[3][1];
		}
		else if(row == 'D' && col == '*')
		{
			return AnalysisTable[3][2];
		}
		else if(row == 'D' && col == ')')
		{
			return AnalysisTable[3][4];
		}
		else if(row == 'D' && col == '$')
		{
			return AnalysisTable[3][5];
		}
		else if(row == 'E' && col == 'a')
		{
			return AnalysisTable[4][0];
		}
		else if(row == 'E' && col == '$')
		{
			return AnalysisTable[4][3];
		}
		System.out.print("Î´Æ¥Åäµ½");
		System.exit(0);
		return "null";
	}
}