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

int Path = 0; //长度
string CriticalPath = ""; //活动
string CriticalPath1 = ""; //路径

void InitStack(SqStack &S)//初始化栈
{
	S.base = new int[MAX];
	if(!S.base)
	{
		exit(-2);
	}
	S.top = S.base;
	S.stacksize = MAX;
}

void Push(SqStack &S,int e)//入栈
{
	if(S.top - S.base == S.stacksize)
	{
		cout << "栈已满" << endl;
		return;
	}
	*S.top++=e;
}

void Pop(SqStack &S,int &e)//出栈
{
	if(S.top == S.base)
	{
		cout << "栈为空" << endl;
		return;
	}
	e=*--S.top;
}

bool StackEmpty(SqStack S)//判断是否栈空
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

int Locate(ALGraph G,string s)//找到顶点下标
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

int InDegree(ALGraph G,int i)//存储顶点i入度
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


bool TopologicalSort(ALGraph G,int topo[])//拓扑排序
{
	int indegree[MAX];
	FindInDegree(G,indegree);//存储各顶点入度
	SqStack S;
	InitStack(S);
	for(int i = 0;i < G.vertexNumber;i++)
	{
		if(indegree[i] == 0)//入度为进栈
		{
			Push(S,i);
		}
	}
	int m = 0;
	while(!StackEmpty(S))//栈非空
	{
		int i = -1;
		Pop(S,i);//栈顶顶点vi出栈
		topo[m] = i;//将vi保存在拓扑序列数组topo中
		m++;//对输出顶点计数
		ArcNode *p = G.vertices[i].firstArc;//p指向vi的第一个邻接点
		while(p != NULL)
		{
			int k = p->tailVertex;//vk为vi的邻接点
			indegree[k]--;//vi每个邻接点的入度减
			if(indegree[k] == 0)//入度为减为，则入栈
			{
				Push(S,k);
			}
			p = p->nextArc;//p指向vi的下一个邻接点
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
			CriticalPath += " 下一个" + path;
			CriticalPath1 += " 下一个" + path1+name[start];
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
	cout << "输入顶点数和边数" << endl;
	cin >> G.vertexNumber >> G.sideNumber;
	n = G.vertexNumber;
	cout << "依次输入顶点名称" << endl;
	for(i = 0;i < G.vertexNumber;i++)
	{
		cin >> G.vertices[i].name;
		name[i] = G.vertices[i].name;
		G.vertices[i].firstArc = NULL;
	}
	cout << "输入每条边依附的两个顶点及权值" << endl;
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
		cout <<endl<< "不是AOE网" << endl;
		return;
	}
	cout <<endl<< "是AOE网" << endl;

	string start[MAX],end[MAX];
	string path = "",path1="";
	int weight = 0;
	int s=0,e=0;//起点和终点的个数

	for(i=0;i<n;i++)
	{
		m=0;
		for(j=0;j<n;j++)
			if(Array[j][i]==0)
				m++;
		if(m==n)
		{
			start[s] = name[i];//起点
			s++;
		}
	}

	for(i=0;i<s;i++)//如果有多个起点，则将每一个起点进行一次运算
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
			end[e] = name[i];//终点
			e++;
		}
	}
	for(i=0;i<e;i++)//如果有多个终点，则循环（只是为了得到-> 后面出现终点名称）
	{
		GetLength(Array,Locate(G,end[i]),name,n,path,path1,weight);
	}
	cout << "关键活动：" << CriticalPath <<endl;
	cout << "关键路径：" << CriticalPath1 <<endl<< "路径长度：" << Path<<endl;
}
