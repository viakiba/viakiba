var updateCommon = {
		queryType:"1",
	// 判断操作是否成功
	judgeState : function(res, fnSucceed, fnError) {
		if (res["state"]) {
			var state = res["state"];
			// 请求成功
			if (state == 1) {
				fnSucceed(res);
			} else {// 请求失败
				if (fnError) {
					fnError(res);
				} else {
					var message = res["data"];
					updateCommon.updateAlert(message);
				}
			}
		} else {
			updateCommon.updateAlert("操作失败,请重试");
		}

	}
	// 解析的模板
	,
	tmpdata : function(tmphtml, data) {
		if (!data)
			return;
		// 模板解析器
		function tmp(tmp, data) {
			return tmp.replace(/\@{([\w\.]*)\}/g, function(str, key) {
				try {
					var k = key.split(".");
					var v = '';
					if (k.length > 1) {
						v = data[k[0]][k[1]];
					} else {
						v = data[key];
					}
				} catch (e) {
					if (console) {
						console.log(e);
					}
				}
				return (typeof v !== "undefined" && v !== null) ? v : "";
			});
		}
		return tmp(tmphtml, data);
	},
	updateAlert : function(msg) {
		var dialog = $.dialog({
			title : '提示',
			content : msg,
			ok : function() {
				return true;
			},
			okVal : '知道了',
			min : false,
			max : false,
			width : 'auto',
			height : 'auto',
			lock : true,
			icon : 'alert.gif',
			drag : false,
			cancel : false
		});
	},
	updateAlertFun : function(msg, fun) {
		var dialog = $.dialog({
			title : '提示',
			content : msg,
			ok : fun,
			okVal : '知道了',
			min : false,
			max : false,
			width : 'auto',
			height : 'auto',
			lock : true,
			icon : 'alert.gif',
			drag : false,
			cancel : false
		});
	},
	updateLoading : function(title) {
		var dialog = $.dialog({
			title : '',
			content : title,
			min : false,
			max : false,
			width : 'auto',
			height : 'auto',
			lock : true,
			icon : 'loading.gif',
			drag : false,
			cancel : false
		});
		return dialog;

	},
	updateConfirm : function(msg, successFun) {

		$.dialog.confirm(msg, successFun, function() {
			return true;
		});
	},
	showImgDialog : function(content) {
		var dialog = $.dialog({
			title : '',
			content : content,
			min : false,
			max : false,
			width : 'auto',
			height : 'auto',
			lock : false,
			drag : false,
			cancel : false,
			okVal : '知道了',
			ok : function() {
				return true;
			}
		});
	},
	// 菜单点击处理
	menuChecked : '0',
	setMenuChecked : function(index) {
		if (index != updateCommon.menuChecked) {
			$("#topmenuid" + updateCommon.menuChecked).parent().removeClass(
					"menu2-link");
			$("#topmenuid" + index).parent().addClass("menu2-link");
		}
	},
	checkUploadFileSize : function(target, maxSize, filename) {
		var flag = false;
		var isIE = /msie/i.test(navigator.userAgent) && !window.opera;

		var fileSize = 0;
		if (isIE && !target.files) {
			var filePath = target.value;
			var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
			var file = fileSystem.GetFile(filePath);
			fileSize = file.Size;
		} else {
			fileSize = target.files[0].size;
		}
		var size = fileSize / 1024 / 1024;
		if (size > maxSize) {
			flag = true;
			updateCommon.updateAlert("[" + filename + "]大小为:" + size
					+ "M 超过系统最大值限制，最大值为:" + maxSize + "M");
		}
		return flag;
	}

};







