/**
 *  创建部门的下拉框，显示出所有部门
 * @param {Object} labelName
 * @memberOf {TypeName} 
 */
depart = Ext.extend(Ext.form.ComboBox,{
	deptStore: null,
	//注意传入参数labelName，因为其作id的一部分，避免出现相同的id
	constructor: function(labelName){
		//创建记录格式
//		defaultRecord = Ext.data.Record.create([{name: 'deptId', type: 'string'},{name: 'deptName', type:'string'}]);
//		var defaultData = new defaultRecord({deptId: '0', deptName: '全部'});
		
		deptStore = new Ext.data.JsonStore({
			url:'dept_show.action',
			autoLoad: true,
			fields: ['deptId','deptName']
//			//监听事件在加载时加入"全部"记录
//			listeners:{'load':function(){ 
//			deptStore.insert(0,defaultData);
//			}}
		});
		depart.superclass.constructor.call(this,{
			id: 'deptValue'+labelName,
			fieldLabel: labelName,
			displayField: 'deptName',
			valueField: 'deptId',
			hiddenName: 'deptId',
			emptyText: '全部',
			width: 100,
			store: deptStore,
			triggerAction: 'all', //显示所有
			editable: false
		})
	}
});
/**
 * 不带全部的dept下拉框
 * @param {Object} labelName
 * @param {Object} hiddenName
 * @memberOf {TypeName} 
 */
DepartJob = Ext.extend(Ext.form.ComboBox,{
	deptStore: null,
	//注意传入参数labelName，因为其作id的一部分，避免出现相同的id
	constructor: function(labelName, hiddenName){
		deptStore = new Ext.data.JsonStore({
			autoLoad: true, //设为自动加载，以便实现修改时选中某值
			url:'dept_show.action',
			fields: ['deptId','deptName']
		});
		DepartJob.superclass.constructor.call(this,{
			id: 'deptValue'+labelName,
			fieldLabel: labelName,
			displayField: 'deptName',
			valueField: 'deptId',
			emptyText: '请选择',
			hiddenName: hiddenName,
			width: 100,
			store: deptStore,
			triggerAction: 'all', //显示所有
			editable: false,
			allowBlank: false,
			msgTarget: 'side',
			blankText: '请选择'
		})
	}
});