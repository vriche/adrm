
function ForetArrearage(){
	//创建对象
	this.obj ={
		fa_id:null,
        createBy:null,
        createDate:null,
        customerName:null,
        endDate:null,
        incomeCode:null,
        incomeDate:null,
        incomeMode:null,
        incomeMoney:null,
        incomePurpose:null,
        memo:null,
        modifyBy:null,
        modifyDate:null,
        payDate:null,
        payMoney:null,
        startDate:null,
        userName:null,
        year:null,
		version:null
	}
	
    this.className = null;
	this.tableName = null;	
	this.tBody = null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.pageInfo ="";
	this.pageSize ="20";
	this.page = null;
	
	return this;
}

//清空对象
ForetArrearage.prototype.reset = function(){
    this.obj.createBy = null;
    this.obj.createDate = null;
    this.obj.customerName = null;
    this.obj.endDate = null;
    this.obj.id = null;
    this.obj.incomeCode = null;
    this.obj.incomeDate = null;
    this.obj.incomeMode = null;
    this.obj.incomeMoney = null;
    this.obj.incomePurpose = null;
    this.obj.memo = null;
    this.obj.modifyBy = null;
    this.obj.modifyDate = null;
    this.obj.payDate = null;
    this.obj.payMoney = null;
    this.obj.startDate = null;
    this.obj.userName = null;
    this.obj.version = null;
    this.obj.year = null;
}

//给对象赋值
ForetArrearage.prototype.setObject = function(sourObj){
    this.obj.createBy = sourObj.createBy;
    this.obj.createDate = sourObj.createDate;
    this.obj.customerName = sourObj.customerName;
    this.obj.endDate = sourObj.endDate;
    this.obj.id = sourObj.id;
    this.obj.incomeCode = sourObj.incomeCode;
    this.obj.incomeDate = sourObj.incomeDate;
    this.obj.incomeMode = sourObj.incomeMode;
    this.obj.incomeMoney = sourObj.incomeMoney;
    this.obj.incomePurpose = sourObj.incomePurpose;
    this.obj.memo = sourObj.memo;
    this.obj.modifyBy = sourObj.modifyBy;
    this.obj.modifyDate = sourObj.modifyDate;
    this.obj.payDate = sourObj.payDate;
    this.obj.payMoney = sourObj.payMoney;
    this.obj.startDate = sourObj.startDate;
    this.obj.userName = sourObj.userName;
    this.obj.version = sourObj.version;
}

/*******************************************
*			对象的基本操作方法                
*******************************************/

ForetArrearage.prototype.getForetArrearage = function(callBackFun){
	ForetArrearageManager.getForetArrearage(callBackFun,this.obj.id);
}
/* 获得列表*/
ForetArrearage.prototype.getForetArrearages = function(callBackFun,type){
    var page = this.page;
    var obj = this.obj;
    if (page.pageSize > 0){
    	function getCountFun(size){ 
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);
			if(type ==2){
				ForetArrearageManager.getForetArrearagesPageXML(callBackFun,obj,page.pageIndex,page.pageSize);
			}else{
				ForetArrearageManager.getForetArrearagesPage(callBackFun,obj,page.pageIndex,page.pageSize);
			}
		}
    	ForetArrearageManager.getForetArrearageCount(getCountFun,obj);	
    }else{
  		if(type ==2){
				ForetArrearageManager.getForetArrearagesXML(callBackFun,obj);
		}else{
				ForetArrearageManager.getForetArrearages(callBackFun,obj);
		}     
    }
}

/* 保存*/
ForetArrearage.prototype.saveForetArrearage = function(callBackFun){
	ForetArrearageManager.saveForetArrearage(this.obj,callBackFun);
}
/* 删除*/
ForetArrearage.prototype.removeForetArrearage = function(callBackFun){
	ForetArrearageManager.removeForetArrearage(callBackFun,this.obj);	
}
ForetArrearage.prototype.getForetArrearagesForXML = function(callBackFun,obj,type){
	ForetArrearageManager.getForetArrearagesForXML(callBackFun,obj,type);
}

