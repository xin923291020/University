#include"point.h"

point::point()
{
}
point::point(double xx,double yy)
{
	x = xx;
	y = yy;
}

point::~point()
{
}

void point::setX(double xx)
{
	x = xx;
}

void point::setY(double yy)
{
	y = yy;
}

double point::length(point a,point b)
{
	return sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));	//º∆À„¡Ωµ„æ‡¿Î°£
}