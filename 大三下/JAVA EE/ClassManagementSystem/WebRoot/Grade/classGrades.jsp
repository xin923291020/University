<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.GradeOperate"%>
<%@ page import="service.StudentOperate"%>
<%@ page import="model.Grade"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String course = request.getParameter("course");
	String class_Identifier = request.getParameter("class_Identifier");
	GradeOperate gradeOperate = new GradeOperate();
	gradeOperate.createGradeDao();
	gradeOperate.createStudentDao();
	StudentOperate studentOperate = new StudentOperate();
	studentOperate.createStudentDao();
	List<Grade> ls = gradeOperate.getGradesByClass(course,class_Identifier);
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
function edit(obj)
{
	obj.style.display = "none";
	obj.parentNode.childNodes[3].style.display = "block";
	var input = obj.parentNode.parentNode.parentNode.cells[2].childNodes[1].childNodes[1];
	input.readOnly = false;
	input.style.border="1px solid #E1E1E1";
}
function save(obj)
{
	obj.style.display = "none";
	obj.parentNode.childNodes[1].style.display = "block";
	var input = obj.parentNode.parentNode.parentNode.cells[2].childNodes[1].childNodes[1];
	input.readOnly = true;
	input.style.border="none";
	var identifier = obj.parentNode.parentNode.parentNode.cells[1].innerText;
	var course_identifier = $("#course").val();
	var score = input.value;
	$.ajax(
	{
		type : "post",
		url : "gradeAction?identifier=" + identifier + "&course_identifier="
			+ course_identifier + "&score=" + score,
		dataType : "text",
		success:function(message)
		{
			if(message == "success")
			{
				layer.msg("修改成功",{time:500,offset:['530px','460px']});
				refresh();
			}
		}
	});
}
$(document).ready(function()
{
	$("#editAll").click(function()
	{
		var scores = document.getElementsByName("score");
		for(var i = 0;i < scores.length;i++)
		{
			scores[i].readOnly = false;
			scores[i].style.border="1px solid #E1E1E1";
		}
		var edits = document.getElementsByName("edit");
		for(var i = 0;i < scores.length;i++)
		{
			edits[i].className = "layui-btn layui-btn-disabled";
			var style = edits[i].style;
			style.width = "45px";
			style.height = "30px";
			style.lineHeight = "11px";
			style.textIndent = "-9px";
		}
		document.getElementById("editAll").style.display = "none";
		document.getElementById("saveAll").style.display = "block";
	});
	$("#saveAll").click(function()
	{
		var course_identifier = $("#course").val();
		var tr = document.getElementById("table").childNodes[1].childNodes;
		for(var i = 2;i < tr.length;i+=2)
		{
			var identifier = tr[i].cells[1].innerText;
			var score = tr[i].cells[2].childNodes[1].childNodes[1].value;
			$.ajax(
			{
				type : "post",
				url : "gradeAction?identifier=" + identifier + "&course_identifier="
					+ course_identifier + "&score=" + score,
				dataType : "text",
				success:function(message)
				{
				}
			});
			layer.msg("修改成功",{time:500,offset:['530px','460px']});
			refresh();
		}
	});
});
</script>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top:5px;">
  		<legend>成绩查询</legend>
	</fieldset>
	<button class="layui-btn layui-btn-small layui-btn-normal" id="editAll"
	 style="margin-left:85px;">编辑全部</button>
	 <button class="layui-btn layui-btn-small layui-btn-normal" id="saveAll"
	 style="margin-left:85px;display:none">保存全部</button>
	<table id="table" class="layui-table" style="width:700px;margin-left:85px;margin-top:15px;">
		<tr>
			<td width="140px;">序号</td>
			<td width="140px;">学号</td>
			<td width="140px;">姓名</td>
			<td width="140px;">分数</td>
			<td width="140px;">操作</td>
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
					out.print(ls.get(i).getStudent());
				%>
			</td>
			<td>
				<%
					out.print(studentOperate.getNameByIdentifier(ls.get(i).getStudent()));
				%>
			</td>
			<td>
				<div style="height:25px;width:100px;margin-left:21px;">
					<input class="layui-input" type="text" readonly="readonly"
					 style="height:33px;margin-top:-7px;line-height:0px;text-indent:23px;border:none"
					 name="score" value='<%= ls.get(i).getScore()%>'>
				</div>
			</td>
			<td>
				<div style="height:25px;">
					<button class="layui-btn layui-btn-small layui-btn-normal"
					 name="edit" onclick="edit(this)" style="margin-left:-5px;">编辑</button>
					<button class="layui-btn layui-btn-small layui-btn-normal"
					 name="save" onclick="save(this) " style="margin-left:-5px;display:none">保存</button>
				</div>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>