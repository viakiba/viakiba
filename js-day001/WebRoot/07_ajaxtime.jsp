<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    	当前时间：<span id="time"></span></br>
    	<input id="buttonID" type="button" value="获取当前时间"><p/>
    	<script type="text/javascript">
    		function createAjax(){
    			var ajax = null;
    			try{
    				//ajax ie5 ie12
    				ajax = new ActiveXObject("microsoft.xmlhttp");
    			}catch(e1){
    			try{
    				//
    				ajax = new XMLHttpRequest();
    			}catch(e2){
    				alert("你的浏览器不支持一部对象")
    			}
    			}
    		return ajax;
    		}
    	</script>
    	
    	<script type="text/javascript">
    		document.getElementById("buttonID").onclick = function(){
    			//1创建ajax异步对象
    			var ajax = createAjax();
    			//2准备发送请求
    			var method = "GET";
    			var url = "${pageContext.request.contextPath}/AjaxTimeServlet?time="+new Date().getHours();
    			ajax.open(method, url);
    			//3真正发送请求体的数据到服务器，如果请求体种无数据 就用null标识
    			ajax.send(null);
    			//------------
    			/*
    			4AJAX异步对象不断监听服务器响应的状态0-1-2-3-【4】
			           一定要状态变化后，才可触发function(){}函数
    			*/
    			//如果状态永远是4-4-4-4-4，是不会触发function(){}函数的
    			ajax.onreadystatechange= function () {
					//如果状态码为4的话
					if(ajax.readyState == 4){
						if(ajax.status == 200){
							//NO5)从AJAX异步对象中获取服务器响应的HTML数据
							var nowstr = ajax.responseText;
							//NO6)将结果按照DOM规则，动态添加到web页面指定的标签中
							var span = document.getElementById("time")	;
							span.innerHTML = nowstr;						
						}
					}
					
				}
    		}
    		
    	</script>
  </body>
</html>
