package dao;

import java.util.List;
import model.Course;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class CourseDao
{
	private SessionFactory sessionFactory;
	
	public CourseDao()
	{
		super();
	}
    @Transactional
    public boolean addCourse(String identifier,String name,String property,int credit)
    {
    	boolean isSuccess = false;
    	try
		{
			Session session = sessionFactory.getCurrentSession();
			Course course = new Course(identifier,name,property,credit);
			session.save(course);
			isSuccess = true;
		}
    	catch (HibernateException e)
		{
			e.printStackTrace();
		}
    	return isSuccess;
    }
    @Transactional
    public boolean deleteByIdentifier(String identifier)
    {
    	boolean isSuccess = false;
    	try
		{
			Session session = sessionFactory.getCurrentSession();
			Course course = session.get(Course.class,identifier);
			session.delete(course);
			isSuccess = true;
		}
    	catch (HibernateException e)
		{
			e.printStackTrace();
		}
    	return isSuccess;
    }
    @Transactional
	public boolean updateCourse(String identifier,String name,String property,int credit)
	{
    	boolean isSuccess = false;
    	try
		{
			Session session = sessionFactory.getCurrentSession();
			Course course = session.get(Course.class,identifier);
			course.setName(name);
			course.setProperty(property);
			course.setCredit(credit);
			session.update(course);
			isSuccess = true;
		}
    	catch (HibernateException e)
		{
			e.printStackTrace();
		}
    	return isSuccess;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<Course> getAllCourses()
	{
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from course";
		List<Course> ls = session.createSQLQuery(hql).addEntity(Course.class).list();
		return ls;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<Course> getAlreadyStartedCourses()
	{
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from Course Where Identifier In (Select Course_Identifier from Grade)";
		List<Course> ls = session.createSQLQuery(hql).addEntity(Course.class).list();
		return ls;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<Course> getCourseByIdentifier(String identifier)
	{
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from course where identifier = '" + identifier + "'";
		List<Course> ls = session.createSQLQuery(hql).addEntity(Course.class).list();
		return ls;
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