<%@ page language="java" isErrorPage="true" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>error page</title>
</head>
<body>
	������ϢΪ��
	<%=exception.getMessage()%><br>
	<%=exception.toString()%>
</body>
</html>