<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.hrmsys.util.CurrentDate"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  	<base href="<%=basePath%>"/>
    <title>人力资源管理系统</title>
    	<link rel="stylesheet" type="text/css"
			href="js/extjs/resources/css/ext-all.css"/>
		<link rel="stylesheet" type="text/css"
			href="css/common.css"/>
		<link rel="stylesheet" type="text/css"
			href="css/icon.css"/>
		<link rel="stylesheet" type="text/css"
			href="css/loading.css"/>
		<script type="text/javascript" src="js/extjs/ext-base.js"></script>
		<script type="text/javascript" src="js/extjs/ext-all.js"></script>
		<!-- ext插件 -->
		<script type="text/javascript" src="js/extjs/plugin/TabCloseMenu.js"></script>
		<link rel="stylesheet" type="text/css" href="js/extjs/plugin/css/fileuploadfield.css"/>
		<script type="text/javascript" src="js/extjs/plugin/FileUploadField.js"></script>
		<script type="text/javascript" src="js/extjs/plugin/TreeCheckNodeUI.js"></script>
		<script type="text/javascript" src="js/extjs/plugin/ext-basex.js"></script>
		<!-- 树形表格 -->
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridSorter.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridColumnResizer.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridNodeUI.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridLoader.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGridColumns.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/TreeGrid.js"></script>
		<script type="text/javascript" src="js/extjs/treegrid/edittreegrid-pkg.js"></script>
		<link rel="stylesheet" type="text/css" href="js/extjs/treegrid/treegrid.css"/>
		<link rel="stylesheet" type="text/css" href="js/extjs/treegrid/edittreegrid.css"/>
		<!-- 公共 JS -->
		<script type="text/javascript" src="js/myjs/department/depart.js"></script>
		<script type="text/javascript" src="js/myjs/department/job.js"></script>
		<script type="text/javascript" src="js/myjs/util/gridOperate.js"></script>
		<script type="text/javascript" src="js/myjs/override/dialog.js"></script>
		<script type="text/javascript" src="js/myjs/util/juage.js"></script>
		<script type="text/javascript" src="js/myjs/util/winSize.js"></script>
		<script type="text/javascript" src="js/myjs/util/Tooltip.js"></script>
		<script type="text/javascript" src="js/myjs/util/common.js"></script>
		<!-- 主页 -->
  		<script type="text/javascript" src="js/myjs/main.js"></script>
  		<!-- 部门管理 -->
  		<script type="text/javascript" src="js/myjs/department/deptAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/department/deptInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/department/jobAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/department/jobInfo.js"></script>
  		<!-- 职员管理 -->
  		<script type="text/javascript" src="js/myjs/employee/empInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/employee/empAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/employee/uploadWin.js"></script>
  		<script type="text/javascript" src="js/myjs/employee/jobChangeInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/employee/jobChangeAdd.js"></script>
  		<SCRIPT type="text/javascript" src="js/myjs/employee/jobChangeDetail.js"></SCRIPT>
  		<script type="text/javascript" src="js/myjs/employee/empUpdateWin.js"></script>
  		<script type="text/javascript" src="js/myjs/employee/empDetailWin.js"></script>
  		<script type="text/javascript" src="js/myjs/employee/empGrid.js"></script>
  		<!-- 招聘管理 -->
  		<script type="text/javascript" src="js/myjs/recruitment/recruitmentInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/recruitment/recruitmentAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/recruitment/recruitmentDetail.js"></script>
  		<!-- 培训记录 -->
  		<script type="text/javascript" src="js/myjs/train/trainAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/train/trainInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/train/train.js"></script>	
  		<script type="text/javascript" src="js/myjs/train/trainRecordInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/train/trainRecord.js"></script>	
  		<script type="text/javascript" src="js/myjs/train/trainDetail.js"></script>
  		<script type="text/javascript" src="js/myjs/train/trainRecordAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/train/trainGrid.js"></script>
  		<script type="text/javascript" src="js/myjs/train/trainRecordDetail.js"></script>
  		<!-- 奖惩管理 -->
  		<script type="text/javascript" src="js/myjs/encouragePunish/encouragePunishInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/encouragePunish/encouragePunishAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/encouragePunish/encouragePunish.js"></script>
  		<script type="text/javascript" src="js/myjs/encouragePunish/encouragePunishDetail.js"></script>
  		<!-- 薪资管理 -->
  		<script type="text/javascript" src="js/myjs/salary/revenue.js"></script>
  		<script type="text/javascript" src="js/myjs/salary/boon.js"></script>
  		<script type="text/javascript" src="js/myjs/salary/salaryBasic.js"></script>
  		<script type="text/javascript" src="js/myjs/salary/salaryAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/salary/salaryInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/salary/salaryDetail.js"></script>
  		<!-- 系统管理 -->
  		<script type="text/javascript" src="js/myjs/system/roleAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/system/permissionAssign.js"></script>
  		<script type="text/javascript" src="js/myjs/system/userInfo.js"></script>
  		<script type="text/javascript" src="js/myjs/system/userAdd.js"></script>
  		<script type="text/javascript" src="js/myjs/system/userUpdate.js"></script>
  		<script type="text/javascript" src="js/myjs/system/update.js"></script>
  		<!-- 报表管理 -->
  		<script type="text/javascript" src="js/myjs/report/FusionCharts.js"></script>
  		<script type="text/javascript" src="js/myjs/report/empDetail.js"></script>
  		<script type="text/javascript" src="js/myjs/report/salary.js"></script>
  		
  		<script type="text/javascript">
	  		Ext.onReady(function(){
	  			Ext.Ajax.request({
	  				timeout: 120000, //超时时间设置为60s
	  				url: 'permission_initPermission.action',
	  				success: function(){
	  					Ext.get('loading').remove();
						Ext.get('loading-mask').fadeOut({remove:true});
	  				}
	  			})
//	  			setTimeout(function() {
//				}, 1000); 
	  			var username = "${user.userName}"; //获取登录用户
	  			var date = "<%=CurrentDate.getDateWeek()%>";
	  			var main = new mainPage(username, date);
			});
  		</script>
  </head>
  
  <body style="margin:0px;">
  	<div id="loading">
             <div  class="loading-indicator">
                  <img src="img/extanim32.gif" alt="" width="32" height="32" style="margin-right:8px;" align="absmiddle"/>
         正在加载,请稍候......
             </div>
         </div>
         <div id="loading-mask">
         </div>
  </body>
</html>
