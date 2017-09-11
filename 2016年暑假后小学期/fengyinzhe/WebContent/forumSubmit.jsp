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
		String time = request.getParameter("time");
		byte[] commentByte = request.getParameter("comment").getBytes("ISO-8859-1");
		String comment = new String(commentByte,"utf-8");
		String SQL = "Insert Into Forum(fengyinzhe_User,time,content,status) Values('" + user + "','" + time + "','" + comment + "','1')";
		int i = db.executeUpdate(SQL);
		if(i == 1)
		{
			out.println("<script language='javaScript'> alert('发表成功');</script>");
			response.setHeader("refresh", "0;url=forum.jsp?user=" + user);
		}
		else
		{
			out.println("<script language='javaScript'> alert('发表失败');</script>");
			response.setHeader("refresh", "0;url=forum.jsp?user=" + user);
		}
	%>
</body>
</html>