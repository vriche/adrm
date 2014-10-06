function OaWorkFlowType(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    parentId:null,
	    nodeLevel:null,
	    displayNo:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null
	}
	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxTarg = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.radioName = null;
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

//清空对象
OaWorkFlowType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.parentId = null;
  	this.obj.nodeLevel = null;
  	this.obj.displayNo = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

OaWorkFlowType.prototype.makeOptions = function(targetName,type,event,styleClass){
	var OBJ = this;
	var obj = this.obj;
	DWREngine.setAsync(false);
	OaWorkFlowTypeManager.getOaWorkFlowTypes(fillFun,obj);	
	DWREngine.setAsync(true);
	function fillFun(objs){
		makeOptionsHtml(objs,type,targetName,styleClass);
	}
}


OaWorkFlowType.prototype.makeSelect = function(targetName,event){
	var OBJ = this;
	var obj = this.obj;
	DWREngine.setAsync(false);
	OaWorkFlowTypeManager.getWorkFlowTypesSelect(fillFun,obj);
	DWREngine.setAsync(true);	
	function fillFun(objs){
		makeSelectHtml(objs,targetName);
	}
}	

OaWorkFlowType.prototype.getTreeXML = function(){
	var OBJ = this;
	var treeXMLString;

	DWREngine.setAsync(false);
	OaWorkFlowTypeManager.getOaWorkFlowTypesXml(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 
    return treeXMLString;
}	




