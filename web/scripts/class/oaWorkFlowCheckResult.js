
function OaWorkFlowCheckResult(){

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
OaWorkFlowCheckResult.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.value = null;
}	

OaWorkFlowCheckResult.prototype.makeOptions = function(targetName,type,event,styleClass,without){
	var OBJ = this;
	var obj = this.obj;
	OaWorkFlowCheckResultManager.getOaWorkFlowCheckResults(fillFun,obj);	
	function fillFun(objs){
		makeOptionsHtml(objs,type,targetName,"name","id",styleClass,event,without);
	}
}

OaWorkFlowCheckResult.prototype.makeSelect = function(targetName,event){
	var OBJ = this;
	var obj = this.obj;
	OaWorkFlowCheckResultManager.getWorkFlowCheckResultsSelect(fillFun,obj);	
	function fillFun(objs){
		makeSelectHtml(objs,targetName);
	}
}	





	