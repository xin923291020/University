#pragma once
#include <iostream>
using namespace std;

#ifndef _PROTOTYPE_H_
#define _PROTOTYPE_H_
class Vector
{
public:
	virtual ~Vector();
	virtual Vector* Clone() const = 0;
	virtual void ShowData() = 0;
	virtual void AddOne() = 0;
protected:
	Vector();
public:
	int length;
	int *p;
};

class ConcreteVector:public Vector
{
public:
	ConcreteVector(int length);
	ConcreteVector(const ConcreteVector& cp);
	~ConcreteVector();
	Vector* Clone() const;
    void ShowData();
	void AddOne();
};
#endif

