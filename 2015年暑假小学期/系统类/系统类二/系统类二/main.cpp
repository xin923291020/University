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
		cout << "��ѡ�������һ����Ŀ��" << endl;
		cout << "1 ����" << endl;
		cout << "2 ���" << endl;
		cout << "3 ��ѯ" << endl;
		cout << "4 �޸�" << endl;
		cout << "5 ɾ��" << endl;
		cout << "6 ��ʾ" << endl;
		cout << "7 �˳�" << endl;
		cout << "��ѡ��:" << endl;
		cin >> n;
		system("CLS");

		if(n == 1)
		{
			cout << "����������Ҫ��Ӷ����ˡ�" << endl;
			cin >> m;
			for(i = 0;i < m;i++)
				a[i] = a[i].set(a[i]);	//���m���ˡ�
		}
		if(n == 2)	//���һ���ˣ�m+1��
		{
			a[m] = a[m].superinduce(a[m]);
			m++;
		}
		if(n == 3)	//��������ѡ��ִ�в�ѯ��ʽ��
		{
			cout << "�������ѯ��ʽ��(1.ѧ�� 2.�༶ 3.רҵ)" << endl;
			cin >> r;
			if(r == 1)
			{
				cout << "��������Ҫ��ѯ��ѧ�š�" << endl;
				cin >> query;
			}
			if(r == 2)
			{
				cout << "��������Ҫ��ѯ�İ༶��" << endl;
				cin  >> query;
			}
			if(r == 3)
			{
				cout << "��������Ҫ��ѯ��רҵ��" << endl;
				cin  >> query;
			}
			cout << "����Ϊ��ѯ�����" << endl;
			for(i = 0;i < m;i++)
			{
				j = a[100].query(a[i],query,r,j);
			}
			if(j == 0)
			{
				cout << "�޷��Ͻ����" << endl;
			}
		}
		if(n == 4)
		{
			cout << "��������Ҫ�޸ĵ�ѧ�š�" << endl;
			cin >> revise_student_ID;

			for(i = 0;i < m;i++)	//�ҵ�һ����ѧ�ţ��˳�ѭ���������������롣
			{
				k = a[100].revise(a[i],revise_student_ID,k);
				if(k == 1)
					break;
			}
			a[i] = a[i].superinduce(a[i]);
		}
		if(n == 5)	//��������ѡ��ִ��ɾ����ʽ��
		{
			cout << "������ɾ����ʽ��(1.���� 2.ѧ��)" << endl;
			cin >> r;
			if(r == 1)
			{
				cout << "��������Ҫɾ����������" << endl;
				cin >> del;
			}
			if(r == 2)
			{
				cout << "��������Ҫɾ����ѧ�š�" << endl;
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
			cout << "����Ϊ��ѯ�����" << endl;
			for(int i = 0;i < m;i++)
				a[100].display(a[i]);
		}
	}
}