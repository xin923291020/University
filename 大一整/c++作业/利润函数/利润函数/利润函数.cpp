//Chengxin Yang,Nov.25 2014  

#include <iostream>
using namespace std;

long double swap(long double n)
{
	long double sum = 0;

	if(n >= 0 && n <= 100000)
	sum += n * 0.1;

	if(n > 100000 && n <= 200000)
	sum = 10000 + (n - 100000) * 0.075;

	if(n > 200000 && n <= 400000)
	sum = 17500 + (n - 200000) * 0.05;

	if(n > 400000 && n <= 600000)
	sum = 27500 + (n - 400000) * 0.03;

	if(n > 600000 && n <= 1000000)
	sum = 33500 + (n - 600000) * 0.015
	;
	if(n > 1000000)
	sum = 39500 + (n - 1000000) * 0.01;

	return sum;
}

void main()
{
	long double n;

	cout << "请输入当月利润：" <<endl;
	cin >> n;

	cout << "当月工资为：" << swap(n) <<endl;
}