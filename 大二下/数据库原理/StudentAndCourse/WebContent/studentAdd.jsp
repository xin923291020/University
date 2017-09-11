<%@ page contentType = "text/html; charset=UTF-8" import = "java.sql.*" errorPage = "error.jsp" %>
<html>
<head>
<title>添加学生信息</title>
<style type = "text/css">
table
{
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 400px;
}
th,td
{
	border: solid #333 1px;
	height: 20px;
}
div
{
	text-align: center;
}
</style>
</head>
<body>

<form action = "studentAdd.jsp" method = "post">
<table>
<caption>添加学生信息</caption>
  <tr>
    <th width = "30%">学号：</th>
    <td width = "70%"><input name = "Sno" type = "text"></td>
  </tr>
  <tr>
    <th>姓名：</th>
    <td><input name = "Sname" type = "text"></td>
  </tr>
  <tr>
    <th>性别：</th>
    <td><input name = "Ssex" type = "text"></td>
  </tr>
   <tr>
    <th>年龄：</th>
    <td><input name = "Sage" type = "text"></td>
  </tr>
  <tr>
    <th>专业：</th>
    <td><input name = "Sdept" type = "text"></td>
  </tr>
  <tr>
    <th colspan = "2">
    <input type = "submit" name = "submit" value = "添加">
    <input type = "reset"  value = "重置">
    </th>
  </tr>
</table>
</form>
<%
request.setCharacterEncoding("UTF-8");
String submit = request.getParameter("submit");
if(submit != null && !submit.equals(""))
{
	String  Sno = request.getParameter("Sno");
	String  Sname = request.getParameter("Sname");
	String  Ssex = request.getParameter("Ssex");
	String  Sage = request.getParameter("Sage");
	String  Sdept = request.getParameter("Sdept");
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
	Statement stmt = con.createStatement();
	String sql = "insert into Student values('" + Sno + "','" + Sname + "','" + Ssex + "','" + Sage + "','" + Sdept + "')";
	int i = stmt.executeUpdate(sql);
	//System.out.println(sql);
	if(i == 1)
	{
		out.println("<script language = 'javaScript'> alert('添加成功,点击确定跳转到主页!');</script>");
		response.setHeader("refresh","1;url = studentDisplay.jsp");
	}
	else
	{
		out.println("<script language = 'javaScript'> alert('添加失败，点击确定返回添加页面！');</script>");
		response.setHeader("refresh","1;url = studentAdd.jsp");
	}
	stmt.close();
	con.close();
}
%>
</body>
</html>