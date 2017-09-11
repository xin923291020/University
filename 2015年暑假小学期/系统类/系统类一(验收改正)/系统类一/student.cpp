#include "student.h"

student::student(void)
{
}

student::~student(void)
{
}

void student::resize(int m)
{
	S.resize(m);
}

void student::set(int m)
{
	for(int i = 0;i < m;i++)
	{
		S[i] = S[i].set();
	}
}

void student::setone(int m)
{
	S[m] = S[m].set();
}

void student::query(int m)
{
	int r,j = 2;
	string que;
	cout << "请输入查询方式。(1.姓名 2.电话)" << endl;
	cin >> r;

	if(r == 1)
	{
		cout << "请输入需要查询的姓名。" << endl;
		cin >> que;
	}
	if(r == 2)
	{
		cout << "请输入需要查询的电话。" << endl;
		cin  >> que;
	}

	for(int i = 0;i < m;i++)
	{
		j = S[i].query(S[i],que,r,j);
	}
	if(j == 0)
	{
		cout << "无符合结果。" << endl;
	}
}

void student::revise(int m)
{
	int i,k = 0;
	string revise_name;

	cout << "请输入需要修改的姓名。" << endl;
	cin >> revise_name;

	for(i = 0;i < m;i++)
	{
		k = S[i].revise(S[i],revise_name,k);
		if(k == 1)
			break;
	}
	S[i] = S[i].set();
}

void student::del(int m)
{
	int r,i,j,k = 0;
	string d;
	cout << "请输入删除方式。(1.姓名 2.编号)" << endl;
	cin >> r;
	if(r == 1)
	{
		cout << "请输入需要删除的姓名。" << endl;
		cin >> d;
	}
	if(r == 2)
	{
		cout << "请输入需要删除的编号。" << endl;
		cin  >> d;
	}
	for(i = 0;i < m;i++)//找到所找数组的i，依次覆盖。
	{
		k = S[i].del(S[i],d,k,r);
		if(k == 1)
			break;
	}
	for(j = i;j < m - 1;j++)
	{
		S[j] = S[j+1];
	}
}

void student::display(int m)
{
	for(int i = 0;i < m;i++)
	{
		S[i].display(S[i]);
	}
}

void student::free()
{
	S.clear();
}