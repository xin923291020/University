#include"Fuction.h"

void main()
{
	int number = -1,cost = 1;//��ʼ��������number�����û����룬cost�������ô泵��λʱ��ķ��á�
	parkinglot p;//����ջp
	LinkQueue Q;//��������Q
	InitStack(p);//��ʼ��ջp
	InitQueue(Q);//��ʼ������Q
	while(number != 0)
	{
		cout << "0.�˳�  1.�泵  2.ȡ��  3.�鿴  4.����" << endl;
		cin >> number;
		if(number == 1)
		{
			CarIn(p,Q);//���Ľ�ջ�������
		}
		if(number == 2)
		{
			CarOut(p,cost,Q);//���ĳ�ջ����г���ջ
			system("pause");
		}
		if(number == 3)
		{
			Display(p,Q);//�����ǰջ�Ͷ��д泵���
			system("pause");
		}
		if(number == 4)
		{
			CostSet(cost);//��������
		}
		system("CLS");
	}
}