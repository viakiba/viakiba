/**
 * 招聘信息管理模块
 * @memberOf {TypeName} 
 */
RecruitmentPanel = Ext.extend(Ext.Panel,{
	id: 'recruitmentPanelId',
	constructor: function(){
		var recruitmentGridPanel = new RecruitmentGridPanel();
		var recQueryPanel = new RecQueryPanel();
		RecruitmentPanel.superclass.constructor.call(this, {
			items: [recQueryPanel,recruitmentGridPanel]
		})
	}
});
/**
 * 招聘信息列表
 * @author sux
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
RecruitmentGridPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'recruitmentGridId',
	constructor: function(){
		var rmStore = new Ext.data.JsonStore({
			url: 'rec_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['recId','recTitle','recJob','recNum', 
				{name: 'recDate', mapping: 'recDate	.time', dateFormat : 'time', type: 'date' }]
		});
		var rowNumber = new Ext.grid.RowNumberer(); //序列号	
		var sm = new Ext.grid.CheckboxSelectionModel(); 
		var cm = new Ext.grid.ColumnModel([
			rowNumber, sm, 
		{
			header: '编号',
			dataIndex: 'recId',
			align: 'center'
		},{
			header: '标题',
			dataIndex: 'recTitle',
			align: 'center'
		},{
			header: '职位',
			dataIndex: 'recJob',
			align: 'center'
		},{
			header: '人数',
			dataIndex: 'recNum',
			align: 'center'
		},{
			header: '发布日期',
			align: 'center',
			renderer: Ext.util.Format.dateRenderer('Y-m-d'), //有用
			dataIndex: 'recDate'
		}]);
		RecruitmentGridPanel.superclass.constructor.call(this,{
			width: Ext.getCmp('mainTab').getActiveTab().getInnerWidth(),
			height: Ext.getCmp('mainTab').getActiveTab().getInnerHeight(),
			/**表格高度自适应 document.body.clientHeight浏览器页面高度 start**/
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-250);
				Ext.grid.GridPanel.prototype.doLayout.call(this); 
			} ,
			border: false,
			viewConfig: {
				forceFit: true
			},
			height: 430,
			cm: cm,
			sm: sm,
			store: rmStore,
			tbar: new Ext.Toolbar({
				items: [
				{
					text: '删除',
					iconCls: 'delete',
					id: 'rec_delete',
					hidden: 'true',
					handler: recruitmentDelFn
				},{
					text: '添加',
					iconCls: 'add',
					id: 'rec_add',
					hidden: 'true',
					handler: recruitmentInfoAddFn
				},{
					text: '修改',
					iconCls: 'update',
					id: 'rec_update',
					hidden: 'true',
					handler: recruitmentInfoUpdateFn
				},{
					text: '详情',
					iconCls: 'detail',
					id: 'rec_detail',
					hidden: 'true',
					handler: recruitmentInfoDetailFn
				}]
			}),
			bbar:new PagingToolbar(rmStore, 20) 
		});
		rmStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});
recruitmentInfoAddFn = function(){
	var recruitmentAddWin = new RecruitmentAddWin();
	recruitmentAddWin.show();
};
recruitmentInfoUpdateFn = function(){
	var recruitmentAddWin = new RecruitmentAddWin();
	recruitmentAddWin.title = '招聘信息修改';
	var selectionModel = Ext.getCmp('recruitmentGridId').getSelectionModel();
	var record = selectionModel.getSelections();
	if(record.length != 1){
		Ext.Msg.alert('提示','请选择一个');
		return;
	}
	var recId = record[0].get('recId');
	Ext.getCmp('recruitmentAddPanelId').getForm().load({
		url: 'recruitment_intoUpdate.action',
		params: {
			recId: recId
		}
	})
	recruitmentAddWin.show();
};
recruitmentInfoDetailFn = function(){
	var recruitmentDetailWin = new RecruitmentDetailWin();
	recruitmentDetailWin.title = '招聘信息';
	var selectionModel = Ext.getCmp('recruitmentGridId').getSelectionModel();
	var record = selectionModel.getSelections();
	if(record.length != 1){
		Ext.Msg.alert('提示','请选择一个');
		return;
	}
	var recId = record[0].get('recId');
	Ext.getCmp('recruitmentDetailPanelId').getForm().load({
		url: 'recruitment_intoUpdate.action',
		params: {
			recId: recId
		}
	})
	recruitmentDetailWin.show();
};
recruitmentDelFn = function(){
	gridDel('recruitmentGridId','recId', 'recruitment_delete.action');
};
/**
 * 按条件查询面板
 * @author sux 2011-02-20
 * @memberOf {TypeName} 
 */
RecQueryPanel = Ext.extend(Ext.form.FormPanel,{
	id: 'recQueryId',
	constructor: function(){
		RecQueryPanel.superclass.constructor.call(this,{
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
						fieldLabel: '标题',
						width: 100,
						id: 'recTitle'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '职位',
						width: 100,
						id: 'recJob'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'datefield',
						fieldLabel: '查询日期',
						format: 'Y-m-d',
						editable: false,
						width: 100,
						id: 'recStartDate'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'datefield',
						fieldLabel: '至',
						format: 'Y-m-d',
						editable: false,
						width: 100,
						id: 'recEndDate'
					}]
				},{
					style: 'margin: 0px 10px 0px 20px;',
					xtype: 'button',
					text: '查询',
					iconCls: 'search',
					handler: queryRecFn
				},{
					xtype: 'button',
					text: '取消',
					iconCls: 'cancel',
					handler: cancelRecFn
				}]
			}]
		})
	}
});
queryRecFn = function(){
	var recTitle = Ext.get('recTitle').dom.value;
	var recJob = Ext.get('recJob').dom.value;
	var startDate = Ext.get('recStartDate').dom.value;
	var endDate = Ext.get('recEndDate').dom.value;
	Ext.getCmp('recruitmentGridId').getStore().load({
		params: {
			type: 'query',
			recTitle: recTitle,
			recJob: recJob,
			startDate: startDate,
			endDate: endDate,
			start: 0,
			limit: 20
		}
	});
};
cancelRecFn = function(){
	Ext.getCmp('recQueryId').getForm().reset();
}