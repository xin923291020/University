<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>发票系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="CssFiles/layer.css" type="text/css" rel="stylesheet" />
<link href="CssFiles/layui.css" type="text/css" rel="stylesheet" />
<script src="JsFiles/layer.js"></script>
<script src="JsFiles/layui-v1.0.9_rls/layui/layui.js" charset="utf-8"></script>
<script src="JsFiles/jquery-1.9.1.js"></script>
<script src="JsFiles/Chart.min.js"></script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>导入Excel</legend>
	</fieldset>
	<div style="margin-left:50px;margin-top:35px;">
		<form name="myform" id="myform" action="importAction" enctype="multipart/form-data"
			method="post">
			<input type="file" id="seed" name="seed">
			<button id="save" class="layui-btn layui-btn-small layui-btn-normal">保存</button>
		</form>
	</div>
</body>
</html>