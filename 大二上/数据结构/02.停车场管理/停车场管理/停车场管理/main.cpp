#include"Fuction.h"

void main()
{
	int number = -1,cost = 1;//初始化变量，number用于用户输入，cost用于设置存车单位时间的费用。
	parkinglot p;//声明栈p
	LinkQueue Q;//声明队列Q
	InitStack(p);//初始化栈p
	InitQueue(Q);//初始化队列Q
	while(number != 0)
	{
		cout << "0.退出  1.存车  2.取车  3.查看  4.设置" << endl;
		cin >> number;
		if(number == 1)
		{
			CarIn(p,Q);//车的进栈或进队列
		}
		if(number == 2)
		{
			CarOut(p,cost,Q);//车的出栈或队列车入栈
			system("pause");
		}
		if(number == 3)
		{
			Display(p,Q);//输出当前栈和队列存车情况
			system("pause");
		}
		if(number == 4)
		{
			CostSet(cost);//费用设置
		}
		system("CLS");
	}
}