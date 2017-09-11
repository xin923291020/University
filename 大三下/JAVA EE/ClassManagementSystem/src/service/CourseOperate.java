package service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Course;
import dao.CourseDao;


public class CourseOperate
{
	private CourseDao courseDao;

	public void createCourseDao()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		courseDao = (CourseDao) application.getBean("myCourseDao");
	}
	
	public boolean addCourse(String identifier,String name,String property,int credit)
	{
		return courseDao.addCourse(identifier,name,property,credit);
	}
	
	public boolean deleteCourse(String identifier)
	{
		return courseDao.deleteByIdentifier(identifier);
	}
	
	public boolean updateCourse(String identifier,String name,String property,int credit)
	{
		return courseDao.updateCourse(identifier,name,property,credit);
	}
	
	public List<Course> getAllCourses()
	{
		List<Course> ls = courseDao.getAllCourses();
		return ls;
	}
	
	public String getAlreadyStartedCoursesToString() throws JSONException
	{
		List<Course> ls = courseDao.getAlreadyStartedCourses();
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
	
	public List<Course> getCourseByIdentifier(String identifier)
	{
		List<Course> ls = courseDao.getCourseByIdentifier(identifier);
		return ls;
	}
	
	public String getNameByIdentifier(String identifier)
	{
		List<Course> ls = courseDao.getCourseByIdentifier(identifier);
		return ls.get(0).getName();
	}
	
	public CourseDao getCourseDao()
	{
		return courseDao;
	}
	public void setCourseDao(CourseDao courseDao)
	{
		this.courseDao = courseDao;
	}
}