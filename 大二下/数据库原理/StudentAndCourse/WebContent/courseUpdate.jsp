<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>修改成功</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String Cno = request.getParameter("Cno");
		String Cname = request.getParameter("Cname");
		String Ccredit = request.getParameter("Ccredit");
		String Ssemester = request.getParameter("Semester");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
		Statement stmt = con.createStatement();
		String sql = "update Course set Cname = '" + Cname + "',Ccredit = '" + Ccredit + "',Semester = '" + Ssemester + "' where Cno = " + Cno;
		
		int i = stmt.executeUpdate(sql);
		if (i == 1)
		{
			out.println("<script language='javaScript'> alert('修改成功，点击确定后自动跳到主页。');</script>");
			response.setHeader("refresh", "1;url=courseDisplay.jsp");
		}
		stmt.close();
		con.close();
	%>
</body>
</html>
