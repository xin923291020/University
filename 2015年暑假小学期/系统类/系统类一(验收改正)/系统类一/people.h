#pragma once
#include <vector>
#include <iostream>
#include<string>
using namespace std;

class people
{
private:
	string identifier;
	string name;
	string sex;
	int age;
	string home_phone_number;
	string telephone;
public:

	people(void);
	~people(void);
	people set();
	int query(people n,string que,int r,int j);
	int revise(people n,string revise_name,int k);
	int del(people n,string d,int k,int r);
	void display(people n);
};

