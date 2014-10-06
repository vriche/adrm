
function Compages(){

	this.obj = {
		id:null,
		name:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null,
	    resources:null,
	    enable:null,
	    priceId:null,
	    isAutoPrice:null

	}
	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxName = null;
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

//Çå¿Õ¶ÔÏó
Compages.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
  	this.obj.resources = null;
  	this.obj.enable = null;
  	this.obj.isAutoPrice = null;
  	this.obj.priceId = null;
}	

Compages.prototype.getCompages = function(id){
	var OBJ = this;
	var obj = OBJ.obj;
	
	this.reset();
	DWRUtil.setValues(this.obj);
	DWREngine.setAsync(false);
	CompagesManager.getCompages(id,setValueFun);
	DWREngine.setAsync(true);
	
	function setValueFun(o){
		DWRUtil.setValues(o);
		obj = o;
	}
	return obj;
}	
Compages.prototype.getCompage = function(id,callback){
	CompagesManager.getCompages(id,callback);
}
Compages.prototype.getTreeXML = function(resourceIdPrefix){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	CompagesManager.getCompagessXML(this.obj,this.IdPrefix,resourceIdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 
//	alert(treeXMLString);
    return treeXMLString;
}

Compages.prototype.getTreeXML2 = function(resourceIdPrefix,getxml){

	CompagesManager.getCompagessXML(this.obj,this.IdPrefix,resourceIdPrefix,getxml);

}

Compages.prototype.getCompagesAutoComplet = function(obj,callBackFun){
	CompagesManager.getCompagess(obj,callBackFun);	
}

Compages.prototype.getPrice = function(o,length,model,priceTypeId,callBackFun){

	CompagesManager.getPrice(o,length,priceTypeId,model,callBackFun);
}
Compages.prototype.getPriceByResIdListAndLength = function(ids,length,priceTypeId,callBackFun){

	CompagesManager.getPriceByResIdListAndLength(ids,length,priceTypeId,callBackFun);
	
}

Compages.prototype.getPricesByCompagesId = function(id){
	CompagesManager.getPricesByCompagesId(id);
}
Compages.prototype.saveCompagesAndResourceRel = function(o,saveFun){

	var obj =  o;	

	CompagesManager.saveCompagesAndResourceRel(obj,saveFun);

}

Compages.prototype.removeCompages = function(id,priceId,func){

	CompagesManager.removeCompages(id,priceId,func);
}
Compages.prototype.getPriceDetailIdByCompagesIdAndLength = function(id,len,func){
	
	CompagesManager.getPriceDetailIdByCompagesIdAndLength(id,len,func);
	
}
Compages.prototype.getPriceByLegth = function(id,len,priceTypeId,func){
	
	CompagesManager.getPriceByLegth(id,len,priceTypeId,func);
	
}




