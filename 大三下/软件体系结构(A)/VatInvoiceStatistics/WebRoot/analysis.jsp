<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>分析</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="CssFiles/layer.css" type="text/css" rel="stylesheet" />
<link href="CssFiles/layui.css" type="text/css" rel="stylesheet" />
<script src="JsFiles/layer.js"></script>
<script src="JsFiles/layui-v1.0.9_rls/layui/layui.js" charset="utf-8"></script>
<script src="JsFiles/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(document).ready(function()
{
	$.ajax(
	{
		type : "post",
		url : "analysisAction",
		dataType : "json",
		success : function(data)
		{
			$("#income").html(data.income);
			$("#expenditure").html(data.expenditure);
			$("#offtake").html(data.offtake);
			$("#purchase").html(data.purchase);
		}
	});
});
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>分析</legend>
	</fieldset>
	<table class="layui-table">
	<tr>
		<td>收入/同对比昨日</td>
		<td id="income"></td>
	</tr>
	<tr>
		<td>支出/同对比昨日</td>
		<td id="expenditure"></td>
	</tr>
	<tr>
		<td>今日卖出最多</td>
		<td id="offtake"></td>
	</tr>
	<tr>
		<td>今日买入最多</td>
		<td id="purchase"></td>
	</tr>
	</table>
</body>
</html>