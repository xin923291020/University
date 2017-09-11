#include"morra.h"

void main()
{
	int n,m,i = 1,j,k;
	morra a;

	cout << "请选择模式:1.简单模式 2.噩梦模式" << endl;//简单模式为正常游戏.噩梦模式电脑不会输。
	cin >> j;

	while(i == 1)
	{
		cout << "请出拳.(1.石头 2.剪刀 3.布)" << endl;
		cin >> n;

		if(n != 1 && n != 2 && n != 3)
		{
			cout << "输入非法，请重新输入。" << endl;
			cin >> n;
		}

		m = a.produce_number();
		if(j == 1)
		{
			a.compare(n,m);//根据n与m的关系判断胜负。
		}
		if(j == 2)
		{
			k = a.cheat(n,m);//如果电脑输，改变随机数，让电脑赢。
			if(k == 1)
			{
				if(m == 1 || m == 2)
				{
					m++;
				}
				else
				{
					m = 1;
				}
			}
			a.compare(n,m);
		}
		cout << "0.退出游戏 1.继续游戏" << endl;
		cin >> i;
		if(i != 1)
		{
			break;
		}
	}
	a.display();
}