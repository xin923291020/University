#include"graph.h"

void main()
{
	int knot;
	AMGraph G;
	CreateUDN(G);
	VisitedInit(G);
	Display(G);
	GetKnot(knot);
	DFS_AM(G,knot);
	ShortestPath_DIJ(G);
	//ShortestPath_floyd(G);
}