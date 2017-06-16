/*!
 * jQuery Input Ip Address Control : v0.1beta (2010/11/09 16:15:43)
 * Copyright (c) 2010 jquery-input-ip-address-control@googlecode.com
 * Licensed under the MIT license and GPL licenses.
 *
 */
(function($){
        String.prototype.isIpv4 = function() {
                rgx = /\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\b/ ;
                return rgx.test(this.toString());
        };
        String.prototype.isIpv6 = function() {
                rgx = /\b([A-F0-9]{1,4}:){7}([A-F0-9]{1,4})\b/i ;
                return rgx.test(this.toString());
        };
        $.fn.extend({
                //Helper Function for Caret positioning
                caret: function(begin, end) {
                        if (this.length == 0) return;
                        if (typeof begin == 'number') {
                                end = (typeof end == 'number') ? end : begin;
                                return this.each(function() {
                                        if (this.setSelectionRange) {
                                                this.focus();
                                                this.setSelectionRange(begin, end);
                                        } else if (this.createTextRange) {
                                                var range = this.createTextRange();
                                                range.collapse(true);
                                                range.moveEnd('character', end);
                                                range.moveStart('character', begin);
                                                range.select();
                                        }
                                });
                        } else {
                                if (this[0].setSelectionRange) {
                                        begin = this[0].selectionStart;
                                        end = this[0].selectionEnd;
                                } else if (document.selection && document.selection.createRange) {
                                        var range = document.selection.createRange();
                                        begin = 0 - range.duplicate().moveStart('character', -100000);
                                        end = begin + range.text.length;
                                }
                                return {
                                        begin: begin,
                                        end: end
                                };
                        }
                },
                ipAddress: function(s) {
                        s = $.extend({
                                v:4
                        }, s);
                        if(s.v == 4) {
                                s.rgxcase = new RegExp('[0-9]','g');
                                s.label = '___.___.___.___';
                        }
                        if(s.v == 6) {
                                s.rgxcase = new RegExp('[A-F0-9]','gi');
                                s.label = '____:____:____:____:____:____:____:____';
                        }
                        s.place = s.label.split('').pop();
                        s.separator = s.label.replace(new RegExp(s.place,'g'),'').split('').pop();
                        s.partplace = s.label.split(s.separator).pop();
                        //end settings and init
                        return $(this).each(function(){
                                var ctx = {
                                        cursor:null,
                                        buffer:null,
                                        ip:null,
                                        input:null
                                };
                                ctx.input = $(this);
                                if( ctx.input.val() =='' || !isIp(ctx.input.val()))
                                        ctx.input.val( s.label );
                                ctx.input.attr('maxlength',(s.v==4? 15 : 39)).attr('size',(s.v==4? 15 : 39));
                                
                                function isIp(ip) {
                                        return eval("ip.isIpv"+s.v+"()");
                                };
                                function loadCtx() {
                                        ctx.cursor = ctx.input.caret();
                                        ctx.ip = isIp(unmask(ctx.input.val())) ? unmask(ctx.input.val()) : ctx.ip ;
                                        ctx.buffer = ctx.input.val().split('');
                                };
                                function mask(ip) {
                                        var part = ip.split(s.separator);
                                        for(var j=0; j<part.length;j++) {
                                                while( (s.partplace.length - part[j].length) > 0)
                                                        part[j] += s.place;
                                        }
                                        return part.join(s.separator);
                                };
                                function unmask(ip) {
                                        var rgx = new RegExp(s.partplace,'g');
                                        var rgx2 = new RegExp(s.place,'g');
                                        return ip.replace(rgx,'0').replace(rgx2,'');
                                };
                                function entryNoCharacter(e) {
                                        switch(e.keyCode) {
                                                case 8: //backspace
                                                        if(ctx.buffer[ctx.cursor.end-1] != s.separator) {
                                                                ctx.buffer[ctx.cursor.end-1] = s.place;
                                                                ctx.input.val(ctx.buffer.join("")).val();
                                                        }
                                                        ctx.input.caret(ctx.cursor.end-1);
                                                        return false;
                                                        break;
                                                case 13: //enter
                                                case 27: //esc
                                                        ctx.input.blur();
                                                        break;
                                                case 46: //suppr.
                                                        if(ctx.buffer[ctx.cursor.end] != s.separator && ctx.cursor.end < s.label.length) {
                                                                ctx.buffer[ctx.cursor.end] = s.place;
                                                                ctx.input.val(ctx.buffer.join(""));
                                                        }
                                                        if(ctx.cursor.end < s.label.length) ctx.input.caret(ctx.cursor.end+1);
                                                        return false;
                                                        break;
                                        }
                                        return true;
                                };
                               
                                ctx.input.bind('keydown',function(e){
                                        loadCtx();
                                        /**
                                         * 
$.browser.mozilla = /firefox/.test(navigator.userAgent.toLowerCase());
$.browser.webkit = /webkit/.test(navigator.userAgent.toLowerCase());
$.browser.opera = /opera/.test(navigator.userAgent.toLowerCase());
$.browser.msie = /msie/.test(navigator.userAgent.toLowerCase());
                                         */
                                        //fix for webkit & IE
                                        if(/webkit/.test(navigator.userAgent.toLowerCase()) || 
                                        		/msie/.test(navigator.userAgent.toLowerCase())) {
                                                return entryNoCharacter(e);
                                        }
                                }).bind('keypress',function(e) {
                                        loadCtx();
                                        //alternative keys
                                        if (e.ctrlKey || e.altKey || e.metaKey) return true;
                                        //typeable characters
                                        else if ((e.which >= 32 && e.which <= 125) || e.which > 186) {
                                                //valid character
                                                if(String.fromCharCode(e.which).match(s.rgxcase)) { 
                                                        ctx.buffer[ctx.cursor.end] = String.fromCharCode(e.which);
                                                        if(!isIp(unmask(ctx.buffer.join('')))) {
                                                                //delete part if ip is invalid
                                                                if((ctx.cursor.end == 0 || ctx.buffer[ctx.cursor.end-1]==s.separator)) {
                                                                        for(var i=ctx.cursor.end+1 ; i<ctx.cursor.end+s.partplace.length ; i++) {
                                                                                ctx.buffer[i] = s.place;
                                                                        }
                                                                }
                                                                else return false;
                                                        }
                                                        ctx.input.val(ctx.buffer.join('')); //ok write
                                                        if(ctx.buffer[ctx.cursor.end+1] == s.separator) {
                                                                //part completed ... next part
                                                                ctx.input.caret(ctx.cursor.end+2); 
                                                        } else {
                                                                ctx.input.caret(ctx.cursor.end+1);
                                                        }
                                                        return false;
                                                } //or separator
                                                else if(s.separator.charCodeAt(0) == e.which) { 
                                                        var pos = ctx.input.val().indexOf(s.separator, ctx.cursor.end);
                                                        if(pos == -1) return false;
                                                        if(ctx.buffer[ctx.cursor.end-1]==s.separator) return false;
                                                        ctx.cursor.end = pos;
                                                        ctx.input.caret(ctx.cursor.end+1);
                                                        return false;
                                                } 
                                                else return false; // or invalid
                                        }
                                        //no character
                                        return entryNoCharacter(e);

                                }).bind('blur', function(){
                                        if(ctx.input.val() == s.label) return true;
                                        var ip = unmask($.trim(ctx.input.val()));
                                        if( isIp(ip) ) ctx.input.val(ip);
                                        else ctx.input.val( ctx.ip );

                                }).bind('focus', function(){
                                        setTimeout(function() {
                                                loadCtx();
                                                if(ctx.input.val() != s.label)
                                                        ctx.input.val( mask(ctx.ip) );
                                                ctx.input.caret(0);
                                        }, 0);
                                        
                                }).bind('paste', function (e){
                                        ctx.input.val('');
                                        setTimeout(function() {
                                                ctx.input.blur();
                                        },0);
                                });
                        });//return each
                }//ipAddress()
        });//$.fn.extends
})(jQuery);