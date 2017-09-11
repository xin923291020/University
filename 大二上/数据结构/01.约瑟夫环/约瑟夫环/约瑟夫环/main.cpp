//单链表实现约瑟夫环。杨程鑫。20142863。2015.10.11.

#include"Fuction.h"

void main()
{
	int e,max,i,j = 0;
	ElemNumberInput(max);
	InitPassworGet(e);
	int now = max;
	LinkList L;
	CreateList(L,now);
	system("CLS");
	ListOutput(L,now);
	ListDelete(L,i,e,now);
}