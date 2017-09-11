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
	cout << "������" << row << "��" << col << "�о���:" << endl;
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
		cout << "�þ����Ƿ��󣬲����ڼ���" << endl;
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
		cout << "�÷���ļ�Ϊ:" << trace_sum << endl;
	}
}
double matrix::determinant(matrix A)
{
	int i,j,k,sign = 0;
	double b[100][100],ret = 1,t;

	if(A.row != A.col)
	{
		cout << "�þ����Ƿ��󣬲���������ʽ���ʲ����档" << endl;
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
				if(!zero(b[j][i]))	//��i���в�Ϊ�������ʱ������ѭ����
					break;
			if(j == A.row)//��jֵ��������ʱ��˵��i��ȫΪ�㣬����ʽֵΪ�㡣
				return 0;
			for(k = i;k < A.row;k++)
				t = b[i][k],b[i][k] = b[j][k],b[j][k] = t;//�ѵ�һ��һ�������ֲ�Ϊ����е�����һ�С�
			sign++;	//��¼���д������ж�����ʽֵ��������
		}
		ret *= b[i][i];
		for(k = i + 1;k < A.row;k++)
			b[i][k] /= b[i][i];//�����i�е�һ�������ǵ�һ�е�һ�����ֵļ�����
		for(j = i + 1;j < A.row;j++)
			for(k = i + 1;k < A.row;k++)
				b[j][k] -= b[j][i] * b[i][k];//��j�ж�Ӧ��ȥ����*��һ�С�
	}
	if(sign & 1)//���signΪ������ret��š�
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