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
<script src="JsFiles/jquery-1.9.1.js"></script>
<script src="JsFiles/layer.js"></script>
<script src="JsFiles/layui-v1.0.9_rls/layui/layui.js" charset="utf-8"></script>
<link href="CssFiles/layer.css" type="text/css" rel="stylesheet"/>
<link href="CssFiles/layui.css" type="text/css" rel="stylesheet"/>
<%
	String identifier = request.getParameter("identifier");
	CourseOperate courseOperate = new CourseOperate();
	courseOperate.createCourseDao();
	List<Course> ls = courseOperate.getCourseByIdentifier(identifier);
%>
<script>
layui.use(['laydate','layedit']);
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
<form class="layui-form layui-form-pane" action="courseAction" method="post">
		<input type="hidden" name="type" value="revise">
		<div style="margin-left:25px;margin-top:15px">
			<label>编号：</label>
			<input type="text" name="course.identifier" class="layui-input" value='<%= ls.get(0).getIdentifier() %>'
			 style="width:225px;height:38px;display:inline-block;" readonly="readonly">
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>名称：</label>
			<input type="text" name="course.name" class="layui-input" value='<%= ls.get(0).getName() %>'
			 style="width:225px;height:38px;display:inline-block;">
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>性质：</label>
			<div class="layui-input-inline" style="margin-left:0px;width:225px;">
			<select name="course.property" style="height:38px;">
		        <option value="必修">必修</option>
		        <option value="选修">选修</option>
		        <option value="专业">专业</option>
		        <option value="限选">限选</option>
	        </select>
	        </div>
		</div>
		<div style="margin-left:25px;margin-top:8px">
			<label>学分：</label>
			<div class="layui-input-inline" style="margin-left:0px;width:225px;">
			<select name="course.credit" style="height:38px;">
		        <option value="1">1分</option>
		        <option value="2">2分</option>
		        <option value="3">3分</option>
		        <option value="4">4分</option>
	        </select>
	        </div>
		</div>
		<div>
			<button type="submit" id="confirm"
				class="layui-btn layui-btn-small layui-btn-normal"
				style="width:70px;margin-top:30px;margin-left:135px;">确定</button>
		</div>
	</form>
</body>
</html>
