#pragma once
#include<iostream>
#include<string>
using namespace std;
#define N 101

class student
{
private:
	string student_ID;
	string name;
	int math;
	int Chinese;
	int English;
public:
	student();
	~student();
	student set(student n);//创建。
	student superinduce(student n);//添加。
	void gather(student a[],int m);//汇总。
	void reorder(student a[],int m);//排序。
	int query(student n,string query,int j);//查询。
	void display(student n);//显示。
};