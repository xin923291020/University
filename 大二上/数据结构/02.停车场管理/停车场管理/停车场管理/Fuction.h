#include"ParkingLot.h"
#include"MakeshiftRoad.h"

void CarIn(parkinglot &p,LinkQueue &Q);//����ջ����Ӻ���
int ComputeCost(int time,int nowtime,int cost);//������ú���
void PopToOther(parkinglot &p_reset,parkinglot &p,string str);//��λ����ջ����λջ
void OtherToPop(parkinglot &p_reset,parkinglot &p);//���ɸ�λջ����ջ
void CarOut(parkinglot &p,int cost,LinkQueue &Q);//����ջ
int Display(parkinglot p,LinkQueue Q);//�����ǰ�泵��Ϣ
void CostSet(int &cost);//��������
void QueueToStack(parkinglot &p,LinkQueue &Q);//���ɶ���ջ