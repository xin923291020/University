#include"supervise_info.h"

supervise_info::supervise_info()
{
}
supervise_info::~supervise_info()
{
}

supervise_info supervise_info::set(supervise_info n)
{
	cout << "请输入学号，姓名，性别，年龄，班级，学院，专业。" << endl;
	cin >> n.student_ID >> n.name >> n.sex >> n.age >> n.grade >> n.college >> n.specialty;

	return n;
}

supervise_info supervise_info::superinduce(supervise_info n)
{
	cout << "请输入学号，姓名，性别，年龄，班级，学院，专业" << endl;
	cin >> n.student_ID >> n.name >> n.sex >> n.age >> n.grade >> n.college >> n.specialty;

	return n;
}

int supervise_info::query(supervise_info n,string query,int r,int j)
{
	if(r == 1)
	{
		if(n.student_ID == query)
		{
			cout << n.student_ID << " " << n.name << " " << n.sex << " " << n.age << " " << n.grade << " " << n.college << " " << n.specialty << endl;
			j = 1;
		}
	}
	if(r == 2)
	{
		if(n.grade == query)
		{
			cout << n.student_ID << " " << n.name << " " << n.sex << " " << n.age << " " << n.grade << " " << n.college << " " << n.specialty << endl;
			j = 1;
		}
	}
	if(r == 3)
	{
		if(n.specialty == query)
		{
			cout << n.student_ID << " " << n.name << " " << n.sex << " " << n.age << " " << n.grade << " " << n.college << " " << n.specialty << endl;
			j = 1;
		}
	}
	return j;	//当j返回1时，向下执行，下同。
}

int supervise_info::revise(supervise_info n,string revise_student_ID,int k)
{
	if(n.student_ID == revise_student_ID)
	{
		k = 1;
	}
	return k;
}

int supervise_info::del(supervise_info n,string del,int l,int r)
{
	if(r == 1)
	{
		if(n.name == del)
		{
			l = 1;
		}
	}
	if(r == 2)
	{
		if(n.student_ID == del)
		{
			l = 1;
		}
	}
	return l;
}

void supervise_info::display(supervise_info n)
{
	cout << n.student_ID << " " << n.name << " " << n.sex << " " << n.age << " " << n.grade << " " << n.college << " " << n.specialty << endl;
}