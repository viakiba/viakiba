<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>员工调动</title>
    <script type="text/javascript">
  		var jobChange = new JobChangeInfoPanel();
  		tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
		juage(tabId,"jobch",jobChange,"jobChangeDiv");
  	</script>
  </head>
  <body>
  		<div id="jobChangeDiv"></div>
  </body>
</html>
