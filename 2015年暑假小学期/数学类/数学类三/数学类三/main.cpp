#include <iostream>
#define N 6000
using namespace std;

void main()
{
	int i,n = 2014,a[N];

	memset(a,0,sizeof(a));	//�������ÿһ������Ϊ0��
	a[0] = 1;

	for(int j = 2;j <= n;j++)	//��1�˵�2014��˼·��1 * 2 = 2 //// 2 * 3 = 6 //// 6 * 4 �����λ��Ϊ4��2����ʮλ�����Ϊ24. 
//// 24 * 5 �����λΪ0��2����ʮλ��ʮλ���Ϊ10 + 2 = 12��2����ʮλ��1������λ�����Ϊ120���Դ����ơ�
	{
		int c = 0,s;
		for( i = 0;i < N;i++)
		{
			s = a[i] * j + c;
			a[i] = s % 10;
			c = s / 10;
		}
	}
	for( i = N - 1;i >= 0;i--)
	if(a[i] != 0)
		break;
	cout << "2014! = ";
	for(int j = i;j >= 0;j--)
		cout << a[j];
	cout << endl;
} 