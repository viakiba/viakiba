<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://haust.vk.cn" prefix="vk" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP '01.hellotag.jsp' starting page</title>

  </head>
  
  <body>
    <%
    	String ip=request.getRemoteHost();
    	ip=request.getRemoteAddr();
    	out.println(ip);
     %><br>
     
     <vk:showIp>xxx</vk:showIp>
  </body>
</html>
