<%@page import="haust.vk.b_cases.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://haust.vk.cn" prefix="vk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '06.foreach.jsp' starting page</title>
  </head>
  
  <body>
  	<%
       //保存数据
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
  
  
    <vk:forEach items="${list }" var="student">
    	姓名：${student.name } - 年龄：${student.age }<br/>
    </vk:forEach>
    <vk:forEach items="${map }" var="entry">
    	编号：${entry.key } -- 姓名：${entry.value.name }<br/>
    </vk:forEach>
    
    
  </body>
</html>
