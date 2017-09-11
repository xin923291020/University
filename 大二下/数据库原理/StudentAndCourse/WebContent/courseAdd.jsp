<%@ page contentType = "text/html; charset=UTF-8" import = "java.sql.*" errorPage = "error.jsp" %>
<html>
<head>
<title>添加课程信息</title>
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

<form action = "courseAdd.jsp" method = "post">
<table>
<caption>添加学生信息</caption>
  <tr>
    <th width = "30%">课程号：</th>
    <td width = "70%"><input name = "Cno" type = "text"></td>
  </tr>
  <tr>
    <th>课程名：</th>
    <td><input name = "Cname" type = "text"></td>
  </tr>
  <tr>
    <th>学分：</th>
    <td><input name = "Ccredit" type = "text"></td>
  </tr>
   <tr>
    <th>学期：</th>
    <td><input name = "Semester" type = "text"></td>
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
	String  Cno = request.getParameter("Cno");
	String  Cname = request.getParameter("Cname");
	String  Ccredit = request.getParameter("Ccredit");
	String  Semester = request.getParameter("Semester");
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = students","sa","19951122");
	Statement stmt = con.createStatement();
	String sql = "insert into Course values('" + Cno + "','" + Cname + "','" + Ccredit + "','" + Semester + "')";
	int i = stmt.executeUpdate(sql);
	//System.out.println(sql);
	if(i == 1)
	{
		out.println("<script language = 'javaScript'> alert('添加成功,点击确定跳转到主页!');</script>");
		response.setHeader("refresh","1;url = courseDisplay.jsp");
	}
	else
	{
		out.println("<script language = 'javaScript'> alert('添加失败，点击确定返回添加页面！');</script>");
		response.setHeader("refresh","1;url = courseAdd.jsp");
	}
	stmt.close();
	con.close();
}
%>
</body>
</html>