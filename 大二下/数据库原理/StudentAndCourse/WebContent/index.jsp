<%@ page language = "java" pageEncoding = "UTF-8"%>
<%@ page errorPage = "error.jsp"%>
<html>
<head>
<title>学生课程管理系统</title>
<style type = "text/css">
table
{
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 600px;
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
</head>
<body>
<table>
	<%
		out.println("<tr><td>" + "学生" + "</td><td><a href = 'studentGetSno.jsp" + "'>查询</a>&nbsp");
		out.println("<tr><td>" + "课程" + "</td><td><a href = 'courseGetCno.jsp" + "'>查询</a>&nbsp");
		out.println("<tr><td>" + "选课" + "</td><td><a href = 'Login.jsp" + "'>进入</a>&nbsp");
		out.println("<tr><td>" + "全部学生" + "</td><td><a href = 'studentDisplay.jsp" + "'>进入</a>&nbsp");
		out.println("<tr><td>" + "全部课程" + "</td><td><a href = 'courseDisplay.jsp" + "'>进入</a>&nbsp");
		out.println("<tr><td>" + "更新成绩" + "</td><td><a href = 'inputGrade.jsp" + "'>进入</a>&nbsp");
	%>
</table>
</body>
</html>