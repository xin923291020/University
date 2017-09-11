package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.GradeOperate;

import com.opensymphony.xwork2.ActionSupport;

public class AddCoursesAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public void doAdd()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		GradeOperate myGradeOperate = (GradeOperate) application.getBean("myGradeOperate");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String addType = request.getParameter("addType");
		if(addType.equals("class"))
		{
			String class_Identifier = request.getParameter("class_Identifier");
			String course_Identifier = request.getParameter("course_Identifier");
			myGradeOperate.addCoursesByClass(class_Identifier, course_Identifier);
		}
		else if(addType.equals("student"))
		{
			String student_Identifier = request.getParameter("student_Identifier");
			String course_Identifier = request.getParameter("course_Identifier");
			myGradeOperate.addCoursesByStudent(student_Identifier,course_Identifier);
		}
	}
}