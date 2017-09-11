package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextFactory
{
	private static ApplicationContext applicationContext = null;
	
	public static ApplicationContext getApplicationContext()
	{
		if(applicationContext == null)
		{
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return applicationContext;
	}
}
