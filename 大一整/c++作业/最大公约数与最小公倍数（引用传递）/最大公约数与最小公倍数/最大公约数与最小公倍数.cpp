//Chengxin Yang,Nov.21 2014

#include <iostream>
using namespace std;
void swap(int &a,int &b,int &p,int &q);

int main()
{
	int a,b,c,d;
	cout << "请依次输入两个数：" <<endl;
	cin >> a >> b;
	swap(a,b,c,d);

	cout << a << "和" << b << "的最大公因数和最小公倍数是：" << c << "和" << d <<endl;

	return 0;
}

void swap(int &a,int &b,int &p,int &q)
{
	p = a;
	q = b;

	int temp,r,s = (p) * (q);
	
	if(p < q)
	{
		temp = p;
		p = q;
		q = temp;
	}

	while(q != 0)
	{
		r = p % q;
		p = q;
		q = r;
	}

	q = s / (p);
}