/* ========================================================= 
 * @author 周小欠
 * @date 2014-07-09
 * @copyright (C) 2014~2015
 * 说明：本插件是基于jquery和bootstrap的表单验证插件
 * 使用方法：在表单项中添加属性，如下：
 * validate-tags：验证规则的标签，支持多个，以空格隔开，如validate-tags="required chinese"
 * 		required 不能为空，并在后面自动加*号
 *   	url  网址
 *   	date 日期格式 xxxx-xx-xx
 *   	mail 邮箱
 *   	number 数字，可以整型，浮点型。
 *   	char 英文字符和下划线
 *   	charUpper 大写英文字符和下划线
 *   	charLower 小写英文字符和下划线
 *   	mobile 手机号码
 *   	telphone 固定电话、传真
 *   	ip ip地址
 *   	mac 物理地址
 *   	chinese 中文
 * validate-message：验证规则对应的提示信息，插件默认提供，用户可覆盖，格式如：validate-message="{required:'请填写你的小名。'}"
 * validate-minLength：最短长度验证，格式如：minlength="6"；无最长长度验证，浏览器会禁止输入
 * validate-range：取值范围验证，其validate-tags必须包含number
 * 		range="2.1~3"   表示值在[2.1~3]之间
 * 		range="2.1,2,4,5"   表示值只能填现数字 
 * validate-equals：是否相同验证，值必须是另一输入域的ID值
 * 
 * validate-remote-before:远程服务器验证前执行的外部方法
 * validate-remote：远程服务器验证，值是url地址
 * 注意：验证顺序与上述排序一致，如果前一项未验证通过，不进行下一项验证
 * 
 * 
 * 组件对外提供一下方法供调用：
 * 1 、$("form").validation()
 * 	描述：对表单进行验证初始化，在必填的项后增加*标识，对input、text绑定失去焦点事件，对type=file绑定change事件，
 * 		这些事件触发时对表单项进行验证
 * 
 * 2、$("form").validate()
 * 	描述：对表单所有需要验证的输入项进行验证，提交表单前调用，根据返回结果判断是否验证通过
 * 
 * 3、$("input").validateSingleField()
 * 	描述：单独验证某一个输入域是否合法
 * 
 * 开发者需要在页面加载完成后显式调用$("form").validation()来绑定表单验证，
 * 在表单提交前，显式调用$("form").validate()判断表单是否可以提交，
 * 如果需要单独验证某个输入域是否合法，可以调用$("input").validateSingleField()方法
 * 
 * 
 * $("form").validation()可以扩展验证方法
 * 例如:
 * $("form").validation(function(obj,params){
 *     if (obj.id=='mail'){
 *       $.post("/verifymail",{mail :$(obj).val()},function(data){
 *         params.err = !data.success;
 *         params.msg = data.msg;
 *       });
 *     }},
 *     {
 *     		validOnBlur : true //input，textarea上失去焦点或type=file文件框的值改变时是否立即验证
 *     		reqmark:false, //自动添加必填的*号
 *     		attrNames : {//输入框中的验证属性标识，可以根据喜好自定义验证标签
				ruleTags : "validate-tags",//支持多个，以空格隔开。
				messages : "validate-message",
				minLength : "validate-minLength",
				range : "validate-range",
				equals : "validate-equals",
				remote : "validate-remote"
			},
 *     }
 *   );
 *   
 *   错误信息提示，默认在右侧，可以在输入域上增加属性data-placement自定义显示位置，取值有：left, top, right, bottom
 */
!function($) {
	var formState = false;//表单状态
    var fieldState = false; //表单字段状态
    var fform_style=0;    //0=表示基本表单 1=表示内联表单 2=水平排列的表单
    var globalOptions = {};//全局参数
	
	/**
	 * 对表单进行验证初始化，在必填的项后增加*标识，对input、text绑定失去焦点事件，对type=file绑定change事件，
	 * 这些事件触发时对表单项进行验证
	 */
	$.fn.validation = function(callback, options) {
		if (!this.length) {
			if (options && options.debug && window.console) {
				console.warn("表单不存在，无法验证");
			}
			return;
		}

		return this.each(function() {
			globalOptions = $.extend({}, $.fn.validation.defaults, options);
			globalOptions.callback = callback;
			//如果是HTML5，表单设置不验证属性
			$(this).attr("novalidate", "novalidate");
			//设置表单类别
			fform_style = isformstyle(this);
			validationForm(this);//初始化表单验证
		});
	}
	
	$.fn.validation.defaults = {
		validOnBlur : true,//input，textarea上失去焦点或type=file文件框的值改变时是否立即验证
		reqmark : true,//自动添加必填的*号
		reqmarkStyle:"color:#A94442",
		callback : null,
		attrNames : {
			ruleTags : "validate-tags",// validate-tags="required chinese" //支持多个，以空格隔开。
			messages : "validate-message",
			minLength : "validate-minLength",
			range : "validate-range",
			equals : "validate-equals",
			remoteBefore : "validate-remote-before",
			remote : "validate-remote"
		},
		validRules : [
		              {
		            	  name : 'required',//必填项
		            	  validate : function(value) {
		            		  return ($.trim(value) == '');
		            	  },
		            	  defaultMsg : '请输入内容。'
		              },
		              {
		            	  name : 'number',//数字
		            	  validate : function(value) {
		            		  return (!/^-?(?:\d+|\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(value));
		            	  },
		            	  defaultMsg : '请输入数字。'
		              },
		              {
		            	  name : 'mail',//邮件
		            	  validate : function(value) {
		            		  return (!/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(value));
		            	  },
		            	  defaultMsg : '请输入邮箱地址。'
		              },
		              {
		            	  name : 'char',//英文字符
		            	  validate : function(value) {
		            		  return (!/^[a-z\_\-A-Z]*$/.test(value));
		            	  },
		            	  defaultMsg : '请输入英文字符。'
		              },
		              {
		            	  name : 'charUpper',//大写英文字符
		            	  validate : function(value) {
		            		  return (!/^[A-Z\_]+$/.test(value));
		            	  },
		            	  defaultMsg : '请输入大写字母'
		              },
		              {
		            	  name : 'charLower',//小写字符
		            	  validate : function(value) {
		            		  return (!/^[a-z\_]+$/.test(value));
		            	  },
		            	  defaultMsg : '请输入小写字母'
		              },
		              {
		            	  name : 'chinese',//汉字
		            	  validate : function(value) {
		            		  return (!/^[\u4e00-\u9fff]+$/.test(value));
		            	  },
		            	  defaultMsg : '请输入汉字。'
		              },
		              {
		            	  name : 'url',//链接地址
		            	  validate : function(value) {
		            		  return (!/^(https?|s?ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(value))
		            	  },
		            	  defaultMsg : '请输入网址'
		              },
		              {
		            	  name : 'date',//日期格式
		            	  validate : function(value) {
		            		  return (/Invalid|NaN/.test(new Date(value).toString()));
		            	  },
		            	  defaultMsg : "日期格式XXXX-XX-XX。"
		              },
		              {
		            	  name : 'mobile',//手机号码
		            	  validate : function(value) {
		            		  return (!/^(13|14|15|17|18)[0-9]{9}$/.test(value));
		            	  },
		            	  defaultMsg : "请输入正确的格式，如：13812345678"
		              },
		              {
		            	  name : 'telphone',//电话号码
		            	  validate : function(value) {
		            		  return (!/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/.test(value));
		            	  },
		            	  defaultMsg : "请输入正确的电话号码(传真号码)"
		              },
		              {
		            	  name : 'ip',//IP地址
		            	  validate : function(value) {
		            		  //return (!/^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$/.test(value));
		            		  return (!/\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\b/.test(value));
		            		  		            	  
		            	  },
		            	  defaultMsg : "请输入正确格式，如：192.168.12.12"
		              },
		              {
		            	  name : 'mac',//MAC物理地址
		            	  validate : function(value) {
		            		  return (!/[A-F\\d]{2}:[A-F\\d]{2}:[A-F\\d]{2}:[A-F\\d]{2}:[A-F\\d]{2}:[A-F\\d]{2}/.test(value));
		            	  },
		            	  defaultMsg : "请输入正确格式，如：AF:02:E3:B5:A9:12"
		              },
		              {
		            	  name : 'name',//允许输入汉字、英文字母、数字
		            	  validate : function(value) {
		            		  return (!/^([\u4e00-\u9fff]|[a-zA-Z0-9])*$/.test(value));
		            	  },
		            	  defaultMsg : "请输入正确格式，如：我是h123"
		              },
		              {
		            	  name : 'charnum',//允许英文字母、数字
		            	  validate : function(value) {
		            		  return (!/^([a-zA-Z0-9])*$/.test(value));
		            	  },
		            	  defaultMsg : "请输入正确格式，如：abc123"
		              }
		              
		             ]
	};
	
	/**
	 * 对表单所有需要验证的输入项进行验证，提交表单前调用
	 */
	$.fn.validate = function(){
		if (formState) { // 重复提交则返回
			return false;
		}
		formState = true;
		var validationError = false;
		// 取出验证的
		$('input, textarea', this).each(function() {
			var el = $(this);
			var valid = (el.attr(globalOptions.attrNames.ruleTags) == undefined) ? 
					null : el.attr(globalOptions.attrNames.ruleTags).split(' ');
			if (valid != null && valid.length > 0) {
				if (!validateField(this, valid)) {
					validationError = true;
				}
			}
		});

		formState = false;
		return !validationError;        
	}
	
	/**
	 * 单独验证某一个输入域是否合法
	 */
	$.fn.validateSingleField = function() {
		var el = $(this);
		var valid = (el.attr(globalOptions.attrNames.ruleTags) == undefined) ? 
				null : el.attr(globalOptions.attrNames.ruleTags).split(' ');
		if (valid != null && valid.length > 0) {
			validateField(this, valid)
		} else {
			console.debug("待验证输入域没有定义任何验证标签，无法验证");
		}
	}
	
	function isformstyle(form) {
		if ($(form).hasClass('form-inline')) {
			return 1;
		} else if ($(form).hasClass('form-horizontal')) {
			return 2;
		} else {
			return 0;
		}
	}
	
	/**
	 * 初始化表单验证
	 * 为表单中的输入项绑定事件，为必填项增加*必填标识
	 */ 
	var validationForm = function(obj) {
		if(globalOptions.validOnBlur) {//如果设置失去焦点就验证，那么设置blur事件和change事件
			// 1.丢失焦点事件
			$(obj).find('input, textarea').each(function() {
				var el = $(this);
				var valid = (el.attr(globalOptions.attrNames.ruleTags) == undefined) ? 
						null : el.attr(globalOptions.attrNames.ruleTags).split(' ');
				if (valid) {
					el.on('blur', function() { // 失去焦点时
						validateField(this, valid);
					});
				}
			});
			
			//2.如是文件选择则要处理onchange事件
			$(obj).find("input[type='file']").each(function() {
				var el = $(this);
				var valid = (el.attr(globalOptions.attrNames.ruleTags) == undefined) ? 
						null : el.attr(globalOptions.attrNames.ruleTags).split(' ');
				if (valid) {
						el.on('change', function() { //
						validateField(this, valid);
					});
				}
			});
		}

		//3.设置必填的标志*号
		if (globalOptions.reqmark == true) {
			if (fform_style == 0) {//基本表单
				$(obj).find(".form-group>label").each(function() {
					var el = $(this);
					var controlGroup = el.parents('.form-group');
					controlGroup.removeClass('has-error has-success');
					controlGroup.find("#autoreqmark").remove();
					//el.after('<span id="autoreqmark" style="' + globalOptions.reqmarkStyle + '"> *</span>')
					controlGroup.append('<span id="autoreqmark" style="' + globalOptions.reqmarkStyle + '"> *</span>');
				});
			} else if (fform_style == 1) {//内联表单

			} else if (fform_style == 2) {//水平排列表单
				$(obj).find('input, textarea').each(function() {
					var el = $(this);
					var valid = (el.attr(globalOptions.attrNames.ruleTags) == undefined) ? 
							null: el.attr(globalOptions.attrNames.ruleTags).split(' ');
					if (valid) {
						var controlGroup = el.parents('.form-group');
						controlGroup.removeClass('has-error has-success');
						controlGroup.find("#autoreqmark").remove();
						
						if ($.inArray('required', valid) >= 0) {
							//el.parent().after('<span class="glyphicon" id="autoreqmark" style="'
								//	+ globalOptions.reqmarkStyle + '">*</span>');
							controlGroup.append('<span class="glyphicon" id="autoreqmark" style="'
										+ globalOptions.reqmarkStyle + '">*</span>')
						}
					}
				})
			}
		}//end 
	};
	
	/**
	 * 服务器验证
	 * 如果内容为空，不发起服务器验证；
	 * 将url地址上的参数转换成post方式，同步发起请求
	 */
	var validateRemote = function(field, remoteUrl, params) {
		var el = $(field);
		var elValue = el.val();
		if($.trim(elValue) == "") {
			return true;
		}
		var param = el.attr("name") + "=" + elValue.split("&").join("%26");//拼凑参数，同时转换特殊字符&
		var hasParams = remoteUrl.indexOf("?");
		if(hasParams != -1) {
			param = param + "&" + remoteUrl.substring(hasParams + 1);//拼凑参数
			remoteUrl = remoteUrl.substring(0, hasParams);
		}
		
		var feedBack = $.ajax({
			url : remoteUrl,
			type : "post", 
			data : param,
			cache : false,
			async : false
		}).responseText;
		//判断返回值，可以设置params
		//返回的feedBack是字符串
		var result = eval('(' + feedBack + ')');
		
		if(feedBack) {
			params.err = !result.success;
		    params.msg = result.message;
		} else {
			params.err = true;
		    params.msg = "服务器无响应，请稍后重试";
		}
		
	}
	
	// 验证字段
	var validateField = function(field, valid) {
		var el = $(field);
		var error = false;
		var errorMsg = '';
		var minlength = (el.attr(globalOptions.attrNames.minLength) ? el.attr(globalOptions.attrNames.minLength) : null);//最短长度
		var range = (el.attr(globalOptions.attrNames.range) ? el.attr(globalOptions.attrNames.range) : null); //范围
		var equals = (el.attr(globalOptions.attrNames.equals) ? el.attr(globalOptions.attrNames.equals) : null);//值相等比较
		var remoteBefore = (el.attr(globalOptions.attrNames.remoteBefore) ? el.attr(globalOptions.attrNames.remoteBefore) : null);//远程验证之前调用的方法
		var messages = (el.attr(globalOptions.attrNames.messages) ?
				eval('(' + el.attr(globalOptions.attrNames.messages) + ')') : null);//验证规则的错误提示信息
		var msg;
		for (i = 0; i < valid.length; i++) {
			var x = true;
			var flag = valid[i];
			if(!messages) {
				msg = null;
			} else {
				msg = messages[flag] ? messages[flag] : null;//设置验证规则的消息提醒
			}

			if (flag.substr(0, 1) == '!') {//!email反转验证
				x = false;
				flag = flag.substr(1, flag.length - 1);
			}

			var rules = globalOptions.validRules;
			for (j = 0; j < rules.length; j++) {
				var rule = rules[j];
				if (flag == rule.name) {
					var value;
					if (el.attr('type') != null && el.attr('type') == 'checkbox') {
						value = el.is(":checked") ? 'true' : '';
					} else {
						value = el.val();
					}
					if (rule.validate.call(field, value) == x) {
						error = true;
						if (el.attr('type') != null && el.attr('type').toLowerCase() == 'file') {
							errorMsg = (msg == null) ? '请选择文件。' : msg;
						} else {
							errorMsg = (msg == null) ? rule.defaultMsg : msg;
						}
						break;
					}
				}
			}
			if (error) {
				break;
			}
		}

		//验证长度
		if (minlength && !error) {
			error = el.val().length < minlength;
			if (error && (msg == null || errorMsg == '')) {
				errorMsg = '输入长度大于等于' + minlength;
			}
		}

		//值区间
		if ($.inArray('number', valid) >= 0 && range && !error) {
			var values = range.split("~");

			if (values.length == 2) {
				error = parseFloat(el.val()) < parseFloat(values[0]) 
					|| parseFloat(el.val()) > parseFloat(values[1]);
				if (error && (msg == null || errorMsg == '')) {
					errorMsg = '输入值在［' + values[0] + '~' + values[1] + ']之间。';
				}
			} else {
				var values = range.split(",");
				if (values.length > 0) {
					error = $.inArray(el.val(), values) < 0;
					if (error && (msg == null || errorMsg == '')) {
						errorMsg = '输入值为' + range + '的其中一个。';
					}
				}
			}
		}
		
		//equals验证
		if(equals && !error) {
			var value = el.val();
			var valueEqualsTo = $("#" + equals).val();
			error = (value != valueEqualsTo);
			if(error && (msg == null || errorMsg == '')) {
				errorMsg = '两次输入值不相同。';
			}
		}

		//外部验证回调方法
		if (!error && globalOptions.callback) {
			var params = {
				msg : '',
				err : error
			};
			globalOptions.callback(field, params);
			error = params.err;
			if (error && (msg == null || errorMsg == '')) {
				errorMsg = params.msg;
			} else if (params.msg != '') {
				errorMsg = params.msg;
			}
		}

		//远程服务器验证
		//如果定义了remoteBefore，则在远程验证前执行remoteBefore方法
		//如果remoteBefore方法返回false,结束当前输入域的验证
        if(remoteBefore) {//如果定义了remoteBefore，则在远程验证前执行remoteBefore方法
            if(!eval(remoteBefore + "()")) {//如果执行不通过，该表单项的验证停止
                return;
            }
        }

        var remote = (el.attr(globalOptions.attrNames.remote) ? el.attr(globalOptions.attrNames.remote) : null);//远程验证

        if (remote && !error) {
            var params = {
				msg : '',
				err : error
			};
			validateRemote(field, remote, params);
			error = params.err;
			if (error && (msg == null || errorMsg == '')) {
				errorMsg = params.msg;
			} else if (params.msg != '') {
				errorMsg = params.msg;
			}
		}
		
		//修改输入框样式
		var controlGroup = el.parents('.form-group');
		controlGroup.removeClass('has-error has-success');

		var groupClass = "";//输入框组的样式
		var feedbackClass = "";//错误、警告、OA等图标样式
		if (error) {
			groupClass = 'has-error has-feedback';
			feedbackClass = "glyphicon-remove";
		} else {
			groupClass = 'has-success has-feedback';
			feedbackClass = "glyphicon-ok";
		}
		controlGroup.addClass(groupClass);
		var form = el.parents("form");
		if (form) {
			//移除错误图标
			controlGroup.find(".form-control-feedback").remove();
			//是否是input-group组合输入
			var isInputGroup = el.parent().hasClass('input-group');
			//组合按钮是否在输入框后方
			var isAddonBehind = el.next('.input-group-addon').length > 0;
			//判断输入域
			if (isInputGroup) {
				if (isAddonBehind) {
					//组合按钮在输入框后方,不设置错误或正确图标，只设置输入框样式，将组合框上的popover提示删除
					el.parent('.input-group').popover('destroy');
				} else {
					//组合按钮在输入框前方
					el.parent('.input-group').after("<span class='glyphicon " + feedbackClass + " form-control-feedback'></span>");
				}
			} else {
				//废除输入框的popover事件
				el.popover('destroy');
				//增加错误或正确图标
				el.after("<span class='glyphicon " + feedbackClass + " form-control-feedback'></span>");
			}
			
			if (error) {
				if (isInputGroup) {
					//是input-group组合输入
						el.parent('.input-group').popover({
							container : 'body',
							trigger : 'hover',
							content : errorMsg
						});
				} else { 
					//鼠标放放入提示
					el.popover({
						container : 'body',
						trigger : 'hover',
						content : errorMsg
					});
				}
			}
		}//end !form
		return !error;
	}
}(window.jQuery);