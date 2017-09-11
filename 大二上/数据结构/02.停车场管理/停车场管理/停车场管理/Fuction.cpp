#include "Fuction.h"

void CarIn(parkinglot &p,LinkQueue &Q)
{
	car newcar;
	cout << "请输入进车的车牌号和时间" << endl;
	cin >> newcar.str >> newcar.time;
	if(p.top - p.base == p.stacksize)
	{
		cout << "停车场已满，车进队列" << endl;
		EnQueue(Q,newcar);//如果栈满，车进队列
	}
	else
	{
		Push(p,newcar);//否则车进栈
		cout << "进站车的在停车场的位置为" << (p.top - p.base) << endl;
	}
	system("pause");
}

int ComputeCost(int time,int nowtime,int cost)
{
	return cost*(nowtime - time);
}

void PopToOther(parkinglot &p_reset,parkinglot &p,string str)
{
	car outcar = GetTop(p);
	while(str != outcar.str)
	{
		Push(p_reset,Pop(p));
		outcar = GetTop(p);
	}
}

void OtherToPop(parkinglot &p_reset,parkinglot &p)
{
	Push(p,Pop(p_reset));
}

void CarOut(parkinglot &p,int cost,LinkQueue &Q)
{
	parkinglot p_reset;//声明复位栈p_reset
	InitStack(p_reset);//复位栈p_reset的初始化
	int nowtime;string str;
	cout << "请输入需要出站车的车牌号:" << endl;
	cin >> str;
	PopToOther(p_reset,p,str);//将栈中需要让位的车放入复位栈
	car outcar = GetTop(p);//得到此时，也就是即将出栈车的信息，用于输出
	while(1)
	{
		cout << "请输入当前时间" << endl;
		cin >> nowtime;
		if(nowtime < outcar.time)
		{
			cout << "离去时间小于到达时间，请重新输入。" << endl;
		}
		else break;
	}
	cout << "出站车的车牌号为" << outcar.str << endl;
	cout << "出站车的停车时间为" << nowtime - outcar.time << endl;
	cout << "所需费用为";
	if(cost == 1)
	{
		cout << "（默认价格为1/时）" ;
	}
	cout << ComputeCost(outcar.time,nowtime,cost) << endl;//计算费用并输出
	Pop(p);//出栈车出栈
	OtherToPop(p_reset,p);//让位的车从复位栈返回栈
	QueueToStack(p,Q);//队列中有车，栈每有空位队列出队进栈
}

int Display(parkinglot p,LinkQueue Q)
{
	cout << "停车场存车信息为:";
	if(p.top == p.base)
	{
		cout << "空" << endl;
	}
	else
	{
		while(p.top != p.base)
		{
			cout << "(" << p.base->str << "," << p.base->time << ")";
			p.base++;
		}
	}
	cout << endl << "便道存车信息为:";
	if(Q.front == Q.rear)
	{
		cout << "空" << endl;
		return 0;
	}
	QueuePtr q = Q.front;
	while(1)
	{
		if(q != Q.rear)
		{
			cout << "(" << q->next->str << "," <<q->next->time << ")";
			q = q->next;
		}
		else
		{
			break;
		}
	}
	return 0;
}

void CostSet(int &cost)
{
	cout << "请输入单位时间收取的费用:" << endl;
	cin >> cost;
}

void QueueToStack(parkinglot &p,LinkQueue &Q)
{
	if(Q.front != Q.rear)
	{
		Push(p,DeQueue(Q));
	}
}