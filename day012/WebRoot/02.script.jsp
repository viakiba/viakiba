<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>Jsp语法</title>  
  </head>
  
  <body>
  	<!-- jsp表达式  -->
  	<%
  		//变量
  		String name = "eric";
  		int a = 10;
  		int b =20;
  	 %>
  	<%=name %>  
  	<br/>
  	<%=(a-b) %>  
  	<hr/>
  	<!-- jsp脚本  -->
  	<%
  		//生成随机数
  		Random ran = new Random();
  		float num = ran.nextFloat();
  	 %>
  	 随机小数：<%=num %>
  	 <hr/>
  	 <!-- 穿插html代码 -->
  	 <%
  	 	for(int i=1;i<=6;i++){ 	
  	  %>
  	 	<h<%=i %>>标题<%=i %></h<%=i %>>
  	 <%
  	  }
  	  %>
  	  <hr/>
  	  <!-- 练习： 使用脚本和html代码显示99乘法表 -->
  	 <%
  	 	for(int i=1;i<=9;i++){//行
  	 		for(int j=1;j<=i;j++){//公式
  	 %>			
  	 		<%=i %> x <%=j %>=<%=(i*j) %>&nbsp;
  	 	<%			
  	 		}
  	 	%>
  	 	   <br/>
  	 	<% 	
  	 	}
  	  %>
  	  <%
  	  	String age = "20";
  	  	
  	  	/* 脚本中不能声明方法
  	  	public String getAge(){
  	  		return age;
  	  	}
  	  	*/
  	   %>
  	  
  	  
  	  <!-- jsp声明 -->
  	  <%!
  	   //变量
  	  	String name = "jacky";
  	  	
  	  	public String getName(){
  	  		return name;
  	  	}
  	  	
  	  	/*jsp声明中不能重复定义翻译好的一些方法
  	  	public void _jspInit(){
  	  	
  	  	}
  	  	*/
  	   %>
  	   <!-- html注释 -->
  	  <%-- <jsp:forward page="/01.hello.jsp"></jsp:forward> --%>
  	   <%-- jsp注释 --%>
  	   
  	 
  </body>
</html>
