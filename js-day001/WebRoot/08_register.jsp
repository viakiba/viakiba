<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP '08_register.jsp' starting page</title>

  </head>
  
  <body>
    	<form >
    		用户名【get】:<input id="usernameID" type="text" name="username" maxlength="4">
    		光标移除后立即检查
    	</form>
    	<span id="resID"></span>
    	<script type="text/javascript">
    		//创建ajax异步对象
    		function createajax(){
    			var ajax = null;
    			try{
    				ajax = new ActiveXObject("microsoft.xmlhttp");
    			}catch(e1){
    				try{
    					ajax = new XMLHttpRequest();
    				}catch(e2){
    					alert("你的浏览器不支持ajax 请更换浏览器");
    				}
    			}
    			return ajax;
    		}
    	</script>
    	
    	<script type="text/javascript">
    		document.getElementById("usernameID").onblur = function(){
    			//获取用户输入的值
    			var username = this.value;
    			//如果用户没有填内容
    			if(username == null){
    				//提示
    				document.getElementById("resID").innerHTML="用户名必填";
    			}else{
    				//对汉字进行utf-8编码
    				username = encodeURI(username);
    				//no1
    				var ajax = createajax();
    				var method = "POST";
    				var url = "${pageContext.request.contextPath}/UserServlet?time"+new Date().getTime()+"&username="+username;
    				
    				ajax.open(method,url);
    				ajax.send(null);
    				
    				if(ajax.onreadystatechange == 4){
    					if(ajax.status == 200){
    						var tip = ajax.responseText;
    						//
    						document.getElementById("resID").innerHTML=tip;
    					}
    				}
    			}
    		}
    	</script>
  </body>
</html>
