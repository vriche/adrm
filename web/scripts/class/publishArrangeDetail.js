
function PublishArrangeDetail(){

	this.obj = {
		id:null,
		publishArrangeId:null,
	    publishSort:null,
	    orderDayId:null,
	    specificValue:null,
	    
		ownerUserName:null,
		firstName:null,
		lastName:null,
		customerName:null,
	    tapeCode:null,
	    matterName:null,
	    matterEdit:null,
	    matterLength:null,	    
		adverTimes:null,
		publishMemo:null,

	    specificName:null,
	    resourceId:null,
		publishDate:null,
		customerId:null,
	    contractId:null,
	    orderId:null,
	    orderDetailId:null,
	    matterId:null,
	    ownerUserId:null
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
	
	this.selectName = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;

	
	return this;	
}	    
//Çå¿Õ¶ÔÏó
PublishArrangeDetail.prototype.reset = function(){

  		this.obj.id = null;
		this.obj.publishArrangeId = null;
	    this.obj.publishSort = null;
	    this.obj.orderDayId = null;
	    this.obj.specificValue = null;
	    
		this.obj.ownerUserName = null;
		this.obj.customerName = null;
	    this.obj.tapeCode = null;
	    this.obj.matterName = null;
	    this.obj.matterEdit = null;
	    this.obj.matterLength = null;	    
		this.obj.adverTimes = null;
		this.obj.publishMemo = null;

	    this.obj.specificName = null;
	    this.obj.resourceId = null;
		this.obj.publishDate = null;
		this.obj.customerId = null;
	    this.obj.contractId = null;
	    this.obj.orderId = null;
	    this.obj.orderDetailId = null;
	    this.obj.matterId = null;
	    this.obj.ownerUserId = null;
	    this.obj.firstName = null;
	    this.obj.lastName = null;	    
  	
}





