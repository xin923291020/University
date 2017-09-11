#include<iostream>
#include <stdlib.h>
#include <time.h>
#define MAXSIZE 100
using namespace std;

typedef struct
{
	int key;
	char other;
}RedType;

typedef struct
{
	RedType R[MAXSIZE+1];
	int length;
	int Compare;
	int Move;
}Sqlist;
       
void InsertSort(Sqlist &L)//直接插入排序
{
	L.Compare = 0;
	L.Move = 0;
	int i,j;
	for(i = 2;i <= L.length;i++)
	{
		if(L.R[i].key < L.R[i - 1].key)
		{
			L.R[0] = L.R[i];
			L.R[i] = L.R[i-1];
			L.Move += 2;
			L.Compare++;
			for(j = i - 2;L.R[0].key < L.R[j].key;j--)
			{
				L.R[j + 1] = L.R[j];
				L.Move++;
			}
			L.R[j + 1]=L.R[0];
			L.Move++;
		}
    }
}

void ShellInsert(Sqlist &L,int n)//希尔排序
{
	L.Compare = 0;
	L.Move = 0;
	int i,j;
	for(i = n + 1;i <= L.length;i++)
	{
		if(L.R[i].key < L.R[i - n].key){
			L.Compare++;
			L.R[0] = L.R[i];
			L.Move++;
			for(j = i - n;j > 0 && L.R[0].key < L.R[j].key;j -= n){
				L.R[j + n] = L.R[j];
				L.Move++;
			}
			L.R[j + n] = L.R[0];
			L.Move++;
		}
	}
}

void ShellSort(Sqlist &L,int &C,int &M){
	int array[3];
	array[0] = 5,array[1] = 3,array[2] = 1;
	int t = 3;C = 0,M = 0;
	for(int k = 0;k < t;k++)
	{
		ShellInsert(L,array[k]);
		C += L.Compare;
		M += L.Move;
	}
}

void BubbleSort(Sqlist &L)//冒泡排序
{
	RedType *t = new RedType;
	L.Compare = 0;
	L.Move = 0;
	int m = L.length - 1;
	bool flag = 1;
	while((m > 0) && (flag == 1))
	{
		flag = 0;
		for(int j = 1;j <= m;j++)
		{
			if(L.R[j].key > L.R[j + 1].key)
			{
				flag = 1;
				L.Compare++;
				*t = L.R[j];
				L.R[j] = L.R[j+1];
				L.R[j+1] = *t;
				L.Move += 3;
			}
		}
	m--;
	}
}


int Partition(Sqlist &L,int low,int high)//快速排序
{
	L.R[0] = L.R[low];
	int pivotkey = L.R[low].key;
	while(low < high)
	{
		while((low < high) && (L.R[high].key >= pivotkey))
		{
			high--;
		}
		L.R[low] = L.R[high];
		while((low < high) && (L.R[low].key <= pivotkey))
		{
			low++;
		}
		L.R[high] = L.R[low];
	}
	L.R[low] = L.R[0];
	return low;
}

void QSort(Sqlist &L,int low,int high)
{
	int pivotloc;
	if(low < high)
	{
		pivotloc = Partition(L,low,high);
		QSort(L,low,pivotloc - 1);
		QSort(L,pivotloc + 1,high);
	}
}

void QuickSort(Sqlist &L)
{
	QSort(L,1,L.length);
}

void SelectSort(Sqlist &L)//简单选择排序
{
	L.Compare = 0;
	L.Move = 0;
	int i,j,k;
	for(i = 1;i < L.length;i++)
	{
		k = i;
		for(j = i + 1;j <= L.length;j++)
		{
			if(L.R[j].key < L.R[k].key)
			{
				k = j;
				L.Compare++;
			}
		}
		if(k != i)
		{
			RedType *t = new RedType;
			*t = L.R[i];
			L.R[i] = L.R[k];
			L.R[k] = *t;
			L.Move += 3;
		}
	}
}

void HeapAdjust(Sqlist &L,int s,int m)//堆排序
{
	RedType *Rc = new RedType;
	*Rc = L.R[s];
	for(int j = 2 * s;j <= m;j *= 2)
	{
		if(j < m && L.R[j].key < L.R[j+1].key)
		{
			j++;
		}
		if(Rc->key >= L.R[j].key)
		{
			break;
		}
		L.R[s] = L.R[j];
		s = j;
	}
	L.R[s] = *Rc;
}

void CreatHeap(Sqlist &L)
{
	int n = L.length;
	for(int i = n / 2;i > 0;i--)
	{
		HeapAdjust(L,i,n);
	}
}

void HeapSort(Sqlist &L)
{
	CreatHeap(L);
	RedType *t = new RedType;
	for(int i = L.length;i > 1;i--)
	{
		*t = L.R[1];
		L.R[1] = L.R[i];
		L.R[i] = *t;
	    HeapAdjust(L,1,i - 1);
	}
}

void main()
{
	int j;
	Sqlist L;
	L.length = 100;
	for(int i = 0;i < 8;)
	{

		for(j = 1;j <= L.length;j++)
		{
			L.R[j].key = rand() % 1000;
		}
		cout << "/*常用算法的对比分析*/" << endl;
		cout <<"1\t原顺序表" << endl;
		cout <<"2\t直接插入排序" << endl;
		cout <<"3\t希尔排序" << endl;
		cout <<"4\t冒泡排序" << endl;
		cout <<"5\t快速排序" << endl;
		cout <<"6\t简单选择排序" << endl;
		cout <<"7\t堆排序" << endl;
		cout <<"8\t退出" << endl;
		cin >> i;
		if(i == 1)
		{
			for(j = 1;j <= L.length;j++)
			{
				cout << L.R[j].key << endl;
			}
		}
		if(i == 2)
		{
			InsertSort(L);
			for(j = 1;j <= L.length;j++)
			{
				cout << L.R[j].key << endl;
			}
			cout << "比较次数为：" << L.Compare << endl;
			cout << "移动次数为：" << L.Move << endl;
		}
		if(i == 3)
		{
			int C,M;
			ShellSort(L,C,M);
			for(j = 1;j <= L.length;j++)
			{
				cout << L.R[j].key << endl;
			}
			cout << "比较次数为：" << C << endl;
			cout << "移动次数为：" << M << endl;
		}
		if(i == 4)
		{
			BubbleSort(L);
			for(j = 1;j <= L.length;j++)
			{
				cout << L.R[j].key << endl;
			}
			cout << "比较次数为：" << L.Compare << endl;
			cout << "移动次数为：" << L.Move << endl;
		}
		if(i == 5)
		{
			QuickSort(L);
			for(j = 1;j <= L.length;j++)
			{
				cout << L.R[j].key << endl;
			}
		}
		if(i == 6)
		{
			SelectSort(L);
			for(j = 1;j <= L.length;j++)
			{
				cout << L.R[j].key << endl;
			}
			cout << "比较次数为：" << L.Compare << endl;
			cout << "移动次数为：" << L.Move << endl;
		}
		if(i == 7)
		{
			HeapSort(L);
			for(j = 1;j <= L.length;j++)
			{
				cout << L.R[j].key << endl;
			}
		}
		if(i == 8)
		{
			break;
		}
	}
}