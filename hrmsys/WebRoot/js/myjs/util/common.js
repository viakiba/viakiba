Ext.namespace("hrmsys.util.common");

/**
 * 判断工号唯一性
 * @param {Object} empId
 */
hrmsys.util.common.empId = function(obj){
		var empId = obj.getValue();
		var id = obj.id;
		Ext.Ajax.request({
			url: 'emp_isExist.action',
			success: function(response, options){
				if(response.responseText != ""){
					Ext.getCmp(id).markInvalid('此工号已存在');
				}
			},
			failure: hrmsys.util.common.failure,
			params: {
				empId: empId
			}
		})
	};
hrmsys.util.common.failure = function (){
	Ext.Msg.alert('提示','连接后台失败');
}