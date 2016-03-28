<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>动作标签</title>
  </head>
  
  <body>
    <%
    	//request.getRequestDispatcher("/09.action2.jsp?name=eric&password=saj").forward(request, response);
     %>
     <%--
     <jsp:forward page="/09.action2.jsp">
     	<jsp:param value="rose" name="name"/>
     	<jsp:param value="sasad" name="password"/>
     </jsp:forward>
      --%>
      <%--
      <jsp:include page="/common/header.jsp">
      	<jsp:param value="lucy" name="name"/>
      </jsp:include>
      
       --%>
       <%@include file="common/header.jsp" %>
  </body>
</html>
