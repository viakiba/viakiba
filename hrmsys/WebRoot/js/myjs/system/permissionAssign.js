
PerAssign = Ext.extend(Ext.Panel,{
	id: 'perAssignId',
	constructor: function(){
		var roleTreePanel = new Ext.tree.TreePanel({
			id: 'roleTree',
			checkModel: 'single',
			rootVisible: false,
			loader: new Ext.tree.TreeLoader({
				dataUrl: 'role_list.action',
				baseAttrs: { uiProvider: Ext.ux.TreeCheckNodeUI }//添加TreeCheckNodeUI插件
			}),
			root: new Ext.tree.AsyncTreeNode({
				id: null
			}),
			listeners: {'check':{
					fn: function(){
						Ext.getCmp('treegrid').remove();
						setTimeout(this.refreshTree, 1000);
					}
				}
			},
			refreshTree: function(){
				var roleNode = Ext.getCmp('roleTree').getChecked();
						if(roleNode == ""){
						}
						var roleId =  roleNode[0].id;
						Ext.getCmp('treegrid').getLoader().dataUrl='permission_list.action?roleId='+roleId;
						Ext.getCmp('treegrid').getLoader().load(treeGrid.getRootNode(), function(){});
			}
		});
		PerAssign.superclass.constructor.call(this,{
			layout: 'border',
			items:[{
				region: 'west',
				width: 200,
				layout: 'fit',
				border: true,
				frame: true,
				title: '角色列表',
				collapsible: true,
				items: [roleTreePanel]
			},{
				region: 'center',
				layout: 'fit',
				items: [{
					title: '角色权限分配',
					//width: 500,
					frame: 'true',
					id: 'treegridPanel',
					autoScroll: false,
					xtype: 'panel',
					items: [treeGrid],
					buttonAlign: 'center',
					buttons: [{
						text: '保存',
						handler: saveRoleFn
					},{
						text: '取消',
						handler: function(){
//							var obj = Ext.query('*[name$=_rs]');
//							for(var i = 0; i < obj.length; i++){
//								var id = obj[i].id;
//								Ext.get(obj[i].id).on('click', function(event,obj){
//									var flag = false;
//									var menu_id = obj.id.split('_')[0];
//									var node = Ext.getCmp("perTree").getNodeById(menu_id);
//									//alert(node);
//									//alert(node.attributes.checked);
//									 Ext.getCmp("perTree").getNodeById(menu_id).attributes.checked = true;
//								})
//							}
						}
					}]
					
				}]
			}],
			tbar: new Ext.Toolbar({
					items: [{
						text: '新建角色',
						iconCls: 'add',
						id: 'role_add',
						hidden: 'true',
						handler: newRoleFn
					},{
						text: '修改角色',
						iconCls: 'update',
						id: 'role_update',
						hidden: 'true',
						handler: updateRoleFn
					},{
						text: '删除角色',
						iconCls: 'delete',
						id: 'role_delete',
						hidden: 'true',
						handler: deleteRoleFn
					}]					
				})
		});
	}
});
saveRoleFn = function(){
			var roleNode = Ext.getCmp('roleTree').getChecked();
			if(roleNode == ""){
				Ext.Msg.alert('提示','请先选择角色');
				return;
			}
			var checkedNodesIds = roleNode[0].id;
			var objs = Ext.query('*[name$=_rs]');
			Ext.each(objs, function(obj){
				if(obj.checked){
					checkedNodesIds +=","+obj.id;
				}
			});
			if(checkedNodesIds == "") {
				Ext.Msg.alert('提示','没有为角色分配权限');
				return;
			}
			Ext.Ajax.request({
				url: 'rolePer_save.action',
				params: {
					checkedNodesIds: checkedNodesIds
				},
				success: saveRoleSuccessFn,
				failure: saveRoleFailureFn
			});
};
saveRoleSuccessFn = function(response, options){
	var datas = Ext.util.JSON.decode(response.responseText);
	Ext.Msg.confirm('提示',datas.msg,function(){
		
	})
};
saveRoleFailureFn = function(response, options){
	Ext.Msg.alert('提示','连接后台失败');
};
newRoleFn = function(){
	var roleAddWin = new RoleAddWin();
	roleAddWin.show();
};
updateRoleFn = function(){
	var roleNode = Ext.getCmp('roleTree').getChecked();
	if(roleNode == ""){
		Ext.Msg.alert('提示','请先选择角色!');
		return;
	}
	var roleId =  roleNode[0].id;
	var roleAddWin = new RoleAddWin();
	roleAddWin.text = '修改角色';
	roleAddWin.show();
	Ext.get('role_roleId').dom.value = roleId;
	Ext.get('role_roleName').dom.value = roleNode[0].text;
};
deleteRoleFn = function(){
	var roleNode = Ext.getCmp('roleTree').getChecked();
	if(roleNode == ""){
		Ext.Msg.alert('提示','请先选择角色!');
		return;
	}
	Ext.Msg.confirm('提示','将删除所有具有该角色的用户!',function(button, text){
		if(button == 'yes'){
			var roleId =  roleNode[0].id;
			Ext.Ajax.request({
				url: 'role_delete.action',
				params: {
					id : roleId
				},
				success: function(response, options){
					var datas = Ext.util.JSON.decode(response.responseText);
					Ext.Msg.alert('提示',datas.msg,function(){
						Ext.getCmp('roleTree').getLoader().dataUrl='role_list.action';
						Ext.getCmp('roleTree').getLoader().load(Ext.getCmp('roleTree').getRootNode(), function(){});
					});
				},
				failure: saveRoleFailureFn
			})
		}
	});
}
var treeGrid = new Ext.ux.tree.TreeGrid({
	width: 900,
	height:400,
	id: 'treegrid',
	autoScroll: false,
	enableColumnMove: false,
	enableColumnResize: false,
	columns: [{
		header: '模块',
		dataIndex: 'text',
		width: 190,
		fixed:true,
		resizable: false,
		align: 'center'
	},{
		header: '功能',
		width: 700,
		resizable: false,
		fixed:true,
		dataIndex: 'functions',
		align: 'center'
	}],
	root: new Ext.tree.AsyncTreeNode({
		expanded :true,	
		id: '0'
	}),
	dataUrl: 'permission_list.action'
});
/**
 * 传入roleId显示出checked出已有权限
 */