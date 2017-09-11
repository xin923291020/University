//Chengxin Yang,Dec.12 2014

#include <iostream>
#include <string>
using namespace std;

bool isSymmetry(string str)
{
	int n,i;
	bool flag = 1;

	n = str.length();
	for(i = 0;i < n;i++)
		if(str[i] != str[n - i-1])
			flag = 0;

	return flag;
}

void main()
{
	string str;
	bool flag;

	cout << "ÇëÊäÈëÐèÒªÅÐ¶ÏµÄ×Ö·û´®¡£" << endl;
	cin >> str;

	flag = isSymmetry(str);

	if(flag == 0)
		cout << "No!" << endl;
	if(flag == 1)
		cout << "Yes!" << endl;
}
