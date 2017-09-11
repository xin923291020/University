#include<stdlib.h>
#include"supervise_info.h"
#define N 101

void main()
{
	int n = 0,m = 0,r = 0,i,j = 0,k = 0;
	string query,revise_student_ID,del;
	supervise_info a[N];
	while(n != 7)
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
			for(i = 0;i < m;i++)
				a[i] = a[i].set(a[i]);	//添加m个人。
		}
		if(n == 2)	//添加一个人，m+1。
		{
			a[m] = a[m].superinduce(a[m]);
			m++;
		}
		if(n == 3)	//根据输入选择执行查询方式。
		{
			cout << "请输入查询方式。(1.学号 2.班级 3.专业)" << endl;
			cin >> r;
			if(r == 1)
			{
				cout << "请输入需要查询的学号。" << endl;
				cin >> query;
			}
			if(r == 2)
			{
				cout << "请输入需要查询的班级。" << endl;
				cin  >> query;
			}
			if(r == 3)
			{
				cout << "请输入需要查询的专业。" << endl;
				cin  >> query;
			}
			cout << "以下为查询结果：" << endl;
			for(i = 0;i < m;i++)
			{
				j = a[100].query(a[i],query,r,j);
			}
			if(j == 0)
			{
				cout << "无符合结果。" << endl;
			}
		}
		if(n == 4)
		{
			cout << "请输入需要修改的学号。" << endl;
			cin >> revise_student_ID;

			for(i = 0;i < m;i++)	//找到一样的学号，退出循环。令其重新输入。
			{
				k = a[100].revise(a[i],revise_student_ID,k);
				if(k == 1)
					break;
			}
			a[i] = a[i].superinduce(a[i]);
		}
		if(n == 5)	//根据输入选择执行删除方式。
		{
			cout << "请输入删除方式。(1.姓名 2.学号)" << endl;
			cin >> r;
			if(r == 1)
			{
				cout << "请输入需要删除的姓名。" << endl;
				cin >> del;
			}
			if(r == 2)
			{
				cout << "请输入需要删除的学号。" << endl;
				cin  >> del;
			}
			for(i = 0;i < m;i++)
			{
				k = a[100].del(a[i],del,k,r);
				if(k == 1)
					break;
			}
			for(j = i;j < m;j++)
			{
				a[j] = a[j+1];
			}
			m--;
		}
		if(n == 6)
		{
			cout << "以下为查询结果。" << endl;
			for(int i = 0;i < m;i++)
				a[100].display(a[i]);
		}
	}
}