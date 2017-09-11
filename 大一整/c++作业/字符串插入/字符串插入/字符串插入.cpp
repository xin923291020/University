//Chengxin Yang,Dec.12 2014

#include <iostream>
#include <string>
using namespace std;

int main()
{
	string str1,str2,str3;
	int i;

	cout << "请输入一个字符串。" << endl;
	cin >> str1;
	cout << "请输入需要插入的字符串。" << endl;
	cin >> str2;
	cout << "请输入插入的位置。" << endl;
	cin >> i;

	if(i > str1.length())
	{
		return 0;
	}

	str3 = str1.insert(i,str2);

	cout << str3 << endl;

	return 0;
}