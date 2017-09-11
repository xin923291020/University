#pragma once
#include<iostream>
#include<cmath>
#define zero(x)(fabs(x) < 1e-10)
using namespace std;

class gauss
{
private:
	int row,col;
	double **a;
public:
	gauss(void);
	~gauss(void);

	void free();
	void short_cut_process(int rowsize,int colsize);
	void dynamic_apply();
	void input();
	double denominator(gauss A);
	int result(gauss A,double den);
};