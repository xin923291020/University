
#include"HuffmanTree.h"

void main()
{
	int n;
	cout << "请输入叶子个数" << endl;
	cin >> n;
	int m = 2 * n - 1;
	HuffmanTree HT;
	HuffmanCode HC;
	CreateHuffmanTree(HT,n);
	DisplayHuffmanTree(HT,m);
	CreateHuffmanCode(HT,HC,m);
	DisplayHuffmanCode(HC,m);
	Encode(HT,HC,m);
	CodetoNode(HT,HC,n);
}