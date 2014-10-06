
function OrderLog(){

	this.obj = {
		id:null,
		log:null,
	    orderId:null,
	    version:null
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
OrderLog.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.log = null;
  	this.obj.orderId = null;
  	this.obj.version = null;
}	
OrderLog.prototype.getOrderLog = function(id,callBackFun){
	OrderLogManager.getOrderLog(callBackFun,id);
}	

OrderLog.prototype.getOrderLogXML = function(obj,callBackFun){
	OrderLogManager.getOrderLogXML(callBackFun,obj);
}	
	