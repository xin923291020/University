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
		cout << "��ҳ�ʯͷ,���Գ����������ʤ��" << endl;
		x++;
	}
	if(n == 2 && m == 3)
	{
		cout << "��ҳ�����,���Գ��������ʤ��" << endl;
		x++;
	}
	if(n == 3 && m == 1)
	{
		cout << "��ҳ���,���Գ�ʯͷ�����ʤ��" << endl;
		x++;
	}
	if(n == 1 && m == 3)
	{
		cout << "��ҳ�ʯͷ,���Գ���������ʤ��" << endl;
		y++;
	}
	if(n == 2 && m == 1)
	{
		cout << "��ҳ�����,���Գ�ʯͷ������ʤ��" << endl;
		y++;
	}
	if(n == 3 && m == 2)
	{
		cout << "��ҳ���,���Գ�����������ʤ��" << endl;
		y++;
	}
	if(n == 1 && m == 1)
	{
		cout << "��ң����Ծ���ʯͷ,ƽ��" << endl;
		z++;
	}
	if(n == 2 && m == 2)
	{
		cout << "��ң����Ծ�������,ƽ��" << endl;
		z++;
	}
	if(n == 3 && m == 3)
	{
		cout << "��ң����Ծ�����,ƽ��" << endl;
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
	cout << "���Ӯ��" << x << "�֡�" << endl;
	cout << "����Ӯ��" << y << "�֡�" << endl;
	cout << "ƽ��" << z << "�֡�" << endl;
	cout << "һ������" << x + y + z << "�֡�" << endl;
}