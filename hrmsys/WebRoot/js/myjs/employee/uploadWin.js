/**
 * @author sux
 * @date 2011-1-30
 * @desc 上传窗体
 */
UploadWin = Ext.extend(Ext.Window,{
	id: 'upLoad',
	uploadPanel: null,
	constructor: function(){
		this.uploadPanel =  new Ext.form.FormPanel({
			fileUpload: true,//允许上传
			baseCls: 'x-plain',//作用在面板元素上的CSS样式类 （默认为 'x-panel')
			layout: 'form',
			labelWidth: 60,
			id: 'uploadformPanel',
			items: [{
				xtype: 'fileuploadfield',//引入插件
				//inputType: 'file',
				fieldLabel: '上传照片',
				//allowBlank: false,
				id: 'photo',
				name: 'upload',
				buttonText: '选择'
			}]
			
	});
		//调用父类构造方法
		UploadWin.superclass.constructor.call(this,{
			title: '上传照片',
			modal: true,
			width: 300,
			height: 130,
			plain: true,
			bodyStyle: 'padding: 15px;',
			items:[this.uploadPanel],
			buttonAlign: 'center',
			buttons:[{
				text: '确定',
				handler: function(){
					Ext.getCmp('uploadformPanel').getForm().submit({
						url: 'emp_upload.action',
						method: 'post',
						waitTitle: '提示',
						waitMsg: '正在上传,请稍后...',
						success: uploadSuccess,
						failure: uploadFailure,
						scope: this
					});
				}
			},{
				text: '取消',
				handler: function(){
					Ext.getCmp('uploadformPanel').getForm().reset();
					Ext.get('emp_photo').dom.src = 'img/default.gif';
					uploadWin.destroy();
				}
			}]
		})
	}
});
	uploadSuccess = function(form,action){
		//console.log('success');
		Ext.getCmp('uploadformPanel').getForm().reset();
		uploadWin.destroy();
		Ext.Msg.alert('提示',action.result.msg,function(){
			Ext.getCmp('emp_photo').getEl().dom.src = action.result.path;
		});
	};
	uploadFailure = function(form,action){
		//console.log('failure');
		Ext.Msg.alert('提示', '连接失败');
	};
