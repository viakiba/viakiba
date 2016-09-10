<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>js中定义函数的三种方式</title>
  </head>
  <body>
    	<script type="text/javascript">
    		//正常方式
    		function add(num1,num2){
    			return num1+num2;
    		}
    		window.alert("10+20="+add(20, 10));
    	</script>
    	
    	<script type="text/javascript">
    		//构造器方式
    		var add = new Function("num1","num2","return num1+num2");
    		window.alert("100+200="+add(100,200))
    	</script>
    	
    	<script type="text/javascript">
    		//直接量或者无名、匿名方式
    		var add = function(num1,num2){
    			return num1+num2;
    		}
    		window.alert("1000+2000="+add(1000,2000))
    	</script>
  </body>
</html>
