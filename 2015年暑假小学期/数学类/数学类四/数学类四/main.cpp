#include"matrix.h"

void main()
{
	matrix A,B,C;
	int rowsize,colsize;
	
	cout << "��������Ҫ��������������������" << endl;
	cin >> rowsize >> colsize;

	A.short_cut_process(rowsize,colsize);
	B.short_cut_process(rowsize,colsize);	//�����������и�ֵ��

	A.dynamic_apply();
	A.input();
	B.dynamic_apply();
	B.input();	//���붯̬�ռ䲢�������

	A.calculate_trace(A);	//����A�ļ���

	C = A + B;
	cout << "A + B:" << endl;
	C.display(C);
	cout << endl;	//����ӷ���

	C = A - B;
	cout << "A - B:" << endl;
	C.display(C);
	cout << endl;	//���������

	C = A * B;
	cout << "A * B:" << endl;
	C.display(C);
	cout << endl;	//����˷���

	cout << "A������ʽΪ:" << A.determinant(A) << endl << endl;;

	//�жϾ��������档
	if(A.determinant(A) == 0)
	{
		cout << "�þ��󲻿��档" << endl;
	}
	else
		cout << "�þ�����档" << endl;

	A.free();
	B.free();
	C.free();	//�ͷſռ䡣
}