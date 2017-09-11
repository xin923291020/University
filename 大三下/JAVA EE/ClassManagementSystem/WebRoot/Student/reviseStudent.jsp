<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.StudentOperate"%>
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
<script src="JsFiles/jquery-1.9.1.js"></script>
<script src="JsFiles/layer.js"></script>
<script src="JsFiles/layui-v1.0.9_rls/layui/layui.js" charset="utf-8"></script>
<link href="CssFiles/layer.css" type="text/css" rel="stylesheet"/>
<link href="CssFiles/layui.css" type="text/css" rel="stylesheet"/>
<%
	String identifier = request.getParameter("identifier");
	StudentOperate studentOperate = new StudentOperate();
	studentOperate.createStudentDao();
	List<Student> ls = studentOperate.getStudentByIdentifier(identifier);
	DateFormat dateFormat = DateFormat.getDateInstance();
%>
<script>
var classIdentifier = '<%= ls.get(0).getClass_Identifier()%>';
var sex = '<%= ls.get(0).getSex()%>';
layui.use(['laydate','layedit'],function()
{
	var form = layui.form();
	$.ajax(
	{
		type : "post",
		url : "classInfoReadyAction",
		dataType : "text",
		success:function(data)
		{
			$("#class_Identifier").empty();
			var obj = eval("(" + data + ")");
			for(var i = 0;i < obj.length;i++)
			{
				$("#class_Identifier").append("<option value='"
				 + obj[i].identifier + "'>" + obj[i].name + "</option>");
			}
			$("#class_Identifier").children("option").each(function()
			{
				if($(this).val() == classIdentifier)
				{
					$(this).attr("selected",true);
				}
			});
			$("input:radio").each(function()
			{
				if($(this).val() == sex)
				{
					$(this).attr("checked",true);
				}
			});
			form.render();
		}
	});
});
$(document).ready(function()
{
	var index = parent.layer.getFrameIndex(window.name);
	$("#confirm").click(function()
	{
		parent.layer.close(index);
	});
});
</script>
</head>
<body>
<form class="layui-form layui-form-pane" action="studentAction" method="post">
		<input type="hidden" name="type" value="revise">
		<div style="margin-left:25px;margin-top:15px">
			<label>学号：</label>
			<input type="text" name="student.identifier" class="layui-input" value='<%= ls.get(0).getIdentifier()%>'
			 style="width:300px;height:38px;display:inline-block;" readonly="readonly">
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>班级：</label>
			<div class="layui-input-inline" style="width:300px;">
			<select id="class_Identifier" name="student.class_Identifier" style="height:38px;">
		        <!-- <option value="140501">信1405-1班</option> -->
		        <option></option>
	        </select>
	        </div>
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>姓名：</label>
			<input type="text" name="student.name" class="layui-input" value='<%= ls.get(0).getName()%>'
			 style="width:300px;height:38px;display:inline-block;" >
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>生日：</label>
			<input type="text" name="student.birth" id="date" class="layui-input" value='<%= dateFormat.format(ls.get(0).getBirth())%>'
			 style="width:300px;height:38px;display:inline-block;"onclick="layui.laydate({elem:this})">
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>性别：</label>
			<div class="layui-input-inline" style="margin-top:-6px;">
			<input type="radio" id="man" name="student.sex" value="男" title="男"
			 style="vertical-align:text-bottom;margin-bottom:-3px;margin-right:-30px;margin-left:8px;display:inline-block;">
			<input type="radio" id="woman" name="student.sex" value="女" title="女"
			 style="vertical-align:text-bottom;margin-bottom:-3px;margin-right:-30px;margin-left:8px;display:inline-block;">
			 </div>
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>电话：</label>
			<input type="text" name="student.phone" class="layui-input" value='<%= ls.get(0).getPhone()%>'
			 style="width:300px;height:38px;display:inline-block;">
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>住址：</label>
			<div class="layui-input-inline" style="width:145px;">
			<select name="addressPrefix" style="height:38px;">
		        <option value="河北省">河北省</option>
	        </select>
	        </div>
	        <div class="layui-input-inline" style="margin-left:6px;width:145px;">
	        <select name="addressSuffix" style="height:38px;">
		        <option value="秦皇岛市">秦皇岛市</option>
	        </select>
	        </div>
		</div>
		<div>
			<button type="submit" id="confirm"
				class="layui-btn layui-btn-small layui-btn-normal"
				style="width:70px;margin-top:30px;margin-left:172px;">确定</button>
		</div>
	</form>
</body>
</html>
