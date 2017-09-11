//Chengxin Yang,Nov.25 2014  

#include <iostream>
using namespace std;

void main()
{
	int i = 1,m,n = 1;

	while(n < 5)
	{
		for(m = 1;m <= i;m++)
		{
			cout <<"*";
		}
		cout << endl;
		i += 2;
		n++;
	}

	n = 3;
	i = 5;
	while(n > 0)
	{
		for(m = i;m > 0;m--)
		{
			cout <<"*";
		}
		cout << endl;
		i -= 2;
		n--;
	}
}