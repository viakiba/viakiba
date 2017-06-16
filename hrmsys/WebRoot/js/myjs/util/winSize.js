function resize(activePanel){
	var w = Ext.getCmp('mainTab').getActiveTab().getInnerWidth();
	var h = Ext.getCmp('mainTab').getActiveTab().getInnerHeight();
	//alert(activePanel);
	    activePanel.setWidth(w);
	    activePanel.setHeight(h);
};