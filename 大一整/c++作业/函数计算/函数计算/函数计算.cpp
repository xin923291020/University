//Chengxin Yang,Noc.16 2014

#include <iostream>
#include <cmath>
using namespace std;

void main()
{
	//��������
	double x,y;
	cout << "�����뻡�ȣ�" <<endl;
	cin >> x;

	y = tan(x);

	cout << "������Ϊ" << x << "������ֵΪ" << y <<endl;

	//��������
	double a,b,c;
	cout << "���������������������" <<endl;
	cin >> a >> b;

	if(a <= 0||b <= 0)
	{
		cout << "����������������룺" <<endl;
		cin >> a >> b;
	}
	
	c = log(a) / log(b);

	cout << "��" << b << "Ϊ��" << a << "�Ķ���Ϊ" << c <<endl;

	//ָ������
	cout << "���������������ָ����" <<endl;
	cin >> a >> b;

	c = pow(a,b);

	cout << a << "��" << b << "����Ϊ" << c <<endl;
}