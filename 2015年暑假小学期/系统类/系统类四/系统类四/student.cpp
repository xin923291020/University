#include"student.h"

student::student()
{
}
student::~student()
{
}

student student::set(student n)
{
	cout << "������ѧ�ţ���������ѧ�����ģ�Ӣ�" << endl;
	cin >> n.student_ID >> n.name >> n.math >> n.Chinese >> n.English;

	return n;
}

student student::superinduce(student n)
{
	int i;
	cout << "������ѧ�ţ���������ѧ�����ģ�Ӣ�" << endl;
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
		English_sum += a[i].English;	//���Ƴɼ��ܷ֡�
		student_sum += a[i].math + a[i].Chinese + a[i].English;
		cout << a[i].name << "���ܷ�Ϊ" << student_sum << "��ƽ���ɼ�Ϊ" << student_sum / 3 << endl;
	}
	cout << "��ѧƽ���ɼ�Ϊ:" << math_sum / m << endl << "����ƽ���ɼ�Ϊ:" << Chinese_sum / m << endl << "Ӣ��ƽ���ɼ�Ϊ:" << English_sum / m << endl;
}

void student::reorder(student a[],int m)
{
	int student_sum[N];
	student a1[N],t;
	for(int i = 0;i < m;i++)	//���¶�a1[]���в�����
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
			if(student_sum[j] < student_sum[j + 1])	//j��j+1�ɼ���ʱ�����˻�λ��
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
		cout << "����Ϊ��ѯ�����" << endl;
		cout << n.student_ID << " " << n.name << " " << n.math << " " << n.Chinese << " " << n.English << endl;
		j = 1;
	}
	return j;	//j��ֵΪ1ʱ�������ҵ���ѧ����
}

void student::display(student n)
{
	cout << n.student_ID << " " << n.name << " " << n.math << " " << n.Chinese << " " << n.English << endl;
}