//Chengxin Yang,Nov.25 2014

#include <iostream>
#include <cmath>
using namespace std;

void main()
{
	double a,b,c;
	cout << "���������� ax^2 + bx + c = 0 �е�a,b,c��" <<endl;
	cin >> a >> b >> c;

	if(a == 0 && b == 0)
	{
		cout << "����������������롣" <<endl;
		cin >> a >> b >> c;
	}
	if(a == 0 && b != 0)
		cout << "x = " << -(c / b) <<endl;
	else
	{
		if(pow(b,2) - 4 * a * c == 0)
		{
			cout << "x = " << (-b) / (2 * a) <<endl;
		}
		if(pow(b,2) - 4 * a * c < 0)
			cout << "������ʵ���⡣" <<endl;
		if(pow(b,2) - 4 * a * c > 0)
			cout << "x = " << ((-b) + sqrt(pow(b,2) - 4 * a * c)) / (2 * a) << "�� x = " << ((-b) - sqrt(pow(b,2) - 4 * a * c)) / (2 * a) <<endl;
	}
}
