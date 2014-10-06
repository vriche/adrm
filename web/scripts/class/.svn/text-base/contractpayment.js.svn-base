

function PayMent(){
	//创建对象
	this.obj ={
		id:null,
		contractId:null,
		customerId:null,
	    payDate:null,
	    payNumber:null,
	    contract:null,
	    order:null,
	    incomePurposeId:null,
	    moneyPay:null,
	    moneyIn:null,
	    incomePurpose:null,
	    incomeId:null,
	    isWhere:null,
	    incomeUsed:null,
	    customer:null,
	    customerName:null,
	    customerCategoryId:null,
	    orderId:null,
	    contractCode:null,
	    carrierId:null,
	    userId:null,
	    state:null,
	    orderCode:null,
	    carrierIds :new Array(),
	    incPullIds : new Array(),
	    paymentIds : new Array(),
	    userIds : new Array(),
		incomePullId : null,
		carrierId : null
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
	
	return this;
}

//清空对象
PayMent.prototype.reset = function(){
	this.obj.id = null;
	this.obj.contractId = null;
  	this.obj.payDate = null;
  	this.obj.payNumber = null;
  	this.obj.contractCode = null;
  	this.obj.orderCode = null;
  	this.obj.contract = null;
  	this.obj.order = null;
  	this.obj.customerId = null;
  	this.obj.incomePurposeId = null;
  	this.obj.memo = null;
  	this.obj.moneyPay = null;
  	this.obj.moneyIn = null;
  	this.obj.incomePurpose = null;
  	this.obj.isWhere = null;
  	this.obj.incomeId = null;
  	this.obj.incomeUsed = null;
  	this.obj.customer = null;
  	this.obj.customerName = null;
  	this.obj.customerCategoryId = null;
  	this.obj.orderId = null;
  	this.obj.state = null;
  	this.obj.carrierId = null;
  	this.obj.userId = null;
  	
  	//this.obj.carrierIds = new Array();
	this.obj.incomePullId = null;
	this.obj.carrierId = null;
  	
  	//this.obj.carrierIds = new Array();
	//this.obj.incPullIds =  new Array();
}

/*******************************************
*			对象的基本操作方法                
*******************************************/
PayMent.prototype.getPayMent = function(id){

	var OBJ = this;
	var obj = OBJ.obj;

	DWREngine.setAsync(false);
	ContractPaymentManager.getContractPayment(id,setValueFun);
	DWREngine.setAsync(true);
	
	function setValueFun(o){
		DWRUtil.setValues(o);
		obj = o;
	}
	return obj;
}




PayMent.prototype.savePutonMoney = function(ids,incomeMoney,incomeId,pullId,carrierId,callBackFun){
	ContractPaymentManager.savePutonMoneyByInIdAndPullId(ids,incomeMoney,incomeId,pullId,carrierId,callBackFun);

}

PayMent.prototype.savePutonMoneyByObj = function(objs,callBackFun){
	ContractPaymentManager.savePutonMoneyByObj(objs,callBackFun);
}


PayMent.prototype.saveBackPaymentMoneyIn = function(ids,incomeId,callBackFun){
	ContractPaymentManager.saveBackPaymentMoneyIn(ids,incomeId,callBackFun);
}


PayMent.prototype.saveBackPaymentMoneyInByInIdAndPullId = function(ids,incomeId,pullId,callBackFun){
	ContractPaymentManager.saveBackPaymentMoneyInByInIdAndPullId(ids,incomeId,pullId,callBackFun);
}

PayMent.prototype.saveBackPaymentMoneyByObj = function(objs,callBackFun){
	ContractPaymentManager.saveBackPaymentMoneyByObj(objs,callBackFun);
}



/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
PayMent.prototype.getContractPayments = function(o){
	var OBJ    = this;
	var obj    = o;
	var page   = this.page;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	var withResourceSort = (obj.withResourceSort ==1);

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		ContractPaymentManager.getContractPaymentsPage(obj,page.pageIndex,page.pageSize,fillTalbe);
    }else{
		ContractPaymentManager.getContractPayments(obj,fillTalbe);	
    }

   
	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.obj = rowData;
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
		 	row.setAttribute("memo", rowData.memo);
		 	row.setAttribute("tvNameParam", tvNameParam);
		 	row.setAttribute("orderMainType", orderMainType);
		 	row.setAttribute("resourceTypeId", rowData.resourceTypeId);
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			var e = event || window.event;
			var editImg = Event.element(e); 
			var tr1= editImg.parentNode.parentNode;
			var id = tr1.getAttribute("paraId");
			var editRow = $(OBJ.IdPrefix + id);
//			editRow.tvNameParam = tvNameParam;
//			editRow.orderMainType = orderMainType;
			
//			alert("editRow=="+editRow);
			
			payment.addNewRow("edit",editRow);

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
		var cellTable=[];
		
		
//		  if(tvNameParam == 'xmtv' && orderMainType == 2){
		  if(withResourceSort){

		
			 cellTable=[
//			            function(obj){return obj.memo;},
			            
			             function(obj){
			             		$("resourceType").value = obj.resourceTypeId;
							  	var selectedIndex = $("resourceType").selectedIndex;
							  	var gg =$("resourceType").options[selectedIndex].text;
							  	return gg;
							},
			            
						function(obj){return obj.payNumber;},
//						function(obj){return obj.payDate},
						
						function(obj){
							var payDate = obj.payDate==null?"":getFormatDay(obj.payDate+"",'y/m/d');
							return payDate;
							},

						function(obj){return obj.incomePurpose.name},
						function(obj){return ForDight(obj.moneyPay,2)},
						function(obj){return obj.moneyIn},
					    function(obj) {
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
					    	editImg.onclick = edit;
					    	if(!OBJ.enableEdit){  
					    		return "&nbsp"; //editImg.onclick = edit;
						}else{
							return editImg;
						}
					    	}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delePayment");
							if(!OBJ.enableDel){
								 return "&nbsp"; //deleImg.onclick = del;
							}else{
								return deleImg;
							}
					    	} 
				];	
		  }else{
			 cellTable=[
						function(obj){return obj.payNumber;},
//						function(obj){return obj.payDate},
						
						function(obj){
							var payDate = obj.payDate==null?"":getFormatDay(obj.payDate+"",'y/m/d');
							return payDate;
							},
							
						function(obj){return obj.incomePurpose.name},
						function(obj){return 	ForDight(obj.moneyPay,2)},
						function(obj){return obj.moneyIn},
					    function(obj) {
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
					    	editImg.onclick = edit;
					    	if(!OBJ.enableEdit){  
					    		return "&nbsp"; //editImg.onclick = edit;
						}else{
							return editImg;
						}
					    	}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delePayment");
							if(!OBJ.enableDel){
								 return "&nbsp"; //deleImg.onclick = del;
							}else{
								return deleImg;
							}
					    	} 
				];	
		  }

				
				
				
				
		
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
}
//要计算折扣的
PayMent.prototype.getContractPaymentDiscount = function(obj,func){
	ContractPaymentManager.getContractPaymentsTable(obj,func);	
	
}

PayMent.prototype.getContractPaymentsTable = function(o){
	var OBJ    = this;
	var obj    = o;
	var page   = this.page;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	var withResourceSort = obj.withResourceSort ==1;
	

//	    alert(obj.toSource());
    obj.resourceTypeId = null;
	if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		ContractPaymentManager.getContractPaymentsPageTable(obj,page.pageIndex,page.pageSize,fillTalbe);
	}else{
		ContractPaymentManager.getContractPayments(obj,fillTalbe);	
    }

   
	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
    	
    	
    	
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.obj = rowData;
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
		 	row.setAttribute("memo", rowData.memo);
		 	row.setAttribute("resourceTypeId", rowData.resourceTypeId);
		 	row.setAttribute("tvNameParam", tvNameParam);
		 	row.setAttribute("orderMainType", orderMainType);
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			var e = event || window.event;
			var editImg = Event.element(e); 
			var tr1= editImg.parentNode.parentNode;
			var id = tr1.getAttribute("paraId");
			var editRow = $(OBJ.IdPrefix + id);
			
			
			
//			editRow.tvNameParam = tvNameParam;
//			editRow.orderMainType = orderMainType;
			
			
			payment.addNewRow("edit",editRow);

		}
		//删除图标的触发的事件
		function del(event){
			var e = event || window.event;
			var deleImg = Event.element(e);
			var id = deleImg.getAttribute("paraId"); 
			var delRow = deleImg.parentNode.parentNode;
			OBJ.removePayMentNum(id,delRow,ordId);
		}
		
		
	
		var cellTable =[];
		
		//一行中，各单元格返回的内容
//		var i = 0;
//         alert(orderMainType);
//        if(tvNameParam == 'xmtv' && orderMainType == 2){
        if(withResourceSort){ 	
        	
//        	 if(tvNameParam == 'xmtv'){
        	 	
        	 	

		  	
			cellTable=[
						function(obj){
							$("resourceType").value = obj.resourceTypeId;
						  	var selectedIndex = $("resourceType").selectedIndex;
						  	var gg =$("resourceType").options[selectedIndex].text;
						  	return gg;
							
							//return obj.memo;
							
							},
						
						
						function(obj){return obj.payNumber;},
//						function(obj){return obj.payDate},
						function(obj){
							var payDate = obj.payDate==null?"":getFormatDay(obj.payDate+"",'y/m/d');
							return payDate;
							},
							
						function(obj){return obj.incomePurpose.name},
						function(obj){return ForDight(obj.moneyPay,2)},
						function(obj){return obj.moneyIn},
					    function(obj) {
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
					    	editImg.onclick = edit;
					    	if(!OBJ.enableEdit){  
					    		return "&nbsp"; //editImg.onclick = edit;
						}else{
							return editImg;
						}
					    	}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delePayment");
							if(!OBJ.enableDel){
								 return "&nbsp"; //deleImg.onclick = del;
							}else{
								return deleImg;
							}
					    	} 
				];
        }else{
				cellTable=[
						function(obj){return obj.payNumber;},
//						function(obj){return obj.payDate},
						function(obj){
							var payDate = obj.payDate==null?"":getFormatDay(obj.payDate+"",'y/m/d');
							return payDate;
							},
							
						function(obj){return obj.incomePurpose.name},
						function(obj){return ForDight(obj.moneyPay,2)},
						function(obj){return obj.moneyIn},
					    function(obj) {
					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
					    	editImg.onclick = edit;
					    	if(!OBJ.enableEdit){  
					    		return "&nbsp"; //editImg.onclick = edit;
						}else{
							return editImg;
						}
					    	}, 
					    function(obj) {
							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delePayment");
							if(!OBJ.enableDel){
								 return "&nbsp"; //deleImg.onclick = del;
							}else{
								return deleImg;
							}
					    	} 
				];
        }

				
				
				
		
		//先删除 tbody		

		DWRUtil.removeAllRows(tBody);
//		tBody.deleteRow(0);
//        tBody.deleteRow(1);
        
//		function   clearData(){
//			for(var   i =   tBody.childNodes.length-1;i>=0;i--)
//			{
//				alert(tBody.childNodes[i]);
//				tBody.removeChild(tBody.childNodes[i]);
//			}
//		}    
		
//		clearData();   
        
        
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
}


PayMent.prototype.getContractPaymentList = function(callBackFun,customerName,startDate,endDate){
    var page = this.page;
    var obj = this.obj;
		
    if (page.pageSize > 0){
    		function getCountFun(size){ 
			page.size = size;
			var lastPage = Math.floor(size/page.pageSize)+1;
			var isLastSumPage = (lastPage==page.pageIndex);
			if(isLastSumPage) size++;
			page.MakePageNav(page.pageIndex,page.pageInfo);
			ContractPaymentManager.getContractPaymentListPage(isLastSumPage,customerName,startDate,endDate,page.pageIndex-1,page.pageSize,callBackFun);
		}
		ContractPaymentManager.getContractPaymentListCount(customerName,startDate,endDate,getCountFun);	
	
    }else{
		ContractPaymentManager.getContractPaymentList(customerName,startDate,endDate,callBackFun);	
    }
}






PayMent.prototype.contractFillTalbe = function(objs){
	var OBJ = contractPayment;
	var obj = OBJ.obj;
	var tBody  = contractPayment.tBody;
	var color1 = contractPayment.color1;
	var color2 = contractPayment.color2;
    var withResourceSort = obj.withResourceSort ==1;	
	
	
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("orderId", rowData.orderId);
		 	row.setAttribute("contractId", rowData.contractId);
		 	
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
		 	row.setAttribute("memo", rowData.memo);
		 	row.setAttribute("resourceTypeId", rowData.resourceTypeId);
		 	
		 	row.rowData = rowData;
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			
			var e = event || window.event;
			var editImg = Event.element(e); 
			var tr1= editImg.parentNode.parentNode;
			var id = tr1.getAttribute("paraId");
			
//			var incomePurposeId = tr1.getAttribute("incomePurposeId");
			
			var editRow = $(OBJ.IdPrefix + id);
			
//			editRow.tvNameParam = tvNameParam;
//			editRow.orderMainType = orderMainType;
			
			
			
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

	
	var cellTable=[];			
	 if(withResourceSort){
			 cellTable=[
//						function(obj){return obj.memo;},
						function(obj){
							$("resourceType").value = obj.resourceTypeId;
						  	var selectedIndex = $("resourceType").selectedIndex;
						  	var gg =$("resourceType").options[selectedIndex].text;
						  	return gg;
							
							//return obj.memo;
							
							},
						function(obj){return obj.contractCode},
						function(obj){ return '<a href="javascript:void 0" onClick="editOrderInfo('+ obj.orderId +')">' + obj.orderCode +'</a>'},
//						function(obj){return obj.orderCode},
						function(obj){return obj.customerName},
						function(obj){
							var payDate = obj.payDate==null?"":getFormatDay(obj.payDate+"",'y/m/d');
							return payDate;
							},
						function(obj){return ForDight(obj.moneyPay,2)},
						function(obj){return obj.moneyIn},
						function(obj){return ForDight(obj.moneyPay,2)-obj.moneyIn},
						
				];		
	 }else{
			 cellTable=[
		
						function(obj){return obj.contractCode},
						function(obj){ return '<a href="javascript:void 0" onClick="editOrderInfo('+ obj.orderId +')">' + obj.orderCode +'</a>'},
//						function(obj){return obj.orderCode},
						function(obj){return obj.customerName},
						function(obj){
							var payDate = obj.payDate==null?"":getFormatDay(obj.payDate+"",'y/m/d');
							return payDate;
							},
						function(obj){return ForDight(obj.moneyPay,2)},
						function(obj){return obj.moneyIn},
						function(obj){return ForDight(obj.moneyPay,2)-obj.moneyIn},
						
				];	
	 }		
				
				
		
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

PayMent.prototype.getContractPaymentAnothers = function(OBJ,carrierId){
    
    function getCountFun(size){
    	OBJ.page.size = size;
    	OBJ.page.MakePageNav(OBJ.page.pageIndex);
    }
    if (OBJ.page.pageSize > 0){
		this.getCountByIdList(this.obj,carrierId,getCountFun);
		ContractPaymentManager.getContractPaymentsPageByMap(this.obj,carrierId,OBJ.page.pageIndex-1,OBJ.page.pageSize,this.fillTalbeF);
    }else{
		ContractPaymentManager.getContractPayments(this.obj,this.fillTalbeF);	
    }
}
   
	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
PayMent.prototype.fillTalbeF = function(objs){
	var OBJ = this;
	var tBody  = payment.tBody;
	var color1 = payment.color1;
	var color2 = payment.color2;
	var withResourceSort = obj.withResourceSort ==1;
	
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("orderId", rowData.orderId);
		 	row.setAttribute("contractId", rowData.contractId);
		 	
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
		 	row.setAttribute("memo", rowData.memo);
		 	row.setAttribute("resourceTypeId", rowData.resourceTypeId);
		 	
		 	row.rowData = rowData;
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			
			var e = event || window.event;
			var editImg = Event.element(e); 
			var tr1= editImg.parentNode.parentNode;
			var id = tr1.getAttribute("paraId");
			
//			var incomePurposeId = tr1.getAttribute("incomePurposeId");
			
			var editRow = $(OBJ.IdPrefix + id);
			
//			editRow.tvNameParam = tvNameParam;
//			editRow.orderMainType = orderMainType;
			
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
		var cellTable=[];
		
		
		if(withResourceSort){
			cellTable=[
//						function(obj){return obj.memo;},
						function(obj){
							$("resourceType").value = obj.resourceTypeId;
						  	var selectedIndex = $("resourceType").selectedIndex;
						  	var gg =$("resourceType").options[selectedIndex].text;
						  	return gg;
							
							//return obj.memo;
							
							},
						function(obj){ return makeInputText(OBJ.checkBoxName,"checkbox",obj.id)},
						function(obj){return obj.orderCode;},
						function(obj){return obj.contractCode},
						function(obj){return obj.payNumber;},
						function(obj){
							var payDate = getFormatDay(obj.payDate+"",'y/m/d');
							return payDate;
							},
						function(obj){return obj.incomePurpose.name},
						function(obj){return ForDight(obj.moneyPay,2)},
						function(obj){return obj.moneyIn},
//					    function(obj) {
//					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return editImg;}, 
//					    function(obj) {
//							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delePayment");
////							if(OBJ.enableDel) deleImg.onclick = del;
//					    	return deleImg;} 
				];	
		}else{
			cellTable=[
						function(obj){ return makeInputText(OBJ.checkBoxName,"checkbox",obj.id)},
						function(obj){return obj.orderCode;},
						function(obj){return obj.contractCode},
						function(obj){return obj.payNumber;},
						function(obj){
							var payDate = getFormatDay(obj.payDate+"",'y/m/d');
							return payDate;
							},
						function(obj){return obj.incomePurpose.name},
						function(obj){return ForDight(obj.moneyPay,2)},
						function(obj){return obj.moneyIn},
//					    function(obj) {
//					    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//					    	if(OBJ.enableEdit) editImg.onclick = edit;
//					    	return editImg;}, 
//					    function(obj) {
//							var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",obj.id,"delePayment");
////							if(OBJ.enableDel) deleImg.onclick = del;
//					    	return deleImg;} 
				];	
		}

				
				
				
		
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

PayMent.prototype.getPaymentByCustomer = function(O,func){
	var OBJ = O;
	var obj = OBJ.obj;
	var page = OBJ.page;

    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		ContractPaymentManager.getContractPaymentsPage(obj,page.pageIndex,page.pageSize,func);
    }else{
		ContractPaymentManager.getContractPayments(obj,OBJ.fillTalbeCus);	
    }
}

PayMent.prototype.fillTalbeCus = function(objs){
	var OBJ = this;
	var tBody  = payment.tBody;
	var color1 = payment.color1;
	var color2 = payment.color2;
	var withResourceSort = obj.withResourceSort ==1;	
	
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("contractId", rowData.contractId);
		 	row.setAttribute("orderId", rowData.orderId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
		 	row.setAttribute("memo", rowData.memo);
		 	row.setAttribute("resourceTypeId", rowData.resourceTypeId);
		 	
		 }	
		 
		//编辑图标的触发的事件
		function edit(event){
			
			var e = event || window.event;
			var editImg = Event.element(e); 
			var tr1= editImg.parentNode.parentNode;
			var id = tr1.getAttribute("paraId");
			
//			var incomePurposeId = tr1.getAttribute("incomePurposeId");
			
			var editRow = $(OBJ.IdPrefix + id);
			
//			editRow.tvNameParam = tvNameParam;
//			editRow.orderMainType = orderMainType;
			
			
			
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

				
		var cellTable=[];				
		if(withResourceSort){
				 cellTable=[
//				 				function(obj){return obj.memo;},
							function(obj){
								$("resourceType").value = obj.resourceTypeId;
							  	var selectedIndex = $("resourceType").selectedIndex;
							  	var gg =$("resourceType").options[selectedIndex].text;
							  	return gg;
								
								//return obj.memo;
							
							},
								function(obj){return obj.payNumber;},
								function(obj){return obj.payDate},
								function(obj){return obj.contractId},
								function(obj){return obj.orderId},
								function(obj){return ForDight(obj.moneyPay,2)},
								function(obj){return obj.moneyIn}
						];		
		}else{
				 cellTable=[
								function(obj){return obj.payNumber;},
								function(obj){return obj.payDate},
								function(obj){return obj.contractId},
								function(obj){return obj.orderId},
								function(obj){return ForDight(obj.moneyPay,2)},
								function(obj){return obj.moneyIn}
						];		
		}			
				
		
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
PayMent.prototype.getContractPaymentsAll = function(obj,callBackFun){
	ContractPaymentManager.getContractPayments(obj,callBackFun);	
}

PayMent.prototype.getContractPaymentAutoComplet = function(O,callBackFun){
	ContractPaymentManager.getContractPaymentAutoComplet(O.obj,callBackFun);	
}
PayMent.prototype.getContractPaymentAutoComplets = function(obj,callBackFun){
	ContractPaymentManager.getContractPaymentAutoComplets(obj,callBackFun);	
}

PayMent.prototype.savePayMentCallBackFun = function(OBJ,callBackFun){
	var obj =  OBJ.obj;
	ContractPaymentManager.saveContractPayment(obj,saveFun);
	function saveFun(newId){
		callBackFun(newId);
	}
}


/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
PayMent.prototype.savePayMent = function(o,mode){
	var OBJ = payment;
	var obj =  o;
	var id=obj.id;
	var ver = obj.version;
	var paydt= obj.payDate;
	
	if(paydt.length>8){
		var y =  paydt.substring(0,4);
		var m =  paydt.substring(5,7);
		var d =  paydt.substring(8,10);
		paydt = y +  m +  d;
		}

	$("hiddenArea").appendChild($("incomePurposeId"));	
	$("hiddenArea2").appendChild($("resourceType"));	

	DWRUtil.getValues(obj);
	obj.id = id;
	obj.version = ver;
	obj.payDate = paydt; 
//	obj.memo = $("resourceType").value;
	obj.resourceTypeId = $("resourceType").value;
	
	
//	alert(id);
	
//	alert(obj.memo);
	

//	obj.contractId = $("contractId").value;
	if (mode == 'new')obj.id = null;
	
	DWREngine.setAsync(false);
		//alert(obj.version);
	ContractPaymentManager.saveContractPayment(obj,saveFun);
	DWREngine.setAsync(true);
	
	function saveFun(newId){
		OBJ.reset();
		id = newId;
//		OBJ.getContractPayments();
	}
	return id;
}
/* 删除
 * 根据id删除对象
 */
PayMent.prototype.removePayMent = function(id,delRow){
	var OBJ = this;
	var page = payment.page;
	var curRow = payment.tBody.rows.length;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SavePayment')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	ContractPaymentManager.removeContractPayment(id,removeFun);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getContractPayments();
   }
}

PayMent.prototype.removePayMentNum = function(id,delRow,ordId){
	var OBJ = this;
	var page = payment.page;
	var curRow = payment.tBody.rows.length;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SavePayment')) return false;
	
	if(!confirmDelete(OBJ.className)) return false;
	delRow.remove();  //ie不能用 delRow.remove();
	curRow--;
	
	DWREngine.setAsync(false);
	ContractPaymentManager.removeContractPayment(id,removeFun);	
	DWREngine.setAsync(true);
	
	function removeFun(){
		ContractPaymentManager.updateNamberPayment(ordId);
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getContractPayments();
   }
}

/* 总记录数
 * 
 */
PayMent.prototype.getCount = function(obj){
	var count;
	DWREngine.setAsync(false);
	ContractPaymentManager.getContractPaymentsCount(obj,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

PayMent.prototype.getCountByIdList = function(obj,carrierId,callbackFun){
	ContractPaymentManager.getContractPaymentCountByMap(obj,carrierId,getCountFun);	
	function getCountFun(size){ 
		callbackFun(size);
	}
}
/* 添加新行 编辑或删除 
 * 
 */
PayMent.prototype.addNewRow = function(mode,editRow){
//alert(editRow);
    var OBJ = this;
	var page = this.page;
	var tBody = this.tBody;
	var obj = this.obj;
	obj.payDate = config_serviceDate;
	
	
	var withResourceSort = obj.withResourceSort ==1;	
	
	if (!checkEeitState('btn_SavePayment')) return false;
	
//	var tvNameParam = editRow.tvNameParam;
//	var orderMainType = editRow.orderMainType;

	
	function getRowDataInObj(editRow){	
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.payNumber = editRow.getAttribute("payNumber");
	 	obj.payDate = editRow.getAttribute("payDate");
	 	obj.incomePurposeId = editRow.getAttribute("incomePurposeId");
	 	obj.moneyPay = editRow.getAttribute("moneyPay");
	 	obj.moneyIn = editRow.getAttribute("moneyIn");
//	 	obj.memo = editRow.getAttribute("memo");
	 	obj.resourceTypeId = editRow.getAttribute("resourceTypeId");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
		
		
		DWRUtil.getValues(obj);
		obj.id = id;
		obj.payDate = getFormatDay(obj.payDate,'ymd'); 
//		obj.memo = $("resourceType").value;
		obj.resourceTypeId = $("resourceTypeId").value;
		OBJ.savePayMent(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 $("hiddenArea").appendChild($("incomePurposeId"));
		 $("hiddenArea2").appendChild($("resourceType"));
		 OBJ.getContractPayments();
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
	
	if(withResourceSort){
//		if(tvNameParam == 'xmtv'){
//		cell[j++] =  makeInputTextTd3("memo","text","10px",obj.memo,"");
		if(mode =='new') $("resourceType").value = 0;
		cell[j++] =  makeTdByObj($("resourceType"));
//		alert($("resourceType"));
		
	}
		
	var saveImgTd = makeImagTd("image/save.png","btn_SavePayment","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelPayment","18","18",0,"");
	
	cannelImgTd.onclick = function(){
    	$("hiddenArea").appendChild($("incomePurposeId"));
    	$("hiddenArea2").appendChild($("resourceType"));
	    newRow.remove(); 
    	setColors(tBody,this.color1,this.color2);
    }
    //获得序号
    var  number = tBody.rows.length + 1;
	if(mode =='new'){
		cell[j++] =  makeInputTextTd3("payNumber","text","10px",number,"");
	}else{
		cell[j++] =  makeInputTextTd3("payNumber","text","10px",obj.payNumber,"");
	}
	
//	cell[j++] =  makeDateInputTextHmtl("payDate","anchorWStart",obj.payDate,"button_showdate_input_edit");
//	  td3.innerHTML = makeDateInputTextHmtl("beginDate","anchorWStart",curDate,"button_showdate_input_edit").innerHTML;
	cell[j++] =  makeInputTextTd3("payDate","text","10px",getFormatDay(obj.payDate+"",'y/m/d'),"");
//	$("incomePurposeId").setAttribute("style","overflow: visible; width:100%;");
	cell[j++] =  makeTdByObj($("incomePurposeId"));
	cell[j++] =  makeInputTextTd3Money("moneyPay","text","10px",ForDight(obj.moneyPay,2),"");
	cell[j++] =  makeTextTd(obj.moneyIn);
//	cell[j++] =  makeInputTextTd("moneyIn","text","10px",obj.moneyIn,"");
	cell[j++] =  saveImgTd;
	cell[j++] =  cannelImgTd;


    
	for (var i = 0;i < cell.length;i++ ){
		newRow.appendChild(cell[i]);
	}

	container.appendChild(newRow);
	
//	alert(editRow.obj);

	
//	alert(newRow.obj);
//////////////////构造新行 end ///////////////////

	
	//编辑状态：追加新行，删除旧行	
	if(mode =='edit'){
		new Insertion.After(editRow,container.innerHTML);
		
		var new_row = $(obj.id);
		
		new_row.obj = editRow.obj;
//		alert(new_row.obj);
		editRow.remove();
		$("incomePurposeId").value = obj.incomePurposeId;	
//		$("resourceType").value = obj.memo;	
		$("resourceType").value = obj.resourceTypeId;	
		
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
//		$("incomePurposeId").value = "";
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SavePayment = $("btn_SavePayment"); btn_SavePayment.onclick = savePayment;
	var btn_CannelPayment = $("btn_CannelPayment"); btn_CannelPayment.onclick = cannelPayment;	
	
	if(mode =='edit'){
		btn_SavePayment.setAttribute("mode","edit")
	}else{
		btn_SavePayment.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
	    this.getDate();
}

PayMent.prototype.getDate = function(){
//	alert(0);
					Calendar.setup({
						inputField  : "payDate",	  // id of the input field
						//ifFormat	: "%Y%m%d",	  // the date format
						singleClick	  : true,
						button	  : "payDate"	// id of the button
					});
}

PayMent.prototype.updateMoneyIn = function(objs,incomeMoney,func){
//		alert(9999);
	ContractPaymentManager.updateContractPaymentMoneyIn(objs,incomeMoney,func);
}	

PayMent.prototype.returnContractPaymentMoneyIn = function(payMentIds,incomeId,func){
		
	ContractPaymentManager.returnContractPaymentMoneyIn(payMentIds,incomeId,func);
}

PayMent.prototype.getPaymentsByIncomeUsedList = function(pullId,carrierId){
	var OBJ = this;
	
	
//	var OBJ    = o;
	var obj    = OBJ.obj;
	var page   = OBJ.page;

    if (page.pageSize > 0){
		var size = this.getBackCountByIdList(pullId,carrierId);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		//DWREngine.setAsync(false);
		ContractPaymentManager.getPaymentsByIncomeUsedAndCarrierIdList(pullId,carrierId,page.pageIndex-1,page.pageSize,OBJ.fillTalbeF);
		//DWREngine.setAsync(true);
    }else{
		ContractPaymentManager.getContractPayments(obj,OBJ.fillTalbeF);	
    }
	
}
	
PayMent.prototype.getBackCountByIdList = function(pullId,carrierId){
	var count;
	DWREngine.setAsync(false);
	ContractPaymentManager.getContractPaymentBackCountByCarrierId(pullId,carrierId,getCountFun);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
	
PayMent.prototype.getMoneyPayByOrderId = function(orderId,func){
	ContractPaymentManager.getMoneyPayByOrderId(orderId,func);
}	

PayMent.prototype.saveContractPaymentByOrder = function(mode,contractId,orderId,customerId,payMoney,isNew,categroyName,year,func){
//	alert(orderId);
	ContractPaymentManager.saveContractPaymentByOrder(mode,contractId,orderId,customerId,payMoney,isNew,categroyName,year,func);
}

PayMent.prototype.saveCuiKuanByNortomOrder = function(modle, isMid, paymentId,orderId, customerId, year,clear,func){

	ContractPaymentManager.saveCuiKuanByNortomOrder(modle, isMid, paymentId,orderId, customerId, year,clear,func);
}

PayMent.prototype.getContractPaymentXML = function(o,callbackFun){
	ContractPaymentManager.getContractPaymentXML(o,callbackFun);
}
//分页处理
PayMent.prototype.getContractPaymentPageXML = function(obj,type,callBackFun){
	 var obj = obj;
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){
				page.size = size;
				if(type==1){
					page.pageIndex=1;
				}
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ContractPaymentManager.getContractPaymentPageXML(obj,page.pageIndex-1,page.pageSize,callBackFun);
			}
			ContractPaymentManager.getContractPaymentCountXML(obj,getCountFun);	
	    }else{
			ContractPaymentManager.getContractPaymentXML(obj,callBackFun);	
	    }
	
}







PayMent.prototype.getContractPaymentFormXml = function(year,loginUser,userName,resourceName,customerName,callBackFun){
	ContractPaymentManager.getContractPaymentFormXml(year,loginUser,userName,resourceName,customerName,callBackFun);
}

PayMent.prototype.saveContractPaymentVersion = function(o,callbackFun){
	ContractPaymentManager.saveContractPaymentVersion(o,callbackFun);
}

PayMent.prototype.getPaymentListXML = function(obj,callBackFun){
	ContractPaymentManager.getPaymentListXML(obj,callBackFun);	
}


PayMent.prototype.savePuton_months = function(querStrs,callbackFun){
	ContractPaymentManager.savePutonMonths(querStrs,callbackFun);
}

PayMent.prototype.saveBack_months = function(querStrs,callbackFun){
	ContractPaymentManager.saveBackPutonMonths(querStrs,callbackFun);
}




	