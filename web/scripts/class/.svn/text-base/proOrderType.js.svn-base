function ProOrderType(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    value:null,
	    
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
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;
}
//清空对象
ProOrderType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.value = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}
ProOrderType.prototype.getProOrderTypeXML = function(proOrderType,callBackFun){{
	ProOrderTypeManager.getProOrderTypeXML(callBackFun,proOrderType);
   
}
}
	
ProOrderType.prototype.getOrderTypesXML = function(el,name,width,callBackFun) {
	ProOrderTypeManager.getProOrderTypes(setValueFun);
	
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

ProOrderType.prototype.getOrderType = function(el,name,width) {
	ProOrderTypeManager.getProOrderTypes(setValueFun);
	
	function setValueFun(objs){
		 
		 var html="";
		html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;' >";
		html +="<option  value='0'>" + "=订单类别= " +"</option>";
		for(var i = 0;i<objs.length;i++){
			var value = objs[i].id;
			var lable = objs[i].name;
			html +="<option  value='"+ value +"'>" + lable +"</option>";		
		}
		html += "</select>";	
		el.innerHTML = html;
	}
}