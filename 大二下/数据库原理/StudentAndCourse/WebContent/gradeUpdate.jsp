<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>修改成功</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String Sno = request.getParameter("Sno");
		String Cno = request.getParameter("Cno");
		String Grade = request.getParameter("Grade");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
		Statement stmt = con.createStatement();
		String sql = "Update SC Set Grade = '" + Grade + "' Where Sno = " + Sno + " And Cno = '" + Cno + "'";
		int i = stmt.executeUpdate(sql);
		if (i == 1)
		{
			out.println("<script language='javaScript'> alert('修改成功，点击确定后继续修改。');</script>");
			response.setHeader("refresh", "1;url=inputGrade.jsp");
		}
		stmt.close();
		con.close();
	%>
</body>
</html>
