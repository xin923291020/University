<%@ page contentType = "text/html; charset = gb2312" language = "java" import = "java.sql.*" pageEncoding = "gb2312"%>
<html>
  <head>
    <title>删除学生信息</title>
  </head>
  <body>
	<%
	request.setCharacterEncoding("gb2312");
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
	Statement stmt = con.createStatement();
	String Sno = request.getParameter("Sno");
	int i = stmt.executeUpdate("delete from Student where Sno = " + Sno);
	if(i == 1)
	{
		out.println("<script language = 'javaScript'> alert('删除成功，点击确定后自动跳到主页！');</script>");
		response.setHeader("refresh","1;url = studentDisplay.jsp");
	}
	else
	{
		out.println("<script language = 'javaScript'> alert('删除失败，点击确定后自动跳到主页！');</script>");
		response.setHeader("refresh","1;url = studentDisplay.jsp");
	}
	con.close();
	stmt.close();
	%>
  </body>
</html>