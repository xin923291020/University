#pragma once
#include<iostream>
#include<string>
using namespace std;

class supervise_info
{
private:
	string student_ID;
	string name;
	string sex;
	int age;
	string grade;
	string college;
	string specialty;
public:
	supervise_info();
	~supervise_info();
	supervise_info set(supervise_info n);//������
	supervise_info superinduce(supervise_info n);//��ӡ�
	int query(supervise_info n,string query,int r,int j);//��ѯ��
	int revise(supervise_info n,string revise_student_ID,int k);//�޸ġ�
	int del(supervise_info n,string del,int l,int k);//ɾ����
	void display(supervise_info n);//��ʾ��
};