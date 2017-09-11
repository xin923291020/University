#include<iostream>
#include<string>
using namespace std;

#define LH +1
#define EH 0
#define RH -1

typedef struct
{
	int key;
	int bf;
}Leaf;
typedef struct BSTNode
{
	Leaf data;
	struct BSTNode *lchild, *rchild;
}BSTNode, *BSTree;

void R_Rotate(BSTree & T)
{
	BSTree p;
	p = T->lchild;
	T->lchild = p->rchild;
	p->rchild = T;
	T=p;
}

void L_Rotate(BSTree & T)
{
	BSTree p;
	p = T->rchild;
	T->rchild = p->lchild;
	p->lchild = T;
	T=p;
}

void LeftBalance(BSTree & T)
{
	BSTree lc,rd;
	lc = T->lchild;
	switch(lc->data.bf)
	{
	case LH:
		T->data.bf = lc->data.bf = EH;
		R_Rotate(T);break;
	case RH:
		rd = lc->rchild;
		switch(rd->data.bf)
		{
		case LH:
			T->data.bf = RH;
			lc->data.bf = EH;break;
		case EH:T->data.bf = lc->data.bf = EH;break;
		case RH:T->data.bf = EH;lc->data.bf=LH;break;
		}
		rd->data.bf = EH;
		L_Rotate(T->lchild);
		R_Rotate(T);
	}
}
		

void RightBalance(BSTree & T)
{
	BSTree rc,ld;
	rc = T->rchild;
	switch(rc->data.bf)
	{
	case RH:
		T->data.bf = rc->data.bf = EH;
		L_Rotate(T);break;
	case LH:
		ld = rc->lchild;
		switch(ld->data.bf)
		{
		case LH:
			T->data.bf = EH;
			rc->data.bf = RH;break;
		case EH:T->data.bf = rc->data.bf = EH;break;
		case RH:T->data.bf = LH;rc->data.bf=EH;break;
		}
		ld->data.bf = EH;
		R_Rotate(T->rchild);
		L_Rotate(T);
	}
}

void PrintBST(BSTree T,int m)
{
	int i;
	if(T->rchild)
		PrintBST(T->rchild,m+1);
	for(i=1;i<=m;i++)
		cout << "	";
	cout << T->data.key << endl;
	if(T->lchild)
		PrintBST(T->lchild,m+1);
}
void InsertBST(BSTree & T, Leaf e,bool &taller)
{
	if (!T)
	{
		BSTNode *S = new BSTNode;
		S->data = e;
		S->lchild = S->rchild = NULL;
		S->data.bf=EH;
		taller = true;
		T = S;
	}
	else
	{
		/*if(e.key==T->data.key)
		{
			taller = false;
			cout << "二叉排序树中已有" << e.key << ",无法插入" << endl;
			return;
		}*/
		if (e.key<=T->data.key)
		{
			InsertBST(T->lchild,e,taller);
			if(taller)
			{
				switch(T->data.bf)
				{
				case LH:
					LeftBalance(T);taller = false;break;
				case EH:
					T->data.bf = LH;taller = true;break;
				case RH:
					T->data.bf = EH;taller = false;break;
				}
			}
		}
		if (e.key>T->data.key)
		{
			InsertBST(T->rchild,e,taller);
			if(taller)
			{
				switch(T->data.bf)
				{
				case LH:
					T->data.bf = EH;taller = false;break;
				case EH:
					T->data.bf = RH;taller = true;break;
				case RH:
					RightBalance(T);taller = false;break;
				}
			}
		}
		
	}
}

void InOrderTraverse(BSTree T)
{
	if(T)
	{
		InOrderTraverse(T->lchild);
		cout << T->data.key << " ";
		InOrderTraverse(T->rchild);
	}
}

void FirstSequenceTraverse(BSTree T)
{
	if(T)
	{
		cout << T->data.key << " ";
		FirstSequenceTraverse(T->lchild);
		FirstSequenceTraverse(T->rchild);
	}
}

void AfterTheSequenceTraverse(BSTree T)
{
	if(T)
	{
		AfterTheSequenceTraverse(T->lchild);
		AfterTheSequenceTraverse(T->rchild);
		cout << T->data.key << " ";
	}
}

void main()
{
	BSTree T = NULL;
	bool taller = false;
	int length = -1;
	cout << "请输入树上结点数量。" << endl;
	cin >> length;
	Leaf *Array = new Leaf[length];
	cout << "请输入" << length << "个结点" << endl;
	for(int i = 0;i < length;i++)
	{
		cin >> Array[i].key;
		InsertBST(T,Array[i],taller);
	}
	if(T)
	{
		PrintBST(T,0);
	}
	else
	{
		cout << "这是一颗空树" << endl;
		return;
	}
	cout << "先序遍历为：" << endl;
	FirstSequenceTraverse(T);
	cout << endl << "中序遍历为：" << endl;
	InOrderTraverse(T);
	cout << endl << "后序遍历为：" << endl;
	AfterTheSequenceTraverse(T);
}