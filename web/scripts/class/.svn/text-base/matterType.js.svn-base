function MatterType(){

	this.obj = {
		id:null,
		name:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    matterIds:null,
	    value:null
	}
	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxTarg = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.radioTarg = null;
	this.radioName = null;
	this.selectTarg = null;
	this.selectName = null;
	
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
			{name: "value", type: "string"}
	];
	
	return this;	
}	

MatterType.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.matterIds = null;
  	this.obj.value = null;
}	
MatterType.prototype.makeSelect = function(targetName,event,callBackFun){
	var OBJ = this;
	var obj = this.obj;
	MatterTypeManager.getMatterTypeSelect(fillFun,obj);	
	
	function fillFun(objs){
		makeSelectHtml(objs,targetName,event);
		callBackFun();
	}
}

MatterType.prototype.getMatterTypeXML = function(OBJ,matterIdPrefix,callBackFun){
	var obj = OBJ.obj;
//	alert(OBJ.IdPrefix);
//	alert(matterIdPrefix);
	MatterTypeManager.getMatterTypeXML(obj,OBJ.IdPrefix,matterIdPrefix,fillFun);
	function fillFun(treeXML){
		callBackFun(treeXML);
	}
	
}	










 MatterType.prototype.getStoreMatterType = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: MatterTypeManager.getMatterTypes}),
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
 
  
MatterType.prototype.getMatterTypeCmd =  function(paramObj,renderTo,elname,filterFiled,width,emptyText,callFunction){
	var OBJ = this;
	var store = OBJ.getStoreMatterType('remote',OBJ.obj);
         
	var conf ={
        store: store,
        id:elname,
        name:elname,
        width:width,
        lazyRender: true,
        displayField:'name',
         valueField:'id',
        typeAhead: true,
        forceSelection: false,
        triggerAction: 'all',
        emptyText:emptyText,
        selectOnFocus:true,
         mode: 'local',
         minChars:1,
         params:paramObj

    };  

    if(renderTo) conf.renderTo = renderTo;
    if(filterFiled) conf.filterFiled = filterFiled;
    if(callFunction) conf.callFunction = callFunction;
    
	var cmd = new Ext.form.ClearableComboBox(conf);

// 	cmd.getEl().on("mousedown",function(){cmd.onTriggerClick();});
     
	 function func(){
	 	 var filterFiled = cmd.filterFiled;
	 	 var params = cmd.params;
	 	 eval("params."+ filterFiled +" =null");
	 	 cmd.callFunction(params);
	 }
	 
	function func2(){
	 	 var filterFiled = cmd.filterFiled;
	 	 var params = cmd.params;
	 	 var value = cmd.getValue();
	 	 eval("params."+ filterFiled +" =value");
	 	 cmd.callFunction(params);
	 }

     cmd.on("clear",func,this);	 
     cmd.on("select",func2,this);	 

     
	return cmd;

 };
		
