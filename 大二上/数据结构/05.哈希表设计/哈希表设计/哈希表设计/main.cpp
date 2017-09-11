#include"hash.h"

void main()
{
	people p;
	hashtable HashList;
	CreatePeople(p);
	CreateHashList(HashList,p);
	Display(HashList);
	Search(HashList);
	Search(HashList);
}