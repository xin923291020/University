package dao;

import java.util.List;
import model.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class AccountDao
{
	private SessionFactory sessionFactory;

	public AccountDao()
	{
		super();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Account getAccountByAccount(String account)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String hql = "select * from Account Where account = '" + account + "'";
			List<Account> ls = session.createSQLQuery(hql).addEntity(Account.class).list();
			return ls.get(0);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
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