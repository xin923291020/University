//Chengxin Yang,Noc.16 2014

#include <iostream>
#include <cmath>
using namespace std;

void main()
{
	//正切运算
	double x,y;
	cout << "请输入弧度：" <<endl;
	cin >> x;

	y = tan(x);

	cout << "弧度数为" << x << "的正切值为" << y <<endl;

	//对数运算
	double a,b,c;
	cout << "请依次输入底数和真数：" <<endl;
	cin >> a >> b;

	if(a <= 0||b <= 0)
	{
		cout << "输入错误，请重新输入：" <<endl;
		cin >> a >> b;
	}
	
	c = log(a) / log(b);

	cout << "以" << b << "为底" << a << "的对数为" << c <<endl;

	//指数运算
	cout << "请依次输入底数和指数：" <<endl;
	cin >> a >> b;

	c = pow(a,b);

	cout << a << "的" << b << "次幂为" << c <<endl;
}