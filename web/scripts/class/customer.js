

function Customer(){
	//创建对象
	this.obj ={
		id:null,
		customerName:null,
	    helpCode:null,
	    customerCategoryId:null,
	    customerTypeId:null,
	    
	    parentId:null,
		industryTypeId:null,
		customerLevel:null,
	    telephone:null,
	    fax:null,
	    
	    webSite:null,
	    creditAccount:null,
		creditSpan:null,
		discountRate:null,
	    delayDays:null,
	    
	    delayDateUnit:null,
	    paymentExpireDays:null,
	    accountName:null,
		accountBank:null,
		accountNumber:null,
		
	    ownerAgent:null,
	    accountAddress:null,
	    memo:null,
	    customerState:null,
	    
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    
	    category:null,
		customerType:null,
		industry:null,
	    linkMan:null
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
			{name: "helpCode", type: "string"},
			{name: "customerName", type: "string"},
			{name: "customerCategoryId", type: "string"},
			{name: "customerCategoryCode", type: "string"},
			{name: "categoryName", mapping: "category.categoryName"}
	];
	
		this.fileds2 =
	[
			{name: "id", type: "int"},
			{name: "helpCode", type: "string"},
			{name: "customerName", type: "string"},
			{name: "customerCategoryId", type: "string"},
			{name: "customerCategoryCode", type: "string"}
	];
	
	return this;
}

//清空对象
Customer.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.customerName = null;
  	this.obj.helpCode = null;
  	this.obj.customerCategoryId = null;
  	this.obj.customerTypeId = null;
  	
	this.obj.parentId = null;
  	this.obj.industryTypeId = null;
  	this.obj.customerLevel = null;
  	this.obj.telephone = null;
  	this.obj.fax = null;
  	
	this.obj.webSite = null;
  	this.obj.creditAccount = null;
  	this.obj.creditSpan = null;
  	this.obj.discountRate = null;
  	this.obj.delayDays = null;
  	
	this.obj.delayDateUnit = null;
  	this.obj.paymentExpireDays = null;
  	this.obj.accountName = null;
  	this.obj.accountBank = null;
  	
  	this.obj.accountNumber = null;
	this.obj.ownerAgent = null;
  	this.obj.accountAddress = null;
  	this.obj.memo = null;
  	this.obj.customerState = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	
  	this.obj.category = null;
  	this.obj.customerType = null;
  	this.obj.industry = null;
  	this.obj.linkMan = null;
}




Customer.prototype.getCustomer = function(id){
	var OBJ = this;
	var obj = OBJ.obj;
	
	this.reset();
	DWRUtil.setValues(this.obj);
	DWREngine.setAsync(false);
	CustomerManager.getCustomer(setValueFun,id);
	DWREngine.setAsync(true);
	
	function setValueFun(o){
		DWRUtil.setValues(o);
		obj = o;
	}
	return obj;
}

Customer.prototype.getCustomerOne = function(id,callBackFun){
	CustomerManager.getCustomer(callBackFun,id);
}

Customer.prototype.getCustomers = function(o){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = OBJ.page;
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		
		CustomerManager.getCustomersPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
    }else{
		CustomerManager.getCustomers(OBJ.fillTalbe,obj);	
    }
}
Customer.prototype.getCustomerByObject = function(obj,callBackFun){  
		CustomerManager.getCustomerByObject(callBackFun,obj);	
}

Customer.prototype.getCustomerByObject2 = function(obj,callBackFun){  
	DWREngine.setAsync(false);
		CustomerManager.getCustomerByObject(setValueFun,obj);	
		DWREngine.setAsync(true);
		
		function setValueFun(o){
			callBackFun(o);
		}
}
   
Customer.prototype.getCustomersByName = function(obj,callBackFun){
		CustomerManager.getCustomers(callBackFun,obj);	
}

//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
Customer.prototype.fillTalbe = function(objs){	
	var OBJ = customer;
	var obj = OBJ.obj;
	var tBody  = customer.tBody;
	var color1 = customer.color1;
	var color2 = customer.color2;
	
	//把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("customerName", rowData.customerName);
	 	row.setAttribute("helpCode", rowData.helpCode);
	 	row.setAttribute("telephone", rowData.telephone);
	 	row.setAttribute("fax", rowData.fax);
	 	row.setAttribute("creditAccount", rowData.creditAccount);
	 	row.setAttribute("ownerAgent", rowData.ownerAgent);
	 	row.setAttribute("customerState", rowData.customerState);
	 	row.setAttribute("categoryName", rowData.categoryName);
	 	row.setAttribute("linkmanName", rowData.linkmanName);
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
		OBJ.removeCustomer(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
//					function(obj){return '<a href="javascript:void 0" onClick="editInfo('+ obj.id +')">' + obj.customerName +'</a>'},
					function(obj){return obj.customerName},
					function(obj){return obj.helpCode},
					function(obj){return obj.telephone},
					function(obj){return obj.fax},
					function(obj){return obj.creditAccount},
					function(obj){return obj.ownerAgent},
					function(obj){return obj.customerState},
					function(obj){return obj.category.categoryName},
					function(obj){return obj.linkMan.linkmanName},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editDocument");
////				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delDocument");
////						if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
				
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
				           row.setAttribute("onclick","javascript:editInfo("+ options.rowData.id +"," + options.rowData.customerCategoryId+ ")");
//						   row.onclick = function(){parent.location.href = "editCustomer.html?id="+options.rowData.id+"";};
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    td.style.cssText = "cursor: pointer;";	 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}
/* 总记录数
 * 
 */
Customer.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	CustomerManager.getCustomersCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Customer.prototype.makeSelect = function(obj,name,event){
	CustomerManager.getCustomerSelect(fillFun,obj);
	function fillFun(objs){
		makeSelectHtml(objs,name,event);
	}
}
/* 给树加载信息	
 * 先初始化树对象，再加载数据
 */
Customer.prototype.getTreeXML = function(getxml){
	CustomerManager.getCustomersXML(this.obj,this.IdPrefix,getxml);
}    

Customer.prototype.getCustomerAutoComplet = function(obj,callBackFun){
	CustomerManager.getCustomers(callBackFun,obj);	
}

Customer.prototype.getCustomerAutoComplet2 = function(curUserId,categoryId,callBackFun){
	CustomerManager.getCustomersByUser(callBackFun,curUserId,categoryId,null);	
}

Customer.prototype.getCustomerAutoCompletByName = function(curUserId,categoryId,customerName,callBackFun){
//	CustomerManager.getCustomersByUser(callBackFun,curUserId,categoryId,customerName);
	CustomerManager.getCustomersAllForCommand(callBackFun,curUserId,categoryId,customerName);	
}


Customer.prototype.getCustomerForReg= function(obj,callBackFun){
	CustomerManager.getCustomerForReg(callBackFun,obj);	
}


Customer.prototype.saveCustomerForm = function(o,func){
	CustomerManager.saveCustomerForm(func,o);
}

Customer.prototype.saveCustomerFormReturnObj = function(o,func){
	CustomerManager.saveCustomerFormReturnObj(func,o);
}



Customer.prototype.removeCustomer = function(id,func){
	
	var OBJ = this;	
	
	if (!checkEeitState('Btn_SaveCustomer')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	
	CustomerManager.removeCustomer(func,id);
}
Customer.prototype.getCustomerUserRel = function(customerId,callBack){

	CustomerManager.getCustomerUserRel(getFun,customerId);
	
	function getFun(ids){
		callBack(ids);
	}
}

Customer.prototype.saveCustomerUserRel = function(customerId,userids,callBackFun){

	CustomerManager.saveCustomerUserRel(customerId,userids,saveFun);

	function saveFun(){
		callBackFun();
	}
}
Customer.prototype.saveUserCustomerRel = function(userId,customerIds,callBackFun){

	CustomerManager.saveUserCustomerRel(userId,customerIds,saveFun);

	function saveFun(){
		callBackFun();
	}
}

Customer.prototype.saveCustomerUnify = function(callBackFun){

	CustomerManager.saveCustomerUnify(this.obj,saveFun);

	function saveFun(){
		callBackFun();
	}
}
Customer.prototype.getParentCustomersXML = function(obj,callBackFun){
	
		CustomerManager.getParentCustomersXML(callBackFun,obj);


}
Customer.prototype.makeSelectAnalyze = function(obj,name,event,callBackFun) {

	CustomerManager.getCustomerSelectFromMap(setValueFun,obj);
	
	function setValueFun(objs){
		 makeSelectHtmlAnalyze(objs,name,event);
		 callBackFun();
	}
}

Customer.prototype.makeSelectAnalyzeWidth = function(obj,name,event,width,callBackFun) {

	CustomerManager.getCustomerSelectFromMap(setValueFun,obj);
	
	function setValueFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 callBackFun();
	}
}



//Customer.prototype.makeSelectAnalyze2 = function(obj,name,event,callBackFun) {
//    
//    var select = $(name);
//	CustomerManager.getCustomersAnalyze(setValueFun,obj);
//	function setValueFun(objs){
//		 DWRUtil.removeAllOptions(name);
//		 DWRUtil.addOptions(name, objs);
//		 select.setAttribute("style","width:100px;margin-left:-100px;CURSOR: pointer;");
//		 select.setAttribute("onChange","javascript:"+ event +"(this)");
//		 callBackFun();
//	}
//}

Customer.prototype.getCustomerIdByUserId = function(id,callBackFun){
	CustomerManager.getCustomerIdByUserId(callBackFun,id);	
}

//Customer.prototype.removeCustomerTree = function(id){
//	var OBJ = customer;
//	var obj = customer.obj;
//	var obj_tree = customer.tree.dhtmlTree;
//	var newItemId = customer.tree.newItemId;
//	
//	if(obj_tree.getSelectedItemId()!= newItemId){
//		if(!confirmDelete('Customer')) return false;
//		doDeleteTreeItem(customer,customer.IdPrefix + id);
//		CustomerManager.removeCustomers(id);
//	}	
//	
//	function doDeleteTreeItem(obj,id){
//		obj.tree.removeNodeItems(id);
//	}
//}

Customer.prototype.comboCollapse = function(win,paramsObj){
	 var combo = win.formPannelSearch.form.findField('customerName3')
	 var valueField = combo.valueField;
	 var id = combo.getValue();
	 var store = combo.store;
	 var total =   store.getCount();

	 if(store.getTotalCount()>0){
	 	var rec = store.getById(id);
	 	var value = rec.get('helpCode');
	 	paramsObj.helpCode = value;
//	 	alert(value);
	 }else{
	 	paramsObj.helpCode = null;
	 }
	
}
Customer.prototype.getStoreMap = function(mode,paramObj){
	paramObj = paramObj || {};

	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CustomerManager.getCustomersMapFromOrder}),
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

Customer.prototype.getStoreListCustomerAutoCompletByName = function(mode,paramObj){
	
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CustomerManager.getCustomersAllForCommand}),
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

Customer.prototype.getStoreList = function(mode,paramObj){
//	mode = mode || 'local';
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CustomerManager.getCustomers}),
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
Customer.prototype.comboFilterBy = function(qe){
 var combo = qe.combo;  
// var filterFiled = combo.hiddenName;
 var filterFiled = combo.filterFiled;
 var filterFiled2 = combo.filterFiled2;
 
 var accountName = combo.params.accountName;
 var accountBank = combo.params.accountBank;
 var orgId =  combo.params.orgId;
// var params = combo.params;
 var q = qe.query;  

 var params ={accountName:accountName,accountBank:accountBank,customerName:q,orgId:orgId};

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
//	                     var text = record.get(filterFiled);  
//	                     return (text.indexOf(q)!=-1);  
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
	         }  
	     }else{  
	         combo.selectedIndex = -1;  
	         combo.onLoad();  
	     }  
	 }  
 	return false;  
 	} 
 	
 Customer.prototype.comboFilterBy_bak = function(qe){
 var combo = qe.combo;  
 var filterFiled = combo.hiddenName;
 var accountName = combo.params.accountName;
 var accountBank = combo.params.accountBank;
 var orgId =  combo.params.orgId;
// var params = combo.params;
 var q = qe.query;  

 var params ={accountName:accountName,accountBank:accountBank,customerName:q,orgId:orgId};

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
	                     return (text.indexOf(q)!=-1);  
	                 });  
	             }  
	             combo.onLoad();  
	             
	         }else{  
	         	
	         
	             combo.store.baseParams[combo.queryParam] = q;  
	             combo.store.load({  
//	                 params: combo.getParams(q) 
//					 params:{dwrParams:[{filterFiled:q}]}  
					  params:{dwrParams:[params]}   
	             });  
	             
	             combo.expand();  
	         }  
	     }else{  
//	     	  alert(3333)
	         combo.selectedIndex = -1;  
	         combo.onLoad();  
	     }  
	 }  
 	return false;  
 	} 
 	
 Customer.prototype.comboFilterBy2 = function(qe){
 var combo = qe.combo;  
 var filterFiled = combo.filterFiled;
 var filterFiled2 = combo.filterFiled2;
 var params = combo.params;
 var q = qe.query;  
 var minChars = combo.minChars;

 
//  if(q.length < minChars) return false;
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
	                 	
//	                     var text = record.get(filterFiled);  
//	                     //在这里写自己的过滤代码  
//	                     return (text.indexOf(q)!=-1);  
	                     
	                     
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

	         }  
	     }else{  
	     	
	         combo.selectedIndex = -1;  
	         combo.onLoad();  
	     }  
	 }  
 	return false;  
 	} 
 
 
 
 Customer.prototype.getTree5 =function(id,params,checkBox,orgId,singleExpand){
   var baseAttrs ={};
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}
   var treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: CustomerManager.getTreeForJosin,
		params: params,
		baseAttrs: baseAttrs //添加 uiProvider 属性  
	});
 
	var tree = new Ext.tree.TreePanel({
		 id:id,
	     height :300,
	     width : 200,
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
	      text: '客户信息',
	      allowDrag:false,
	      id: "0",
	      orgId:orgId
	      })

	 });
	 
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


Customer.prototype.getTree =function(id,params,checkBox,renderTo,width,tbar){
	
	var OBJ = this;
	var mode = 'remote';
    var storeCustomer = OBJ.getStoreCustomersAnalyze(mode,OBJ.obj);  
    
   	this.customerCommand = new Ext.ux.form.LovCombo({
			id:'customerName2',
			name: 'customerName2',
			displayField: 'customerName',
//		  tiggerAction:'all',
		  store:storeCustomer,
		   listWidth:300,
		  editable: true,
//		  triggerAction: 'all', //query all
		  lastQuery:'l',
//          typeAhead :true,
		  valueField:'id',
		  mode:mode,
		  allowBlank:false,
		   resizable : true,  
		   anchor : '60%',
		   forceSelection:false, 
//		  forceAll:true,
		  allowBlank:false,
		  emptyText:'请输入客户名...',
		  minChars:2,
		  hiddenName:'helpCode', //提交传过去的值 
		  filterFiled:'customerName',
		  filterFiled2:'helpCode',
		  params:OBJ.obj,
		  listeners:{beforequery:OBJ.comboFilterBy.createDelegate(this)}	
	 });     
      
      
      
//      function callBack(cbo){
//	            var v = cbo.value;
//	            //var node = OBJ.tree.root.findChild('id',v);
//	             var node = OBJ.tree.getNodeById(v);
//	             var type = node.attributes.type;
//	            if(node && type == '2'){
//				    node.ui.toggleCheck(true);      
//				    node.attributes.checked = true;     	
//	            }
//   	     }
//            


      
//      this.customerCommand.on("select",callBack,this);	   	
      
      
   
   this.treeCommandNameTypeReload = function(custType){
   	            if(!custType){
	   	          	 this.customerTypeCommand.setValue(0);
		             this.obj.customerTypeId = null;
   	            }else{
//	   	       	    var v =  this.obj.customerTypeId;
		            if(custType > 0) {
		            	this.obj.customerTypeId = custType;
		            }else{
		            	this.obj.customerTypeId = null;
		            }
   	            }

			 this.customerCommand.clearValue(); 
		     this.customerCommand.store.reload();
		    
		
		    if(this.tree){
			    this.tree.getLoader().params =[{},this.obj];
				this.tree.root.reload(); 
		    }	  
   };
      
      
    this.customerTypeCommand = new Ext.form.ComboBox({
//                                         fieldLabel : '部门',  //UI标签名称
                                         id:'customerTypeCommand',
                                         name : 'customerTypeCommand',   //作为form提交时传送的参数名
//                                         allowBlank : false,  //是否允许为空
                                         mode : 'local',      //数据模式, local为本地模式, 如果不设置,就显示不停的加载中...
//                                         readOnly : true,     //是否只读  变成文本框
                                         triggerAction : 'all',  //显示所有下列数.必须指定为'all'
//                                        anchor : '30%',
                                         width:100,
                                         emptyText:'请选择...',  //没有默认值时,显示的字符串
                                         store : new Ext.data.SimpleStore({  //填充的数据
                                                           fields : ['text', 'value'],
                                                           data : [['所有', '0'],['省内', '1'], ['省外', '2']]
                                         }),
//                                         value:'0',  //设置当前选中的值, 也可用作初始化时的默认值, 默认为空  
                                         valueField : 'value',      //传送的值
                                         displayField : 'text',     //UI列表显示的文本
//                                         regex : /[\u4e00-\u9fa5]/,   //只能输入中文. 正则表达式验证:详见: http://www.blogjava.net/algz/articles/263284.html
//                                         regexText : "只能输入中文!",       //使用正则表达式时,设置的错误提示
                                          editable: false
  });      
      
      
      function customerTypeCallBack(cbo){
//	            this.obj.customerTypeId = cbo.value;
                this.treeCommandNameTypeReload(cbo.value);
   	     };
            
      this.customerTypeCommand.on("select",customerTypeCallBack,this);	 

	
	
	
   var baseAttrs ={};
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}
   this.treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: CustomerManager.getTreeForJosin,
		params: params,
		baseAttrs: baseAttrs //添加 uiProvider 属性  
	});
	
	
	var root = new Ext.tree.AsyncTreeNode({
	      text: '客户信息',
	      allowDrag:false,
	      id: "0",
	      uiProvider: Ext.tree.TreeCheckNodeUI,
	      expanded:true
	      });
	      
	      
//	var tools = {
//id:'refresh',
//qtip: 'Refresh form Data',
//// hidden:true,
//handler: function(event, toolEl, panel){
//	alert(1);
//// refresh logic
//}
//};
	      




	var tree = new Ext.tree.TreePanel({
		 id:id,
	     height :500,
	     border:true,
	     rootVisible:true,
	     autoScroll:true,
	     renderTo:renderTo,
	      singleExpand:true,
	     width:width,
	     autoWidth:false,
//	     enableDrop:true,
        tbar:[this.customerCommand,this.customerTypeCommand],
//        bbar: ['名称：',{xtype:'trigger',id: 'searchName',width:200,triggerClass:'x-form-search-trigger',onTriggerClick:OBJ.search}],

//       	 bbar:[bbar],
//       tools:[tools],
//		 enableDD:true,
	     loader: this.treeload, //使用第2步中创建树的加载器
	     checkModel: 'cascade',
	     root:root
//	     listeners:{
//                click:gg.createDelegate(this),
//                beforeload:reload.createDelegate(this)
//         }

	 });
	 
     //节点排序  
//     new Ext.tree.TreeSorter(tree, {  
//         folderSort: true,  
//         property: "id",  
//         dir: "asc"  
//     });  

//#   //节点编辑  
//#     new Ext.tree.TreeEditor(tree);  
	
//	 var tb = tree.getTopToolbar(); 

	 

	 
     tree.on('beforeload', function(){this.body.mask('数据加载中……', 'x-mask-loading');});   
     tree.on('load', function(node){this.body.unmask();}); 
     
//     tree.on('treeselected',onTreeSelected,this.customerCommand);  
//     
//     function onTreeSelected(node){
//      		
//      		alert(node)
//     }
     
     tree.getAllCheckedIds = function(fiterType){
 
 			var checkedNodes = this.getChecked();

                    	var ids = [];
			            for(var i=0;i<checkedNodes.length;i++){    
			               var node = checkedNodes[i];    
			               var type = node.attributes.type;

			               
			               if(node.id !='0' && type == fiterType){
			               		ids.push(node.id);
			               }
			            }    
			            
//			  var cmdValue = OBJ.customerCommand.getValue();     
//			  var cmdName = OBJ.customerCommand.getRawValue();         
//			  if(cmdValue > 0 && cmdValue != cmdName &&  !ids.contains(cmdValue)) ids.push(cmdValue);  

            
			  var cmdValues = OBJ.customerCommand.getCheckedValue().split(",");    
			  for(var i = 0 ;i<cmdValues.length;i++){
			  	 if(!ids.contains(cmdValues[i]) && cmdValues[i]>0) ids.push(cmdValues[i]); 
			  }
			 
			   
     	    return ids;
     }
     
     
     


   return tree;
};
 	
 	
Customer.prototype.search =   function(){
				var searchName = Ext.getDom('searchName').value;
				alert("查询字符串："+searchName);
}
   
 
   
    
	
   
Customer.prototype.getCustomerCmdTree = function (orgId,paras,cmdId,treeId,allowUnLeafClick,renderTo,filterFiled,emptyText,width,checkBox,singleExpand,onSelected,callFunction){
	         var OBJ = this;
//	     	 OBJ.obj.parentId = 0;
//	     	 var params = [{}]; //tree dataIn。;
//	     	 var tree = OBJ.getTree(treeId,params,checkBox,orgId,singleExpand);
	     	 
	  		var par2;
		    if(paras instanceof Array){
		    	paras[1].orgId = orgId;
		    	par2 = [{},paras[1]];
		    	
		    }	
        	
    
            var tree =  OBJ.getTree5(treeId,par2,checkBox,null,singleExpand,{});     	 

	     	if(!OBJ.treecombo){
				var conf = {
					       id: cmdId,
					       fieldLabel : '客户名称',
			               width : width,
			               listWidth : 400,
			               lastQuery:'-l',
			               passName : 'id',
			               autoScroll:true,
			               treeHeight:300,
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
               	var nodeType = node.attributes.type;
           
//               	if(nodeType <3) return false;

//                if(nodeType ==1 && !node.expanded){
//                	 this.expand();
//                }
//                
//                if(nodeType ==1){
//                	 var checked = node.getUI().isChecked();
//                	 node.getUI().toggleCheck(!checked);
//                }
                
              
               	name = node.text;  	
               	
//               	node.attributes.checked = true;   
//				node.getUI().toggleCheck(!node.attributes.checked);
				node.getUI().toggleCheck(true);
               
                OBJ.treecombo.passField.value = node.id;
                OBJ.treecombo.setValue(name);  	
                OBJ.treecombo.nodeType = nodeType;
                
                
//                var search =  OBJ.treecombo.lastQuery !== node.id;
//				if(search){ 
//					eval("params."+ filterFiled +" =node.id");  
//					OBJ.treecombo.lastQuery = node.id;
//					OBJ.treecombo.callFunction(params);
//				}
	     	
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
   
		  
 Customer.prototype.showWin = function(name,paramObj,loginUser,checkBox,funct){
    var OBJ = this;
    var win;
    var button = Ext.get(name);

    button.on('click', function(){
        // create the window on the first click and reuse on subsequent clicks
        if(!OBJ.winCustomer){
        	
            var par2;
		    if(paramObj instanceof Array){
		    	paramObj[1].orgId = OBJ.obj.orgId;
		    	par2 = [{},paramObj[1]];
		    	
		    }	
        	
    
           OBJ.tree = OBJ.getTree('customerTree',par2,checkBox,null,'',{});
            
            var btnReload = {
                    text:'重置',
                    disabled:false,
                     handler: function(){
                        //tree.root.reload(); 
	                OBJ.tree.root.eachChild(function(child) {      
			             child.ui.toggleCheck(false);      
			             child.attributes.checked = false;            
			         });      
                    }
                };          


            OBJ.winCustomer = new Ext.Window({
//                applyTo     : 'hello-win',
                id          :'winCustomer',
                layout      : 'fit',
                modal : true,
                resizable : false,
                width       : 500,
                height      : 300,
                closable:false,
//                closeAction :'hide',
                plain       : true,
//                tbar        :['-','查找客户',OBJ.customerCommand,'-'],
                items       : OBJ.tree,

                buttons: [btnReload,{
                    text     : '确定',
                    handler  : function(){
                    	removeWin();
                    }
                }
                ]
            });
        }
        OBJ.winCustomer.show(button);
        
     function removeWin(){
			var checkedNodes = OBJ.tree.getChecked();
			
			
                    	var ids = [];
			            for(var i=0;i<checkedNodes.length;i++){    
			               var node = checkedNodes[i];    
			               var level = node.attributes.level;
			               if(node.id !='0' && level == '2'){
			               		ids.push(node.id);
			               }
			            }
			            
			            
//					  var cmdValue = OBJ.customerCommand.getValue();     
//					  var cmdName = OBJ.customerCommand.getRawValue();          
//					  if(cmdValue > 0 && cmdValue != cmdName &&  !ids.contains(cmdValue)) ids.push(cmdValue); 			            
					  var cmdValues = OBJ.customerCommand.getCheckedValue().split(",");    
					  for(var i = 0 ;i<cmdValues.length;i++){
					  	 if(!ids.contains(cmdValues[i]) && cmdValues[i]>0) ids.push(cmdValues[i]); 
					  }  
			            
			                
                    	if(funct) funct(ids);
                        OBJ.winCustomer.hide();
   	} 
   	
        OBJ.winCustomer.on({'close': {fn: removeWin}});   
    });
				
 	
 }	
 

 Customer.prototype.buildCommand = function(elid,renderTo,model,paramObj){
 		var storeCustomer = this.getStoreListCustomerAutoCompletByName(model,paramObj);  
	 	var customerCommand = new Ext.form.ComboBox({
	 	  id:paramObj.elid,
	 	  name:elid,
		  renderTo:renderTo,
		  tiggerAction:'all',
		  store:storeCustomer,
		  editable: true,
		  triggerAction: 'all', //query all
		  lastQuery:'1',
		  displayField:'customerName',
		  valueField:'id',
		  mode:model,
		  allowBlank:false,
		   width:138,
		   listWidth:300,
		   forceSelection:false, 
		  allowBlank:false,
		  emptyText:'请选择...',
		  minChars:2,
		  hiddenName:'helpCode', //提交传过去的值 
		  filterFiled2:'helpCode',
		  filterFiled:'customerName',
		  params:paramObj,
		  listeners:{beforequery:this.comboFilterBy.createDelegate(this)}	
	 });
	 
	 return customerCommand;
 }
 
Customer.prototype.getStoreCustomersAnalyze = function(mode,paramObj){
	paramObj = paramObj || {};
	var fileds= this.fileds;

	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CustomerManager.getCustomersAnalyze}),
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

Customer.prototype.getComboboxTree =  function(mode,cmdId,treeId,params,checkBox,renderTo,width){
	params = [{},params];
	this.tree =  this.getTree(treeId,params,checkBox,null,width);
	

		
	var OBJ = this;
	
	 new ComboBoxTree({
           id: cmdId,
           treeHeight:360,
//           hiddenName:'dept_no',
           fieldLabel:'机构',
           renderTo:renderTo,
           width: 160,
           tree: OBJ.tree/*,
            onSelect: function(cmb, node) {
                alert(node.attributes.text);
            }*/
       });
       
   
       
       
       
       
       
       
}



Customer.prototype.getComboboxTree2 =  function(mode,cmdId,treeId,params,checkBox,renderTo,width){

//	var tree =  this.getTree2(treeId,params,checkBox,renderTo,width);
	var tree2 =  this.getTree2('treeId2',params,checkBox,renderTo,width,this.obj.orgId);

	

   this.comboxWithPanel = new Ext.form.ComboBox({   
	   	id:cmdId,
	    store:new Ext.data.SimpleStore({fields:[],data:[[]]}),   
	    renderTo:renderTo,
	    editable:false,   
	    mode: 'local',   
	    triggerAction:'all',   
	    maxHeight: 200,   
	    tpl: '<div style="height:200px"><div id="customer_tree_panel"></div></div>',   
	    selectedClass:'',   
	    onSelect:Ext.emptyFn   
   });   
   
   this.customerTreeFormPanel = new Ext.Panel({ 
	    title:'面板title',   
	    layout:'fit',   
	    height :500,
	     width :500,
	    items: [tree2]   
    });   
    
    var OBJ = this;
    
    

    
    
      this.comboxWithPanel .on('expand',function(){   
      if(!OBJ.customerTreeFormPanel.rendered)
	      
	      var queryWindow = new QueryWindow({  
	            title : '添加',  
	            dataurl : 'new.action'  
	     });  
	
	     queryWindow.show();     
      
      
  	  	 queryWindow.render('customer_tree_panel');   
  	  });       
         
    
    
    
    
//    this.comboxWithPanel .on('expand',function(){   
//      if(!OBJ.customerTreeFormPanel.rendered)
//  	  	 OBJ.customerTreeFormPanel.render('customer_tree_panel');   
//    });       
//       



//
//var turnckForm = new Ext.form.FormPanel({
//		title: '查询条件',
//		labelAlign: 'right',
//		labelWidth: 90,
//		frame: true,
//		renderTo: renderTo,
//		bodyStyle: 'padding: 0 0 0 0;',
//		style: 'padding:0 0 0 0;',
//		width: '100%',
//		heigth: 300,
//		buttonAlign : "center",
//		items: [
//			{
//				layout:'column',
//				items:[
//					{
//						columnWidth:.5,
//		                layout: 'form',
//		                items:
//		                [{xtype:'hidden',name:'testa',id:'testa',value:'ddd'},
//						new Ext.ux.form.ComboBoxTree({
//		            		name:'usertype',
//		                    hiddenName:'usertype',
//		                    fieldLabel:'地理位置',
//		                    tree:  tree,
//		                  })
//		                  ]
//					},
//					{
//						columnWidth:.5,
//		                layout: 'form',
//		                items:[{
//			                xtype: 'combo',
//			                typeAhead: true,
//			                triggerAction: 'all',
//			                lazyRender:true,
//			                mode: 'local',
//			                store: new Ext.data.ArrayStore({
//			                    id: 0,
//			                    fields: [
//			                        'myId',
//			                        'displayText'
//			                    ],
//			                    data: [[1, 'item1'], [2, 'item2']]
//			                }),
//			                valueField: 'myId',
//			                displayField: 'displayText',
//			                listeners:{
//			                  	'focus' : function(fld){
//		                	alert(turnckForm.findById('testa').getValue());
//			                  	
//			                  }  
//			                }
//		                
//						}]
//					}
//					]
//			}
//			]
//	});	    		

        
   
//普通的面板

   
   

   
   
   
   
   
   
   
   
   
   
   
   
   
        
        
        
}

Customer.prototype.getTree2 =  function(mode,cmdId,treeId,params,checkBox,renderTo,width,orgId){
	
	params = [{},{orgId:orgId}];
	

	var OBJ = this;
	

   var baseAttrs ={};
   
   if(checkBox){baseAttrs ={uiProvider: Ext.tree.TreeCheckNodeUI};}

   this.treeload = new Ext.tree.DWRTreeLoader({
		dwrMethod: CustomerManager.getTreeForJosin,
		params: params,
		baseAttrs: baseAttrs //添加 uiProvider 属性  
	});

	
	var root = new Ext.tree.AsyncTreeNode({
	      text: '客户信息',
	      allowDrag:false,
	      id: "0",
	      uiProvider: Ext.tree.TreeCheckNodeUI,
	      expanded:true
	      });
	      


	var tree = new Ext.tree.TreePanel({
		 id:treeId,
	     border:true,
	     rootVisible:true,
	     autoScroll:true,
//	     renderTo:renderTo,
//	      singleExpand:true,
	       lazyRender:true,
//	      onlyLeafCheckable: true,
	     width:width,
	     autoWidth:false,
//         bbar: ['名称：',{xtype:'trigger',id: 'searchName',width:200,triggerClass:'x-form-search-trigger',onTriggerClick:OBJ.search}],
	     loader: this.treeload, //使用第2步中创建树的加载器
	     checkModel: 'cascade',
	     root:root


	 });
	 

//     tree.on('beforeload', function(){this.body.mask('数据加载中……', 'x-mask-loading');});   
//     tree.on('load', function(node){this.body.unmask();}); 
     
//     tree.on('checkchange', function(node, checked) {      
//         node.expand();      
//         node.attributes.checked = checked;      
//         node.eachChild(function(child) {      
//             child.ui.toggleCheck(checked);      
//             child.attributes.checked = checked;      
//             child.fireEvent('checkchange', child, checked);      
//         });      
//     }, tree);         
     
     
     
//     tree.on("contextmenu",function(node,e)
//        {
//            var treeMenu = new Ext.menu.Menu
//            ([
//                {xtype:"button",text:"打开",icon:"images/plugin.gif",pressed:true},
//                {xtype:"button",text:"添加",icon:"images/plugin.gif",pressed:true},
//                {xtype:"button",text:"编辑",icon:"images/plugin.gif",pressed:true},
//                {xtype:"button",text:"隐藏",icon:"images/plugin.gif",pressed:true},
//                {xtype:"button",text:"删除",icon:"images/plugin.gif",pressed:true}
//                          
//            ]);
//            treeMenu.showAt(e.getPoint());
//        });        
     
     
     
//        tree.on("check",function(node,checked){alert(node.text+" = "+checked)}); 

     
     return tree;
  
};


 	


		
 Customer.prototype.getCustStOreFromOrder = function(mode,paramObj){
	paramObj = [paramObj || {}];
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: CustomerManager.getCustFromOrder}),
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

Customer.prototype.getCustomerFromOrder =  function(rederId,elname,width,callBackFun){
	  var OBJ = this;
  	  var paramObj = this.obj;
      var storeUser = OBJ.getCustStOreFromOrder('remote',paramObj);

      var cmd = new Ext.form.ClearableComboBox({
        store: storeUser,
        id:elname,
        name:elname,
        width:width,
        listWidth:300,
        displayField:'customerName',
         valueField:'id',
        typeAhead: true,
        editable: true,
        mode: 'remote',
        forceSelection: true,
        triggerAction: 'all',
        fieldLabel: '客户名称',
        emptyText:'请选择...',
        selectOnFocus:true,
        forceAll:true,
        minChars:2,
        filterFiled:'helpCode',
        params:paramObj,
        renderTo:rederId,
//        params:paramObj,
		filterFiled2:'customerName',
		listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
    });
    
    return cmd;
    
};


Customer.prototype.getCustomerRemote =  function(rederId,elname,width,callBackFun){
	  var OBJ = this;
  	  var paramObj = this.obj;
  	  
  	  paramObj = paramObj || {};

  	   var fileds = this.fileds;
  	   
	   var store = new Ext.data.Store({
			proxy: new Ext.data.DWRHttpProxy({url: CustomerManager.getCustomerRemote}),
			reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
		});
		
		store.on('beforeload', function(){
	    	Ext.apply(this.baseParams, {dwrParams:paramObj});
		}); 
		
		
		var conf = {
        store: store,
        id:elname,
        name:elname,
        width:width,
        listWidth:300,
        displayField:'customerName',
         valueField:'id',
         lastQuery:'l',
//        typeAhead: true,
        mode: 'remote',
        editable: true,
        forceSelection: false,
//        allowBlank:false,
//        triggerAction: 'all',
        fieldLabel: '客户名称',
        emptyText:'请选择客户...',
        selectOnFocus:true,
//        forceAll:true,
        minChars:2,
//        renderTo:rederId,
        params:paramObj,
    	filterFiled:'customerName',
    	filterFiled2:'helpCode',
		listeners:{beforequery:OBJ.comboFilterBy2.createDelegate(this)}	
     };
     
	if(rederId) conf.renderTo = rederId;

	var cmd = new Ext.form.ClearableComboBox(conf);

	if(callBackFun){
		cmd.store.on('load', function(){callBackFun();}); 
     }
    
    return cmd;
    
};


Customer.prototype.getCustomerCmdTemple1 =  function(rederId,elname,width,callBackFun){
	   //模板
 		var tpl2=new Ext.XTemplate(
             '<table border=0 cellpadding=0 cellspacing=0 width= 100%><tbody>',
            '<tpl for=".">',
              
               '<tr ><td class="x-combo-list-item {[xindex % 2 == 0 ? "even" : "odd"]}"><div style="overflow:hidden;height:20px;width:220px;line-height:20px;"> {customerName}</div> </td><td><div style="overflow:hidden;height:20px;width:80px;line-height:20px;">{categoryName}</div></td><tr></div>',
//                '<tr ><td class="x-combo-list-item {[xindex % 2 == 0 ? "even" : "odd"]}">{[this.check(values)]}</td><td>{[this.check2(values)]}</td><tr></div>',
   
            '</tpl></tbody></table>',
            {
                check : function (values) {
                    if(values.customerCategoryId == 2 ){
                        return "<font color=black>"+values.customerName+"</font>";
                    }else if(values.customerCategoryId == 3){
                        return "<font color=blue>"+values.customerName+"</font>";
                    }else {
                        return "<font color=green>"+values.customerName+"</font>";
                    }
                },
                  check2 : function (values) {
                    if(values.customerCategoryId == 2 ){
                        return "<font color=black>"+values.categoryName+"</font>";
                    }else if(values.customerCategoryId == 3){
                        return "<font color=blue>"+values.categoryName+"</font>";
                    }else {
                        return "<font color=green>"+values.categoryName+"</font>";
                    }
                }
            }
            );	
            
        return tpl2;    
};


Customer.prototype.initCustomerCmd =  function(params,id,renderTo,mode,hiddenName,filterFiled,minChars,width,listWidth,emptyText,callFunction){
        var OBJ = this;

    	var store = OBJ.getStoreCustomersAnalyze(mode,OBJ.obj);   
//	   //模板
        var tpl2= OBJ.getCustomerCmdTemple1();

        var conf = {
		 	  id:id,
		 	  name:id,
			  tiggerAction:'all',
			  listWidth:listWidth,
			  store:store,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'-1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:true,
			   width:width,
			  allowBlank:false,
			  lazyRender: false,
			  forceAll: true,
			  emptyText:emptyText,
			  minChars:minChars,
			  params:params,
			  tpl:tpl2,
			  listeners:{beforequery:OBJ.comboFilterBy3.createDelegate(this)}
		 };
		 
		if(renderTo) conf.renderTo = renderTo;
		if(hiddenName) conf.hiddenName = hiddenName;
		if(filterFiled) conf.filterFiled = filterFiled;
		if(callFunction) conf.callFunction = callFunction;

		var cmd = new Ext.form.ClearableComboBox(conf);
	 
		 function func(){
		 	 var filterFiled = cmd.filterFiled;
		 	 var params = cmd.params;
		 	 eval("params."+ filterFiled +" =null");
		 	 cmd.lastQuery = -1;  
		 	 cmd.callFunction(params);
		 }
		 

		function func2(){
	 	 var filterFiled = cmd.filterFiled;
	 	 var params = cmd.params;
	 	 var value = cmd.getRawValue();
	 	 eval("params."+ filterFiled +" =value");
	 	 cmd.callFunction(params);
	 	}	 
		 
	
	     cmd.on("clear",func,this);	 
	     
	     cmd.on("select",func2,this);	 
	     
   
	     	 
	    return cmd;
};



Customer.prototype.comboFilterBy3 = function(qe){
 var combo = qe.combo;  
 var filterFiled = combo.filterFiled;
 var filterFiled2 = combo.filterFiled2;
 var params = combo.params;
 var q = qe.query;  
 var minChars = combo.minChars;

 
//  if(q.length < minChars) return false;
  eval("params."+ filterFiled +" =q");

 var forceAll = qe.forceAll;  
 
  var search = q.length >= combo.minChars && combo.lastQuery !== q;
  

  
 
	 if(forceAll === true || (q.length >= combo.minChars)){  
	     if(combo.lastQuery !== q){  
	         combo.lastQuery = q;  

	         if(combo.mode == 'local'){  
	             combo.selectedIndex = -1;  
	             if(forceAll){  
	                 combo.store.clearFilter();  
	             }else{  
	                 combo.store.filterBy(function(record,id){  
	                 	
//	                     var text = record.get(filterFiled);  
//	                     //在这里写自己的过滤代码  
//	                     return (text.indexOf(q)!=-1);  
	                     
	                     
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
		         
					if(forceAll === true || search){  
					         combo.lastQuery = q;  
					         combo.callFunction(params);
					 } 

	         }  
	     }else{  
	     	
	         combo.selectedIndex = -1;  
	         combo.onLoad();  
	     }  
	 }  
 	return false;  
 	} 
 	
 	
 Customer.prototype.get_custumer_for_order = function(mode,width,listWidth,orgId,id,renderId,emptyText){
 
//		var customerName = "";
//		var categoryId = 0;
//        var mode = 'remote';
		var that =  this;
        that.obj.orgId = orgId;
    	var storeCustomer = this.getStoreCustomersAnalyze(mode,that.obj);   
    	
	   if(!that.customerCommand){
//	   //模板
        var tpl2= this.getCustomerCmdTemple1();
        
        var conf = {
		 	  id:id,
		 	  name:id,
//			  renderTo:renderId,
			  tiggerAction:'all',
			  listWidth:listWidth,
			  store:storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			   width:width,
//			   typeAhead: true,
//			   forceSelection:false, 
			  allowBlank:false,
			  lazyRender: false,
			  forceAll: true,
			  emptyText:emptyText,
			  minChars:2,
			  hiddenName:'customerCategoryId', //提交传过去的值 
			  filterFiled:'customerName',
			  filterFiled2:'helpCode',
			  params:that.obj,
			  tpl:tpl2,
			  listeners:{
			  	beforequery:that.comboFilterBy2.createDelegate(this)}
		 };
         
        if(renderId) conf.renderTo = renderId;
		that.customerCommand = new Ext.form.ClearableComboBox(conf);
	   }
	   
	   return that.customerCommand;
 	}
 
    Customer.prototype.get_custumer_for_order2 = function(mode,width,listWidth,id,renderId,emptyText,xtype){

		var that =  this;
    	var storeCustomer = this.getStoreCustomersAnalyze(mode,that.obj);   

        var tpl2= this.getCustomerCmdTemple1();
        
        var conf = {
		 	  id:id,
		 	  name:id,
			  tiggerAction:'all',
			  listWidth:listWidth,
			  store:storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			   width:width,
			  allowBlank:false,
			  lazyRender: false,
			  forceAll: true,
			  emptyText:emptyText,
			  minChars:2,
			  hiddenName:'customerCategoryId', //提交传过去的值 
			  filterFiled:'customerName',
			  filterFiled2:'helpCode',
			  params:that.obj,
			  tpl:tpl2,
			  listeners:{
			  	beforequery:that.comboFilterBy2.createDelegate(this)}
		 };
         
        if(renderId) conf.renderTo = renderId;
  
	    if(xtype){
	    	conf.xtype = 'clearableComboBox';
	    	return conf;
	    }else{
		    var comboBox =   new Ext.form.ClearableComboBox(conf);
		    return comboBox
	    } 
 	}
    