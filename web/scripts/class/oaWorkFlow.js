
function OaWorkFlow(){

	this.obj = {
		id:null,
		name:null,
	    workFlowTypeId:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    
	    workFlowMoveTypeId:null,
	    parentId:null,
	    nodeLevel:null,
	    displayNo:null,
	    agreeFlowId:null,
	    dissentFlowId:null,
	    isFirstPoint:null,
	    isEndPoint:null,
	    
	    workFlowType:null,
	    workFlowMoveType:null,
	    cominUsers:null,
	    checkUsers:null,
	    checkRoles:null,
	    workFlowsMap:null,
	    version:null
	}
	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxName = null;
	this.selectName =null;
	this.checkBox =null;
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
OaWorkFlow.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.workFlowTypeId = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	
  	this.obj.workFlowMoveTypeId = null;
  	this.obj.parentId = null;
  	this.obj.nodeLevel = null;
  	this.obj.displayNo = null;
  	this.obj.agreeFlowId = null;
  	this.obj.dissentFlowId = null;
  	this.obj.isFirstPoint = null;
  	this.obj.isEndPoint = null;
  	
  	this.obj.workFlowType = null;
  	this.obj.workFlowMoveType = null;
  	this.obj.cominUsers = null;
  	this.obj.checkUsers = null;
  	this.obj.checkRoles = null;
  	this.obj.workFlowsMap = null;
  	this.obj.version = null;
}	

OaWorkFlow.prototype.getOaWorkFlow = function(id){
	var OBJ = this;
	this.reset();
	var o;

	DWREngine.setAsync(false);
	OaWorkFlowManager.getOaWorkFlow(setValueFun,id);
	DWREngine.setAsync(true);	
	function setValueFun(obj){
		OBJ.obj =  obj;
		o = obj;
	}
	return o;
} 

OaWorkFlow.prototype.saveOaWorkFlow = function(o,mode){
	var OBJ = this;
	var obj = this.obj;
	var id;

	if (mode == 'new') obj.id = null;
	
	DWREngine.setAsync(false);
	OaWorkFlowManager.saveOaWorkFlow(obj,saveFun);
	DWREngine.setAsync(true);
	
	function saveFun(newId){OBJ.reset(); id = newId;}
	return id;
}

/* 删除
 * 根据id删除对象
 */
OaWorkFlow.prototype.removeOaWorkFlow = function(id){
	var OBJ = this;
	var obj = this.obj;

	if(!confirmDelete(OBJ.className)) return false;
    DWREngine.setAsync(false);
	OaWorkFlowManager.removeOaWorkFlow(removeFun,id);	
	DWREngine.setAsync(true);
	function removeFun(){}
	
    return true;
}


OaWorkFlow.prototype.getOaWorkFlowsView = function(workFlowTypeId,parentId){
	    var OBJ = this;
	    var obj = this.obj;
	    var viewFlowSchem = null;
	    
	    this.reset();
		obj.workFlowTypeId = workFlowTypeId;
		obj.parentId = parentId;
		DWREngine.setAsync(false);
		OaWorkFlowManager.getOaWorkFlowsView(fillFun,obj);
		DWREngine.setAsync(true);
		function fillFun(workFlowViewStr){
//			DWRUtil.setValue("viewFlowSchem",workFlowViewStr);
            viewFlowSchem = workFlowViewStr;
		}
		return viewFlowSchem;
}


OaWorkFlow.prototype.makeSelect = function(workFlowTypeId,userId,targetName,event){
	DWREngine.setAsync(false);
	OaWorkFlowManager.getWorkFlowSelectByUser(fillFun,workFlowTypeId,userId);	
	DWREngine.setAsync(true);
	function fillFun(objs){
		makeSelectHtml(objs,targetName);
	}
}

OaWorkFlow.prototype.makeSelects = function(O,targetName,event){
	DWREngine.setAsync(false);
	OaWorkFlowManager.getWorkFlowSelects(fillFun,O.obj);	
	DWREngine.setAsync(true);
	function fillFun(objs){
		makeSelectHtml(objs,targetName);
	}
}


