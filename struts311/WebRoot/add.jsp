<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	
  	 
  	 <s:form action="/user_add" method="post">
  	 	用户名:<s:textfield name="userName"></s:textfield>  <br/>
  	 	密码：<s:textfield name="pwd"></s:textfield>        <br/>
  	 	
  	 	<s:submit value="保存用户"></s:submit>
  	 </s:form>
  </body>
</html>






