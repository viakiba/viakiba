<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>js类型</title>
  </head>
  
  <body>
  	练习：
    	<script type="text/javascript">
    		//num为number类型
    		var num = 100;
    		//str为string类型 注意js的string类型用''或者""均可
    		var str = '哈哈';
    		var flag = true;
    		//alert(person); 先定义后使用
    		
    		
    		//alert(num);
    		//alert(str);
    		//alert(flag);
    	</script>
    	
    	<script type="text/javascript">
    		//多个script快中的内容 可以互相访问
    		var person = null;
    		var card;
    		//alert(str); //可以访问其他的块的内容
    		if(person == undefined){
    			alert("card没有赋值 为 null")
    		}else{
    			alert(person)
    		}
    		
    		//判断空的话 undefined来判断 null
    		if(card == undefined){
    			alert("card没有赋值 为 null")
    		}else{
    			alert(card)
    		}
    		
    		//
    		
    	</script>
  </body>
</html>
