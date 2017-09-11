<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>实时监控</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="CssFiles/layer.css" type="text/css" rel="stylesheet" />
<link href="CssFiles/layui.css" type="text/css" rel="stylesheet" />
<script src="JsFiles/layer.js"></script>
<script src="JsFiles/layui-v1.0.9_rls/layui/layui.js" charset="utf-8"></script>
<script src="JsFiles/jquery-1.9.1.js"></script>
<script src="JsFiles/Chart.min.js"></script>
<script type="text/javascript">
$(document).ready(function()
{
	realTime();
	setInterval(function()
	{
		realTime();
	},5000);
	$("#isCreate").change(function()
	{
		var instructions = $("#isCreate").prop("checked");
		$.ajax(
		{
			type : "post",
			url : "createInvoiceAction?instructions=" + instructions,
			dataType : "text",
			success : function(data)
			{
			}
		});
	});
});
function realTime()
{
	var times = getRequestTimeJson();
	var labels = [];
	for(var i = 0; i < 20;i++)
	{
		labels.push(times[i]);
	}
	times = JSON.stringify(times);
	$.ajax(
	{
		type : "post",
		url : "chartInDayAction?times=" + times,
		dataType : "text",
		success : function(data)
		{
			var array = eval("(" + data + ")");
			var inAmount = [];
			var outAmount = [];
			for( var i = 0;i < 20;i++)
			{
				inAmount.push(array[i].In);
				outAmount.push(array[i].Out);
			}
			var data =
			{
				labels : labels,
				datasets : [
				{
					fillColor : "rgba(0,0,0,0)",
					strokeColor : "rgba(0,255,0,1)",
					pointColor : "rgba(0,255,0,1)",
					pointStrokeColor : "#fff",
					data : inAmount
				},
				{
					fillColor : "rgba(255,255,255,0)",
					strokeColor : "rgba(255,0,0,1)",
					pointColor : "rgba(255,0,0,1)",
					pointStrokeColor : "#fff",
					data : outAmount
				}]
			};
			var tmp = $("#realCanvas").clone();
			$("#realCanvas").remove();
			$("#realCanvasDiv").prepend(tmp);
			var ctx = document.getElementById("realCanvas").getContext("2d");
			var myNewChart = new Chart(ctx);
			myNewChart.Line(data,
			{
				responsive : true
			});
		}
	});
}
function getRequestTimeJson()
{
	var result = [];
    var date = new Date();
    for(var i = 0; i < 21;i++)
    {
    	result.push(getDateSuffix(date));
    	date = new Date(date.getTime() - 5000);
    }
    var result1 = [];
    for(var i = 20; i >= 0;i--)
    {
    	result1.push(result[i]);
    }
    return result1;
}
function getDateSuffix(date)
{
    var currentTime = "";
    var hours = date.getHours();
    if(hours >= "0" && hours <= "9")
    {
    	currentTime += "0" + hours + ":";
    }
    else
    {
    	currentTime += hours + ":";;
    }
    var minute = date.getMinutes();
    if(minute >= "0" && minute <= "9")
    {
    	currentTime += "0" + minute + ":";
    }
    else
    {
    	currentTime += minute + ":";;
    }
    var second = date.getSeconds();
    if(second >= "0" && second <= "9")
    {
    	currentTime += "0" + second;
    }
    else
    {
    	currentTime += second;
    }
    return currentTime;
}
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>实时监控</legend>
	</fieldset>
	<input type="checkbox" id="isCreate" style="margin-left:80px;"><label for="isCreate">随机生成数据</label>
	<div id="realCanvasDiv" style="width:1000px;height:500px;">
		<canvas id="realCanvas"></canvas>
	</div>
</body>
</html>