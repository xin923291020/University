package service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.ClassInfo;
import dao.ClassInfoDao;

public class ClassInfoOperate
{
	private ClassInfoDao classInfoDao;

	public void createClassInfoDao()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		classInfoDao = (ClassInfoDao) application.getBean("myClassInfoDao");
	}
	
	public boolean addClassInfo(String identifier,String name)
	{
		return classInfoDao.addClassInfo(identifier,name);
	}
	
	public boolean deleteClassInfo(String identifier)
	{
		return classInfoDao.deleteByIdentifier(identifier);
	}
	
	public List<ClassInfo> getAllClassInfo()
	{
		List<ClassInfo> ls = classInfoDao.getAllClassInfo();
		return ls;
	}
	
	public String getClassInfoByIdentifier(String identifier)
	{
		List<ClassInfo> ls = classInfoDao.getClassInfoByIdentifier(identifier);
		return ls.get(0).getName();
	}
	
	public String getAllClassInfoString() throws JSONException
	{
		List<ClassInfo> ls = classInfoDao.getAllClassInfo();
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
	
	public ClassInfoDao getClassInfoDao()
	{
		return classInfoDao;
	}

	public void setClassInfoDao(ClassInfoDao classInfoDao)
	{
		this.classInfoDao = classInfoDao;
	}
}