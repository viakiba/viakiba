<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
  <jsp:include page="/head.jsp"></jsp:include>

  <s:form action="/emp_update.action" method="POST" theme="simple">
    <!-- 修改操作：隐藏域保存主键值 -->
    <s:hidden name="id" id="id" value="%{id}"></s:hidden>

    <table border="1" align="center" cellpadding="5" cellspacing="0">
      <tr>
        <td>员工姓名</td>
        <td>
          <s:textfield name="empName" id="empName"></s:textfield>
        </td>
      </tr>
      <tr>
        <td>员工薪水</td>
        <td>
          <s:textfield name="salary" id="salary"></s:textfield>
        </td>
      </tr>
      <tr>
        <td>选择部门</td>
        <td>
          <!--
                  value  默认选择的项的设置
                         即设置要显示的对象的主键
                        (根元素取值)
           -->
          <s:select
                  name="deptId"
                  headerKey="-1"
                  headerValue="请选择"
                  list="#request.listDept"
                  listKey="id"
                  listValue="name"
                  value="dept.id"
                  ></s:select>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <s:submit value="修改员工"></s:submit>
        </td>
      </tr>
    </table>
  </s:form>
</body>
</html>
