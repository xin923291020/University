//Chengxin Yang,Nov.18 2014

#include <iostream>
using namespace std;

int swap(int n)
{
	int i = 0;
	while(n)
	{
		n = n / 10;
		i++;
	}
	return i;
}

int main()
{
	int n,i,j;
	cout << "������һ������" <<endl;
	cin >> n;

	i = n % 2;

	if(i == 1)
	{
		cout << n << "��������" <<endl;
		j = i % 3;
		if(j == 0)
			cout << n << "�ܱ�3������" <<endl;
		else
			cout << n << "���ܱ�3������" <<endl;
	
		return 0;
	}
	else if(i == 0)
	{
		cout << n << "��ż����" <<endl;
		cout << n << "��" << swap(n) << "λ����" <<endl;
	}

	return 0;
}