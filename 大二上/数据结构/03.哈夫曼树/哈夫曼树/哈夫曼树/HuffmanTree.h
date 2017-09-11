#pragma once
#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

typedef struct
{
	int weight;
	int parent,lchild,rchild;
}HTNode,*HuffmanTree;

typedef char **HuffmanCode;

void CreateHuffmanTree(HuffmanTree &HT,int n);//������������
void Select(HuffmanTree HT,int n,int &s1,int &s2);//ѡ��HT������parent����Ȩֵ��С�Ľ�㣬�������±�
void CreateHuffmanCode(HuffmanTree HT,HuffmanCode &HC,int m);//��������������
void DisplayHuffmanTree(HuffmanTree HT,int m);//���������������̬
void DisplayHuffmanCode(HuffmanCode HC,int m);//�������������
void Encode(HuffmanTree HT,HuffmanCode HC,int m);//����
void CodetoNode(HuffmanTree HT,HuffmanCode HC,int n);