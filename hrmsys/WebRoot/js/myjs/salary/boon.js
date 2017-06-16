/**
 * 福利信息
 * @author sux 2011-02-23
 * @memberOf {TypeName} 
 */
var Boon = Ext.extend(Ext.grid.EditorGridPanel,{
	id: 'boonId',
	constructor: function(){
		Ext.form.Field.prototype.msgTarget = 'title';
		var number = new Ext.grid.RowNumberer();
		var sm = new Ext.grid.CheckboxSelectionModel();
		var boonStore = new Ext.data.JsonStore({
			url: 'boon_edit.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['boonId','boonName','boonMoney','boonPercent','boonRmark']
		});
		var cm = new Ext.grid.ColumnModel([
			number, sm,
		{
			header: '编号',
			dataIndex: 'boonId',
			align: 'center'
		},{
			header: '名称',
			dataIndex: 'boonName',
			align: 'center',
			editor: new Ext.form.TextField({
				allowBlank: false,
				blankText: '不能为空'
			})
		},{
			header: '总额',
			dataIndex: 'boonMoney',
			align: 'center',
			editor: new Ext.form.NumberField({
				allowBlank: false,
				blankText: '不能为空'
			})
		},{
			header: '百分比',
			dataIndex: 'boonPercent',
			align: 'center',
			editor: new Ext.form.NumberField({
				allowBlank: false,
				blankText: '不能为空'
			})
		},{
			header: '备注',
			dataIndex: 'boonRemark',
			align: 'center',
			editor: new Ext.form.TextArea()
		}]);
		Boon.superclass.constructor.call(this, {
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
			store: boonStore,
			tbar: new Ext.Toolbar({
				items: [{
					text: '删除',
					iconCls: 'delete',
					id: 'boon_delete',
					hidden: 'true',
					handler: delBoonFn
				},{
					text: '新增',
					id: 'boon_add',
					hidden: 'true',
					iconCls: 'add',
					handler: newBoonFn
				},{
					text: '保存或修改',
					iconCls: 'save',
					id: 'boon_saveorupdate',
					hidden: 'true',
					handler: modifyBoonFn
				}]
			}),
			bbar: new PagingToolbar(boonStore, 20)
		});
		boonStore.load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});
delBoonFn = function(){
	gridDel('boonId', 'boonId','boon_delete.action');
	
};

newBoonFn = function(){
	var DefaultRecord = new Ext.data.Record.create([{name: 'boonId', mapping: 0},{name: 'boonName', mapping: 1},
		{name: 'boonMoney', mapping: 2},{name: 'boonPercent', mapping: 3},{name: 'boonRemark', mapping: 4}]);
	var num = Ext.getCmp('boonId').getStore().getCount();
	var newRecord = new DefaultRecord({
		boonId: num+1,
		boonName: '',
		boonMoney: '',
		boonPercent: '',
		boonRemark: ''
	});
	Ext.getCmp('boonId').getStore().insert(0,newRecord);	
};

modifyBoonFn = function(){
	var modifiedRecords = Ext.getCmp('boonId').getStore().getModifiedRecords();
	var boons = reJson(modifiedRecords);
	Ext.Ajax.request({
		url: 'boon_modify.action',
		waitTitle: '提示',
		waitMsg: '正在保存数据...',
		method: 'post',
		params: {
			json: boons
		},
		success: boonModifySuccessFn,
		failure: boonModifyfailureFn
	})
};
boonModifySuccessFn = function(response, options){
	var datas = Ext.util.JSON.decode(response.responseText);
	Ext.Msg.alert('提示',datas.msg,function(){
		Ext.getCmp('boonId').getStore().load({
			params: {
				start: 0,
				limit: 20
			}
		});
	});
};
boonModifyfailureFn = function(response, options){
	Ext.Msg.alert('提示','连接失败',function(){})
};
reJson = function(modifiedRecords){
	var count = modifiedRecords.length;
	var boons='';
	//有修改或保存
	if(count > 0){
		boons = "[";
		for(i=0; i<count; i++){
			boons += "{";
			var boonId = modifiedRecords[i].get('boonId');
			var boonName = modifiedRecords[i].get('boonName');
			var boonMoney = modifiedRecords[i].get('boonMoney');
			var boonPercent = modifiedRecords[i].get('boonPercent');
			var boonRemark = modifiedRecords[i].get('boonRemark');
			boons += '"boonId":'+boonId+', "boonName":"'+boonName+'","boonMoney":'+boonMoney+',"boonPercent":'+boonPercent+',"boonRemark":"'+boonRemark+'"}';
			if( i != count-1)
				boons += ","
		}
		boons += "]"
	}
	return boons;
}