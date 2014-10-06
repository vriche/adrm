
function OaAreaCity(){

	this.obj = {
		id:null,
		name:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null
	}
	
	this.fileds =
	[
			{name: "id", type: "int"},
			{name: "name", type: "string"}

	];
	
	
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
OaAreaCity.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
}	

OaAreaCity.prototype.makeSelectAnalyze = function(obj,name,event,callBackFun) {

	OaAreaCityManager.getOaAreaCitySelectFromMap(setValueFun,obj);
	
	function setValueFun(objs){
		 makeSelectHtmlAnalyze(objs,name,event);
		 callBackFun();
	}
}


OaAreaCity.prototype.getStore = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: OaAreaCityManager.getOaAreaCitys}),
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
 
 

OaAreaCity.prototype.buildCommand = function(rederId,elname,width) {
	
  	     var paramObj = this.obj;
         var storeCity = this.getStore('local',paramObj);
    
////	OaAreaCityManager.getOaAreaCitys(this.obj,setValueFun);
//	alert(this.obj);
//	var fn = OaAreaCityManager.getOaAreaCitys;
//	var fileds =
//	[
//			{name: "id", type: "int"},
//			{name: "name", type: "string"}
//	];
//	
//	var paramObj = this.obj;
//	var storeCity = new Ext.data.Store();
//	storeCity.proxy = new Ext.data.DWRHttpProxy({url: fn});
////	storeCity.reader = new Ext.data.MapReader();
//	storeCity.reader = new Ext.data.DWRObjectReader({id: "id"},fileds);
//	storeCity.load({params:{dwrParams:[paramObj],callback:callBackFun}});

//	function callBackFun(objs){
	   new Ext.form.ComboBox({
	        store: storeCity,
	        hideLabels:true,
	        id:elname,
	        name:elname,
	        width:width,
	        displayField:'name',
	         valueField:'id',
	        typeAhead: true,
	        forceSelection: true,
	        triggerAction: 'all',
	        fieldLabel: '城市名称',
	        emptyText:'请选择城市...',
	        selectOnFocus:true,
	         mode: 'local',
	        renderTo:rederId
	    });	
//	}
}



