#include"supervise_func.h"

void main()
{
	int n = 0,m,i;
	supervise_func a;

	while(n != 6)
	{
		cout << "��ѡ�������һ����Ŀ:" << endl;
		cout << "1.����(1000����)" << endl;
		cout << "2.ˮ�ɻ���" << endl;
		cout << "3.����(1000����)" << endl;
		cout << "4.ð�ݷ�����" << endl;
		cout << "5.�ַ�������Ϣ�������" << endl;
		cout << "6.�˳�" << endl;
		cout << "��ѡ��:" << endl;
		cin >> n;
		system("CLS");

		if(n == 1)
		{
			a.prime_number();
		}
		if(n == 2)
		{
			a.narcissus();
		}
		if(n == 3)
		{
			a.perfect_number();
		}
		if(n == 4)
		{
			a.reorder();
		}
		if(n == 5)
		{
			a.classify();
		}
	}
}