package test1;

public class SLRTable
{
	public int Row = 12;
	public int Col = 9;
	String[][] SLR = new String[Row][Col];
	public SLRTable()
	{
		for(int i = 0;i < Row;i++)
		{
			for(int j = 0;j < Col;j++)
			{
				SLR[i][j] = "";
			}
		}
		SLR[0][0] = "S5";SLR[0][3] = "S4";SLR[0][6] = "1";SLR[0][7] = "2";SLR[0][8] = "3";
		SLR[1][1] = "S6";SLR[1][5] = "acc";
		SLR[2][1] = "r2";SLR[2][2] = "S7";SLR[2][4] = "r2";SLR[2][5] = "r2";
		SLR[3][1] = "r4";SLR[3][2] = "r4";SLR[3][4] = "r4";SLR[3][5] = "r4";
		SLR[4][0] = "S5";SLR[4][3] = "S4";SLR[4][6] = "8";SLR[4][7] = "2";SLR[4][8] = "3";
		SLR[5][1] = "r6";SLR[5][2] = "r6";SLR[5][4] = "r6";SLR[5][5] = "r6";
		SLR[6][0] = "S5";SLR[6][3] = "S4";SLR[6][7] = "9";SLR[6][8] = "3";
		SLR[7][0] = "S5";SLR[7][3] = "S4";SLR[7][8] = "A";
		SLR[8][1] = "S6";SLR[8][4] = "S4";
		SLR[9][1] = "r1";SLR[9][2] = "S7";SLR[9][4] = "r1";SLR[9][5] = "r1";
		SLR[10][1] = "r3";SLR[10][2] = "r3";SLR[10][4] = "r3";SLR[10][5] = "r3";
		SLR[11][1] = "r5";SLR[11][2] = "r5";SLR[11][4] = "r5";SLR[11][5] = "r5";
	}
	public int GetCol(char c)
	{
		if(c == 'i')
		{
			return 0;
		}
		else if(c == '+')
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
		else if(c == '#')
		{
			return 5;
		}
		else if(c == 'E')
		{
			return 6;
		}
		else if(c == 'T')
		{
			return 7;
		}
		else
		{
			return 8;
		}
	}
	public int GetRow(char c)
	{
		if(c == '0')
		{
			return 0;
		}
		else if(c == '1')
		{
			return 1;
		}
		else if(c == '2')
		{
			return 2;
		}
		else if(c == '3')
		{
			return 3;
		}
		else if(c == '4')
		{
			return 4;
		}
		else if(c == '5')
		{
			return 5;
		}
		else if(c == '6')
		{
			return 6;
		}
		else if(c == '7')
		{
			return 7;
		}
		else if(c == '8')
		{
			return 8;
		}
		else if(c == '9')
		{
			return 9;
		}
		else if(c == 'A')
		{
			return 10;
		}
		else if(c == 'B')
		{
			return 11;
		}
		return 'C';
	}
}