<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>福利信息</title>
	<script type="text/javascript">
		var boon = new Boon();
		var tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
		juage(tabId,"boon",boon,"boon");
	</script>
	
  </head>
  <body>
  	<div id="boon" ></div>
  </body>
</html>
