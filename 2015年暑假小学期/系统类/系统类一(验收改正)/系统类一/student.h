#pragma once
#include"people.h"

typedef vector<people>  vectorOfPeople;

class student
{
private:
	vectorOfPeople S;
public:
	student(void);
	~student(void);
	void resize(int m);
	void set(int m);
	void setone(int m);
	void query(int m);
	void revise(int m);
	void del(int m);
	void display(int m);
	void free();
};

