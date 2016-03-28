<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true" session="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '03.pageContext.jsp' starting page</title>
    
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
    <%
    //获取其他八个内置对象
    //	response.getWriter().write("是否相同？"+(out==pageContext.getOut())+"<br/>");
    //	response.getWriter().write("是否相同？"+(session==pageContext.getSession())+"<br/>");   
     %>
     
     <%
     //保存数据
    // pageContext.setAttribute("message", "page's message");
     //pageContext.setAttribute("message", "session'message", PageContext.SESSION_SCOPE);
     //pageContext.setAttribute("message", "request'message", PageContext.REQUEST_SCOPE);
     
     pageContext.setAttribute("message", "application'message", PageContext.APPLICATION_SCOPE);
     
      %>
      
      <%
      //获取数据
      response.getWriter().write(""+pageContext.getAttribute("message")+"</br>");
       %>
       <%=pageContext.getAttribute("message", pageContext.REQUEST_SCOPE) %></br>
       <%=pageContext.getAttribute("message",PageContext.SESSION_SCOPE) %><br/>
       <%=pageContext.getAttribute("message",PageContext.APPLICATION_SCOPE) %><br/>
 	   <%=pageContext.findAttribute("message") %>
  <%=pageContext.findAttribute("message") %>
  <%--  --%>
  <%
  //转发
  //request.getRequestDispatcher("/03.page.context.jsp").forward(request, response);
  
  //重定向
  	//response.sendRedirect(request.getContextPath()+"/03.page.context2.jsp");
   %>
  </body>
</html>
