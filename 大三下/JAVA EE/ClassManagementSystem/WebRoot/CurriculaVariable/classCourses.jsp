<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.GradeOperate"%>
<%@ page import="model.Course"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String classType = new String(request.getParameter("classType").getBytes("ISO-8859-1"),"UTF-8");
	String class_Identifier = request.getParameter("class_Identifier");
	GradeOperate gradeOperate = new GradeOperate();
	gradeOperate.createGradeDao();
	List<Course> ls = gradeOperate.getCourseChoosedByClass(classType,class_Identifier);
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
<script type="text/javascript">
var class_Identifier = '<%= class_Identifier%>';
$(document).ready(function()
{
	$("#delete").click(function()
	{
		var course_Identifier = $("input[name='dropRadio']:checked").val();
		if(course_Identifier != null)
		{
			$.ajax(
			{
				type : "post",
				url : "dropCoursesAction?dropType=class&class_Identifier=" + class_Identifier +
					"&course_Identifier=" + course_Identifier,
				dataType : "text",
				success:function()
				{
					refresh("0");
				}
			});
		}
		else
		{
			layer.msg("请选中一个已选课程",{time:500,offset:['530px','460px']});
		}
	});
	$("#add").click(function()
	{
		var course_Identifier = $("input[name='addRadio']:checked").val();
		if(course_Identifier != null)
		{
			$.ajax(
			{
				type : "post",
				url : "addCoursesAction?addType=class&class_Identifier=" + class_Identifier +
					"&course_Identifier=" + course_Identifier,
				dataType : "text",
				success:function()
				{
					refresh("1");
				}
			});
		}
		else
		{
			layer.msg("请选中一个未选课程",{time:500,offset:['530px','460px']});
		}
	});
});
</script>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top:5px;">
  		<legend>已选课程</legend>
	</fieldset>
	<button class="layui-btn layui-btn-small layui-btn-normal" id="delete">退课</button>
	<table class="layui-table" style="width:850px;margin-top:15px;">
		<tr>
			<td>选中</td>
			<td>序号</td>
			<td>课程名称</td>
			<td>课程性质</td>
			<td>学分</td>
		</tr>
		<%
			for (int i = 0; i < ls.size(); i++)
			{
		%>
		<tr>
			<td>
				<input type="radio" name="dropRadio" value='<%=ls.get(i).getIdentifier()%>'>
			</td>
			<td>
				<%
					out.print(i);
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getName());
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getProperty());
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getCredit());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		ls = gradeOperate.getCourseNotChoosedByClass(classType,class_Identifier);
	 %>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top:35px;">
  		<legend>未选课程</legend>
	</fieldset>
	<button class="layui-btn layui-btn-small layui-btn-normal" id="add">选课</button>
	<table class="layui-table" style="width:850px;margin-top:15px;">
		<tr>
			<td>选中</td>
			<td>序号</td>
			<td>课程名称</td>
			<td>课程性质</td>
			<td>学分</td>
		</tr>
		<%
			for (int i = 0; i < ls.size(); i++)
			{
		%>
		<tr>
			<td>
				<input type="radio" name="addRadio" value='<%=ls.get(i).getIdentifier()%>'>
			</td>
			<td>
				<%
					out.print(i);
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getName());
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getProperty());
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getCredit());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>