#include "morra.h"

morra::morra(void)
{
	x = 0;
	y = 0;
	z = 0;
}
morra::~morra(void)
{
}

int morra::produce_number()
{
	srand((unsigned)time(NULL));  
    int n = rand() % 3 + 1;

	return n;
}

void morra::compare(int n,int m)
{
	if(n == 1 && m == 2)
	{
		cout << "玩家出石头,电脑出剪刀，玩家胜。" << endl;
		x++;
	}
	if(n == 2 && m == 3)
	{
		cout << "玩家出剪刀,电脑出布，玩家胜。" << endl;
		x++;
	}
	if(n == 3 && m == 1)
	{
		cout << "玩家出布,电脑出石头，玩家胜。" << endl;
		x++;
	}
	if(n == 1 && m == 3)
	{
		cout << "玩家出石头,电脑出布，电脑胜。" << endl;
		y++;
	}
	if(n == 2 && m == 1)
	{
		cout << "玩家出剪刀,电脑出石头，电脑胜。" << endl;
		y++;
	}
	if(n == 3 && m == 2)
	{
		cout << "玩家出布,电脑出剪刀，电脑胜。" << endl;
		y++;
	}
	if(n == 1 && m == 1)
	{
		cout << "玩家，电脑均出石头,平。" << endl;
		z++;
	}
	if(n == 2 && m == 2)
	{
		cout << "玩家，电脑均出剪刀,平。" << endl;
		z++;
	}
	if(n == 3 && m == 3)
	{
		cout << "玩家，电脑均出布,平。" << endl;
		z++;
	}
}

int morra::cheat(int n,int m)
{
	int i = 0;
	if(n == 1 && m == 2 || n == 2 && m == 3 || n == 3 && m == 1)
	{
		i = 1;
	}
	return i;
}

void morra::display()
{
	cout << "玩家赢了" << x << "局。" << endl;
	cout << "电脑赢了" << y << "局。" << endl;
	cout << "平了" << z << "局。" << endl;
	cout << "一共玩了" << x + y + z << "局。" << endl;
}