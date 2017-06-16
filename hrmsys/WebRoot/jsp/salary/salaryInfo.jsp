<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>工资信息</title>
	<script type="text/javascript">
		var salaryInfoGridPanel = new SalaryInfoGridPanel();
		var tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
		juage(tabId,"sal",salaryInfoGridPanel,"salaryInfoPanel");
	</script>
	
  </head>
  <body>
  	<div id="salaryInfoPanel" ></div>
  </body>
</html>
