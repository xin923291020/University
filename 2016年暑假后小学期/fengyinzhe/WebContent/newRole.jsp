<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新角色：蕾比亚</title>
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
#apDiv2 {
	position: absolute;
	width: 595px;
	height: 483px;
	z-index: 1;
	left: 628px;
	top: 289px;
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
</table>
</div>
<div id="apDiv2"><img src="image/leibiya1.jpg" width="595" height="483" alt="leibiya1" /></div>
<div id="apDiv1"><table width="516" height="487" border="1">
  <tr>
    <td><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;次元战争后期，遭受赫克顿盖尔袭击的法国海岸边的一个洞穴中，人们发现了六个巨大的半

锥形蛋。这些蛋散发着强大的力量，研究人员决定将它们销毁。但其中一个研究员对龙之军

团精锐兵的惊人力量十分着迷，便带着这些蛋潜逃，开始了孵化实验。最终，只有一个蛋忍

受了长达五年的次元压成功孵化。</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;她就是蕾比亚。蕾比亚有着与人类极其相似的容貌，并将研究员当成了自己的父母，研究员

对其进行了无数残忍的实验。而蕾比亚对其仍旧无条件的服从，但有一天，她目睹研究员被

刺杀的景象突然暴走，杀死了半数处理部队，直到红狼小队的队长出现将她打晕。</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;恢复意识的他回想起父母的死亡和被自己起手杀死的人类，陷入了深深的自责，她希望一死

了之，因为这是她唯一的赎罪方式。最后，她成为了红狼小队的一员，服从队长的命令，处

理着与自己有相同血脉的次元兽。</p></td>
  </tr>
</table></div>
</body>
</html>