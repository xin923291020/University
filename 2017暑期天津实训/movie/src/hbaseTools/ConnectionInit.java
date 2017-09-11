package hbaseTools;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionInit implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		HbaseFactory.getHbaseConnection();
	}
}
