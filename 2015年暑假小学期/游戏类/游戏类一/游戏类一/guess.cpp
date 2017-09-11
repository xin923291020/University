#include "guess.h"

guess::guess(void)
{
}
guess::~guess(void)
{
}

int guess::produce_number()	//在1-9999时间生成随机数字。
{
	srand((unsigned)time(NULL));  
    int n = rand() % 10000 + 1;

	return n;
}

int guess::compare(int guess_number,int real_number)//输入数字与随机数字比较。
{
	int j;
	if(guess_number > real_number)
	{
		cout << "高了。" << endl;
	}
	if(guess_number < real_number)
	{
		cout << "低了。" << endl;
	}
	if(guess_number == real_number)
	{
		cout << "恭喜!正确猜出数字" << real_number << endl;
		return j = 1;
	}
	return j = 0;
}