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
	student set(student n);//������
	student superinduce(student n);//��ӡ�
	void gather(student a[],int m);//���ܡ�
	void reorder(student a[],int m);//����
	int query(student n,string query,int j);//��ѯ��
	void display(student n);//��ʾ��
};