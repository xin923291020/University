//Chengxin Yang,Dec.12 2014

#include <iostream>
#include <string>
using namespace std;

int main()
{
	string str1,str2,str3;
	int i;

	cout << "������һ���ַ�����" << endl;
	cin >> str1;
	cout << "��������Ҫ������ַ�����" << endl;
	cin >> str2;
	cout << "����������λ�á�" << endl;
	cin >> i;

	if(i > str1.length())
	{
		return 0;
	}

	str3 = str1.insert(i,str2);

	cout << str3 << endl;

	return 0;
}