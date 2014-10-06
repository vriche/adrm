function IncomeMode(){
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
	
		this.fileds =
	[
			{name: "id", type: "int"},
			{name: "name", type: "string"},
			{name: "value", type: "string"}
	];
	
	return this;
}

//清空对象
IncomeMode.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.value = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}

IncomeMode.prototype.makeSelect = function(obj,name,event){
	//DWREngine.setAsync(false);
	IncomeModeManager.getIncomeModeSelect(fillFun,obj);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}




IncomeMode.prototype.makeSelectFromMap = function(obj,name,event,width,callBackFun){
	IncomeModeManager.getIncomeModeFromMap(fillFun,obj);
	function fillFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 $(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}

IncomeMode.prototype.makeSelectItemAnalyze = function(obj,name,event,callback){
	 obj.nodeLevel = 1;
	IncomeModeManager.getIncomeModeFromMap(obj,fillFun);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
		if(callback) callback();
	}
}




		
 IncomeMode.prototype.getStore = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: IncomeModeManager.getIncomeModes}),
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

IncomeMode.prototype.getIncomeModeCmd =  function(rederId,elname,width,callBackFun){
	  var OBJ = this;
  	  var paramObj = this.obj;
      var store = OBJ.getStore('remote',paramObj);
      
      var conf = {
        store: store,
        id:elname,
        name:elname,
        width:width,
        listWidth:300,
        displayField:'name',
         valueField:'id',
        typeAhead: true,
        editable: false,
        mode: 'local',
        forceSelection: true,
        triggerAction: 'all',
        fieldLabel: '到款类型',
        emptyText:'请选择...',
        selectOnFocus:true,
        forceAll:true,
        minChars:2,
        filterFiled:'name',
        params:paramObj
//        params:paramObj,

//		listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
    };
    
    if(rederId) conf.renderTo = rederId;

    var cmd = new Ext.form.ClearableComboBox(conf);
    
      cmd.store.on('load', function(){cmd.setValue(3);}); 
    
    return cmd;
    
};

