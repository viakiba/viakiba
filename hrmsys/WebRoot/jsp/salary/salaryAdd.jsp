<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>工资备录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var salaryAddPanel = new SalaryAddPanel();
		var width = Ext.getCmp('mainTab').getActiveTab().getInnerWidth();
	 	var height = Ext.getCmp('mainTab').getActiveTab().getInnerHeight();
		var activeTab = Ext.getCmp('salaryAddPanelId');
	 	if(activeTab){
	 	  	activeTab.setWidth(width);
	 	  	activeTab.setHeight(height);
	 	}
		activeTab.render('salaryAddPanel');
	</script>
	
  </head>
  <body>
  	<div id="salaryAddPanel" ></div>
  </body>
</html>
