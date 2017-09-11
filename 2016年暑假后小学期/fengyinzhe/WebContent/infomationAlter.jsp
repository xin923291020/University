<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改信息</title>
<jsp:useBean id = "db" class = "bean.Fengyinzhe_Connect" scope = "page" />
<%
	request.setCharacterEncoding("UTF-8");
	String user = request.getParameter("user");
	String selectSQL = "Select * From Infomation Where fengyinzhe_User = '" + user + "'";
	ResultSet rs = db.executeQuery(selectSQL);
	rs.next();
%>
<script type="text/javascript">
function save()
{
	var user  = '<%= user %>';
	var bb;
	var name = document.getElementById("name").value;
	var cc = document.getElementsByName('sex'); 
	for(var i = 0; i < sex.length; i++)
	{
		if(cc[i].checked)
		{
		bb = cc[i].value;
		}
	}
	var age = document.getElementById("age").value;
	var phone = document.getElementById("phone").value;
	var emailAddress = document.getElementById("emailAddress").value;
	var serverName = document.getElementById("serverName").value;
	var role = document.getElementById("role").value;
	window.location.href = "infomationUpdate.jsp?user=" + user + "&name=" + name + "&age=" + age + "&sex=" + bb
			+ "&phone=" + phone + "&emailAddress=" + emailAddress + "&serverName=" + serverName + "&role=" + role;
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
#apDiv5 {
	position: absolute;
	width: 65px;
	height: 31px;
	z-index: 4;
	left: 306px;
	top: 418px;
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
        <td width="280" align="center">
          <input type="text" name="name" id="name" value="<%= rs.getString(2)%>"/></td>
      </tr>
      <tr>
        <td width="100" align="center">性别</td>
        <td width="280" align="center">
        <%if(rs.getString(3).equals("男"))
        	{%>
        <label>男</label><input type="radio"name="sex"id="sex1"value="男" checked="checked"/>
        <label>女</label><input type="radio"name="sex"id="sex2"value="女"/>
        <%}
        else
        	{%>
        <label>男</label><input type="radio"name="sex"id="sex1"value="男"/>
        <label>女</label><input type="radio"name="sex"id="sex2"value="女"checked="checked"/>
        <%} %>
        </td>
      </tr>
      <tr>
        <td width="100" align="center"><label>年龄</label></td>
        <td width="280" align="center"><label></label>
          <select name="age" id="age">
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="<%= rs.getString(4)%>" selected="selected"><%out.print(rs.getString(4));%></option>
          </select></td>
      </tr>
      <tr>
        <td width="100" align="center">手机号</td>
        <td width="280" align="center"><input type="text" name="phone" id="phone" value="<%= rs.getString(5)%>"/></td>
      </tr>
      <tr>
        <td width="100" align="center"><label>邮箱</label></td>
        <td width="280" align="center"><input type="text" name="emailAddress" id="emailAddress" value="<%= rs.getString(6)%>"/></td>
      </tr>
      <tr>
        <td width="100" align="center"><label>游戏大区</label></td>
        <td width="280" align="center"><label></label>
          <label for="serverName"></label>
          <select name="serverName" id="serverName">
            <option value="网通一区">网通一区</option>
            <option value="电信一区">电信一区</option>
            <option value="电信二区">电信二区</option>
            <option value="<%= rs.getString(7)%>" selected="selected"><%out.print(rs.getString(7));%></option>
          </select>          
          &nbsp;</td>
      </tr>
      <tr>
        <td width="100" align="center"><label>角色</label></td>
        <td width="280" align="center"><label><input type="text" name="role" id="role" value="<%= rs.getString(8)%>"/></label></td>
      </tr>
    </table>
  </div>
   <div id="apDiv5">
    <input type="button" name="save" onclick="save()" value="保存" />
  </div>
      </td>
    </tr>
  </table>
</div>
<div id="apDiv3">
  <table width="158" height="50" border="1">
    <tr>
     <td height="50" align="center">
    <input type="button" value="返回" onclick="window.location.href='personalCenter.jsp?user=<%= user%>'" style="background-color:transparent;border:0;font-size:16px;font-style:italic;text-decoration:underline"/>
    </td>
    </tr>
  </table>
</div>
</body>
</html>