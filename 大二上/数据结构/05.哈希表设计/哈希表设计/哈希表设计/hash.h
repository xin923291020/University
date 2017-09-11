#pragma once
#include<iostream>
#include<string>
#include<cmath>
using namespace std;
#define MAX 8

typedef struct
{
	int number[MAX];
	string name[MAX];
}people;

typedef struct
{   
    int key[MAX];
	string name[MAX];
}hashtable;

void CreatePeople(people &p);
void GetNumber(people &p,int n);
int GetMod(int value);
void InitHashList(hashtable &HashList);
void CreateHashList(hashtable &HashList,people p);
void Search(hashtable HashList);
void Display(hashtable HashList);