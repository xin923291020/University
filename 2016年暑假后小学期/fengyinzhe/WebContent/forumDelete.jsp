<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>提交成功</title>
</head>
<body>
	<jsp:useBean id = "db" class = "bean.Fengyinzhe_Connect" scope = "page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String num = request.getParameter("num");
		String SQL = "Update forum Set status = '0' Where num = '" + num + "'";
		System.out.println(SQL);
		int i = db.executeUpdate(SQL);
		if (i == 1)
		{
			out.println("<script language='javaScript'> alert('删除成功。');</script>");
			response.setHeader("refresh", "1;url=forumManage.jsp?user=" + user);
		}
		else
		{
			out.println("<script language='javaScript'> alert('删除失败');</script>");
			response.setHeader("refresh", "1;url=forumManage.jsp?user=" + user);
		}
	%>
</body>
</html>
