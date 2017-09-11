#pragma once
#include<iostream>
#include<string>
using namespace std;
#define MaxInt 32767

typedef struct
{
	char vexs[100];
	int arcs[100][100];
	int vexnum,arcnum;
	bool visited[100];
}AMGraph;

void CreateUDN(AMGraph &G);
int LocateVex(AMGraph G,char value);
void Display(AMGraph G);
void VisitedInit(AMGraph &G);
void GetKnot(int &knot);
void DFS_AM(AMGraph &G,int value);
void ShortestPath_DIJ(AMGraph G);
void ShortestPath_floyd(AMGraph G);