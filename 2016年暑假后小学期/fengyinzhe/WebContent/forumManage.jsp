<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>吐槽区</title>
<%
request.setCharacterEncoding("UTF-8");
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

#apDiv3 {
	position: absolute;
	width: 165px;
	height: 800px;
	z-index: 3;
	left: 1062px;
	top: 291px;
}
.AutoNewline 
{ 
  Word-break: break-all;
  width :50px;
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
		String selectSQL = "Select * From Forum Where fengyinzhe_User = '" + user + "' Order By time DESC";
		ResultSet rs = db.executeQuery(selectSQL);
	    while(rs.next())
		{
	    	int num = rs.getInt(1);
	    	if(rs.getInt(5) == 1)
	    	{
	%>
  		<table width="700" height="100" border="0" style="margin-top:1px;border:1px solid #000000;table-layout:fixed;"cellpadding="0"cellspacing="0">
    	<tr>
      		<td width="100"><%out.print(rs.getString(2));%></td>
      		<td width="605"><table width="603" height="94" border="0" style="margin-top:0px;border:1px solid #000000;table-layout:fixed;"cellpadding="0"cellspacing="0">
        	<tr>
          		<td class="AutoNewline"><p style="margin-top:0px;">&nbsp;&nbsp;<%out.print(rs.getString(4));%></p></td>
        	</tr>
        	<tr>
          		<td height="20" align="right">
          		<form name="comment"><%out.print(rs.getString(3)); %>&nbsp;
          		  <input type="button" name="comment" onclick="window.location.href='forumAlter.jsp?num=<%= num%>&user=<%= user%>'"  value="修改" />
          		  <input type="button" name="comment" onclick="window.location.href='forumDelete.jsp?num=<%= num%>&user=<%= user%>'"  value="删除" /></form></td>
        	</tr></table>
        	</td>
    	</tr>
  		</table>
    <%
	    	}
		}
    %>
</div>
<div id="apDiv3">
  <table width="158" height="50" border="1">
    <tr>
     <td height="50" align="center">
    <input type="button" value="返回" onclick="window.location.href='forum.jsp?user=<%= user%>'" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
</div>
</body>
</html>