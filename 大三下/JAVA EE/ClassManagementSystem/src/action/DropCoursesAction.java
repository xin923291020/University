package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.GradeOperate;

import com.opensymphony.xwork2.ActionSupport;

public class DropCoursesAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public void doDrop()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		GradeOperate myGradeOperate = (GradeOperate) application.getBean("myGradeOperate");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String dropType = request.getParameter("dropType");
		if(dropType.equals("class"))
		{
			String class_Identifier = request.getParameter("class_Identifier");
			String course_Identifier = request.getParameter("course_Identifier");
			myGradeOperate.dropCoursesByClass(class_Identifier, course_Identifier);
		}
		else if(dropType.equals("student"))
		{
			String student_Identifier = request.getParameter("student_Identifier");
			String course_Identifier = request.getParameter("course_Identifier");
			myGradeOperate.dropCoursesByStudent(student_Identifier, course_Identifier);
		}
	}
}