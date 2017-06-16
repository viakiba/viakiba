/**
 * 该对象主要用于页面级校验,开发人员可根据需要通过 <br>
 * <p>
 * <script type="text/javascript" src="../校验/Validator.js"></script>
 * </p>
 * 方式将该js引入到相应的页面,通过在需校验的HTML标签上定义一些扩展属性即可,在Form提交事件中像如下方式调用来进行表单校验：<br>
 * <p>
 * <script language="javascript">
 *     function checkform(form) {
 *          // @param {form} 表单form对象，如果只有一个form可通过document.forms[0]来取得该form对象
 *          // @param {mode} : 校验模式，目前支持三种模式,具体值及涵义如下:
 *          //				   不传 : 则以alert方式弹出校验提示信息
 *          //				   2   : 以alert方式弹出校验提示信息,同时对select和textare标签内的字体红色显示
 *          //				   3   : 则在相应的校验项右边以红色字体进行提示 
 *          // @return boolean : true,通过校验; false:校验失败,并按照校验模式,给出不同的提示信息
 *         return Validator.Validate(form,2);
 *     }
 * </script>
 * </p>
 * 该组件的调用还需要对需要校验的页面元素添加一些扩展属性，这些扩展属性有：
 * 			 require, dataType, msg, to, regexp, format, min, max, accept, operator
 * request : 用来指定元素是否必输项，是和dataType配合使用
 * 			 如果不指定，则默认为true，在表单提交时根据dataType进行校验；
 * 			 如果指定为false，则表示该项为非必输项，只有输入有值才根据dataType进行校验，否则不进行校验
 * dataType : 指定校验的类型，目前支持的数据校验类型有：
 * 			 IdCard | Chinese | Username | English | Url | SafeString | Repeat | Email | QQ | Range | 
 * 			 Compare | Phone | Mobile | Date | Custom | Zip | Require | Group | Limit | LimitB | Filter
 * 			 其中：dataType="Require"主要针对select进行校验，要求必须选择一项
 * 				  dataType="Group"主要针对radio和checkbox进行分组校验
 * 				  dataType="Username"主要真对用户名，其校验规则是第一个字符必须为a-z中的任意一个字符,后边必须是三个或者三个以上包括下划线的任何单词字符
 * 				  dataType="SafeString"主要对密码的安全度进行校验
 * 				  dataType="Chinese"主要校验是否中文
 * 			 其他dataType可参考对应的实例。
 * msg      : 提示信息
 * to       : 目标值或页面元素名称，当和dataType="Repeat"配合使用时，to指定目标元素的名称；当和dataType="Compare"配合使用时，to指定目标值
 * regexp   : 正则表达式，必须和Custom配合使用，当dataType指定为Custom时，将自动根据regexp指定的正则表达式来进行校验
 * format   : 和dataType="Date"配合使用，主要对日期进行格式化，目前支持两种格式ymd、dmy
 * min      : 和dataType="Group"、dataType="Limit"、dataType="LimitB"、dataType="Range"配合使用,分别指定对应类型的下限
 * max      : 和dataType="Group"、dataType="Limit"、dataType="LimitB"、dataType="Range"配合使用,分别指定对应类型的上限
 * accept   : 和dataType="Filter"配合使用，指定过滤的文件扩展名，如accept="jpg, gif, png"，表示只支持三种类型文件的上传
 * operator : 和dataType="Compare"配合使用，指定比较方式
 * 			  目前支持：NotEqual、GreaterThan、GreaterThanEqual、LessThan、LessThanEqual比较，如果不指定默认为是否相等比较
 * 简单示例：身份证号：<input name="Card" dataType="IdCard" msg="身份证号错误">
 * 		   邮政编码(通过自己写的正则表达式进行校验)：<input name="Zip" dataType="Custom" regexp="^[1-9]\d{5}$" msg="邮政编码不存在">
 * 该对象同时具有良好的扩展性，可根据需要进行注册不同的校验方式或者通过自己写正则表达式来进行校验<br>
 *
 * @author <a href=../校验/Administrator@htjs.net>Administrator</a>
 * @version v1.05
 * @Date 2007-07-06
 */
 Validator = {
	Require : /.+/,
	ZwSzYw:"this.isZwSzYw(value)", //只能输入中文英文和数字
	Email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
	Phone : /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/,
	Mobile : /^((\(\d{2,3}\))|(\d{3}\-))?1(3|5|8)\d{9}$/,
	Url : /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
	IdCard : "this.IsIdCard(value,'zip')",
	IdCard2 : /^\d{17}(X|x|\d)$/,
	Currency : /^\d+(\.\d+)?$/,
	versionInfo:/(^\d+$)|(^\d+\.\d+$)|(^\d+\.\d+\.\d+$)|(^\d+\.\d+\.\d+\.\d+$)/,
	Number : /^\d+$/,
	Zip : "this.isZipFile(value,'zip')",
	Png : "this.isZipFile(value,'png,jpg,gif')",
	QQ : /^[1-9]\d{4,8}$/,
	Integer : /^[-\+]?\d+$/,
	Double : /^[-\+]?\d+(\.\d+)?$/,
	English : /^[A-Za-z]+$/,
	Chinese :  /^[\u0391-\uFFE5]+$/,
	Account : /^([a-zA-Z0-9_]){4,12}$/,//用于校验用户账号
	password:/^([a-zA-Z0-9_]){6,12}$/,//用于校验密码
	Username : /^[a-z]\w{3,}$/i,//第一个字符必须为a-z,后边必须是三个或者三个以上包括下划线的任何单词字符
	UnSafe : /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
	IsSafe : function(str){return !this.UnSafe.test(str);},
	SafeString : "this.IsSafe(value)",
	Filter : "this.DoFilter(value, getAttribute('accept'))",
	Limit : "this.limit(value.length,getAttribute('min'),  getAttribute('max'))",
	LimitB : "this.limit(this.LenB(value), getAttribute('min'), getAttribute('max'))",
	Date : "this.IsDate(value, getAttribute('min'), getAttribute('format'))",
	Repeat : "value == document.getElementsByName(getAttribute('to'))[0].value",
	RepeatB : "value == document.getElementsByName(getAttribute('to'))[1].value",
	Range : "getAttribute('min') < (value|0) && (value|0) < getAttribute('max')",
	Compare : "this.compare(value,getAttribute('operator'),getAttribute('to'))",
	Custom : "this.Exec(value, getAttribute('regexp'))",
	Group : "this.MustChecked(getAttribute('name'), getAttribute('min'), getAttribute('max'))",
	ErrorItem : [document.forms[0]],
	ErrorMessage : ["以下原因导致提交失败：\t\t\t\t"],
	//TagFilter : "INPUT,SELECT,TEXTAREA",//只对在此定义的标签进行校验
	/**
	 * Validate对象，处理表单校验
	 * @param {theForm} : 表单对象
	 * @param {mode} : 校验模式，目前支持三种模式,具体值及涵义如下:
	 *                 不传 : 则以alert方式弹出校验提示信息
	 *                 2   : 以alert方式弹出校验提示信息,同时对select和textare标签内的字体红色显示
	 *                 3   : 则在相应的校验项右边以红色字体进行提示 
	 * @return boolean : true,通过校验; false:校验失败,并按照校验模式,给出不同的提示信息
	 */
	Validate : function(theForm, mode){
    var obj = theForm || event.srcElement;
		var count = obj.elements.length;
		this.ErrorMessage.length = 1;
		this.ErrorItem.length = 1;
		this.ErrorItem[0] = obj;
		for(var i=0;i<count;i++){
			with(obj.elements[i]){
				//if(this.TagFilter.indexOf(tagName)<0 || getAttribute("type").toUpperCase=="BUTTON" || getAttribute("type").toUpperCase=="RESET" || getAttribute("type").toUpperCase=="SUBMIT") continue;
				var _dataType = getAttribute("dataType");
				if(typeof(_dataType) == "object" || typeof(this[_dataType]) == "undefined")  continue;
				this.ClearState(obj.elements[i]);
				if(getAttribute("require") == "false" && value == "") continue;
				switch(_dataType){
					case "IdCard" :
					case "Date" :
					case "Repeat" :
					case "RepeatB" :
					case "Range" :
					case "Compare" :
					case "Custom" :
					case "Group" : 
					case "Limit" :
					case "LimitB" :
					case "SafeString" :
					case "Zip" :
					case "ZwSzYw":
					case "Filter" :
						if(!eval(this[_dataType]))	{//非正则表达式的校验
							this.AddError(i, getAttribute("msg"));
						}
						break;
					default :
						if(!this[_dataType].test(value)){//带正则表达式的校验
							this.AddError(i, getAttribute("msg"));
						}
						break;
				}
			}
		}
		if(this.ErrorMessage.length > 1){
			mode = mode || 3; //缺省情况下采用第一种模式来进行校验
			
			var errCount = this.ErrorItem.length;
			switch(mode){
			case 2 :
				for(var i=1;i<errCount;i++)
					this.ErrorItem[i].style.color = "red";
			case 1 :
				alert(this.ErrorMessage.join("\n"));
				this.ErrorItem[1].focus();
				break;
			case 3 :
				for(var i=1;i<errCount;i++){
				try{
					var span = document.createElement("SPAN");
					span.id = "__ErrorMessagePanel";
					span.style.color = "red";
					this.ErrorItem[i].parentNode.appendChild(span);
					span.innerHTML = this.ErrorMessage[i].replace(/\d+:/,"*");
					}
					catch(e){alert(e.description);}
				}
//				this.ErrorItem[1].focus();
				break;
			default :
				alert(this.ErrorMessage.join("\n"));
				break;
			}
			return false;
		}
		return true;
	},
	isZwSzYw:function(value){
		if($.trim(value)==''){
			return false;
		}
		var reg = /^(\w|[\u4E00-\u9FA5])*$/; 
		if(arr=value.match(reg)) 
		{ 
		ti=1; 
		return true; 
		} 
		else 
		{ 
		ti=0; 
		return false; 
		} 
	},
	/**
	 * 对输入长度进行校验,只按照输入字符的个数进行检验,不论是数字 汉字还是字母都按照长度1来进行校验<br>
	 * @param {len} : 已输入值得长度
	 * @param {min} : 长度下限,如果不传,则为0
	 * @param {max} : 长度上限,如果不传,则为Number类型的最大值
	 * @return boolean : true,成功; false:失败
	 */
	limit : function(len,min, max){
		min = min || 0;
		max = max || Number.MAX_VALUE;
		return min <= len && len <= max;
	},
	/**
	 * 按照一个汉字两个长度的规则统计一个字符串的长度<br>
	 * @param {str} : 输入的字符串
	 * @return 统计后的字节长度
	 */
	LenB : function(str){
		return str.replace(/[^\x00-\xff]/g,"**").length;
	},
	ClearState : function(elem){//清除红色高亮显示的状态
		with(elem){
			if(style.color == "red")
				style.color = "";
			var lastNode = parentNode.childNodes[parentNode.childNodes.length-1];
			if(lastNode.id == "__ErrorMessagePanel")
				parentNode.removeChild(lastNode);
		}
	},
	AddError : function(index, str){
		this.ErrorItem[this.ErrorItem.length] = this.ErrorItem[0].elements[index];
		this.ErrorMessage[this.ErrorMessage.length] = this.ErrorMessage.length + ":" + str;
	},
	/**
	 * 根据开发人员提供的正则表达式来对用户输入的值进行校验<br>
	 * @param {op}  : 输入的值
	 * @param {reg} : 用于对值进行校验的正则表达式
	 * @return 
	 */
	Exec : function(op, reg){
		return new RegExp(reg,"g").test(op);
	},
	/**
	 * 将输入值和目标值按照规则来进行比较<br>
	 * @param {op1}  : 用户输入的值
	 * @param {operator}  : 比较规则
	 * @param {op2} : 目标值
	 * @return 
	 */
	compare : function(op1,operator,op2){
		switch (operator) {
			case "NotEqual":
				return (op1 != op2);
			case "GreaterThan":
				return (op1 > op2);
			case "GreaterThanEqual":
				return (op1 >= op2);
			case "LessThan":
				return (op1 < op2);
			case "LessThanEqual":
				return (op1 <= op2);
			default:
				return (op1 == op2);            
		}
	},
	/**
	 * <br>
	 * @param {name} : 
	 * @param {min}  : 上限
	 * @param {max}  : 下限
	 * @return 
	 */
	MustChecked : function(name, min, max){
		var groups = document.getElementsByName(name);
		var hasChecked = 0;
		min = min || 1;
		max = max || groups.length;
		for(var i=groups.length-1; i>=0; i--)
			if(groups[i].checked) hasChecked++;
		return min <= hasChecked && hasChecked <= max;
	},
	DoFilter : function(input, filter){//对文件类型进行过滤
return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, filter.split(/\s*,\s*/).join("|")), "gi").test(input);
	},
	IsIdCard : function(number){
		var date, Ai;
		var verify = "10x98765432";
		var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
		var area = ['','','','','','','','','','','','北京','天津','河北','山西','内蒙古','','','','','','辽宁','吉林','黑龙江','','','','','','','','上海','江苏','浙江','安微','福建','江西','山东','','','','河南','湖北','湖南','广东','广西','海南','','','','重庆','四川','贵州','云南','西藏','','','','','','','陕西','甘肃','青海','宁夏','新疆','','','','','','台湾','','','','','','','','','','香港','澳门','','','','','','','','','国外'];
		var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[Xx\d])))$/i);
		if(re == null) return false;
		if(re[1] >= area.length || area[re[1]] == "") return false;
		if(re[2].length == 12){
			Ai = number.substr(0, 17);
			date = [re[9], re[10], re[11]].join("-");
		}
		else{
			Ai = number.substr(0, 6) + "19" + number.substr(6);
			date = ["19" + re[4], re[5], re[6]].join("-");
		}
		if(!this.IsDate(date, "ymd")) return false;
		var sum = 0;
		for(var i = 0;i<=16;i++){
			sum += Ai.charAt(i) * Wi[i];
		}
		Ai +=  verify.charAt(sum%11);
		return (number.length == 18 && number.toUpperCase() == Ai.toUpperCase());
	},
	IsDate : function(op, formatString){//校验是否日期类型
		formatString = formatString || "ymd";
		var m, year, month, day;
		switch(formatString){
			case "ymd" :
				m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
				if(m == null ) return false;
				day = m[6];
				month = m[5]*1;
				year =  (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
				break;
			case "dmy" :
				m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
				if(m == null ) return false;
				day = m[1];
				month = m[3]*1;
				year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));
				break;
			default :
				break;
		}
		if(!parseInt(month)) return false;
		month = month==0 ?12:month;
		var date = new Date(year, month-1, day);
        return (typeof(date) == "object" && year == date.getFullYear() && month == (date.getMonth()+1) && day == date.getDate());
		function GetFullYear(y){return ((y<30 ? "20" : "19") + y)|0;}
	}
	,isZipFile:function(value,str){
		value = value.toLowerCase();
		var strs = str.split(",");
		for ( var i = 0; i < strs.length; i++) {
			var reg1 = new RegExp(strs[i]+"$");
			if(reg1.test(value)){
				return true;
			}
		}
	}
 }