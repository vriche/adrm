

function ProOrder(){
	//创建对象
	this.obj ={
		id:null,
		orderCode:null,
	    relationCode:null,
	    orderMeno:null,
	    payMoney:null,
	    payDate:null,
	    paidMoney:null,
	    paidDate:null,
	    moreMoney:null,
	    lessMoney:null,
	    programId:null,
	    orderTypeId:null,
	    userId:null,
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
ProOrder.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.orderCode = null;
  	this.obj.relationCode = null;
  	this.obj.orderMeno = null;
  	this.obj.payMoney = null;
  	this.obj.payDate = null;
  	this.obj.paidMoney = null;
  	this.obj.paidDate = null;
  	this.obj.moreMoney = null;
  	this.obj.lessMoney = null;
  	this.obj.programId = null;
  	this.obj.orderTypeId = null;
  	this.obj.userId = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	


  	this.obj.orderCategory = null;
}
ProOrder.prototype.getProOrderXML = function(proOrder,callBackFun){
	ProOrderManager.getProOrderXML(callBackFun,proOrder);
  
}
ProOrder.prototype.getProOrderXMLByProgramId = function(proOrder,callBackFun){
	ProOrderManager.getProOrderXMLByProgramId(callBackFun,proOrder);
}

ProOrder.prototype.getProOrder = function(id,callBackFun){
	ProOrderManager.getProOrder(callBackFun,id);
  
}

ProOrder.prototype.getProOrders = function(obj,callBackFun){
	ProOrderManager.getProOrders(callBackFun,obj);
  
}


ProOrder.prototype.getIncomePullListXML = function(customerName,programName,cusType,obj,callBackFun){
	ProOrderManager.getIncomePullListXML(callBackFun,customerName,programName,cusType,obj);
   
}
  
ProOrder.prototype.getProIncomePullPageXML=function(customerName,programName,cusType,obj,callBackFun) {
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ProOrderManager.getProIncomePullPageXML(callBackFun,customerName,programName,cusType,obj,page.pageIndex-1,page.pageSize);
			}
	    	
			ProOrderManager.getProIncomePullCount(getCountFun,customerName,programName,cusType,obj);	
	    }else{
	  
			ProOrderManager.getIncomePullListXML(callBackFun,customerName,programName,cusType,obj);
	    }

  }

ProOrder.prototype.getPaymentByCustomerXML = function(obj,callBackFun){
	ProOrderManager.getPaymentByCustomerXML(callBackFun,obj);
   
}


ProOrder.prototype.getPaymentPageXML=function(customerName,obj,callBackFun) {
	    var obj = obj;
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ProOrderManager.getPaymentPageXML(callBackFun,customerName,obj,page.pageIndex-1,page.pageSize);
			}
	    	
			ProOrderManager.getProPaymentCount(getCountFun,customerName,obj);	
	    }else{
	  
			ProOrderManager.getPaymentByCustomerXML(callBackFun,customerName,obj);	
	    }

  }


ProOrder.prototype.getProOrderCodeXML = function(obj,callBackFun){
	ProOrderManager.getProOrderCodeXML(callBackFun,obj);

}
ProOrder.prototype.removeProOrder = function(id,callBackFun){
	ProOrderManager.removeProOrder(callBackFun,id);

}

ProOrder.prototype.saveProOrder = function(proOrder,callBackFun){
	ProOrderManager.saveProOrder(callBackFun,proOrder);

}

ProOrder.prototype.saveProOrders = function(proOrder,callBackFun){
	ProOrderManager.saveProOrders(callBackFun,proOrder);

}


ProOrder.prototype.saveProIncomePulls = function(obj,callBackFun){
	ProOrderManager.saveProIncomePulls(callBackFun,obj);

}

ProOrder.prototype.getProOrderPageXML=function(obj,callBackFun) {
	    var obj = obj;
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ProOrderManager.getProOrdersPageXML(callBackFun,obj,page.pageIndex-1,page.pageSize);
			}
	    	
			ProOrderManager.getProOrdersCountByName(getCountFun,obj);	
	    }else{
	  
			ProOrderManager.getProOrderXML(callBackFun,obj);	
	    }

  }
ProOrder.prototype.getYearByVersion = function(el,name,obj,callBackFun) {
	
	ProOrderManager.getProOrders(obj,setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:140px;height:20px'>";	
		for(var i = 0;i<objs.length;i++){
			var lable = objs[i].version;
			html +="<option  value='"+ lable +"'>" + lable +"</option>";
		}
		html += "</select>";	
		el.innerHTML = html;
		callBackFun();
		
	}
}
ProOrder.prototype.getMoneyByProgramId = function(programId,callBackFun){
	ProAnalyzeManager.getMoneyByProgramId(callBackFun,programId);
}
