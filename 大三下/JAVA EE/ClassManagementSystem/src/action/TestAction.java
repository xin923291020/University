package action;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ClassInfoDao;

public class TestAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	public void aa()
	{
		System.out.println("ww");
		try
		{
			ApplicationContext ac = ApplicationContextFactory.getApplicationContext();
			ClassInfoDao classInfoDao = (ClassInfoDao)ac.getBean("myClassInfoDao");
			for(int i = 0;i < 10;i++)
			{
				classInfoDao.getAllClassInfo();
			}
		} catch (BeansException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
