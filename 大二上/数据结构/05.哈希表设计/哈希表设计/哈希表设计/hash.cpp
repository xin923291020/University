#include "hash.h"

void CreatePeople(people &p)
{
	for(int i = 0;i < MAX;i++)
	{
		cout << "请输入第" << i + 1 << "个人名。" << endl;
		cin >> p.name[i];
		GetNumber(p,i);
	}
}

void GetNumber(people &p,int n)
{
	char ch[16];
	int num = 0,i;
	strcpy(ch,p.name[n].c_str());
	for(i = 0;i < p.name[n].length();i++)
	{
		num += ch[i];
	}
	p.number[n] = GetMod(num);
}

int GetMod(int value)
{
	return (value % 7);
}

void InitHashList(hashtable &HashList)
{
	for(int i = 0;i < MAX;i++)
	{
		HashList.name[i] = "NULL";
	}
}

void CreateHashList(hashtable &HashList,people p)
{
	InitHashList(HashList);
	int i = 0;
	int j = p.number[i];
	while(i < MAX)
	{
		if(HashList.name[j] == "NULL")
		{
			HashList.key[j] = p.number[i];
			HashList.name[j] = p.name[i];
			i++;
			j = p.number[i];
		}
		else
		{
			j++;
			j = j % MAX;
		}
	}
}

void Search(hashtable HashList)
{
	string name;
	cout << "请输入需要查找的姓名。" << endl;
	cin >> name;

	int num = 0,time = 0;
	char ch[16];
	strcpy(ch,name.c_str());
	for(int i = 0;i < name.length();i++)
	{
		num += ch[i];
	}
	int key = GetMod(num);

	while(1)
	{
		time++;
		if(HashList.name[key] == name)
		{
			cout << "查找成功，次数：" << time << "  位置：" << key << "  key = " << HashList.key[key] << "  name = " << HashList.name[key] << endl;
			break;
		}
		else
		{
			key++;
			key = key % MAX;
			if(key == GetMod(num))
			{
				cout << "查找失败。" << endl;
				break;
			}
		}
	}
}

void Display(hashtable HashList)
{
	for(int i = 0;i < MAX;i++)
	{
		cout << i << "		" << HashList.key[i] << "		" <<  HashList.name[i] << endl; 
	}
}