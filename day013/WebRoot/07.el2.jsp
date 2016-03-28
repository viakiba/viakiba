<%@page import="haust.vk.b_entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP '07.el2.jsp' starting page</title>

  </head>
  
  <body>
      <%--
		1)EL输出对象的属性    
     --%>
     <%
     	Student student=new Student("eric",20);
     	pageContext.setAttribute("student", student);
     	
     	//list
     	List <Student> list= new ArrayList<Student>();
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
      
       <%--使用EL获取对象 --%>
      ${student.name} - ${student.age }
      <%--
       ${student.name} 等价于     （点相对于调用getXX（）方法）
          <%=((Student)pageContext.findAttribute("student")).getName()%>
       --%>
       
       <hr/>
       <%--使用EL获取List对象 --%>
       ${list[0].name } - ${list[0].age }<br/>
       ${list[1].name } - ${list[1].age }<br/>
       ${list[2].name } - ${list[2].age }
       <%--
       list[0]等价于       (中括号相对于调用get(参数)方法)
       		((List)pageContext.findAttribute("list")).get(0)
        --%>
        <hr/>
        <%--使用EL获取Map对象 --%>
        ${map['100'].name } -  ${map['100'].age }<br/>
        ${map['101'].name } -  ${map['101'].age }<br/>
        ${map['102'].name } -  ${map['102'].age }<br/>
  </body>
</html>
