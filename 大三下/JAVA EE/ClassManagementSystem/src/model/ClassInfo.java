package model;

import java.util.HashSet;
import java.util.Set;

public class ClassInfo implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private String identifier;
	private String name;
	private Set<Student> students = new HashSet<Student>(0);

	public ClassInfo(){}

	public ClassInfo(String identifier, String name)
	{
		this.identifier = identifier;
		this.name = name;
	}

	public ClassInfo(String identifier, String name, Set<Student> students)
	{
		this.identifier = identifier;
		this.name = name;
		this.students = students;
	}

	public String getIdentifier()
	{
		return this.identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Student> getStudents()
	{
		return this.students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}
}