#pragma once
#include<iostream>
#include<string>
#include<Windows.h>
#include<time.h>
using namespace std;

class play_chess
{
private:
	string a[3][3];
	int b[3][3];
public:
	play_chess(void);
	~play_chess(void);
	void play(int m);
	void display();
	int judgement();
	int close_win(string s,int j);
	void anticipate(int m);
};

