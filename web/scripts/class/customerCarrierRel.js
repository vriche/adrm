function CustomerCarrierRel(){
	//创建对象
	this.obj ={
	    id:null,
	    customerId:null,
	    carrierId:null,
	    carrierName:null,
	    resourceName:null,
	    memo:null,
	    resourceId:null,
	    length:null,
	    startDate:null,
	    payMoney:null,
	    endDate:null,
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
	
	this.selectName = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;
}

//清空对象
CustomerCarrierRel.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.customerId = null;
  	this.obj.carrierId = null;
  	this.obj.carrierName = null;
  	this.obj.resourceName = null;
  	this.obj.memo = null;
  	this.obj.resourceId = null;
  	this.obj.length = null;
  	this.obj.startDate = null;
  	this.obj.endDate = null;
  	this.obj.payMoney = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.selectName = null;
}
CustomerCarrierRel.prototype.saveCustomerCarrierRel=function(obj,callBack){
	CustomerManager.saveCustomerCarrierRel(callBack,obj);
}

CustomerCarrierRel.prototype.removeCustomerCarrierRel=function(id,callBack){
	CustomerManager.removeCustomerCarrierRel(callBack,id);
}

CustomerCarrierRel.prototype.getCustomerCarrierRelPageXML=function(obj,callBackFun) {
	    var obj = obj;
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				
				CustomerManager.getCustomerCarrierRelPageXML(callBackFun,obj,page.pageIndex-1,page.pageSize);
			}
	    	
			CustomerManager.getCustomerCarrierRelCountAll(getCountFun,obj);	
	    }

  }
  
CustomerCarrierRel.prototype.getCarrierPageXMLs=function(obj,callBackFun) {
	    var obj = obj;
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				
				CustomerManager.getCarrierPageXML(callBackFun,obj,page.pageIndex-1,page.pageSize);
			}
	    	
			CustomerManager.getOrderDetailCountAll(getCountFun,obj);	
	    }

  }
CustomerCarrierRel.prototype.getCarrierXML = function(el,name,obj,callBackFun) {
	
	CustomerManager.getCarrierXML(obj,setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:160px;height:20px'>";	
//		html +="<option  value='0'>" + "==节目名称== " +"</option>";
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].carrierId;
			var lable = objs[i].carrierName;
			html +="<option  value='"+ value +"'>" + lable +"</option>";
		}
		html += "</select>";	
		el.innerHTML = html;
		callBackFun();
		
	}
}
CustomerCarrierRel.prototype.getCustomerCarrierRelXML=function(obj,callBackFun) {		
	CustomerManager.getCustomerCarrierRelXML(callBackFun,obj);	
  }
  
CustomerCarrierRel.prototype.getCustomerCarrierRelCount=function(obj,callBackFun) {		
	CustomerManager.getCustomerCarrierRelCount(callBackFun,obj);	
  }
CustomerCarrierRel.prototype.getCustomerCarrierRels=function(obj,callBackFun) {
	CustomerManager.getCustomerCarrierRels(callBackFun,obj);	
  }
CustomerCarrierRel.prototype.getCarrierPageXML=function(obj,callBackFun) {
	CustomerManager.getCarrierPageXML(callBackFun,obj);	
  }
CustomerCarrierRel.prototype.getDetailsByOrderId=function(obj,callBackFun) {
	CustomerManager.getDetailsByOrderId(callBackFun,obj);
  }