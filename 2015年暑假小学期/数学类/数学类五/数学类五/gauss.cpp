#include "gauss.h"

gauss::gauss(void)
{
}

gauss::~gauss(void)
{
}
void gauss::free()//�ͷſռ䡣
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
void gauss::dynamic_apply()//��̬���롣
{
	a = new double *[row + 1];
	for(int i = 0;i < row + 1;i++)
		*(a + i) = new double[col + 1];
}
void gauss::input()
{
	cout << "������" << row << "��" << col + 1 << "�о���:" << endl;
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
			for(j = 0;j < A.col;j++)//���¶�b������в�����
			{
				b[i][j] = A.a[i][j];
			}
		for(i = 0;i < A.col;i++)//�����������i��(iΪxi�е�i)������
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
	cout << "����Ϊ������:" << endl;
	for(i = 1;i < row + 1;i++)
	{
		cout << "x" << i << " = " << ret[i]/den << endl;
	}
	return 0;
}