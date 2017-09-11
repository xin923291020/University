package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClassInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ClassInfoOperate;
import com.opensymphony.xwork2.ActionSupport;

public class ClassInfoAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private ClassInfo classInfo;

	public String execute()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassInfoOperate classInfoOperate = (ClassInfoOperate) application.getBean("myClassInfoOperate");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		if(type.equals("add"))
		{
			String classPrefix = request.getParameter("classPrefix");
			String classSuffix = request.getParameter("classSuffix");
			classInfoOperate.addClassInfo(classPrefix + classSuffix,"пе" + classPrefix + "-" + classSuffix + "╟Ю");
			ServletActionContext.getRequest().getSession().setAttribute("addClassMessage","Success");
			return "success";
		}
		else if(type.equals("delete"))
		{
			classInfoOperate.deleteClassInfo(classInfo.getIdentifier());
			ServletActionContext.getRequest().getSession().setAttribute("deleteClassMessage","Success");
			return null;
		}
		return ERROR;
	}

	public ClassInfo getClassInfo()
	{
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo)
	{
		this.classInfo = classInfo;
	}
}