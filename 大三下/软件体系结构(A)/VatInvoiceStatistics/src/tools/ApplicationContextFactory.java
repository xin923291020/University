package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

public class ApplicationContextFactory implements ServletContextListener
{
	private static ApplicationContext applicationContext = null;
	private static Connection connection = null;
	private static Statement statement = null;
	
	public static ApplicationContext getApplicationContext()
	{
		if(applicationContext == null)
		{
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return applicationContext;
	}
	
	public static Connection getConnection() throws SQLException
	{
		if(connection == null)
		{
			SessionFactory sessionFactory = (SessionFactory)getApplicationContext().getBean("sessionFactory");
			connection = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
		}
		return connection;
	}
	
	public static Statement getStatement() throws SQLException
	{
		if(statement == null)
		{
			statement = getConnection().createStatement();
		}
		return statement;
	}
	
	public static PreparedStatement getPreparedStatement(String sql) throws SQLException
	{
		return getConnection().prepareStatement(sql);
	}
	
	public static ResultSet getResultSet(String sql) throws SQLException
	{
		return getStatement().executeQuery(sql);
	}
	
	public static int executeUpdate(String sql) throws SQLException
	{
		return getStatement().executeUpdate(sql);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		getApplicationContext();
		new TableCreateTask();
	}
}
