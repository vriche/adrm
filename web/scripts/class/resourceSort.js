function ResourceSort(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    value:null,
	    memo:null,
        enable:null,
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
	
	this.fileds =
	[
			{name: "id", type: "int"},
			{name: "name", type: "string"}
			
	];
	
	return this;
}

//清空对象
ResourceSort.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.value = null;
  	this.obj.memo = null;
	this.obj.enable = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

ResourceSort.prototype.makeSelect = function(name,event) {
	DWREngine.setAsync(false);
	ResourceSortManager.getResourceSortSelect(setValueFun);
	DWREngine.setAsync(true);	
	
	function setValueFun(objs){
		 makeSelectHtml(objs,name,event);
	}
}  
ResourceSort.prototype.getResourceSorts = function(callBak) {
	
	function setValueFun(objs){
		 if(callBak) callBak(objs);
	}
	ResourceSortManager.getResourceSorts(this.obj,setValueFun);
}  
 

ResourceSort.prototype.makeSelectFromMap = function(name,event,callBackFun) {
	ResourceSortManager.getResourceSortSelectFromMap(setValueFun);
	function setValueFun(objs){
		 makeSelectHtml(objs,name,event);
		 if(callBackFun) callBackFun();
	}
}   

ResourceSort.prototype.makeSelectFromMap5 = function(name,width,event,callBackFun) {
	var OBJ = this;
	ResourceSortManager.getResourceSortSelect2(setValueFun);
	function setValueFun(objs){
		 OBJ.makeSelectHtml(objs,name,width,event);
		 if(callBackFun) callBackFun();
	}
}  



 
ResourceSort.prototype.makeSelectHtml= function(objs,name,width,event){
    var div = document.createElement("div");
    var span = document.createElement("span");
    var parnetNode = $(name).parentNode;
    
    div.setAttribute("style","position:relative;");
    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
    
    DWRUtil.removeAllOptions(name);
    
    var select = $(name);
    
    for(var i = 0;i< objs.length;i++){
	   var  option = new Option(objs[i].name, objs[i].id);
	   option.paramvalue = objs[i].value;
//	   option.setAttribute("value",objs[i].value);
	   select.options.add(option);
    }

//	select.setAttribute("style","width:138px;margin-left:-100px;font-size:12px;");
	select.setAttribute("style","width:" + width +"px;margin-left:-100px;CURSOR: pointer;");
	
	select.setAttribute("onChange","javascript:"+ event +"(this)");
	
	div.appendChild(span);
	span.appendChild(select);
	parnetNode.appendChild(div);
 }

ResourceSort.prototype.makeSelectFromMap2 = function(name,event,width,callBackFun) {
	ResourceSortManager.getResourceSortSelectFromMap2(setValueFun);
	function setValueFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 if(callBackFun) callBackFun();
	}
}   


 ResourceSort.prototype.getStoreObj = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: ResourceSortManager.getResourceSorts}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
	});
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
		}); 
		store.load();			
	}else{
		store.load({params:{dwrParams:paramObj}});
	}
		return store;
};

ResourceSort.prototype.getResourceSortCmd = function(el_id,mode,width,fieldLabel,emptyText){
		var paramObj = this.obj;
		var store = this.getStoreObj('remote',paramObj);
		var resourceSortCmd =new Ext.form.ClearableComboBox({
						 	  id:el_id,
						 	  name:el_id,
							  tiggerAction:'all',
							  fieldLabel:fieldLabel,
							  store:store,
							  editable: false,
							  triggerAction: 'all', //query all
							  lastQuery:'1',
							  displayField:'name',
							  valueField:'id',
							  mode:mode,
							  allowBlank:true,
							   width:width,
							   listWidth:300,
							   forceSelection:false, 
							  emptyText:emptyText,
//							  minChars:2,
//							  hiddenName:'helpCode', //提交传过去的值 
							  filterFiled:'name'

						 });			
	return resourceSortCmd;
}

