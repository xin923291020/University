#pragma once
#include<iostream>
#include<new>
#include<cmath>
#define zero(x)(fabs(x) < 1e-10)
using namespace std;

class matrix
{
private:
	int row,col;
	double **a;
public:
	matrix();
	~matrix();

	void free();
	void dynamic_apply();	//申请动态空间。
	void short_cut_process(int rowsize,int colsize);	//对行列数赋值。
	void input();	//得到矩阵数据。
	void display(matrix A);	//	输出矩阵。
	void calculate_trace(matrix A);	//计算迹。
	double determinant(matrix A);	//计算行列式。

	//符号重载。
	friend matrix operator + (matrix A,matrix B);
	friend matrix operator - (matrix A,matrix B);
	friend matrix operator * (matrix A,matrix B);
};