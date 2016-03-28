<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '03.page.context2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    page域：<%=pageContext.getAttribute("message",PageContext.PAGE_SCOPE) %><br/>
    request域： <%=pageContext.getAttribute("message",PageContext.REQUEST_SCOPE) %><br/>
    session域： <%=pageContext.getAttribute("message",PageContext.SESSION_SCOPE) %><br/>
    context域：<%=pageContext.getAttribute("message",PageContext.APPLICATION_SCOPE) %><br/>
  </body>
</html>
