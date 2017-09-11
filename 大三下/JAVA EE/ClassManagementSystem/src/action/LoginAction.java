package action;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import model.Student;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentOperate;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Student student;

	public void doLogin() throws IOException
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentOperate studentOperate = (StudentOperate) application.getBean("myStudentOperate");
		HttpServletResponse response = ServletActionContext.getResponse();
		if(studentOperate.isLoginSuccess(student.getIdentifier(),student.getPassword()))
		{
			response.getWriter().print("true");
		}
		else
		{
			response.getWriter().print("false");
		}
	}

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}
}