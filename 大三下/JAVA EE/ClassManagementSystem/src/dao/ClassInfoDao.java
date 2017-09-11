package dao;

import java.util.List;
import model.ClassInfo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class ClassInfoDao
{
	private SessionFactory sessionFactory;
	
	public ClassInfoDao()
	{
		super();
	}
	
    @Transactional
    public boolean addClassInfo(String identifier,String name)
    {
    	boolean isSuccess = false;
    	try
		{
			Session session = sessionFactory.getCurrentSession();
			ClassInfo classInfo = new ClassInfo(identifier,name);
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
			ClassInfo classInfo = session.get(ClassInfo.class,identifier);
			session.delete(classInfo);
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
	public List<ClassInfo> getAllClassInfo()
	{
		System.out.println("ee");
    	List<ClassInfo> ls = null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String hql = "select * from ClassInfo";
			ls = session.createSQLQuery(hql).addEntity(ClassInfo.class).list();
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<ClassInfo> getClassInfoByIdentifier(String identifier)
	{
    	Session session = sessionFactory.getCurrentSession();
		String hql = "select * from ClassInfo where identifier = '" + identifier + "'";
		List<ClassInfo> ls = session.createSQLQuery(hql).addEntity(ClassInfo.class).list();
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