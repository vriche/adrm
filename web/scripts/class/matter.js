

function Matter(){
	//创建对象
	this.obj ={
		id:null,
		name:null,
	    edit:null,
	    length:null,
	    brandId:null,
	    brandId2:null,
	    customerId:null,
	    matterType:null,
		tapeCode:null,
		
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    memo:null,
		enable:null,
		
		startDate:null,
		endDate:null,
		
		customer:null
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
			{name: "edit", type: "string"},
			{name: "length", type: "string"},	
	];
	
	return this;
}

//清空对象
Matter.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.name = null;
  	this.obj.edit = null;
  	this.obj.length = null;
  	this.obj.brandId = null;
  	this.obj.brandId2 = null;
  	this.obj.customerId = null;
	this.obj.matterType = null;
  	this.obj.tapeCode = null;  	

  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.memo = null;
  	this.obj.enable = null;
  	
  	this.obj.customer = null;
}
Matter.prototype.backupObject = function(sourObj,targObj){
	targObj.id = sourObj.id;
	targObj.name = sourObj.name;
	targObj.edit = sourObj.edit;
	targObj.length = sourObj.length;
	targObj.brandId = sourObj.brandId;
	targObj.brandId2 = sourObj.brandId2;
	targObj.customerId = sourObj.customerId;
	targObj.matterType = sourObj.matterType;
	targObj.tapeCode = sourObj.tapeCode;
	targObj.enable = sourObj.enable;
	targObj.version = sourObj.version;
	return 	targObj;
}

Matter.prototype.getMatterByTapCode = function(obj,func1){
//	alert(obj);
//	this.reset();
//	DWRUtil.setValues(this.obj);
	MatterManager.getMatterByTapCode(obj,func1);
//		alert(obj);
//	function setValueFun(obj){
//		DWRUtil.setValues(obj);
//	}
}

Matter.prototype.getMatterAutoComplet = function(obj,callBackFun){
	MatterManager.getMatters(callBackFun,obj);	
}




//通过用户名与广告长度查询广告信息,用来代替上面的‘getMatterAutoComplet’,代替原因是原来方法太耗内存.
Matter.prototype.getMattersByCustomerIdAndLength = function(obj,callBackFun){
	MatterManager.getMattersByCustomerIdAndLength(obj,callBackFun);	
}

Matter.prototype.getMatterAutoCompletDIV = function(obj,callBackFun){
	MatterManager.getMattersDIV(obj,callBackFun);	
}
Matter.prototype.saveMatterForm = function(obj,callBackFun){
//	alert("call  saveMatterForm ");
	MatterManager.saveMatterForm(obj,callBackFun);	
}
//下面两个函数实现远程签单中的广告选择
Matter.prototype.makeMatterSelect = function(obj,name,event,callBack){
	DWREngine.setAsync(false);
	MatterManager.getMatterName(fillFun,obj);
	DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
		callBack();
	}
}
Matter.prototype.makeMatterEditOrLengthSelect = function(obj,name,event,callBack){
	DWREngine.setAsync(false);
	MatterManager.getMatterEditOrLength(fillFun,obj);
	DWREngine.setAsync(true);
	
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
		callBack();
	}
}
Matter.prototype.getMatter = function(id){
	this.reset();
	DWRUtil.setValues(this.obj);
	MatterManager.getMatter(setValueFun,id);
		
	function setValueFun(obj){
		DWRUtil.setValues(obj);
	}
}

Matter.prototype.getCountByDate = function(beginDate,startOrend){
	var count;
	DWREngine.setAsync(false);
	MatterManager.getMattersCountByDate(getCountFun,beginDate,startOrend);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Matter.prototype.getMattersByDate = function(beginDate,startOrend){
	var OBJ = this;
	var obj = OBJ.obj;
	var page   = this.page;
    if (page.pageSize > 0){
		var size = this.getCountByDate(beginDate,startOrend);
		page.size = size;

		page.MakePageNav(page.pageIndex,page.pageInfo);
		MatterManager.getMattersByDate(OBJ.fillTalbeByDate,beginDate,startOrend,page.pageIndex,page.pageSize);
    }else{
		MatterManager.getMatters(OBJ.fillTalbeByDate,obj);	
    } 
}

Matter.prototype.fillTalbeByDate = function(objs){
	var OBJ = matter;
	var obj = OBJ.obj;
	var tBody  = matter.tBody;
	var color1 = matter.color1;
	var color2 = matter.color2;
	
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("rowData", rowData);
	 }	

	function endDateFormat(intDate){
		var yy = intDate.substring(0,4);
		var mm = intDate.substring(4,6);
		var dd = intDate.substring(6,8);
		var end = new Date(yy, mm*1-1, dd*1+1, 0, 0, 0);
                var val = end - new Date();
                val = Math.round(val /(3600000*24));
	return val;
}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){ return encode_data_xml(obj.name)},
					function(obj){ return encode_data_xml(obj.customer.customerName)},
					function(obj){ return getFormatDay(obj.startDate,'y/m/d')},
					function(obj){ return getFormatDay(obj.endDate,'y/m/d')},
					function(obj){ return encode_data_xml(obj.edit)},
					function(obj){ return obj.length},
					function(obj){ return encode_data_xml(obj.tapeCode)},
					function(obj){ return endDateFormat(obj.endDate)},
			];		
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}

Matter.prototype.getMatters = function(o){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = this.page;
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		MatterManager.getMattersPage(obj,page.pageIndex,page.pageSize,OBJ.fillTalbe);
    }else{
		MatterManager.getMatters(obj,OBJ.fillTalbe);	
    } 
}
Matter.prototype.getMattersSearch = function(o,matterName,customerName,matterEdit,matterType){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = this.page;
	var orgId = obj.orgId;
    if (page.pageSize > 0){
		var size = this.getSearchCount(orgId,matterName,customerName,matterEdit,matterType);
		page.size = size;
		page.pageIndex = page.pageIndex;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		MatterManager.getMattersSerachPage(orgId,matterName,customerName,matterEdit,matterType,page.pageIndex,page.pageSize,OBJ.fillTalbe);
    }else{
		MatterManager.getMatters(obj,OBJ.fillTalbe);	
    } 
}

Matter.prototype.getSearchCount = function(orgId,matterName,customerName,matterEdit,matterType){
	var count;
	DWREngine.setAsync(false);
	MatterManager.getMattersSerachCount(orgId,matterName,customerName,matterEdit,matterType,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Matter.prototype.getMatterByNameVerLen = function(o){
  var object;
  DWREngine.setAsync(false);
  MatterManager.getMatterByObj(o,func);
  DWREngine.setAsync(true);
  function func(obj){
  	object =obj;
  }
  return object;
}

Matter.prototype.getMatterByTapeCode = function(o){
  var object;
  DWREngine.setAsync(false);
  MatterManager.getMatterByObj(func,o);
  DWREngine.setAsync(true);
  function func(obj){
  	object =obj;
  }
  return object;
}

Matter.prototype.getAllMatters = function(o,func){
	MatterManager.getAllMatters(func,o);
}
Matter.prototype.saveMatter3 = function(o,func){
	MatterManager.saveMatter3(o,func);
}




Matter.prototype.CheckMatter = function(o,func){
//	alert(o.length);
	MatterManager.getCheckMatter(o,func);
}

Matter.prototype.getMattersByCustomerId = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page = OBJ.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		MatterManager.getMattersPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		MatterManager.getMatters(func,obj);	
    } 
}
Matter.prototype.fillTalbe = function(objs){
	var OBJ = matter;
	var obj = OBJ.obj;
	var tBody  = matter.tBody;
	var color1 = matter.color1;
	var color2 = matter.color2;
	
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
//	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
//	 	row.setAttribute("paraId", rowData.id);
//	 	row.setAttribute("name", rowData.name);
//	 	row.setAttribute("customerId", rowData.customerId);
//	 	row.setAttribute("matterType", rowData.matterType);
//	 	row.setAttribute("edit", rowData.edit);
//	 	row.setAttribute("length", rowData.length);
//	 	row.setAttribute("tapeCode", rowData.tapeCode);
//	 	row.setAttribute("memo", rowData.memo);
//	 	row.setAttribute("enable", rowData.enable);
	 	row.setAttribute("rowData", rowData);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeOrderCategory(id,delRow);
	}
	

	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){ return '<a href="javascript:void 0" onClick="editInfo('+ obj.id +')">' + encode_data_xml(obj.name) +'</a>'},
					function(obj){ return encode_data_xml(obj.edit)},
					function(obj){ return obj.length},
					function(obj){ return encode_data_xml(obj.tapeCode)},
					function(obj){return encode_data_xml(obj.matType.name)},
//					function(obj){ return encode_data_xml(obj.customer.customerName)},
					
					function(obj){ 
						var v =  obj.industry.parentName!=''&& obj.industry.parentName != null?obj.industry.parentName+'/'+obj.industry.name:obj.industry.name
						return encode_data_xml(v);
						},
						
					function(obj){
							var i = obj.pos;
							if(i == 1){
								return encode_data_xml("首一");
							}else if(i == 2){
								return encode_data_xml("尾一");
							}else{
								return ""
;							}
						},
						
					function(obj){ return formatDateGlobal3(obj.createDate)},
					
					function(obj){ 
						
						
						return obj.endDate >=curDate?"是":""; 
						
						},			
					
					
					function(obj){ return obj.enable?'是':'否'},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
//							if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}

/* 总记录数
 * 
 */
Matter.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	MatterManager.getMattersCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
Matter.prototype.fillTableByCustomerId = function(objs){
	var OBJ = matter;
	var obj = OBJ.obj;
	var tBody  = matter.tBody;
	var color1 = matter.color1;
	var color2 = matter.color2;
	
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("name", rowData.name);
	 	row.setAttribute("edit", rowData.edit);
	 	row.setAttribute("length", rowData.length);
	 	row.setAttribute("tapeCode", rowData.tapeCode);
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeOrderCategory(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){ return "<a href='editMatter.html?id=" +obj.id +"'>" + encode_data_xml(obj.name) +"</a>"},
					function(obj){ return encode_data_xml(obj.edit)},
					function(obj){ return obj.length},
					function(obj){ return encode_data_xml(obj.tapeCode)},
					function(obj){ return ""},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
//							if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}

Matter.prototype.getMatterXML = function(o,func){
	MatterManager.getMatterXML(func,o,this.IdPrefix);
}

Matter.prototype.getMatterNameXML = function(o,func){
	MatterManager.getMatterNameXML(o,func);
}

Matter.prototype.getMattersListXML = function(obj,callBackFun){
	MatterManager.getMattersListXML(callBackFun,obj);	
}
Matter.prototype.saveMatter = function(obj,callBackFun){
	DWREngine.setAsync(false);
	MatterManager.saveMatter(obj,callBackFun);	
    DWREngine.setAsync(true);  
}

Matter.prototype.saveMatter2 = function(obj,callBackFun){
	DWREngine.setAsync(false);
	MatterManager.saveMatter2(obj,callBackFun);	
    DWREngine.setAsync(true);  
}




Matter.prototype.getStoreMatter = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: MatterManager.getMatters}),
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



Matter.prototype.getStoreMatterEditByName = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: MatterManager.getStoreMatterEditByName}),
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


Matter.prototype.getStoreMatterByOrderId = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: MatterManager.getMattersByOrderId}),
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

Matter.prototype.getStoreMatterLengthByName = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;
//	MatterManager.getMatterEditOrLength(fillFun,obj);
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: MatterManager.getStoreMatterLengthByName}),
//		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
		reader: new  Ext.data.MapReader()
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





 Matter.prototype.comboFilterBy2 = function(qe){
 var combo = qe.combo;  
 var filterFiled = combo.filterFiled;
 var filterFiled2 = combo.filterFiled2;
 var params = combo.params;
 var q = qe.query;  
 var minChars = combo.minChars;
 

  eval("params."+ filterFiled +" =q");
  eval("params."+ filterFiled2 +" =q");

  
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
	                     var match = (text.indexOf(q)!=-1);  
	                     if(!match && filterFiled2){
	                     	match = (record.get(filterFiled2).indexOf(q)!=-1);
	                     }
	                     //在这里写自己的过滤代码  
	                     return match;
	                 });  
	             }  
	             combo.onLoad();  
	             
	         }else{  

		         	 if(q !== ''){
			             combo.store.baseParams[combo.queryParam] = q;  
			             combo.store.load({  
							  params:{dwrParams:[params]}   
			             });  
		         	 }	         	
		         	 combo.expand(); 

//		             combo.store.baseParams[combo.queryParam] = q;  
//		             combo.store.load({  
//						  params:{dwrParams:[params]}   
//		             });  
//		             combo.expand(); 
		             
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
 	
 	
 	
 	
 
 Matter.prototype.getMatterNamesStoreList = function(mode,paramObj){
//	mode = mode || 'local';
	paramObj = paramObj || {};
	var fileds= this.fileds;
	
	

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: MatterManager.getMatterNamesStore}),
		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
	});
	
	if(mode == 'remote'){
	  	store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
		}); 
	  	if(paramObj.name != null) store.load();	
				
	}else{
		store.load({params:{dwrParams:[paramObj]}});
	}

	return store;
}
 	
 	
 Matter.prototype.getCommand = function(id,renderTo,width){
    var OBJ = this;
 	var mode = 'remote';
    var store = OBJ.getMatterNamesStoreList(mode,OBJ.obj);  

    
   	this.customerCommand = new Ext.ux.form.LovCombo({
   		    showSelectAll   : true,  
			id:id,
			name: id,
			displayField: 'name',
//		  tiggerAction:'all', 
		  store:store,
		  width:width,
		   listWidth:300,
		  editable: true,
//		  triggerAction: 'all', //query all
		  lastQuery:'l',
//          typeAhead :true,
		  valueField:'name',
		  mode:mode,
		  allowBlank:false,
		   resizable : true,  
		   anchor : '60%',
		   forceSelection:false, 
//		  forceAll:true,
		  allowBlank:true,
		  emptyText:'请输入品牌...',
		  minChars:2,
//		  hiddenName:'helpCode', //提交传过去的值 
		  filterFiled:'name',
//		  filterFiled2:'helpCode',
		  params:OBJ.obj,
		  renderTo:renderTo
		  ,listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
	 });     
 	
  }		
  
  
 Matter.prototype.getMattersNamesStore = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: MatterManager.getMattersNamesStore}),
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
 
  
	
 Matter.prototype.getCommandForSelect = function(id,emptyText,filterFiled,minChars,width,callFunction){
   var OBJ = this;
   var store = new Ext.data.Store();

  var conf = {
			id:id,
			name: id,
		  store: store,
		  width:width,
		  editable: true,
		  lastQuery:'-l',
		  mode:true,
		  allowBlank:false,
		  resizable : false,  
		   anchor : '60%',
		   forceSelection:false, 
		  allowBlank:false,
		   emptyText: emptyText,
		   filterFiled: filterFiled,
		  minChars:minChars,
		  params:OBJ.obj,
		  callFunction:callFunction,
		  listeners:{beforequery:OBJ.comboFilterBy3.createDelegate(this)}	
	 }
	 

	 
	 
//	   if(filterFiled == 'length'){
//	    	conf.valueField = 'key';
//	   		conf.displayField = 'value';
//	     	conf.typeAhead = true;
//	   	    conf.filterFiled = 'value',
//	   		conf.store = OBJ.getStoreMatterLengthByName('local',{orgId:OBJ.obj.orgId});  
//	   }	 
	 
	 
	 var cmd = new Ext.form.ClearableComboBox(conf);  
	 
	 function func(){
	 	 var filterFiled = cmd.filterFiled;
	 	 var params = cmd.params;
	 	 eval("params."+ filterFiled +" =null");
	 	 cmd.lastQuery = -1;  
	 	 cmd.callFunction(params);
	 }

     cmd.on("clear",func,this);	 
  
   return cmd

  }	  
  
 
 Matter.prototype.comboFilterBy3 = function(qe){
 var combo = qe.combo;  
 var filterFiled = combo.filterFiled;
 var params = combo.params;
 var q = qe.query;  
 var minChars = combo.minChars;
 eval("params."+ filterFiled +" =q"); 
   
 var forceAll = qe.forceAll;  

 var search = q.length >= combo.minChars && combo.lastQuery !== q;
 
	 if(forceAll === true || search){  
	         combo.lastQuery = q;  
	         combo.callFunction(params);
	 }
	 return false;  
 } 	
 	
 	
/* 添加新行 编辑或删除 
 * 
 */
//Matter.prototype.addNewRow = function(mode,editRow){
//    var OBJ = this;
//    var obj = this.obj;
//	var page = this.page;
//	var tBody = this.tBody;
//
//	
//	if (!checkEeitState('btn_SaveImgTd')) return false;
//	
//	function getRowDataInObj(editRow){
//	 	obj.id = editRow.getAttribute("paraId");
//	 	obj.name = editRow.getAttribute("name");
//	 }	 
//	 
//	function save(event){
//		var e = event || window.event;
//		var saveImgTd = Event.element(e);		
//		var mode = saveImgTd.getAttribute("mode");
//		var id = saveImgTd.getAttribute("paraId");
//
//		DWRUtil.getValues(obj);
//
//		OBJ.saveOrderCategory(obj,mode);
//	}	 
//	
//	function cannel(event){
//		 OBJ.reset();
//		 OBJ.getOrderCategorys()
//	}	 	
//	 
//	//从编辑行中获得数据，来添对象
//	if(mode =='edit'){ 
//		getRowDataInObj(editRow);
//	}
//
//
//	//////////////////构造新行 start //////////////////
//	
//	var container = document.createElement("span");
//	var newRow = document.createElement("tr");
//	//给新行设置ID属性
//	newRow.setAttribute("id",obj.id);
//		
//	var cell = []; var j = 0;
//		
//	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",obj.id,"");
//	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");
//
//	cannelImgTd.onclick = function(){
//	    newRow.remove(); 
//    	setColors(tBody,color1,color2);
//    }
//
//	cell[j++] =  makeInputTextTd("name","text","10px",obj.name,"");
//	cell[j++] =  makeInputTextTd("value","text","10px",obj.value,"");
//	cell[j++] =  makeInputTextTd("calculateAuto","text","10px",obj.calculateAuto,"");
//	cell[j++] =  saveImgTd;
//	cell[j++] =  cannelImgTd;
//
//	for (var i = 0;i < cell.length;i++ ){
//		newRow.appendChild(cell[i]);
//	}
//	container.appendChild(newRow);
//	
//	//////////////////构造新行 end ///////////////////
//	
//	
//	
//	//编辑状态：追加新行，删除旧行	
//	if(mode =='edit'){
//		new Insertion.After(editRow,container.innerHTML);
//		editRow.remove();	
//	}else{
//	//新添状态，直接追加新行
//		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
//		tBody.appendChild(newRow);
//	}
//		
//	//只能在新行添完后，才能给对象添加事件
//	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
//	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
//	
//	if(mode =='edit'){
//		btn_SaveImgTd.setAttribute("mode","edit")
//	}else{
//		btn_SaveImgTd.setAttribute("mode","new")
//	}
//
//	setColors(tBody,this.color1,this.color2);
//}
//
