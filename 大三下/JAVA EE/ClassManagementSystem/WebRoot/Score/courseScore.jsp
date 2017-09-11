<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.GradeOperate"%>
<%@ page import="service.CourseOperate"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String course_Identifier = request.getParameter("course_Identifier");
	GradeOperate gradeOperate = new GradeOperate();
	gradeOperate.createGradeDao();
	gradeOperate.createStudentDao();
	gradeOperate.createCourseDao();
	CourseOperate courseOperate = new  CourseOperate();
	courseOperate.createCourseDao();
	Iterator<?> iterator = gradeOperate.getGradeByCourse(course_Identifier);
	Object[] score = (Object[])iterator.next();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top:5px;">
	</fieldset>
	<table id="table" class="layui-table" style="width:600px;margin-left:20px;margin-top:15px;">
		<tr>
			<td width="260px;">课程名称</td>
			<td width="80px;">最高分</td>
			<td width="80px;">最低分</td>
			<td width="80px;">平均分</td>
		</tr>
		<tr>
			<td>
				<%
					out.print(courseOperate.getNameByIdentifier(course_Identifier));
				%>
			</td>
			<td>
				<%
					out.print(score[0]);
				%>
			</td>
			<td>
				<%
					out.print(score[1]);
				%>
			</td>
			<td>
				<%
					out.print(score[2]);
				%>
			</td>
		</tr>
	</table>
</body>
</html>