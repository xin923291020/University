<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>修改课程信息</title>
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
	<%
		request.setCharacterEncoding("gb2312");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
		Statement stmt = con.createStatement();
		String Cno = request.getParameter("Cno");
		ResultSet rs = stmt.executeQuery("select * from Course where Cno = " + Cno);
		rs.next();
	%>
	<form action = "courseUpdate.jsp" method = "post">
		<table>
			<caption>修改课程信息</caption>
			<tr>
				<th width = "30%">课程名：</th>
				<td width = "70%"><input name = "Cname" type = "text"
					value = "<%= rs.getString(2)%>"></td>
			</tr>
			<tr>
				<th>学分：</th>
				<td><input name = "Ccredit" type = "text"
					value = "<%= rs.getString(3)%>"></td>
			</tr>
			<tr>
				<th>学期：</th>
				<td><input name = "Semester" type = "text"
					value = "<%= rs.getString(4)%>"></td>
			</tr>
			<tr>
				<th colspan = "2"><input type = "hidden" name = "Cno" value = "<%= Cno%>">
					<input type = "submit" value = "修改"> <input type = "reset" value = "重置"></th>
			</tr>
		</table>
	</form>
	<%
		rs.close();
		stmt.close();
		con.close();
	%>
</body>
</html>