//Chengxin Yang��Dec.2 2014

#include <iostream>
using namespace std;

void main()
{
	double n = 100,m = 10,sum = 0;

	while(m)
	{
		n = n / 2;
		sum = sum + n;
		m--;
	}

	cout << "С�򵯹���·��Ϊ" << sum <<endl;
	cout << "���һ�ε���߶�Ϊ" << n << endl;
}