EmpUpdateWin = Ext.extend(Ext.Window, {
	id: 'empUpdateWinId',
	constructor: function(){
		var empForm = new addEmpForm();
		EmpUpdateWin.superclass.constructor.call(this, {
			modal: true,
			width: 825,
			items: [empForm]
		});
	}
})