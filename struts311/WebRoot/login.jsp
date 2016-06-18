<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>

  </head>
  
  <body>
    	<s:form action="/user_login" method="post" name="frmLogin" id="frmLogin">
  		
  		用户名：<s:textfield name="user.name"></s:textfield>
  		密码：<s:textfield name="user.pwd"></s:textfield>
  		<s:submit value="登陆"></s:submit>
  	</s:form>
  </body>
</html>
