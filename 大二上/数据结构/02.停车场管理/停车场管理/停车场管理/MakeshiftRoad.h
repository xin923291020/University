#include"ParkingLot.h"

typedef struct QNode
{
	char ch;
	string str;
	int time;
	int number;
	struct QNode *next;
}QNode,*QueuePtr;
typedef struct
{
	QueuePtr front;
	QueuePtr rear;
}LinkQueue;

void InitQueue(LinkQueue &Q);//队列初始化
void EnQueue(LinkQueue &Q,car newcar);//入队函数
car DeQueue(LinkQueue &Q);//出队函数