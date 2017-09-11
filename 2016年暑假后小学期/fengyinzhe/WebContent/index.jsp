<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>封印者</title>
<%
request.setCharacterEncoding("UTF-8");
String user = request.getParameter("user");
%>
<script type="text/javascript">
function GoIntroduction()
{
	var user  = '<%= user %>';
	if(user=="null")
	{
		alert("请先登录。");
		ShopConfirm('img1');
	}
	else
	{
		window.location.href = "introduction.jsp?user=" + user;
	}
}
function GoNewRole()
{
	var user  = '<%= user %>';
	if(user=="null")
	{
		alert("请先登录。");
		ShopConfirm('img1');
	}
	else
	{
		window.location.href = "newRole.jsp?user=" + user;
	}
}
function GoForum()
{
	var user  = '<%= user %>';
	if(user=="null")
	{
		alert("请先登录。");
		ShopConfirm('img1');
	}
	else
	{
		window.location.href = "forum.jsp?user=" + user;
	}
}
function GoWallpaper()
{
	var user  = '<%= user %>';
	if(user=="null")
	{
		alert("请先登录。");
		ShopConfirm('img1');
	}
	else
	{
		window.location.href = "wallpaper.jsp?user=" + user;
	}
}
function GoPersonalCenter()
{
	var user  = '<%= user %>';
	if(user=="null")
	{
		alert("请先登录。");
		ShopConfirm('img1');
	}
	else
	{
		window.location.href = "personalCenter.jsp?user=" + user;
	}
}
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
#apDiv3
{
	position: absolute;
	width: 129px;
	height: 800px;
	z-index: 1;
	left: 1090px;
	top: 288px;
}
.ziti{font-size:12px;color:#00F}
.biaoti1{font-size:16px}
.biaoti2{font-size:20px}
</style>
</head>
<body>
<div id="apDiv0">
<table width="1100" height="270" style="left:100"border="1">
  <tr>
    <td width="1100" height="270"><img src="image/fengyinzhe.jpg" width="1100" height="270" alt="fengyinzhe1" /></td>
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
  <table width="722" height="200" border="1">
    <tr>
      <td width="140"><img src="image/lishihe.png" width="140" height="200" alt="lishihe" /></td>
      <td width="140"><img src="image/liseyu.png" width="140" height="200" alt="liseyu" /></td>
      <td width="140"><img src="image/youli.png" width="140" height="200" alt="youli" /></td>
      <td width="140"><img src="image/Jshu.png" width="140" height="200" alt="Jshu" /></td>
      <td width="140"><img src="image/xiaomi.png" width="140" height="200" alt="xiaomi" /></td>
    </tr>
    <tr>
      <td width="140" height="30" align="center"><p class="biaoti1"><a href="javascript:GoIntroduction();"<u><em>人物简介</em></u>></a></p></td>
      <td width="140" height="30" align="center"><p class="biaoti1"><a href="javascript:GoNewRole();"<u><em>新角色</em></u>></a></p></td>
      <td width="140" height="30" align="center"><p class="biaoti1"><a href="javascript:GoForum();"<u><em>吐槽区</em></u>></a></p></td>
      <td width="140" height="30" align="center"><p class="biaoti1"><a href="javascript:GoWallpaper();"<u><em>精美壁纸</em></u>></a></p></td>
      <td width="140" height="30" align="center"><p class="biaoti1"><a href="javascript:GoPersonalCenter();"<u><em>个人中心</em></u>></a></p></td>
    </tr>
  </table>
  <h1><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;游戏背景</strong></h1>
<blockquote>
  <blockquote>
     <font size = 3> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《封印者》的故事描述在数十年前，未知的异次元生命体跨越次元侵袭地球，通常的武器火力并无法与之对抗，而其所到之处皆毁灭为废墟。但是当入侵者开启次元之门时，同时也有极少数的人类因此觉醒，得到了能与怪物对抗的力量，在付出了极大牺牲的情况下在&ldquo;第一次次元战争&rdquo;中关闭了次元之门，世人就以&ldquo;封印者&rdquo;来称呼这些超能力者，大战的幸存者编入了联合国底下的机构&ldquo;UNION&rdquo;，为防止第二次次元战争的爆发，玩家将扮演韩国首尔城市中的UNION所属特殊小队BLACK LAMBS（黑绵羊）中的队员进行战斗。</font>
  </blockquote>
</blockquote>
</div>
<div id="apDiv3">
  <form name="Headline">
  <%
  if(user == null)
  {
  %>
  <table width="129"border="1">
    <tr>
    <td height="50" align="center">
    <input type="button" value="登陆" onclick="ShopConfirm('img1')" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
  <table width="129"border="1">
    <tr>
    <td height="50" align="center">
    <input type="button" value="注册" onclick="ShopConfirm('img2')" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
  <%
  }
  else
  {
  %>
  <table width="129"border="1">
    <tr>
    <td height="50" align="center">
    <input type="button" value="注销" onclick="window.location.href='index.jsp'" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
  <%
  }
  %>
  </form>
</div>
<div id="img1" style="position: absolute; top: 200px; left: 400px; background: #FFF; font-size: 14px; z-index: 900; border: 2px #FFCC00 solid; width: 350px; height: 200px; padding: 9px;"> 
    <div style="width:350px;text-align:right;">
	    <div style=" color:#080808; font-weight:bold;font-size:15px;cursor:hand;"onclick="CloseShopConfirm('img1')">关闭</div>
    </div>
    <form action="proving.jsp" method="post" name="submit">
    <table width="350" height="170" border="0">
          <tr>
            <th width="120" scope="row"><img src="image/leibiya2.png" width="120" height="170" alt="leibiya1" /></th>
            <td width="214"><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="text" name="user" style="width:160px;height:20px;"><br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="password" name="password" style="width:160px;height:20px;"><br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="submit" value="登陆" style="width:60px"><br><br>
    		<p class="ziti">
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:CloseShopConfirm('img1');ShopConfirm('img3')"<u><em>忘了密码?</em></u>></a>&nbsp;&nbsp;&nbsp;<a href="javascript:CloseShopConfirm('img1');ShopConfirm('img2')"<u><em>注册新用户</em></u>></a></p></td>
          </tr>
      </table>
  	</form>
</div>
<script language="javascript">hide('img1');</script>
<div id="webBgLayer" style="position:absolute;top:0px;left:0px;z-index:899;height:100%;width:100%;display:none;-moz-opacity:0.5;filter:alpha(opacity=50);"></div>
<div id="img2" style="position: absolute; top: 200px; left: 400px; background: #FFF; font-size: 14px; z-index: 900; border: 2px #FFCC00 solid; width: 260px; height: 400px; padding: 9px;"> 
    <div style="width:250px;text-align:right;">
	    <div style=" color:#080808; font-weight:bold;font-size:15px;cursor:hand;"onclick="CloseShopConfirm('img2')">关闭</div>
    </div>
    <form action="register.jsp" method="post" name="register">
    <table width="350" height="170" border="0">
          <tr>
            <td width="214"><br>
    		账号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="text" name="user" style="width:160px;height:20px;"><br><br>
    		密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="password" name="password" style="width:160px;height:20px;"><br><br>
    		确认密码&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="password" name="confirmPassword" style="width:160px;height:20px;"><br><br>
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<input type="submit" value="注册" style="width:60px"><br><br></td>
          </tr>
      </table>
  	</form>
</div>
<script language="javascript">hide('img2');</script>
<div id="webBgLayer" style="position:absolute;top:0px;left:0px;z-index:899;height:100%;width:100%;display:none;-moz-opacity:0.5;filter:alpha(opacity=50);"></div><div id="webBgLayer" style="position:absolute;top:0px;left:0px;z-index:899;height:100%;width:100%;display:none;-moz-opacity:0.5;filter:alpha(opacity=50);"></div>
<div id="img3" style="position: absolute; top: 200px; left: 400px; background: #FFF; font-size: 14px; z-index: 900; border: 2px #FFCC00 solid; width: 260px; height: 400px; padding: 9px;"> 
    <div style="width:250px;text-align:right;">
	    <div style=" color:#080808; font-weight:bold;font-size:15px;cursor:hand;"onclick="CloseShopConfirm('img3')">关闭</div>
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
<script language="javascript">hide('img3');</script>
<div id="webBgLayer" style="position:absolute;top:0px;left:0px;z-index:899;height:100%;width:100%;display:none;-moz-opacity:0.5;filter:alpha(opacity=50);"></div>
</body>
</html>