TrainGridWin = Ext.extend(Ext.Window,{
	id: 'trainGridWinId',
	constructor: function(){
		var trainGridPanel = new TrainGridPanel();
		TrainGridWin.superclass.constructor.call(this, {
			width: 550,
			height: 350,
			resizable: false, //不能改变窗体大小 
			title: '培训信息',
			collapsible: true,
			modal: true,
			items: [trainGridPanel]
		})
	}
});

TrainGridPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'trainGridId',
	constructor: function(){
		Ext.QuickTips.init();
		var number = new Ext.grid.RowNumberer();
		var cm = new Ext.grid.ColumnModel([
			number,
		{
			header: '编号',
			dataIndex: 'trainId',
			align: 'center',
			renderer: this.renderFn
		},{
			header: '培训人',
			dataIndex: 'trainPerson',
			align: 'center',
			renderer: this.renderFn
		},{
			header: '培训时间',
			dataIndex: 'trainDate',
			align: 'center',
			renderer: this.renderFn
		},{
			header: '培训主题',
			dataIndex: 'trainTitle',
			align: 'center',
			renderer: this.renderFn
		},{
			header: '培训地点',
			dataIndex: 'trainPlace',
			align: 'center',
			renderer: this.renderFn
		}]);
		var trainStore = new Ext.data.JsonStore({
			url: 'train_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['trainId','trainPerson','trainDate','trainTitle','trainPlace']
		});
		TrainGridPanel.superclass.constructor.call(this, {
			viewConfig: {
				forceFit: true,
				autoFill: true,
				columnsText : "显示/隐藏列",
                sortAscText : "正序排列",
                sortDescText : "倒序排列"
			},
			border: false,
			height: 320,
			frame: true,
			cm: cm,
			store: trainStore,
			listeners:{"rowdblclick" : function(grid, rowIndex, e){
				    var rowdata = grid.getStore().getAt(rowIndex).data;
                   Ext.getDom('trainId').value = rowdata.trainId; 
                   Ext.getDom('title').value = rowdata.trainTitle;
                   Ext.getCmp('trainGridWinId').destroy();
                }
            },
			bbar: new PagingToolbar(trainStore,10)
		});
		trainStore.load({
			params: {
				start: 0,
				limit: 10
			}
		});
	},
	renderFn: function(value){
				return "<span ext:qtip= '双击选取'>" + value + "</span>";
			}
});