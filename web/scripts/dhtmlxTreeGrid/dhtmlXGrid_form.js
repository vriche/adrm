dhtmlXGridObject.prototype.attachHeaderA=dhtmlXGridObject.prototype.attachHeader;
dhtmlXGridObject.prototype.attachHeader=function()
{
	this.attachHeaderA.apply(this,arguments);
	this.formAutoSubmit();
	this.submitOnlyChanged(true);
}

dhtmlXGridObject.prototype.formAutoSubmit = function()
{
	this.parentForm = this.detectParentFormPresent();
	if (this.parentForm === false) {
		return false;
	}
	if (this.formEventAttached)
		return;
    this.formInputs = new Array();
	var self = this;
	dhtmlxEvent(this.parentForm, 'submit', function() {self.parentFormOnSubmit();});
	this.formEventAttached = true;
}

dhtmlXGridObject.prototype.parentFormOnSubmit = function()
{
	this.formCreateInputCollection();
}

dhtmlXGridObject.prototype.submitOnlyChanged = function(mode)
{
	this.FormSubmitOnlyChanged = convertStringToBoolean(mode);
}



dhtmlXGridObject.prototype.formCreateInputCollection = function()
{
	if (this.parentForm == false) {
		return false;
	}
	for (var i=0; i<this.formInputs.length; i++) {
		this.parentForm.removeChild(this.formInputs[i]);
	}
    this.formInputs = new Array();
    var row_length = this.rowsCol.length;
	var col_length = this._cCount;
    for (var i=0; i<row_length; i++) {
    	for (var j=0; j<col_length; j++) {
    		var foo_cell = this.cells(this.rowsCol[i].idd, j);
    		var isChanged = foo_cell.wasChanged();
    		if (!(this.FormSubmitOnlyChanged && !isChanged)) {
	            var input = document.createElement('input');
	            input.type = 'hidden';
	            input.name =(this.entBox.id||'dhtmlXGrid')+'_'+this.rowsCol[i].idd+'_'+j;
	            input.value = foo_cell.getValue();
	            this.parentForm.appendChild(input);
	            this.formInputs.push(input);
    		}
    	}
    }
}

dhtmlXGridObject.prototype.detectParentFormPresent = function()
{
	var parentForm = false;
	var parent = this.entBox;
	while(parent != document.body) {
		if (parent.tagName.toLowerCase() == 'form') {
			parentForm = parent;
			break;
		} else {
        	parent = parent.parentNode;
		}
	}
	return parentForm;
}
