<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>修改成功</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String Sno = request.getParameter("Sno");
		String Sname = request.getParameter("Sname");
		String Ssex = request.getParameter("Ssex");
		String Sage = request.getParameter("Sage");
		String Sdept = request.getParameter("Sdept");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
		Statement stmt = con.createStatement();
		String sql = "update Student set Sname = '" + Sname + "',Ssex = '" + Ssex + "',Sage = '" + Sage + "',Sdept = '" + Sdept + "' where Sno = " + Sno;
		int i = stmt.executeUpdate(sql);
		if (i == 1)
		{
			out.println("<script language='javaScript'> alert('修改成功，点击确定后自动跳到主页。');</script>");
			response.setHeader("refresh", "1;url=studentDisplay.jsp");
		}
		stmt.close();
		con.close();
	%>
</body>
</html>
