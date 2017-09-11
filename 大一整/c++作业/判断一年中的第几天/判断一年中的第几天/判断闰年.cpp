bool swap(int n)
{
	int t;
	bool flag = 0;

	t = n % 100;
	
	while(t)
	{
		if(n % 4 == 0)
			flag = 1;
		break;
	}

	if(n % 400 == 0)
		flag = 1;

	return flag;
}