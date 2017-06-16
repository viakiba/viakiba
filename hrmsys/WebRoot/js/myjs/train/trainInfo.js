/**
 * 培训信息表格
 * @author sux 2011-02-20
 * @memberOf {TypeName} 
 */
TrainInfoGridPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'trainInfoGridId',
	constructor: function(){
		Ext.QuickTips.init();
		var sm = new Ext.grid.CheckboxSelectionModel();
		var number = new Ext.grid.RowNumberer();
		var cm = new Ext.grid.ColumnModel([
			number, sm,
		{
			header: '编号',
			dataIndex: 'trainId',
			align: 'center'
		},{
			header: '培训人',
			dataIndex: 'trainPerson',
			align: 'center'
		},{
			header: '培训时间',
			dataIndex: 'trainDate',
			align: 'center'
		},{
			header: '培训主题',
			dataIndex: 'trainTitle',
			align: 'center'
		},{
			header: '培训地点',
			dataIndex: 'trainPlace',
			align: 'center'
		}]);
		var trainStore = new Ext.data.JsonStore({
			url: 'train_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['trainId','trainPerson','trainDate','trainTitle','trainPlace']
		});
		TrainInfoGridPanel.superclass.constructor.call(this, {
			width: Ext.getCmp('mainTab').getActiveTab().getInnerWidth(),
			height: Ext.getCmp('mainTab').getActiveTab().getInnerHeight(),
			/**表格高度自适应 document.body.clientHeight浏览器页面高度 start**/
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-250);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			} ,
			viewConfig: {
				forceFit: true,
				autoFill: true,
				columnsText : "显示/隐藏列",
                sortAscText : "正序排列",
                sortDescText : "倒序排列"
			},
			border: false,
			height: 500,
			frame: true,
			cm: cm,
			sm: sm,
			store: trainStore,
			tbar: new Ext.Toolbar({
				items: [{
					text: '显示全部',
					iconCls: 'all',
					handler: function(){
						trainStore.load();
					}
				},{
					text: '删除',
					iconCls: 'delete',
					id: 'train_delete',
					hidden: 'true',
					handler: delTrainFn
				},{
					text: '添加',
					iconCls: 'add',
					id: 'train_add',
					hidden: 'true',
					handler: addTrainFn
				},{
					text: '修改',
					iconCls: 'update',
					id: 'train_update',
					hidden: 'true',
					handler: editTrainFn
				},{
					text: '详情',
					iconCls: 'detail',
					id: 'train_detail',
					hidden: 'true',
					handler: detailTrainFn
				}]
			}),
			bbar: new PagingToolbar(trainStore,20)
		});
		trainStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});
delTrainFn = function(){
	gridDel('trainInfoGridId','trainId','train_delete.action');
};
addTrainFn = function(){
	var trainAddWin = new TrainAddWin();
	trainAddWin.show();
};
detailTrainFn = function(){
	var trainDetailWin = new TrainDetailWin();
	trainDetailWin.title = '招聘信息';
	var selectionModel = Ext.getCmp('trainInfoGridId').getSelectionModel();
	var record = selectionModel.getSelections();
	if(record.length != 1){
		Ext.Msg.alert('提示','请选择一个');
		return;
	}
	var trainId = record[0].get('trainId');
	Ext.getCmp('trainDetailPanelId').getForm().load({
		url: 'train_intoUpdate.action',
		params: {
			trainId: trainId
		}
	})
	trainDetailWin.show();
};
editTrainFn = function(){
	var trainAddWin = new TrainAddWin();
	trainAddWin.title = '招聘信息修改';
	var selectionModel = Ext.getCmp('trainInfoGridId').getSelectionModel();
	var record = selectionModel.getSelections();
	if(record.length != 1){
		Ext.Msg.alert('提示','请选择一个');
		return;
	}
	var trainId = record[0].get('trainId');
	Ext.getCmp('trainAddPanelId').getForm().load({
		url: 'train_intoUpdate.action',
		params: {
			trainId: trainId
		}
	})
	trainAddWin.show();
};
/**
 * 按条件查询面板
 * @author sux 2011-02-20
 * @memberOf {TypeName} 
 */
var TrainQueryPanel = Ext.extend(Ext.Panel,{
	id: 'trainQueryId',
	constructor: function(){
		TrainQueryPanel.superclass.constructor.call(this,{
			collapsible: true,
			titleCollapse: true, //单击整个collapse都有效
			//collapsed: true, //渲染后即闭合
			title: '条件查询',
			border: false,
			frame: true,
			autoWidth: true,
			defaultType: 'fieldset',
			items: [{
				title: '条件',
				layout: 'table',
				layoutConfig: {
					columns: 6
				},
				defaults: {
					labelWidth: 60,
					labelAlign: 'right'
				},
				items: [{
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '培训人',
						width: 100,
						id: 'train_person'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '培训主题',
						width: 100,
						id: 'train_title'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'datefield',
						fieldLabel: '开始时间',
						format: 'Y-m-d',
						width: 100,
						id: 'start_date'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'datefield',
						fieldLabel: '结束时间',
						format: 'Y-m-d',
						width: 100,
						id: 'end_date'
					}]
				},{
					style: 'margin: 0px 10px 0px 20px;',
					xtype: 'button',
					text: '查询',
					iconCls: 'search',
					handler: queryTrainFn
				},{
					xtype: 'button',
					text: '取消',
					iconCls:'cancel',
					handler: cancelTrainFn
				}]
			}]
		})
	}
});

queryTrainFn = function(){
	var trainPerson = Ext.get("train_person").dom.value;
	var trainTitle = Ext.get("train_title").dom.value;
	var startDate = Ext.get("start_date").dom.value;
	var endDate = Ext.get("end_date").dom.value;
	Ext.getCmp('trainInfoGridId').getStore().load({
		params: {
			type: 'query',
			startDate: startDate,
			endDate: endDate,
			trainTitle: trainTitle,
			trainPerson: trainPerson,
			start: 0,
			limit: 20
		}
	})
};
cancelTrainFn = function(){
	Ext.get("train_person").dom.value = "";
	Ext.get("train_title").dom.value = "";
	Ext.get("start_date").dom.value = "";
	Ext.get("end_date").dom.value = "";
};

