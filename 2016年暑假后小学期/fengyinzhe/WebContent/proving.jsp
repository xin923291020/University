<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>登陆</title>
</head>
<body>
	<jsp:useBean id = "db" class = "bean.Fengyinzhe_Connect" scope = "page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
			String SQL = "Select * From Account";
			ResultSet rs = db.executeQuery(SQL);
			boolean userFlag = false;
			boolean pwFlag = false;
			while(rs.next())
			{
				if(user.equals(rs.getString(1)))
				{
					userFlag = true;
					if(password.equals(rs.getString(2)))
					{
						pwFlag = true;
						response.setHeader("refresh", "0;url = index.jsp?user=" + user);
						break;
					}
				}
			}
			if(!userFlag)
			{
				out.println("<script language='javaScript'> alert('用户不存在，请注册');</script>");
				response.setHeader("refresh", "0;url = index.jsp");
			}
			else if(!pwFlag)
			{
				out.println("<script language='javaScript'> alert('密码错误');</script>");
				response.setHeader("refresh", "0;url = index.jsp");
			}
		db.close();
	%>
</body>
</html>
