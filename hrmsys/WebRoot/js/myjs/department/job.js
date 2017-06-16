/**
 * 创建职位的下拉框，依据所选择的部门进行查询出部门职位
 * @author sux
 */
jobStore = new Ext.data.JsonStore({
	autoLoad: true,
	url: 'job_list.action',
	fields: ['jobId','jobName']
});

Job = Ext.extend(Ext.form.ComboBox,{
	constructor: function(labelName,hiddenName, deptObject){
		//与部门表进行级联操作
		deptObject.on('select', function(comboBox){
			var value = comboBox.getValue();
			Ext.getCmp('jobValue'+labelName).setRawValue('');
			jobStore.reload({
				params: {deptId: value}
			})
		});
		Job.superclass.constructor.call(this,{
			id: 'jobValue'+labelName,
			fieldLabel: labelName,
			displayField: 'jobName',
			valueField: 'jobId',
			hiddenName: hiddenName,
			width: 100,
			emptyText: '请选择',
			height: 100,
			store: jobStore,
			triggerAction: 'all', //显示所有
			editable: false,
			allowBlank: false,
			msgTarget: 'side',
			blankText: '请选择'
		})
	}
});
//job.on('click', function(comboBox){alert('ok');
//	comboBox.value = "";
//});