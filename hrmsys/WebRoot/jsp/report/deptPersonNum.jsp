<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>部门人数统计图</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		Ext.onReady(function(){
			var chart = new FusionCharts("flash/Column3D.swf", "ChartId", "600", "350", "0", "0");
		    chart.setDataURL("dept_report.action");		   
		    chart.render("chartdiv");		
		});
		//http://shihuan830619.javaeye.com/blog/833813
	</script>
  </head>
  
  <body>
		<div id="chartdiv" align="center">a </div>
  </body>
</html>
