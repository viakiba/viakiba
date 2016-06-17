<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    	<br/>取非根元素<br/>
    	<s:property value="user.id"/>
    	<s:property value="user.name"/>
    	<s:property value="#user.address"/>
    	<s:property value="#user.address.city"/>
    	<s:property value="#user.address.province"/>
    	
    	
    	<s:property value="#request.request_data"/>
    	<s:property value="#session.Session_data"/>
    	<s:property value="#application.Session_data"/>
  </body>
</html>
