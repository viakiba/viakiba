<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://haust.vk.cn" prefix="vk" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '07.javabean.jsp' starting page</title>
  </head>
  
  <body>
	     <%---创建对象 --%>
     <jsp:useBean id="stu" class="haust.vk.b_cases.Student"></jsp:useBean>
     
     
     <%--赋值 --%>
     <jsp:setProperty property="name" name="stu" value="jacky"/>
     
       <%--获取--%>
    <jsp:getProperty property="name" name="stu"/>
  </body>
</html>
