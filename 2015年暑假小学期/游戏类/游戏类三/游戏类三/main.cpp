#include"morra.h"

void main()
{
	int n,m,i = 1,j,k;
	morra a;

	cout << "��ѡ��ģʽ:1.��ģʽ 2.ج��ģʽ" << endl;//��ģʽΪ������Ϸ.ج��ģʽ���Բ����䡣
	cin >> j;

	while(i == 1)
	{
		cout << "���ȭ.(1.ʯͷ 2.���� 3.��)" << endl;
		cin >> n;

		if(n != 1 && n != 2 && n != 3)
		{
			cout << "����Ƿ������������롣" << endl;
			cin >> n;
		}

		m = a.produce_number();
		if(j == 1)
		{
			a.compare(n,m);//����n��m�Ĺ�ϵ�ж�ʤ����
		}
		if(j == 2)
		{
			k = a.cheat(n,m);//��������䣬�ı���������õ���Ӯ��
			if(k == 1)
			{
				if(m == 1 || m == 2)
				{
					m++;
				}
				else
				{
					m = 1;
				}
			}
			a.compare(n,m);
		}
		cout << "0.�˳���Ϸ 1.������Ϸ" << endl;
		cin >> i;
		if(i != 1)
		{
			break;
		}
	}
	a.display();
}