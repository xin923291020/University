//此处认为对角线之和是正、次对角线之和减去重复计算的元素。
//Chengxin Yang,Nov.20 2014

#include <iostream>
#include <new>
#define N 3
using namespace std;

void main()
{
	int **p,i,j,a,sum = 0;

	p = new int *[N];
		for(i = 0;i < N;i++)
			*(p + i) = new int[N];

	cout << "请输入" << N << "阶行列式" <<endl;
	for(i = 0;i < N;i++)
		for(j = 0;j < N;j++)
			cin >> p[i][j];

	for(i = 0;i < N;i++)
	{
		j = i;
		sum += p[i][j];
		sum += p[j][i];
	}
	
	a = (N / 2);
	sum -= p[a][a];

	cout << "其对角线和为：" << sum <<endl;

	for(i = 0;i < N;i++)
		delete[] a[i];
	delete[] a;
}
