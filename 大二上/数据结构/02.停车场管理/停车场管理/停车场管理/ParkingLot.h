#pragma once
#include<iostream>
#include<string>
using namespace std;
#define MAXSIZE 2

typedef struct
{
	char ch;
	string str;
	int time;
}car;
typedef struct
{
	car *base;
	car *top;
	int stacksize;
}parkinglot;

int InitStack(parkinglot &p);//ջ�ĳ�ʼ��
int Push(parkinglot &p,car e);//��ջ����
car Pop(parkinglot &p);//��ջ����
car GetTop(parkinglot p);//���ջ��Ԫ��