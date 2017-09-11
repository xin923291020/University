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

void CreateHuffmanTree(HuffmanTree &HT,int n);//创建哈夫曼树
void Select(HuffmanTree HT,int n,int &s1,int &s2);//选择HT中两个parent域中权值最小的结点，返回其下标
void CreateHuffmanCode(HuffmanTree HT,HuffmanCode &HC,int m);//创建哈夫曼编码
void DisplayHuffmanTree(HuffmanTree HT,int m);//输出哈夫曼树的终态
void DisplayHuffmanCode(HuffmanCode HC,int m);//输出哈夫曼编码
void Encode(HuffmanTree HT,HuffmanCode HC,int m);//编码
void CodetoNode(HuffmanTree HT,HuffmanCode HC,int n);