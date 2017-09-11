//Chengxin Yang,Nov.21 2014

#include <iostream>
using namespace std;

int swap(int n)
{
	int a,b,c,d;

	a = n / 100;
	b = n % 100;
	c = b / 10;
	d = b % 10;

	bool flag;
	if(n == (a * a * a) + (c * c * c) + (d * d * d))
		flag = 1;
	else
		flag = 0;
	
	return flag;
}

void main()
{
	int i;
	for(i = 100;i < 1000;i++)
	{
		if(swap(i) == 1)
			cout << i <<endl;
	}
}