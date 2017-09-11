#include"graph.h"

void CreateUDN(AMGraph &G)
{
	int i,j,w;
	char v1,v2;
	cout << "�����������ܶ��������ܱ�����" << endl;
	cin >> G.vexnum >> G.arcnum;
	cout << "��������������Ϣ��" << endl;
	for(i = 0;i < G.vexnum;i++)
	{
		cin >> G.vexs[i];
	}
	for(i = 0;i < G.vexnum;i++)
	{
		for(j = 0;j < G.vexnum;j++)
		{
			G.arcs[i][j] = MaxInt;
		}
	}
	for(int k = 0;k < G.arcnum;k++)
	{
		cout << "����������һ���������Ķ��㼰Ȩֵ��" << endl;
		cin >> v1 >> v2 >> w;
		i = LocateVex(G,v1);
		j = LocateVex(G,v2);
		G.arcs[i][j] = w;
	}
}

int LocateVex(AMGraph G,char value)
{
	for(int i = 0;i < G.vexnum;i++)
	{
		if(G.vexs[i] == value)
		{
			return i;
		}
	}
}

void Display(AMGraph G)
{
	cout << "�ڽӾ���Ϊ��" << endl;
	for(int i = 0;i < G.vexnum;i++)
	{
		for(int j = 0;j < G.vexnum;j++)
		{
			if(G.arcs[i][j] == MaxInt)
			{
				cout << G.arcs[i][j] << "  ";
			}
			else
				cout << "  " << G.arcs[i][j] << "    ";
		}
		cout << endl;
	}
	cout << endl;
}

void VisitedInit(AMGraph &G)
{
	for(int i = 0;i < G.vexnum;i++)
	{
		G.visited[i] = false;
	}
	cout << endl;
}

void GetKnot(int &knot)
{
	cout << "�����������ʼ��㡣" << endl;
	cin >> knot;
	cout << endl << "����·��Ϊ:";
}

void DFS_AM(AMGraph &G,int value)
{
	cout << G.vexs[value] << " ";
	G.visited[value] = true;

	for(int i = 0;i < G.vexnum;i++)
	{
		if((G.arcs[value][i] != 32767) && (!G.visited[i]))
		{
			DFS_AM(G,i);
		}
	}
}

void ShortestPath_DIJ(AMGraph G)
{
	int v0,v,D[100],Path[100];
	cout << endl << "������ĳ�㡣" << endl;
	cin >> v0;
	
	bool S[100];string p[100];
	int n = G.vexnum;
	for(v = 0;v < n;v++)
	{
		S[v] = false;
		D[v] = G.arcs[v0][v];
		if(D[v] < MaxInt)
		{
			Path[v] = v0;
		}
		else
		{
			Path[v] = -1;
		}
	}
	S[v0] = true;
	D[v0] = 0;
	for(int i = 1;i < n;i++)
	{
		int min = MaxInt;
		for(int w = 0;w < n;w++)
		{
			if(!S[w] && D[w] < min)
			{
				v = w;
				min = D[w];
			}
		}
		S[v] = true;
		for(int w = 0;w < n;w++)
		{
			if(!S[w] && (D[v] + G.arcs[v][w] < D[w]))
			{
				D[w] = D[v] + G.arcs[v][w];
				Path[w] = v;
			}
		}
	}
	for(int i = 0;i < n;i++)
	{
		if(i != v0)
		{
			cout << G.vexs[v0] << " �� " << G.vexs[i] << " �����·������Ϊ " << D[i] << endl;
		}
		else
		{
			continue;
		}
		int k = i,j = 0,jj;
		while(1)
		{
			if(Path[k] == -1)
			{
				p[j] = G.vexs[k];
				jj = j;
				break;
			}
			p[j] = G.vexs[k];
			k = Path[k];
			j++;
		}
		if(D[i] != MaxInt)
		{
			cout << "���·��:";
			for(j = jj;j >= 0;j--)
			{
				cout << p[j] << "--";
			}
			cout << endl;
		}
		cout << endl;
	}
}

void ShortestPath_floyd(AMGraph G)
{
	int i,j,D[100][100],Path[100][100];
	for(i = 0;i < G.vexnum;i++)
	{
		for(j = 0;j < G.vexnum;j++)
		{
			D[i][j] = G.arcs[i][j];
			if(D[i][j] < 32767)
			{
				Path[i][j] = i;
			}
			else
				Path[i][j] = -1;
		}
	}

	for(int k = 0;k < G.vexnum;k++)
	{
		for(i = 0;i < G.vexnum;i++)
		{
			for(j = 0;j < G.vexnum;j++)
			{
				if(D[i][k] + D[k][j] < D[i][j])
				{
					D[i][j] = D[i][k] + D[k][j];
					Path[i][j] = Path[k][j];
				}
			}
		}
	}
	char v1,v2;
	cout << endl << "�����������·���������㡣" << endl;
	cin >> v1 >> v2;
	i = LocateVex(G,v1);
	j = LocateVex(G,v2);
	cout << v1 << "��" << v2 << "�����·��Ϊ" << D[i][j] << endl;;
}