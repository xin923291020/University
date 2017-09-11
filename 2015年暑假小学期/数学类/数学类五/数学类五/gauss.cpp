#include "gauss.h"

gauss::gauss(void)
{
}

gauss::~gauss(void)
{
}
void gauss::free()//释放空间。
{
	for(int i = 0;i < row;i++)
		delete [] a[i];
	delete [] a;
}
void gauss::short_cut_process(int rowsize,int colsize)
{
	row = rowsize;
	col = colsize;
}
void gauss::dynamic_apply()//动态申请。
{
	a = new double *[row + 1];
	for(int i = 0;i < row + 1;i++)
		*(a + i) = new double[col + 1];
}
void gauss::input()
{
	cout << "请输入" << row << "行" << col + 1 << "列矩阵:" << endl;
	for(int i = 0;i < row;i++)
		for(int j = 0;j < col + 1;j++)
			cin >> a[i][j];
}
double gauss::denominator(gauss A)
{
	int i,j,k,sign = 0;
	double b[100][100],ret = 1,t;

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
int gauss::result(gauss A,double den)
{
	int i,j,k,flag = 0,sign = 0;
	double b[100][100],ret[100],t;

	for(i = 0;i < 100;i++)
	{
		ret[i] = 1;
	}
	while(1)
	{
		for(i = 0;i < A.col;i++)
			for(j = 0;j < A.col;j++)//以下对b数组进行操作。
			{
				b[i][j] = A.a[i][j];
			}
		for(i = 0;i < A.col;i++)//将常数列与第i列(i为xi中的i)交换。
		{
			b[i][flag] = A.a[i][col];
		}
		flag++;
		for(i = 0;i < A.row;i++)
		{
			if(zero(b[i][i]))
			{
				for(j = i + 1;j < A.row;j++)
					if(!zero(b[j][i]))
						break;
				if(j == A.row)
					return 0;
				for(k = i;k < A.row;k++)
					t = b[i][k],b[i][k] = b[j][k],b[j][k] = t;
				sign++;	
			}
			ret[flag] *= b[i][i];
			for(k = i + 1;k < A.row;k++)
				b[i][k] /= b[i][i];
			for(j = i + 1;j < A.row;j++)
				for(k = i + 1;k < A.row;k++)
					b[j][k] -= b[j][i] * b[i][k];
		}
		if(sign & 1)
			ret[flag] = -ret[flag];
		if(flag >= row)
		{
			break;
		}
	}
	cout << "以下为计算结果:" << endl;
	for(i = 1;i < row + 1;i++)
	{
		cout << "x" << i << " = " << ret[i]/den << endl;
	}
	return 0;
}