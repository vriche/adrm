
function PriceType(){

	this.obj = {
		id:null,
		priceTypeName:null,
		value:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null,
	    enable:null
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
PriceType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.priceTypeName = null;
  	this.obj.value = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
  	this.obj.enable = null;
}	

PriceType.prototype.makeSelect = function(obj,name,event){
	DWREngine.setAsync(false);
	PriceTypeManager.getPriceTypeSelect(fillFun,obj);
	DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

PriceType.prototype.makeSelectFromMap_bak = function(obj,name,event,callfun){
	//DWREngine.setAsync(false);
	PriceTypeManager.getPriceTypeSelectFromMap(fillFun,obj);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);

		if(callfun) callfun();
	}
}	


PriceType.prototype.makeSelectFromMap = function(obj,name,width,event,callfun){
	var OBJ =this;
	PriceTypeManager.getPriceTypeSelectFromMap2(fillFun,obj);
	function fillFun(objs){
		OBJ.makeSelectHtml(objs,name,width,event);
		if(callfun) callfun();
	}
}	


PriceType.prototype.makeSelectHtml= function(objs,name,width,event){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
    
    var select = $(name);

    for(var i = 0;i< objs.length;i++){
	   var  option = new Option(objs[i].priceTypeName, objs[i].id);
	   option.paramvalue = objs[i].value;
	   select.options.add(option);
    }

	select.setAttribute("style","width:" + width +"px;margin-left:-100px;CURSOR: pointer;");
	
	select.setAttribute("onChange","javascript:"+ event +"(this)");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
 }
 
 

