<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var deptPanel = new deptInfoGridPanel();
	var tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
	juage(tabId,"dept",deptPanel,"tab");
	//deptPanel.render("tab");
</script>
<div id="tab" ></div>
