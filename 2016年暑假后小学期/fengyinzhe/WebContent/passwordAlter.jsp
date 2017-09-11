<%@ page import = "java.sql.*" pageEncoding = "UTF-8" errorPage = "error.jsp"%>
<html>
<head>
<title>修改密码</title>
</head>
<body>
	<jsp:useBean id = "db" class = "bean.Fengyinzhe_Connect" scope = "page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		if(!password.endsWith(confirmPassword))
		{
			out.println("<script language='javaScript'> alert('密码不一致。');</script>");
			response.setHeader("refresh", "0;url=index.jsp");
		}
		else
		{
		String selectSQL_1 = "Select fengyinzhe_User From Account";
		ResultSet rs_1 = db.executeQuery(selectSQL_1);
		boolean existFlag = false;
		while(rs_1.next())
		{
			if(user.equals(rs_1.getString(1)))
			{
				existFlag = true;
				break;
			}
		}
		String selectSQL_2 = "Select phone From Infomation Where fengyinzhe_User = '" + user + "'";
		ResultSet rs_2 = db.executeQuery(selectSQL_2);
		if(existFlag)
		{
			rs_2.next();
			if(phone.equals(rs_2.getString(1)))
			{
				String updateSQL = "Update Account Set fengyinzhe_Password = '" + password + "' Where fengyinzhe_User = '" + user + "'";
				int i = db.executeUpdate(updateSQL);
				if (i == 1)
				{
					out.println("<script language='javaScript'> alert('修改成功。');</script>");
					response.setHeader("refresh", "0;url=index.jsp");
				}
			}
			else
			{
				out.println("<script language='javaScript'> alert('手机号不正确，请重新输入。');</script>");
				response.setHeader("refresh", "0;url=index.jsp");
			}
		}
		else
		{
			out.println("<script language='javaScript'> alert('用户名不存在，请重新输入。');</script>");
			response.setHeader("refresh", "0;url=index.jsp");
		}}
		db.close();
	%>
</body>
</html>
