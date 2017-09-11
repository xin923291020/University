#include"number.h"

number::number(string n)	//构造函数和析构函数
{
	num = n;
}
number::~number(void)
{
}

void number::add(number A,number B)
{
	string a[100],b[100];
	int t = A.num.length(),i,n = B.num.length(),a1[100],b1[100],c1[101];
	for(i = 0;i < 100;i++)
	{
		a1[i] = 0;
		b1[i] = 0;
		c1[i] = 0;
	}	//变量的定义和赋初值。
	for(i = 0;i < t;i++)
	{
		a[i] = A.num.at(t - i - 1);
		a1[i] = atoi(a[i].c_str());
	}

	for(i = 0;i < n;i++)
	{
		b[i] = B.num.at(n - i - 1);
		b1[i] = atoi(b[i].c_str());
	}	//将string中的数字拆分为单个数字，并转化为int格式。
	

	for(i = 0;i < 100;i++)
	{
		c1[i] = a1[i] + b1[i];
		if(c1[i] >= 10)
		{
			a1[i+1] += 1;
		}
		c1[i] = c1[i] % 10;
	}	//每个数相加，超过10向前一位进一。

	if(n > t)
	{
		i = t;t = n;n = i;
	}
	cout << "A+B=";
	if(c1[t] != 0)
	{
		cout << c1[t];
	}	//如果两个数相加结果比两个数多一位。
	for(i = t-1;i >= 0;i--)
	{
		cout << c1[i];
	}	//将每个数字依次输出。
}

void number::sub(number A,number B)
{
	string a[100],b[100];
	int t = A.num.length(),i,j,n = B.num.length(),a1[100],b1[100],c1[101];
	for(i = 0;i < 100;i++)
	{
		a1[i] = 0;
		b1[i] = 0;
		c1[i] = 0;
	}
	for(i = 0;i < t;i++)
	{
		a[i] = A.num.at(t - i - 1);
		a1[i] = atoi(a[i].c_str());
	}

	for(i = 0;i < n;i++)
	{
		b[i] = B.num.at(n - i - 1);
		b1[i] = atoi(b[i].c_str());
	}	//同上。

	for(i = 0;i < 100;i++)
	{
		if(a1[i] >= b1[i])
		{
			c1[i] = a1[i] - b1[i];
		}
		if(a1[i] < b1[i])
		{
			c1[i] = a1[i] + 10 - b1[i];
			a1[i + 1] -= 1;
		}
	}	//两个数前者较大直接减。不够则加十，前一位减一。

	if(n > t)
	{
		i = t;t = n;n = i;
	}
	cout << endl << "A-B=:";
	for(i = t-1;i >= 0;i--)
	{
		if(c1[i] == 0)
		{
			continue;
		}	//前几项若为零，不输出。
		else
		{
			for(j = i;j >= 0;j--)
			{
				cout << c1[j];
			}
		}
		break;	//由j代替i执行循环。i循环无用，直接break。
	}
	cout << endl;
}