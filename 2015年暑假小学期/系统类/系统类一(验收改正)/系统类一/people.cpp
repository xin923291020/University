#include "people.h"

people::people(void)
{
}

people::~people(void)
{
}

people people::set()
{
	people n;

	cout << "请输入编号，姓名，性别，年龄，宅电，电话。" << endl;
	cin >> n.identifier >> n.name >> n.sex >> n.age >> n.home_phone_number >> n.telephone;

	return n;
}

int people::query(people n,string que,int r,int j)
{
	if(r == 1)
	{
		if(n.name == que)
		{
			cout << "以下为查询结果：" << endl;
			cout << n.identifier << " " << n.name << " " << n.sex << " " << n.age << " " << n.home_phone_number << " " << n.telephone << endl;
			j = 1;
		}
	}
	if(r == 2)
	{
		if(n.telephone == que)
		{
			cout << "以下为查询结果：" << endl;
			cout << n.identifier << " " << n.name << " " << n.sex << " " << n.age << " " << n.home_phone_number << " " << n.telephone << endl;
			j = 1;
		}
	}

	return j;
}

int people::revise(people n,string revise_name,int k)
{
	if(n.name == revise_name)
	{
		k = 1;
	}
	return k;
}

int people::del(people n,string d,int k,int r)
{
	if(r == 1)
	{
		if(n.name == d)
		{
			k = 1;
		}
	}
	if(r == 2)
	{
		if(n.identifier == d)
		{
			k = 1;
		}
	}
	return k;
}

void people::display(people n)
{	
	cout << n.identifier << " " << n.name << " " << n.sex << " " << n.age << " " << n.home_phone_number << " " << n.telephone << endl;
}