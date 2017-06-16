TrainPanel = Ext.extend(Ext.Panel,{
	id: 'trainPanelId',
	constructor: function(){
		trainQueryPanel = new TrainQueryPanel();
		trainInfoGridPanel = new TrainInfoGridPanel();
		TrainPanel.superclass.constructor.call(this,{
			style: 'margin:0 auto',
			border: false,
			//layout: 'fit',
			//autoWidth: true,
			//autorHeight: true,
			items: [trainQueryPanel, trainInfoGridPanel]
		})
	}
})