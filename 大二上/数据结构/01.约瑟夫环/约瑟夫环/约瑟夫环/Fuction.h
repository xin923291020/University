#pragma once
#include<iostream>
using namespace std;

typedef struct LNode
{
	int data;
	int number;
	struct LNode *next;
}LNode,*LinkList;

void ElemNumberInput(int &max);    //Ԫ�ظ�������
void InitPassworGet(int &e);    //��ʼ��������
void CreateList(LinkList &L,int n);    //������Ĵ���
void ListOutput(LinkList L,int now);    //���������ĵ�ǰԪ��
void ListDelete(LinkList &L,int &i,int &e,int &now);    //�������ɾ��
int ListDeleteTop(LinkList &L,int i);
int ListDeleteAmong(LinkList &L,int i);
int ListDeleteEnd(LinkList &L,int i);
int ListDeleteFew(LinkList &L,int i);
int GetValue(LinkList L,int i,int &e);    //�������ȡֵ
void ElemDeleteDeclare(LNode *q);
void PasswordDeclare(int i);    //��ǰ��������
void PasswordResetting(int &i,int e,int now);    //���������