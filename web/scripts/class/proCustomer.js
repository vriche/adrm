function ProCustomer(){
	//创建对象
	this.obj ={
		id:null,
		customerName:null,
	    helpCode:null,
	    typeId:null,
	    
	    telephone:null,
	    fax:null,
	    linkmanName:null,
	    accountAddress:null,
	    
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    
		proCustomerType:null
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
ProCustomer.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.customerName = null;
  	this.obj.helpCode = null;
  	this.obj.typeId = null;
  	
  	this.obj.telephone = null;
  	this.obj.fax = null;
	this.obj.linkmanName = null;
  	this.obj.accountAddress = null;
  
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	
  	this.obj.proCustomerType = null;
}


ProCustomer.prototype.getProCustomersXML = function(obj,callBackFun){
	
	ProCustomerManager.getProCustomersXML(callBackFun,obj);
}  

ProCustomer.prototype.saveProCustomer = function(obj,callBackFun){
	
	ProCustomerManager.saveProCustomer(callBackFun,obj);
} 

ProCustomer.prototype.getProCustomerListXML = function(obj,callBackFun){
	
	ProCustomerManager.getProCustomerListXML(callBackFun,obj);
} 

ProCustomer.prototype.getProCustomersPageXML=function(obj,callBackFun) {
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ProCustomerManager.getProCustomersPageXML(callBackFun,obj,page.pageIndex-1,page.pageSize);
			}
	    	
			ProCustomerManager.getProCustomersCount(getCountFun,obj);	
	    }else{
	  
			ProCustomerManager.getProCustomerListXML(callBackFun,obj);	
	    }

  }

ProCustomer.prototype.removeProCustomer = function(id){
	
	ProCustomerManager.removeProCustomer(id);
} 

ProCustomer.prototype.getProCustomer = function(id,callBackFun){
	
	ProCustomerManager.getProCustomer(callBackFun,id);
}

ProCustomer.prototype.getProCustomersId = function(obj,callBackFun){
	
	ProCustomerManager.getProCustomersId(callBackFun,obj);
}
ProCustomer.prototype.getAllCustomerXML = function(el,name,obj) {
	
	ProCustomerManager.getProCustomers(obj,setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:140px;height:20px'>";	
		html +="<option  value='0'>" + "==客户名称== " +"</option>";
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].customerName;
			html +="<option  value='"+ value +"'>" + lable +"</option>";		
		}
		html += "</select>";	
		el.innerHTML = html;
		
	}
}
