<%@ page language = "java" import = "java.sql.*" pageEncoding = "UTF-8"%>
<%@ page errorPage = "error.jsp"%>
<html>
<head>
<title>全部课程</title>
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
</head>
<body>
	<div>
		<a href = index.jsp>返回主页</a>
	</div>
	<p>
	<table>
		<tr>
			<th>课程号</th>
			<th>课程名</th>
			<th>学分</th>
			<th>学期</th>
			<th>管理</th>
		</tr>
		<%
			String Sno = request.getParameter("Sno");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
			Statement stmt = con.createStatement();
			String s = "select * from Course";
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next())
			{
				String Cno = rs.getString(1);
				out.println("<tr><td>" + rs.getString(1) + 
						"</td><td>" + rs.getString(2) + 
						"</td><td>" + rs.getString(3) + 
						"</td><td>" + rs.getString(4) + 
						"</td><td><a href = 'takeCourse.jsp?Cno=" + Cno + "&Sno=" + Sno
						+ "'>选课</a>&nbsp;");
			}
			rs.close();
			stmt.close();
			con.close();
		%>
	</table>
</body>
</html>