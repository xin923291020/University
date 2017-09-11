package action;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ClassInfoOperate;
import service.CourseOperate;
import service.StudentOperate;

import com.opensymphony.xwork2.ActionSupport;


public class ReadyAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public void getCourseRequest() throws JSONException, IOException
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		CourseOperate courseOperate = (CourseOperate) application.getBean("myCourseOperate");
		String course = courseOperate.getAlreadyStartedCoursesToString();
		response.getWriter().print(course);
	}
	
	public void getClassInfoRequest() throws JSONException, IOException
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		ClassInfoOperate classInfoOperate = (ClassInfoOperate) application.getBean("myClassInfoOperate");
		String classInfo = classInfoOperate.getAllClassInfoString();
		response.getWriter().print(classInfo);
	}
	
	public void getStudentRequest() throws IOException, JSONException
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		StudentOperate studentOperate = (StudentOperate) application.getBean("myStudentOperate");
		String student = studentOperate.getAllClassInfoString();
		response.getWriter().print(student);
	}
}