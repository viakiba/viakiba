<%@page import="haust.vk.b_entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>核心标签库</title>
  </head>
  
  <body>
    	<%--使用标签 --%>
   		<%--set标签 :保存数据(保存到域中)默认保存到page域 --%>
    	<c:set var="name" value="rose" scope="application"></c:set>
 		
 		<%
 			String msg=null;
 			pageContext.setAttribute("msg", msg);
 		 %>
 		 msg:${msg }<br>
 		 <%--out标签： 获取数据（从域中） 
    	default： 当value值为null时，使用默认值
    	escapeXml: 是否对value值进行转义，false，不转义，true，转义（默认）
   		 --%>
   		 <c:out value="${name }" default="<h3>标题3</h3>" escapeXml="false"></c:out>
 		<hr/>
 		<%--if标签 ：单条件判断--%>
 
 		<c:if test="${empty msg }">
 			条件成立
 		</c:if>
 		<c:set var="score" value="56"></c:set>
 		<c:choose>
 			<c:when test="${score>=90 && score<=100 }">
 				优秀
 			</c:when>
 			
 			<c:otherwise>
 				不及格。
 			</c:otherwise>
 		</c:choose>
 
 <hr>
 
 		<%-- forEach标签：循环 --%>
    <%
    	//List
     	List<Student>  list = new ArrayList<Student>();
     	list.add(new Student("rose",18));
     	list.add(new Student("jack",28));
     	list.add(new Student("lucy",38));
     	//放入域中
     	pageContext.setAttribute("list",list);
     	
     	//Map
     	Map<String,Student> map = new HashMap<String,Student>();
     	map.put("100",new Student("mark",20));
     	map.put("101",new Student("maxwell",30));
     	map.put("102",new Student("narci",40));
     	//放入域中
     	pageContext.setAttribute("map",map);
     %>
     
     <%--
      begin="" : 从哪个元素开始遍历，从0开始.默认从0开始
      end="":     到哪个元素结束。默认到最后一个元素
      step="" ： 步长    (每次加几)  ，默认1
      items=""： 需要遍历的数据（集合） 
      var=""： 每个元素的名称 
      varStatus=""： 当前正在遍历元素的状态对象。（count属性：当前位置，从1开始）
      
     --%>
     
     <c:forEach items="${list }" var="student" varStatus="varSta">
        	序号：${varSta} - 姓名：${student.name } - 年龄：${student.age }<br/>
     </c:forEach>
     
     <hr/>
     
     <c:forEach items="${map }" var="entry">
     	${entry.key } - 姓名：{entry.value.name} -年龄：${entry.value.age }<br/>
     </c:forEach>
     
     <%-- forToken标签： 循环特殊字符串 --%>
    <%
    	String str = "java-php-net-平面";
    	pageContext.setAttribute("str",str);
     %>
    
    <c:forTokens items="${str}" delims="-" var="s">
    	${s }<br/>
    </c:forTokens>
    
     <%--redrict:重定向 --%>
     <%--
     <c:redirect url="http://163.com"></c:redirect>
      --%>
     <hr/>
  </body>
</html>
