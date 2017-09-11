#include"point.h"

class triangle
{
private:
	point a;
	point b;
	point c;
public:
	triangle();
	~triangle();
	void judgement(point a,point b,point c);
};