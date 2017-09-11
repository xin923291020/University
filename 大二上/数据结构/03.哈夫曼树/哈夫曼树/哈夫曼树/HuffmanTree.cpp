#include"HuffmanTree.h"

void Select(HuffmanTree HT,int n,int &s1,int &s2)
{
	int Array[100];//����һ���㹻������飬����������е�Ȩֵ
	int j = 1;
	for(int i = 1;i <= n;i++)
	{
		Array[i] = HT[i].weight;
	}
	sort(&Array[1],&Array[n + 1]);//����������
	while(1)
	{
		for(int i = 1;i <= n;i++)
		{
			if((HT[i].weight == Array[j]) && (HT[i].parent == 0))//parent��Ϊ0��Ȩֵ������Сֵ���õ���i��s1
			{
				s1 = i;
				j++;//��s2��ֵʱ���ܿ�����С�ģ�j++�ܿ���С�ġ�
				break;
			}
			if((HT[i].weight == Array[j]) && (HT[i].parent != 0))//Ȩֵ��С����parent��Ϊ0��˵��֮ǰ��ѭ�����ù�������������
			{
				for(int k = n;k >= i + 1;k--)//��������ѭ����
				{
					if((HT[k].weight == Array[j]) && (HT[k].parent == 0))//�ҵ�parentΪ0�ġ�
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

	HT[s1].parent = -1;//���治����s1��parent��

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
	cout << "������Ҷ�ӽ���Ȩֵ" << endl;
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
	cout << "��������Ҫ���������" << endl;
	cin >> number;
	bool flag = 0;
	int i;
	for(i = 1;i <= m;i++)
	{
		if(HT[i].weight == number)//�ҵ���������ͬ��Ȩֵ
		{
			cout << "�����ֵĹ�������Ϊ" << HC[i] << endl;
			flag = 1;
		}
	}
	if(flag == 0)
	{
		cout << "�����������޸����֡�" << endl;
		return;
	}	
}

void CodetoNode(HuffmanTree HT,HuffmanCode HC,int n)
{
	string codestring;
	cout << "��������Ҫ����ı���" << endl;
	cin >> codestring;
	int length = codestring.length(),m = 2 * n - 1;

	cout << "�ַ�Ϊ:";
	char codechar[10000];
	for(int i = 0;i <= length;i++)
	{
		codechar[i] = codestring.c_str()[i];//��stringת��Ϊchar
		
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
			m = 2 * n - 1;//���ؿ�ʼ�ĸ��ڵ�
			i = i - 1;//��ȥ��ѭ���˵�һ��
		}
	}
	cout << endl;
}