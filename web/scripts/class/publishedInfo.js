
function PublishedInfo(){

	this.obj = {
		id:null,
		publishDate:null,
	    contractId:null,
	    orderId:null,
	    publishOrder:null,
	    
		adResourceId:null,
		adResourceWorkspanId:null,
	    resourceCarrier:null,
	    carrierId:null,
	    resourceType:null,
	    
		position:null,
		publishMemo:null,
	    linkUser:null,
	    linkUserId:null,
	    positionDes:null,
	    
		proResourceMemo:null,
		adverMatterId:null,
	    tapeCode:null,
	    matterName:null,
	    matterEdit:null,
	    
		matterLength:null,
		appPosition:null,
	    version:null,
	    customerId:null,
	    customerName:null,
	    
	    publishMemoValue:null,
	    specificValue:null,
	    dayTimes:null,
	    orderDayInfoId:null,
	    orderCode:null,
	    adContent:null
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
PublishedInfo.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.publishDate = null;
  	this.obj.contractId = null;
  	this.obj.orderId = null;
  	this.obj.publishOrder = null;
  	
	this.obj.adResourceId = null;
  	this.obj.adResourceWorkspanId = null;
  	this.obj.resourceCarrier = null;
  	this.obj.carrierId = null;
  	this.obj.resourceType = null;
  	
	this.obj.position = null;
  	this.obj.publishMemo = null;
  	this.obj.linkUser = null;
  	this.obj.linkUserId = null;
  	this.obj.positionDes = null;
  	
	this.obj.proResourceMemo = null;
  	this.obj.adverMatterId = null;
  	this.obj.tapeCode = null;
  	this.obj.matterName = null;
  	this.obj.matterEdit = null;
  	
	this.obj.matterLength = null;
  	this.obj.appPosition = null;
  	this.obj.version = null;
  	this.obj.customerId = null;
  	this.obj.customerName = null;
  	
  	this.obj.publishMemoValue = null;
  	this.obj.specificValue = null;
  	this.obj.dayTimes = null;
  	this.obj.orderDayInfoId = null;
  	this.obj.orderCode = null;
  	this.obj.adContent = null;
}

PublishedInfo.prototype.getPublishedCount = function(resourceIds,dateStr,func){
	PublishedInfoManager.getPublishedCount(func,resourceIds,dateStr);
}
PublishedInfo.prototype.getPublishedInfosByResourceIdsXML = function(resourceIds,dateStr,model,func){

	PublishedInfoManager.getPublishedInfosByResourceIdsXML(func,resourceIds,dateStr,model);
}

PublishedInfo.prototype.getInfosByResourceIdsXML = function(resourceIds,dateStr,model,func){
	
	PublishedInfoManager.getInfosByResourceIdsXML(func,resourceIds,dateStr,model);
}	
	
PublishedInfo.prototype.removePublishedInfosByResDate = function(resourceIds,broDate,func){	
	PublishedInfoManager.removePublishedInfosByResDate(func,resourceIds,broDate);	
}
PublishedInfo.prototype.savePublishedInfo = function(publish,func){
	PublishedInfoManager.savePublishedInfo(func,publish);
}



