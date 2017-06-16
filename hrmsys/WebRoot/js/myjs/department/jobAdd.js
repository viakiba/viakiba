Ext.namespace("hrmsys.job.add");

JobAddWin = Ext.extend(Ext.Window,{
	id: 'jobAddWinId',
	addForm: null,
	constructor: function(){
		addForm = new JobAddForm();
		JobAddWin.superclass.constructor.call(this,{
			title: '职位录入',
			width: 400,
			modal: true,
			height: 300,
			collapsible: true,
			colsable: true,
			layout: 'form',
			items: [addForm]
		})
	}
})
JobAddForm = Ext.extend(Ext.form.FormPanel,{
	id: 'jobAddFormId', 
	dept: null,
	constructor: function(){
		Ext.QuickTips.init();
		//加载后台数据，进行转换
		var reader = new Ext.data.JsonReader({},[{
			name: 'deptId', mapping: 'department.deptId'
		},{
			name: 'job.jobName', mapping: 'jobName'
		},{
			name: 'job.jobBasicWage', mapping: 'jobBasicWage'
		},{
			name: 'job.jobRemark', mapping: 'jobRemark'
		},{
			name: 'job.jobId', mapping: 'jobId'
		}]);
		this.dept = new depart("所在部门");
	    JobAddForm.superclass.constructor.call(this, {
	    	labelWidth: 80,
	    	padding: '20 0 0 50',
	    	reader: reader,
	    	labelAlign: 'right',
	    	border: false,
	    	frame: true,
	    	items: [this.dept,{
	    		xtype: 'textfield',
	    		fieldLabel: '新增职位',
	    		allowBlank: false,
				msgTarget: 'side',
				blankText: '不能为空',
				emptyText: '不能为空',	
	    		width: 150,
	    		name: 'job.jobName',
	    		listeners: {'blur': this.jobBlurFn}
	    	},{
	    		xtype: 'textfield',
	    		width: 150,
	    		fieldLabel: '岗位工资',
	    		name: 'job.jobBasicWage',
	    		regex: /^[0-9]+(.[0-9]{2})?$/,
	    		regexText: '只能输入数字(可两位小数)',
	    		msgTarget: 'side'
	    	},{
	    		xtype: 'textarea',
	    		fieldLabel: '备注',
	    		width: 150,
	    		height: 120,
	    		name: 'job.jobRemark'
	    	},{
	    		xtype: 'hidden',//隐藏值
	    		name: 'job.jobId'
	    	}],
	    	buttonAlign: 'center',
	    	buttons: [{
	    		text: '保存',
	    		handler: function(){
	    			if(!Ext.getCmp('jobAddFormId').getForm().isValid()){
	    				return;
	    			}
	    			Ext.getCmp('jobAddFormId').getForm().submit({
	    				url: 'job_saveOrUpdate.action',
	    				method: 'post',
	    				waitMsg: '正在保存数据...',
	    				waitTitle: '提示',
	    				scop: this,
	    				success: save_success,
	    				failure: save_failure
	    			})
	    		}
	    	},{
	    		text: '关闭',
	    		handler: function(){
	    			Ext.getCmp('jobAddWinId').destroy();
	    		}
	    	}]
	    })
	},
	jobBlurFn: function(obj){
		Ext.Ajax.request({
			url: 'job_unique.action',
			params: {
				jobName: obj.getValue()
			},
			success: function(response, options){
				var data = Ext.util.JSON.decode(response.responseText);
				if(data.msg != ""){
					obj.markInvalid("该职位已存在!");	
				}
			},
			failure: hrmsys.util.common.failure
		})
	}
});
save_success = function(form, action){
	Ext.Msg.confirm('提示', action.result.msg, function(button, text){
		if(button == "yes"){
			form.reset();
			Ext.getCmp('jobAddWinId').destroy();
			Ext.getCmp('jobGrid').getStore().reload();//刷新部门显示列表
		}
	});
};
save_failure = function(form, action){
	Ext.Msg.alert('提示',"连接失败", function(){
		
	});
};

