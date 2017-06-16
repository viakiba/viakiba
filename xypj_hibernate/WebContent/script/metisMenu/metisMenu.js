/*
 * metismenu - v1.1.3
 * Easy menu jQuery plugin for Twitter Bootstrap 3
 * https://github.com/onokumus/metisMenu
 *
 * Made by Osman Nuri Okumus
 * Under MIT License
 */
;(function($, window, document, undefined) {

    var pluginName = "metisMenu",
        defaults = {
            toggle: true,
            doubleTapToGo: false,
            loadPageContainer:".dashbord-main"
        };

    function Plugin(element, options) {
        this.element = $(element);
        this.settings = $.extend({}, defaults, options);
        this._defaults = defaults;
        this._name = pluginName;
        this.init();
    }

    Plugin.prototype = {
        init: function() {

            var $this = this.element,
                $toggle = this.settings.toggle,
                obj = this;
            if (this.isIE()) {
                $this.find("li.active").has("ul").children("ul").collapse("show");
                $this.find("li").not(".active").has("ul").children("ul").collapse("hide");
            } else {
                $this.find("li.active").has("ul").children("ul").addClass("collapse in");
                $this.find("li").not(".active").has("ul").children("ul").addClass("collapse");
            }

            //add the "doubleTapToGo" class to active items if needed
            if (obj.settings.doubleTapToGo) {
                $this.find("li.active").has("ul").children("a").addClass("doubleTapToGo");
            }

            $ali = $this.find("li");
            $pli = $this.find("li").has("ul");
            $cli = $ali.not($pli);
            //有子菜单，点击展开或隐藏子菜单
            $pli.children("a").on("click" + "." + pluginName, function(e) {
                e.preventDefault();
                //Do we need to enable the double tap
                if (obj.settings.doubleTapToGo) {

                    //if we hit a second time on the link and the href is valid, navigate to that url
                    if (obj.doubleTapToGo($(this)) && $(this).attr("href") !== "#" && $(this).attr("href") !== "") {
                        e.stopPropagation();
                        document.location = $(this).attr("href");
                        return;
                    }
                }

                $(this).parent("li").toggleClass("active").children("ul").collapse("toggle");

                if ($toggle) {
                    $(this).parent("li").siblings().removeClass("active").children("ul.in").collapse("hide");
                }

            });
            //无子菜单，点击打开连接
            $cli.children("a").on("click", function(e) {
                e.preventDefault();
                var href = $(this).attr("href");
                if(href && href.indexOf("#") != 0) {
            		$(this).parent("li").addClass("active");
            		if ($toggle) {
            			$(".dashbord-sidebar .active").not($(this).parents("li"))
            				.removeClass("active").children("ul.in").collapse("hide");
                    }
                   
            		$(obj.settings.loadPageContainer).load(href, null, function(response, status, xhr){
            			if(xhr.status === 200) {
            				$(this)[0].scrollTop = 0; //加载成功后，将DIV的滚动条设置到顶部
            			} else if(xhr.status === 404) {
            	    		//找不着
            	    		$(this).html('<div class="page404"></div>');
            	    	} else if(xhr.status === 403) {
            	    		//无权限
            	    		$(this).html('<div class="page403"></div>');
            	    	} else if(xhr.status === 500) {
            	    		//服务器错误
            	    		$(this).html('<div class="page500"></div>');
            	    	}
            		});
                }
            });
        },

        isIE: function() { //判断是否是IE9及以下浏览器版本
        	var isIE = /msie 9.0|msie 8.0|msie 7.0/.test(navigator.userAgent.toLowerCase());
        	return isIE;
        },

        //Enable the link on the second click.
        doubleTapToGo: function(elem) {
            var $this = this.element;

            //if the class "doubleTapToGo" exists, remove it and return
            if (elem.hasClass("doubleTapToGo")) {
                elem.removeClass("doubleTapToGo");
                return true;
            }

            //does not exists, add a new class and return false
            if (elem.parent().children("ul").length) {
                 //first remove all other class
                $this.find(".doubleTapToGo").removeClass("doubleTapToGo");
                //add the class on the current element
                elem.addClass("doubleTapToGo");
                return false;
            }
        },

        remove: function() {
            this.element.off("." + pluginName);
            this.element.removeData(pluginName);
        }

    };

    $.fn[pluginName] = function(options) {
        this.each(function () {
            var el = $(this);
            if (el.data(pluginName)) {
                el.data(pluginName).remove();
            }
            el.data(pluginName, new Plugin(this, options));
        });
        return this;
    };

})(jQuery, window, document);