<#macro page>

<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

li {
	list-style: none;
}

.wrap {
	font-size: 12px;
	color: #333;
	font-family: "微软雅黑", Simsun;
	width: auto;
	max-width: 320px;
	margin: 0 auto;
}

.center {
	width: 103%;
	margin: 0 auto;
}

/***************分页******************/
.fenye {
	float: left;
	margin-top: 10px;
}

.fenye ul {
	float: left;
	margin-left: 32px;
}

.fenye ul li {
	float: left;
	margin-left: 5px;
	padding: 4px 6px;
	border: 1px solid #ccc;
	font-weight: bold;
	cursor: pointer;
	color: #333;
}

.fenye ul li a {
	color: #333;
}

.fenye ul li.xifenye {
	width: 38px;
	text-align: center;
	float: left;
	position: relative;
	cursor: pointer;
}

.fenye ul li .xab {
	float: left;
	position: absolute;
	width: 39px;
	border: 1px solid #ccc;
	height: 123px;
	overflow-y: auto;
	overflow-x: hidden;
	top: -125px;
	background-color: #fff;
	display: inline;
	left: -1px;
	width: 50px;
}

.fenye ul li .xab ul {
	margin-left: 0;
	padding-bottom: 0;
}

.fenye ul li .xab ul li {
	border: 0;
	padding: 4px 0px;
	color: #333;
	width: 34px;
	margin-left: 0px;
	text-align: center;
}
</style>

	<!--下一页--->
	<div class="wrap" style="margin-top:10px;">
		<div class="fenye">
			<ul id = "page_fenye">
				<li id="first">首页</li>
				<li id="top" onclick="topclick()">上一页</li>
				<li class="xifenye" id="xifenye"><a id="xiye">1</a>/<a id="mo">1</a>
					<div class="xab" id="xab" style="display:none">
						<ul id="uljia">

						</ul>
					</div>
				</li>
				<li id="down" onclick="downclick()">下一页</li>
				<li id="last">末页</li>
			</ul>
		</div>
	</div>

	<script type="text/javascript" src="${path!}/js/plus/public.js"></script>
	<script type="text/javascript">
		$("#page_fenye li").each(function(){
			$(this).mouseover(function(){
				$(this).addClass("datagrid-row-over");
			});
			$(this).mouseout(function(){
				$(this).removeClass("datagrid-row-over");
			});
		});
	</script>

</#macro>