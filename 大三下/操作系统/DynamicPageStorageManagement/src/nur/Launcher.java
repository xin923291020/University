package nur;

import java.util.ArrayList;

public class Launcher
{
	public static int ap = 3;
	public static int clearPreiod = 5;
	public static ArrayList<Integer> pageTableArrayList = new ArrayList<Integer>();
	public static ArrayList<Integer> pageUnuseFrequencyArrayList = new ArrayList<Integer>();
	public static String requestTable = "1、4、2、5、3、3、2、4、2、5";
	public static int time = 0;
	
	public static void main(String[] args)
	{
		String[] requestStringArray = requestTable.split("、");
		for(int i = 0;i < ap;i++)
		{
			pageUnuseFrequencyArrayList.add(0);
		}
		for(int i = 0;i < requestStringArray.length;i++)
		{
			time++;
			if(pageTableArrayList.contains(Integer.valueOf(requestStringArray[i])))
			{
				showPageTableArrayList(pageTableArrayList);
				continue;
			}
			if(pageTableArrayList.size() < ap)
			{
				pageTableArrayList.add(Integer.valueOf(requestStringArray[i]));
				pageUnuseFrequencyArrayList = addUnuseFrequency(pageUnuseFrequencyArrayList);
			}
			else
			{
				int index = getMaxUnuseFrequencyIndex(pageUnuseFrequencyArrayList);
				pageTableArrayList.set(index,Integer.valueOf(requestStringArray[i]));
				pageUnuseFrequencyArrayList = addUnuseFrequency(pageUnuseFrequencyArrayList);
				pageUnuseFrequencyArrayList.set(index,1);
			}
			showPageTableArrayList(pageTableArrayList);
		}
	}
	
	public static int getMaxUnuseFrequencyIndex(ArrayList<Integer> arrayList)
	{
		if(time % clearPreiod == 0)
		{
			for(int i = 0;i < arrayList.size();i++)
			{
				arrayList.set(i,0);
			}
		}
		for(int i = 0;i < arrayList.size();i++)
		{
			if(arrayList.get(i) == 0)
			{
				return i;
			}
		}
		int maxUnuseFrequency = arrayList.get(0);
		for(int i = 1;i < arrayList.size();i++)
		{
			if(maxUnuseFrequency < arrayList.get(i))
			{
				maxUnuseFrequency = arrayList.get(i);
			}
		}
		for(int i = 0;i < arrayList.size();i++)
		{
			if(arrayList.get(i) == maxUnuseFrequency)
			{
				return i;
			}
		}
		return 0;
	}
	
	public static ArrayList<Integer> addUnuseFrequency(ArrayList<Integer> arrayList)
	{
		for(int i = 0;i < arrayList.size();i++)
		{
			arrayList.set(i,arrayList.get(i) + 1);
		}
		return arrayList;
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
}