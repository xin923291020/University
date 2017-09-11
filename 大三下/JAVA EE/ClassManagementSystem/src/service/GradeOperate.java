package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Course;
import model.Grade;
import model.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CourseDao;
import dao.GradeDao;
import dao.StudentDao;

public class GradeOperate
{
	private GradeDao gradeDao;
	private StudentDao studentDao;
	private CourseDao courseDao;

	public void createGradeDao()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		gradeDao = (GradeDao) application.getBean("myGradeDao");
	}
	
	public void createStudentDao()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		studentDao = (StudentDao) application.getBean("myStudentDao");
	}
	
	public void createCourseDao()
	{
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		courseDao = (CourseDao) application.getBean("myCourseDao");
	}

	public Iterator<?> getGradeByCourse(String course_Identifier)
	{
		return gradeDao.getGradeByCourse(course_Identifier);
	}
	
	public boolean updateGradeByStudentAndCourse(String score,String identifier,String course_Identifier)
	{
		return gradeDao.updateGradeByStudentAndCourse(score,identifier,course_Identifier);
	}
	
	public List<Course> getCourseChoosedByClass(String classType,String class_Identifier)
	{
		return gradeDao.getCourseChoosedByClass(classType,class_Identifier);
	}
	
	public List<Course> getCourseNotChoosedByClass(String classType,String class_Identifier)
	{
		return gradeDao.getCourseNotChoosedByClass(classType,class_Identifier);
	}
	
	public List<Course> getCourseChoosedByStudent(String classType,String student_Identifier)
	{
		return gradeDao.getCourseChoosedByStudent(classType,student_Identifier);
	}
	
	public List<Course> getCourseNotChoosedByStudent(String classType,String student_Identifier)
	{
		return gradeDao.getCourseNotChoosedByStudent(classType,student_Identifier);
	}
	
	public List<Grade> getGradesByClass(String course,String class_Identifier)
	{
		List<Grade> result = new ArrayList<Grade>();
		List<Student> ls = studentDao.getByClassIdentifier(class_Identifier);
		for(int i = 0;i < ls.size();i++)
		{
			Grade grade = (Grade) gradeDao.getGradeByCourseAndStudent(course,ls.get(i).getIdentifier());
			if(grade != null)
			{
				result.add(grade);
			}
		}
		return result;
	}

	public int getCreditByStudent(List<Grade> ls)
	{
		int result = 0;
		for(int i = 0;i < ls.size();i++)
		{
			if(ls.get(i).getScore() >= 60)
			{
				List<Course> course = courseDao.getCourseByIdentifier(ls.get(i).getCourse());
				result += course.get(0).getCredit();
			}
		}
		return result;
	}

	public List<Grade> getGradesByStudent(String student_Identifier)
	{
		return gradeDao.getGradeByStudent(student_Identifier);
	}
	
	public List<Grade> getGradesByStudentAndCourse(String course,String student_Identifier)
	{
		List<Grade> result = new ArrayList<Grade>();
		Grade grade = (Grade) gradeDao.getGradeByCourseAndStudent(course,student_Identifier);
		if(grade != null)
		{
			result.add(grade);
		}
		return result;
	}
	
	public void addCoursesByStudent(String student_Identifier,String course_Identifier)
	{
		List<Student> ls = studentDao.getByIdentifier(student_Identifier);
		for(int i = 0;i < ls.size();i++)
		{
			gradeDao.addCoursesByStudent(ls.get(i),course_Identifier);
		}
	}
	
	public void addCoursesByClass(String class_Identifier,String course_Identifier)
	{
		List<Student> ls = studentDao.getByClassIdentifier(class_Identifier);
		for(int i = 0;i < ls.size();i++)
		{
			gradeDao.addCoursesByStudent(ls.get(i),course_Identifier);
		}
	}
	
	public void dropCoursesByClass(String class_Identifier,String course_Identifier)
	{
		List<Student> ls = studentDao.getByClassIdentifier(class_Identifier);
		for(int i = 0;i < ls.size();i++)
		{
			gradeDao.dropCoursesByStudent(ls.get(i),course_Identifier);
		}
	}
	
	public void dropCoursesByStudent(String student_Identifier,String course_Identifier)
	{
		List<Student> ls = studentDao.getByIdentifier(student_Identifier);
		for(int i = 0;i < ls.size();i++)
		{
			gradeDao.dropCoursesByStudent(ls.get(i),course_Identifier);
		}
	}
	
	public GradeDao getGradeDao()
	{
		return gradeDao;
	}

	public void setGradeDao(GradeDao gradeDao)
	{
		this.gradeDao = gradeDao;
	}

	public StudentDao getStudentDao()
	{
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao)
	{
		this.studentDao = studentDao;
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