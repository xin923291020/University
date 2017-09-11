//Chengxin Yang,Nov.18 2014

#include <iostream>
#include <string>
using namespace std;

void main()
{
	char str[100];
	int i;
	cout << "ÇëÊäÈëÒ»¸ö×Ö·û´®¡£" <<endl;
	cin >>str;

	int n = strlen(str);
	for(i = 0;i < n;i++)
		if(str[i] >= 'a' && str[i] <= 'z' || str[i] == '.')
		{
			cout << "NO!" <<endl;
			break;
		}
	if(i == n)
		cout << "YES!" <<endl;
}