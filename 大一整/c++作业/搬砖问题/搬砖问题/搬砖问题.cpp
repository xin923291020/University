//Chengxin Yang£¬Dec.2 2014

#include <iostream>
using namespace std;

void main()
{
	int x,y,z;

	for(x = 1;x < 36;x++)
		for(y = 1;y < 36;y++)
			for(z = 2;z < 36;z = z + 2)
				if(4 * x + 3 * y + z / 2 == 36 && x + y + z == 36)
					cout << "ÄÐ" << x << "Å®" << y << "Ð¡º¢" << z <<endl;
}