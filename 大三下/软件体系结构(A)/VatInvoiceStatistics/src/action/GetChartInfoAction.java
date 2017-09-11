package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import service.GetChartInfoService;
import tools.ApplicationContextFactory;

import com.opensymphony.xwork2.ActionSupport;


public class GetChartInfoAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public void doGetInOneYear() throws IOException
	{
		ApplicationContext application = ApplicationContextFactory.getApplicationContext();
		GetChartInfoService myGetChartInfoService = (GetChartInfoService) application.getBean("myGetChartInfoService");
		HttpServletRequest request = ServletActionContext.getRequest();
		String year = request.getParameter("year");
		String kind = request.getParameter("kind");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(myGetChartInfoService.getChartInfoInOneYear(year,kind));
	}
	
	public void doGetInManyYear() throws IOException
	{
		ApplicationContext application = ApplicationContextFactory.getApplicationContext();
		GetChartInfoService myGetChartInfoService = (GetChartInfoService) application.getBean("myGetChartInfoService");
		HttpServletRequest request = ServletActionContext.getRequest();
		String startYear = request.getParameter("startYear");
		String finishYear = request.getParameter("finishYear");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(myGetChartInfoService.getChartInfoInManyYear(startYear,finishYear));
	}
	
	public void doGetByCurrentTime() throws IOException
	{
		ApplicationContext application = ApplicationContextFactory.getApplicationContext();
		GetChartInfoService myGetChartInfoService = (GetChartInfoService) application.getBean("myGetChartInfoService");
		HttpServletRequest request = ServletActionContext.getRequest();
		String times = request.getParameter("times");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(myGetChartInfoService.getChartByCurrentTime(times));
	}
}