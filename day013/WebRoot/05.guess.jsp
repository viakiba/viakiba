<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP '05.guess.jsp' starting page</title>

  </head>
  
  <body>
    <%
    	//从req域中取出信息
    	String msg=(String)request.getAttribute("msg");
     	if(msg!=null){
  			out.write("<font color='red'>"+msg+"</font>");
  		}
     %>
    
    <%
    	Integer times = (Integer)request.getAttribute("times");
  	 	if(times!=null){
  	 		out.write(",你还有"+(5-times)+"次机会！");
  	 	}
     %>
    
    <form action="/day013/GuessServlet" method="post">
    	请输入30以下的整数：<input type="text" name="num" /><br>
    	<%
    	 if(times!=null){
    	 %>
    	<input type="hidden" name="times" value="<%=times %>"/> 
    	<%
    	} 
    	%>   	
    	<input type="submit" value="提交"/>
    	
    
    </form>
  </body>
</html>
