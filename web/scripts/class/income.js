
function Income(){

	this.obj = {
		resourceCarrierId:null,
		incomeCode:null,
		incomeDate:null,
		customerId:null,
		incomeMoney:null,
		incomeModeId:null,
		incomeUsed:null,
		balanceMoney:null,
		incomePurposeId:null,
		id:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    incomePullDate:null,
	    userId:null,
	    
	    user:null,
	    incomeMode:null,
	    incomePurpose:null,
	    customer:null,
		carrier:null,
		incomePull:null,
	    state:null,
	    memo:null
	}
	this.startDate = null;
	this.endDate =null;
	
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
	this.radioTarg = null;
	this.radioName = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
		this.fileds =
	[
			{name: "id", type: "int"},
			{name: "incomeCode", type: "string"},
			{name: "customerId", type: "string"},
			{name: "customer.customerName", type: "string"}
			
	];
	
	return this;	
}	

//清空对象
Income.prototype.reset = function(){
	this.obj.incomeCode = null;
  	this.obj.incomeDate = null;
  	this.obj.customerId = null;
  	this.obj.incomeMoney = null;
  	this.obj.incomeUsed = null;
  	this.obj.balanceMoney = null;
  	this.obj.incomeModeId = null;
  	this.obj.incomePurposeId = null;
  	
  	this.obj.id = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	this.obj.userId = null;
  	this.obj.user = null;
  	this.obj.incomeMode = null;
  	this.obj.incomePurpose = null;
  	this.obj.carrier = null;
  	this.obj.incomePull = null;
  	this.obj.customer = null;
  	this.obj.state = null;
  	this.obj.memo = null;
  	this.obj.incomePullDate = null;
  	this.obj.resourceCarrierId = null;
}
Income.prototype.setObject = function(sourObj){
	this.obj.id = sourObj.id;
	this.obj.customerId = sourObj.customerId;
	this.obj.incomeCode = sourObj.incomeCode;
  	this.obj.incomeDate = sourObj.incomeDate;
	this.obj.incomePullDate = sourObj.incomePullDate;	
  	this.obj.incomeMoney = sourObj.incomeMoney;
  	this.obj.incomeUsed = sourObj.incomeUsed;
  	this.obj.balanceMoney = sourObj.balanceMoney;
  	this.obj.incomeModeId = sourObj.incomeModeId;
  	this.obj.incomePurposeId = sourObj.incomePurposeId;
	this.obj.memo = sourObj.memo;
	
	this.obj.incomeMode = sourObj.incomeMode;
  	this.obj.incomePurpose = sourObj.incomePurpose;
  	this.obj.carrier = sourObj.carrier;
  	this.obj.customer = sourObj.customer;
  	this.obj.userId = sourObj.userId;
  	this.obj.user = sourObj.user;
  	
  	this.obj.createBy = sourObj.createBy;
  	this.obj.createDate = sourObj.createDate;
  	this.obj.modifyBy = sourObj.modifyBy;
  	this.obj.modifyDate = sourObj.modifyDate;
  	this.obj.version = sourObj.version;
  	this.obj.state = sourObj.state;
}
	
	
Income.prototype.getIncome = function(setValueFun,id){
//	var OBJ = this;
//	var obj = OBJ.obj;
//	
//	this.reset();
//	DWRUtil.setValues(this.obj);
	
	IncomeManager.getIncome(id,setValueFun);
		
//	function setValueFun(o){
//		DWRUtil.setValues(o);
//		obj = o;
//	}
//	
//	return obj;
	
}

Income.prototype.getIncome5 = function(id,setValueFun){
	IncomeManager.getIncome5(id,setValueFun);
}
Income.prototype.getIncomeByCode = function(setValueFun,id){
	IncomeManager.getIncome2(setValueFun,id);
}

Income.prototype.getIncomeByCodeAuto = function(setValueFun,orgId,year,id){
	IncomeManager.getIncomeByCodeAuto(setValueFun,orgId,year,id);
}


Income.prototype.getPutOnInfos = function(O,userId,carrierName,channelModelParam){
	var OBJ    = O;
	var obj    = OBJ.obj;
	var page   = OBJ.page;
//	var tBody  = OBJ.tBody;
//	var color1 = OBJ.color1;
//	var color2 = OBJ.color2;
	
    if (page.pageSize > 0){
		var size = this.getPutOnInfosCount(OBJ.startDate,OBJ.endDate,userId,carrierName,channelModelParam);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		IncomeManager.getPutOnInfos(fillTalbeIncome,O.startDate,O.endDate,userId,carrierName,channelModelParam);
    }else{
//		IncomeManager.getIncomes(OBJ.fillTalbeIncome,obj);	
    } 
}

function fillTalbeIncome(objs){
//	var tBody  = income.tBody;
	var tBody  = $("orderdayinfoBody");
	var color1 = "BACKGROUND-COLOR: #f5f5f5";
	var color2 = "BACKGROUND-COLOR: #ECEFF4";
//	alert("ddd"+objs.length);
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
//		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
//		 	row.setAttribute("paraId", rowData.id);
//		 	row.setAttribute("payNumber", rowData.payNumber);
//		 	row.setAttribute("payDate", rowData.payDate);
//		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
//		 	row.setAttribute("moneyPay", rowData.moneyPay);
//		 	row.setAttribute("moneyIn", rowData.moneyIn);
			row.setAttribute("rowData", rowData);
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			
			var e = event || window.event;
			var editImg = Event.element(e); 
			var tr1= editImg.parentNode.parentNode;
			var id = tr1.getAttribute("paraId");
			
//			var incomePurposeId = tr1.getAttribute("incomePurposeId");
			
			var editRow = $(OBJ.IdPrefix + id);
			
			OBJ.addNewRow("edit",editRow);
		}
		//删除图标的触发的事件
		function del(event){
			var e = event || window.event;
			var deleImg = Event.element(e);
			var id = deleImg.getAttribute("paraId"); 
			var delRow = deleImg.parentNode.parentNode;
			OBJ.removePayMent(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[						
						function(obj){return obj.memo},

						function(obj){return obj.month[1]},
						function(obj){return obj.month[2]},
						function(obj){return obj.month[3]},
						function(obj){return obj.month[4]},
						
						function(obj){return obj.month[5]},
						function(obj){return obj.month[6]},	
						function(obj){return obj.month[7]},
						function(obj){return obj.month[8]},
						
						function(obj){return obj.month[9]},
						function(obj){return obj.month[10]},
						function(obj){return obj.month[11]},
						function(obj){return obj.month[12]},
						function(obj){return obj.month[13]},	

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
//	    this.getDate();
    }

Income.prototype.getPutOnInfosCount = function(startDate,endDate,userId,carrierName,channelModelParam){
	var count;
	DWREngine.setAsync(false);
	IncomeManager.getPutOnInfosCount(getCountFun,startDate,endDate,userId,carrierName,channelModelParam);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Income.prototype.getIncomes = function(o){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = this.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		IncomeManager.getIncomesPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
    }else{
		IncomeManager.getIncomes(OBJ.fillTalbe,obj);	
    } 
}

Income.prototype.CheckIncomeForIncomeCode = function(o,callback){
		DWREngine.setAsync(false);
		IncomeManager.getIncomes(callback,o);
		DWREngine.setAsync(true);
 
}
Income.prototype.getCountByIdList = function(obj,state){
	var count;
	DWREngine.setAsync(false);
	IncomeManager.getIncomeCountByIdList(getCountFun,obj,state);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
Income.prototype.getIncomesByIdList = function(OBJ,state){
	IncomeManager.getIncomesPageByIdList(OBJ.fillTalbe,OBJ.obj);
}
Income.prototype.getIncomesByCustomerId = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page = OBJ.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);

		IncomeManager.getIncomesPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		IncomeManager.getIncomes(func,obj);	
    } 
}




Income.prototype.fillTalbe = function(objs){
	var OBJ = income;
	var obj = OBJ.obj;
	var tBody  = income.tBody;
	var color1 = income.color1;
	var color2 = income.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("incomeDate", rowData.income.incomeDate);
	 	row.setAttribute("incomeCode", rowData.income.incomeCode);
	 	row.setAttribute("incomeMoney", rowData.income.incomeMoney);
	 	row.setAttribute("customerId", rowData.income.customer.customerId);
	 	row.rowData = rowData;
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
					function(obj){var incomeIdPullIdCarrierId =obj.id+","+obj.income.id+"&"+obj.carrier.id;  return makeInputText(OBJ.radioName,"radio",incomeIdPullIdCarrierId,getTable)},
					function(obj){ 
						var incomeDate = obj.income.incomeDate==null?"":getFormatDay(obj.income.incomeDate+"",'y/m/d');
						return incomeDate;
						},
					function(obj){ return obj.carrier.carrierName},
					function(obj){ return obj.income.incomeCode},
					function(obj){ return obj.moneyPull},
					function(obj){ 
//						if(obj.incomeUsed == obj.incomeMoney){
//							return 0;
//						}else{
							return obj.moneyPull-obj.income.incomeUsed
//						}
					},
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
	//再重新构新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) { 
						   var row = document.createElement("tr"); 
				           putRowDataInHidden(row,options.rowData);
				           var rowIndex = options.rowIndex;
				           row.setAttribute("onclick","javascript:drawColorOrderTable("+ rowIndex +")");
						   return row;  
					  },  
					  
				cellCreator:function(options) {
						    var td = document.createElement("td"); 
						    td.style.cssText = "cursor:pointer;";
						    td.onclick = selectRow;
						    return td;  
					  }  
				});
				
	function selectRow(ev){
		getElementByEvent(ev).parentNode.firstChild.firstChild.checked = true;
		getTable();
	}			
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}
Income.prototype.fillTalbeByCusId = function(objs){
	var OBJ = income;
	var obj = OBJ.obj;
	var tBody  = income.tBody;
	var color1 = income.color1;
	var color2 = income.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("incomeDate", rowData.incomeDate);
	 	row.setAttribute("incomeCode", rowData.incomeCode);
	 	row.setAttribute("incomeMoney", rowData.incomeMoney);
	 	row.setAttribute("incomeModeId", rowData.incomeModeId);
	 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
	 	row.setAttribute("memo", rowData.memo);
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
//	alert(1);
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){ return "<a href='editIncome.html?id=" +obj.id +"'>" + obj.incomeDate +"</a>"},
					function(obj){ return obj.incomeCode},
					function(obj){ return obj.incomeMoney},
					function(obj){ return obj.incomeMode.name},
					function(obj){ return obj.incomePurpose.name},
//					function(obj){ return ""},
					function(obj){ return obj.memo},
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
	//再重新构新的表
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
Income.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	IncomeManager.getIncomeCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

/* 添加新行 编辑或删除 
 * 
 */
Income.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
    var obj = this.obj;
	var page = this.page;
	var tBody = this.tBody;

	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.name = editRow.getAttribute("name");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");

		DWRUtil.getValues(obj);

		OBJ.saveOrderCategory(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getOrderCategorys()
	}	 	
	 
	//从编辑行中获得数据，来添对象
	if(mode =='edit'){ 
		getRowDataInObj(editRow);
	}


	//////////////////构造新行 start //////////////////
	
	var container = document.createElement("span");
	var newRow = document.createElement("tr");
	//给新行设置ID属性
	newRow.setAttribute("id",obj.id);
		
	var cell = []; var j = 0;
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");

	cannelImgTd.onclick = function(){
	    newRow.remove(); 
    	setColors(tBody,color1,color2);
    }

	cell[j++] =  makeInputTextTd("name","text","10px",obj.name,"");
	cell[j++] =  makeInputTextTd("value","text","10px",obj.value,"");
	cell[j++] =  makeInputTextTd("calculateAuto","text","10px",obj.calculateAuto,"");
	cell[j++] =  saveImgTd;
	cell[j++] =  cannelImgTd;

	for (var i = 0;i < cell.length;i++ ){
		newRow.appendChild(cell[i]);
	}
	container.appendChild(newRow);
	
	//////////////////构造新行 end ///////////////////
	
	
	
	//编辑状态：追加新行，删除旧行	
	if(mode =='edit'){
		new Insertion.After(editRow,container.innerHTML);
		editRow.remove();	
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

Income.prototype.saveIncome = function(o,func){
	IncomeManager.saveIncome(o,func);
}

Income.prototype.removeIncome = function(id,func){
	IncomeManager.removeIncome(id,func);
}

Income.prototype.getIncomesListXML = function(obj,callBackFun){
	IncomeManager.getIncomesListXML(callBackFun,obj);	
}

Income.prototype.makeSelectFromMap = function(obj,name,event,width,callBackFun){
	IncomeManager.getAccountFromMap(fillFun,obj);       
	function fillFun(objs){
		 makeSelectHtmlWidth(objs,name,event,width);
		 if(callBackFun) callBackFun();
	}
}



Income.prototype.getIncomeXML2 = function(callBackFun){
    var page = this.page;
    var obj = this.obj;
    
    if (page.pageSize > 0){
    	
    	function getCountFun(size){ 
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);
			
			IncomeManager.getIncomeXML2(fun,obj,page.pageIndex-1,page.pageSize);
			
			function fun(strXML){
				if(callBackFun) callBackFun(strXML);
			}
		}
    	
		IncomeManager.getIncomeCount(getCountFun,obj);	
    }
}



 Income.prototype.getIncomeCodeStoreList = function(mode,paramObj){
	paramObj = [paramObj || {}];

		
	var fileds= this.fileds;
	var store = new Ext.data.Store({
		proxy: new Ext.data.DWRHttpProxy({url: IncomeManager.getIncomeCodeStoreList}),
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


 Income.prototype.comboFilterBy = function(qe){
 	
 var combo = qe.combo;  
 var filterFiled = combo.filterFiled;
 var params = combo.params;
 var q = qe.query;  
 var minChars = combo.minChars;

  if(q.length < minChars) return false;
  
  eval("params."+ filterFiled +" =q");
  

  
  var params = $H(params).toQueryString();

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

	         }  
	     }else{  
	     	
	         combo.selectedIndex = -1;  
	         combo.onLoad();  
	     }  
	 }  
 	return false;  
 } 


Income.prototype.getIncomeCodeCom = function(width,renderTo,id,paramObj,defId,defvalue){
		
		 var params = $H(paramObj).toQueryString();
		 var OBJ = this;

         var store = this.getIncomeCodeStoreList('remote',params);

         if(defvalue){
			var rc1 = Ext.data.Record.create(this.fileds);
		    var rc = new rc1({
		    	   id:defId,
		           incomeCode:defvalue
		     });
		     store.add(rc);
         }
         
//         store.on('load', function(){callBackFun();}); 

         var conf = {
		 	     fieldLabel: '到款编号'
//		 	      ,renderTo:renderTo
				 ,id:id
				  ,name:id
				,width:width
//				,hideOnSelect:true
				,maxHeight:200
		  		,editable: true
		  		,typeAhead: true
		  		,forceSelection: true
				,emptyText: '请选择到款编号...' 
				,store:store
				,triggerAction:'all'
				,valueField:'id'
				,displayField:'incomeCode'
				,mode:'remote'
				,params:paramObj
				,lastQuery:'1'
				,minChars:3
    			,filterFiled:'incomeCode'
    			,listeners:{beforequery:OBJ.comboFilterBy.createDelegate(this)}	
			};
         if(renderTo) conf.renderTo = renderTo;
		 var cmd =  new Ext.form.ClearableComboBox(conf);		
		 
		 if(defId){
		 	cmd.setValue(defId);  
		 }
			
		return cmd;	
			
}


Income.prototype.getBalanceParaSortXml = function(queryString,callback){
		IncomeManager.getBalanceParaSortXml(queryString,callback);

}

