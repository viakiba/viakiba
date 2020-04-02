<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
  </head>
  
  <body>
   	<#if Request.all?exists>  
         ${Request.all}   
    </#if> 
    
    <#if Request.city?exists>  
         ${Request.city}   
    </#if> 
    
    <#if Request.province?exists>  
         ${Request.province}   
    </#if> 
  </body>
</html>
