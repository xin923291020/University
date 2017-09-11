<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>更改学生成绩</title>
</head>
<style type = "text/css">
table
{
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 400px;
}
th,td
{
	border: solid #333 1px;
	height: 20px;
}
div
{
	text-align: center;
}
</style>
<body>
	<div>
		<a href = index.jsp>返回主页</a>
	</div>
	<form action = "gradeUpdate.jsp" method = "post">
		<table>
			<tr>
				<th width = "30%">学号：</th>
				<td width = "70%"><input name = "Sno" type = "text"></td>
			</tr>
			<tr>
				<th width = "30%">课程号：</th>
				<td width = "70%"><input name = "Cno" type = "text"></td>
			</tr>
			<tr>
				<th width = "30%">成绩：</th>
				<td width = "70%"><input name = "Grade" type = "text"></td>
			</tr>
			<tr>
				<th colspan = "2"><input type = "hidden" name = "Cno">
					<input type = "submit" value = "确认"> <input type = "reset" value = "重置"></th>
			</tr>
		</table>
	</form>
</body>
</html>