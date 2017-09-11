#include "guess.h"

DWORD WINAPI Fun(LPVOID lpParamter)	//在玩家输入数字后开始倒计时。
{
	int n;
	cin >> n;
	n += 5;//主函数生成实际数字前停滞5秒，此处加上。
	while(n >= 0)
	{
		Sleep(1000);
		n--;
	}
	cout << "遗憾,未能在规定时间内猜出正确数字,你可以继续游戏或按0键退出。" << endl;
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
			cout << "请输入游戏时间,5秒后开始游戏。" << endl;
			HANDLE hThread = CreateThread(NULL, 0, Fun, NULL, 0, NULL);
			Sleep(5000);
			number = a.produce_number();
		}
		j = 0;
		cout << "请输入所猜数字.(0为退出游戏.-1为清屏.-2为获取结果)" << endl;
		cin >> guess_number;

		if(guess_number == 0)
		{
			break;
		}
		if(guess_number == -2)
		{
			cout << "答案为" << number << endl;
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
			cout << "0.退出游戏 1.继续游戏" << endl;
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
