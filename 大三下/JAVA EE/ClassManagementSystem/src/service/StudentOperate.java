package service;

import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.Student;
import dao.StudentDao;


public class StudentOperate
{
	private StudentDao studentDao;

	public void createStudentDao()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		studentDao = (StudentDao) application.getBean("myStudentDao");
	}
	
	public boolean addStudent(String identifier, String class_Identifier,
			String name, String sex, Date birth, String phone, String address)
	{
		return studentDao.addStudent(identifier,class_Identifier,name,sex,birth,phone,address);
	}
	
	public boolean isLoginSuccess(String identifier,String password)
	{
		List<Student> ls = studentDao.getByIdentifier(identifier);
		if(ls.get(0).getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean updateStudent(String identifier, String class_Identifier,
			String name, String sex, Date birth, String phone, String address)
	{
		return studentDao.updateStudents(identifier,class_Identifier,name,sex,birth,phone,address);
	}
	
	public boolean deleteStudent(String identifier)
	{
		return studentDao.deleteByIdentifier(identifier);
	}

	public List<Student> getAllStudent()
	{
		List<Student> ls = studentDao.getAllStudents();
		return ls;
	}
	
	public String getNameByIdentifier(String identifier)
	{
		List<Student> ls = studentDao.getByIdentifier(identifier);
		return ls.get(0).getName();
	}
	
	public List<Student> getStudentByIdentifier(String identifier)
	{
		List<Student> ls = studentDao.getByIdentifier(identifier);
		return ls;
	}
	
	public String getAllClassInfoString() throws JSONException
	{
		List<Student> ls = studentDao.getAllStudents();
		JSONArray jsonArray = new JSONArray();
		for(int i = 0;i < ls.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("identifier",ls.get(i).getIdentifier());
			jsonObject.put("name",ls.get(i).getName());
			jsonArray.put(jsonObject);
		}
		return jsonArray.toString();
	}
	
	public StudentDao getStudentDao()
	{
		return studentDao;
	}
	
	public void setStudentDao(StudentDao studentDao)
	{
		this.studentDao = studentDao;
	}
}