function Carrier(){
	//创建对象
	this.obj ={
		id:null,
		carrierName:null,
	    aliasName:null,
	    parentId:null,
	    nodeLevel:null,
	    displayNo:null,
	    nodePath:null,
	    memo:null,
	    enable:null,
	    carrierTypeId:null,
	    channelId:null,
	    mediaOrgId:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    isBuildLevel:null,
	    version:null
	}
	
	this.fileds =
	[
			{name: "id", type: "int"},
			{name: "carrierName", type: "string"},
			{name: "aliasName", type: "string"},
			{name: "memo", type: "string"},
			{name: "channelId", mapping: "resourceChannel.id"},
			{name: "channelName", mapping: "resourceChannel.name"}
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
	
	this.selectName = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;
}

//清空对象
Carrier.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.carrierName = null;
  	this.obj.aliasName = null;
  	this.obj.parentId = null;
  	this.obj.nodeLevel = null;
  	this.obj.displayNo = null;
  	this.obj.nodePath = null;
  	this.obj.memo = null;
  	this.obj.enable = null;
  	this.obj.carrierTypeId = null;
  	this.obj.channelId = null;
  	this.obj.mediaOrgId = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.isBuildLevel = null;
  	this.obj.selectName = null;
}


Carrier.prototype.backupObject = function(sourObj,targObj){
	targObj.id = sourObj.id;
	targObj.carrierName = sourObj.carrierName;
	targObj.aliasName = sourObj.aliasName;
	targObj.parentId = sourObj.parentId;
	targObj.nodeLevel = sourObj.nodeLevel;
	targObj.displayNo = sourObj.displayNo;
	targObj.memo = sourObj.memo;
	targObj.enable = sourObj.enable;
	targObj.isBuildLevel = sourObj.isBuildLevel;
	targObj.version = sourObj.version;
	return 	targObj;
}

Carrier.prototype.makeSelect = function(obj,name,event){
	DWREngine.setAsync(false);
	CarrierManager.getCarrierSelect(obj,fillFun);
	DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}
Carrier.prototype.makeSelectItem = function(obj,name,event){
	//DWREngine.setAsync(false);
	CarrierManager.getCarrierSelectItem(obj,fillFun);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}
Carrier.prototype.makeCarrierSelect = function(obj,name,event,callBack){
	DWREngine.setAsync(false);
	CarrierManager.getCarrierSelectItem(obj,fillFun);
	DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
		callBack();
	}
}

Carrier.prototype.makeSelectItemFromMap = function(obj,name,event){
	//DWREngine.setAsync(false);
	CarrierManager.getCarrierSelectItemFromMap(obj,fillFun);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

Carrier.prototype.makeSelectItemFromMapOrderList = function(obj,name,event,callBackFun){
	//DWREngine.setAsync(false);
//	CarrierManager.getCarrierSelectItemFromMap(fillFun,obj);
    obj.nodeLevel = 1;
	CarrierManager.getCarriersAllFromMap(obj,true,true,fillFun);
	
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
		callBackFun();
	}
}

Carrier.prototype.makeSelectItemAnalyze = function(obj,name,event,callback){
	//DWREngine.setAsync(false);
//	CarrierManager.getCarrierSelectItem(fillFun,obj);
	
	 obj.nodeLevel = 1;
	CarrierManager.getCarriersAllFromMap(obj,true,true,fillFun);
	
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtmlAnalyze(objs,name,event);
		if(callback) callback();
	}
}

Carrier.prototype.makeSelectItem2 = function(obj,name,event){
	//DWREngine.setAsync(false);
	CarrierManager.getCarrierSelectItem2(obj,fillFun);
	//DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

Carrier.prototype.getCarrier = function(setValueFun,id){
	CarrierManager.getCarrier(id,setValueFun);
}

Carrier.prototype.getCarrierBuildLevel = function(id){
	var rt;
	DWREngine.setAsync(false);
	CarrierManager.getCarrier(id,setValueFun);
	DWREngine.setAsync(true);
	
	function setValueFun(obj){
		rt =  obj.isBuildLevel == null|| obj.isBuildLevel==""?false:true;
	}
	
	return rt;
}


Carrier.prototype.saveCarrier = function(func,carrier){
//	alert(carrier);
	CarrierManager.saveCarrier(carrier,func);
}

Carrier.prototype.isBuildLevel = function(func,nodeLevel){
//	alert(carrier);
	CarrierManager.isBuildLevel(nodeLevel,func);
}

Carrier.prototype.removeCarrier = function(id){
	CarrierManager.removeCarrier(id);
}

Carrier.prototype.getCarriersAdvTypeXML = function(){
	var OBJ = this;
	var treeXMLString;
	
	DWREngine.setAsync(false);
	CarrierManager.getCarriersAdvTypeXML(this.obj,this.IdPrefix,getxml);
	DWREngine.setAsync(true);
	
	function getxml(treeXML){ 
		OBJ.tree.treeXML = treeXML; 
		treeXMLString = treeXML;
	} 

    return treeXMLString;
}

Carrier.prototype.getCarrierAutoComplet = function(obj,callBackFun){
	CarrierManager.getCarriers(obj,callBackFun);	
}

Carrier.prototype.getCarrierForChannel = function(obj,callBackFun){
	CarrierManager.getCarriersForChannel(obj,callBackFun);	
}
Carrier.prototype.makeSelectItemAnalyze2 = function(obj,name,event,callBackFun) {
	CarrierManager.getCarrierSelectItemAnalyze(setValueFun);
	
	function setValueFun(objs){
		 makeSelectHtmlAnalyze(objs,name,event);
		 callBackFun();
	}
}
Carrier.prototype.makeSelectItemAnalyze3 = function(obj,name,event,width,isRemove,callBackFun) {
	CarrierManager.getCarrierSelectItemAnalyze(setValueFun);
	
	function setValueFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 if(isRemove)$(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}

Carrier.prototype.makeSelectItemAnalyze5 = function(obj,name,event,width,isRemove,theUser,callBackFun) {
	
//    alert(obj.orgId)
	
	CarrierManager.getCarrierSelectItemAnalyze5(theUser,obj.orgId,setValueFun);
	
	function setValueFun(objs){

		 makeSelectHtmlWidth(objs,name,event,width);
		 if(isRemove)$(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}

Carrier.prototype.makeSelectItemAnalyze6 = function(obj,name,event,width,isRemove,theUser,callBackFun) {

	CarrierManager.getCarrierSelectItemAnalyze6(theUser,obj.orgId,setValueFun);
	
	function setValueFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 if(isRemove)$(name).remove(0);  
		 if(callBackFun) callBackFun();
	}
}

Carrier.prototype.getCarriersAllFromMap = function(obj,enable,needZeroId, el,callbackFun,event){
	CarrierManager.getCarriersAllFromMap(obj,enable,needZeroId,fillFun);
	DWRUtil.removeAllOptions(el);
	function fillFun(objs){
		DWRUtil.addOptions(el, objs);
		el.setAttribute("onChange","javascript:"+ event +"(this)");
	        if(callbackFun) callbackFun();
	}
}

Carrier.prototype.makeSelectFromMap2 = function(obj,el,callbackFun,event){
	function fillFun(objs){
		DWRUtil.addOptions(el, objs);
		el.setAttribute("onChange","javascript:"+ event +"(this)");
	    if(callbackFun) callbackFun();
	}
		
	DWRUtil.removeAllOptions(el);
	CarrierManager.getCarrierSelectItemFromMap(obj,fillFun);
	

}




Carrier.prototype.getChannelsByUser = function(el,callbackFun,event){
	CarrierManager.getCarrierSelectItemAnalyze(fillFun);
	DWRUtil.removeAllOptions(el);
	function fillFun(objs){
		DWRUtil.addOptions(el, objs);   
		el.setAttribute("onChange","javascript:"+ event +"(this)");
	        if(callbackFun) callbackFun();
	}
}


Carrier.prototype.getTree =function(theUser,fun){
	CarrierManager.getCarrierTree(theUser,fun);
};



Carrier.prototype.getStoreList = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CarrierManager.getCarrierAlisnamesStore}),
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


Carrier.prototype.getStoreMap = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CarrierManager.getStoreMap}),
		reader: new Ext.data.MapReader(),
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







Carrier.prototype.getLovCombo = function(id,width,mode,checkBox){
		 var OBJ = this;
  	     var paramObj = this.obj;
         var store = this.getStoreMap(mode,paramObj);

		 var resourceTypeCmd;
		 var conf = {
	 	     fieldLabel: '频道'
			 ,id:id
			,name:id
			,width:width
			,hideOnSelect:false
			,maxHeight:200
			,readOnly: false 
	  		,editable: false
	  		,typeAhead: true
			,emptyText: '请选择...' 
			,store:store
			,triggerAction:'all'
			,valueField:'key'
			,displayField:'value'
			,mode:mode		  	
			};
	 
	 if(checkBox){
		  resourceTypeCmd = new Ext.ux.form.LovCombo(conf);		
	 }else{
		  resourceTypeCmd =  new Ext.form.ClearableComboBox(conf);		
	 }
	return 	resourceTypeCmd
	
}


Carrier.prototype.getStoreListWithChannel = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CarrierManager.getCarrierWithChannel}),
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
Carrier.prototype.getStoreListWithChannel2 = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CarrierManager.getCarrierWithChannel2}),
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
Carrier.prototype.getLovCombo2 = function(id,width,mode,checkBox){
		 var OBJ = this;
  	     var paramObj = this.obj;
         var store = this.getStoreListWithChannel(mode,paramObj);

		 var resourceTypeCmd;
		 var conf = {
	 	     fieldLabel: '频道'
			 ,id:id
			,name:id
			,width:width
			,hideOnSelect:false
			,maxHeight:200
			,readOnly: false 
	  		,editable: false
	  		,typeAhead: true
			,emptyText: '请选择...' 
			,store:store
			,triggerAction:'all'
			,valueField:'channelId'
			,displayField:'channelName'
			,mode:mode		  	
			};
	 
	 if(checkBox){
		  resourceTypeCmd = new Ext.ux.form.LovCombo(conf);		
	 }else{
		  resourceTypeCmd =  new Ext.form.ClearableComboBox(conf);		
	 }
	return 	resourceTypeCmd
	
}

Carrier.prototype.getLovCombo3 = function(id,width,mode,checkBox,fieldLabel,emptyText){
		 var OBJ = this;
  	     var paramObj = this.obj;
         var store = this.getStoreListWithChannel2(mode,paramObj);

		 var resourceTypeCmd;
		 var conf = {
	 	     fieldLabel: fieldLabel
			 ,id:id
			,name:id
			,width:width
			,listWidth:160
			,hideOnSelect:false
			,maxHeight:200
			,readOnly: false 
			,forceSelection:true
			, allowBlank:false
	  		,editable: false
	  		,typeAhead: true
			,emptyText: emptyText
			,store:store
			,triggerAction:'all'
			,valueField:'id'
			,displayField:'carrierName'
			,mode:mode		  	
			};
	 
	 if(checkBox){
		  resourceTypeCmd = new Ext.ux.form.LovCombo(conf);		
	 }else{
		  resourceTypeCmd =  new Ext.form.ClearableComboBox(conf);		
	 }
	return 	resourceTypeCmd
	
}


//Carrier.prototype.getLovComboForCtr = function(id,width,mode,checkBox,fieldLabel,emptyText){
//		 var OBJ = this;
//
//
//       var tabledata = [["0",""]];
//          var store = new Ext.data.Store({
//               proxy: new Ext.data.MemoryProxy(tabledata),
//               reader: new Ext.data.ArrayReader({},[//注意在用数组填充数据时，为ArrayReader
//                     {name:"id"},
//                     {name:"carrierName"}
//               ])
//              });
//      store.load();
//    
//    
//
//		 var resourceTypeCmd;
//		 var conf = {
//	 	     fieldLabel: fieldLabel
//			 ,id:id
//			,name:id
//			,width:width
//			,listWidth:200
//			,hideOnSelect:false
//			,maxHeight:200
//			,readOnly: false 
//			,forceSelection:true
//			, allowBlank:false
//	  		,editable: false
//	  		,typeAhead: true
//			,emptyText: emptyText
//			,store:store
//			,triggerAction:'all'
//			,valueField:'id'
//			,displayField:'carrierName'
//			,mode:mode		  	
//			};
//	 
//	 if(checkBox){
//		  resourceTypeCmd = new Ext.ux.form.LovCombo(conf);		
//	 }else{
//		  resourceTypeCmd =  new Ext.form.ClearableComboBox(conf);		
//	 }
//	return 	resourceTypeCmd
//	
//}



Carrier.prototype.getLovComboForCtr = function(id,width,mode,checkBox,fieldLabel,emptyText){
		 var OBJ = this;
	  var paramObj = this.obj || {};

    var store = this.getStoreObjsCtr(mode,paramObj);

		 var resourceTypeCmd;
		 var conf = {
	 	     fieldLabel: fieldLabel
			 ,id:id
			,name:id
			,width:width
			,listWidth:200
			,hideOnSelect:false
			,maxHeight:200
			,readOnly: false 
			,forceSelection:true
			, allowBlank:false
	  		,editable: false
	  		,typeAhead: true
			,emptyText: emptyText
			,store:store
			,triggerAction:'all'
			,valueField:'id'
			,displayField:'carrierName'
			,mode:mode		  	
			};
	 
	 if(checkBox){
		  resourceTypeCmd = new Ext.ux.form.LovCombo(conf);		
	 }else{
		  resourceTypeCmd =  new Ext.form.ClearableComboBox(conf);		
	 }
	return 	resourceTypeCmd
	
}


Carrier.prototype.getStoreMapCtr = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CarrierManager.getStoreMapCtr}),
		reader: new Ext.data.MapReader(),
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


Carrier.prototype.getStoreObjsCtr = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CarrierManager.getStoreObjsCtr}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
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



