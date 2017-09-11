<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心</title>
  	<jsp:useBean id = "db" class = "bean.Fengyinzhe_Connect" scope = "page" />
	<%
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String selectSQL = "Select * From Infomation Where fengyinzhe_User = '" + user + "'";
		ResultSet rs = db.executeQuery(selectSQL);
		rs.next();
	%>
	<script type="text/javascript">
function ShopConfirm(str)
{ 
	var ShopConfirmLayer=document.getElementById(str); 
	var webBgLayer=document.getElementById("webBgLayer");
	ShopConfirmLayer.style.display="";//显示内容层，显示覆盖层

	ShopConfirmLayer.style.left=parseInt((document.documentElement.scrollWidth-ShopConfirmLayer.offsetWidth)/2)+document.documentElement.scrollLeft+"px"; 
	ShopConfirmLayer.style.top=Math.abs(parseInt((document.documentElement.clientHeight-ShopConfirmLayer.offsetHeight)/2))+document.documentElement.scrollTop+"px"; //为内容层设置位置
	webBgLayer.style.display=""; 
	webBgLayer.style.height=document.documentElement.scrollHeight+"px"; //为覆盖层设置高度 
} 
function CloseShopConfirm(ids)
{ 
	var ShopConfirmLayer=document.getElementById(ids); 
	var webBgLayer=document.getElementById("webBgLayer"); 
	ShopConfirmLayer.style.display="none"; 
	webBgLayer.style.display="none"; 
} 
function hide(id)
{
	var ids=document.getElementById(id);
	ids.style.display='none';
}
</script>
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
#apDiv4 {
	position: absolute;
	width: 398px;
	height: 354px;
	z-index: 1;
	left: 150px;
	top: 40px;
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
  <table width="706" height="808" border="1">
    <tr>
      <td>
      
  <div id="apDiv4">
    <table width="396" height="352" border="1">
      <tr>
        <td width="100" align="center"><label>姓名</label></td>
        <td width="280" align="center"><label><%out.print(rs.getString(2));%></label>&nbsp;</td>
      </tr>
      <tr>
        <td width="100" align="center">性别</td>
        <td width="280" align="center"><label><%out.print(rs.getString(3));%></label>&nbsp;</td>
      </tr>
      <tr>
        <td width="100" align="center"><label>年龄</label></td>
        <td width="280" align="center"><label><%out.print(rs.getString(4));%></label>&nbsp;</td>
      </tr>
      <tr>
        <td width="100" align="center">手机号</td>
        <td width="280" align="center"><label><%out.print(rs.getString(5));%></label>&nbsp;</td>
      </tr>
      <tr>
        <td width="100" align="center"><label>邮箱</label></td>
        <td width="280" align="center"><label><%out.print(rs.getString(6));%></label>&nbsp;</td>
      </tr>
      <tr>
        <td width="100" align="center"><label>游戏大区</label></td>
        <td width="280" align="center"><label><%out.print(rs.getString(7));%></label>&nbsp;</td>
      </tr>
      <tr>
        <td width="100" align="center"><label>角色</label></td>
        <td width="280" align="center"><label><%out.print(rs.getString(8));%></label>&nbsp;</td>
      </tr>
    </table>
  </div>
      </td>
    </tr>
  </table>
</div>
<div id="apDiv3">
	<table width="158" height="50" border="1">
    <tr>
     <td height="50" align="center">
    <input type="button" value="修改信息" onclick="window.location.href='infomationAlter.jsp?user=<%= user%>'" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
  <table width="158" height="50" border="1">
    <tr>
     <td height="50" align="center">
    <input type="button" value="修改密码" onclick="ShopConfirm('img1')" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
  <table width="158" height="50" border="1">
    <tr>
     <td height="50" align="center">
    <input type="button" value="返回" onclick="window.location.href='index.jsp?user=<%= user%>'" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
</div>
<div id="img1" style="position: absolute; top: 200px; left: 400px; background: #FFF; font-size: 14px; z-index: 900; border: 2px #FFCC00 solid; width: 260px; height: 400px; padding: 9px;"> 
    <div style="width:250px;text-align:right;">
	    <div style=" color:#080808; font-weight:bold;font-size:15px;cursor:hand;"onclick="CloseShopConfirm('img1')">关闭</div>
    </div>
    <form action="passwordAlter.jsp" method="post" name="aaa">
    <table width="350" height="170" border="0">
          <tr>
            <td width="214"><br>
    		账号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="text" name="user" style="width:160px;height:20px;"><br><br>
    		手机&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="text" name="phone" style="width:160px;height:20px;"><br><br>
    		密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="password" name="password" style="width:160px;height:20px;"><br><br>
    		确认密码&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="password" name="confirmPassword" style="width:160px;height:20px;"><br><br>
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="submit" value="确认" style="width:60px"><br><br></td>
          </tr>
      </table>
  	</form>
</div>
<script language="javascript">hide('img1');</script>
<div id="webBgLayer" style="position:absolute;top:0px;left:0px;z-index:899;height:100%;width:100%;display:none;-moz-opacity:0.5;filter:alpha(opacity=50);"></div>
</body>
</html>