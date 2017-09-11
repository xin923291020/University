//矩阵相乘
//Chengxin Yang Nov.3 2014
#include <iostream>
using namespace std;

#define N 3
#define ROWSIZE N
#define COLSIZE N

int main()
{
	float matrix1[ROWSIZE][COLSIZE],matrix2[ROWSIZE][COLSIZE],matrixpro[ROWSIZE][COLSIZE];
	int i,j,c;

	cout <<"input the first matrix with"<< ROWSIZE <<"rows and"<< COLSIZE <<"columns:"<<endl;
	for(i = 0;i < ROWSIZE;i++)
		for(j = 0;j < COLSIZE;j++)
			cin >> matrix1[i][j];

	cout <<"input the second matrix with"<< ROWSIZE <<"rows and"<< COLSIZE <<"columns:"<<endl;
	for(i = 0;i < ROWSIZE;i++)
		for(j = 0;j < COLSIZE;j++)
			cin >> matrix2[i][j];

	for(i = 0;i < ROWSIZE;i++)
		for(j = 0;j < COLSIZE;j++)
		{
			matrixpro[i][j] = 0;
			for(c = 0;c < COLSIZE;c++)
			matrixpro[i][j] = matrixpro[i][j] + matrix1[i][c] * matrix2[c][j];
		}
	
	cout <<"其乘积为"<<endl;
	for(i = 0;i < ROWSIZE;i++)
	{
		for(j = 0;j < COLSIZE;j++)
	    cout << matrixpro[i][j]<<" ";
		cout <<endl;
	}

	return 0;
}