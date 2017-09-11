package dao;

import java.util.Date;
import java.util.List;
import model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao
{
	private SessionFactory sessionFactory;
	
	public StudentDao()
	{
		super();
	}
    @Transactional
    public boolean addStudent(String identifier, String class_Identifier,
			String name, String sex, Date birth, String phone, String address)
    {
    	boolean isSuccess = false;
    	try
		{
			Session session = sessionFactory.getCurrentSession();
			Student classInfo = new Student(identifier,class_Identifier,identifier,name,sex,birth,phone,address);
			session.save(classInfo);
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
			Student student = session.get(Student.class,identifier);
			session.delete(student);
			isSuccess = true;
		}
    	catch (HibernateException e)
		{
			e.printStackTrace();
		}
    	return isSuccess;
    }
	@Transactional
	public boolean updateStudents(String identifier, String class_Identifier,
			String name, String sex, Date birth, String phone, String address)
	{
    	boolean isSuccess = false;
    	try
		{
			Session session = sessionFactory.getCurrentSession();
			Student student = session.get(Student.class,identifier);
			student.setClass_Identifier(class_Identifier);
			student.setName(name);
			student.setSex(sex);
			student.setBirth(birth);
			student.setPhone(phone);
			student.setAddress(address);
			session.update(student);
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
	public List<Student> getAllStudents()
	{
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from Student";
		List<Student> ls = session.createSQLQuery(hql).addEntity(Student.class).list();
		return ls;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<Student> getByIdentifier(String identifier)
	{
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from Student Where identifier = '" + identifier + "'";
		List<Student> ls = session.createSQLQuery(hql).addEntity(Student.class).list();
		return ls;
	}

    @SuppressWarnings("unchecked")
	@Transactional
	public List<Student> getByClassIdentifier(String class_Identifier)
	{
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from Student Where class_Identifier = '" + class_Identifier + "'";
		List<Student> ls = session.createSQLQuery(hql).addEntity(Student.class).list();
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