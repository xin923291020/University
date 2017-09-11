//Chengxin Yang,Nov.25 2014

#include<iostream>
using namespace std;

int swap(int n)
{
	int i,s = 0;
	for(i = 1;i * i < n;i++)
		if(n % i == 0)
			s += i + n / i;
	if(i * i == n)
		s += i;
	s -= n;

	return s;
}

void main()
{
	int i,j;
	for(i = 0;i < 10000;i++)
	{
		j = swap(i);
		if(j > i && swap(j) == i)
			cout << i << " " << j <<endl;
	}
}