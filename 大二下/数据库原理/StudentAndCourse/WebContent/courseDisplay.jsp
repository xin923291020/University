<%@ page language = "java" import = "java.sql.*" pageEncoding = "UTF-8"%>
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
	<div>
		<a href = courseAdd.jsp>添加课程信息    </a><a href = index.jsp>返回主页</a>
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
						"</td><td><a href = 'courseEdit.jsp?Cno=" + Cno
						+ "'>修改</a>&nbsp;<a href = 'courseDelete.jsp?Cno=" + Cno
						+ "'>删除</a></td></tr>");
			}
			rs.close();
			stmt.close();
			con.close();
		%>
	</table>
</body>
</html>