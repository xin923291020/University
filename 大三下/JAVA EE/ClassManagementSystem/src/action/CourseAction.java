package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CourseOperate;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Course course;

	public String execute()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseOperate courseOperate = (CourseOperate) application.getBean("myCourseOperate");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		if(type.equals("add"))
		{
			courseOperate.addCourse(course.getIdentifier(),
					course.getName(),course.getProperty(),course.getCredit());
			ServletActionContext.getRequest().getSession().setAttribute("addCourseMessage","Success");
			return "success";
		}
		else if(type.equals("revise"))
		{
			courseOperate.updateCourse(course.getIdentifier(),
					course.getName(),course.getProperty(),course.getCredit());
			ServletActionContext.getRequest().getSession().setAttribute("reviseCourseMessage","Success");
			return null;
		}
		else if(type.equals("delete"))
		{
			courseOperate.deleteCourse(course.getIdentifier());
			ServletActionContext.getRequest().getSession().setAttribute("deleteCourseMessage","Success");
			return null;
		}
		return ERROR;
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}
}