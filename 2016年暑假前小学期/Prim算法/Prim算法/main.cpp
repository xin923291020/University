#include<iostream>
#include<string>
using  namespace std;

#define MAX 100
#define MAXCOST 0x7fffffff

typedef struct
{
	string vertexName[MAX];
	int graph[MAX][MAX];
	int vertexNumber,sideNumber;
}Graph;

int Locate(Graph G,string n)
{
	for(int i = 1;i <= G.vertexNumber;i++)
	{
		if(n == G.vertexName[i])
		{
			return i;
		}
	}
}

int prim(Graph G)
{
    int lowcost[MAX];
    int start[MAX];
    int minCost,next,SUM = 0;
	for(int i = 2;i <= G.vertexNumber;i++)
    {
        lowcost[i] = G.graph[1][i];
        start[i] = 1;
    }
    start[1] = 0;
    for (int i = 2;i <= G.vertexNumber;i++)
    {
        minCost = MAXCOST;
        next = 0;
        for (int j = 2;j <= G.vertexNumber;j++)
        {
            if (lowcost[j] < minCost && lowcost[j] != 0)
            {
                minCost = lowcost[j];
                next = j;
            }
        }
		cout << G.vertexName[start[next]] << " - " << G.vertexName[next] << " = " << minCost << endl;
        SUM += minCost;
        lowcost[next] = 0;
        for (int j = 2;j <= G.vertexNumber;j++)
        {
            if (G.graph[next][j] < lowcost[j])
            {
                lowcost[j] = G.graph[next][j];
                start[j] = next;
            }
        }
    }
    return SUM;
}

void main()
{
	Graph G;
    int cost;
	cout << "������ߵĶ������ͱ�����" << endl;
    cin >> G.vertexNumber >> G.sideNumber;
    for(int i = 1;i <= G.vertexNumber;i++)  
    {
        for(int j = 1;j <= G.sideNumber;j++)
        {
            G.graph[i][j] = MAXCOST;
        }
    }
	cout << "������ߵ����֡�" << endl;
    for(int i = 1;i <= G.vertexNumber;i++)  
    {
		cin >> G.vertexName[i];
    }
	cout << "������ÿ���������ıߺ�Ȩֵ��" << endl;
    for(int k = 1;k <= G.sideNumber;k++)
    {
		string v1,v2;
        cin >> v1 >> v2 >> cost;
		int i = Locate(G,v1);
		int j = Locate(G,v2);
        G.graph[i][j] = cost;
        G.graph[j][i] = cost;
    }
	cout << endl;
    cost = prim(G);
    cout << "��СȨֵ��Ϊ" << cost << endl;
}