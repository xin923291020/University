#include"ParkingLot.h"

int InitStack(parkinglot &p)
{
	p.base = new car[MAXSIZE];
	if(!p.base)
	{
		exit(OVERFLOW);
	}
	p.top = p.base;
	p.stacksize = MAXSIZE;
	return 0;
}

int Push(parkinglot &p,car e)
{
	if(e.ch == 'n')
	{
		return 0;
	}
	*p.top++ = e;
	return 0;
}

car Pop(parkinglot &p)
{
	car e;
	e.ch = 'n';
	if(p.top == p.base)
	{
		return e;
	}
	e = *--p.top;
	return e;
}

car GetTop(parkinglot p)
{
	if(p.top != p.base)
	{
		return *(p.top - 1);
	}
}