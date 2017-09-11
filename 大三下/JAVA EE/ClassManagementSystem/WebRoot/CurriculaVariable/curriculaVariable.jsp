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
function refresh(message)
{
	if(message == "0" || message == "1")
	{
		var classType = $("#classType").val();
		var class_Identifier = $("#class").val();
		$("#result").load("CurriculaVariable/classCourses.jsp?classType="
		 + classType + "&class_Identifier=" + class_Identifier);
		if(message == "0")
		{
			layer.msg("退课成功",{time:500,offset:['530px','460px']});
		}
		else if(message == "1")
		{
		 	layer.msg("选课成功",{time:500,offset:['530px','460px']});
		}
	 }
	 else if(message == "2" || message == "3")
	 {
		var classType = $("#classType").val();
		var student_Identifier = $("#student").val();
		$("#result").load("CurriculaVariable/studentCourses.jsp?classType="
		 + classType + "&student_Identifier=" + student_Identifier);
		if(message == "2")
		{
			layer.msg("退课成功",{time:500,offset:['530px','460px']});
		}
		else if(message == "3")
		{
		 	layer.msg("选课成功",{time:500,offset:['530px','460px']});
		}
	 }
}
$(document).ready(function()
{
	$("#query").click(function()
	{
		if($("#studentDiv").is(":hidden"))
		{
			var classType = $("#classType").val();
			var class_Identifier = $("#class").val();
			$("#result").load("CurriculaVariable/classCourses.jsp?classType="
			 + classType + "&class_Identifier=" + class_Identifier);
		}
		else if($("#classDiv").is(":hidden"))
		{
			var classType = $("#classType").val();
			var student_Identifier = $("#student").val();
			$("#result").load("CurriculaVariable/studentCourses.jsp?classType="
			 + classType + "&student_Identifier=" + student_Identifier);
		}
	});
});
layui.use(['form',],function()
{
	var form = layui.form();
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
			$("#classType").empty();
			$("#classType").append("<option value='必修'>必修</option>");
			$("#classType").append("<option value='学位'>学位</option>");
			$("#studentDiv").hide();
			$("#classDiv").show();
			form.render();
		}
		else if(data.value == "1")
		{
			$("#classType").empty();
			$("#classType").append("<option value='必修'>必修</option>");
			$("#classType").append("<option value='学位'>学位</option>");
			$("#classType").append("<option value='选修'>选修</option>");
			$("#classType").append("<option value='限选'>限选</option>");
			$("#classDiv").hide();
			$("#studentDiv").show();
			form.render();
		}
	});
});
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>选课信息管理</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" method="post" onsubmit="return false;">
	<div class="layui-input-inline" style="margin-left:85px;margin-top:13px">
		<label>选课方式：</label>
		<div class="layui-input-inline" style="margin-left:5px;width:70px;">
	        <select id="way" name="way" lay-filter="way" style="height:38px;">
		        <option value="0">班级</option>
		        <option value="1">学生</option>
	        </select>
        </div>
	</div>
	<div class="layui-input-inline" style="margin-left:15px;margin-top:13px">
		<label>课程类型：</label>
		<div class="layui-input-inline a" style="margin-left:5px;width:70px;">
	        <select id="classType" name="classType" style="height:38px;">
		        <option value="必修">必修</option>
		        <option value="学位">学位</option>
	        </select>
        </div>
	</div>
	<div id="classDiv" class="layui-input-inline" style="margin-left:15px;margin-top:13px">
		<label>班级：</label>
		<div class="layui-input-inline" style="margin-left:5px;width:125px;">
	        <select id="class" name="class" lay-search="" style="height:38px;">
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
	<div id="result" style="margin-left:100px;margin-top:35px;width:1050px;"></div>
</body>
</html>