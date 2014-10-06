function FinanceTarget(){
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
FinanceTarget.prototype.reset = function(){
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

FinanceTarget.prototype.getFinanceTargetsXML = function(targetYear,carrierId,channelModelParam,userName,callBackFun){
	FinanceTargetManager.getFinanceTargetsPageXML(fillFun,targetYear,carrierId,channelModelParam,userName);
	function fillFun(treeXML){
		callBackFun(treeXML);
	}
	
}

FinanceTarget.prototype.saveFinanceTargets = function(obj,carrierId,channelModelParam,userName,func){
	FinanceTargetManager.saveFinanceTargets(obj,carrierId,channelModelParam,userName,func);
	alert("保存成功");
}
FinanceTarget.prototype.deleteFinanceTarget = function(obj,func){
	FinanceTargetManager.removeFTarget(obj,func);
}

FinanceTarget.prototype.getFinanceTargetYear = function(obj,func){
	FinanceTargetManager.getFinanceTargetYear(obj,func);
}

FinanceTarget.prototype.getCustomerYearRelPut = function(obj,func){
	FinanceTargetManager.getCustomerYear(obj,func);
}
FinanceTarget.prototype.getCustomerYearRelPut2 = function(obj,func){
	DWREngine.setAsync(false);
	FinanceTargetManager.getCustomerYear(obj,func);
	DWREngine.setAsync(true);
}
FinanceTarget.prototype.getCustomerYearRelIncome = function(obj,func){
	FinanceTargetManager.getCustomerYearRelIncome(obj,func);
}

FinanceTarget.prototype.getCustomerYearRelTime = function(obj,func){
	FinanceTargetManager.getCustomerYearRelTime(obj,func);
}

FinanceTarget.prototype.getYearTargetAnalyzeXml = function(size,type,carrierId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func){
	FinanceTargetManager.getYearTargetAnalyzeXml(size,type,carrierId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func);
}

FinanceTarget.prototype.getCustomerYearAnalyzeXml = function(size,type,customerId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func){
	FinanceTargetManager.getCustomerYearAnalyzeXml(size,type,customerId,channelModelParam,theUser,isPutYear,isNotReturnValue,purpose,func);
}

FinanceTarget.prototype.getCarrierTargetXML = function(orgId,userId,year,start,end,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,customerId,callBackFun){

	
	FinanceTargetManager.getCarrierTargetXML(orgId,userId,year,start,end,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,customerId,fillFun);
    function fillFun(treeXML){
		callBackFun(treeXML);
	}
}

FinanceTarget.prototype.getArrearsXML = function(param,callBackFun){
	FinanceTargetManager.getArrearsXML(param,callBackFun);
}
FinanceTarget.prototype.getIncomeRelpayQiankArray = function(searchQuery,callBackFun){
	FinanceTargetManager.getIncomeRelpayQiankArray(searchQuery,callBackFun);
}





