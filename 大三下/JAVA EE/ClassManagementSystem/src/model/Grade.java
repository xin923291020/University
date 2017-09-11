package model;

public class Grade implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer identifier;
	private String course;
	private String student;
	private Integer score;

	public Grade(){}

	public Grade(Integer identifier, String course, String student, Integer score)
	{
		this.identifier = identifier;
		this.course = course;
		this.student = student;
		this.score = score;
	}

	public Integer getIdentifier()
	{
		return this.identifier;
	}

	public void setIdentifier(Integer identifier)
	{
		this.identifier = identifier;
	}

	public String getCourse()
	{
		return this.course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}

	public String getStudent()
	{
		return this.student;
	}

	public void setStudent(String student)
	{
		this.student = student;
	}

	public Integer getScore()
	{
		return this.score;
	}

	public void setScore(Integer score)
	{
		this.score = score;
	}
}