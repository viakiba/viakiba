TrainRecordPanel = Ext.extend(Ext.Panel,{
	id: 'trainRecordPanelId',
	constructor: function(){
		tRecordQueryPanel = new TRecordQueryPanel();
		tRecordInfoGridPanel = new TRecordInfoGridPanel();
		TrainRecordPanel.superclass.constructor.call(this,{
			style: 'margin:0 auto',
			border: false,
			//layout: 'fit',
			//autoWidth: true,
			//autorHeight: true,
			items: [tRecordQueryPanel, tRecordInfoGridPanel]
		})
	}
})