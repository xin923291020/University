#include"number.h"

number::number(string n)	//���캯������������
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
	}	//�����Ķ���͸���ֵ��
	for(i = 0;i < t;i++)
	{
		a[i] = A.num.at(t - i - 1);
		a1[i] = atoi(a[i].c_str());
	}

	for(i = 0;i < n;i++)
	{
		b[i] = B.num.at(n - i - 1);
		b1[i] = atoi(b[i].c_str());
	}	//��string�е����ֲ��Ϊ�������֣���ת��Ϊint��ʽ��
	

	for(i = 0;i < 100;i++)
	{
		c1[i] = a1[i] + b1[i];
		if(c1[i] >= 10)
		{
			a1[i+1] += 1;
		}
		c1[i] = c1[i] % 10;
	}	//ÿ������ӣ�����10��ǰһλ��һ��

	if(n > t)
	{
		i = t;t = n;n = i;
	}
	cout << "A+B=";
	if(c1[t] != 0)
	{
		cout << c1[t];
	}	//�����������ӽ������������һλ��
	for(i = t-1;i >= 0;i--)
	{
		cout << c1[i];
	}	//��ÿ���������������
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
	}	//ͬ�ϡ�

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
	}	//������ǰ�߽ϴ�ֱ�Ӽ����������ʮ��ǰһλ��һ��

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
		}	//ǰ������Ϊ�㣬�������
		else
		{
			for(j = i;j >= 0;j--)
			{
				cout << c1[j];
			}
		}
		break;	//��j����iִ��ѭ����iѭ�����ã�ֱ��break��
	}
	cout << endl;
}