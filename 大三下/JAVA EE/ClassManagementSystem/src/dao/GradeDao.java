package dao;

import java.util.Iterator;
import java.util.List;
import model.Course;
import model.Grade;
import model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class GradeDao
{
	private SessionFactory sessionFactory;
	
	public GradeDao()
	{
		super();
	}
	
	@Transactional
	public boolean updateGradeByStudentAndCourse(String score,String identifier,String course_identifier)
	{
		boolean isSuccess = false;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String hql = "update Grade set Score = '" + score + "'" +
					" Where Student_Identifier = '" + identifier + "'" +
					" And Course_Identifier = '" + course_identifier + "'";
			int i = session.createSQLQuery(hql).executeUpdate();
			if(i == 1)
			{
				isSuccess = true;
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
    public List<Grade> getGradeByStudent(String student_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from Grade Where Student_Identifier = '" + student_Identifier + "'";
		List<Grade> ls = session.createSQLQuery(hql).addEntity(Grade.class).list();
		return ls;
    }
	
	@Transactional
    public Iterator<?> getGradeByCourse(String course_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select MAX(Score) As MAX,MIN(Score) As MIN,AVG(Score) As AVG" +
				" from Grade Where course_Identifier = '" + course_Identifier + "'";
		Iterator<?> integer = session.createSQLQuery(hql).list().iterator();
		return integer;
    }
	
    @SuppressWarnings("unchecked")
	@Transactional
    public Grade getGradeByCourseAndStudent(String course,String student_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from Grade Where Student_Identifier = '" + student_Identifier
				+ "' And Course_Identifier = '" + course + "'";
		List<Grade> ls = session.createSQLQuery(hql).addEntity(Grade.class).list();
		if(ls.size() == 1)
		{
			return ls.get(0);
		}
		return null;
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
    public List<Course> getCourseChoosedByClass(String classType,String class_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select Course.Identifier,Course.Name,Property,Credit from Grade" +
				 		" Join Course On Grade.Course_Identifier = Course.Identifier" +
				 		" Join Student On Grade.Student_Identifier = Student.Identifier" +
				 		" Where Course.Property = '" + classType + 
				 		"' And Class_Identifier ='" + class_Identifier + 
				 		"' Group By Course.Identifier,Course.Name,Property,Credit";
		List<Course> ls = session.createSQLQuery(hql).addEntity(Course.class).list();
		return ls;
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
    public List<Course> getCourseChoosedByStudent(String classType,String student_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select Course.Identifier,Course.Name,Property,Credit from Grade" +
				 		" Join Course On Grade.Course_Identifier = Course.Identifier" +
				 		" Join Student On Grade.Student_Identifier = Student.Identifier" +
				 		" Where Course.Property = '" + classType + 
				 		"' And Student_Identifier ='" + student_Identifier + 
				 		"' Group By Course.Identifier,Course.Name,Property,Credit";
		List<Course> ls = session.createSQLQuery(hql).addEntity(Course.class).list();
		return ls;
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
    public List<Course> getCourseNotChoosedByClass(String classType,String class_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from Course Where Identifier" +
				" Not In (Select Course_Identifier from Grade Where Student_Identifier" +
				" Not In (Select Identifier from Student" +
				" Where Class_Identifier != '" + class_Identifier + 
				"')) And Property = '" + classType + "'";
		List<Course> ls = session.createSQLQuery(hql).addEntity(Course.class).list();
		return ls;
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
    public List<Course> getCourseNotChoosedByStudent(String classType,String student_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from Course Where Identifier" +
				" Not In (Select Course_Identifier from Grade Where Student_Identifier" +
				" Not In (Select Identifier from Student" +
				" Where Student_Identifier != '" + student_Identifier + 
				"')) And Property = '" + classType + "'";
		List<Course> ls = session.createSQLQuery(hql).addEntity(Course.class).list();
		return ls;
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
    public void dropCoursesByStudent(Student student,String course_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
    	String hql = "select * from Grade Where Student_Identifier = '"
    	+ student.getIdentifier() + "' And Course_Identifier = '" + course_Identifier + "'";
    	List<Grade> ls = session.createSQLQuery(hql).addEntity(Grade.class).list();
    	for(int i = 0;i < ls.size();i++)
    	{
    		session.delete(ls.get(i));
    	}
    }
    
	@Transactional
    public void addCoursesByStudent(Student student,String course_Identifier)
    {
    	Session session = sessionFactory.getCurrentSession();
    	Grade grade = new Grade();
    	grade.setStudent(student.getIdentifier());
    	grade.setCourse(course_Identifier);
    	grade.setScore(0);
    	session.save(grade);
    }
    
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
}