<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>选课成功</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String Cno = request.getParameter("Cno");
		String Sno = request.getParameter("Sno");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
		Statement stmt = con.createStatement();
		String sql = "Insert Into SC Values ('" + Sno + "','" + Cno + "','0','1234')";
		int i = stmt.executeUpdate(sql);
		if (i == 1)
		{
			out.println("<script language='javaScript'> alert('选课成功，点击确定后自动跳到主页。');</script>");
			response.setHeader("refresh", "1;url=index.jsp");
		}
		else
		{
			out.println("<script language='javaScript'> alert('选课成功，点击确定后自动跳到选课页面。');</script>");
			response.setHeader("refresh", "1;url=chooseCourse.jsp");
		}
		stmt.close();
		con.close();
	%>
</body>
</html>
