<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/easyui.css" type="text/css"></link>
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/icon.css" type="text/css"></link>
  		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
  		<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_TW.js"></script>
  </head>
  <body>
	
	<table id="dg"></table>
	<script type="text/javascript">
		$("#dg").datagrid({
			url : "${pageContext.request.contextPath}/emp/findAllEmpMethod.do?time="+new Date().getTime(),
			columns:[[    
		        {field:'empno',title:'编号',width:100},    
		        {field:'ename',title:'姓名',width:100},    
		        {field:'job',title:'职位',width:100},   
		        {field:'mgr',title:'上级编号',width:100},   
		         
		        {field:'hiredate',title:'入职时间',width:100,
		        	formatter:function(value){
		        		var date = new Date(value);
		        		var year = date.getFullYear();
		        		var month = date.getMonth()+1;
		        		var date = date.getDate();
		        		return year+"年"+month+"月"+date+"日";
		        	}
		        },    
		        
		        {field:'sal',title:'薪水',width:100},  
		         
		        {field:'comm',title:'佣金',width:100,
		        	formatter:function(value){
		        		if(value == null){
		        			return 0;
		        		}else{
		        			return value;
		        		}
		        	}
		        },   
		         
		        {field:'deptno',title:'部门编号',width:100}   
		    ]],
		    singleSelect : true,
		    pagination : true  
		});	
	</script>	
  </body>
</html>
