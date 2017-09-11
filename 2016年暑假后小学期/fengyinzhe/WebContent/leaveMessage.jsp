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
		String time = request.getParameter("time");
		byte[] messageByte = request.getParameter("message").getBytes("ISO-8859-1");
		String message = new String(messageByte,"utf-8");
		String SQL = "Insert Into message Values('" + num + "','" + user + "','" + time + "','" + message + "')";
		int i = db.executeUpdate(SQL);
		if(i == 1)
		{
			out.println("<script language='javaScript'> alert('评论成功');</script>");
			response.setHeader("refresh", "0;url=message.jsp?user=" + user + "&num=" + num);
		}
		else
		{
			out.println("<script language='javaScript'> alert('评论失败');</script>");
			response.setHeader("refresh", "0;url=message.jsp?user=" + user + "&num=" + num);
		}
	%>
</body>
</html>