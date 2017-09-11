<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>修改学生信息</title>
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
		String Sno = request.getParameter("Sno");
		ResultSet rs = stmt.executeQuery("select * from Student where Sno = " + Sno);
		rs.next();
	%>
	<form action = "studentUpdate.jsp" method = "post">
		<table>
			<caption>修改学生信息</caption>
			<tr>
				<th width = "30%">姓名：</th>
				<td width = "70%"><input name = "Sname" type = "text"
					value = "<%= rs.getString(2)%>"></td>
			</tr>
			<tr>
				<th>性别：</th>
				<td><input name = "Ssex" type = "text"
					value = "<%= rs.getString(3)%>"></td>
			</tr>
			<tr>
				<th>年龄：</th>
				<td><input name = "Sage" type = "text"
					value = "<%= rs.getString(4)%>"></td>
			</tr>
			<tr>
				<th>专业：</th>
				<td><input name = "Sdept" type = "text"
					value = "<%= rs.getString(5)%>"></td>
			</tr>
			<tr>
				<th colspan = "2"><input type = "hidden" name = "Sno" value = "<%= Sno%>">
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