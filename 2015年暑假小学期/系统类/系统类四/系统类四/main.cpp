#include<stdlib.h>
#include"student.h"
void main()
{
	int n = 0,m = 0,r = 0,i,j = 0,k = 0,l,x,y;
	string query_ID,revise_name,del;
	student a[N],t;
	while(n != 7)	//输入7时，循环退出。
	{
		cout << "请选择下面的一个项目：" << endl;
		cout << "1 创建" << endl;
		cout << "2 添加" << endl;
		cout << "3 汇总" << endl;
		cout << "4 排序" << endl;
		cout << "5 查询" << endl;
		cout << "6 显示" << endl;
		cout << "7 退出" << endl;
		cout << "请选择:" << endl;
		cin >> n;
		system("CLS");

		if(n == 1)	//添加人数，用户输入。
		{
			cout << "请输入你想要添加多少人。" << endl;
			cin >> l;
			m += l;
			for(i = 0;i < m;i++)
				a[i] = a[i].set(a[i]);
		}
		if(n == 2)	//插入一个人，插入后排序功能未实现。
		{
			cout << "0.在中间插入一人 1.在末尾添加几人" << endl;
			cin >> y;
			if(y == 0)
			{
				cout << "请输入要插入的位置。" << endl;
				cin >> x;
				for(i = m;i > x;i--)
				{
					a[i] = a[i - 1];
				}
				a[x] = a[100].superinduce(a[x]);
				m++;
			}
			if(y == 1)
			{
				cout << "请输入要添加的人数" << endl;
				cin >> l;
				for(i = m;i < l + m;i++)
				{
					a[i] = a[i].superinduce(a[i]);
				}
				m += l;
			}
		}
		if(n == 3)	//输出个人每科平均分，全体总分和平均分。
		{
			a[100].gather(a,m);
		}
		if(n == 4)	//根据总分降序输出。
		{
			a[100].reorder(a,m);
		}
		if(n == 5)	//根据学号查询。
		{
			cout << "请输入学号。" << endl;
			cin >> query_ID;
			for(i = 0;i < m;i++)
			{
				j = a[100].query(a[i],query_ID,j);
			}
			if(j == 0)
			{
				cout << "无符合结果。" << endl;
			}
		}
		if(n == 6)
		{
			cout << "以下为查询结果。" << endl;
			for(int i = 0;i < m;i++)
				a[100].display(a[i]);
		}
	}
}