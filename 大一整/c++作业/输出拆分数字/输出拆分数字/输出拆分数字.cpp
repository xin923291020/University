//Chengxin Yang,Nov.16 2014

#include <iostream>
using namespace std;

void main()
{
	int a,b,c,d,f;
	cout << "请输入一个三位数字：" <<endl;
	cin >> a;

	b = a / 100;
	c = a % 100;

	d = c / 10;
	f = c % 10;

	cout << b <<endl << d <<endl << f <<endl;
}