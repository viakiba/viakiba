<#--
js组件引用标签：用于引用核心js、css及用户指定的js组件
	value: 要引用的js组件简称，目前支持dialog、ztree、validate、calendar、card
-->
<#macro script value=[]>
	<link href="${path!}/theme/css/main.css" rel="stylesheet" type="text/css"/>
	<script src="${path!}/script/jquery.js" type="text/javascript"></script>
	<script src="${path!}/script/jquery.ext.js" type="text/javascript"></script>
	<script src="${path!}/script/date.js" type="text/javascript"></script>
	
<#list value as item>
	<#if item=="dialog">
		<script src="${path!}/script/dialog/lhgdialog.js?skin=default" type="text/javascript"></script>
	</#if>
	<#if item=="ztree">
		<link href="${path!}/script/ztree/css/zTreeStyle.css" rel="stylesheet" type="text/css"/>
		<script src="${path!}/script/ztree/jquery.ztree.core.min.js" type="text/javascript"></script>
		<script src="${path!}/script/ztree/jquery.ztree.excheck.min.js" type="text/javascript"></script>
	</#if>
	<#if item=="calendar">
		<link href="${path!}/script/calendar/css/calendar.css" rel="stylesheet" type="text/css"/>
		<script src="${path!}/script/calendar/WdatePicker.js" type="text/javascript"></script>
		<script src="${path!}/script/calendar/jquery-calendar.js" type="text/javascript"></script>
	</#if>
	<#if item=="validate">
		<link href="${path!}/script/validate/skins/default.css" rel="stylesheet" type="text/css"/>
		<script src="${path!}/script/validate/validator-source.js" type="text/javascript"></script>
	</#if>
	<#if item=="card">
		<script src="${path!}/script/common.js" type="text/javascript" id="js_common"></script>		
	</#if>
</#list>
	<script type="text/javascript">
	//所有的ajax请求在sesstion超时的时候都自动跳转到登录页面
	$.ajaxSetup({
		global: false,
		complete:function(xhr, ts) {
			if(xhr.status == 200) {
				return;
			}
			var result = eval("(" + xhr.responseText + ")");
			if(result.flag == 2) {//500错误信息，后台异常
				alert(result.msg);
			} else if(result.flag == 3) {//403错误
				alert(result.msg);
			} else if(result.flag == 4) {//404错误
				alert(result.msg);
			} else if(result.flag == 5) {//session超时
				alert(result.msg, function(){
					top.location.href = "${path!}/login.jsp";
				})
			} else {
				alert("无法连接到服务器，请检查您的网络连接")
			}
		}
	});
</script>
</#macro>