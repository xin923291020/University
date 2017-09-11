#include "Fuction.h"

void CarIn(parkinglot &p,LinkQueue &Q)
{
	car newcar;
	cout << "����������ĳ��ƺź�ʱ��" << endl;
	cin >> newcar.str >> newcar.time;
	if(p.top - p.base == p.stacksize)
	{
		cout << "ͣ������������������" << endl;
		EnQueue(Q,newcar);//���ջ������������
	}
	else
	{
		Push(p,newcar);//���򳵽�ջ
		cout << "��վ������ͣ������λ��Ϊ" << (p.top - p.base) << endl;
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
	parkinglot p_reset;//������λջp_reset
	InitStack(p_reset);//��λջp_reset�ĳ�ʼ��
	int nowtime;string str;
	cout << "��������Ҫ��վ���ĳ��ƺ�:" << endl;
	cin >> str;
	PopToOther(p_reset,p,str);//��ջ����Ҫ��λ�ĳ����븴λջ
	car outcar = GetTop(p);//�õ���ʱ��Ҳ���Ǽ�����ջ������Ϣ���������
	while(1)
	{
		cout << "�����뵱ǰʱ��" << endl;
		cin >> nowtime;
		if(nowtime < outcar.time)
		{
			cout << "��ȥʱ��С�ڵ���ʱ�䣬���������롣" << endl;
		}
		else break;
	}
	cout << "��վ���ĳ��ƺ�Ϊ" << outcar.str << endl;
	cout << "��վ����ͣ��ʱ��Ϊ" << nowtime - outcar.time << endl;
	cout << "�������Ϊ";
	if(cost == 1)
	{
		cout << "��Ĭ�ϼ۸�Ϊ1/ʱ��" ;
	}
	cout << ComputeCost(outcar.time,nowtime,cost) << endl;//������ò����
	Pop(p);//��ջ����ջ
	OtherToPop(p_reset,p);//��λ�ĳ��Ӹ�λջ����ջ
	QueueToStack(p,Q);//�������г���ջÿ�п�λ���г��ӽ�ջ
}

int Display(parkinglot p,LinkQueue Q)
{
	cout << "ͣ�����泵��ϢΪ:";
	if(p.top == p.base)
	{
		cout << "��" << endl;
	}
	else
	{
		while(p.top != p.base)
		{
			cout << "(" << p.base->str << "," << p.base->time << ")";
			p.base++;
		}
	}
	cout << endl << "����泵��ϢΪ:";
	if(Q.front == Q.rear)
	{
		cout << "��" << endl;
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
	cout << "�����뵥λʱ����ȡ�ķ���:" << endl;
	cin >> cost;
}

void QueueToStack(parkinglot &p,LinkQueue &Q)
{
	if(Q.front != Q.rear)
	{
		Push(p,DeQueue(Q));
	}
}