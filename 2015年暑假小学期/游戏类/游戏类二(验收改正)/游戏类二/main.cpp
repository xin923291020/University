#include"play_chess.h"

void main()
{
	play_chess a;
	int n,m;

	cout << "��ѡ�����ֻ��Ǻ���:0.���� 1.����" << endl;
	cin >> n;
	cout << "��ѡ��ִX�廹��O��(0.X 1.O)" << endl;
	cin >> m;
	cout << "���ӷ��������뼸�м��С�" << endl;

	if(n == 0)
	{
		a.play(m);
	}
	if(n == 1)
	{
		a.anticipate(m);
		a.play(m);
	}
}