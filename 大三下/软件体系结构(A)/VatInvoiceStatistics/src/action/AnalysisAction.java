package action;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import service.AnalysisService;
import tools.ApplicationContextFactory;

import com.opensymphony.xwork2.ActionSupport;

public class AnalysisAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	public void doAnalysis() throws IOException
	{
		ApplicationContext application = ApplicationContextFactory.getApplicationContext();
		AnalysisService myAnalysisService = (AnalysisService) application.getBean("myAnalysisService");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(myAnalysisService.getAnalysisResult());
	}
	
}