#include "Vector.h"
Vector::Vector()
{
}

Vector::~Vector()
{
}

Vector* Vector::Clone() const
{
	return 0;	
}

ConcreteVector::ConcreteVector(int length)
{
	this->length = length;
	this->p = new int[length];
	for(int i = 0; i < length;i++)
	{
		p[i] = i;
	}
}

ConcreteVector::~ConcreteVector()
{
	delete []p;
}

ConcreteVector::ConcreteVector(const ConcreteVector& cp)
{
	this->length = cp.length;
	this->p = cp.p;
	/*this->length = cp.length;
    this->p = new int[cp.length];
	for(int i = 0; i < this->length;i++)
	{
		this->p[i] = cp.p[i];
	}*/
}

Vector* ConcreteVector::Clone() const
{
	return new ConcreteVector(*this);
}

void ConcreteVector::ShowData()
{
	for(int i = 0; i < this->length;i++)
	{
		cout << p[i] << " ";
	}
}

void ConcreteVector::AddOne()
{
	for(int i = 0; i < this->length;i++)
	{
		 p[i] += 2;
	}
}