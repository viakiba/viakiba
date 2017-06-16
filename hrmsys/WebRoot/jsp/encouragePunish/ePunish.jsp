<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>招聘管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		var ePunishPanel = new EPunishPanel();
		tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
		juage(tabId,"ePunish",ePunishPanel,"ePunishPanel");
	</script>
  </head>
  
  <body>
	<div id="ePunishPanel"></div>
  </body>
</html>
