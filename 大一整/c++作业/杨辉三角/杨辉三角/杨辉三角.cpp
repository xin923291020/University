//Chengxin Yang,Nov.25 2014  

#include <iostream>
#define N 15
using namespace std;

void main()
{
	int n = 1,array[N] = {1,1};
	int i,j;

	if(N == 1)
		cout << array[0] <<endl;
	else if(N == 2)
	{
		cout << array[0] <<endl;
		cout << array[0] << " " << array[1] <<endl;
	}
	
	else
	{
		cout << array[0] <<endl;
		cout << array[0] << " " << array[1] <<endl;
		while(n < N - 1)
		{
			array[n + 1] = array[n];
			for(j = n;j > 0;j--)
			{
				array[j] += array[j - 1];
				array[0] = 1;
			}
			n++;
			for(i = 0;i < n + 1;i++)
				cout << array[i] <<" ";
			cout <<endl;
		}

	}
}