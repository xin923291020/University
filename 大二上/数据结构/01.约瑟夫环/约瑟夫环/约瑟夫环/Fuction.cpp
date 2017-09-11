#include "Fuction.h"

void ElemNumberInput(int &max)
{
	while(1)
	{
		cout << "������Ԫ�ظ���(0-30)" << endl;
		cin >> max;

		if(max >30 ||max <= 0)
		{
			cout << "����Ƿ������������롣" << endl;
		}
		else
			break;
	}
}

void InitPassworGet(int &e)
{
	while(1)
	{
		cout << "�������ʼ����(������)" << endl;
		cin >> e;

		if(e <= 0)
		{
			cout << "����Ƿ������������롣" << endl;
		}
		else
			break;
	}
}

void CreateList(LinkList &L,int n)
{
	LNode *r,*p;
	L = new LNode;
	L->next = NULL;
	r = L;
	int j = 1;

	cout << "������" << n <<"��Ԫ�ء�" << endl;
	for(int i = 0;i < n;i++)
	{
		p = new LNode;

		cin >> p->data;
		p->number = j;
		j++;

		p->next = NULL;
		r->next = p;
		r = p;
	}
}

void ListOutput(LinkList L,int now)
{	
	cout << endl << "��ǰ����Ϊ:";
	for(int j = 0;j < now;j++)
	{
		cout << L->next->data << " ";
		L = L->next;
	}
	cout << endl;
}

void ListDelete(LinkList &L,int &i,int &e,int &now)
{
	while(1)
	{
		PasswordResetting(i,e,now);    //���ϴ�ѭ���õ���������������
		GetValue(L,i,e);    //��ȡ����������ݵ����롣
		if(i == 1)    //ɾ��ͷԪ�ء�
		{
			ListDeleteTop(L,i);
		}
		if(now >= 3 && i != now && i != 1)    //���м�ɾ��Ԫ�ء�
		{
			ListDeleteAmong(L,i);
		}
		if(i == now && i != 1)    //ɾ��βԪ�ء�
		{
			ListDeleteEnd(L,i);
		}
		if(now > 0 && now < 3 && i != now && i != 1)    //�����ٵ�ʱ��
		{
			ListDeleteFew(L,i);
		}
		now--;    //Ԫ������һ
		ListOutput(L,now);    //�����ǰԪ�ء�
		if(now == 0)    //û��Ԫ�ص�ʱ��������ǰѭ����
		{
			break;
		}
	}
}

int ListDeleteTop(LinkList &L,int i)
{
	PasswordDeclare(i);
	LNode *q;
	q = L->next;
	L->next = L->next->next;
	ElemDeleteDeclare(q);
	delete q;

	return 0;
}

int ListDeleteAmong(LinkList &L,int i)
{
	PasswordDeclare(i);
	LNode *p,*q,*r,*s;
	int j = 0;
	p = L;
	while(1)
	{
		if(p->next)
		{
			p = p->next;
			s = p;
		}
		else
			break;
	}
	p = L;
	while((p->next) && (j < i - 1))
	{
		p = p->next;
		j++;
	}
	if(!(p->next) || (j > i - 1))
	{
		return 0;
	}

	q = p->next;
	p->next = q->next;
	r = q->next;

	ElemDeleteDeclare(q);
	delete q;

	s->next = L->next;
	L->next = p->next;
	p->next = NULL;

	return 0;
}

int ListDeleteEnd(LinkList &L,int i)
{
	PasswordDeclare(i);
	LNode *p,*q;
	p = L;
	int j = 0;
	while((p->next) && (j < i - 1))
	{
		p = p->next;
		j++;
	}
	if(!(p->next) || (j > i - 1))
	{
		return 0;
	}

	q = p->next;
	p->next = NULL;
	ElemDeleteDeclare(q);
	delete q;

	return 0;
}

int ListDeleteFew(LinkList &L,int i)
{
	PasswordDeclare(i);
	LNode *q;
	if(i == 1)
	{
		q = L->next;
		L->next = L->next->next;
		ElemDeleteDeclare(q);
		delete q;
	}
	if(i == 2)
	{
		q = L->next->next;
		ElemDeleteDeclare(q);
		delete q;
	}

	return 0;
}

int GetValue(LinkList L,int i,int &e)
{
	LNode *p;int j = 1;
	p = L->next;

	while(p && j < i)
	{
		p = p->next;
		j++;
	}
	if(!p || j > i)
	{
		return 0;
	}

	e = p->data;

	return 1;
}

void ElemDeleteDeclare(LNode *q)
{
	cout << q->data << "���С�" <<"	";
	cout << "����Ϊ:" << q->number << endl;
}

void PasswordDeclare(int i)
{
	cout << "����Ϊ:" << i << "    ";
}

void PasswordResetting(int &i,int e,int now)
{
	if(e >= now)
		{
			i = e % now;
			if(i == 0)
			{
				i = now;
			}
		}
		if(e < now)
		{
			i = e;
		}
}