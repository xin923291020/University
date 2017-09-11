//Chengxin Yang,Nov.21 2014

#include <iostream>
using namespace std;

void main()
{
	int i;
	double a = 1,b = 1,sum = 0,t;
	for(i = 0;i < 20;i++)
	{
		sum += (a + b) / b;
		t = a;
		a = b;
		b = b + t;
	}

	cout << sum <<endl;
}