/**
 * 对话框重写
 * @author sux
 * @date 2011-02-18
 */

Ext.Msg.confirm = function(title, msg, fn){
	this.show({
		title: title,
		msg: msg,
		fn: fn,
		buttons: {
			yes: '确定',
			no: '取消'
		}
		//multiline: true  多行输入
	});
	return this;
}

Ext.Msg.alert = function(title, msg, fn){
	this.show({
		title: title,
		msg: msg,
		fn: fn,
		buttons: {
			yes: '确定'
		}
	});
	return this;
};