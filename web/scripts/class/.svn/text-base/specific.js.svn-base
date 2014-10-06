function Specific(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    position:null,
        overRate:null,
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
	this.fileds =
	[
			{name: "id", type: "int"},
			{name: "name", type: "string"},
			{name: "position", type: "string"}
	];
	return this;
}

//清空对象
Specific.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.position = null;
	this.obj.overRate = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
}

Specific.prototype.backupObject = function(sourObj,targObj){
	targObj.id = sourObj.id;
	targObj.name = sourObj.name;
	targObj.position = sourObj.position;
	targObj.overRate = sourObj.overRate;
	return 	targObj;
}

Specific.prototype.makeSelect = function(obj,name,event){
	DWREngine.setAsync(false);
	SpecificManager.getSpecificSelect(fillFun,obj);
	DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

Specific.prototype.makeSelectFromMap = function(obj,name,event){
	//DWREngine.setAsync(false);
	SpecificManager.getSpecificSelectFromMap(fillFun,obj);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

Specific.prototype.makeSelectFromMap2 = function(obj,el,callbackFun,event){
	SpecificManager.getSpecificSelectFromMap(fillFun,obj);
	DWRUtil.removeAllOptions(el);
	function fillFun(objs){
		DWRUtil.addOptions(el, objs);
		el.setAttribute("onChange","javascript:"+ event +"(this)");
	        if(callbackFun) callbackFun();
	}
}


Specific.prototype.makeSelectFromMap3 = function(obj,name,width,callBackFun,event){
	var OBJ = this;
	SpecificManager.getSpecificSelectFromMap3(setValueFun,obj);
	function setValueFun(objs){
		 OBJ.makeSelectHtml(objs,name,width,event);
		 if(callBackFun) callBackFun();
	}	
}




Specific.prototype.makeSelectHtml= function(objs,name,width,event){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
    
    var select = $(name);

    for(var i = 0;i< objs.length;i++){
    
	   var  option = new Option(objs[i].name, objs[i].id);
//	   option.setAttribute("position",objs[i].value);
	   option.position = objs[i].position;
	   select.options.add(option);
    }

//	select.setAttribute("style","width:138px;margin-left:-100px;font-size:12px;");
	select.setAttribute("style","width:" + width +"px;margin-left:-100px;CURSOR: pointer;");
	
	select.setAttribute("onChange","javascript:"+ event +"(this)");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
 }
 
 

Specific.prototype.getSpecific = function(fun,id){

	SpecificManager.getSpecific(fun,id);

}



Specific.prototype.getStoreMap = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;
//	MatterManager.getMatterEditOrLength(fillFun,obj);
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: SpecificManager.getSpecifics}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
//		reader: new  Ext.data.MapReader()
	});
	
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:[paramObj]}});
	}
		return store;
}


Specific.prototype.getSpecificsXML = function(fun){
	SpecificManager.getSpecificsXML(this.obj,fun);
}
//Specific.prototype.getTree = function(paramObj){
//	
//}
	