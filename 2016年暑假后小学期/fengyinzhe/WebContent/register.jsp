<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>注册</title>
</head>
<body>
	<jsp:useBean id = "db" class = "bean.Fengyinzhe_Connect" scope = "page" />
	<%
		request.setCharacterEncoding("UTF-8");
		byte[] userByte = request.getParameter("user").getBytes("ISO-8859-1");
		String user = new String(userByte,"utf-8");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String selectSQL = "Select fengyinzhe_User From Account";
		ResultSet rs = db.executeQuery(selectSQL);
		boolean existFlag = true;
		while(rs.next())
		{
			if(user.equals(rs.getString(1)))
			{
				existFlag = false;
				out.println("<script language='javaScript'> alert('用户名已存在，注册失败。');</script>");
				response.setHeader("refresh", "0;url=index.jsp");
			}
		}
		if(existFlag)
		{
			if(!password.equals(""))
			{
				if(confirmPassword.equals(password))
				{
					String InsertSQL = "Insert Into Account Values('" + user + "','" + password + "')";
					int i = db.executeUpdate(InsertSQL);
					if (i == 1)
					{
						String InsertSQL1 = "Insert Into Infomation Values('" + user + "',' ',' ',' ',' ',' ',' ',' ')";
						int j = db.executeUpdate(InsertSQL1);
						if(j == 1)
						{
							out.println("<script language='javaScript'> alert('注册成功，点击确定回到登陆页面。');</script>");
							response.setHeader("refresh", "0;url=index.jsp");
						}
					}
				}
				else
				{
					out.println("<script language='javaScript'> alert('密码不一致，注册失败。');</script>");
					response.setHeader("refresh", "0;url=index.jsp");
				}
			}
			else
			{
				out.println("<script language='javaScript'> alert('密码为空，注册失败。');</script>");
				response.setHeader("refresh", "0;url=index.jsp");
			}
		}
		db.close();
	%>
</body>
</html>
