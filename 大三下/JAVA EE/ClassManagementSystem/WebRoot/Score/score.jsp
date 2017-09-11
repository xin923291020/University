<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript">
$(document).ready(function()
{
	$("#query").click(function()
	{
		if($("#way").val() == "0")
		{
			var course_Identifier = $("#course").val();
			$("#result").load("Score/courseScore.jsp?course_Identifier=" + course_Identifier);
		}
		else if($("#way").val() == "1")
		{
			var student_Identifier = $("#student").val();
			$("#result").load("Score/studentScore.jsp?student_Identifier=" + student_Identifier);
		}
	});
});
layui.use(['form',],function()
{
	var form = layui.form();
	$.ajax(
	{
		type : "post",
		url : "courseReadyAction",
		dataType : "text",
		success:function(data)
		{
			var obj = eval("(" + data + ")");
			for(var i = 0;i < obj.length;i++)
			{
				$("#course").append("<option value='"
				 + obj[i].identifier + "'>" + obj[i].name + "</option>");
			}
			form.render();
		}
	});
	$.ajax(
	{
		type : "post",
		url : "classInfoReadyAction",
		dataType : "text",
		success:function(data)
		{
			var obj = eval("(" + data + ")");
			for(var i = 0;i < obj.length;i++)
			{
				$("#class").append("<option value='"
				 + obj[i].identifier + "'>" + obj[i].name + "</option>");
			}
			form.render();
		}
	});
	$.ajax(
	{
		type : "post",
		url : "studentReadyAction",
		dataType : "text",
		success:function(data)
		{
			var obj = eval("(" + data + ")");
			for(var i = 0;i < obj.length;i++)
			{
				$("#student").append("<option value='"
				 + obj[i].identifier + "'>" + obj[i].name + " " + obj[i].identifier + "</option>");
			}
			form.render();
		}
	});
	form.on("select(way)",function(data)
	{
		if(data.value == "0")
		{
			$("#studentDiv").hide();
			$("#courseDiv").show();
			form.render();
		}
		else if(data.value == "1")
		{
			$("#courseDiv").hide();
			$("#studentDiv").show();
			form.render();
		}
	});
});
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>成绩查询</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" method="post" onsubmit="return false;">
	<div class="layui-input-inline" style="margin-left:85px;margin-top:13px">
		<label>查询方式：</label>
		<div class="layui-input-inline" style="margin-left:5px;width:70px;">
	        <select id="way" name="way" lay-filter="way" style="height:38px;">
		        <option value="0">课程</option>
		        <option value="1">学生</option>
	        </select>
        </div>
	</div>
	<div id="courseDiv" class="layui-input-inline" style="margin-left:15px;margin-top:13px">
		<label>已开课程：</label>
		<div class="layui-input-inline" style="margin-left:5px;width:200px;">
	        <select id="course" name="course" style="height:38px;">
		        <option></option>
	        </select>
        </div>
	</div>
	<div id="studentDiv" class="layui-input-inline" style="margin-left:15px;margin-top:13px;display:none">
		<label>学号：</label>
		<div class="layui-input-inline" style="margin-left:5px;width:165px;">
	        <select id="student" name="student" style="height:38px;" lay-search="">
		        <option value="">请输入学号</option>
	        </select>
        </div>
	</div>
	<div class="layui-input-inline">
		<button class="layui-btn layui-btn-small layui-btn-normal" id="query" style="width:65px;margin-left:20px;margin-top:12px;">查询</button>
	</div>
	</form>
	<div id="result" style="margin-left:140px;margin-top:35px;width:1000px;"></div>
</body>
</html>