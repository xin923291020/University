#include "supervise_func.h"

supervise_func::supervise_func(void)
{
}

supervise_func::~supervise_func(void)
{
}

void supervise_func::prime_number()
{
	int n = 0,i,j,k = 0,temp,flag;
	for(i = 3;i < 1000;i++)
	{
		temp = int(sqrt(double(i)));
		flag = 1;
		for(j = 2;j <= temp;j++)
		{
			if(i % j == 0)
				flag = 0;
		}
		if(flag)
		{
			k++;n++;
			cout << i << " ";
			if(k == 10)
			{
				k = 0;
				cout << endl;
			}
		}
	}
	cout << endl;
	cout << "1000���ڹ���" << n << "��������" << endl;
}

void supervise_func::narcissus()
{
	int a,b,c,d,i,j = 0;

	for(i = 100;i < 1000;i++)	//ˮ�ɻ���Ϊ��λ��ÿ���������ݺ͵��ڱ���
	{
		a = i / 100;
		b = i % 100;
		c = b / 10;
		d = b % 10;

		if(i == (a * a * a) + (c * c * c) + (d * d * d))
		{
			j++;
			cout << i << " ";
		}
	}
	cout << endl;
	cout << "ˮ�ɻ�������" << j << "��" << endl;
}

void supervise_func::perfect_number()
{
	int n = 0,i,j,sum;
	for(i = 1;i < 1000;i++)	//����Ϊ���������Ӻ�Ϊ���������
	{
		sum = 0;
		for(j = 1;j < i;j++)
		{
			if(i % j == 0)
				sum += j;
		}
		if(sum == i)
		{
			n++;
			cout << i << " ";
		}
	}
	cout << endl;
	cout << "1000���ڵ�������" << n << "��" << endl;
}

void supervise_func::reorder()
{
	int i,j;
	string array[10],t;
	cout << "������10���ַ���:" << endl;
	for(i = 0;i < 10;i++)
		cin >> array[i];

	for(i = 0;i < 10;i++)	//ð�����򷨶��ַ�����������
	{
		for(j = 0;j < 9 - i;j++)
		{
			if(array[j] > array[j + 1])
			{
				t = array[j];
				array[j] = array[j + 1];
				array[j + 1] = t;
			}
		}
	}
	cout << "�����Ϊ:" << endl;
	for(i = 0;i < 10;i++)
		cout << array[i] << " ";
}

void supervise_func::classify()
{
	int i,l,flag1 = 0,flag2 = 0,flag3 = 0,flag4 = 0;
	string str;

	cout << "�������ַ�����" << endl;
	cin >> str;

	l = str.length();
	for(i = 0;i < l;i++)
	{
		string s(str,i,1);

		if(s >= "0" && s <= "9")	//�ַ����������ı�Ǽ�һ��Ȼ���������ͬ��
		{
			flag1++;
		}
		if(s >= "A" && s <= "Z")
		{
			flag2++;
		}
		if(s >= "a" && s <= "z")
		{
			flag3++;
		}
	}
	flag4 = l - flag1 - flag2 - flag3;
	cout << "���ַ�����������" << flag1 << "�����д�д��ĸ" << flag2 << "������Сд��ĸ" << flag3 << "�����з��š��ո�" << flag4 << "����" << endl;
}