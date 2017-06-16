Ext.namespace("hrmsys.encouragePunish.info");

var EPunishGridPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'ePunishGridPanelId',
	constructor: function(){
		Ext.QuickTips.init();
		var sm = new Ext.grid.CheckboxSelectionModel();
		var number = new Ext.grid.RowNumberer();
		var cm = new Ext.grid.ColumnModel([
			number, sm,
		{
			header: '编号',
			dataIndex: 'epId',
			align: 'center'
		},{
			header: '员工姓名',
			dataIndex: 'employee',
			align: 'center'
		},{
			header: '类别',
			dataIndex: 'epType',
			align: 'center',
			renderer: function(value){
				if(value == 0) return "奖励";
				return "惩罚";
			}
		},{
			header: '主题',
			dataIndex: 'epTopic',
			align: 'center'
		},{
			header: '奖惩金额',
			dataIndex: 'epMoney',
			align: 'center'
		},{
			header: '其它奖惩',
			dataIndex: 'epOther',
			align: 'center',
			renderer: Ext.hrmsys.grid.tooltip.subLength
		}]);
		var ePunishStore = new Ext.data.JsonStore({
			url: 'ePunish_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['epId',{name: 'employee', convert: function(v){return v.empName}},'epType','epTopic','epMoney','epOther','epStatus']
		});
		EPunishGridPanel.superclass.constructor.call(this, {
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
			store: ePunishStore,
			tbar: new Ext.Toolbar({
				items: [{
					text: '显示全部',
					iconCls: 'all',
					handler: function(){
						ePunishStore.load();
					}
				},{
					text: '删除',
					iconCls: 'delete',
					id: 'ePunish_delete',
					hidden: 'true',
					handler: ePunishDelFn
				},{
					text: '添加',
					iconCls: 'add',
					id: 'ePunish_add',
					hidden: 'true',
					handler: ePunishAddFn
				},{
					text: '修改',
					iconCls: 'update',
					id: 'ePunish_update',
					hidden: 'true',
					handler: ePunishUpdateFn
				},{
					text: '详情',
					iconCls: 'detail',
					id: 'ePunish_detail',
					hidden: 'true',
					handler: ePunishDetailFn
				}]
			}),
			bbar: new PagingToolbar(ePunishStore,20)
		});
		ePunishStore.load({
			params: {
				start: 0,
				limit: 20
			}});
	}
});
ePunishDelFn = function(){
	gridDel('ePunishGridPanelId','epId','ePunish_delete.action');
};
ePunishAddFn = function(){
	var ePunishAddWin = new EPunishAddWin();
	ePunishAddWin.show();
}

/**
 * 查询面板
 * @author sux 2011-02-21
 * @memberOf {TypeName} 
 */
var EPunishQueryPanel = Ext.extend(Ext.Panel,{
	id: 'ePunishQueryId',
	constructor: function(){
		EPunishQueryPanel.superclass.constructor.call(this,{
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
						xtype: 'combo',
						fieldLabel: '条目',
						width: 100,
						mode: 'local',
						triggerAction: 'all',
						editable: false,
						store: new Ext.data.SimpleStore({
							fields: ['name', 'value'],
							data: [["无",""],["员工编号","empId"],["员工姓名","empName"]]
						}),
						displayField: 'name',
						valueField: 'value',
						id: 'epEmp'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '内容',
						width: 100,
						id: 'epContent'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'textfield',
						fieldLabel: '主题',
						width: 100,
						id: 'epTitle'
					}]
				},{
					layout: 'form',
					items: [{
						xtype: 'combo',
						fieldLabel: '类别',
						width: 100,
						triggerAction: 'all',
						mode: 'local',
						editable: false,
						store: new Ext.data.SimpleStore({
							fields: ['name','value'],
							data: [["无",""],["奖励","0"],["惩罚","1"]]
						}),
						displayField: 'name',
						valueField: 'value',
						id: 'epType'
					}]
				},{
					style: 'margin: 0px 10px 0px 20px;',
					xtype: 'button',
					text: '查询',
					iconCls: 'search',
					handler: epQueryFn
				},{
					xtype: 'button',
					text: '取消',
					iconCls: 'cancel',
					handler: epCancelFn
				}]
			}]
		})
	}
});
epQueryFn = function(){
	var epEmp = Ext.getCmp("epEmp").getValue();
	var epContent = Ext.getCmp("epContent").getValue();
	var epTitle = Ext.getCmp("epTitle").getValue();
	var epType = Ext.getCmp("epType").getValue();
	Ext.getCmp("ePunishGridPanelId").getStore().load({
		params: {
			type: "query",
			empIdOrName: epEmp,
			empValue: epContent,
			epTitle: epTitle,
			epType: epType,
			start: 0,
			limit: 20
		}
	});
};
epCancelFn = function(){
	Ext.getCmp("epEmp").setValue("");
	Ext.get("epContent").dom.value = "";
	Ext.get("epTitle").dom.value = "";
	Ext.getCmp("epType").setValue("");
};
ePunishUpdateFn = function(){
	var ePunishAddWin = new EPunishAddWin();
	ePunishAddWin.title = '奖惩信息修改';
		var selectionModel = Ext.getCmp('ePunishGridPanelId').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var epId = record[0].get('epId');
		Ext.getCmp('ePunishAddPanelId').getForm().load({
			url: 'ePunish_edit.action',
			params: {
				epId: epId
			}
		})
	ePunishAddWin.show();
};
ePunishDetailFn = function(){
	var ePunishDetailWin = new EPunishDetailWin();
		var selectionModel = Ext.getCmp('ePunishGridPanelId').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var epId = record[0].get('epId');
		Ext.getCmp('ePunishDetailPanelId').getForm().load({
			url: 'ePunish_edit.action',
			params: {
				epId: epId
			}
		})
	ePunishDetailWin.show();
};
