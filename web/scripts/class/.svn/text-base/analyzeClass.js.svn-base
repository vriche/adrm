function AnalyzeClass(){
	//创建对象
	this.obj ={
		resourceName:null,
		resourceMeno:null,
		resourceId:null,
	    relIncome:null,
	    sumTimes:null,
	    matterName:null,
	    timeUsed:null,
	    carrierName:null,
	    carrierIds:null,
	    publishDate:null,
	    sumUsed:null,
	    startDate:null,
	    id:null,
	    endDate:null
	 
	    
	}
	
    this.className = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo =""
	this.pageSize ="4"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;
}

//清空对象
AnalyzeClass.prototype.reset = function(){
	    this.obj.customerName = null;
  	    this.obj.resourceName=null;
		this.obj.resourceMeno=null;
		this.obj.resourceId=null;
	    this.obj.relIncome=null;
	    this.obj.sumTimes=null;
	    this.obj.matterName=null;
	    this.obj.timeUsed=null;
	    this.obj.carrierName=null;
	    this.obj.carrierIds=null;
	    this.obj.publishDate=null;
	    this.obj.sumUsed=null;
	    this.obj.startDate=null;
	    this.obj.endDate=null;
	    this.obj.id=null;
}

AnalyzeClass.prototype.getAnalyCarrierMatterByDate = function(startDate,endDate,resourceIds,callBackFun){
	AnalyCarrierMatterManager.getAnalyCarrierMatterByDate(startDate,endDate,resourceIds,callBackFun);
	function setFun(treeGridXML){ callBackFun(treeGridXML);} 
}



AnalyzeClass.prototype.getResourceAdverCount = function(callBackFun){
	
	AnalyseManager.getResourceAdverPageCount(this.obj,callBackFun);
	function setFun(size){ 
		if(callBackFun) callBackFun(size);
	} 
}

AnalyzeClass.prototype.getResourceAdverXML = function(callBackFun){
	var obj = this.obj;
	var page   = this.page;
	
	function getCountFun(size){
		
		if(size > 0){
			AnalyseManager.getResourceAdverXML(obj,page.pageIndex,page.pageSize,callBackFun);
			function setFun(){ 
				if(callBackFun) callBackFun();
			} 
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);	
		}

	}
	
	this.getResourceAdverCount(getCountFun);
}






AnalyzeClass.prototype.getBrandPageCount = function(callBackFun){
	AnalyseManager.getBrandPageCount(this.obj,callBackFun);
	function setFun(size){if(callBackFun) callBackFun(size);} 
}

AnalyzeClass.prototype.getBrandXML_bak = function(callBackFun){
	var obj = this.obj;
	var page   = this.page;
	
	function getCountFun(size){
//		alert(size)
		if(size > 0){
			
			function setFun(){ if(callBackFun) callBackFun();} 
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);	
			AnalyseManager.getBrandXML(obj,page.pageIndex,page.pageSize,page.pageCount,callBackFun);
		}
			Ext.getBody().unmask();
	}
	this.getBrandPageCount(getCountFun);
}

AnalyzeClass.prototype.getBrandXML = function(callBackFun){
	var obj = this.obj;
	var page   = this.page;
	
	AnalyseManager.getBrandXML(obj,page.pageIndex,page.pageSize,page.pageCount,callBackFun);
	
	
}
AnalyzeClass.prototype.getOrderCategoryByCarrierTypeXML = function(carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint,callBackFun){
		
		AnalyseManager.getOrderCategoryByCarrierTypeXML(carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint,callBackFun);	
}

AnalyzeClass.prototype.getAreaCustomerByCarrierTypeXML = function(carrierIds,model,sDate,eDate,userId,userName,isPrint,callBackFun){
		
		AnalyseManager.getAreaCustomerByCarrierTypeXML(carrierIds,model,sDate,eDate,userId,userName,isPrint,callBackFun);	
}

AnalyzeClass.prototype.getCustomerByYearXML = function(func,obj,year,customerIds,userId,carrierName,channelModelParam,theUser){
		AnalyseManager.getOrderCategoryByCustomerXML(obj,year,customerIds,userId,carrierName,channelModelParam,theUser,func);
}

AnalyzeClass.prototype.getCarrierBasalByBeginAndEndDateXML = function(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint,callBackFun){

		AnalyseManager.getCarrierBasalByBeginAndEndDateXML(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint,callBackFun);	

}


