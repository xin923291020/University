#include "guess.h"

guess::guess(void)
{
}
guess::~guess(void)
{
}

int guess::produce_number()	//��1-9999ʱ������������֡�
{
	srand((unsigned)time(NULL));  
    int n = rand() % 10000 + 1;

	return n;
}

int guess::compare(int guess_number,int real_number)//����������������ֱȽϡ�
{
	int j;
	if(guess_number > real_number)
	{
		cout << "���ˡ�" << endl;
	}
	if(guess_number < real_number)
	{
		cout << "���ˡ�" << endl;
	}
	if(guess_number == real_number)
	{
		cout << "��ϲ!��ȷ�³�����" << real_number << endl;
		return j = 1;
	}
	return j = 0;
}