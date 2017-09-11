package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.GradeOperate;

import com.opensymphony.xwork2.ActionSupport;

public class GradeAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public void doUpdate() throws IOException
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		GradeOperate myGradeOperate = (GradeOperate) application.getBean("myGradeOperate");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String identifier = request.getParameter("identifier");
		String course_identifier = request.getParameter("course_identifier");
		String score = request.getParameter("score");
		boolean isSuccess = myGradeOperate.updateGradeByStudentAndCourse(score,identifier,course_identifier);
		if(isSuccess)
		{
			response.getWriter().print("success");
		}
	}
}