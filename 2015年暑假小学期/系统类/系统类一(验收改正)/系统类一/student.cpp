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
	cout << "�������ѯ��ʽ��(1.���� 2.�绰)" << endl;
	cin >> r;

	if(r == 1)
	{
		cout << "��������Ҫ��ѯ��������" << endl;
		cin >> que;
	}
	if(r == 2)
	{
		cout << "��������Ҫ��ѯ�ĵ绰��" << endl;
		cin  >> que;
	}

	for(int i = 0;i < m;i++)
	{
		j = S[i].query(S[i],que,r,j);
	}
	if(j == 0)
	{
		cout << "�޷��Ͻ����" << endl;
	}
}

void student::revise(int m)
{
	int i,k = 0;
	string revise_name;

	cout << "��������Ҫ�޸ĵ�������" << endl;
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
	cout << "������ɾ����ʽ��(1.���� 2.���)" << endl;
	cin >> r;
	if(r == 1)
	{
		cout << "��������Ҫɾ����������" << endl;
		cin >> d;
	}
	if(r == 2)
	{
		cout << "��������Ҫɾ���ı�š�" << endl;
		cin  >> d;
	}
	for(i = 0;i < m;i++)//�ҵ����������i�����θ��ǡ�
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