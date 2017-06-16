/**
 * 工资记录信息表格
 * @author sux 2011-02-24
 * @memberOf {TypeName} 
 */
Ext.namespace("hrmsys.salaryInfo");
SalaryInfoGridPanel = Ext.extend(Ext.grid.GridPanel,{
	id: 'salaryInfoGridId',
	constructor: function(){
		Ext.QuickTips.init();
		var sm = new Ext.grid.CheckboxSelectionModel();
		var number = new Ext.grid.RowNumberer();
		var cm = new Ext.grid.ColumnModel([
			number, sm,
		{
			header: '编号',
			dataIndex: 'salId',
			align: 'center'
		},{
			header: '员工工号',
			dataIndex: 'employee',
			align: 'center',
			renderer: function(v){
				return v.empId;
			}
		},{
			header: '员工姓名',
			dataIndex: 'employee',
			align: 'center',
			renderer: function(v){
				return v.empName
			}
		},{
			header: '年份',
			dataIndex: 'salYear',
			align: 'center'
		},{
			header: '月份',
			dataIndex: 'salMonth',
			align: 'center'
		},{
			header: '实发工资',
			dataIndex: 'salMoney',
			align: 'center',
			renderer: function(value){
				return value.toFixed(2); //控制两位小数
			}
		},{
			header: '发布人',
			dataIndex: 'salReleasePerson',
			align: 'center'
		},{
			header: '发布时间',
			dataIndex: 'salReleaseDate',
			align: 'center',
			renderer: Ext.util.Format.dateRenderer('Y-m-d')
		}]);
		var salaryInfoStore = new Ext.data.JsonStore({
			url: 'salary_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['salId','employee','salMonth','salMoney','salReleasePerson','salYear',
				{name: 'salReleaseDate', mapping: 'salReleaseDate.time', dateFormat : 'time', type: 'date' }]
		});
		SalaryInfoGridPanel.superclass.constructor.call(this, {
			width: Ext.getCmp('mainTab').getActiveTab().getInnerWidth(),
			height: Ext.getCmp('mainTab').getActiveTab().getInnerHeight(),
			/**表格高度自适应 document.body.clientHeight浏览器页面高度 start**/
			monitorResize: true, 
			doLayout: function() { 
				this.setWidth(document.body.clientWidth-205);
				this.setHeight(document.body.clientHeight-140);
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
			//height: 500,
			frame: true,
			cm: cm,
			sm: sm,
			store: salaryInfoStore,
			tbar: new Ext.Toolbar({
				items: ['条目:',{
					xtype: 'combo',
					mode: 'local',//加载本地数据，必须加入
					store: new Ext.data.SimpleStore({
						fields: ['name','value'],
						data: [["",""],['empId','工号'],['empName','姓名']]
					}),
					displayField: 'value',
					valueField: 'name',
					id: 'sal_condition',
					width: 50,
					autoLoad: true,
					listWidth: 50,
					editable: false,
					triggerAction: 'all'
				},'内容:',{
					xtype: 'textfield',
					id: 'sal_conditionValue',
					width: 80
				},'月份:',{
					xtype: 'textfield',
					id: 'sal_month',
					width: 80
				},{
					text: '查询',
					iconCls: 'search',
					handler: querySalaryFn
				},{
					text: '显示全部',
					iconCls: 'all',
					handler: function(){
						salaryInfoStore.load();
					}
				},{
					text: '删除',
					iconCls: 'delete',
					id: 'sal_delete',
					hidden: 'true',
					handler: delSalaryFn
				},{
					text: '修改',
					id: 'sal_update',
					hidden: 'true',
					iconCls: 'update',
					handler: updateSalaryFn
				},{
					text: '详情',
					id: 'sal_detail',
					hidden: 'true',
					iconCls: 'detail',
					handler: detailSalaryFn
				}]
			}),
			bbar: new PagingToolbar(salaryInfoStore,20)
		});
		salaryInfoStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});
delSalaryFn = function(){
	gridDel('salaryInfoGridId','salId','salary_delete.action');
};
querySalaryFn = function(){
	var condition = Ext.getCmp('sal_condition').getValue();
	var conditionValue = Ext.getCmp('sal_conditionValue').getValue();
	var salMonth = Ext.getCmp('sal_month').getValue();
	Ext.getCmp('salaryInfoGridId').getStore().load({
		params: {
			type: 'query',
			condition: condition,
			conditionValue: conditionValue,
			salMonth : salMonth,
			start: 0,
			limit: 20
		}
	});
};
detailSalaryFn = function(){
	var salaryDetailWin = new SalaryDetailWin();
	var selectionModel = Ext.getCmp('salaryInfoGridId').getSelectionModel();
	var record = selectionModel.getSelections();
	if(record.length != 1){
		Ext.Msg.alert('提示','请选择一个');
		return;
	}
	var salId = record[0].get('salId');
	Ext.getCmp('salaryDetailPanelId').getForm().load({
		url: 'salary_intoUpdate.action',
		params: {
			salId: salId
		}
	});
	salaryDetailWin.show();
};
updateSalaryFn = function(){
	//因为和录入共用同一界面，所以在打修改界面时移除出录入界面，否则发生混乱
	Ext.getCmp('mainTab').remove(Ext.getCmp('tab_23'));
	var salaryAddPanel = new SalaryAddPanel();
	var salaryUpdateWin = new Ext.Window({
		id: 'salaryUpdateWinId',
		width: 1080,
		height: 550,
		title: '员工工资修改',
		items: [salaryAddPanel]
	});
	var selectionModel = Ext.getCmp('salaryInfoGridId').getSelectionModel();
	var record = selectionModel.getSelections();
	if(record.length != 1){
		Ext.Msg.alert('提示','请选择一个');
		return;
	};
	var salId = record[0].get('salId');
	Ext.getCmp('salaryAddPanelId').getForm().load({
		url: 'salary_intoUpdate.action',
		params: {
			salId: salId
		}
	});
	//alert(Ext.get('salEmpId').dom.value);
	salaryUpdateWin.show();
};