//Chengxin Yang,Nov.21 2014

#include <iostream>
using namespace std;

void main()
{
	int i,j;
	for(i = 0;i < 9;i++)
	{
		for(j = 0;j < 9;j++)
			cout << (j + 1) << "*" << (i + 1) <<" ";
		cout <<endl;
	}
}