//Chengxin Yang��Dec.2 2014

#include <iostream>
using namespace std;

void main()
{
	int n,t;
	bool flag = 0;

	cout << "�������жϵ���ݣ�" << endl;
	cin >> n;

	t = n % 100;
	
	while(t)
	{
		if(n % 4 == 0)
			flag = 1;
		break;
	}

	if(n % 400 == 0)
		flag = 1;

	if(flag == 0)
		cout << n << "�������ꡣ" <<endl;
	else
		cout << n << "�����ꡣ" <<endl;
}