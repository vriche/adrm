function ProPublishPlanDetail(){
	//创建对象
	this.obj ={
	    id:null,              
		publishPlanId:null,	         
		planDate:null,      
		dayTimes:null, 
		times:null,      
	
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,

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
	this.curPopupWindow = null;
	this.rowNum = 1;
	
	return this;
}

//清空对象
ProPublishPlanDetail.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.publishPlanId = null;
  	this.obj.planDate = null;
  	this.obj.dayTimes = null;
    this.obj.times = null;
    
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

ProPublishPlanDetail.prototype.saveProPublishPlanDetail = function(obj,callBackFun){
	ProPublishPlanManager.saveProPublishPlanDetails(saveFun,obj);

	function saveFun(){
		
		callBackFun();
		
	}
}

ProPublishPlanDetail.prototype.getProPublishPlanDetailXML = function(id,callBackFun){
	
	ProPublishPlanManager.getProPublishPlanDetailXML(callBackFun,id);
}

ProPublishPlanDetail.prototype.removeProPublishPlanDetail = function(id,callBackFun){
	
	ProPublishPlanManager.removeProPublishPlanDetail(callBackFun,id);
}
	