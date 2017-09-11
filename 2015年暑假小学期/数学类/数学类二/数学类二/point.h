#pragma once
#include<iostream>
#include<cmath>
using namespace std;

class point
{
private:
	double x;
	double y;
public:
	point();
	point(double,double);
	~point();
	void setX(double x);
	void setY(double y);
	double length(point a,point b);
};