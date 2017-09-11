<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="CssFiles/layer.css" type="text/css" rel="stylesheet" />
<link href="CssFiles/layui.css" type="text/css" rel="stylesheet" />
<script src="JsFiles/layer.js"></script>
<script src="JsFiles/layui-v1.0.9_rls/layui/layui.js" charset="utf-8"></script>
<script src="JsFiles/jquery-1.9.1.js"></script>
<script src="JsFiles/Chart.min.js"></script>
<script type="text/javascript">
layui.use(['form',],function()
{
	var form = layui.form();
	form.on("select(year)",function()
	{
		refresh1($("#year").val(),0);
	});
	form.on("select(startYear)",function()
	{
		if($("#startYear").val() < $("#finishYear").val())
		{
			refresh2($("#startYear").val(),$("#finishYear").val());
		} else
		{
			alert("起始年份应小于终止年份。");
		}
	});
	form.on("select(finishYear)",function()
	{
		if($("#startYear").val() < $("#finishYear").val())
		{
			refresh2($("#startYear").val(),$("#finishYear").val());
		} else
		{
			alert("起始年份应小于终止年份。");
		}
	});
});
function refresh1(year,type)
{
	$.ajax(
	{
		type : "post",
		url : "chartInOneYearAction?year=" + year + "&kind=0",
		dataType : "text",
		success : function(data)
		{
			var array = eval("(" + data + ")");
			var data =
			{
				labels : ["1月","2月","3月","4月","5月","6月","7月","8月","9月",
						"10月","11月","12月"],
				datasets : [
						{
							fillColor : "rgba(0,0,0,0)",
							strokeColor : "rgba(0,255,0,1)",
							pointColor : "rgba(0,255,0,1)",
							pointStrokeColor : "#fff",
							data : [array[0].Jan,array[0].Feb,array[0].Mar,
									array[0].Apr,array[0].May,array[0].Jun,
									array[0].Jul,array[0].Aug,array[0].Sep,
									array[0].Oct,array[0].Nov,array[0].Dec]
						},
						{
							fillColor : "rgba(255,255,255,0)",
							strokeColor : "rgba(255,0,0,1)",
							pointColor : "rgba(255,0,0,1)",
							pointStrokeColor : "#fff",
							data : [array[1].Jan,array[1].Feb,array[1].Mar,
									array[1].Apr,array[1].May,array[1].Jun,
									array[1].Jul,array[1].Aug,array[1].Sep,
									array[1].Oct,array[1].Nov,array[1].Dec]
						}]
			};
			var tmp = $("#yearCanvas").clone();
			$("#yearCanvas").remove();
			$("#yearCanvasDiv").prepend(tmp);
			var ctx = document.getElementById("yearCanvas")
					.getContext("2d");
			var myNewChart = new Chart(ctx);
			myNewChart.Line(data,
			{
				responsive : true
			});
			
			$.ajax(
			{
				type : "post",
				url : "chartInOneYearAction?year=" + year + "&kind=1",
				dataType : "text",
				success : function(data)
				{
					var array = eval("(" + data + ")");
					var data =
					{
						labels : ["第一季度","第二季度","第三季度","第四季度"],
						datasets : [
								{
									fillColor : "rgba(0,0,0,0)",
									strokeColor : "rgba(0,255,0,1)",
									pointColor : "rgba(0,255,0,1)",
									pointStrokeColor : "#fff",
									data : [array[0].One,array[0].Two,
											array[0].Three,array[0].Four]
								},
								{
									fillColor : "rgba(255,255,255,0)",
									strokeColor : "rgba(255,0,0,1)",
									pointColor : "rgba(255,0,0,1)",
									pointStrokeColor : "#fff",
									data : [array[1].One,array[1].Two,
											array[1].Three,array[1].Four]
								}]
					};
					var tmp = $("#quarterCanvas").clone();
					$("#quarterCanvas").remove();
					$("#quarterCanvasDiv").prepend(tmp);
					var ctx = document.getElementById("quarterCanvas").getContext(
							"2d");
					var myNewChart = new Chart(ctx);
					myNewChart.Line(data,
					{
						responsive : true
					});
					if(type == 1)
					{
						refresh2(2015,2017);
					}
				}
			});
		}
	});
}
function refresh2(startYear, finishYear)
{
	var year = [];
	for( var i = startYear;i <= finishYear;i++)
	{
		year.push(i);
	}
	$.ajax(
	{
		type : "post",
		url : "chartInManyYearAction?startYear=" + startYear
				+ "&finishYear=" + finishYear,
		dataType : "text",
		success : function(data)
		{
			var array = eval("(" + data + ")");
			var inAmount = [];
			var outAmount = [];
			for( var i = startYear;i <= finishYear;i++)
			{
				inAmount.push(array[0][i]);
				outAmount.push(array[1][i]);
			}
			var data =
			{
				labels : year,
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
			var tmp = $("#yearsCanvas").clone();
			$("#yearsCanvas").remove();
			$("#yearsCanvasDiv").prepend(tmp);
			var ctx = document.getElementById("yearsCanvas").getContext(
					"2d");
			var myNewChart = new Chart(ctx);
			myNewChart.Line(data,
			{
				responsive : true
			});
		}
	});
}
refresh1(2017,1);
</script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="text-align:left;">
		<legend>图表显示</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" onsubmit="return false" style="margin-left:150px;">
		<div class="layui-input-inline" style="width:120px;">
			<select id="year" lay-filter="year" style="height:38px;">
				<option value="2017">2017年</option>
				<option value="2016">2016年</option>
				<option value="2015">2015年</option>
				<option value="2014">2014年</option>
				<option value="2013">2013年</option>
			</select>
		</div>
	</form>
	<div style="width:900px;margin:16px auto;">
		<div id="yearCanvasDiv" style="float:left;width:400px;height:200px;">
			<canvas id="yearCanvas"></canvas>
		</div>
		<div id="quarterCanvasDiv"
			style="float:right;width:400px;height:200px;">
			<canvas id="quarterCanvas"></canvas>
		</div>
	</div>
	<div style="margin-left:150px;">
		<form class="layui-form layui-form-pane" onsubmit="return false">
			<div id="startYearDiv" class="layui-input-inline" style="width:120px;">
				<select id="startYear" lay-filter="startYear" style="height:38px;">
					<option value="2017">2017年</option>
					<option value="2016">2016年</option>
					<option value="2015" selected="selected">2015年</option>
					<option value="2014">2014年</option>
					<option value="2013">2013年</option>
				</select>
			</div>
			<div id="labelDiv" class="layui-input-inline">
				<label>至</label>
			</div>
			<div id="finishYearDiv" class="layui-input-inline" style="width:120px;">
				<select id="finishYear" lay-filter="finishYear" style="height:38px;">
					<option value="2017">2017年</option>
					<option value="2016">2016年</option>
					<option value="2015">2015年</option>
					<option value="2014">2014年</option>
					<option value="2013">2013年</option>
				</select>
			</div>
		</form>
	</div>
	<div style="width:450px;margin-left:120px;">
	<div id="yearsCanvasDiv" style="float:left;width:400px;height:200px;">
		<canvas id="yearsCanvas"></canvas>
	</div>
	</div>
</body>
</html>
