<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>吐槽区</title>
<jsp:useBean id = "time" class = "bean.Time" scope = "page" />
<%
request.setCharacterEncoding("UTF-8");
byte[] userByte = request.getParameter("user").getBytes("ISO-8859-1");
String user = new String(userByte,"utf-8");
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
function CommentSubmit()
{
	var user  = '<%= user %>';
	var time  = '<%= time.GetTime() %>';
	var comment  = content.comment.value;
	if(user=="null")
	{
		alert("请先登录。");
	}
	else
	{
		window.location.href = "forumSubmit.jsp?user=" + user + "&time=" + time + "&comment=" + comment;
	}
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
		String selectSQL = "Select * From Forum Order By time DESC";
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
          		  <input type="button" name="comment" onclick="window.location.href='message.jsp?num=<%= num%>&user=<%= user%>'"  value="查看评论" /></form></td>
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
    <input type="button" value="发布帖子" onclick="ShopConfirm('img1')" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
  <table width="158" height="50" border="1">
    <tr>
     <td height="50" align="center">
    <input type="button" value="管理我的帖子" onclick="window.location.href='forumManage.jsp?user=<%= user%>'" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
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
<div id="img1" style="position: absolute; top: 200px; left: 400px; background: #FFF; font-size: 14px; z-index: 900; border: 2px #FFCC00 solid; width: 350px; height: 180px; padding: 9px;"> 
  <div style="width:350px;text-align:right;">
    <div style=" color:#080808; font-weight:bold;font-size:15px;cursor:hand;"onclick="CloseShopConfirm('img1')">关闭</div>
  <div id="apDiv7" style="position: absolute;width: 349px;height: 150px;z-index: 901;">
    <form name="content">
      <textarea name="comment" cols="40" rows="9"></textarea>
    </form>
  </div>
  <div id="apDiv8" style="position: absolute;width: 347px;height: 21px;z-index: 901;left: 12px;top: 170px;">
      <input type="button" name="submit" onclick="CommentSubmit()"value="发表" />
  </div>
  </div>
   	
</div>
<script language="javascript">hide('img1');</script>
</body>
</html>