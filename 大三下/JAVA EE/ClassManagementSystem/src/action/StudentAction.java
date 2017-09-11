package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentOperate;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Student student;

	public String execute()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentOperate studentOperate = (StudentOperate) application.getBean("myStudentOperate");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		if(type.equals("add"))
		{
			studentOperate.addStudent(student.getIdentifier(),student.getClass_Identifier(),
					student.getName(),student.getSex(),student.getBirth(),
					student.getPhone(),request.getParameter("addressPrefix") + request.getParameter("addressSuffix"));
			ServletActionContext.getRequest().getSession().setAttribute("addStudentMessage","Success");
			return SUCCESS;
		}
		else if(type.equals("revise"))
		{
			studentOperate.updateStudent(student.getIdentifier(),student.getClass_Identifier(),
					student.getName(),student.getSex(),student.getBirth(),
					student.getPhone(),request.getParameter("addressPrefix") + request.getParameter("addressSuffix"));
			ServletActionContext.getRequest().getSession().setAttribute("reviseStudentMessage","Success");
			return null;
		}
		else if(type.equals("delete"))
		{
			studentOperate.deleteStudent(student.getIdentifier());
			ServletActionContext.getRequest().getSession().setAttribute("deleteStudentMessage","Success");
			return null;
		}
		return ERROR;
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