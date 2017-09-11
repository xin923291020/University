<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.CourseOperate"%>
<%@ page import="model.Course"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script src="JsFiles/jquery-1.9.1.js"></script>
<script src="JsFiles/layer.js"></script>
<script src="JsFiles/layui-v1.0.9_rls/layui/layui.js" charset="utf-8"></script>
<link href="CssFiles/layer.css" type="text/css" rel="stylesheet"/>
<link href="CssFiles/layui.css" type="text/css" rel="stylesheet"/>
<%
	CourseOperate studentOperate = new CourseOperate();
	studentOperate.createCourseDao();
	List<Course> ls = studentOperate.getAllCourses();
	String addCourseMessage = (String)session.getAttribute("addCourseMessage");
	String reviseCourseMessage = (String)session.getAttribute("reviseCourseMessage");
	String deleteCourseMessage = (String)session.getAttribute("deleteCourseMessage");
%>
<script type="text/javascript">
$(document).ready(function()
{
	var addCourseMessage = '<%=addCourseMessage%>';
	if(addCourseMessage == "Success")
	{
		layer.msg("新增课程成功",{time:500,offset:['530px','460px']});
	}
	var reviseCourseMessage = '<%=reviseCourseMessage%>';
	if(reviseCourseMessage == "Success")
	{
		layer.msg("修改课程成功",{time:500,offset:['530px','460px']});
	}
	var deleteCourseMessage = '<%=deleteCourseMessage%>';
	if(deleteCourseMessage == "Success")
	{
		layer.msg("删除课程成功",{time:500,offset:['530px','460px']});
	}
	$("#add").click(function()
	{
		layer.open(
		{
			title : "新增学生",
			type : 1,
			offset : ['130px','350px'],
			area : ['345px','335px'],
			shadeClose : true,
			content : $("#addDiv")
		});
	});
	$("#revise").click(function()
	{
		var identifier = $("input[name='radio']:checked").val();
		if(identifier != null)
		{
			layer.open(
			{
				title : "修改学生信息",
				type : 2,
				offset : ['130px','350px'],
				area : ['345px','335px'],
				shadeClose : true,
				content : ["Course/reviseCourse.jsp?identifier=" + identifier],
				end: function()
				{
					location.reload();
				}
			});
		}
		else
		{
			layer.msg("请选中一个班级",{time:500,offset:['530px','460px']});
		}
	});
	$("#delete").click(function()
	{
		var identifier = $("input[name='radio']:checked").val();
		if(identifier != null)
		{
			$.ajax(
			{
				type : "post",
				url : "courseAction?type=delete&course.identifier=" + identifier,
				dataType : "text",
				success:function()
				{
					location.reload();
				}
			});
		}
		else
		{
			layer.msg("请选中一个班级",{time:500,offset:['530px','460px']});
		}
	});
});
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>课程信息管理</legend>
	</fieldset>
	<div style="margin-left:205px;margin-top:35px;width:720px;">
	<button class="layui-btn layui-btn-small layui-btn-normal" id="add">新增</button>
	<button class="layui-btn layui-btn-small layui-btn-normal" id="revise">修改</button>
	<button class="layui-btn layui-btn-small layui-btn-normal" id="delete">删除</button>
	<table class="layui-table" style="margin-top:15px;">
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
				<input type="radio" name="radio" value='<%=ls.get(i).getIdentifier()%>'>
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
	</div>
	<div id="addDiv" style="display:none">
	<jsp:include page="addCourse.html" />
	</div>
</body>
<%
	session.removeAttribute("addCourseMessage");
	session.removeAttribute("reviseCourseMessage");
	session.removeAttribute("deleteCourseMessage");
%>
</html>