package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String identifier;
	private String class_Identifier;
	private String password;
	private String name;
	private String sex;
	private Date birth;
	private String phone;
	private String address;
	private Set<Grade> grades = new HashSet<Grade>(0);

	public Student(){}

	public Student(String identifier, String class_Identifier, String password,
			String name, String sex, Date birth, String phone, String address)
	{
		this.identifier = identifier;
		this.class_Identifier = class_Identifier;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
	}

	public Student(String identifier, String class_Identifier, String password,
			String name, String sex, Date birth, String phone, String address,
			Set<Grade> grades)
	{
		this.identifier = identifier;
		this.class_Identifier = class_Identifier;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
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

	public String getClass_Identifier()
	{
		return class_Identifier;
	}

	public void setClass_Identifier(String class_Identifier)
	{
		this.class_Identifier = class_Identifier;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Date getBirth()
	{
		return this.birth;
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
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