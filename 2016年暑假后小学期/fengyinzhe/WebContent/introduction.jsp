<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人物简介</title>
<%
request.setCharacterEncoding("UTF-8");
String user = request.getParameter("user");
%>
<script type="text/javascript">
function showTab(tabHeadId,tabContentId) 
{
    //tab层
    var tabDiv = document.getElementById("apDiv2");
    //将tab层中所有的内容层设为不可见
    //遍历tab层下的所有子节点
    var taContents = tabDiv.childNodes;
    for(i=0; i<taContents.length; i++) 
    {
        //将所有内容层都设为不可见
        if(taContents[i].id!=null && taContents[i].id != 'tabsHead')
        {
            taContents[i].style.display = 'none';
        }
    }
    //将要显示的层设为可见
    document.getElementById(tabContentId).style.display = 'block';          
    //遍历tab头中所有的超链接
    var tabHeads = document.getElementById('tabsHead').getElementsByTagName('a');
    for(i=0; i<tabHeads.length; i++) 
    { 
        //将超链接的样式设为未选的tab头样式
        tabHeads[i].className='tabs'; 
    }
    //将当前超链接的样式设为已选tab头样式
    document.getElementById(tabHeadId).className='curtab';
    document.getElementById(tabHeadId).blur();
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
#apDiv4 {
	position: absolute;
	width: 288px;
	height: 27px;
	z-index: 1;
	left: 573px;
	top: 1px;
}
</style>
</head>
<body>
<div id="apDiv0">
<table width="1100" height="270" border="1">
  <tr>
    <td width="1100" height="270"><a href="index.jsp?user=<%= user%>"><img src="image/fengyinzhe.jpg" width="1100" height="270" alt="fengyinzhe1" /></a></td>
  </tr>
</table>
</div>
<div id="apDiv1">
	<table width="200" height="800" border="1">
		<tr>
			<td width="200" height="800"><img src="image/leibiya.jpg" width="233" height="800" alt="leibiya"/></td>
		</tr>
	</table>
</div>
<div id="apDiv2">
	 <div id="tabsHead">
  <table width="487" height="36" border="1">
    <tr>
      	<td><a id="tabs1" class="curtab" href="javascript:showTab('tabs1','tabContent1')">李世赫</a></td>
        <td><a id="tabs2" class="tabs" href="javascript:showTab('tabs2','tabContent2')">李瑟钰</a></td>
        <td><a id="tabs3" class="tabs" href="javascript:showTab('tabs3','tabContent3')">尤莉</a></td>
        <td><a id="tabs4" class="tabs" href="javascript:showTab('tabs4','tabContent4')">J叔</a></td>
        <td><a id="tabs5" class="tabs" href="javascript:showTab('tabs5','tabContent5')">米斯丁</a></td>
    </tr>
  </table>
  </div>
  <div id="tabContent1" style="display: block">
  <table width="861" height="341" border="1">
    <tr>
      <td width="560">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;李世赫的母亲是终结第一次次元战争的传奇封印者，李世赫也被视为“黑羊”中的头号种子。世赫擅长利用次元力引发瞬间爆炸，是一名冲锋陷阵的封印者。然而，世赫似乎并不能发挥全部能力，他对自己的潜力也没什么兴趣——他的最爱是玩游戏。游戏机不离手的他是个典型的重度游戏迷。对他来说，“黑羊”小队就像补习班一样讨厌。</td>
      <td width="285"><img src="image/lishihe1.png" width="285" height="341" alt="misiding" /></td>
    </tr>
  </table>
  </div>
  <div id="tabContent2" style="display: none">
  <table width="861" height="341" border="1">
    <tr>
      <td width="560">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;李瑟钰是在Union的“早期培训”中脱颖而出的少女。第一次次元战争夺走了她的父母， Union抚养她长大。瑟钰擅长用次元力操纵物体进行战斗，是一位法师般的封印者。瑟钰天赋不高，但是一个努力家。刻苦的练习使她能娴熟地控制自己的力量，更被委任“黑羊”小队的队长。严谨认真的她，与敷衍了事的李世赫是一对冤家。</td>
      <td width="285"><img src="image/liseyu1.png" width="285" height="341" alt="misiding" /></td>
    </tr>
  </table>
  </div>
  <div id="tabContent3" style="display: none">
  <table width="861" height="341" border="1">
    <tr>
      <td width="560">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尤莉在成为封印者之前已是一位剑道达人。初中时，她用扫把打跑了一群不良少年，因此受邀加入校剑道部，并在一次比赛中觉醒了次元力。刀枪并用的她是一位身法利落的封印者。为了拿到“铁饭碗”，尤莉成为了小队中最渴望晋升正职的队员。另一方面，尤莉开朗乐观的性格也活跃了小队的气氛，小队成员们都将她视作队中不可或缺的一位成员。</td>
      <td width="285"><img src="image/youli1.png" width="285" height="341" alt="misiding" /></td>
    </tr>
  </table>
  </div>
  <div id="tabContent4" style="display: none">
  <table width="861" height="341" border="1">
    <tr>
      <td width="560">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;J的青春在第一次次元战争中度过，惨烈的战场重创了他的身心。如今，战力大不如前的J，仍凭借多年积累的战斗经验和自创的次元力应用法为“黑羊”战斗着。J的拿手武器就是他的一对铁拳。为了弥补战力损失，在战斗中服用各类“次元力增幅剂”也成为了J的招牌动作。虽然嗜好保健品、满口冷笑话的J被队友们看做奇怪的大叔，但他丰富的实战经验，让他成为小队里最可靠的前辈。</td>
      <td width="285"><img src="image/Jshu1.png" width="285" height="341" alt="misiding" /></td>
    </tr>
  </table>
  </div>
  <div id="tabContent5" style="display: none">
  <table width="861" height="341" border="1">
    <tr>
      <td width="560">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;米斯丁是“黑羊”小队的追加成员，也是个“可爱的男孩子”。他的武器是比自己还大的长枪，娇小的他有着强大的战斗力。米斯丁在还不会说话的时候，就已显现出惊人的次元力，并被视为“次世代的新星”。最终，他在Union德国支部以第一的成绩毕业。不过，即使身为天才，他也还是个孩子。在日常生活中，米斯丁常常展现出旺盛的好奇心以及天真烂漫的一面。</td>
      <td width="252"><img src="image/xiaomi1.png" width="285" height="341" alt="misiding" /></td>
    </tr>
  </table>
  </div>
</div>
</body>
</html>