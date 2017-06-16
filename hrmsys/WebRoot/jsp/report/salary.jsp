<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<!-- <a href="emp_report.action?empId=0007" target="_blank">report</a>
	<s:form action="emp_report.action">
		<s:textfield name="empId"/>
		<s:submit value="确定"/>
	</s:form>-->
	<script type="text/javascript">
		var salaryPanel = new SalaryPanel();
		var w = Ext.getCmp('mainTab').getActiveTab().getInnerWidth();
		var h = Ext.getCmp('mainTab').getActiveTab().getInnerHeight();
		var activeTab = Ext.getCmp('salaryPanelId');
		if(activeTab){
			activeTab.setHeight(h);
			activeTab.setWidth(w);
		}
		activeTab.render('salaryDiv');
	</script>
	<div id="salaryDiv"></div>
</body>
</html>
 