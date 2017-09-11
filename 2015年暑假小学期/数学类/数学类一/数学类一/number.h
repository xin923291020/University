#pragma once
#include<iostream>
#include<string>
using namespace std;

class number
{
private:
	string num;
public:
	number(string);
	~number(void);

	void add(number A,number B);
	void sub(number A,number B);
};