#include "guess.h"

DWORD WINAPI Fun(LPVOID lpParamter)	//������������ֺ�ʼ����ʱ��
{
	int n;
	cin >> n;
	n += 5;//����������ʵ������ǰͣ��5�룬�˴����ϡ�
	while(n >= 0)
	{
		Sleep(1000);
		n--;
	}
	cout << "�ź�,δ���ڹ涨ʱ���ڲ³���ȷ����,����Լ�����Ϸ��0���˳���" << endl;
	return 0;
}
int main() 
{
	int number,guess_number = -1,i = 0,j = 2;
	HANDLE hThread;
	guess a;
	while(j != 1)
	{
		if(j == 2)
		{
			cout << "��������Ϸʱ��,5���ʼ��Ϸ��" << endl;
			HANDLE hThread = CreateThread(NULL, 0, Fun, NULL, 0, NULL);
			Sleep(5000);
			number = a.produce_number();
		}
		j = 0;
		cout << "��������������.(0Ϊ�˳���Ϸ.-1Ϊ����.-2Ϊ��ȡ���)" << endl;
		cin >> guess_number;

		if(guess_number == 0)
		{
			break;
		}
		if(guess_number == -2)
		{
			cout << "��Ϊ" << number << endl;
		}
		if(guess_number == -1)
		{
			system("CLS");
		}
		if(guess_number != -1 && guess_number != -2)
		{
			j = a.compare(guess_number,number);
		}

		if(j == 1)
		{
			cout << "0.�˳���Ϸ 1.������Ϸ" << endl;
			cin >> i;
			if(i == 0)
			{
				break;
			}
			if(i == 1)
			{
				j = 2;
			}
		}
	}
	return 0;
}
