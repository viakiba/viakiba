(function($) {

/**
 *
 * 图片上传前预览插件
 * @author 马德成
 * @date 2014-12-8
 * 
 */
 $.fn.uploadPreview = function(opts){
	 if (this.length < 1){
		 return this;
	 }
	
	var $this = $(this);
	var msie = $.fn.uploadPreview.msie;// IE版本

	opts = $.extend({
			container: '#preView',
			css:{},		 //设置按钮的样式map类型
			text:'浏览图片', //按钮上的文字
			width: '100%', //图片宽度,如果width和height只设置其中一个,
						 //则没有设置的属性按等比缩放,都为null则显示原始图像大小
						 //可以设置百分比(基于容器的大小按比例进行缩放)
			height: '100%',//图片高度, 数字或string类型
            maxSize:1024*1024*2,//图片大小
			imgType: ["gif", "jpeg", "jpg", "bmp", "png"], //支持的图片格式 ["gif", "jpeg", "jpg", "bmp", "png"]
			onTypeError:$.noop, //当文件类型发生错误时处理的函数
			onSizeError:$.noop, //当文件大小发生错误时处理的函数
			callback:function(){return true;} // function（input）预览之前的回调函数， 该函数返回false则不预览, input为文件域
		}, opts || {});

	

	if(msie) { //IE 浏览器
		if(msie == 6) { //IE6
			//<change>
			$.fn.uploadPreview.loopInput($this, opts, function (input) {debugger
				$(input).change({opts:opts}, function() {
					if(!$.fn.uploadPreview.checkFileType(input.value, opts)) {
						
						input.value = '';
						return false;
					}
					
					if(opts.callback.call(input, input)){
						$.fn.uploadPreview.getImage(opts).attr('src', 'file:///' + input.value);
					}
				});
				
			});
			
			//</change>
			return $this;
		}
		
		// 大于IE6
		//<change>
		$.fn.uploadPreview.loopInput($this, opts, function (input) {
			$(input).change({opts:opts}, function() {
				if(!$.fn.uploadPreview.checkFileType(input.value, opts)) {
					input.value = '';
					return false;
				}

				var innerDiv = $('<div/>');
				var container = $(opts.container);
				container.empty().prepend(innerDiv);

				input.select();
				input.blur();
				var imgSrc = document.selection.createRange().text;
				if(opts.callback.call(input, input)){
					try {
							innerDiv.css('filter', 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)');
							innerDiv[0].filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
							
							innerDiv.css($.fn.uploadPreview.getImageWH($(opts.container), opts.width, opts.height, imgSrc));
						} catch (e) {
							//alert("您上传的图片格式不正确，请重新选择!");
							return false;
						}
						
						$('.upload-pre-view-image', container).hide();
						document.selection.empty();
				}
			});

		});
		
		//</change>

		return $this;
	}

	//非IE浏览器
	//<change>
	$.fn.uploadPreview.loopInput($this, opts, function (input) {
		$(input).change({opts:opts}, function (){
			if(!$.fn.uploadPreview.checkFileType(input.value, opts)) {
				input.value = '';
				return false;
			}

            //图片大于指定大小
			if(input.files[0].size > opts.maxSize){
				input.value = '';
				opts.onSizeError.call();
				return false;
			}
			
			if(opts.callback.call(input, input)){
				$.fn.uploadPreview.getImage(opts).attr('src', URL.createObjectURL(input.files[0]));
			}
		});
	});
	
	//</change>
	return $this;
 };

//检测IE版本,不是每次获取,而是在初始化时只执行一次
 $.fn.uploadPreview.msie = (function() {
		var undef,
		v = 3,
		div = document.createElement('div'),
		all = div.getElementsByTagName('i');
		while ( div.innerHTML = '<!--[if gt IE ' + (++v) + ']><i></i><![endif]-->', all[0]);
		return v > 4 ? v : undef;
})();

//检测文件类型
$.fn.uploadPreview.checkFileType = function(value, opts){
	if(value) {
		 if (!RegExp('\.(' + opts.imgType.join('|') + ')$', 'i').test(value)) {
			//alert('图片类型必须是' + opts.imgType.join(', ') + '中的一种');
			opts.onTypeError.call(null);
			return false;
		}
		return true;
	}

	return false;
};

//获取图片对象
$.fn.uploadPreview.getImage = function(opts){
	var img = $('.upload-pre-view-image', opts.container); //获取图片
	if(img.length > 0) {
		return img;
	}

	var wh = {};
	var container = $(opts.container);

	if(opts.width) {
		if(isNaN(opts.width)) {
			opts.width = $.trim(opts.width);
			if(opts.width.lastIndexOf('%') != -1) {
				wh.width = ((container.width() * (opts.width.split('%')[0]-0))/100) + 'px';
			} else {
				wh.width = opts.width;
			}
		} else {
			wh.width = opts.width + 'px';
		}
	}

	if(opts.height) {
		if(isNaN(opts.height - 0)) {
			opts.height = $.trim(opts.height);
			if(opts.height.lastIndexOf('%') != -1) {
				wh.height = ((container.height() * (opts.height.split('%')[0]-0))/100) + 'px';
			} else {
				wh.height = opts.height;
			}
		} else {
			wh.height = opts.height + 'px';
		}
	}

	img = $('<img />');
	img.addClass('upload-pre-view-image');
	img.css(wh);//设置高宽

	$(opts.container).empty().prepend(img);
	img = $('.upload-pre-view-image', opts.container); //获取图片
	return img;
};

//获取图片需要缩放的高和宽
$.fn.uploadPreview.getImageWH = function (container, width, height, imgSrc){
	var wh = {}; //存储图片需要缩放的宽和高

	if(width) { //如果width有值

		if(isNaN(width - 0)) {
			width = $.trim(width);
			if(width.lastIndexOf('%') != -1) {
				wh.width = ((container.width() * (width.split('%')[0]-0))/100) + 'px';
			} else {
				wh.width = width;
			}
		} else {
			wh.width = width + 'px';
		}

		if(height) { //高度有值,则直接返回指定值,不需要缩放处理
			if(isNaN(height - 0)) {
				height = $.trim(height);
				if(height.lastIndexOf('%') != -1) {
					wh.height = ((container.height() * (height.split('%')[0]-0))/100) + 'px';
				} else {
					wh.height = height;
				}
			} else {
				wh.height = height + 'px';
			}
			return wh;
		} 

		//计算图片需要缩放的大小
		var img = new Image(); //创建一个对象
		img.src = imgSrc; //图片大小

		var w = wh.width.toLowerCase().split('px')[0] - 0;
		if(w != img.width) {
			wh.height = ((w/img.width) * img.height) + 'px';
		}
		return wh;
	}

	//height
	if(height) {

		if(isNaN(height - 0)) {
			wh.height = height;
		} else {
			wh.height = height + 'px';
		}

		//计算图片需要缩放的大小
		var img = new Image(); //创建一个对象
		img.src = imgSrc; //图片大小

		var h = wh.height.toLowerCase().split('px')[0] - 0;
		if(img.height != h) {
			wh.width = ((h/img.height) * img.width) + 'px';
		}

		return wh;
	}

	//如果宽度和高度都设置为null,则设置为图片的原始大小
	//计算图片需要缩放的大小
	var img = new Image(); //创建一个对象
	img.src = imgSrc; //图片大小
	if(img.width) wh.width = img.width;
	if(img.height) wh.height = img.height;

	return wh;
};

//循环input元素
$.fn.uploadPreview.loopInput = function (obj, opts, callback){
	
	var file;
	for (var i=0; i< obj.length; i++ ) {
		file = obj[i];
		
		if (file.tagName.toLowerCase() == 'input' && $(file).attr('type').toLowerCase() == 'file' ){
			$(file).wrap('<span class="upload-pre-view"></span>').before('<span>' + opts.text + '</span>');
			$(file).parent().css(opts.css);
			callback(file);
		} 
	
	}
};


/*$('head').append(function(){
	return '<style>.upload-pre-view{-moz-user-select:none;border:1px solid transparent;border-radius:3px;cursor:pointer;display:inline-block;font-size:13px;line-height:1.42857;margin-bottom:0;padding:5px 12px;text-align:center;vertical-align:middle;white-space:nowrap;overflow:hidden;position:relative;background-color:#5cb85c;border-color:#4cae4c;color:#fff;}.upload-pre-view:hover{color:#FFF;background-color:#449D44;border-color:#398439;}.upload-pre-view input{width:9999px;display:block;cursor:pointer;direction:ltr;font-size:200px;margin:0;opacity:0;filter:alpha(opacity=0);height:100%;*+font-size:130%;position:absolute;right:0;top:0;font-family:inherit;}</style>'
});*/

})(jQuery);