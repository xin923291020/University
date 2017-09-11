#include<iostream>
#include<string>
using namespace std;

#define MAX 100

typedef struct ArcNode
{
	int tailVertex;
	struct ArcNode *nextArc;
	int weight;
}ArcNode;
typedef struct Vnode
{
	string name;
	ArcNode *firstArc;
}Vnode,AdjList[MAX];
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

int Path = 0; //����
string CriticalPath = ""; //�
string CriticalPath1 = ""; //·��

void InitStack(SqStack &S)//��ʼ��ջ
{
	S.base = new int[MAX];
	if(!S.base)
	{
		exit(-2);
	}
	S.top = S.base;
	S.stacksize = MAX;
}

void Push(SqStack &S,int e)//��ջ
{
	if(S.top - S.base == S.stacksize)
	{
		cout << "ջ����" << endl;
		return;
	}
	*S.top++=e;
}

void Pop(SqStack &S,int &e)//��ջ
{
	if(S.top == S.base)
	{
		cout << "ջΪ��" << endl;
		return;
	}
	e=*--S.top;
}

bool StackEmpty(SqStack S)//�ж��Ƿ�ջ��
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

int Locate(ALGraph G,string s)//�ҵ������±�
{
	int k=0,i;
	for(i = 0;i < G.vertexNumber;i++)
	{
		if(s == G.vertices[i].name)
		{
			k=i;
			break;
		}
	}
	return k;
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

int InDegree(ALGraph G,int i)//�洢����i���
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


bool TopologicalSort(ALGraph G,int topo[])//��������
{
	int indegree[MAX];
	FindInDegree(G,indegree);//�洢���������
	SqStack S;
	InitStack(S);
	for(int i = 0;i < G.vertexNumber;i++)
	{
		if(indegree[i] == 0)//���Ϊ��ջ
		{
			Push(S,i);
		}
	}
	int m = 0;
	while(!StackEmpty(S))//ջ�ǿ�
	{
		int i = -1;
		Pop(S,i);//ջ������vi��ջ
		topo[m] = i;//��vi������������������topo��
		m++;//������������
		ArcNode *p = G.vertices[i].firstArc;//pָ��vi�ĵ�һ���ڽӵ�
		while(p != NULL)
		{
			int k = p->tailVertex;//vkΪvi���ڽӵ�
			indegree[k]--;//viÿ���ڽӵ����ȼ�
			if(indegree[k] == 0)//���Ϊ��Ϊ������ջ
			{
				Push(S,k);
			}
			p = p->nextArc;//pָ��vi����һ���ڽӵ�
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

void GetLength(int Array[MAX][MAX],int start,string name[],int n,string path,string path1,int weight)
{
	bool flag = true;
	int i;
	for(i = 0;i < n;i++)
	{
		if(Array[start][i] != 0)
		{
			flag = false;
			string TemPath = path;
			string TemPath1 = path1;
			int TemWeight = weight;
			TemPath += "(" + name[start] + "," + name[i] + ")";
			TemPath1+=name[start]+"->";
			TemWeight += Array[start][i];
			GetLength(Array,i,name,n,TemPath,TemPath1,TemWeight);
		}
	}
	if(flag && Path <= weight) 
	{
		if(Path == weight)
		{
			CriticalPath += " ��һ��" + path;
			CriticalPath1 += " ��һ��" + path1+name[start];
		}
		if(Path < weight)
		{
			Path = weight;
			CriticalPath = path;
			CriticalPath1 = path1+name[start];
		}
	}
}

void main()
{
	int i,j,k=0,n,m;
	ALGraph G;
	string name[MAX];
	cout << "���붥�����ͱ���" << endl;
	cin >> G.vertexNumber >> G.sideNumber;
	n = G.vertexNumber;
	cout << "�������붥������" << endl;
	for(i = 0;i < G.vertexNumber;i++)
	{
		cin >> G.vertices[i].name;
		name[i] = G.vertices[i].name;
		G.vertices[i].firstArc = NULL;
	}
	cout << "����ÿ�����������������㼰Ȩֵ" << endl;
	int Array[MAX][MAX];
	for(i = 0;i < n;i++)
	{
		for(j = 0;j < n;j++)
		{
			Array[i][j] = 0;
		}
	}
	for(k = 0;k < G.sideNumber;k++)
	{
		ArcNode *p = new ArcNode;
		string v1,v2;
		cin >> v1 >> v2  >> p->weight;
		i = Locate(G,v1);
		j = Locate(G,v2);
		Array[i][j] = p->weight;
		p->tailVertex = j;
		p->nextArc = G.vertices[i].firstArc;
		G.vertices[i].firstArc = p;
	}
	int topo[MAX];
	if(!TopologicalSort(G,topo))
	{
		cout <<endl<< "����AOE��" << endl;
		return;
	}
	cout <<endl<< "��AOE��" << endl;

	string start[MAX],end[MAX];
	string path = "",path1="";
	int weight = 0;
	int s=0,e=0;//�����յ�ĸ���

	for(i=0;i<n;i++)
	{
		m=0;
		for(j=0;j<n;j++)
			if(Array[j][i]==0)
				m++;
		if(m==n)
		{
			start[s] = name[i];//���
			s++;
		}
	}

	for(i=0;i<s;i++)//����ж����㣬��ÿһ��������һ������
	{
		GetLength(Array,Locate(G,start[i]),name,n,path,path1,weight);
	}

	for(i=0;i<n;i++)
	{
		m=0;
		for(j=0;j<n;j++)
			if(Array[i][j]==0)
				m++;
		if(m==n)
		{
			end[e] = name[i];//�յ�
			e++;
		}
	}
	for(i=0;i<e;i++)//����ж���յ㣬��ѭ����ֻ��Ϊ�˵õ�-> ��������յ����ƣ�
	{
		GetLength(Array,Locate(G,end[i]),name,n,path,path1,weight);
	}
	cout << "�ؼ����" << CriticalPath <<endl;
	cout << "�ؼ�·����" << CriticalPath1 <<endl<< "·�����ȣ�" << Path<<endl;
}
