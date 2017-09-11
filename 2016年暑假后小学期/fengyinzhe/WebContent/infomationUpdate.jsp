<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>提交成功</title>
</head>
<body>
	<jsp:useBean id = "db" class = "bean.Fengyinzhe_Connect" scope = "page" />
	<%
		byte[] userByte = request.getParameter("user").getBytes("ISO-8859-1");
		String user = new String(userByte,"utf-8");
		byte[] nameByte = request.getParameter("name").getBytes("ISO-8859-1");
		String name = new String(nameByte,"utf-8");
		String age = request.getParameter("age");
		byte[] sexByte = request.getParameter("sex").getBytes("ISO-8859-1");
		String sex = new String(sexByte,"utf-8");
		String phone = request.getParameter("phone");
		String emailAddress = request.getParameter("emailAddress");
		byte[] serverNameByte = request.getParameter("serverName").getBytes("ISO-8859-1");
		String serverName = new String(serverNameByte,"utf-8");
		byte[] roleByte = request.getParameter("role").getBytes("ISO-8859-1");
		String role = new String(roleByte,"utf-8");
		String SQL = "Update Infomation Set name = '" + name + "' ,age = '" + age + "' ,sex = '" + sex
				 + "' ,phone = '" + phone + "' ,email_Address = '" + emailAddress + "' ,serverName = '" + serverName
				 + "' ,role = '" + role + "' Where fengyinzhe_User = '" + user + "'";
		int i = db.executeUpdate(SQL);
		if (i == 1)
		{
			out.println("<script language='javaScript'> alert('修改成功。');</script>");
			response.setHeader("refresh", "0;url=personalCenter.jsp?user=" + user);
		}
		else
		{
			out.println("<script language='javaScript'> alert('修改失败');</script>");
			response.setHeader("refresh", "0;url=personalCenter.jsp?user=" + user);
		}
	%>
</body>
</html>
