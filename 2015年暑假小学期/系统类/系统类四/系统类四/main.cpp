#include<stdlib.h>
#include"student.h"
void main()
{
	int n = 0,m = 0,r = 0,i,j = 0,k = 0,l,x,y;
	string query_ID,revise_name,del;
	student a[N],t;
	while(n != 7)	//����7ʱ��ѭ���˳���
	{
		cout << "��ѡ�������һ����Ŀ��" << endl;
		cout << "1 ����" << endl;
		cout << "2 ���" << endl;
		cout << "3 ����" << endl;
		cout << "4 ����" << endl;
		cout << "5 ��ѯ" << endl;
		cout << "6 ��ʾ" << endl;
		cout << "7 �˳�" << endl;
		cout << "��ѡ��:" << endl;
		cin >> n;
		system("CLS");

		if(n == 1)	//����������û����롣
		{
			cout << "����������Ҫ��Ӷ����ˡ�" << endl;
			cin >> l;
			m += l;
			for(i = 0;i < m;i++)
				a[i] = a[i].set(a[i]);
		}
		if(n == 2)	//����һ���ˣ������������δʵ�֡�
		{
			cout << "0.���м����һ�� 1.��ĩβ��Ӽ���" << endl;
			cin >> y;
			if(y == 0)
			{
				cout << "������Ҫ�����λ�á�" << endl;
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
				cout << "������Ҫ��ӵ�����" << endl;
				cin >> l;
				for(i = m;i < l + m;i++)
				{
					a[i] = a[i].superinduce(a[i]);
				}
				m += l;
			}
		}
		if(n == 3)	//�������ÿ��ƽ���֣�ȫ���ֺܷ�ƽ���֡�
		{
			a[100].gather(a,m);
		}
		if(n == 4)	//�����ֽܷ��������
		{
			a[100].reorder(a,m);
		}
		if(n == 5)	//����ѧ�Ų�ѯ��
		{
			cout << "������ѧ�š�" << endl;
			cin >> query_ID;
			for(i = 0;i < m;i++)
			{
				j = a[100].query(a[i],query_ID,j);
			}
			if(j == 0)
			{
				cout << "�޷��Ͻ����" << endl;
			}
		}
		if(n == 6)
		{
			cout << "����Ϊ��ѯ�����" << endl;
			for(int i = 0;i < m;i++)
				a[100].display(a[i]);
		}
	}
}