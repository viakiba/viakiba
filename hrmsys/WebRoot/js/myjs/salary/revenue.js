/**
 * 税率信息
 * @author sux 2011-02-22
 * @memberOf {TypeName} 
 */
var Revenue = Ext.extend(Ext.grid.EditorGridPanel,{
	id: 'revenueId',
	constructor: function(){
		Ext.form.Field.prototype.msgTarget = 'title';
		var number = new Ext.grid.RowNumberer();
		var sm = new Ext.grid.CheckboxSelectionModel();
		var revenueStore = new Ext.data.JsonStore({
			url: 'revenue_edit.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['reId','reMin','reMax','rePercent','reMinus']
		});
		var cm = new Ext.grid.ColumnModel([
			number, sm,
		{
			header: '编号',
			dataIndex: 'reId',
			align: 'center'
		},{
			header: '最小值',
			dataIndex: 'reMin',
			align: 'center',
			editor: new Ext.form.NumberField({
				allowBlank: false,
				blankText: '不能为空'
			})
		},{
			header: '最大值',
			dataIndex: 'reMax',
			align: 'center',
			editor: new Ext.form.NumberField({
				allowBlank: false,
				blankText: '不能为空'
			})
		},{
			header: '税率',
			dataIndex: 'rePercent',
			align: 'center',
			editor: new Ext.form.NumberField({
				allowBlank: false,
				blankText: '不能为空'
			})
		},{
			header: '速算减值',
			dataIndex: 'reMinus',
			align: 'center',
			editor: new Ext.form.NumberField({
				allowBlank: false,
				blankText: '不能为空'
			})
		}]);
		Revenue.superclass.constructor.call(this, {
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
				forceFit: true
			},
			sm: sm,
			cm: cm,
			store: revenueStore,
			tbar: new Ext.Toolbar({
				items: [{
					text: '删除',
					iconCls: 'delete',
					id: 'reve_delete',
					hidden: 'true',
					handler: delRevenueFn
				},{
					text: '新增',
					iconCls: 'add',
					id: 'reve_add',
					hidden: 'true',
					handler: newRevenueFn
				},{
					text: '保存或修改',
					iconCls: 'save',
					id: 'reve_saveorupdate',
					hidden: 'true',
					handler: modifyRevenueFn
				}]
			}),
			bbar: new PagingToolbar(revenueStore, 20)
		});
		revenueStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});
delRevenueFn = function(){
	gridDel('revenueId', 'reId','revenue_delete.action');
	
};

newRevenueFn = function(){
	var DefaultRecord = new Ext.data.Record.create([{name: 'reId', mapping: 0},{name: 'reMin', mapping: 1},
		{name: 'reMax', mapping: 2},{name: 'rePercent', mapping: 3},{name: 'reMinus', mapping: 4}]);
	var num = Ext.getCmp('revenueId').getStore().getCount();
	var newRecord = new DefaultRecord({
		reId: num+1,
		reMin: '',
		reMax: '',
		rePercent: '',
		reMinus: ''
	});
	Ext.getCmp('revenueId').getStore().insert(0,newRecord);	
};

modifyRevenueFn = function(){
	var modifiedRecords = Ext.getCmp('revenueId').getStore().getModifiedRecords();
	var revenues = reRevenueJson(modifiedRecords);
	Ext.Ajax.request({
		url: 'revenue_modify.action',
		waitTitle: '提示',
		waitMsg: '正在保存数据...',
		method: 'post',
		params: {
			json: revenues
		},
		success: reModifySuccessFn,
		failure: reModifyfailureFn
	})
};
reModifySuccessFn = function(response, options){
	var datas = Ext.util.JSON.decode(response.responseText);
	Ext.Msg.alert('提示',datas.msg,function(){
		Ext.getCmp('revenueId').getStore().load({
			params: {
				start: 0,
				limit: 20
			}
		});
	});
};
reModifyfailureFn = function(response, options){
	Ext.Msg.alert('提示','连接失败',function(){})
};
reRevenueJson = function(modifiedRecords){
	var count = modifiedRecords.length;
	var revenues='';
	//有修改
	if(count > 0){
		revenues = "[";
		for(i=0; i<count; i++){
			revenues += "{";
			var reId = modifiedRecords[i].get('reId');
			var reMin = modifiedRecords[i].get('reMin');
			var reMax = modifiedRecords[i].get('reMax');
			var rePercent = modifiedRecords[i].get('rePercent');
			var reMinus = modifiedRecords[i].get('reMinus');
			revenues += '"reId":'+reId+', "reMin":'+reMin+',"reMax":'+reMax+',"rePercent":'+rePercent+',"reMinus":'+reMinus+'}';
			if( i != count-1)
				revenues += ","
		}
		revenues += "]"
	}
	return revenues;
}