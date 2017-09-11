#pragma once
#include<iostream>
#include<time.h>
using namespace std;

class morra
{
	int x,y,z;
public:
	morra(void);
	~morra(void);

	int produce_number();
	void compare(int n,int m);
	int cheat(int n,int m);
	void display();
};

