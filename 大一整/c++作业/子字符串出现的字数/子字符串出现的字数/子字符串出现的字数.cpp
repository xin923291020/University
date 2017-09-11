//Chengxin Yang,Dec.12 2014

#include <iostream>
#include <string>
using namespace std;

int tongji(string str1,string str2)
{
	int m = 0,i = 0,l;
	l = str2.length();

	while(m != string::npos)
	{
		m = str1.find(str2);
		if(m != string::npos)
		{
			str1 = str1.substr(m + 1);
			i++;
		}
	}
	return i;
}

void main()
{
	string str1,str2;
	cout << "ÇëÊäÈë×Ö·û´®¡£" <<endl;
	cin >> str1;
	cout << "ÇëÊäÈë×Ó×Ö·û´®¡£" <<endl;
	cin >> str2;

	cout << tongji(str1,str2) << endl;
}