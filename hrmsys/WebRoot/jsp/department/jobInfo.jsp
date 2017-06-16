<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var jobGrid = new jobInfoGrid();
	var tabId = Ext.getCmp('mainTab').getActiveTab().id.split('_')[1];
	juage(tabId,"job",jobGrid, "job");
</script>
<div id="job"></div>