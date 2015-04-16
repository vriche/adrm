

function Resource(){
	//创建对象
	this.obj ={
		id:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null,
    
		resourceName:null,
	    carrierId:null,
	    parentId:null,
	    resourceType:null,
	    propertiyTime:null,
	
	    proResourceId:null,
		proResourceMemo:null,
		displayNo:null,
	    isClosed:null,
	    isOverweight:null,

	    isValidate:null,
	    isSeralized:null,
		isManual:null,
		enable:null,
    
	    prices:null,
	    workspans:null,
	    resourceYear:null
	}
	
    this.className = null;
	this.treebox = null;
	this.tree = null;
	this.tableName = null;	
	this.selectName =null;
	this.roleTable = null;
	this.tBody = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.treeName = null;
	
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	this.roleId = null;
	
	this.fileds =
	[
			{name: "id", type: "int"},
			
			{name: "broadcastT", mapping: "workspan.broadcastT"},	
			{name: "broadStartTimeS", mapping: "workspan.broadStartTimeS"},		
			{name: "broadEndTimeS", mapping: "workspan.broadEndTimeS"},					
			{name: "resourceName", type: "string"},
			{name: "memo", type: "string"},
			
			{name: "broadcastStartTime", mapping: "workspan.broadcastStartTime"},		
//			{name: "resourceSortId", type: "string"},
			{name: "resourceSortId",  mapping: "resSort.value"}
	];
	
	return this;
}

//清空对象
Resource.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
	
  	this.obj.resourceName = null;
  	this.obj.carrierId = null;
  	this.obj.parentId = null;
  	this.obj.resourceType = null;
  	this.obj.propertiyTime = null;
  	
	this.obj.proResourceId = null;
  	this.obj.proResourceMemo = null;
  	this.obj.displayNo = null;
  	this.obj.isClosed = null;
  	this.obj.isOverweight = null;
 	
	this.obj.isValidate = null;
  	this.obj.isSeralized = null;
  	this.obj.isManual = null;
  	this.obj.enable = null;
 	
	this.obj.prices = null;
  	this.obj.workspans = null;
  	this.obj.resourceYear = null;
  	

}



Resource.prototype.backupObject = function(sourObj,targObj){
	targObj.id = sourObj.id;
	targObj.resourceName = sourObj.resourceName;
	targObj.carrierId = sourObj.carrierId;
	targObj.parentId = sourObj.parentId;
	targObj.resourceType = sourObj.resourceType;
	targObj.propertiyTime = sourObj.propertiyTime;
	targObj.matterType = sourObj.matterType;
	targObj.displayNo = sourObj.displayNo;
	targObj.isClosed = sourObj.isClosed;
	targObj.isOverweight = sourObj.isOverweight;
	targObj.isValidate = sourObj.isValidate;
	targObj.isSeralized = sourObj.isSeralized;
	
	targObj.isManual = sourObj.isManual;
	targObj.enable = sourObj.enable;
	targObj.memo = sourObj.memo;
	targObj.version = sourObj.version;
	return 	targObj;
}

Resource.prototype.makeSelect = function(obj,name,event){
	
	DWREngine.setAsync(false);
	ResourceManager.getResourceSelect(fillFun,obj);
	DWREngine.setAsync(true);

	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}

Resource.prototype.makeSelectFromMap = function(obj,name,event){
	DWREngine.setAsync(false);
	ResourceManager.getResourceSelectFromMap(fillFun,obj);
	DWREngine.setAsync(true);
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}
Resource.prototype.makeResourceSelect = function(obj,name,event,callBack){
	
	DWREngine.setAsync(false);
	ResourceManager.getResourceSelect(fillFun,obj);
	DWREngine.setAsync(true);

	function fillFun(objs){
		makeSelectHtml(objs,name,event);
		callBack();
	}
}

Resource.prototype.makeSelectFromMap2 = function(obj,el,callbackFun,event){
	ResourceManager.getResourceSelectFromMap(obj,fillFun);
	DWRUtil.removeAllOptions(el);
	function fillFun(objs){
//		buildOptionsByObjs(el, objs);
		DWRUtil.addOptions(el, objs);
		el.setAttribute("onChange","javascript:"+ event +"(this)");
	        if(callbackFun) callbackFun();
	}
}

Resource.prototype.getResourceSelectFromMap3 = function(obj,el,width,event,callbackFun){
	var my = this;
	DWRUtil.removeAllOptions(el);
	function fillFun(objs){
		my.makeSelectHtml(objs,el.name,width,event);
	    if(callbackFun) callbackFun();
	}
	
	ResourceManager.getResourceSelectFromMap3(obj,fillFun);


}



//Resource.prototype.makeSelectHtml= function(objs,name,width,event){
//    var div = document.createElement("div");
//    var span = document.createElement("span");
//    var parnetNode = $(name).parentNode;
//    
//    div.setAttribute("style","position:relative;");
//    span.setAttribute("style","margin-left:100px;width:18px;overflow:hidden;");
//    
//    DWRUtil.removeAllOptions(name);
//    
//    var select = $(name);
//
//    for(var i = 0;i< objs.length;i++){
//    
//	   var  option = new Option(objs[i].resourceName, objs[i].id);
////	   option.setAttribute("position",objs[i].value);
//	   option.isManual = objs[i].isManual;
//	   select.options.add(option);
//    }
//
////	select.setAttribute("style","width:138px;margin-left:-100px;font-size:12px;");
//	select.setAttribute("style","width:" + width +"px;margin-left:-100px;CURSOR: pointer;");
//	
//	select.setAttribute("onChange","javascript:"+ event +"(this)");
//	
//	div.appendChild(span);
//	span.appendChild(select);
//	parnetNode.appendChild(div);
// }
Resource.prototype.makeSelectHtml= function(objs,name,width,event){
  
    var parnetNode = $(name).parentNode;
    DWRUtil.removeAllOptions(name);
    var select = $(name);
    for(var i = 0;i< objs.length;i++){
	   var  option = new Option(objs[i].resourceName, objs[i].id);
	   option.isManual = objs[i].isManual;
	   select.options.add(option);
    }

	select.setAttribute("style","width:" + width +"px;margin-left:-100px;CURSOR: pointer;");
	select.setAttribute("onChange","javascript:"+ event +"(this)");
	parnetNode.appendChild(select);
 }


Resource.prototype.getResourceByIdFromMap = function(obj,callBackFun){
//	DWREngine.setAsync(false);
	ResourceManager.getResourceByIdFromMap(fillFun,obj);
//	DWREngine.setAsync(true);
	function fillFun(obj){
		callBackFun(obj);
	}
}





Resource.prototype.getResourcesByCompagesId = function(id,func){
	
	var propertyName = "id";
	var str = new Array();
	DWREngine.setAsync(false);
	ResourceManager.getResourcesByCompagesId(getFun,id,propertyName);	
	DWREngine.setAsync(true);
	
	function getFun(strArray){
		str = strArray;
	}
	return str;
}


Resource.prototype.getResourceIds = function(func){
	ResourceManager.getResourceIds(getFun,this.obj);	
	function getFun(strArray){
		if(func) func(strArray);
	}
}
Resource.prototype.saveResCarrTypeRel = function(resourceType,resIds,callBackFun){
	ResourceManager.saveResCarrTypeRel(getFun,resourceType,resIds);	
	function getFun(){
		if(callBackFun) callBackFun();
	}
}




Resource.prototype.getResource = function(id){
	var OBJ = this;
	var obj = this.obj;
	
	this.reset();
	DWRUtil.setValues(obj);
	DWREngine.setAsync(false);
	ResourceManager.getResource(setValueFun,id);
	DWREngine.setAsync(true);	
	
	function setValueFun(o){
		DWRUtil.setValues(o);
		obj = o;
	}
	return obj;
}

Resource.prototype.getResourceById = function(func,id){
	
	ResourceManager.getResource(func,id);
	
}

Resource.prototype.saveResource = function(func,res){
	
	ResourceManager.saveResource(func,res);
	
}

Resource.prototype.removeResource = function(id){
	ResourceManager.removeResource(id);
}
Resource.prototype.updateDisplayNo = function(objs){
	ResourceManager.updateDisplayNo(objs);
}
Resource.prototype.updateEnable = function(resourceId,enable){
	ResourceManager.updateEnable(resourceId,enable);
}
Resource.prototype.getPriceLength = function(objs){
	var priceLengths;
	DWREngine.setAsync(false);
	ResourceManager.getPriceLength(setValueFun,objs);
	DWREngine.setAsync(true);	
	
	function setValueFun(obj){
		priceLengths=obj;
	}
	return priceLengths;
}

Resource.prototype.getResourcesAllFromChannelId = function(obj,el,callbackFun,event){
	ResourceManager.getResourcesAllFromChannelId(fillFun,obj);
	DWRUtil.removeAllOptions(el);
	function fillFun(objs){
		DWRUtil.addOptions(el, objs);
		el.setAttribute("onChange","javascript:"+ event +"(this)");
	        if(callbackFun) callbackFun();
	}
}


Resource.prototype.getStoreResourceByOrderId = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: ResourceManager.getStoreResourceByOrderId}),
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



 Resource.prototype.comboFilterBy2 = function(qe){
 var combo = qe.combo;  
 var filterFiled = combo.filterFiled;
 var params = combo.params;
 var q = qe.query;  
 var minChars = combo.minChars;

  eval("params."+ filterFiled +" =q");


  
 var forceAll = qe.forceAll;  
 
 
	 if(forceAll === true || (q.length >= combo.minChars)){  

	     if(combo.lastQuery !== q){  
	         combo.lastQuery = q;  
	         if(combo.mode == 'local'){  
	             combo.selectedIndex = -1;  
	             if(forceAll){  
	                 combo.store.clearFilter();  
	             }else{  
	                 combo.store.filterBy(function(record,id){  
	                 	
	                     var text = record.get(filterFiled);  
	                     //在这里写自己的过滤代码  
	                     return (text.indexOf(q)!=-1);  
	                 });  
	             }  
	             combo.onLoad();  
	             
	         }else{  
		             combo.store.baseParams[combo.queryParam] = q;  
		             combo.store.load({  
						  params:{dwrParams:[params]}   
		             });  
		             combo.expand(); 
		             
		             combo.store.on('load', function(store, records, options){
		             	    
						 	if (records.length != 0){
//						        combo.setValue(records[0].data.id);
						    }else{
						    	var rawValue = combo.getRawValue();
						    	combo.setValue(rawValue);
						    	combo.setRawValue(rawValue);
						    }

					 }); 

	         }  
	     }else{  

	         combo.selectedIndex = -1;  
	         combo.onLoad();  
	     }  
	 }  
 	return false;  
 	} 




Resource.prototype.getTree =function(id,params,checkBox,orgId,version,singleExpand){

   var baseAttrs ={};
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}
   var treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: ResourceManager.getTree,
		params: params,
		baseAttrs: baseAttrs //添加 uiProvider 属性  
	});
	
	
	function search(){
				var searchName = Ext.getDom('searchName').value;
				alert("查询字符串："+searchName);
	}	
		

       
	var tree = new Ext.tree.TreePanel({
		 id:id,
	     height :300,
	     width : 300,
	     border:true,
	     rootVisible:false,
	     autoScroll:true,
//	     enableDrop:true,
		 enableDD:true,
		 singleExpand:singleExpand,
	     loader: treeload, //使用第2步中创建树的加载器 
	     checkModel: 'cascade',
//	     bbar: ['名称：',{xtype:'trigger',id: 'searchName',width:200,triggerClass:'x-form-search-trigger',onTriggerClick:search}],
	     root:new Ext.tree.AsyncTreeNode({
	      text: '广告时段',
	      allowDrag:false,
	      id: "0",
	      orgId:orgId,
	      version:version
	      })
//	     listeners:{
//                click:gg.createDelegate(this),
//                beforeload:reload.createDelegate(this)
//         }

	 });
	 
//     tree.on('beforeload', function(){this.body.mask('数据加载中……', 'x-mask-loading');});   
//     tree.on('load', function(node){this.body.unmask();}); 

 		tree.getAllCheckedIds = function(fiterType){
	 
	 			var checkedNodes = this.getChecked();
	                    	var ids = [];
				            for(var i=0;i<checkedNodes.length;i++){    
				              		var node = checkedNodes[i];  
				              		 if(node.attributes.type == fiterType){
				              		 	ids.push(node.id);
				              		 }
				            }    
	     	    return ids.join("_");
	     }
   return tree;
};



Resource.prototype.getResourceCmdTree = function (orgId,paras,cmdId,treeId,allowUnLeafClick,renderTo,filterFiled,emptyText,width,checkBox,singleExpand,onSelected,callFunction){
	       var OBJ = this;
	     	 OBJ.obj.parentId = 0;
	     	 var params = [{}]; //tree dataIn。;
	     	 var tree = OBJ.getTree(treeId,params,checkBox,orgId,OBJ.obj.version,singleExpand);
	     	  	
	     	if(!OBJ.treecombo){
							var conf = {
								       id: cmdId,
								       fieldLabel : '广告位置',
						               width : width,
						               listWidth : 450,
						               treeWidth : 300,
						               treeHeight : 400,
						               lastQuery:'-l',
						               passName : 'id',
						               autoScroll:true,
						               tree :tree,
						               params:paras,
						               filterFiled: filterFiled,
						               emptyText: emptyText,
						               allowBlank : false        
							}	
							if(renderTo) conf.renderTo = renderTo;  
							if(allowUnLeafClick != null) conf.allowUnLeafClick = allowUnLeafClick;  
							if(callFunction) conf.callFunction = callFunction;  
				
							   		
							OBJ.treecombo = new ComboBoxTree(conf);
	     	}
	     	
	     	function onTreeSelected(node){
	     		
	    
	     		var params = OBJ.treecombo.params;
               	var name  ='';
               	var nodeType = node.attributes.nodeType;
               	
               	node.getUI().toggleCheck(true);
               	
//               	if(nodeType <3) return false;
              
               	name = node.text;  	
               	

               
                OBJ.treecombo.passField.value = node.id;
                OBJ.treecombo.setValue(name);  	
                OBJ.treecombo.nodeType = nodeType;
               
                
                var search =  OBJ.treecombo.lastQuery !== node.id;
				if(search){ 
					eval("params."+ filterFiled +" =node.id");  
					OBJ.treecombo.lastQuery = node.id;
					OBJ.treecombo.callFunction(params);
				}
	     	
	     	}
	 
			 function func(){
			 	 var filterFiled = OBJ.treecombo.filterFiled;
			 	 var params = OBJ.treecombo.params;
			 	 eval("params."+ filterFiled +" =null");
			 	 OBJ.treecombo.lastQuery = -1;
			 	 OBJ.treecombo.callFunction(params);
			 	 OBJ.treecombo.nodeType = 0;
			 	 
			 	 OBJ.treecombo.tree.root.getUI().toggleCheck(false);	
			 }

    	   OBJ.treecombo.on("clear",func,this);	 	     	

           if(onSelected){
           	 OBJ.treecombo.on('treeselected',onTreeSelected,OBJ.treecombo);  
           }
          
           
           return OBJ.treecombo;
}


Resource.prototype.getStoreObj = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: ResourceManager.getResourcesBySort}),
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

Resource.prototype.getResourceCmd = function(el_id,mode,width,fieldLabel,emptyText){
		var paramObj = this.obj;
		var store = this.getStoreObj('remote',paramObj);
		var resourceSortCmd =new Ext.form.ClearableComboBox({
						 	  id:el_id,
						 	  name:el_id,
							  forceAll:false,
							  fieldLabel: fieldLabel,
							  store:store,
							  editable: false,
//							  triggerAction: 'all', //query all
							  lastQuery:'1',
							  displayField:'resourceName',
							  valueField:'id',
							  mode:mode,
							  allowBlank:true,
							   width:width,
							   listWidth:300,
//							   forceSelection:false, 
							  emptyText:emptyText,
//							  minChars:2,
//							  hiddenName:'helpCode', //提交传过去的值 
							  filterFiled:'resourceName',
							  filterFiled1:'broadcastStartT',
							  filterFiled2:'resourceSortId'
						 });			
	return resourceSortCmd;
}



Resource.prototype.getStoreObj2 = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: ResourceManager.getResourcesBySort2}),
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

Resource.prototype.getResourceCmd2 = function(el_id,mode,width,fieldLabel,emptyText){
		var paramObj = this.obj;
		var store = this.getStoreObj2('remote',paramObj);
		var resourceSortCmd =new Ext.form.ClearableComboBox({
						 	  id:el_id,
						 	  name:el_id,
							  forceAll:false,
							  fieldLabel: fieldLabel,
							  store:store,
							  editable: false,
//							  triggerAction: 'all', //query all
							  lastQuery:'1',
							  displayField:'resourceName',
							  valueField:'id',
							  mode:mode,
							  allowBlank:true,
							   width:width,
							   listWidth:300,
//							   forceSelection:false, 
							  emptyText:emptyText,
//							  minChars:2,
//							  hiddenName:'helpCode', //提交传过去的值 
							  filterFiled:'resourceName',
							  filterFiled1:'broadcastStartT',
							  filterFiled2:'resourceSortId'
						 });			
	return resourceSortCmd;
}



Resource.prototype.getResourceTimeCmd = function(store,el_id,mode,width,fieldLabel,emptyText){
//	   var store = new Ext.data.Store();
	  
//		sd.filterBy(function(record,id){  
//			if(store.indexOf(record)==-1){
//				store.addSorted(record);
//			}    
//		});		
			
		var resourceSortCmd =new Ext.form.ClearableComboBox({
						 	  id:el_id,
						 	  name:el_id,
							  forceAll:true,
							  fieldLabel: fieldLabel,
							  store:store,
							  editable: false,
							  	hideOnSelect:false,
							  		typeAhead: true,
							  		readOnly : false,
						  triggerAction: 'all', //query all
							  lastQuery:'1',
							  displayField:'broadStartTimeS',
							  valueField:'broadcastStartTime',
							  mode:mode,
							  allowBlank:true,
							   width:width,
							   listWidth:width,
							   forceSelection:false, 
							     selectOnFocus:false,
							  emptyText:emptyText
						 });			
	return resourceSortCmd;
}


Resource.prototype.getFitterStore = function(store,sortId,min,max){
					store.filterBy(function(record,id){    
							 if(min){
								 	if(sortId > 0){
											if(record.get('resourceSortId') == sortId && record.get('broadcastStartTime')>= min && record.get('broadcastStartTime')<= max){          
												return true;         
											} else return false; 
								 	}else{
											if(record.get('broadcastStartTime')>= min && record.get('broadcastStartTime')<= max){          
												return true;         
											} else return false;     
								 	}
 
							 }else{
							 	 	if(sortId > 0){
											if(record.get('resourceSortId') == sortId){          
												return true;         
											} else return false;  
							 	 	}else{
							 	 		return true;      
							 	 	}

							 }
					});		
					
};  

Resource.prototype.getResourcesForQueryXml = function(queryString,type,callBackFun){
	ResourceManager.getResourcesForQueryXml(queryString,type,callBackFun);
}



Resource.prototype.getStoreResourceCtrData = function(mode,paramObj){
	
	paramObj = [paramObj || {}];

	var fileds= [
			{name: "id", type: "int"},
			{name: "broTime", type: "int"},
			{name: "broTimeStr", type: "string"},
			{name: "advContents", type: "string"},
			{name: "broLength", type: "int"}
	];
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: ResourceManager.getResourceCtrData}),
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



Resource.prototype.getResourcesByIds = function(queryString,callBackFun){
	ResourceManager.getResourcesByIds(queryString,callBackFun);
}


//Resource.prototype.getResourceByYearUserStore = function(mode,paramObj){
//	paramObj = [paramObj || {}];
//	var fileds= this.fileds;
//	var store = new Ext.data.Store({
//		proxy: new Ext.data.DWRHttpProxy({url: CarrierManager.getCarrierAlisnamesStore}),
//		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
//	});
//	if(mode == 'remote'){
//	  	store.on('beforeload', function(){
//	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
//		}); 
//		store.load();			
//	}else{
//		store.load({params:{dwrParams:paramObj}});
//	}
//	return store;
//};

Resource.prototype.getResourceIdsByYearUser = function(year,uid,callBackFun){
	ResourceManager.getResourceIdsByYearUser(year,uid,callBackFun);
}
Resource.prototype.saveResourceIdsYearUser = function(resourceIds,uid,rate,callBackFun){
	ResourceManager.saveResourceIdsYearUser(resourceIds,uid,rate,callBackFun);
}
Resource.prototype.removeResourceIdsYearUser = function(ids,callBackFun){
	ResourceManager.removeResourceIdsYearUser(ids,callBackFun);
}

