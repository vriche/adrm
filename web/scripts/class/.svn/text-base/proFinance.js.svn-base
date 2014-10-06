

function ProFinance(){
	//创建对象
	this.obj ={
		id:null,
		orderId:null,
	    payMoney:null,
	    payDate:null,
	    paidMoney:null,
	    paidDate:null,
	    incomeModeId:null,
	    incomePurposeId:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
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
	
//	this.pageInfo =""
//	this.pageSize ="20"
//	this.page = null;
    this.pageInfo = null;
	this.pageSize = null;
//	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	this.curPopupWindow = null;
	this.rowNum = 1;
	
	return this;
}

//清空对象
ProFinance.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.orderId = null;
  	this.obj.payMoney = null;
  	this.obj.payDate = null;
  	this.obj.paidMoney = null;
  	this.obj.paidDate = null;
  	this.obj.incomeModeId = null;
  	this.obj.incomePurposeId = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;

}


ProFinance.prototype.getProFinanceXML = function(id,callBackFun){
	ProFinanceManager.getProFinanceXML(callBackFun,id);
  
}

ProFinance.prototype.removeProFinance = function(id,callBackFun){
	ProFinanceManager.removeProFinance(callBackFun,id);

}

ProFinance.prototype.saveProFinance = function(proFinance,callBackFun){
	ProFinanceManager.saveProFinance(callBackFun,proFinance);

}


