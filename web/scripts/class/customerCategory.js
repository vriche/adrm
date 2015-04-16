function CustomerCategory(){
	//创建对象
	this.obj ={
		id:null,
		categoryName:null,
		categoryCode:null,
	    memo:null,
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
CustomerCategory.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.categoryName = null;
  	this.obj.categoryCode = null;
  	this.obj.memo = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

CustomerCategory.prototype.makeSelectAnalyze = function(callBackFun) {
    var obj = this.obj;
	CategoryManager.getCustomerTypeSelectLimit(obj,setValueFun);
	
	function setValueFun(objs){
		 makeSelectHtmlAnalyze(objs,name,event);
		 callBackFun();
	}
}



