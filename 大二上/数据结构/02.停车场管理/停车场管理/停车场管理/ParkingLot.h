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

int InitStack(parkinglot &p);//栈的初始化
int Push(parkinglot &p,car e);//入栈函数
car Pop(parkinglot &p);//出栈函数
car GetTop(parkinglot p);//获得栈顶元素