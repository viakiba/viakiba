/**
 * @author sux
 * @desc 用户信息
 */
UserInfoPanel = Ext.extend(Ext.grid.EditorGridPanel,{
	id: 'userInfoPanelId',
	constructor: function(){
		Ext.QuickTips.init();
		userStore = new Ext.data.JsonStore({
			url: 'user_list.action',
			root: 'root',
 			totalProperty: 'totalProperty',
			fields: ['userId','role',
			'employee','userName','userRemark',{name: 'userDate', mapping: 'userDate.time', dateFormat : 'time', type: 'date' }]
		});
		var rowNumber = new Ext.grid.RowNumberer(); //序列号	
		var checkbox = new Ext.grid.CheckboxSelectionModel(); //{默认是多选singleSelect: false}
		deptInfoGridPanel.superclass.constructor.call(this,{
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
				columnsText : "显示/隐藏列",
                sortAscText : "正序排列",
                sortDescText : "倒序排列"
			},
			sm: checkbox,
			store: userStore,
			columns: [
				rowNumber, checkbox,
				{
					header: '用户编号',
					dataIndex: 'userId',
					align: 'center'
				},{
					header: '用户名',
					dataIndex: 'userName',
					align: 'center'
				},{
					header: '员工名',
					dataIndex: 'employee',
					align: 'center',
					renderer: function(v){
						return v.empName;
					}
				},{
					header: '角色',
					dataIndex: 'role',
					align: 'center',
					renderer: function(v){
						return v.roleName;
					}
				},{
					header: '创建日期',
					dataIndex: 'userDate',
					renderer: Ext.util.Format.dateRenderer('Y-m-d'),
					align: 'center'
				},{
					header: '备注',
					dataIndex: 'userRemark',
					align: 'center'
				}],
			tbar: new Ext.Toolbar({
				style: 'padding: 5px;',
				id: 'userToolbar',
				items: ['条目:',{
					xtype: 'combo',
					width: 80,
					triggerAction: 'all',
					editable: false,
					mode: 'local',
					store: new Ext.data.SimpleStore({
						fields: ['name','value'],
						data: [[" "," "],["userName","用户名"],["empName","员工名"]]
					}),
					id: 'user_condition',
					displayField: 'value',
					valueField: 'name'
				},'内容:',{
					id: 'user_conditionValue',
					xtype: 'textfield',
					width: 100
				},{
					text: '查询',
					tooltip: '查询用户',
					iconCls: 'search',
					id: 'user_query',
					handler: queryUserFn
				},{
					text: '删除',
					tooltip: '删除用户',
					id: 'user_delete',
					iconCls: 'delete',
					hidden: 'true',
					handler: delUserFn
				},{
					text: '添加',
					tooltip: '添加用户',
					id: 'user_add',
					hidden: 'true',
					iconCls: 'add',
					handler: userAddFn
				},{
					text: '修改',
					id: 'user_update',
					iconCls: 'update',
					hidden: 'true',
					tooltip: '修改用户',
					handler: userUpdateFn
				}]
			}),
			bbar: new PagingToolbar(userStore, 20)
		});
		this.getStore().load({
			params: {
				start: 0,
				limit: 20
			}
		});
	}
});

delUserFn = function(){
	gridDel('userInfoPanelId','userId', 'user_delete.action');
};

queryUserFn = function(){
	var condition = Ext.getCmp('user_condition').getValue();
	var conditionValue = Ext.getCmp("user_conditionValue").getValue();
	Ext.getCmp("userInfoPanelId").getStore().reload({
		params: {
			condition: condition,
			conditionValue : conditionValue,
			start: 0,
			limit: 20
		}
	})
};
userAddFn = function(){
	var userAddWin = new UserAddWin("用户添加");
	userAddWin.show();
};
userUpdateFn = function(){
	var userUpdateWin = new UserUpdateWin("用户修改");
	var selectionModel = Ext.getCmp('userInfoPanelId').getSelectionModel();
		var record = selectionModel.getSelections();
		if(record.length != 1){
			Ext.Msg.alert('提示','请选择一个');
			return;
		}
		var userId = record[0].get('userId');
	Ext.getCmp('userUpdateFormId').getForm().load({
		url: 'user_intoUpdate.action',
		params: {
			userId: userId
		}
	});
	userUpdateWin.show();
};