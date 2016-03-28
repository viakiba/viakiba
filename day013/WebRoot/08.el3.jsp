<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '08.el3.jsp' starting page</title>
    
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
     <%--
    	1)算术表达式
    	  +  -  *  /
     --%>
     ${10+5 }
     ${4-1 }
     <hr/>
      <%--
    	2)比较运算
    	>  <  >=  <=  ==   !=
     --%>
     ${10>5 }<br/>
     ${10!=5 }
     <hr/>
	     <%--
    	3)逻辑运算
    	 &&  ||  !
     --%>
     ${true||false }<br/>
     ${true&&false }<br/>
     ${!false }<br/>
     <hr/>
      <%--
    	4)判空
    	null 或 空字符串:  empty
     --%>
     <%
     	String name="";
     	String age=null;
     	pageContext.setAttribute("name", name);
     	pageContext.setAttribute("age", age);
      %>
      
      判断null：${age==null }
  判断空字符： ${name=="" }
    判空：  ${name==null || name=="" }
     另一种判空写法： ${empty name }
  </body>
</html>
