/**
 * 添加职员Form
 * @author sux
 * @param {Object} width
 * @memberOf {TypeName} 
 */
addEmpForm = Ext.extend(Ext.form.FormPanel,{
	id: 'empForm',
	//url: 'emp_save.action',
	//构造方法中的width参数为TabPanel的宽度
	constructor: function(width){
		width = (width-750)/2;
		Ext.QuickTips.init();
		var deptObject = new DepartJob("所在部门","emp.department.deptId"); //实例化部门
		jobObject = new Job("职位","emp.job.jobId",deptObject); //实例化职位
		jobObject.on('expand', function(comboBox){
			var deptId = Ext.getCmp("deptValue所在部门").getValue();
			this.getStore().load({
				params: {
					deptId: deptId
				}
			})
		});
		var reader = new Ext.data.JsonReader({},[{
			name: 'emp.empId', mapping: 'empId'
		},{//json时间格式转为ext,time为json中显示的一部分
			name: 'emp.empBirth', mapping: 'empBirth.time', dateFormat : 'time', type: 'date'
		},{
			name: 'emp.empSex', mapping: 'empSex'
		},{
			name: 'emp.empPost', mapping: 'empPost'
		},{
			name: 'emp.empBank', mapping: 'empBank'
		},{
			name: 'emp.empNationality', mapping: 'empNationality'
		},{
			name: 'emp.empSchool', mapping: 'empSchool'
		},{
			name: 'emp.empName', mapping: 'empName'
		},{
			name: 'emp.empTelephone', mapping: 'empTelephone'
		},{
			name: 'emp.empEmail', mapping: 'empEmail'
		},{
			name: 'emp.empMobilephone', mapping: 'empMobilephone'
		},{
			name: 'emp.empIdcard', mapping: 'empIdcard'
		},{
			name: 'emp.empAccount', mapping: 'empAccount'
		},{
			name: 'emp.empOrigin', mapping: 'empOrigin'
		},{
			name: 'emp.empEducation', mapping: 'empEducation'
		},{
			name: 'emp.empPhoto', mapping: 'empPhoto', convert: function(v){if(v != '')Ext.get('emp_photo').dom.src=v;}
		},{
			name: 'emp.empNation', mapping: 'empNation'
		},{
			name: 'emp.empProfession', mapping: 'empProfession'
		},{
			name: 'emp.empAddress', mapping: 'empAddress'
		},{
			name: 'emp.department.deptId', mapping: 'department.deptId'
		},{
			name: 'emp.job.jobId', mapping: 'job.jobId'
		}])
		addEmpForm.superclass.constructor.call(this,{
			//var windowWidth =   window.screen.availWidth;获取屏幕宽度
			//bodyStyle: 'margin-left:'+width+'px;', //将下面的panel显示在中间
			frame: true,
			reader: reader,
			items: [{
				width: 768,
				html: '<center><h1>员工信息</h1></center><br/>'
			},{
			xtype: 'fieldset',
			title: '个人信息',
			defaults: {
				bodyStyle: 'padding-right: 30px;'
			},
			width: 768,
			layout: 'table',//表格布局
			labelAlign: 'right',
			labelWidth: 60,
			frame: true,
			layoutConfig: {//3列
				columns: 3
			},
			items: [{
				layout: 'form',
				//columnWidth: .33, // column列布局
				defaults: {
					xtype: 'textfield',
					width: 150
				},
				items: [{
					fieldLabel: '工号',
					name: 'emp.empId',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '工号不能为空',
					emptyText: '不能为空',
					id: 'empAddId',
					listeners: {'blur':hrmsys.util.common.empId}
				},{
					xtype: 'datefield',
					fieldLabel: '出生日期',
					name: 'emp.empBirth',
					format: 'Y-m-d',
					allowBlank: false,
					editable: false,
					msgTarget: 'side',
					blankText: '出生日期不能为空',
					emptyText: '不能为空'
				},{
					xtype: 'numberfield', //只能为数字
					fieldLabel: 'QQ',
					//emptyText: '只能为数字',
					name: 'emp.empQq'
				},{
					fieldLabel: '性别',
					xtype: 'panel',
					layout: 'column',
					bodyStyle: 'padding:0px 0px 10px 30px;',
					items: [{
						columnWidth: .5,
						xtype: 'radio',
						boxLabel: '男',
						checked: true,
						inputValue: 1, //此处特别注意inputValue
						name: 'emp.empSex'
					},{
						columnWidth: .5,
						xtype: 'radio',
						boxLabel: '女',
						inputValue: 0,
						name: 'emp.empSex'
					}]
				},{
					xtype: 'numberfield',
					fieldLabel: '邮编',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '邮编不能为空',
					emptyText: '只能为数字',
					regex: /^[1-9]\d{5}$/,
					regexText: '邮编格式不正确',
					name: 'emp.empPost'
				},{
					fieldLabel: '开户银行',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '开户银行不能为空',
					emptyText: '不能为空',
					name: 'emp.empBank'
				},{
					fieldLabel: '国籍',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '国籍不能为空',
					emptyText: '不能为空',
					name: 'emp.empNationality'
				},{
					fieldLabel: '毕业学校',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '毕业学校不能为空',
					emptyText: '不能为空',
					name: 'emp.empSchool'
				}]
			},{
				layout: 'form',
				//columnWidth: .33,
				defaults: {
					xtype: 'textfield',
					width: 150
				},
				items: [{
					fieldLabel: '姓名',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '用户名不能为空',
					emptyText: '不能为空',
					name: 'emp.empName'
				},{
					fieldLabel: '电话',
					name: 'emp.empTelephone',
					msgTarget: 'side',
					regex: /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/,
					regexText: '电话格式不正确'
				},{
					fieldLabel: 'e-mail',
					emptyText: '不能为空',
					allowBlank: false,
					blankText: '邮箱不能为空',
					vtype: 'email', //自带的邮箱校验
					msgTarget: 'side',
					vtypeText: '请输入正确的邮箱格式',
					name: 'emp.empEmail'
				},{
					fieldLabel: '手机',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '手机号不能为空',
					emptyText: '不能为空',
					name: 'emp.empMobilephone',
					regex: /(^0?[1][358][0-9]{9}$)/,
					regexText: '手机格式不正确'                                
				},{
					fieldLabel: '身份证',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '身份证号不能为空',
					regex: /^(\d{14}|\d{17})(\d|[xX])$/,
					regexText: '身份证格式不正确',
					emptyText: '不能为空',
					name: 'emp.empIdcard'
				},{
					xtype: 'numberfield',
					fieldLabel: '开户账号',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '账号不能为空',
					emptyText: '只能为数字',
					name: 'emp.empAccount'
				},{
					fieldLabel: '籍贯',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '籍贯不能为空',
					emptyText: '不能为空',
					name: 'emp.empOrigin'
				},{
					fieldLabel: '学历',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '学历不能为空',
					emptyText: '不能为空',
					name: 'emp.empEducation'
				}]
			},{
				//rowspan: 5,
				layout: 'form',
				defaults: {
					xtype: 'textfield',
					width: 150
				},
				items: [{
					xtype: 'textfield', //注意此处为textfield, inputType: 'image'
					fieldLabel: '照片',
					inputType: 'image',
					width: 130,
					height: 125,
					id: 'emp_photo',
					autoCreate : {
					tag : "input",
				    type : "image",
					src : "img/default.gif",
					name: 'emp.empPhoto'
					//autocomplete:  "off"
					}
				},{
					style: 'margin-left: 110px;',
					xtype: 'button',
					width: 50,
					text: '上传照片',
					handler: upload
				},{
					xtype: 'textfield',
					fieldLabel: '民族',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '民族不能为空',
					emptyText: '不能为空',
					name: 'emp.empNation'
				},{
					xtype: 'textfield',
					fieldLabel: '专业',
					allowBlank: false,
					msgTarget: 'side',
					blankText: '专业不能为空',
					emptyText: '不能为空',
					name: 'emp.empProfession'
				}]
			},{
				colspan: 3,
				layout: 'form',
				items: [{
					xtype: 'textfield',
					fieldLabel: '地址',
					width: 640,
					allowBlank: false,
					msgTarget: 'side',
					blankText: '地址不能为空',
					emptyText: '不能为空',
					name: 'emp.empAddress'
			}]
			}]
			},{
				xtype: 'fieldset',
				title: '部门',
				width: 768,
				layout: 'column',
				defaultType: 'textfield',
				defaults: {
					labelWidth: 60,
					labelAlign: 'right'
				},
				items: [{
					columnWidth: .32,
					layout: 'form',
					xtype: 'panel',
					items: [deptObject]
				},{
					columnWidth: .32,
					layout: 'form',
					xtype: 'panel',
					items: [jobObject]
				}]
			},{
				xtype: 'panel',
				width: 750,
				buttonAlign: 'center',
				buttons: [{
					text: '保存',
					handler: function(){
						if(!Ext.getCmp('empForm').getForm().isValid()){
		    				return;
		    			}
						Ext.getCmp('empForm').getForm().submit({
							url: 'emp_save.action',
							method: 'post',
							waitTitle: '提示',
							waitMsg: '正在保存数据...',
							success: saveSuccess,
							failure: saveFailure,
							scope: this,
							params: {empPhoto: Ext.get('emp_photo').dom.src}
						});
					}
				},{
					text: '关闭',
					handler: function(){
						//Ext.getCmp('empForm').getForm().reset();
						//Ext.get('emp_photo').dom.src = 'img/default.gif';
						Ext.getCmp('empUpdateWinId').destroy();
					}
				}]
			}]
		});
	}
});
//上传窗体显示
upload = function(){
	uploadWin = new UploadWin();//实例化上传窗体
	uploadWin.show();//显示窗体
};
//保存成功操作
saveSuccess = function(form, action){
	Ext.Msg.confirm('提示', action.result.msg, function(button, text){
		Ext.getCmp('empForm').getForm().reset();
		Ext.get('emp_photo').dom.src = 'img/default.gif';
		if(button == "yes"){
			Ext.getCmp('empUpdateWinId').destroy();//销毁窗体
			Ext.getCmp("empInfo").getStore().load({
			params: {
				deptId: "",
				start: 0,
				limit: 20
			}
		});
		}
	});
};
//保存失败操作
saveFailure = function(form, action){
	Ext.Msg.alert('提示','连接失败');
}