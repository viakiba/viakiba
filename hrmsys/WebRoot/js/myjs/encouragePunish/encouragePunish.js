
EPunishPanel = Ext.extend(Ext.Panel,{
	id: 'ePunishPanelId',
	constructor: function(){
		var ePunishGridPanel = new EPunishGridPanel();
		var ePunishQueryPanel = new EPunishQueryPanel();
		EPunishPanel.superclass.constructor.call(this,{
			style: 'margin:0 auto',
			border: false,
			items: [ePunishQueryPanel, ePunishGridPanel]
		})
	}
})