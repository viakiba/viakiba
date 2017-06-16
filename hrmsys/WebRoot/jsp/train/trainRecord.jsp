<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>培训记录</title>
    
	<script type="text/javascript">
		var trainRecordPanel = new TrainRecordPanel();
		var tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
		juage(tabId,"trainr",trainRecordPanel,"trainRecord");
	</script>
	
  </head>
  <body>
  	<div id="trainRecord" ></div>
  </body>
</html>
