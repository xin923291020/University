#include"student.h"

student::student()
{
}
student::~student()
{
}

student student::set(student n)
{
	cout << "请输入学号，姓名，数学，语文，英语。" << endl;
	cin >> n.student_ID >> n.name >> n.math >> n.Chinese >> n.English;

	return n;
}

student student::superinduce(student n)
{
	int i;
	cout << "请输入学号，姓名，数学，语文，英语。" << endl;
	cin >> n.student_ID >> n.name >> n.math >> n.Chinese >> n.English;

	return n;
}

void student::gather(student a[],int m)
{
	double math_sum = 0,Chinese_sum = 0,English_sum = 0,student_sum;

	for(int i = 0;i < m;i++)
	{	
		student_sum = 0;
		math_sum += a[i].math;
		Chinese_sum += a[i].Chinese;
		English_sum += a[i].English;	//各科成绩总分。
		student_sum += a[i].math + a[i].Chinese + a[i].English;
		cout << a[i].name << "的总分为" << student_sum << "。平均成绩为" << student_sum / 3 << endl;
	}
	cout << "数学平均成绩为:" << math_sum / m << endl << "语文平均成绩为:" << Chinese_sum / m << endl << "英语平均成绩为:" << English_sum / m << endl;
}

void student::reorder(student a[],int m)
{
	int student_sum[N];
	student a1[N],t;
	for(int i = 0;i < m;i++)	//以下对a1[]进行操作。
	{
		a1[i] = a[i];
	}
	for(int i = 0;i < m;i++)
	{
		student_sum[i] = a1[i].math + a1[i].Chinese + a1[i].English;
	}
	for(int i = 0;i < m - 1;i++)
	{
		for(int j = 0;j < m - i;j++)
		{
			if(student_sum[j] < student_sum[j + 1])	//j比j+1成绩低时，两人换位。
			{
				t = a1[j + 1];
				a1[j + 1] = a1[j];
				a1[j] = t;
			}
		}
	}
	for(int i = 0;i < m;i++)
	{
		cout << a1[i].student_ID << " " << a1[i].name << " " << a1[i].math << " " << a1[i].Chinese << " " << a1[i].English << endl;
	}
}

int student::query(student n,string query,int j)
{
	if(n.student_ID == query)
	{
		cout << "以下为查询结果：" << endl;
		cout << n.student_ID << " " << n.name << " " << n.math << " " << n.Chinese << " " << n.English << endl;
		j = 1;
	}
	return j;	//j的值为1时，代表找到该学生。
}

void student::display(student n)
{
	cout << n.student_ID << " " << n.name << " " << n.math << " " << n.Chinese << " " << n.English << endl;
}