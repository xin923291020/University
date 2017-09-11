//Chengxin Yang£¬Dec.2 2014

#include <iostream>
using namespace std;

void main()
{
	for(int n = 8;n < 1000;n = n + 7)
	if(n % 2 == 0 && n % 3 == 0 && n % 5 == 0 && n % 6 == 0)
		cout << n - 1 <<endl;
}