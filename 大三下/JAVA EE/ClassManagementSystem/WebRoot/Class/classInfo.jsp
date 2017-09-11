<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.ClassInfoOperate"%>
<%@ page import="model.ClassInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<%
	ClassInfoOperate classInfoOperate = new ClassInfoOperate();
	classInfoOperate.createClassInfoDao();
	List<ClassInfo> ls = classInfoOperate.getAllClassInfo();
	String addClassMessage = (String)session.getAttribute("addClassMessage");
	String deleteClassMessage = (String)session.getAttribute("deleteClassMessage");
%>
$(document).ready(function()
{
	var addClassMessage = '<%=addClassMessage%>';
	if(addClassMessage == "Success")
	{
		layer.msg("新增班级成功",{time:500,offset:['530px','460px']});
	}
	var deleteClassMessage = '<%=deleteClassMessage%>';
	if(deleteClassMessage == "Success")
	{
		layer.msg("删除班级成功",{time:500,offset:['530px','460px']});
	}
	$("#add").click(function()
	{
		layer.open(
		{
			title : "新增班级",
			type : 1,
			offset : ['150px','360px'],
			area : ['320px','180px'],
			shadeClose : true,
			content : $("#addDiv")
		});
	});
	$("#delete").click(function()
	{
		var radio;
		var i = 0;
		$("input:radio").each(function()
		{
			if(this.checked)
			{
				radio = this;
			}
			i++;
		});
		var number = radio.parentNode.parentNode.cells[4].innerText;
		if(number == 0)
		{
			var identifier = $("input[name='radio']:checked").val();
			$.ajax(
			{
				type : "post",
				url : "classInfoAction?type=delete&classInfo.identifier=" + identifier,
				dataType : "text",
				success:function()
				{
					location.reload();
				}
			});
		}
		else
		{
			layer.msg("班级中存在学生，不可删除",{time:500,offset:['530px','460px']});
		}
	});
});
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>班级信息管理</legend>
	</fieldset>
	<div style="margin-left:150px;margin-top:35px;width:800px;">
	<button class="layui-btn layui-btn-small layui-btn-normal" id="add">新增</button>
	<button class="layui-btn layui-btn-small layui-btn-normal" id="delete">删除</button>
	<table id="a" class="layui-table" style="margin-top:15px;">
		<tr>
			<td>选中</td>
			<td>序号</td>
			<td>编号</td>
			<td>名称</td>
			<td>人数</td>
		</tr>
		<%
			for (int i = 0; i < ls.size(); i++)
			{
		%>
		<tr id="1">
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
					out.print(ls.get(i).getName());
				%>
			</td>
			<td>
				<%
					out.print(ls.get(i).getStudents().size());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	</div>
	 <div id="addDiv" style="display:none">
	 <jsp:include page="addClass.html" />
      </div>
</body>
<%
	session.removeAttribute("addClassMessage");
	session.removeAttribute("deleteClassMessage");
%>
</html>