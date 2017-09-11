package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainClass
{
	public static void main(String[] args)
	{
		ArrayList<Student> AL = new ArrayList<Student>();
		AL.add(new Student("20142863","杨程鑫",21));
		AL.add(new Student("20142872","神神鑫",21));
		AL.add(new Student("20142867","ycx",21));
		System.out.println("升序：");
		AL = Sort(AL,true);
		for(Iterator<Student> StudentIter = AL.iterator();StudentIter.hasNext();)
		{
			Student student = StudentIter.next();
			System.out.println("学号:" + student.ID + " 姓名:" + student.Name + " 年龄:" + student.Age);
		}
		System.out.println();
		System.out.println("降序：");
		AL = Sort(AL,false);
		for(Iterator<Student> StudentIter = AL.iterator();StudentIter.hasNext();)
		{
			Student student = StudentIter.next();
			System.out.println("学号:" + student.ID + " 姓名:" + student.Name + " 年龄:" + student.Age);
		}
	}
	public static ArrayList<Student> Sort(ArrayList<Student> arraylist,boolean flag)
	{
		ArrayList<String> ID = new ArrayList<String>();
		for(Iterator<Student> StudentIter = arraylist.iterator();StudentIter.hasNext();)
		{
			ID.add(StudentIter.next().ID);
		}
		if(flag)
		{
			Collections.sort(ID);
		}
		else
		{
			Collections.sort(ID);
			Collections.reverse(ID);
		}

		ArrayList<Student> ReturnArrayList = new ArrayList<Student>();
		for(Iterator<String> StringIter = ID.iterator();StringIter.hasNext();)
		{
			String id = StringIter.next();
			for(Iterator<Student> StudentIter = arraylist.iterator();StudentIter.hasNext();)
			{
				Student student = StudentIter.next();
				if(student.ID.equals(id))
				{
					ReturnArrayList.add(student);
				}
			}
		}
		return ReturnArrayList;
	}
}