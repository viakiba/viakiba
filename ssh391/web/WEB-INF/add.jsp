<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: viakiba
  Date: 2016/8/19
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <jsp:include page="/head.jsp"></jsp:include>

  <s:form action="/emp_save.action" method="post" theme="simple">
    <table border="1" align="center" cellpadding="5" cellspacing="0">
      <tr>
        <td>员工姓名</td>
        <td>
          <s:textfield name="empName" id="empName" value=""></s:textfield>
        </td>
      </tr>
      <tr>
        <td>员工薪水</td>
        <td>
          <s:textfield value="" name="salary" id="salary"></s:textfield>
        </td>
      </tr>

      <tr>
        <td>选择部门</td>
        <td>
          <!--
  	 			 	Struts下拉列表标签：
  	 			 		name="deptId"  下拉列表标签的名称(服务器根据这个名称获取选择的项的实际的值value值)
  	 			 		headerKey   默认选择项的实际的值
  	 			 		headerValue  默认下拉列表显示的内容
  	 			 		list      下拉列表显示数据的集合
  	 			 		listKey    集合对象的哪个属性作为下拉列表的实例的值，即value值
  	 			 		listValue  集合对象的哪个属性作为下拉列表显示的值
  	 			 		value      默认选择的项的设置
  	 			  -->
          <s:select list="#request.listDept"
                name="deptId"
                headerKey="-1"
                headerValue="请选择"
                listValue="name"
                listKey="id"
                value="-1"></s:select>

        </td>
      </tr>
      <tr>
        <td colspan="2">
          <s:submit value="添加员工"></s:submit>
        </td>
      </tr>
    </table>
  </s:form>
</body>
</html>
