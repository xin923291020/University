#include"triangle.h"

triangle::triangle()
{
}
triangle::~triangle()
{
}	//构造函数与虚构函数。

void triangle::judgement(point a,point b,point c)
{
	point A,B,C;
	if(A.length(a,b) + B.length(b,c) > C.length(a,c) && a.length(a,b) + C.length(a,c) >  B.length(b,c) &&  B.length(b,c) + C.length(a,c) > A.length(a,b))	//判断是否为三角形。
	{
		if(A.length(a,b) ==  B.length(b,c) || A.length(a,b) == C.length(a,c) ||  B.length(b,c) == C.length(a,c))	//是否等腰。
		{
			if(A.length(a,b) ==  B.length(b,c) && A.length(a,b) == C.length(a,c) &&  B.length(b,c) == C.length(a,c))	//是否等边。
			{
				cout << "三点构成等边三角形。" << endl;
			}
			if(sqrt(A.length(a,b) * A.length(a,b) +  B.length(b,c) * B.length(b,c)) == C.length(a,c) || sqrt(A.length(a,b) * A.length(a,b) + C.length(a,c) * C.length(a,c)) == B.length(b,c) || sqrt(B.length(b,c) * B.length(b,c) + C.length(a,c) * C.length(a,c)) == A.length(a,b))
			{	//是否有直角。
				cout << "三点构成等腰直角三角形。" << endl;
			}
			else
			{
				cout  << "三点构成等腰三角形。" << endl;
			}
		}
		else
		{
				if(sqrt(A.length(a,b) * A.length(a,b) +  B.length(b,c) * B.length(b,c)) == C.length(a,c) || sqrt(A.length(a,b) * A.length(a,b) + C.length(a,c) * C.length(a,c)) == B.length(b,c) || sqrt(B.length(b,c) * B.length(b,c) + C.length(a,c) * C.length(a,c)) == A.length(a,b))
			{	//是否有直角。
				cout << "三点构成直角三角形。" << endl;
			}
			else
			{
				cout << "三点构成普通三角形。" << endl;
			}
		}
		
	}
	else
	{
		cout << "三点构不成三角形。" << endl;
	}
}