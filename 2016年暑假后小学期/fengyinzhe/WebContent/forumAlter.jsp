<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>吐槽区</title>
<%
request.setCharacterEncoding("UTF-8");
String num = request.getParameter("num");
String user = request.getParameter("user");
%>
<style type="text/css">
#apDiv0
{
	position: absolute;
	width: 1100px;
	height: 270px;
	left: 110px;
	z-index: 1;
}
#apDiv1
{
	position: absolute;
	width: 200px;
	height: 800px;
	left: 110px;
	top: 289px;
	z-index: 1;
}
#apDiv2
{
	position: absolute;
	width: 700px;
	height: 800px;
	z-index: 2;
	left: 355px;
	top: 289px;
}
#apDiv3
{
	position: absolute;
	width: 129px;
	height: 800px;
	z-index: 1;
	left: 1061px;
	top: 288px;
}
</style>
</head>
<body>
<div id="apDiv0">
<table width="1100" height="270" border="1">
  <tr>
    <td width="1100" height="270"><a href="index.jsp?user=<%= user%>"><img src="image/fengyinzhe.jpg" width="1100" height="270" alt="fengyinzhe1" /></a></td>
  </tr>
</table></div>
<div id="apDiv1">
	<table width="200" height="800" border="1">
		<tr>
			<td width="200" height="800"><img src="image/leibiya.jpg" width="233" height="800" alt="leibiya"/></td>
		</tr>
	</table>
</div>
<div id="apDiv2">
	<jsp:useBean id = "db" class = "bean.Fengyinzhe_Connect" scope = "page" />
	<%
		String selectSQL = "Select * From Forum Where num = '" + num + "'";
		ResultSet rs = db.executeQuery(selectSQL);
		rs.next();
	%>
	<form action="forumUpdate.jsp" method="post">
	<textarea name="comment" cols="85" rows="9"><%out.print(rs.getString(4)); %></textarea>
	<input type = "hidden" name = "num" value = <%= num%>>
	<input type = "hidden" name = "user" value = <%= user%>>
	<input type="submit" value="保存">
	</form>
</div>

<div id="apDiv3">
  <table width="158" height="50" border="1">
    <tr>
     <td height="50" align="center">
    <input type="button" value="返回" onclick="window.location.href='forumManage.jsp?user=<%= user%>'" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
</div>
</body>
</html>