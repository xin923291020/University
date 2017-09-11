package model;

import java.util.HashSet;
import java.util.Set;

public class Course implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private String identifier;
	private String name;
	private String property;
	private Integer credit;
	private Set<Grade> grades = new HashSet<Grade>(0);

	public Course(){}

	public Course(String identifier, String name, String property, Integer credit)
	{
		this.identifier = identifier;
		this.name = name;
		this.property = property;
		this.credit = credit;
	}

	public Course(String identifier, String name, String property, Integer credit, Set<Grade> grades)
	{
		this.identifier = identifier;
		this.name = name;
		this.property = property;
		this.credit = credit;
		this.grades = grades;
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

	public String getProperty()
	{
		return this.property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	public Integer getCredit()
	{
		return this.credit;
	}

	public void setCredit(Integer credit)
	{
		this.credit = credit;
	}

	public Set<Grade> getGrades()
	{
		return this.grades;
	}

	public void setGrades(Set<Grade> grades)
	{
		this.grades = grades;
	}
}