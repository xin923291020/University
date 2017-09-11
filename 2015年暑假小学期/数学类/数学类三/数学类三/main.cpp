#include <iostream>
#define N 6000
using namespace std;

void main()
{
	int i,n = 2014,a[N];

	memset(a,0,sizeof(a));	//另数组的每一个数都为0。
	a[0] = 1;

	for(int j = 2;j <= n;j++)	//从1乘到2014。思路是1 * 2 = 2 //// 2 * 3 = 6 //// 6 * 4 结果个位数为4，2进到十位，结果为24. 
//// 24 * 5 结果个位为0，2进到十位，十位结果为10 + 2 = 12，2留在十位，1进到百位。结果为120。以此列推。
	{
		int c = 0,s;
		for( i = 0;i < N;i++)
		{
			s = a[i] * j + c;
			a[i] = s % 10;
			c = s / 10;
		}
	}
	for( i = N - 1;i >= 0;i--)
	if(a[i] != 0)
		break;
	cout << "2014! = ";
	for(int j = i;j >= 0;j--)
		cout << a[j];
	cout << endl;
} 