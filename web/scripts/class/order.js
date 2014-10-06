

function Order(){
	//创建对象
	this.obj ={
		id:null,
		orderCode:null,
	    relationCode:null,
	    contractId:null,
	    customerId:null,
	    categoryId:null,
	    userId:null,
	    orderMeno:null,
	    isCkecked:null,
	    publishMemo:null,
	    paymentId:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    matterId:null,
	    orderPublic:null,
	    user:null,
	    customer:null,
	    contract:null,
	    orderStates:null,
	    orderDetails:null,
	    contractPayments:null,
	    orderLogs:null,
	    
	    orderCategory:null
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
	this.curPopupWindow = null;
	this.rowNum = 1;
	
	return this;
}



Order.prototype.isChanged = function(bakObj,curObj, sysParam){
	var same = (bakObj.id == curObj.id);
	if(same) same = bakObj.categoryId == curObj.categoryId;
	if(same) same = bakObj.customerId == curObj.customerId;
	if(same) same = bakObj.paymentId == curObj.paymentId;
	if(same) same = bakObj.userId == curObj.userId;
	if(same) same = bakObj.orderMeno == curObj.orderMeno;
	if(same) same = bakObj.publishMemo == curObj.publishMemo;
	if(same) same = bakObj.modifyBy == curObj.modifyBy;

	if(same && sysParam.autoRelationCodeParam == 0){
		 same = bakObj.relationCode == curObj.relationCode;
	}

    return !same;
}

//清空对象
Order.prototype.reset = function(){
	this.obj.id = null;
  	this.obj.orderCode = null;
  	this.obj.relationCode = null;
  	this.obj.contractId = null;
  	this.obj.customerId = null;
  	this.obj.categoryId = null;
  	this.obj.userId = null;
  	this.obj.orderMeno = null;
  	this.obj.paymentId = null;
  	
  	this.obj.isCkecked = null;
  	this.obj.publishMemo = null;
  	
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
  	
  	this.obj.orderPublic = null;
	this.obj.user = null;
  	this.obj.customer = null;
  	this.obj.contract = null;
  	this.obj.matterId = null;
  	this.obj.orderDetails = null;
  	this.obj.contractPayments = null;
  	this.obj.orderLogs = null;

  	this.obj.orderCategory = null;
  	
  	
}


Order.prototype.setObject = function(sourObj){
	this.obj.id = sourObj.id;
  	this.obj.orderCode = sourObj.orderCode;
  	this.obj.relationCode = sourObj.relationCode;
  	this.obj.contractId = sourObj.contractId;
  	this.obj.customerId = sourObj.customerId;
  	this.obj.categoryId = sourObj.categoryId;
  	this.obj.userId = sourObj.userId;
  	this.obj.orderMeno = sourObj.orderMeno;
  	this.obj.paymentId = sourObj.paymentId;
  	this.obj.isCkecked = sourObj.isCkecked;
  	this.obj.publishMemo = sourObj.publishMemo;
  	this.obj.createBy = sourObj.createBy;
  	this.obj.createDate = sourObj.createDate;
  	this.obj.modifyBy = sourObj.modifyBy;
  	this.obj.modifyDate = sourObj.modifyDate;
  	this.obj.version = sourObj.version;
  	

	this.obj.user = sourObj.user;
  	this.obj.customer = sourObj.customer;
  	this.obj.contract = sourObj.contract;
  	this.obj.orderDetails = sourObj.orderDetails;
  	this.obj.contractPayments = sourObj.contractPayments;
  	this.obj.contractPayment = sourObj.contractPayment;
  	this.obj.orderLogs = sourObj.orderLogs;
  	this.obj.orderCategory = sourObj.orderCategory;
  	this.obj.orderState = sourObj.orderState;
  	this.obj.orderPublic = sourObj.orderPublic;
//  	this.obj.orderPublic.orderStates = sourObj.orderState.name;


  	//this.obj.orderCategory.name = sourObj.orderCategory

}

Order.prototype.setObject2 = function(sourObj){
	this.obj.id = sourObj.id;
  	this.obj.orderCode = sourObj.orderCode;
  	this.obj.relationCode = sourObj.relationCode;
  	this.obj.contractId = sourObj.contractId;
  	this.obj.customerId = sourObj.customerId;
  	this.obj.categoryId = sourObj.categoryId;
  	this.obj.userId = sourObj.userId;
  	this.obj.orderMeno = sourObj.orderMeno;
  	this.obj.paymentId = sourObj.paymentId;
  	this.obj.isCkecked = sourObj.isCkecked;
  	this.obj.publishMemo = sourObj.publishMemo;
  	this.obj.createBy = sourObj.createBy;
//  	this.obj.createDate = sourObj.createDate;
  	this.obj.modifyBy = sourObj.modifyBy;
//  	this.obj.modifyDate = sourObj.modifyDate;
  	this.obj.version = sourObj.version;
  	this.obj.loginUser = sourObj.loginUser;
  	
}


Order.prototype.backupObject = function(sourObj,targObj){
	targObj.id = sourObj.id;
  	targObj.orderCode = sourObj.orderCode;
  	targObj.relationCode = sourObj.orderCode;
  	targObj.contractId = sourObj.contractId;
  	targObj.customerId = sourObj.customerId;
  	targObj.categoryId = sourObj.categoryId;
  	targObj.userId = sourObj.userId;
  	targObj.orderMeno = sourObj.orderMeno;
  	targObj.paymentId = sourObj.paymentId;
  	
  	targObj.isCkecked = sourObj.isCkecked;
  	targObj.publishMemo = sourObj.publishMemo;
  	
  	targObj.createBy = sourObj.createBy;
  	targObj.createDate = sourObj.createDate;
  	targObj.modifyBy = sourObj.modifyBy;
  	targObj.modifyDate = sourObj.modifyDate;
  	targObj.version = sourObj.version;
  	
//  	targObj.orderPublic = sourObj.orderPublic;
		targObj.user = sourObj.user;
  	targObj.customer = sourObj.customer;
  	targObj.contract = sourObj.contract;
  	
  	targObj.orderDetails = sourObj.orderDetails;
  	targObj.contractPayments = sourObj.contractPayments;
  	targObj.orderLogs = sourObj.orderLogs;

  	targObj.orderCategory = sourObj.orderCategory;
  	targObj.orderState = sourObj.orderState;
  	
  	
  	targObj.orderPublic = sourObj.orderPublic;
  	//this.obj.orderCategory.name = sourObj.orderCategory
  	
  	return 	targObj;

}


Order.prototype.getOrder = function(id,getFun){
//	var obj;

//	DWREngine.setAsync(false);
	OrderManager.getOrder(getFun,id);
//	DWREngine.setAsync(true);
//    var fnc = getFun;
//	function setValueFun(o){
//		fnc(o);
//	}
		
//	function setValueFun(o){
//		this.obj = o;
//		obj = o;
//	}
//	return obj;
}


Order.prototype.getOrderForEdit = function(id,getFun){
	OrderManager.getOrderForEdit(id,getFun);
}
Order.prototype.saveOrderClone = function(id,loginUserId,getFun){
	OrderManager.saveOrderClone(id,loginUserId,getFun);
}


Order.prototype.getOrdersByPaymentId = function(o,getFun){
	OrderManager.getOrdersCount(getFun,o);
}

/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
Order.prototype.getOrders = function(o){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = OBJ.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
//		DWREngine.setAsync(false);
		OrderManager.getOrdersPage(OBJ.fillTalbe,obj,page.pageIndex,page.pageSize);
//		DWREngine.setAsync(true);
    }else{
		OrderManager.getOrders(OBJ.fillTalbe,obj);	
    }
}

Order.prototype.getOrders = function(OBJ,func){
	var obj = OBJ.obj;
	var page   = OBJ.page;
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		OrderManager.getOrdersPage(func,obj,page.pageIndex,page.pageSize);
    }else{
		OrderManager.getOrders(func,obj);	
    }
}

Order.prototype.getOrdersByCusId = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page   = OBJ.page;
//	alert(obj.customerId);
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);
		DWREngine.setAsync(false);
		OrderManager.getOrdersPage(func,obj,page.pageIndex,page.pageSize);
		DWREngine.setAsync(true);
    }else{
		OrderManager.getOrders(func,obj);	
    }
}
Order.prototype.getOrdersReport = function(o,func){
	var OBJ = o;
	var obj = OBJ.obj;
	var page   = OBJ.page;
	
	var setFun = function(size){
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		OrderManager.getOrdersReportPage(func,obj,page.pageIndex-1,page.pageSize);
	}

    if (page.pageSize > 0){
		OrderManager.getOrdersReportCount(setFun,obj);
//		DWREngine.setAsync(false);
//        alert(page.pageIndex);
		

//		DWREngine.setAsync(true);
    }else{
		OrderManager.getOrdersReport(func,obj);	
//		OrderManager.getOrders(func,obj);	
    }
  
}

Order.prototype.getOrderAutoComplt = function(obj,callBackFun){
	OrderManager.getOrders(callBackFun,obj);
}



Order.prototype.fillTalbeReport= function(objs){
	var OBJ = order;
	var obj = OBJ.obj;
	var tBody  = order.tBody;
	var color1 = order.color1;
	var color2 = order.color2;

		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("orderCode", rowData.orderCode);
		 	row.setAttribute("relationCode", rowData.relationCode);
		 	row.setAttribute("categoryId", rowData.categoryId);
		 	row.setAttribute("orderMeno", rowData.orderMeno);
		 	row.setAttribute("contractId", rowData.contractId);
		 	row.setAttribute("userId", rowData.userId);
		 	row.obj = rowData;
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
			OBJ.removeOrder(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[
//						function(obj){ return makeInputText(OBJ.checkBoxName,"checkbox",obj.id)},
						function(obj){ return '<a href="javascript:void 0" onClick="editOrderInfo('+ obj.id +')">' + obj.orderCode +'</a>'},
//						function(obj){ return obj.orderCode},
						function(obj){ return obj.contract.code;},
						//广告名称
						//function(obj){ return obj.publishMemo;},
						function(obj){ return obj.orderPublic.matterName;},
						
						function(obj){return getFormatDay(obj.orderPublic.publishStartDate+"",'y/m/d');},
						function(obj){return getFormatDay(obj.orderPublic.publishEndDate+"",'y/m/d');},
						function(obj){ return obj.orderPublic.moneyRealpay;},
						function(obj){ return obj.orderPublic.moneyIn;},
						function(obj){ return obj.orderState.name;},
//					    function(obj) {
////					    	var view = makeInputButtonTd(obj.id,"button","18","预览","button_view_bro");
//					    	var view ="<a herf='javascript:void 0;' onclick='javascript:button_view_bro(" + obj.id +"," + obj.orderPublic.publishStartDate +")'>预览</a>"
////					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return view;}, 
//					    function(obj) {
////							var print = makeInputButtonTd(obj.id,"button","18","打印","button_print_bro");
//                            var print ="<a herf='javascript:void 0;' onclick='javascript:button_print_bro(" + obj.id +"," + obj.orderPublic.publishStartDate +")'>打印</a>"
////					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return print;},  
//					    function(obj) {
////							var exp = makeInputButtonTd(obj.id,"button","18","导出","button_print_export");
//							var exp ="<a herf='javascript:void 0;' onclick='javascript:button_print_export(" + obj.id +"," + obj.orderPublic.publishStartDate +")'>导出</a>"
////					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return exp;},
				];		
		
		//先删除 tbody		
		DWRUtil.removeAllRows(tBody);
		//再重新构造新的表
		DWRUtil.addRows(tBody,objs,cellTable,{
					rowCreator:function(options) {  
							   var row = document.createElement("tr"); 
					           putRowDataInHidden(row,options.rowData);
						   	   var rowIndex = options.rowIndex;	
//						   	   console.log(options);
						   	   row.obj = options.rowData;
					           row.setAttribute("onclick","javascript:drawColorOrderTable("+ rowIndex +"," + row.obj.id +")");
//					           row.setAttribute("ondblclick","javascript:alert("+ rowIndex +")");
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



Order.prototype.fillTalbe= function(objs){
	var OBJ = order;
	var obj = OBJ.obj;
	var tBody  = order.tBody;
	var color1 = order.color1;
	var color2 = order.color2;
	

		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("orderCode", rowData.orderCode);
		 	row.setAttribute("relationCode", rowData.relationCode);
		 	row.setAttribute("categoryId", rowData.categoryId);
		 	row.setAttribute("orderMeno", rowData.orderMeno);
		 	row.setAttribute("contractId", rowData.contractId);
		 	row.setAttribute("userId", rowData.userId);
		 	row.obj = rowData;
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
			OBJ.removeOrder(id,delRow);
		}
		
		//一行中，各单元格返回的内容
		var cellTable=[
//						function(obj){ return makeInputText(OBJ.checkBoxName,"checkbox",obj.id)},
//						function(obj){ return '<a href="javascript:void 0" onClick="editOrderInfo('+ obj.id +')">' + obj.orderCode +'</a>'},
						function(obj){ return obj.orderCode;},
//						function(obj){ return obj.contract.code;},
						//function(obj){ return obj.customer.customerName;},
						function(obj){return getFormatDay(obj.orderPublic.publishStartDate+"",'y/m/d');},
						function(obj){return getFormatDay(obj.orderPublic.publishEndDate+"",'y/m/d');},
						function(obj){ return obj.orderPublic.moneyRealpay;},
						function(obj){ return obj.orderPublic.moneyIn;},
						function(obj){ return obj.orderState.name;},
//					    function(obj) {
//					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editOrder");
////					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return editImg;}, 
//					    function(obj) {
//							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
//							if(OBJ.enableDel) deleImg.onclick = del;
//					    	return deleImg;} 
				];		
		
		//先删除 tbody		
		DWRUtil.removeAllRows(tBody);
		//再重新构造新的表
		DWRUtil.addRows(tBody,objs,cellTable,{
					rowCreator:function(options) {  
							   var row = document.createElement("tr"); 
							   row.setAttribute("onclick","javascript:editOrderInfo("+ options.rowData.customer.orgId +","+ options.rowData.id + ")");
					           putRowDataInHidden(row,options.rowData);
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

Order.prototype.fillTalbeByCusId = function(objs){
	var OBJ = order;
	var obj = OBJ.obj;
	var tBody  = order.tBody;
	var color1 = order.color1;
	var color2 = order.color2;
	

		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("orderCode", rowData.orderCode);
		 	row.setAttribute("relationCode", rowData.relationCode);
		 	row.setAttribute("categoryId", rowData.categoryId);
		 	row.setAttribute("orderMeno", rowData.orderMeno);
		 	row.setAttribute("contractId", rowData.contractId);
		 	row.setAttribute("userId", rowData.userId);
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
			OBJ.removeOrder(id,delRow);
		}
		
		order.rowNum = (OBJ.page.pageIndex-1)*OBJ.page.pageSize;
		
		//一行中，各单元格返回的内容
		var cellTable=[
						function(obj){return "<a href='editOrder.html?id=" +obj.id +"&"+"'>" + (++order.rowNum) +"</a>"},
						function(obj){ return '<a href="javascript:void 0" onClick="editOrderInfo('+ obj.id +')">' + obj.orderCode +'</a>'},
						function(obj){ return obj.contract.code;},
						//function(obj){ return obj.customer.customerName;},
						function(obj){ return formatDateGlobal(obj.orderPublic.publishStartDate);},
						function(obj){ return formatDateGlobal(obj.orderPublic.publishEndDate);},
						function(obj){ return obj.orderPublic.moneyRealpay;},
						function(obj){ return obj.orderPublic.moneyIn;},
						function(obj){ return obj.orderState.name;},
						function(obj){ return ""},
//					    function(obj) {
//					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"editOrder");
////					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return editImg;}, 
//					    function(obj) {
//							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"");
//							if(OBJ.enableDel) deleImg.onclick = del;
//					    	return deleImg;} 
				];		
		
		//先删除 tbody		
		DWRUtil.removeAllRows(tBody);
		//再重新构造新的表
		DWRUtil.addRows(tBody,objs,cellTable,{
					rowCreator:function(options) {  
							   var row = document.createElement("tr"); 
							   row.setAttribute("onclick","javascript:editOrderInfo("+ options.rowData.id + ")");
					           putRowDataInHidden(row,options.rowData);
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
Order.prototype.fillTalbeWF= function(objs){	
//	payOrderAutoComplet(objs);
//alert(objs.length);
	var OBJ = this;
	var tBody  = order.tBody;
	var color1 = order.color1;
	var color2 = order.color2;
	

		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("orderCode", rowData.orderCode);
		 	row.setAttribute("relationCode", rowData.relationCode);
		 	row.setAttribute("categoryId", rowData.categoryId);
		 	row.setAttribute("orderMeno", rowData.orderMeno);
		 	row.setAttribute("contractId", rowData.contractId);
		 	row.setAttribute("userId", rowData.userId);
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
			OBJ.removeOrder(id,delRow);
		}
		
	
	function formatName(s){
		s =s==null?"":s.substring(0,9);
		return s;
	}
		
		//一行中，各单元格返回的内容
		var cellTable=[
						function(obj){ return makeInputText(OBJ.checkBoxName,"checkbox",obj.id)},
//						function(obj){ return '<a href="javascript:void 0" onClick="editOrderInfo('+ obj.id +')">' + obj.orderCode +'</a>'},
						function(obj){ return "<a href=editOrder.html?id="+ obj.id +"&orgId="+ OBJ.obj.orgId+" target=_bank>" + obj.orderCode +'</a>'},
						function(obj){ return obj.contract.code;},
						function(obj){ return formatName(obj.customer.customerName);},
						function(obj){ return formatName(obj.orderPublic.matterName);},
						function(obj){ return formatDateGlobal(obj.orderPublic.publishStartDate);},
						function(obj){ return formatDateGlobal(obj.orderPublic.publishEndDate);},
						function(obj){ return obj.orderPublic.moneyRealpay;},
						function(obj){ return obj.orderPublic.moneyIn;},
						function(obj){ return '<a href="javascript:void 0" onClick="autoOrderArrange('+ obj.id +')">'+"结果明系"},
						function(obj){ return obj.user.fullName;},
						function(obj){ return obj.orderMeno;},
						function(obj){ return obj.orderState.name;},
					    	function(obj) { var r="";if(obj.orderPublic.moneyBase >0) r = cheng(obj.orderPublic.moneyRealpay/obj.orderPublic.moneyBase*100,2) +"%";
					    		return r=(r=="100%")?"":r;}, 
					    	//function(obj) {return obj.orderPublic.moneyRealpay;}, 
					    	//function(obj) {return obj.orderPublic.moneyBase;} 
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

/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
Order.prototype.saveOrder = function(obj,saveFun){
	OrderManager.saveOrder(obj,saveFun);
}

Order.prototype.saveOrderReturnObj = function(obj,saveFun){
	OrderManager.saveOrderReturnObj(obj,saveFun);
}
/* 删除
 * 根据id删除对象
 */
Order.prototype.removeOrder = function(id,delRow){
	var OBJ = this;
	var obj = this.obj;
	var page = this.page;
	var curRow = this.tBody.rows.length;

	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	OrderManager.removeOrder(removeFun,id);	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getOrders();
   }
}
/* 总记录数
 * 
 */
Order.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	OrderManager.getOrdersCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Order.prototype.getOrdersCount = function(obj,getCountFun){
	OrderManager.getOrdersCount(getCountFun,obj);	
}

/* 添加新行 编辑或删除 
 * 
 */
Order.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
	var page = this.page;
	var tBody = this.tBody;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;

	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.orderCode = editRow.getAttribute("orderCode");
	 	obj.relationCode = editRow.getAttribute("relationCode");
	 	obj.categoryId = editRow.getAttribute("categoryId");
	 	obj.orderMeno = editRow.getAttribute("orderMeno");
	 	obj.contractId = editRow.getAttribute("contractId");
	 	obj.userId = editRow.getAttribute("userId");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
		DWRUtil.getValues(obj);
		obj.id = id;
		OBJ.saveTarget(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 $("hiddenArea").appendChild($("userId"));
		 $("hiddenArea").appendChild($("categoryId"));
		 OBJ.getOrders()
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
		$("hiddenArea").appendChild($("userId"));
		$("hiddenArea").appendChild($("categoryId"));
	    newRow.remove(); 
    	setColors(tBody,color1,color2);
    }
	cell[j++] =  makeInputTextTd("orderCode","text","10px",obj.orderCode,"");
	cell[j++] =  makeInputTextTd("relationCode","text","10px",obj.relationCode,"");

	cell[j++] =  makeTdByObj($("categoryId"));
	cell[j++] =  makeInputTextTd("orderMeno","text","10px",obj.orderMeno,"");
	cell[j++] =  makeInputTextTd("contractId","text","10px",obj.contractId,"");

	cell[j++] =  makeTdByObj($("userId"));
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
//		alert(2)
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



Order.prototype.getOrdersByWorkFlowCount = function(workFlowId,state,userId){
	var count;
	DWREngine.setAsync(false);
	OrderManager.getOrdersByWorkFlowCount(getCountFun,workFlowId,state,userId);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Order.prototype.getContractsByWorkFlowPage = function(workFlowId,OBJ,fn){ 

  	var page = OBJ.page;
    var obj = OBJ.obj;
    
    function  lastFunc(objs){
    	OBJ.fillTalbeWF(objs);
    	if(fn) fn();
    }
    
    
    if (page.pageSize > 0){
    	
		function getCountFun(size){
			
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);		
		
			OrderManager.getOrdersByWorkFlowPage(lastFunc,workFlowId,obj,page.pageIndex-1,page.pageSize);		
		}    	
	 
		OrderManager.getOrdersByWorkFlowCount(getCountFun,workFlowId1,obj);	


    }else{
		OrderManager.getOrders(lastFunc,obj);	
    }    

}

Order.prototype.updateOrderStates = function(ids,state){ 
	var saveFunction = function(){};

		if(ids != "" ) {
//			DWREngine.setAsync(false);
			OrderManager.updateOrderStates(ids,state,saveFunction);
//			DWREngine.setAsync(true);
		}	
}
Order.prototype.updateOrderStates2 = function(ids,state,checkUserId,checkStateIdOld,defMsg,callbakFunction){ 
	var saveFunction = function(){
		if(callbakFunction) callbakFunction();
	};

		if(ids != "" ) {
//			DWREngine.setAsync(false);
//			OrderManager.updateOrderStates(ids,state,saveFunction);
			OrderManager.updateOrderStates2(ids,state,checkUserId,checkStateIdOld,defMsg,saveFunction);
			
//			DWREngine.setAsync(true);
		}	
}

Order.prototype.getOrderPublic = function(getFun,orderId){
	OrderManager.getOrderPublic(getFun,orderId);	
}

Order.prototype.getOrdersByWFSearchCount = function(workFlowId,state,orderCode,userId){
	var count;
	DWREngine.setAsync(false);
	OrderManager.getOrdersByWFSearchCount(getCountFun,workFlowId,state,orderCode,userId);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

Order.prototype.getOrdersByWorkFlowPageSearch = function(workFlowId,state,orderCode,userId){ 
	var OBJ = this;
  	var page = this.page;
    	var obj = this.obj;

    
    if (page.pageSize > 0){
	function getCountFun(size){
		page.size = size;
		
		page.MakePageNav(page.pageIndex,page.pageInfo);		
		OrderManager.getOrdersByWorkFlowPageSearch(OBJ.fillTalbeWF,workFlowId,state,orderCode,userId,page.pageIndex-1,page.pageSize);		
	}
	
	//alert(workFlowId);alert(state);alert(orderCode);alert(userId);
	
	OrderManager.getOrdersByWFSearchCount(getCountFun,workFlowId,state,orderCode,userId);	
	
    }else{
		OrderManager.getOrders(OBJ.fillTalbeWF,obj);	
    }    

}

Order.prototype.getOrdersByCheckState = function(checkState,getCountFun){
	OrderManager.getOrdersByCheckState(getCountFun,checkState);	
}
Order.prototype.getOrdersByCheckState2 = function(checkState,userId,year,getCountFun){
	OrderManager.getOrdersByCheckState2(getCountFun,checkState,userId,year);	
}
Order.prototype.getOrderCodeByCheckState1 = function(checkState,publishDate,resourceId,callBackFun){
	DWREngine.setAsync(false);
	OrderManager.getOrderCodeByCheckState1(callBackFun,checkState,publishDate,resourceId);
	DWREngine.setAsync(true);
}
Order.prototype.getSpecificInfo = function(beginDate,endDate,resourceId,specificId,callback){

	OrderManager.getSpecificInfo(callback,beginDate,endDate,resourceId,specificId);	

}
Order.prototype.getSpecificInfo2 = function(queryStr,callback){

	OrderManager.getSpecificInfo2(queryStr,callback);	

}

Order.prototype.fillTalbeSpecific= function(objs){	
//	payOrderAutoComplet(objs);
//	alert(objs.length);
	var OBJ = this;
	var tBody  = order.tBody;
	var color1 = order.color1;
	var color2 = order.color2;
	

		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
//		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
//		 	row.setAttribute("paraId", rowData.id);
//		 	row.setAttribute("orderCode", rowData.orderCode);
//		 	row.setAttribute("relationCode", rowData.relationCode);
//		 	row.setAttribute("categoryId", rowData.categoryId);
//		 	row.setAttribute("orderMeno", rowData.orderMeno);
//		 	row.setAttribute("contractId", rowData.contractId);
//		 	row.setAttribute("userId", rowData.userId);
		 	
		 	row.setAttribute("rowData", rowData);
		 }	
		 
		//一行中，各单元格返回的内容
		var cellTable=[
		
						//开始和结束日期
						function(obj){return getFormatDay(obj.orderPublic.publishStartDate+"",'y/m/d');},
									//订单号
						function(obj){return '<a href="javascript:void 0" onClick="editOrderInfo('+ obj.order.id +')">' + obj.order.orderCode +'</a>'},
									//资源备注  资源名称 
						function(obj){ return "["+obj.resource.resourceName+"]"+"     "+obj.resource.memo;},
									//指定
						function(obj){ return obj.specific.name;},
									//广告名称
						function(obj){ return obj.matter.name;},
									//广告版本
						function(obj){ return obj.matter.edit;},

						
						//function(obj){ return getFormatDay(obj.orderPublic.publishEndDate+"",'y/m/d');},
					 
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

Order.prototype.getOrderListXML = function(obj,callBackFun){
	OrderManager.getOrderListXML(callBackFun,obj);	
}
Order.prototype.getCustomerIdByUserId = function(obj,callBackFun){
	CustomerManager.getCustomerIdByUserId(callBackFun,obj);	
}



Order.prototype.saveOrderStopBro = function(obj,detailIds,startDate,endDate,callBack){

	OrderManager.saveOrderStopBro(obj,detailIds,startDate*1,endDate*1,callBack);
}

Order.prototype.saveOrderStopBro2 = function(obj,callBack){
	OrderManager.saveOrderStopBro2(obj,callBack);
}

Order.prototype.saveOrderSpec = function(obj,detailIds,startDate,endDate,specValue,specId, specTXT,callBack){

	OrderManager.saveOrderSpec(obj,detailIds,startDate*1,endDate*1,specValue,specId,specTXT,callBack);
}
Order.prototype.saveOrderPrice = function(obj,detailIds,startDate,endDate,execPrice,favourRate,appRate,callBack){

	OrderManager.saveOrderPrice(obj,detailIds,startDate*1,endDate*1,execPrice,favourRate,appRate,callBack);
}

Order.prototype.saveOrderMoreDetails = function(obj,orderBackUp,callBack){
	OrderManager.saveOrderMoreDetails(obj,orderBackUp,callBack);
}


Order.prototype.saveOrderMemo = function(obj,callBack){
	OrderManager.saveOrderMemo(obj,callBack);
}

