#include "play_chess.h"

play_chess::play_chess(void)	//û����ĵط����������ո�"��""��"ռ�������ո�
{
	for(int i = 0;i < 3;i++)
		for(int j = 0;j < 3;j++)
		{	
			a[i][j] = "  ";
			b[i][j] = 0;
		}
}

play_chess::~play_chess(void)
{
}

int play_chess::judgement()	//�������ĵط����1.��������ĵط����4.���жԽ��ߺ�Ϊ3���ʤ.��Ϊ12����ʤ��
{
	int r,sum = 0,z = 0;

	for(r = 0;r < 3;r++)
	{
		sum += b[r][0] + b[r][1] + b[r][2];
		if(sum == 3)
		{
			cout << "���ʤ!" << endl;
			z = 1;
			break;
		}
		if(sum == 12)
		{
			cout << "����ʤ!" << endl;
			z = 1;
			break;
		}
		sum = 0;
	}
	for(r = 0;r < 3;r++)
	{
		sum += b[0][r] + b[1][r] + b[2][r];
		if(sum == 3)
		{
			cout << "���ʤ!" << endl;
			z = 1;
			break;
		}
		if(sum == 12)
		{
			cout << "����ʤ!" << endl;
			z = 1;
			break;
		}
		sum = 0;
	}
	if(b[0][0] + b[1][1] + b[2][2] == 3 || b[2][0] + b[1][1] + b[0][2] == 3)
	{
		cout << "���ʤ!" << endl;
		z = 1;
	}
	if(b[0][0] + b[1][1] + b[2][2] == 12 || b[2][0] + b[1][1] + b[0][2] == 12)
	{
		cout << "����ʤ!" << endl;
		z = 1;
	}
	return z;
}

int play_chess::close_win(string s,int j)
{
	int r,sum = 0;

	for(r = 0;r < 3;r++)
	{
		sum += b[r][0] + b[r][1] + b[r][2];
		if(sum == 8)
		{
			if(b[r][0] == 0)
				a[r][0] = s,b[r][0] = 4;
			if(b[r][1] == 0)
				a[r][1] = s,b[r][1] = 4;
			if(b[r][2] == 0)
				a[r][2] = s,b[r][2] = 4;
			return j = 1;
		}
		sum =0;
	}

	for(r = 0;r < 3;r++)
	{
		sum += b[0][r] + b[1][r] + b[2][r];
		if(sum == 8)
		{
			if(b[0][r] == 0)
				a[0][r] = s,b[0][r] = 4;
			if(b[1][r] == 0)
				a[1][r] = s,b[1][r] = 4;
			if(b[2][r] == 0)
				a[2][r] = s,b[2][r] = 4;
			return j = 1;;
		}
		sum = 0;
	}

	if(b[0][0] + b[1][1] + b[2][2] == 8)
	{
		if(b[0][0] == 0)
			a[0][0] = s,b[0][0] = 4;
		if(b[1][1] == 0)
			a[1][1] = s,b[1][1] = 4;
		if(b[2][2] == 0)
			a[2][2] = s,b[2][2] = 4;
		return j = 1;
	}

	if(b[2][0] + b[1][1] + b[0][2] == 8)
	{
		if(b[2][0] == 0)
			a[2][0] = s,b[2][0] = 4;
		if(b[1][1] == 0)
			a[1][1] = s,b[1][1] = 4;
		if(b[0][2] == 0)
			a[0][2] = s,b[0][2] = 4;
		return j = 1;
	}
//����Ϊ������һ��Ӯ�������һ��Ϊ��һ�����Ӯ�������Ҫ�¡�
	for(r = 0;r < 3;r++)
	{
		sum += b[r][0] + b[r][1] + b[r][2];
		if(sum == 2)
		{
			if(b[r][0] == 0)
				a[r][0] = s,b[r][0] = 4;
			if(b[r][1] == 0)
				a[r][1] = s,b[r][1] = 4;
			if(b[r][2] == 0)
				a[r][2] = s,b[r][2] = 4;
			return j = 1;
		}
		sum =0;
	}

	for(r = 0;r < 3;r++)
	{
		sum += b[0][r] + b[1][r] + b[2][r];
		if(sum == 2)
		{
			if(b[0][r] == 0)
				a[0][r] = s,b[0][r] = 4;
			if(b[1][r] == 0)
				a[1][r] = s,b[1][r] = 4;
			if(b[2][r] == 0)
				a[2][r] = s,b[2][r] = 4;
			return j = 1;;
		}
		sum = 0;
	}

	if(b[0][0] + b[1][1] + b[2][2] == 2)
	{
		if(b[0][0] == 0)
			a[0][0] = s,b[0][0] = 4;
		if(b[1][1] == 0)
			a[1][1] = s,b[1][1] = 4;
		if(b[2][2] == 0)
			a[2][2] = s,b[2][2] = 4;
		return j = 1;
	}

	if(b[2][0] + b[1][1] + b[0][2] == 2)
	{
		if(b[2][0] == 0)
			a[2][0] = s,b[2][0] = 4;
		if(b[1][1] == 0)
			a[1][1] = s,b[1][1] = 4;
		if(b[0][2] == 0)
			a[0][2] = s,b[0][2] = 4;
		return j = 1;
	}
	return j;
}

void play_chess::play(int m)
{
	int sum = 0,z = 0,i,j;
	
	while(1)
	{
		z = judgement();
		if(z == 1)
		{
			break;
		}	//zΪ1ʱ��˵����ʤ���ߡ��˳�ѭ������Ϸ������
		if(b[0][0] != 0 && b[0][1] != 0 && b[0][3] != 0 && b[1][0] != 0 && b[1][1] != 0 && b[1][2] != 0 && b[2][0] != 0 && b[2][1] != 0&& b[2][2] != 0)
		{
			cout << "ƽ��!" << endl;
			break;
		}//����ʤ���������еط������ʱ���޵ؿ��¡���ͬ��
		cout << "������:" << endl;
		cin >> i >> j;
		while(1)
		{
			if(b[i - 1][j - 1] == 0)
			{
				if(m == 0)	//	����m��ֵ�ж�����õ���ʲô�ӣ���ͬ��
				{
					a[i - 1][j - 1] = "��";
				}
				if(m == 1)
				{
					a[i - 1][j - 1] = "��";
				}
				b[i - 1][j - 1] = 1;
				break;
			}
			else
			{
				cout << "��λ�ò�Ϊ�գ�����������" << endl;
				cin >> i >> j;
			}
		}
		display();
		z = judgement();
		if(z == 1)
		{
			break;
		}
		if(b[0][0] != 0 && b[0][1] != 0 && b[0][3] != 0 && b[1][0] != 0 && b[1][1] != 0 && b[1][2] != 0 && b[2][0] != 0 && b[2][1] != 0&& b[2][2] != 0)
		{
			cout << "ƽ��!" << endl;
			break;
		}
		anticipate(m);
	}
}

void play_chess::anticipate(int m)	//�����ѡ����ֵ�ʱ��ִ�д˺������õ�������һ�ӡ�
{
	int x,y,j;
	while(1)
	{
		j = 0;
		srand((int)time(NULL));
		x = rand() % 3 + 0;
		Sleep(500);
		y = rand() % 3 + 0;
		if(m == 0)//�õ�����ʱ����ҪӮ��Ҫ��ʱ���ı���������
		{
			j = close_win("��",j);
		}
		if(m == 1)
		{
			j = close_win("��",j);
		}
		if(j == 1)
		{
			display();
			break;
		}
		if(j == 0)
		{
			if(b[x][y] == 0)
			{
				if(m == 0)
				{
					a[x][y] = "��";
				}
				if(m == 1)
				{
					a[x][y] = "��";
				}
				b[x][y] = 4;
				display();
				break;
			}
		}
	}
}
void play_chess::display()
{
	cout << "�����Щ��Щ���" << endl;
	cout << "��" << a[0][0] << "��" << a[0][1] << "��" << a[0][2] <<"��" << endl;
	cout << "�����੤�੤��" << endl;
	cout << "��" << a[1][0] << "��" << a[1][1] << "��" << a[1][2] <<"��" << endl;
	cout << "�����੤�੤��" << endl;
	cout << "��" << a[2][0] << "��" << a[2][1] << "��" << a[2][2] <<"��" << endl;
	cout << "�����ة��ة���" << endl;
}