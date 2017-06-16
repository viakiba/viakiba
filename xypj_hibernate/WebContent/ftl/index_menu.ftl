<#macro index_menu>
<!--主菜单 -->


<section id="secondary_bar">
		<div class="user">
			<#if Session.updateUserSessionInfo?exists!>
				<p>${Session.updateUserSessionInfo.userRealName!}</p>
			<#else>
				<p>尚未登录</p>
			</#if>
		</div>
		<div class="breadcrumbs_container">
		<p>${system_version.nodeDesc }:${system_version.nodeValue }&nbsp;&nbsp;</p>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column" style="min-height:600px;">
		<hr/>
			<h3 id="topmenuid1" data-url="/Update/index.do?url=main/main">首页</h3>
			<h3 id="topmenuid2" data-url="/Update/index.do?url=update/list">升级配置</h3>
			<h3 id="topmenuid3" data-url="/Dict/index.do?url=dict/dict">字典管理</h3>
			<h3 id="topmenuid4" data-url="/Plugin/index.do?url=plugin/list">插件管理</h3>
			<h3 id="topmenuid5" data-url="/User/index.do?url=user/list">用户管理</h3>
			<h3 id="topmenuid6" data-url="/SysConfig/index.do?url=sysconfig/sysConfig">系统配置</h3>
			<h3 id="topmenuid7" data-url="/Log/index.do?url=log/list">日志查看</h3>
		
		
	</aside>
<script type="text/javascript">
	//绑定菜单点击事件
	$(function() {

		$("#sidebar h3").each(function() {
			$(this).click(function() {
				window.location.href = path + $(this).attr("data-url");
			});
		});
	});
</script>
</#macro>