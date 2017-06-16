Ext.namespace("hrmsys.trainRecord.info");
/**
 * 培训记录信息表格
 * @author sux 2011-02-19
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
TRecordInfoGridPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'tRecordInfoGridId',
	constructor: function(){
		Ext.QuickTips.init();
		var sm = new Ext.grid.CheckboxSelectionModel();
		var number = new Ext.grid.RowNumberer();
		var cm = new Ext.grid.ColumnModel([
			number, sm,
		{
			header: '编号',
			dataIndex: 'tRecordId',
			align: 'center'
		},{
			header: '培训对象',
			dataIndex: 'empName',
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
		},{
			header: '结果',
			dataIndex: 'trainResult',
			align: 'center',
			renderer: function(value){
				if(value == 0){
					return "未参加";
				}else if( value == 1){
					return "优秀";
				}else if( value == 2){
					return "良好";
				}else if( value == 3){
					return "及格";
				}else if( value == 4){
					return "不及格";
				}
			}
		}]);
		var trainStore = new Ext.data.JsonStore({
			url: 'tRecord_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['tRecordId','empName','trainPerson','trainDate','trainTitle','trainPlace','trainResult']
		});
		TRecordInfoGridPanel.superclass.constructor.call(this, {
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
					id: 'trainr_delete',
					hidden: 'true',
					handler: delTRecordFn
				},{
					text: '添加',
					iconCls: 'add',
					id: 'trainr_add',
					hidden: 'true',
					handler: addTRecordFn
				},{
					text: '修改',
					iconCls: 'update',
					id: 'trainr_update',
					hidden: 'true',
					handler: updateTRecordFn
				},{
					text: '详情',
					iconCls: 'detail',
					id: 'trainr_detail',
					hidden: 'true',
					handler: detailTRecordFn
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
delTRecordFn = function(){
	gridDel('tRecordInfoGridId','tRecordId','tRecord_delete.action');
};
addTRecordFn = function(){
	var trainRecordAddWin = new TrainRecordAddWin()
	trainRecordAddWin.show();
}

/**
 * 培训记录查询面板
 * @memberOf {TypeName} 
 * @author sux 2011-02-19
 */
var TRecordQueryPanel = Ext.extend(Ext.Panel,{
	id: 'tRecordQueryId',
	constructor: function(){
		TRecordQueryPanel.superclass.constructor.call(this,{
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
					columns: 7
				},
				defaults: {
					labelWidth: 60,
					labelAlign: 'right'
				},
				items: [{
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '培训对象',
						id: 'empName',
						width: 100
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '培训人',
						width: 100,
						id: 'trainPerson'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '培训主题',
						width: 100,
						id: 'trainTitle'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'datefield',
						fieldLabel: '开始时间',
						format: 'Y-m-d',
						width: 100,
						id: 'startDate'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'datefield',
						fieldLabel: '结束时间',
						format: 'Y-m-d',
						width: 100,
						id: 'endDate'
					}]
				},{
					style: 'margin: 0px 10px 0px 20px;',
					xtype: 'button',
					text: '查询',
					iconCls: 'search',
					handler: queryTRecordFn
				},{
					xtype: 'button',
					text: '取消',
					iconCls: 'cancel',
					handler: cancelTRecordFn
				}]
			}]
		})
	}
});
queryTRecordFn = function(){
	var empName = Ext.get("empName").dom.value;
	var trainPerson = Ext.get("trainPerson").dom.value;
	var trainTitle = Ext.get("trainTitle").dom.value;
	var startDate = Ext.get("startDate").dom.value;
	var endDate = Ext.get("endDate").dom.value;
	Ext.getCmp('tRecordInfoGridId').getStore().load({
		params: {
			type: 'query',
			empName: empName,
			startDate: startDate,
			endDate: endDate,
			trainTitle: trainTitle,
			trainPerson: trainPerson,
			start: 0,
			limit: 20
		}
	})
};
cancelTRecordFn = function(){
	Ext.get("empName").dom.value = "";
	Ext.get("trainPerson").dom.value = "";
	Ext.get("trainTitle").dom.value = "";
	Ext.get("startDate").dom.value = "";
	Ext.get("endDate").dom.value = "";
};
updateTRecordFn = function(){
	var trainRecordAddWin = new TrainRecordAddWin()
	trainRecordAddWin.title = '培训记录修改';
		var selectionModel = Ext.getCmp('tRecordInfoGridId').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var tRecordId = record[0].get('tRecordId');
		Ext.getCmp('tRecordAddPanelId').getForm().load({
			url: 'tRecord_edit.action',
			params: {
				trainRecordId: tRecordId
			}
		})
	trainRecordAddWin.show();
};
detailTRecordFn = function(){
	var trainRecordDetailWin = new TrainRecordDetailWin()
		var selectionModel = Ext.getCmp('tRecordInfoGridId').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var tRecordId = record[0].get('tRecordId');
		Ext.getCmp('tRecordDetailPanelId').getForm().load({
			url: 'tRecord_edit.action',
			params: {
				trainRecordId: tRecordId
			}
		})
	trainRecordDetailWin.show();
};