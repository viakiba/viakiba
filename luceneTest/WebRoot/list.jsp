<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>使用Jsp +Js + Jquery + EasyUI + Servlet + Lucene，完成分页</title>
    <!-- 引入css文件，无顺序 -->
       	<!-- 引入css文件，无顺序 -->
   	<link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
    <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
   	
   	<!-- 引入js文件 -->
   	 <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
   	
  </head>
  
  <body>
	<!-- 输入区 -->
	<form id="myformID">
		输入关键字：<input type="text" value="" id="keywordID">
		<!--  -->
		<input type="button" value="站内搜索" id="findID">
	</form>
	
	<!-- 脚本 -->
	<script type="text/javascript">
		//
		$("#findID").click(function(){
			//
			var keyword = $("#keywordID").val();
			//
			keyword = $.trim(keyword);
			//
			if(keyword.length == 0){
				//
				alert("请输入关键字");
				//
				$("#keywordID").val("");
				//
				$("#keywordID").focus();
			}else{
				/*
				
				*/
				$("#dg").datagrid("load",{
					"keywords" : keyword
				});
				
			}
			
		});
	</script>
	
	<table id="dg">
	
	</table>
	
	<script type="text/javascript">
		$("#dg").datagrid({
			url : "${pageContext.request.contextPath}/ArticleServlet?time="+new Date().getTime(),
			columns :  [[    
					        	{field:'id',title:'编号',width:100},    
					        	{field:'title',title:'标题',width:100},    
					        	{field:'content',title:'内容',width:100}
						]],
			fitColumns : true,
			singleSelect : true,
			pagination : true,
			pageSize : 2,
			pageList : [2]		    
		});
	</script>
  </body>
</html>
