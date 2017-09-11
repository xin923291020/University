//Chengxin Yang,Nov.18 2014

#include <iostream>
using namespace std;

void main()
{
	char a,b,c;
	cout << "请输入一个字符:";
	cin >> a;
	b = a + 1;
	c = a - 1;

	cout << a << "的前一个字符为:" << c << endl;
	cout << a << "的后一个字符为:" << b << endl;
}