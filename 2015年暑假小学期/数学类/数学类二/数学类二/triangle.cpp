#include"triangle.h"

triangle::triangle()
{
}
triangle::~triangle()
{
}	//���캯�����鹹������

void triangle::judgement(point a,point b,point c)
{
	point A,B,C;
	if(A.length(a,b) + B.length(b,c) > C.length(a,c) && a.length(a,b) + C.length(a,c) >  B.length(b,c) &&  B.length(b,c) + C.length(a,c) > A.length(a,b))	//�ж��Ƿ�Ϊ�����Ρ�
	{
		if(A.length(a,b) ==  B.length(b,c) || A.length(a,b) == C.length(a,c) ||  B.length(b,c) == C.length(a,c))	//�Ƿ������
		{
			if(A.length(a,b) ==  B.length(b,c) && A.length(a,b) == C.length(a,c) &&  B.length(b,c) == C.length(a,c))	//�Ƿ�ȱߡ�
			{
				cout << "���㹹�ɵȱ������Ρ�" << endl;
			}
			if(sqrt(A.length(a,b) * A.length(a,b) +  B.length(b,c) * B.length(b,c)) == C.length(a,c) || sqrt(A.length(a,b) * A.length(a,b) + C.length(a,c) * C.length(a,c)) == B.length(b,c) || sqrt(B.length(b,c) * B.length(b,c) + C.length(a,c) * C.length(a,c)) == A.length(a,b))
			{	//�Ƿ���ֱ�ǡ�
				cout << "���㹹�ɵ���ֱ�������Ρ�" << endl;
			}
			else
			{
				cout  << "���㹹�ɵ��������Ρ�" << endl;
			}
		}
		else
		{
				if(sqrt(A.length(a,b) * A.length(a,b) +  B.length(b,c) * B.length(b,c)) == C.length(a,c) || sqrt(A.length(a,b) * A.length(a,b) + C.length(a,c) * C.length(a,c)) == B.length(b,c) || sqrt(B.length(b,c) * B.length(b,c) + C.length(a,c) * C.length(a,c)) == A.length(a,b))
			{	//�Ƿ���ֱ�ǡ�
				cout << "���㹹��ֱ�������Ρ�" << endl;
			}
			else
			{
				cout << "���㹹����ͨ�����Ρ�" << endl;
			}
		}
		
	}
	else
	{
		cout << "���㹹���������Ρ�" << endl;
	}
}