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

void InitQueue(LinkQueue &Q);//���г�ʼ��
void EnQueue(LinkQueue &Q,car newcar);//��Ӻ���
car DeQueue(LinkQueue &Q);//���Ӻ���