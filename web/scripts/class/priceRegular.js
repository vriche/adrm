
function PriceRegular(){

	this.obj = {
		id:null,
		name:null,
	    multiBase:null,
	    multiply:null,
	    otherBase:null,
	    regularExpr:null,
		
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null
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
PriceRegular.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.multiBase = null;
  	this.obj.multiply = null;
  	this.obj.otherBase = null;
  	this.obj.regularExpr = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
}	


PriceRegular.prototype.getPriceRegularByName = function(resourceId,priceTypeId,regularName,callBackFun){

	DWREngine.setAsync(false);
	PriceRegularManager.getPriceRegularByName(resourceId,priceTypeId,regularName,fillFun);
	DWREngine.setAsync(true);
	function fillFun(s){;
		var r = eval(s);
		if(isUndefined(r)) r = 0;
		callBackFun(r);
	}
}
