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
	void dynamic_apply();	//���붯̬�ռ䡣
	void short_cut_process(int rowsize,int colsize);	//����������ֵ��
	void input();	//�õ��������ݡ�
	void display(matrix A);	//	�������
	void calculate_trace(matrix A);	//���㼣��
	double determinant(matrix A);	//��������ʽ��

	//�������ء�
	friend matrix operator + (matrix A,matrix B);
	friend matrix operator - (matrix A,matrix B);
	friend matrix operator * (matrix A,matrix B);
};