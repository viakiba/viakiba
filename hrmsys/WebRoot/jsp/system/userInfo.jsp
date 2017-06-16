<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色</title>
	<script type="text/javascript">
		var userInfoPanel = new UserInfoPanel();
		var tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
		juage(tabId,"user",userInfoPanel,"userDiv");
	</script>
	
  </head>
  <body>
  	<div id="userDiv" ></div>
  </body>
</html>
