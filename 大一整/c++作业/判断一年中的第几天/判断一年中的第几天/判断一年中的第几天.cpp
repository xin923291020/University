//Chengxin Yang��Dec.2 2014

#include <iostream>
#include "�ж�����.h"
using namespace std;

void main()
{
	int n,m,p,sum;
	cout << "���������������ա�" << endl;
	cin >> n >> m >> p;

	if(m < 1 || m > 12 || p < 0 || p > 32)
	{
		cout << "����������������롣" << endl;
		cin >> n >> m >> p;
	}

	if(m == 1)
		sum = p;
	if(m == 2)
		sum = 31 + p;
	if(m == 3)
		sum = 59 + p;
	if(m == 4)
		sum = 90 + p;
	if(m == 5)
		sum = 120 + p;
	if(m == 6)
		sum = 151 + p;
	if(m == 7)
		sum = 181 + p;
	if(m == 8)
		sum = 212 + p;
	if(m == 9)
		sum = 243 + p;
	if(m == 10)
		sum = 273 + p;
	if(m == 11)
		sum = 304 + p;
	if(m == 12)
		sum = 334 + p;

	if(swap(n) == 1 && m > 2)
		sum++;
	if(swap(n) == 1 && m == 2 && p == 29)
		sum++;

	cout << "����һ���еĵ�" << sum << "�졣" << endl;
}