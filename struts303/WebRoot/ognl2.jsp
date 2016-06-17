<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css" >
	   .odd{
	           background-color: red; 
	          }
	   .even{
	           background-color:blue;}
	  </style>

  </head>
  
  <body>
    <br/>一、.构建 list集合</br>
    <s:iterator var="str" value="{'a','b'}">
    	<s:property value="#str"/>
    </s:iterator>
    
     <br/>一、.构建 map集合</br>
     <s:iterator var="en" value="#{'cn':'China','usa':'America'}">
     	<s:property value="#en.key"/>
     	<s:property value="#en.value"/>  <br/>
     </s:iterator>
    
  </body>
</html>







