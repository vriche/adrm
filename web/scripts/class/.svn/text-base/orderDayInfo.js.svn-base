

function OrderDayInfo(){
	//创建对象
	this.obj ={
		needCal:null,
		contractId:null,
		paymentId:null,
		orderId:null,
	    orderDetailId:null,
	    publishDate:null,
	    adlength:null,
	    dayStandardPrice:null,
	    dayRelIncome:null,
	    dayRelPuton:null,
		adDayTimes:null,
		needPublish:null,
		totalTime:null,
	    resourceSpecific:null,
	    isPublished:null,
	    customerId:null,
	    linkUserId:null,
		id:null,
	    version:null,
		dayInfo:null
		
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
	this.carrierIds=null;
	this.resourceIds=null;
	this.toaccountTotal=null;
	this.pageInfo =""
	this.pageSize ="20"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;		

}

//清空对象
OrderDayInfo.prototype.reset = function(){
	this.obj.needCal = null;
	this.obj.contractId = null;
	this.obj.paymentId = null;
  	this.obj.orderId = null;
  	this.obj.orderDetailId = null;
  	this.obj.publishDate = null;
  	this.obj.adlength = null;
  	this.obj.dayStandardPrice = null;
	this.obj.dayRelIncome = null;
	this.obj.dayRelPuton = null;
  	this.obj.adDayTimes = null;  	

  	this.obj.resourceSpecific = null;
  	this.obj.isPublished = null;
  	this.obj.customerId = null;
  	this.obj.linkUserId = null;
  	this.obj.needPublish = null;
  	
	this.obj.id = null;
  	this.obj.version = null;
  	
  	this.obj.dayInfo = null;
  	
  	this.obj.customerName =null;
  	this.obj.dayRelIncome =null;
  	this.obj.totalTime =null;
  	
}

OrderDayInfo.prototype.getMonthInfos = function(orderDetailId,startDate,endDate,resourceId,specific,func){
//	var objs;
//	DWREngine.setAsync(false);
	OrderDayInfoManager.getMonthInfosByParameter(func,orderDetailId,startDate,endDate,resourceId,specific);
//	DWREngine.setAsync(true);
//	
//	function fillFun(o){
//		objs =  o;
//	}
//	return objs;
}


OrderDayInfo.prototype.getOrderDayByDayInfoArray = function(monthInfos){
	
        var orderDayInfos = new Array();
        
        for(var i = 0;i< monthInfos.length;i++){
        	
        	var days = monthInfos[i].days;
        	
        	if(Object.isArray(days)){
				for(var j = 0;j< days.length;j++){
				    
		            var dayInfoArray = days[j];
		            
		            var adDayTimes = dayInfoArray.adTimes;
		            
		            if(adDayTimes > 0){
		            	
			        	var res_Day_Info = (new DayInfo()).obj;
			
						res_Day_Info.resourceId = dayInfoArray.resourceId;
				        res_Day_Info.id = dayInfoArray.resourceDayId;
				        res_Day_Info.used = dayInfoArray.rsUsedTime;  
						res_Day_Info.specific = dayInfoArray.rsSpecific;
						res_Day_Info.modifyTime = dayInfoArray.rsModifyTime;
						
//						alert(dayInfoArray.modifyTime)

			
			          	var order_Day_Info = (new OrderDayInfo()).obj; 
			          	    	
			        	order_Day_Info.id = dayInfoArray.adDayInfoId;
			        	order_Day_Info.publishDate = dayInfoArray.dayDate;
			        	order_Day_Info.orderDetailId = dayInfoArray.adOrderDetailId;
			        	order_Day_Info.adlength = dayInfoArray.adLength;
			        	order_Day_Info.adDayTimes = dayInfoArray.adTimes;
//			        	order_Day_Info.adSumTimes = dayInfoArray.adUsedTime;
			        	order_Day_Info.rsModifyTime = dayInfoArray.rsModifyTime;
			        	order_Day_Info.rsSpecific = dayInfoArray.rsSpecific;
//			        	order_Day_Info.rsUsed = dayInfoArray.rsUsedTime;  

			        	order_Day_Info.resourceSpecific = dayInfoArray.adSpecific;
			        	order_Day_Info.dayRelIncome = dayInfoArray.dayRelIncome;
			        	order_Day_Info.dayRelPuton = dayInfoArray.dayRelPuton;
			        	
//			        	alert(order_Day_Info.dayRelPuton)

			        	order_Day_Info.isPublished = 0;
			        	order_Day_Info.version = dayInfoArray.version;
			        	
			        	
			        	order_Day_Info.dayInfo = res_Day_Info;
			        	
			        	orderDayInfos.push(order_Day_Info);
		            }
		

				}
        	}

        }
        
	  return orderDayInfos;
}

OrderDayInfo.prototype.saveOrderDayInfos = function(o,func){

	OrderDayInfoManager.saveOrderDayInfos(o,func);
}

OrderDayInfo.prototype.saveOrderDayInfo = function(o,func){
//    DWREngine.setAsync(false);
	OrderDayInfoManager.saveOrderDayInfo(o,saveFun);
//	DWREngine.setAsync(true);
	function saveFun(){}

}

OrderDayInfo.prototype.getAllMonthInfos = function(o,func){
	
	OrderDayInfoManager.getOrderDayInfos(func,o);
	
}

OrderDayInfo.prototype.getOrderDayInfosArray = function(o,func){
	OrderDayInfoManager.getOrderDayInfosArray(o,func);
}



OrderDayInfo.prototype.getOrderDayInfosXML = function(obj,userId,carrierName,customerId,channelModelParam,theUser,func){
	OrderDayInfoManager.getOrderDayInfosPageXML(obj,userId,carrierName,customerId,channelModelParam,theUser,func);	
}

OrderDayInfo.prototype.getOrderDayInfos = function(O,userId,carrierName,customerId,channelModelParam){
	
	var OBJ    = O;
	var obj    = OBJ.obj;
	var page   = OBJ.page;
	var tBody  = OBJ.tBody;
	var color1 = OBJ.color1;
	var color2 = OBJ.color2;
	

	OrderDayInfoManager.getOrderDayInfosPage(fillTalbe,O.startDate,O.endDate,userId,carrierName,customerId,channelModelParam);

	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
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
						function(obj){return obj.adlength},
						function(obj){return obj.customer.customerName},
						function(obj){return obj.dayRelIncome},
						function(obj){return obj.dayRelPuton},
						function(obj){return obj.adSumTimes},
						function(obj){return obj.dayRelIncome-obj.dayRelPuton},
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
}
OrderDayInfo.prototype.getCount = function(obj1,obj2){
	var count;
	DWREngine.setAsync(false);
	OrderDayInfoManager.getOrderDayInfoCount(getCountFun,obj1,obj2);	

    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
	
	return count;
}
//OrderDayInfo.prototype.getCustomerByYear = function(func,year,customerIds,userId,carrierName,channelModelParam,theUser){
//		OrderDayInfoManager.getCustomerByYearPage(func,year,customerIds,userId,carrierName,channelModelParam,theUser);
//}

OrderDayInfo.prototype.getCustomerByYearXML = function(func,obj,year,customerIds,userId,carrierName,channelModelParam,theUser){
		OrderDayInfoManager.getCustomerByYearPageXML(func,obj,year,customerIds,userId,carrierName,channelModelParam,theUser);
}

OrderDayInfo.prototype.getCustomerByQuarter = function(func,year,customerIds,userId,carrierName,channelModelParam){
		OrderDayInfoManager.getCustomerByQuarterPage(func,year,customerIds,userId,carrierName,channelModelParam);
}

OrderDayInfo.prototype.getCarrierByDateXML = function(startDate,endDate,carrierIds,userId,userName,isPrint,orderSubCategorys,func){
		OrderDayInfoManager.getCarrierByDateXML(startDate,endDate,carrierIds,userId,userName,isPrint,orderSubCategorys,func);
}

OrderDayInfo.prototype.getResourceListByDateXML = function(startDate,endDate,resourceIds,userId,userName,isPrint,orderSubCategorys,weekStr,func){
		OrderDayInfoManager.getResourceListByDateXML(startDate,endDate,resourceIds,userId,userName,isPrint,orderSubCategorys,weekStr,func);
}
OrderDayInfo.prototype.getAudienceListByDateXML = function(startDate,endDate,resourceIds,userId,userName,isPrint,func){
		OrderDayInfoManager.getAudienceListByDateXML(startDate,endDate,resourceIds,userId,userName,isPrint,func);
}			

OrderDayInfo.prototype.getBusinessAnalyzePagesXML = function(func,obj,userId,carrierName,isPutOnORIncome,channelModelParam){
	OrderDayInfoManager.getBusinessAnalyzePagesXML(obj,userId,carrierName,isPutOnORIncome,channelModelParam,func);
}

OrderDayInfo.prototype.getBusinessAnalyzePages = function(O,userId,carrierName,isPutOnORIncome,channelModelParam){
	
	var OBJ    = O;
	var obj    = OBJ.obj;
	var page   = OBJ.page;
	var tBody  = OBJ.tBody;
	var color1 = OBJ.color1;
	var color2 = OBJ.color2;
	
//	var startDate=$("startDate").value;
//	var endDate=$("endDate").value;
//	
//	alert("开始shijian"+tBody);
    if (page.pageSize > 0){
		var size = this.getBusinessCount(OBJ.startDate,OBJ.endDate,userId,carrierName,channelModelParam);
		page.size = size;
		page.MakePageNav(page.pageIndex);
			OrderDayInfoManager.getBusinessInfos(fillTalbe,O.startDate,O.endDate,userId,carrierName,isPutOnORIncome,channelModelParam);
    }else{

		//OrderDayInfoManager.getContractPayments(fillTalbe,obj);	
    }


   
	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
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
						function(obj){return obj.businessFullName},

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
}




OrderDayInfo.prototype.getBusinessCount = function(startDate,endDate,userId,carrierName,channelModelParam){
	var count;
	DWREngine.setAsync(false);
	OrderDayInfoManager.getBusinessCount(getCountFun,startDate,endDate,userId,carrierName,channelModelParam);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}


OrderDayInfo.prototype.getCarrierByDate = function(O,userId,userName,isPrint){

	var OBJ    = O;
	var obj    = OBJ.obj;
	var page   = OBJ.page;
	var tBody  = OBJ.tBody;
	var color1 = OBJ.color1;
	var color2 = OBJ.color2;
	

    if (page.pageSize > 0){
    	
		var size = this.getCarrierScopeCount(OBJ.startDate,OBJ.endDate,OBJ.carrierIds,userId,userName,isPrint);
		//alert("kaishi shijian"+OBJ.startDate);
		page.size = size;
		page.MakePageNav(page.pageIndex);
		OrderDayInfoManager.getCarrierByDate(fillTalbe,OBJ.startDate,OBJ.endDate,OBJ.carrierIds,userId,userName,isPrint);
    }else{


		//OrderDayInfoManager.getContractPayments(fillTalbe,obj);	
    }

   
	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
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
					function(obj){return obj.carrier.carrierName},
					function(obj){return obj.dayRelIncome},
					function(obj){return obj.dayRelPuton},
					function(obj){return obj.adSumTimes},
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
}
OrderDayInfo.prototype.getCarrierScopeCount = function(startDate,endDate,carrierIds,userId,userName,isPrint){
	var count;
	DWREngine.setAsync(false);
	OrderDayInfoManager.getCarrierScopeCount(getCountFun,startDate,endDate,carrierIds,userId,userName,isPrint);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}



OrderDayInfo.prototype.getAllYearCarrierXML = function(OBJ,userId,userName,type,isPrint,callBackFun){
	OrderDayInfoManager.getAllYearCarrierXML(callBackFun,OBJ.year,OBJ.carrierIds,userId,userName,type,isPrint);
}

OrderDayInfo.prototype.getCarrierByYear = function(O,userId,userName,isPrint,func){

	var OBJ    = O;
	var obj    = OBJ.obj;
	var page   = OBJ.page;

    if (page.pageSize > 0){
		var size = this.getCarrierAllCount(OBJ.year,OBJ.carrierIds,userId,userName,isPrint);
			
		page.size = size;
		page.MakePageNav(page.pageIndex);
		OrderDayInfoManager.getAllYearCarrier(func,OBJ.year,OBJ.carrierIds,userId,userName,isPrint);
    }else{

		//OrderDayInfoManager.getContractPayments(fillTalbe,obj);	
    }

}

OrderDayInfo.prototype.fillTable_year = function(objs){
	var OBJ    = this;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("payNumber", rowData.payNumber);
	 	row.setAttribute("payDate", rowData.payDate);
	 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
	 	row.setAttribute("moneyPay", rowData.moneyPay);
	 	row.setAttribute("moneyIn", rowData.moneyIn);
	}	

	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.carrier.carrierName},
			
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

}

OrderDayInfo.prototype.getCarrierAllCount = function(year,carrierIds,userId,userName,isPrint){
	var count;
	DWREngine.setAsync(false);
	OrderDayInfoManager.getAllYearCarrierCount(getCountFun,year,carrierIds,userId,userName,isPrint);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
OrderDayInfo.prototype.getResourceByDate = function(O,userId,userName,isPrint){

	var OBJ    = O;
	var obj    = OBJ.obj;
	var page   = OBJ.page;
	var tBody  = OBJ.tBody;
	var color1 = OBJ.color1;
	var color2 = OBJ.color2;
	
	OrderDayInfoManager.getResourceListByDate(fillTalbe,OBJ.startDate,OBJ.endDate,OBJ.resourceIds,userId,userName,isPrint);

	//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
    function fillTalbe(objs){
		 //把行的数据放到行的属性里
		 //row 是创建的行对象  options是行数据
		 function putRowDataInHidden(row,rowData){
		 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
		 	row.setAttribute("paraId", rowData.id);
		 	row.setAttribute("payNumber", rowData.payNumber);
		 	row.setAttribute("payDate", rowData.payDate);
		 	row.setAttribute("incomePurposeId", rowData.incomePurposeId);
		 	row.setAttribute("moneyPay", rowData.moneyPay);
		 	row.setAttribute("moneyIn", rowData.moneyIn);
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
					function(obj){
						var channel = (obj.toaccountTotal==null)?"":(obj.toaccountTotal);
						return channel+obj.carrier.carrierName},
					function(obj){return obj.resourceSpecific},
					function(obj){return obj.dayRelIncome},
					function(obj){return obj.dayRelPuton},
					function(obj){return obj.adSumTimes},
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
}
