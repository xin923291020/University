<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.StudentOperate"%>
<%@ page import="service.ClassInfoOperate"%>
<%@ page import="model.Student"%>
<%@ page import="java.text.DateFormat"%>
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
	StudentOperate studentOperate = new StudentOperate();
	studentOperate.createStudentDao();
	ClassInfoOperate classInfoOperate = new ClassInfoOperate();
	classInfoOperate.createClassInfoDao();
	List<Student> ls = studentOperate.getAllStudent();
	DateFormat dateFormat = DateFormat.getDateInstance();
	String addStudentMessage = (String)session.getAttribute("addStudentMessage");
	String reviseStudentMessage = (String)session.getAttribute("reviseStudentMessage");
	String deleteStudentMessage = (String)session.getAttribute("deleteStudentMessage");
%>
<script type="text/javascript">
$(document).ready(function()
{
	var addStudentMessage = '<%=addStudentMessage%>';
	if(addStudentMessage == "Success")
	{
		layer.msg("新增学生成功",{time:500,offset:['530px','460px']});
	}
	var reviseStudentMessage = '<%=reviseStudentMessage%>';
	if(reviseStudentMessage == "Success")
	{
		layer.msg("修改学生成功",{time:500,offset:['530px','460px']});
	}
	var deleteStudentMessage = '<%=deleteStudentMessage%>';
	if(deleteStudentMessage == "Success")
	{
		layer.msg("删除学生成功",{time:500,offset:['530px','460px']});
	}
	$("#add").click(function()
	{
		layer.open(
		{
			title : "新增学生",
			type : 1,
			offset : ['70px','300px'],
			area : ['420px','450px'],
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
				offset : ['70px','300px'],
				area : ['420px','460px'],
				shadeClose : true,
				content : ["Student/reviseStudent.jsp?identifier=" + identifier],
				end: function()
				{
					location.reload();
				}
			});
		}
		else
		{
			layer.msg("请选中一个学生",{time:500,offset:['530px','460px']});
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
				url : "studentAction?type=delete&student.identifier=" + identifier,
				dataType : "text",
				success:function()
				{
					location.reload();
				}
			});
		}
		else
		{
			layer.msg("请选中一个学生",{time:500,offset:['530px','460px']});
		}
	});
});
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>学生信息管理</legend>
	</fieldset>
	<div style="margin-left:75px;margin-top:35px;width:1000px;">
	<button class="layui-btn layui-btn-small layui-btn-normal" id="add">新增</button>
	<button class="layui-btn layui-btn-small layui-btn-normal" id="revise">修改</button>
	<button class="layui-btn layui-btn-small layui-btn-normal" id="delete">删除</button>
	<table class="layui-table" style="margin-top:15px;">
		<tr>
			<td>选中</td>
			<td>序号</td>
			<td>学号</td>
			<td>班级</td>
			<td>姓名</td>
			<td>性别</td>
			<td>生日</td>
			<td>电话</td>
			<td>住址</td>
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
					out.print(ls.get(i).getIdentifier());
				%>
			</td>
			<td>
				<%
					out.print(classInfoOperate.getClassInfoByIdentifier(ls.get(i).getClass_Identifier()));
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getName());
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getSex());
				%>
			</td>
			<td>
				<%
					out.print(dateFormat.format(ls.get(i).getBirth()));
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getPhone());
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getAddress());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	</div>
	<div id="addDiv" style="display:none">
	<jsp:include page="addStudent.html" />
	</div>
</body>
<%
	session.removeAttribute("addStudentMessage");
	session.removeAttribute("reviseStudentMessage");
	session.removeAttribute("deleteStudentMessage");
%>
</html>