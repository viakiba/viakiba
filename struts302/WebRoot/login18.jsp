<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><s:text name="title"></s:text></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	 <form method="post" action="${pageContext.request.contextPath }/user_login.action">
  	 	用户名：<input type="text" name="admin.userName"><br/>
  	 	密码：<input type="text" name="admin.pwd"><br/>
  	 	<input type="submit" value="登陆"><br/>
  	 </form>
  </body>
</html>
