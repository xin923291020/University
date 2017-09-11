#include "Vector.h"

void main()
{
	int length;
	cout << "请输入向量维度。" << endl;
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

	cout << "浅克隆" << endl;
	cout << " p:";
	p->ShowData();
	cout << endl;
	cout << "p1:";
	p1->ShowData();
	cout << endl;
}