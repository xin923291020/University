#include"student.h"

void main()
{
	int n = 0,m = 0,r = 0,i,j = 0,k = 0;
	string query,revise_name,del;
	people p;
	student s;
	while(n != 7)	//����7ʱ��ѭ���˳���
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
			s.resize(m);	//������m��λ�á�
			s.set(m);
		}
		if(n == 2)	//���һ���ˣ�m+1��
		{
			m++;
			s.resize(m);
			s.setone(m - 1);
		}
		if(n == 3)	//��������ѡ��ִ�в�ѯ��ʽ��
		{
			s.query(m);
		}
		if(n == 4)
		{
			s.revise(m);
		}
		if(n == 5)	//��������ѡ��ִ��ɾ����ʽ��m-1��
		{
			s.del(m);
			m--;
		}
		if(n == 6)
		{
			cout << "����Ϊ��ѯ�����" << endl;
				s.display(m);
		}
	}
	s.free();//�ͷſռ䡣
}