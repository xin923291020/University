//Chengxin Yang,Nov.25 2014

#include <iostream>
using namespace std;

void main()
{
	int n,a[100],i = 0,j;
	int flag = 1;

	cout << "请输入一个数。" <<endl;
	cin >> n;

	int t = n;

	while(a[i-1])
	{
		
		a[i] = n % 10;
		n -= a[i];
		n /= 10;
		i++;
	}

	for(j = 0;j < i - 1;j++)
		if(a[j] != a[i - j - 2])
		{
			flag = 0;
		}

	if(flag == 1)
		cout << t << "是回文数。" <<endl;
	if(flag == 0)
		cout << t << "不是回文数。" <<endl;
}