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
	cout << "1000以内共有" << n << "个素数。" << endl;
}

void supervise_func::narcissus()
{
	int a,b,c,d,i,j = 0;

	for(i = 100;i < 1000;i++)	//水仙花数为三位数每个数三次幂和等于本身。
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
	cout << "水仙花数共有" << j << "个" << endl;
}

void supervise_func::perfect_number()
{
	int n = 0,i,j,sum;
	for(i = 1;i < 1000;i++)	//完数为除本身因子和为本身的数。
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
	cout << "1000以内的完数有" << n << "个" << endl;
}

void supervise_func::reorder()
{
	int i,j;
	string array[10],t;
	cout << "请输入10个字符串:" << endl;
	for(i = 0;i < 10;i++)
		cin >> array[i];

	for(i = 0;i < 10;i++)	//冒泡排序法对字符串进行排序。
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
	cout << "排序后为:" << endl;
	for(i = 0;i < 10;i++)
		cout << array[i] << " ";
}

void supervise_func::classify()
{
	int i,l,flag1 = 0,flag2 = 0,flag3 = 0,flag4 = 0;
	string str;

	cout << "请输入字符串。" << endl;
	cin >> str;

	l = str.length();
	for(i = 0;i < l;i++)
	{
		string s(str,i,1);

		if(s >= "0" && s <= "9")	//字符符合条件的标记加一，然后输出。下同。
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
	cout << "该字符串中有数字" << flag1 << "个，有大写字母" << flag2 << "个，有小写字母" << flag3 << "个，有符号、空格" << flag4 << "个。" << endl;
}