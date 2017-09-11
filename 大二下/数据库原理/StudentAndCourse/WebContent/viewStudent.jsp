<%@ page language = "java" import = "java.sql.*" pageEncoding = "UTF-8"%>
<%@ page errorPage = "error.jsp"%>
<html>
<head>
<title>查看学生</title>
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
	<div>
		<a href = index.jsp>返回主页</a>
	</div>
	<p>
	<table>
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>专业</th>
			<th>分数</th>
		</tr>
		<%
			String Cno = request.getParameter("Cno");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
			Statement stmt = con.createStatement();
			String s = "select SC.Sno,Sname,Sdept,Grade from Student Join SC On SC.Sno = Student.Sno Where Cno = '" + Cno + "'";
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next())
			{
				out.println("<tr><td>" + rs.getString(1) + 
						"</td><td>" + rs.getString(2) + 
						"</td><td>" + rs.getString(3) + 
						"</td><td>" + rs.getString(4));
			}
			rs.close();
			stmt.close();
			con.close();
		%>
	</table>
</body>
</html>