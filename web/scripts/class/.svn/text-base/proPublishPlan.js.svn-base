function ProPublishPlan(){
	//创建对象
	this.obj ={
	    id:null,              //计划id  20
		programId:null,        //节目id 20
		carrierId:null,	         //频道id 20
		startDate:null,      //节目开始日期12
		endDate:null,       //节目结束日期12
		startTime:null,      //节目开始时间12
		endTime:null,         //节目结束时间12
		weeksPlan:null,      //周排期 20
	
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
    
   		carrier:null,
    	proProgram:null
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
ProPublishPlan.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.programId = null;
  	this.obj.carrierId = null;
  	this.obj.startDate = null;
  	this.obj.endDate = null;
  	this.obj.startTime = null;
  	this.obj.endTime = null;
  	this.obj.weeksPlan = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.carrier = null;
  	this.obj.proProgram = null
}
	
ProPublishPlan.prototype.getProPublishPlanPageXML = function(proName,obj,callBackFun){
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
	    		
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ProPublishPlanManager.getProPublishPlanPageXML(callBackFun,proName,obj,page.pageIndex-1,page.pageSize);
			}
			
			ProPublishPlanManager.getProPublishPlanCount(getCountFun,proName,obj);	
			
	    }else{
			ProPublishPlanManager.getProPublishPlanXML(callBackFun,proName,obj);	
	    }
	
}
ProPublishPlan.prototype.getProPublishPlanXML = function(obj,callBackFun){
	
	ProPublishPlanManager.getProPublishPlanXML(callBackFun,obj);
}

ProPublishPlan.prototype.getProPublishPlan = function(obj,callBackFun){
	
	ProPublishPlanManager.getProPublishPlans(callBackFun,obj);
}

ProPublishPlan.prototype.removeProPublishPlan = function(id){
	
	ProPublishPlanManager.removeProPublishPlan(id);
} 

ProPublishPlan.prototype.saveProPublishPlanById = function(obj,callBackFun){
	ProPublishPlanManager.saveProPublishPlanById(saveFun,obj);

	function saveFun(newId){
		
		callBackFun(newId);
		
	}
}

ProPublishPlan.prototype.getProPublishPlanDetailXML = function(id,callBackFun){
	
	ProPublishPlanManager.getProPublishPlanDetailXML(callBackFun,id);
} 

ProPublishPlan.prototype.removeProPublishPlanDetail = function(ids,callBackFun){
	
	ProPublishPlanManager.removeProPublishPlanDetail(callBackFun,ids);
}
	