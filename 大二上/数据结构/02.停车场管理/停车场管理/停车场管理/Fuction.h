#include"ParkingLot.h"
#include"MakeshiftRoad.h"

void CarIn(parkinglot &p,LinkQueue &Q);//车入栈或入队函数
int ComputeCost(int time,int nowtime,int cost);//计算费用函数
void PopToOther(parkinglot &p_reset,parkinglot &p,string str);//让位车由栈进复位栈
void OtherToPop(parkinglot &p_reset,parkinglot &p);//车由复位栈返回栈
void CarOut(parkinglot &p,int cost,LinkQueue &Q);//车出栈
int Display(parkinglot p,LinkQueue Q);//输出当前存车信息
void CostSet(int &cost);//费用设置
void QueueToStack(parkinglot &p,LinkQueue &Q);//车由队入栈