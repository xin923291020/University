#pragma once
#include<iostream>
#include<stdlib.h>
#include<Windows.h>
#include<time.h>
using namespace std;  

class guess
{
public:
	guess(void);
	~guess(void);
	int produce_number();
	int compare(int guess_number,int real_number);
};

