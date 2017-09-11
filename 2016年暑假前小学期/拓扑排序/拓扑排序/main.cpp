#include<iostream>
#include<string>
using namespace std;

#define MAX 100

typedef struct ArcNode
{
	int tailVertex;
	struct ArcNode *nextArc;
}ArcNode;
typedef struct VNode
{
	string name;
	ArcNode *firstArc;
}VNode,AdjList[MAX];
typedef struct
{
	AdjList vertices;
	int vertexNumber,sideNumber;
}ALGraph;
typedef struct
{
	int *base;
	int *top;
	int stacksize;
}SqStack;

int Locate(ALGraph G,string s)
{
	for(int i = 0;i < G.vertexNumber;i++)
	{
		if(s == G.vertices[i].name)
		{
			return i;
		}
	}
}

void InitStack(SqStack &S)
{
	S.base = new int[MAX];
	if(!S.base)
	{
		exit(OVERFLOW);
	}
	S.top = S.base;
	S.stacksize = MAX;
}

void Push(SqStack &S,int e)
{
	if(S.top - S.base == S.stacksize)
	{
		cout << "栈满！" << endl;
		return;
	}
	*S.top++=e;
}

void Pop(SqStack &S,int &e)
{
	if(S.top == S.base)
	{
		cout << "栈空！" << endl;
		return;
	}
	e=*--S.top;
}

bool StackEmpty(SqStack S)
{
	if(S.top == S.base)
	{
		return true;
	}
	else
	{
		return false;
	}
}

int GraphExist(ALGraph G,int i,int j)
{
	ArcNode *s;
	s = G.vertices[i].firstArc;
	while(s && s->tailVertex != j)
		s = s->nextArc;
	if(s)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

int InDegree(ALGraph G,int i)
{
	int j;
	int n = 0;
	for(j = 0;j < G.vertexNumber;j++)
	{
		if(GraphExist(G,j,i))
		{
			n++;
		}
	}
	return n;
}
void FindInDegree(ALGraph G,int indegree[])
{
	int numDegree = 0;
	for(int i = 0;i < G.vertexNumber;i++)
	{
		indegree[i] = InDegree(G,i);
	}
}

bool TopologicalSort(ALGraph G,int topo[])
{
	int indegree[MAX];
	FindInDegree(G,indegree);
	SqStack S;
	InitStack(S);
	for(int i = 0;i < G.vertexNumber;i++)
	{
		if(indegree[i] == 0)
		{
			Push(S,i);
		}
	}
	int m = 0;
	while(!StackEmpty(S))
	{
		int i = -1;
		Pop(S,i);
		topo[m] = i;
		m++;
		ArcNode *p = G.vertices[i].firstArc;
		while(p != NULL)
		{
			int k = p->tailVertex;
			indegree[k]--;
			if(indegree[k] == 0)
			{
				Push(S,k);
			}
			p = p->nextArc;
		}
	}
	if(m < G.vertexNumber)
	{
		return false;
	}
	else
	{
		return true;
	}
}

void main()
{
	ALGraph G;
	cout << "请输入顶点数和边数。" << endl;
	cin >> G.vertexNumber >> G.sideNumber;
	cout << "请依次输入顶点名字。" << endl;
	for(int i = 0;i < G.vertexNumber;i++)
	{
		cin >> G.vertices[i].name;
		G.vertices[i].firstArc = NULL;
	}
	cout << "输入每条边依附的两个点。" << endl;
	for(int k = 0;k < G.sideNumber;k++)
	{
		string v1,v2;
		cin >> v1 >> v2;
		int i = Locate(G,v1);
		int j = Locate(G,v2);
		ArcNode *p1 = new ArcNode;
		p1->tailVertex = j;
		p1->nextArc = G.vertices[i].firstArc;
		G.vertices[i].firstArc = p1;
	}
	int topo[MAX];
	bool flag = TopologicalSort(G,topo);
	if(flag)
	{
		cout << "拓扑序列为：";
		for(int i = 0;i < G.vertexNumber;i++)
		{
			cout << G.vertices[topo[i]].name << "，";
		}
	}
	else
	{
		cout << "该有向图有回路。" << endl;
	}
}