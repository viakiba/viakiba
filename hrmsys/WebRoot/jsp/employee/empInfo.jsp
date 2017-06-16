<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var empGrid = new empInfoGridPanel();
	tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
	juage(tabId,"emp",empGrid,"emp");
</script>
<div id="emp"></div>