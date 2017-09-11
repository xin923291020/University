#include"matrix.h"

matrix::matrix()
{
	for(int i = 0;i < row;i++)
		for(int j = 0;j < col;j++)
			a[i][j] = 0;
}
matrix::~matrix()
{
}

void matrix::free()
{
	for(int i = 0;i < row;i++)
		delete [] a[i];
	delete [] a;
}
void matrix::short_cut_process(int rowsize,int colsize)
{
	row = rowsize;
	col = colsize;
}
void matrix::dynamic_apply()
{
	a = new double *[row];
	for(int i = 0;i < row;i++)
		*(a + i) = new double[col];
}
void matrix::input()
{
	cout << "请输入" << row << "行" << col << "列矩阵:" << endl;
	for(int i = 0;i < row;i++)
		for(int j = 0;j < col;j++)
			cin >> a[i][j];
}
void matrix::display(matrix A)
{
	for(int i = 0;i < row;i++)
	{
		for(int j = 0;j < col;j++)
		{
			cout << A.a[i][j] << " ";
		}
	cout << endl;
	}
}
void matrix::calculate_trace(matrix A)
{
	double trace_sum = 0;
	if(row != col)
	{
		cout << "该矩阵不是方阵，不存在迹。" << endl;
	}
	if(row == col)
	{
		for(int i = 0;i < row;i++)
		{
			for(int j = 0;j < col;j++)
			{
				if(i == j)
				{
					trace_sum += A.a[i][j];
				}
			}
		}
		cout << "该方阵的迹为:" << trace_sum << endl;
	}
}
double matrix::determinant(matrix A)
{
	int i,j,k,sign = 0;
	double b[100][100],ret = 1,t;

	if(A.row != A.col)
	{
		cout << "该矩阵不是方阵，不存在行列式，故不可逆。" << endl;
		return 0;
	}
	for(i = 0;i < A.row;i++)
		for(j = 0;j < A.col;j++)
			b[i][j] = A.a[i][j];
	for(i = 0;i < A.row;i++)
	{
		if(zero(b[i][i]))
		{
			for(j = i + 1;j < A.row;j++)
				if(!zero(b[j][i]))	//第i列有不为零的数字时，结束循环。
					break;
			if(j == A.row)//当j值等于行数时，说明i列全为零，行列式值为零。
				return 0;
			for(k = i;k < A.row;k++)
				t = b[i][k],b[i][k] = b[j][k],b[j][k] = t;//把第一列一行首数字不为零的行调到第一行。
			sign++;	//记录调行次数，判断行列式值的正负。
		}
		ret *= b[i][i];
		for(k = i + 1;k < A.row;k++)
			b[i][k] /= b[i][i];//算出第i列第一行数字是第一列第一行数字的几倍。
		for(j = i + 1;j < A.row;j++)
			for(k = i + 1;k < A.row;k++)
				b[j][k] -= b[j][i] * b[i][k];//第j列对应减去倍数*第一行。
	}
	if(sign & 1)//如果sign为奇数，ret变号。
		ret = -ret;

	return ret;
}
matrix operator + (matrix A,matrix B)
{
	matrix C;
	C.row = A.row;
	C.col = A.col;
	C.dynamic_apply();
	for(int i = 0;i < C.row;i++)
		for(int j = 0;j < C.col;j++)
			C.a[i][j] = A.a[i][j] + B.a[i][j];

	return C;
}
matrix operator - (matrix A,matrix B)
{
	matrix C;
	C.row = A.row;
	C.col = A.col;
	C.dynamic_apply();
	for(int i = 0;i < C.row;i++)
		for(int j = 0;j < C.col;j++)
			C.a[i][j] = A.a[i][j] - B.a[i][j];

	return C;
}
matrix operator * (matrix A,matrix B)
{
	matrix C;
	C.row = A.row;
	C.col = A.col;
	C.dynamic_apply();

	for(int i = 0;i < C.row;i++)
		for(int j = 0;j < C.col;j++)
			C.a[i][j] = 0;

	for(int i = 0;i < C.row;i++)
		for(int j = 0;j < C.col;j++)
			for(int n = 0;n < C.col;n++)
				C.a[i][j] += A.a[i][n] * B.a[n][i];

	return C;
}