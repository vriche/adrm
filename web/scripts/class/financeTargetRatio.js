function FinanceTargetRatio(){
	this.obj = { 
		id:null,
		carrierId:null,
	    	targetDateYear:null,
	    	targetDateMonth:null,
		targetMoney:null,
	   	targetDateYear:null,
		createBy:null,
		createDate:null,
		modifyBy:null,
		modifyDate:null,
		carrier:null,
		tarMonths:null
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

//清空对象
FinanceTargetRatio.prototype.reset = function(){
  	this.obj.id = null;
	this.obj.carrierId = null;
	this.obj.targetDateYear = null;
	this.obj.targetDateMonth = null;
	this.obj.targetMoney = null;
	this.obj.createBy = null;
	this.obj.createDate = null;
	this.obj.modifyBy = null;
	this.obj.modifyDate = null;
	this.obj.carrier = null;
	this.obj.tarMonths = null;
}	

FinanceTargetRatio.prototype.getFinanceTargetsXML = function(targetYear,carrierId,channelModelParam,userName,callBackFun){
	FinanceTargetRatioManager.getFinanceTargetsPageXML(targetYear,carrierId,channelModelParam,userName,fillFun);
	function fillFun(treeXML){
		callBackFun(treeXML);
	}
	
}

FinanceTargetRatio.prototype.getFinanceTargetRatioCarrierXML = function(paramQueryString,callBackFun){
	FinanceTargetRatioManager.getFinanceTargetRatioCarrierXML(paramQueryString,fillFun);
	function fillFun(treeXML){
		callBackFun(treeXML);
	}
	
}



FinanceTargetRatio.prototype.saveFinanceTargets = function(obj,carrierId,channelModelParam,userName,func){
	FinanceTargetRatioManager.saveFinanceTargets(obj,carrierId,channelModelParam,userName,func);
	alert("保存成功");
}
FinanceTargetRatio.prototype.deleteFinanceTarget = function(obj,func){
	FinanceTargetRatioManager.removeFTarget(obj,func);
}

FinanceTargetRatio.prototype.getFinanceTargetYear = function(obj,func){
	FinanceTargetRatioManager.getFinanceTargetYear(obj,func);
}

FinanceTargetRatio.prototype.getCustomerYearRelPut = function(obj,func){
	FinanceTargetRatioManager.getCustomerYear(obj,func);
}
FinanceTargetRatio.prototype.getCustomerYearRelPut2 = function(obj,func){
	DWREngine.setAsync(false);
	FinanceTargetRatioManager.getCustomerYear(obj,func);
	DWREngine.setAsync(true);
}
FinanceTargetRatio.prototype.getCustomerYearRelIncome = function(obj,func){
	FinanceTargetRatioManager.getCustomerYearRelIncome(obj,func);
}

FinanceTargetRatio.prototype.getCustomerYearRelTime = function(obj,func){
	FinanceTargetRatioManager.getCustomerYearRelTime(obj,func);
}

FinanceTargetRatio.prototype.getYearTargetAnalyzeXml = function(size,type,carrierId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func){
	FinanceTargetRatioManager.getYearTargetAnalyzeXml(size,type,carrierId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func);
}

FinanceTargetRatio.prototype.getCustomerYearAnalyzeXml = function(size,type,customerId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func){
	FinanceTargetRatioManager.getCustomerYearAnalyzeXml(size,type,customerId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func);
}

FinanceTargetRatio.prototype.getCarrierTargetXML = function(orgId,userId,year,start,end,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,customerId,callBackFun){

	
	FinanceTargetRatioManager.getCarrierTargetXML(orgId,userId,year,start,end,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,customerId,fillFun);
    function fillFun(treeXML){
		callBackFun(treeXML);
	}
}

FinanceTargetRatio.prototype.getArrearsXML = function(param,callBackFun){
	FinanceTargetRatioManager.getArrearsXML(param,callBackFun);
}
FinanceTargetRatio.prototype.getIncomeRelpayQiankArray = function(searchQuery,callBackFun){
	FinanceTargetRatioManager.getIncomeRelpayQiankArray(searchQuery,callBackFun);
}





