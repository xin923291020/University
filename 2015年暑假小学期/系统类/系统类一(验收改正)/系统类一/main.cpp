#include"student.h"

void main()
{
	int n = 0,m = 0,r = 0,i,j = 0,k = 0;
	string query,revise_name,del;
	people p;
	student s;
	while(n != 7)	//输入7时，循环退出。
	{
		cout << "请选择下面的一个项目：" << endl;
		cout << "1 创建" << endl;
		cout << "2 添加" << endl;
		cout << "3 查询" << endl;
		cout << "4 修改" << endl;
		cout << "5 删除" << endl;
		cout << "6 显示" << endl;
		cout << "7 退出" << endl;
		cout << "请选择:" << endl;
		cin >> n;
		system("CLS");

		if(n == 1)
		{
			cout << "请输入你想要添加多少人。" << endl;
			cin >> m;
			s.resize(m);	//给数组m个位置。
			s.set(m);
		}
		if(n == 2)	//添加一个人，m+1。
		{
			m++;
			s.resize(m);
			s.setone(m - 1);
		}
		if(n == 3)	//根据输入选择执行查询方式。
		{
			s.query(m);
		}
		if(n == 4)
		{
			s.revise(m);
		}
		if(n == 5)	//根据输入选择执行删除方式，m-1。
		{
			s.del(m);
			m--;
		}
		if(n == 6)
		{
			cout << "以下为查询结果。" << endl;
				s.display(m);
		}
	}
	s.free();//释放空间。
}