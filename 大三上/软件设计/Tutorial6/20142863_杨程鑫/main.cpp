#include "Vector.h"

void main()
{
	int length;
	cout << "����������ά�ȡ�" << endl;
	cin >> length;
	Vector* p = new ConcreteVector(length);
	Vector* p1 = p->Clone();
   
	cout << " p:";
	p->ShowData();
	cout << endl;
	cout << "p1:";
	p1->ShowData();
	cout << endl;

	p1->AddOne();

	cout << "ǳ��¡" << endl;
	cout << " p:";
	p->ShowData();
	cout << endl;
	cout << "p1:";
	p1->ShowData();
	cout << endl;
}