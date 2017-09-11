#include"HuffmanTree.h"

void Select(HuffmanTree HT,int n,int &s1,int &s2)
{
	int Array[100];//创建一个足够大的数组，用来存放数中的权值
	int j = 1;
	for(int i = 1;i <= n;i++)
	{
		Array[i] = HT[i].weight;
	}
	sort(&Array[1],&Array[n + 1]);//将数组排序
	while(1)
	{
		for(int i = 1;i <= n;i++)
		{
			if((HT[i].weight == Array[j]) && (HT[i].parent == 0))//parent域为0，权值等于最小值，得到其i给s1
			{
				s1 = i;
				j++;//给s2赋值时不能考虑最小的，j++避开最小的。
				break;
			}
			if((HT[i].weight == Array[j]) && (HT[i].parent != 0))//权值最小，但parent不为0，说明之前的循环被用过，将其跳过。
			{
				for(int k = n;k >= i + 1;k--)//继续进行循环。
				{
					if((HT[k].weight == Array[j]) && (HT[k].parent == 0))//找到parent为0的。
					{
						s1 = k;
						break;
					}
				}
				j++;
				break;
			}
		}
		if(s1 != 0)
		{
			break;
		}
	}

	HT[s1].parent = -1;//下面不考虑s1的parent域

	while(1)
	{
		for(int i = 1;i <= n;i++)
		{
			if((HT[i].weight == Array[j]) && (HT[i].parent == 0))
			{
				s2 = i;
				j++;
				break;
			}
			if((HT[i].weight == Array[j]) && (HT[i].parent != 0))
			{
				for(int k = n;k >= i + 1;k--)
				{
					if((HT[k].weight == Array[j]) && (HT[k].parent == 0))
					{
						s2 = k;
						break;
					}
				}
				j++;
				break;
			}
		}
		if(s2 != 0)
		{
			break;
		}
	} 
}

void CreateHuffmanTree(HuffmanTree &HT,int n)
{
	if(n <= 1)
	{
		return;
	}
	int m = 2 * n - 1;
	HT = new HTNode[m + 1];
	for(int i = 1;i <= m;i++)
	{
		HT[i].parent = 0;
		HT[i].lchild = 0;
		HT[i].rchild = 0;
	}
	cout << "请输入叶子结点的权值" << endl;
	for(int i = 1;i <= n;i++)
	{
		cin >> HT[i].weight;
	}
	for(int i = n + 1;i <= m;i++)
	{
		int s1 = 0;
		int s2 = 0;
		Select(HT,i - 1,s1,s2);
		HT[s1].parent = i;
		HT[s2].parent = i;
		HT[i].lchild = s1;
		HT[i].rchild = s2;
		HT[i].weight = HT[s1].weight + HT[s2].weight;
	}
}

void CreateHuffmanCode(HuffmanTree HT,HuffmanCode &HC,int m)
{
	HC = new char *[m + 1];
	char *cd = new char[m];
	cd[m - 1] = '\0';

	for(int i = 1;i <= m;i++)
	{
		int start = m - 1;
		int c = i;
		int f = HT[i].parent;
		while(f != 0)
		{
			start--;
			if(HT[f].lchild == c)
			{
				cd[start] = '0';
			}
			else
				cd[start] = '1';
			c = f;
			f = HT[f].parent;
		}
		HC[i] = new char[m - start];
		strcpy(HC[i],&cd[start]);
	}
	delete []cd;
}

void DisplayHuffmanTree(HuffmanTree HT,int m)
{
	for(int i = 1;i <= m;i++)
	{
		cout << i << " " << HT[i].weight << " " << HT[i].parent << " " << HT[i].lchild << " " << HT[i].rchild <<endl;
	}
}

void DisplayHuffmanCode(HuffmanCode HC,int m)
{
	for(int i = 1;i <= m;i++)
	{
		cout << HC[i] << " ";
	}
	cout << endl;
}

void Encode(HuffmanTree HT,HuffmanCode HC,int m)
{
	int number;
	cout << "请输入需要编码的数字" << endl;
	cin >> number;
	bool flag = 0;
	int i;
	for(i = 1;i <= m;i++)
	{
		if(HT[i].weight == number)//找到与数字相同的权值
		{
			cout << "该数字的哈夫曼码为" << HC[i] << endl;
			flag = 1;
		}
	}
	if(flag == 0)
	{
		cout << "哈夫曼树中无该数字。" << endl;
		return;
	}	
}

void CodetoNode(HuffmanTree HT,HuffmanCode HC,int n)
{
	string codestring;
	cout << "请输入需要译码的编码" << endl;
	cin >> codestring;
	int length = codestring.length(),m = 2 * n - 1;

	cout << "字符为:";
	char codechar[10000];
	for(int i = 0;i <= length;i++)
	{
		codechar[i] = codestring.c_str()[i];//把string转化为char
		
		if(HT[m].lchild != 0)
		{
			if(codechar[i] == '0')
				m = HT[m].lchild;
			else
				m = HT[m].rchild;
		}
		else
		{
			cout << HT[m].weight << " ";
			m = 2 * n - 1;//返回开始的根节点
			i = i - 1;//减去多循环了的一次
		}
	}
	cout << endl;
}