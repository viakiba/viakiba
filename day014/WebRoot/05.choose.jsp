<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://haust.vk.cn" prefix="vk" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '05.choose.jsp' starting page</title>
  </head>
  
  <body>
  	<vk:choose>
  		<vk:when test="${10>5 }">条件成立</vk:when>
  		<vk:otherwhise >条件不成立</vk:otherwhise>
  	</vk:choose>
  </body>
</html>
