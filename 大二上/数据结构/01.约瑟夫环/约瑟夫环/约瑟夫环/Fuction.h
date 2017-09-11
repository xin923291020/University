#pragma once
#include<iostream>
using namespace std;

typedef struct LNode
{
	int data;
	int number;
	struct LNode *next;
}LNode,*LinkList;

void ElemNumberInput(int &max);    //元素个数输入
void InitPassworGet(int &e);    //初始密码输入
void CreateList(LinkList &L,int n);    //单链表的创建
void ListOutput(LinkList L,int now);    //输出单链表的当前元素
void ListDelete(LinkList &L,int &i,int &e,int &now);    //单链表的删除
int ListDeleteTop(LinkList &L,int i);
int ListDeleteAmong(LinkList &L,int i);
int ListDeleteEnd(LinkList &L,int i);
int ListDeleteFew(LinkList &L,int i);
int GetValue(LinkList L,int i,int &e);    //单链表的取值
void ElemDeleteDeclare(LNode *q);
void PasswordDeclare(int i);    //当前密码声明
void PasswordResetting(int &i,int e,int now);    //密码的重置