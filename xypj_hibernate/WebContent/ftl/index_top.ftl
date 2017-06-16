<#macro index_top>
<div class="container">
		<div class="page-header">
            <div class="page-header-top"></div>
			<div class="page-header-top2">
				<span class="page-header-top-left"><span class="nihao">你好，${Session.updateUserSessionInfo.userRealName!}</span></span>
				<span class="page-header-top-right"> 
				<a class="tc"
					href="${path}/Login/index.do">退出</a> <!-- 暂时关掉换肤，等有多套皮肤时再开启 -->
				<a class="xgmm"
								 href="${path!}/User/index.do?url=user/editPwd&userId=${Session.updateUserSessionInfo.userId!}" >修改密码</a>
				
				</span>
			</div>
			<div class="page-header-content report_header">
				<div class="logo2">
					<a href="javascript:void(0)"><span class="page_logo"></span></a>
					<p class="wj_logo_version"></p>
				</div>
				<div class="menu2  fr"></div>
			</div>
		</div>
		</div>
		
		
		<div id="mainPage" class="page-main">

			<div id="mainLayout">

				<div data-options="region:'west',split:true" id="subMenu" title="二级菜单" style="width: 160px;">
					<div class="erji-menu">
						<ul id="smallmenu" style="height:100%;overflow-y:auto;overflow-x: hidden;"></ul>
					</div>
				</div>
				<div id="content-center" data-options="region:'center'" style="width: 100%;"></div>
			</div>
		</div>

		
		<script type="text/javascript">
		var topMenu="<ul id='bigmenu' class='menu_con_detail'><li class=''><a href='javascript:void(0)' id='topmenuid1' data-url='/lsbk/index.do?url=main/main'><div class = 'bgdiv'>首页<div></a></li>";
		  topMenu+="<li class=''><a href='javascript:void(0)' id='topmenuid2' data-url='/ControlPerson/index.do?url=controlPerson/list'>用户管理</a></li>";
		  topMenu+="<li class=''><a href='javascript:void(0)' id='topmenuid3' data-url='/ControlPerson/index.do?url=controlPerson/list'>管控人员</a></li>";
	      topMenu+="</ul>";
	      $('.menu2').html(topMenu);
	      
	      $(".menu2 a").each(function() {
				$(this).click(function() {
					window.location.href = path + $(this).attr("data-url");
				});
			});
	
	

</script>
</#macro>