//Chengxin Yang，Dec.2 2014

#include <iostream>
using namespace std;

void main()
{
	int n,t;
	bool flag = 0;

	cout << "请输入判断的年份：" << endl;
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
		cout << n << "不是闰年。" <<endl;
	else
		cout << n << "是闰年。" <<endl;
}