#include"matrix.h"

void main()
{
	matrix A,B,C;
	int rowsize,colsize;
	
	cout << "请输入需要计算矩阵的行数与列数。" << endl;
	cin >> rowsize >> colsize;

	A.short_cut_process(rowsize,colsize);
	B.short_cut_process(rowsize,colsize);	//对行列数进行赋值。

	A.dynamic_apply();
	A.input();
	B.dynamic_apply();
	B.input();	//申请动态空间并输入矩阵。

	A.calculate_trace(A);	//计算A的迹。

	C = A + B;
	cout << "A + B:" << endl;
	C.display(C);
	cout << endl;	//矩阵加法。

	C = A - B;
	cout << "A - B:" << endl;
	C.display(C);
	cout << endl;	//矩阵减法。

	C = A * B;
	cout << "A * B:" << endl;
	C.display(C);
	cout << endl;	//矩阵乘法。

	cout << "A的行列式为:" << A.determinant(A) << endl << endl;;

	//判断矩阵书否可逆。
	if(A.determinant(A) == 0)
	{
		cout << "该矩阵不可逆。" << endl;
	}
	else
		cout << "该矩阵可逆。" << endl;

	A.free();
	B.free();
	C.free();	//释放空间。
}