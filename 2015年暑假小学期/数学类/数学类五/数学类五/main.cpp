#include"gauss.h"

void main()
{
	gauss A;
	int n;
	double den;

	cout << "��������Ҫ��������ĸ���:" << endl;
	cin >> n;

	A.short_cut_process(n,n);
	A.dynamic_apply();
	A.input();
	den = A.denominator(A);
	A.result(A,den);
	A.free();
}