<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.GradeOperate"%>
<%@ page import="service.CourseOperate"%>
<%@ page import="model.Grade"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String student_Identifier = request.getParameter("student_Identifier");
	GradeOperate gradeOperate = new GradeOperate();
	gradeOperate.createGradeDao();
	gradeOperate.createStudentDao();
	gradeOperate.createCourseDao();
	CourseOperate courseOperate = new  CourseOperate();
	courseOperate.createCourseDao();
	List<Grade> ls = gradeOperate.getGradesByStudent(student_Identifier);
	int credit = gradeOperate.getCreditByStudent(ls);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript">
function isPass()
{
	var tr = document.getElementById("table").childNodes[1].childNodes;
	for(var i = 2;i < tr.length;i+=2)
	{
		var score = tr[i].cells[2].innerText;
		if(score < 60)
		{
			tr[i].style.color = "red";
			tr[i].style.fontWeight = "bold";
		}
	}
}
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top:5px;">
  		<legend><%= ls.get(0).getStudent()%></legend>
	</fieldset>
	<label style="margin-left:100px;">已修学分：<%= credit%></label>
	<table id="table" class="layui-table" style="width:600px;margin-left:100px;margin-top:15px;">
		<tr>
			<td width="80px;">序号</td>
			<td width="260px;">课程名称</td>
			<td width="80px;">分数</td>
		</tr>
		<%
			for (int i = 0; i < ls.size(); i++)
			{
		%>
		<tr>
			<td>
				<%
					out.print(i);
				%>
			</td>
			<td>
				<%
					out.print(courseOperate.getNameByIdentifier(ls.get(i).getCourse()));
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getScore());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
<%
	out.print("<script type='text/javascript'>isPass()</script>");
%>
</html>