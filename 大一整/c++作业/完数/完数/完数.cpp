//Chengxin Yang,Nov.21 2014

#include <iostream>
using namespace std;

int swap(int n)
{
	int i,sum = 0;
	bool flag;

	for(i = 1;i < n;i++)
	{
		if(n % i == 0)
			sum += i;
	}

	if(sum == n)
		flag = 1;
	else
		flag = 0;

	return flag;
}

void main()
{
	int i;

	for(i = 1;i < 1000;i++)
		if(swap(i) == 1)
			cout << i <<endl;
}