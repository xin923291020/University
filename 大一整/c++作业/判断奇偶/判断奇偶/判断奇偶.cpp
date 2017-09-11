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
	cout << "请输入一个数：" <<endl;
	cin >> n;

	i = n % 2;

	if(i == 1)
	{
		cout << n << "是奇数。" <<endl;
		j = i % 3;
		if(j == 0)
			cout << n << "能被3整除。" <<endl;
		else
			cout << n << "不能被3整除。" <<endl;
	
		return 0;
	}
	else if(i == 0)
	{
		cout << n << "是偶数。" <<endl;
		cout << n << "是" << swap(n) << "位数。" <<endl;
	}

	return 0;
}