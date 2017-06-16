/* Set the defaults for DataTables initialisation */
/**
 * @author 周小欠
 * @date 2014-06-06
 * 
 */
$.extend( true, $.fn.dataTable.defaults, {
	//l=每页显示x条记录，f=查询，i=页码，p=分页
	//"sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-6'i><'col-md-6'p>>",
	sDom: "<'row'r>t<'row'<'col-md-2'l><'col-md-3'i><'col-md-7'p>>",
	oClasses : {
		"sLengthSelect": "form-control"
	},
	sPaginationType: "bootstrap",
	oLanguage: {
		"sLengthMenu": "每页_MENU_条",
		"sInfo": "第 _PAGE_ 页 / 共 _PAGES_ 页 / 共 _TOTAL_ 条",
        "sInfoEmpty": "未查询到任何数据",
        "sInfoFiltered": "(从_MAX_条记录中检索)",
		"sZeroRecords":"未查询到任何数据",
		"sEmptyTable": "未查询到任何数据",
		"sProcessing":"<div class='loading-img'></div><div class='loading-font'>正在加载</div>"
	},
	lengthMenu: [[10, 25, 50, 100], [10, 25, 50, 100]],
	iDisplayLength:10,
	processing: true,
    serverSide: true,
	ordering : false,
    searching : true
} );


/* Default class modification */
$.extend( $.fn.dataTableExt.oStdClasses, {
	"sWrapper": "dataTables_wrapper form-inline"
} );


/* API method to get paging information */
$.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
{
	return {
		"iStart":         oSettings._iDisplayStart,
		"iEnd":           oSettings.fnDisplayEnd(),
		"iLength":        oSettings._iDisplayLength,
		"iTotal":         oSettings.fnRecordsTotal(),
		"iFilteredTotal": oSettings.fnRecordsDisplay(),
		"iPage":          oSettings._iDisplayLength === -1 ?
			0 : Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
		"iTotalPages":    oSettings._iDisplayLength === -1 ?
			0 : Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
	};
};


/* Bootstrap style pagination control */
$.extend( $.fn.dataTableExt.oPagination, {
	"bootstrap": {
		"fnInit": function( oSettings, nPaging, fnDraw ) {
			var oLang = oSettings.oLanguage.oPaginate;
			var fnClickHandler = function ( e ) {
				e.preventDefault();
				if ( oSettings.oApi._fnPageChange(oSettings, e.data.action) ) {
					fnDraw( oSettings );
				}
			};

			$(nPaging).addClass('pagination').append(
				'<ul class="pagination">'+
					'<li class="first disabled"><a href="#">首页</a></li>'+
					'<li class="prev disabled"><a href="#">上页</a></li>'+
					'<li class="next disabled"><a href="#">下页</a></li>'+
					'<li class="last disabled"><a href="#">尾页</a></li>'+
				'</ul>'
			);
			var els = $('a', nPaging);
//			$(els[0]).bind( 'click.DT', { action: "previous" }, fnClickHandler );
//			$(els[1]).bind( 'click.DT', { action: "next" }, fnClickHandler );
			$(els[0]).bind( 'click.DT', { action: "first" }, fnClickHandler );
			$(els[1]).bind( 'click.DT', { action: "previous" }, fnClickHandler );
			$(els[2]).bind( 'click.DT', { action: "next" }, fnClickHandler );
			$(els[3]).bind( 'click.DT', { action: "last" }, fnClickHandler );
		},

		"fnUpdate": function ( oSettings, fnDraw ) {
			var iListLength = 5;
			var oPaging = oSettings.oInstance.fnPagingInfo();
			var an = oSettings.aanFeatures.p;
			var i, ien, j, sClass, iStart, iEnd, iHalf=Math.floor(iListLength/2);

			if ( oPaging.iTotalPages < iListLength) {
				iStart = 1;
				iEnd = oPaging.iTotalPages;
			}
			else if ( oPaging.iPage <= iHalf ) {
				iStart = 1;
				iEnd = iListLength;
			} else if ( oPaging.iPage >= (oPaging.iTotalPages-iHalf) ) {
				iStart = oPaging.iTotalPages - iListLength + 1;
				iEnd = oPaging.iTotalPages;
			} else {
				iStart = oPaging.iPage - iHalf + 1;
				iEnd = iStart + iListLength - 1;
			}

			for ( i=0, ien=an.length ; i<ien ; i++ ) {
				// Remove the middle elements
				//$('li:gt(0)', an[i]).filter(':not(:last)').remove();
				$('li:gt(1)', an[i]).filter(':not(.next)').filter(':not(.last)').remove();
				// Add the new list items and their event handlers
				for ( j=iStart ; j<=iEnd ; j++ ) {
					sClass = (j==oPaging.iPage+1) ? 'class="active"' : '';
					$('<li '+sClass+'><a href="#">'+j+'</a></li>')
						//.insertBefore( $('li:last', an[i])[0] )
						.insertBefore( $('li.next', an[i])[0] )
						.bind('click', function (e) {
							e.preventDefault();
							oSettings._iDisplayStart = (parseInt($('a', this).text(),10)-1) * oPaging.iLength;
							fnDraw( oSettings );
						} );
				}

				// Add / remove disabled classes from the static elements
				if ( oPaging.iPage === 0 ) {
					$('li.first', an[i]).addClass('disabled');
					$('li.prev', an[i]).addClass('disabled');
				} else {
					//$('li:first', an[i]).removeClass('disabled');
					$('li.first', an[i]).removeClass('disabled');
					$('li.prev', an[i]).removeClass('disabled');
				}

				if ( oPaging.iPage === oPaging.iTotalPages-1 || oPaging.iTotalPages === 0 ) {
					$('li.next', an[i]).addClass('disabled');
					$('li.last', an[i]).addClass('disabled');
				} else {
					//$('li:last', an[i]).removeClass('disabled');
					$('li.next', an[i]).removeClass('disabled');
					$('li.last', an[i]).removeClass('disabled');
				}
			}
		}
	}
} );

/*
 * TableTools Bootstrap compatibility
 * Required TableTools 2.1+
 */
if ( $.fn.DataTable.TableTools ) {
	// Set the classes that TableTools uses to something suitable for Bootstrap
	$.extend( true, $.fn.DataTable.TableTools.classes, {
		"container": "DTTT btn-group",
		"buttons": {
			"normal": "btn",
			"disabled": "disabled"
		},
		"collection": {
			"container": "DTTT_dropdown dropdown-menu",
			"buttons": {
				"normal": "",
				"disabled": "disabled"
			}
		},
		"print": {
			"info": "DTTT_print_info modal"
		},
		"select": {
			"row": "active"
		}
	} );

	// Have the collection use a bootstrap compatible dropdown
	$.extend( true, $.fn.DataTable.TableTools.DEFAULTS.oTags, {
		"collection": {
			"container": "ul",
			"button": "li",
			"liner": "a"
		}
	} );
}

function calcDataTablesHeight($parent, $slibings) {
	var parentHeight = $parent.height();
	var wrapperHeight = parentHeight - 81;
	if($slibings) {
		wrapperHeight = wrapperHeight - $slibings.height() - 2;
	}
	/**
	if($(".searchPanel")) {
		wrapperHeight = wrapperHeight - $(".searchPanel").height() - 2;
	}*/
	return wrapperHeight;
}

function reWidthDataTables() {
	$("div.dataTables_wrapper div.dataTables_scrollHeadInner").css("width", "100%");
	$("div.dataTables_wrapper div.dataTables_scrollHeadInner table.dataTable").css("width", "100%");
}
