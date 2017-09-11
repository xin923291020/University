#include"supervise_func.h"

void main()
{
	int n = 0,m,i;
	supervise_func a;

	while(n != 6)
	{
		cout << "请选择下面的一个项目:" << endl;
		cout << "1.素数(1000以内)" << endl;
		cout << "2.水仙花数" << endl;
		cout << "3.完数(1000以内)" << endl;
		cout << "4.冒泡法排序" << endl;
		cout << "5.字符串中信息分类汇总" << endl;
		cout << "6.退出" << endl;
		cout << "请选择:" << endl;
		cin >> n;
		system("CLS");

		if(n == 1)
		{
			a.prime_number();
		}
		if(n == 2)
		{
			a.narcissus();
		}
		if(n == 3)
		{
			a.perfect_number();
		}
		if(n == 4)
		{
			a.reorder();
		}
		if(n == 5)
		{
			a.classify();
		}
	}
}