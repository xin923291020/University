//Chengxin Yang,Nov.16 2014

#include <iostream>
#include <cmath>
#include <new>
using namespace std;

void main()
{
	int SIZE,a,i = 0;
	cout << "请输入你想拆分几位数字：" <<endl;
	cin >> SIZE;
	cout << "请输入" << SIZE << "位数字" <<endl;
	cin >> a;

	int num[100];

	while(a)
	{
		num[i] = a % 10;
		i++;
		a = a / 10;
	}
	for(i = SIZE - 1;i >= 0;i--)
		cout << num[i] << " ";
}