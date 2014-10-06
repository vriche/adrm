function ProCustomerType(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    
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
ProCustomerType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

 ProCustomerType.prototype.makeSelectCustomerType = function(el,name,width) {
//	UserManager.getUserSelect(setValueFun,obj);
	ProCustomerTypeManager.getProCustomerTypes(setValueFun);
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;' >";	
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].name;
			html +="<option  value='"+ value +"'>" + lable +"</option>";		
		}
		html += "</select>";	
		el.innerHTML = html;
		
	}
}

 ProCustomerType.prototype.makeSelectCustomerTypeByOrder = function(el,name,width,callBackFun) {
//	UserManager.getUserSelect(setValueFun,obj);
	ProCustomerTypeManager.getProCustomerTypes(setValueFun);
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;' >";	
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].name;
			html +="<option  value='"+ value +"'>" + lable +"</option>";		
		}
		html += "</select>";	
		el.innerHTML = html;
		callBackFun();
	}
}

 ProCustomerType.prototype.getProCustomerTypeXML = function(obj,callBackFun){
	
	ProCustomerTypeManager.getProCustomerTypeXML(callBackFun,obj);
}  

 ProCustomerType.prototype.removeProCustomerType = function(id){
	
	ProCustomerTypeManager.removeProCustomerType(id);
}  

 ProCustomerType.prototype.getProCustomerType = function(id,callBackFun){
	
	ProCustomerTypeManager.getProCustomerType(callBackFun,id);
}  

 ProCustomerType.prototype.saveProCustomerType = function(obj,callBackFun){
	
	ProCustomerTypeManager.saveProCustomerType(callBackFun,obj);
} 
