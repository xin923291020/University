package opt;

import java.util.ArrayList;
import java.util.Collections;

public class Launcher
{
	public static int ap = 3;
	public static ArrayList<Integer> pageTableArrayList = new ArrayList<Integer>();
	public static ArrayList<Integer> pageNextNumberArrayList = new ArrayList<Integer>();
	public static String requestTable = "1、4、2、5、3、3、2、4、2、5";
	
	public static void main(String[] args)
	{
		String[] requestStringArray = requestTable.split("、");
		for(int i = 0;i < requestStringArray.length;i++)
		{
			if(pageTableArrayList.contains(Integer.valueOf(requestStringArray[i])))
			{
				showPageTableArrayList(pageTableArrayList);
				continue;
			}
			if(pageTableArrayList.size() < ap)
			{
				pageTableArrayList.add(Integer.valueOf(requestStringArray[i]));
			}
			else
			{
				for(int j = 0;j < pageTableArrayList.size();j++)
				{
					int number = pageTableArrayList.get(j);
					pageNextNumberArrayList.add(getNextNumber(number,i,requestStringArray));
				}
				if(pageNextNumberArrayList.contains(-1))
				{
					for(int j = 0;j < pageNextNumberArrayList.size();j++)
					{
						if(pageNextNumberArrayList.get(j) == -1)
						{
							pageTableArrayList.set(j,Integer.valueOf(requestStringArray[i]));
							break;
						}
					}
				}
				else
				{
					Collections.sort(pageNextNumberArrayList);
					for(int j = 0;j < pageNextNumberArrayList.size();j++)
					{
						if(pageNextNumberArrayList.get(j) == pageNextNumberArrayList.get(0))
						{
							pageTableArrayList.set(j,Integer.valueOf(requestStringArray[i]));
							break;
						}
					}
				}
			}
			pageNextNumberArrayList.clear();
			showPageTableArrayList(pageTableArrayList);
		}
	}
	
	public static void showPageTableArrayList(ArrayList<Integer> arrayList)
	{
		String result = "";
		for(int i =0;i < arrayList.size();i++)
		{
			result += arrayList.get(i) + "\t";
		}
		System.out.println(result);
	}
	
	public static int getNextNumber(int currentNumber,int currentIndex,String[] requestStringArray)
	{
		for(int i = currentIndex;i < requestStringArray.length;i++)
		{
			if(Integer.valueOf(requestStringArray[i]) == currentNumber)
			{
				return i;
			}
		}
		return -1;
	}
}