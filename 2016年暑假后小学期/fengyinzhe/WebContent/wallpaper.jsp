<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>精美壁纸</title>
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
#apDiv3
{
	position: absolute;
	width: 129px;
	height: 800px;
	z-index: 1;
	left: 1190px;
	top: 288px;
}
.ziti{font-size:12px;color:#00F}
.biaoti1{font-size:16px}
.biaoti2{font-size:20px}
</style>
</head>
<body>
<div id="apDiv0">
<table width="1100" height="270" border="1">
  <tr>
    <td width="1138" height="270"><a href="index.jsp?user=<%= user%>"><img src="image/fengyinzhe.jpg" width="1100" height="270" alt="fengyinzhe1" /></a></td>
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
  <table width="864" height="485" border="1">
    <tr>
      <td width="274" height="156"><img src="image/wallpaper1.jpg" width="274" height="152" alt="wallpaper1" /></td>
      <td width="274"><img src="image/wallpaper2.jpg" width="274" height="152" alt="wallpaper2" /></td>
      <td width="270"><img src="image/wallpaper3.jpg" width="274" height="152" alt="wallpaper3" /></td>
    </tr>
    <tr>
      <td height="156"><img src="image/wallpaper4.jpg" width="274" height="152" alt="wallpaper4" /></td>
      <td><img src="image/wallpaper5.jpg" width="274" height="152" alt="wallpaper5" /></td>
      <td><img src="image/wallpaper6.jpg" width="274" height="152" alt="wallpaper6" /></td>
    </tr>
    <tr>
      <td height="156"><img src="image/wallpaper7.jpg" width="274" height="152" alt="wallpaper7" /></td>
      <td><img src="image/wallpaper8.jpg" width="274" height="152" alt="wallpaper8" /></td>
      <td><img src="image/wallpaper9.jpg" width="274" height="152" alt="wallpaper9" /></td>
    </tr>
  </table>
</div>
</body>
</html>