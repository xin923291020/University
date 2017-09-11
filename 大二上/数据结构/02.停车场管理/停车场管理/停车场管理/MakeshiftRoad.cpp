#include"MakeshiftRoad.h"

void InitQueue(LinkQueue &Q)
{
	Q.front = Q.rear = new QNode;
	Q.front->next = NULL;
}

void EnQueue(LinkQueue &Q,car newcar)
{
	QueuePtr p;
	p = new QNode;
	p->ch = newcar.ch;p->str = newcar.str;p->time = newcar.time;
	p->next = NULL;
	Q.rear->next = p;
	Q.rear = p;
}

car DeQueue(LinkQueue &Q)
{
	car e;
	QueuePtr p;
	p = Q.front->next;
	e.ch = p->ch;e.str = p->str;e.time = p->time;
	Q.front->next = p->next;
	if(Q.rear == p)
	{
		Q.rear = Q.front;
	}
	delete p;
	return e; 
}