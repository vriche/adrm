
function OaWorkFlowCheckState(){

	this.obj = {
		id:null,
		name:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    value:null
	}
	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxTarg = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.radioTarg = null;
	this.radioName = null;
	this.selectTarg = null;
	this.selectName = null;
	
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;	
}	

//Çå¿Õ¶ÔÏó
OaWorkFlowCheckState.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.value = null;
}
	
OaWorkFlowCheckState.prototype.getCheckStatesXML = function(el,name,width) {
	OaWorkFlowCheckStateManager.getOaWorkFlowCheckStates(setValueFun);
	
	function setValueFun(objs){
		var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;' >";	
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].name;
			html +="<option  value='"+ value +"'>" + lable +"</option>";		
		}
		html += "</select>";	
		el.innerHTML = html;
		
	}
}

OaWorkFlowCheckState.prototype.makeOptions = function(targetName,type,event,styleClass,without){
	var OBJ = this;
	var obj = this.obj;
	
	
//	DWREngine.setAsync(false);
	OaWorkFlowCheckStateManager.getOaWorkFlowCheckStates(fillFun,obj);
//	DWREngine.setAsync(true);

	function fillFun(objs){
		makeOptionsHtml(objs,type,targetName,"name","id",styleClass,event,without);
	}
}

OaWorkFlowCheckState.prototype.makeSelect = function(targetName,event,width,callBackFun){
	var OBJ = this;
	var obj = this.obj;
	OaWorkFlowCheckStateManager.getOaWorkFlowCheckStateSelect(obj,fillFun);	
	
	function fillFun(objs){
		makeSelectHtmlWidth(objs,targetName,event,width);
		callBackFun();
	}
}	
OaWorkFlowCheckState.prototype.makeSelectFromMap = function(targetName,event,width,callBackFun){
	
	function fillFun(objs){
		makeSelectHtmlWidth(objs,targetName,event,width);
		callBackFun();
	}	
	OaWorkFlowCheckStateManager.getOaWorkFlowCheckStateSelectFromMap(fillFun);
		


}

		