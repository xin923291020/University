package test1;

public class Function
{
    static String resourceCode;
    static boolean flag = true;
    static StringBuilder stack = new StringBuilder("#");
    static StringBuilder buffer = new StringBuilder();
    static int step = 1;
    static int siYuanShi = 0;
    static int n = 0;
    static String nValue[] = new String[10];
    static int result = 1;
    static int top;
    static String sequenceList = "+*/i()#0123456789";
    static int relation[][] = {{1,-1,-1,-1,-1,1,1},
    						  {1,1,-1,-1,-1,1,1},
    						  {1,1,-1,-1,-1,1,1},
    						  {1,1,1,-2 -2,1,1},
    						  {-1,-1,-1,-1,-1,0,-2},
    						  {1,1,1,-2,-2,1,1},
    						  {-1,-1,-1,-1,-1,-2,0}};
    public static void main(String[] args)
    {
        /*System.out.print("�������ַ�����");
        @SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
        resourceCode = s.nextLine();*/
    	resourceCode = "1*(1+1)#";
        buffer.append(resourceCode);
        if(sequenceList.indexOf(buffer.charAt(0)) == -1)
        {
            flag = false;
            System.err.println("�����Ƿ��ַ���");
            return;
        }
        if(!IsNumber(buffer.charAt(0)) && buffer.charAt(0) != '(')
        {
            flag = false;
            System.err.println("�﷨���ҡ�");
            return;
        }
        for(int i = 1;i < buffer.length() - 2;i++)
        {
            if(!IsNumber(buffer.charAt(i)))
            {
                if(buffer.charAt(i) == '(')
                {
                    if(buffer.charAt(i + 1) == ')' || buffer.charAt(i + 1) == '+' || buffer.charAt(i + 1) == '*' || buffer.charAt(i + 1) == '/')
                    {
                        flag = false;
                        System.err.println("�﷨���ҡ�");
                        return;
                    }
                }
            }
        }
        System.out.println("����\t\tջ\t\t���뻺����");
        System.out.println(step++ + "\t\t" + stack + "\t\t" + buffer);
        move();
        do
        {
            top = stack.length() - 1;
            if(buffer.charAt(0) == '#')
            {
                if(stack.charAt(stack.length() - 2) == '#' && stack.charAt(stack.length() - 1) == 'N')
                {
                    System.out.println("\nɨ����ϡ�");
                    break;
                }
            }
            if(stack.charAt(top) == 'N')
            {
                top--;
            }
            if(sequenceList.indexOf(buffer.charAt(0)) == -1)
            {
                flag = false;
                System.err.println("\t�����Ƿ��ַ���");
                return;
            }
            compare(stack.charAt(top), buffer.charAt(0));
        }
        while(flag);
    }
  
    static void compare(char a, char b)
    {
    	int i;
    	int j;
    	if(IsNumber(a))
    	{
    		i = 3;
    	}
    	else
    	{
    		i = sequenceList.indexOf(a);// ��
    	}
    	if(IsNumber(b))
    	{
    		j = 3;
    	}
    	else
    	{
    		j = sequenceList.indexOf(b);// ��
    	}
        switch(relation[i][j])
        {
        	case 1:// a>b,��ջ���ҵڶ����ս����׼����Լ
            int second;
            for(second = top - 1;stack.charAt(second) == 'N';second--)
            {
                continue;
            }
            n = 0;
            for(int m = 0;m < top;m++)
            {// �ҵ�����ַ�ǰ���м���N  
                if(stack.charAt(m) == 'N')
                {
                    n++;
                }
            }
            if(IsNumber(stack.charAt(top)))
        	{
        		i = 3;
        	}
        	else
        	{
        		i = sequenceList.indexOf(stack.charAt(top));
        	}
            if(IsNumber(stack.charAt(second)))
        	{
        		j = 3;
        	}
        	else
        	{
        		j = sequenceList.indexOf(stack.charAt(second));
        	}
            if(relation[j][i] == 0)
            {
                stack.replace(second,top + 1,"N");
            }
            else if(relation[j][i] == -1)
            {
                if(stack.charAt(top - 1) == 'N')
                {
                    System.out.println("\t��Ԫʽ" + ++siYuanShi + "\tT" + result
                    		+ "=" + nValue[n - 1] + stack.charAt(top) + nValue[n]);
                    nValue[n - 1] = "T" + result++;
                    stack.delete(top,top + 2);
  
                }
                else
                {
                    nValue[n] = Character.toString((stack.charAt(top)));
                    stack.deleteCharAt(top);
                    stack.append('N');
                }
            }
            System.out.println(step++ + "\t\t" + stack + "\t\t" + buffer);
            break;
        case 0:
        case -1:
            move();
            break;
        default:
            System.err.println(a + "��" + b + "��ʱ���ܱȽ����ȼ���������봮���Ǿ��ӡ�");
            flag = false;
        }
        return;
    }
    static void move()
    {
        stack.append(buffer.charAt(0));
        buffer.deleteCharAt(0);
        System.out.println(step++ + "\t\t" + stack + "\t\t" + buffer);
    }
	public static boolean IsNumber(char c)
	{
		if(c >= '0' && c <= '9')
		{
			return true;
		}
		return false;
	}
} 