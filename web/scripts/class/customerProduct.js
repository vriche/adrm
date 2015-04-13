function CustomerProduct(){
	//创建对象
	this.obj ={
		customerName:null,
		relIncome:null,
		putOn:null,
	    matterName:null,
	    orderCode:null,
	    industryType:null,
	    timeUsed:null,
	    carrierName:null,
	    publishDate:null,
	    resourceName:null,
	    total:null,
	    used:null,
	    dayTimes:null,
	    sumUsed:null,
	    resourceId:null,
	    month:null
	}
	
    this.className = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo =""
	this.pageSize ="4"
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	
	return this;
}

//清空对象
CustomerProduct.prototype.reset = function(){
	this.obj.customerName = null;
  	this.obj.relIncome = null;
  	this.obj.putOn = null;
  	this.obj.matterName = null;
  	this.obj.orderCode = null;
  	this.obj.industryType = null;
  	this.obj.timeUsed = null;
  	this.obj.carrierName = null;
  	this.obj.publishDate = null;
  	this.obj.resourceName = null;
  	this.obj.total = null;
  	this.obj.used = null;
  	this.obj.dayTimes = null;
  	this.obj.sumUsed = null;
  	this.obj.resourceId = null;
  	this.obj.month = null;
}

CustomerProduct.prototype.getResourceLimit61 = function(beginDate,endDate,startTime,endTime,carrierId,customerId,mode,orderBy,callBackFun){
	OrderDayInfoManager.getResourceLimit61(beginDate,endDate,startTime,endTime,carrierId,customerId,mode,orderBy,callBackFun);
}
CustomerProduct.prototype.getTreeGrid = function(type,weekIds,beginDate,endDate,resIds,customerId,mode,orderBy,callBackFun){
	OrderDayInfoManager.getTreeGrid(type,weekIds,beginDate,endDate,resIds,customerId,mode,orderBy,callBackFun);
	//function setFun(treeGridXML){ callBackFun(treeGridXML);} 
}






CustomerProduct.prototype.getResourceByDate = function(beginDate,endDate,resIds,func){
	OrderDayInfoManager.getResourceByDate(func,beginDate,endDate,resIds);
}	

CustomerProduct.prototype.fillTable = function(objs){
	var OBJ = CustomerProduct;
	var obj = OBJ.obj;
	var tBody  = CustomerProduct.tBody;
	var color1 = CustomerProduct.color1;
	var color2 = CustomerProduct.color2;
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("resourceName", rowData.resourceName);
	 	row.setAttribute("publishDate", rowData.publishDate);
	 	row.setAttribute("dayTimes", rowData.dayTimes);
	 	row.setAttribute("total", rowData.total);
	 	row.setAttribute("used", rowData.used);
	 	row.setAttribute("timeUsed", rowData.timeUsed);
	}	

	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.resourceName},
					function(obj){return obj.month},
					
					
					function(obj){return obj.dayTimes[0]},
					function(obj){return obj.dayTimes[1]},
					function(obj){return obj.dayTimes[2]},
					function(obj){return obj.dayTimes[3]},
					function(obj){return obj.dayTimes[4]},
					function(obj){return obj.dayTimes[5]},
					function(obj){return obj.dayTimes[6]},
					function(obj){return obj.dayTimes[7]},
					function(obj){return obj.dayTimes[8]},
					function(obj){return obj.dayTimes[9]},
					function(obj){return obj.dayTimes[10]},
					function(obj){return obj.dayTimes[11]},
					function(obj){return obj.dayTimes[12]},
					function(obj){return obj.dayTimes[13]},
					function(obj){return obj.dayTimes[14]},
					function(obj){return obj.dayTimes[15]},
					function(obj){return obj.dayTimes[16]},
					function(obj){return obj.dayTimes[17]},
					function(obj){return obj.dayTimes[18]},
					function(obj){return obj.dayTimes[19]},
					function(obj){return obj.dayTimes[20]},
					function(obj){return obj.dayTimes[21]},
					function(obj){return obj.dayTimes[22]},
					function(obj){return obj.dayTimes[23]},
					function(obj){return obj.dayTimes[24]},
					function(obj){return obj.dayTimes[25]},
					function(obj){return obj.dayTimes[26]},
					function(obj){return obj.dayTimes[27]},
					function(obj){return obj.dayTimes[28]},
					function(obj){return obj.dayTimes[29]},
					function(obj){return obj.dayTimes[30]},
					
					function(obj){return obj.total},
					function(obj){return obj.sumUsed},
					function(obj){return ForDight((obj.sumUsed*1/obj.total)*100,2)+"%"},	
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


CustomerProduct.prototype.getAdvTypeProductByBeginAndEndDate = function(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint,callBackFun){
	var OBJ    = this;
	var obj    = this.obj;
	var page   = this.page;
	
	if (page.pageSize > 0){
		var size = this.getAdvTypeCount(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint);
		page.size = size;
		page.MakePageNav(page.pageIndex);
	
		OrderDetailManager.getAdvTypeProductByBeginAndEndDate(callBackFun,channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint);	
	}
}

CustomerProduct.prototype.fillTable_AdvType = function (objs){
	var OBJ = this;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("carrierName", rowData.carrierName);
	 	row.setAttribute("matterName", rowData.matterName);
	 	row.setAttribute("relIncome", rowData.relIncome);
	 	row.setAttribute("timeUsed", rowData.timeUsed);
	 	row.setAttribute("orderCode", rowData.orderCode);
	 }	
	 function myFormat1(timeUsed){
	 	timeUsed =timeUsed+"";
	 	var  newTimeUsed=timeUsed.substring(0,4);
	 	return newTimeUsed;
	 }
	//一行中，各单元格返回的内容
	var cellTable=[
				function(obj){return obj.carrierName},
				function(obj){return obj.matterName},
				function(obj){return obj.relIncome},
				function(obj){return myFormat1(obj.timeUsed*100)+"%"},
//				function(obj){return obj.orderCode},
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



CustomerProduct.prototype.getOaTeleExpensesByBeginAndEndDate = function(carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint,callBackFun){
//	var OBJ    = this;
//	var obj    = this.obj;
//	var page   = this.page;
//	
//	if (page.pageSize > 0){
//		var size = this.getOaTeleExpensesCount(carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint);
//		page.size = size;
//		page.MakePageNav(page.pageIndex);
		
		OrderDetailManager.getOaTeleExpensesByBeginAndEndDate(carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint,callBackFun);	
//	}
}
CustomerProduct.prototype.getOaTeleExpensesByBeginAndEndDateXML = function(carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint,callBackFun){
		
		OrderDetailManager.getOaTeleExpensesByBeginAndEndDateXML(carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint,callBackFun);	
//	}
}
CustomerProduct.prototype.getOaTeleExpensesByBeginAndEndDateXML2 = function(queryStr,callBackFun){
		
		OrderDetailManager.getOaTeleExpensesByBeginAndEndDateXML2(queryStr,callBackFun);	
//	}
}


CustomerProduct.prototype.getOaTeleExpensesCount = function(carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint){
	var count;
	
	DWREngine.setAsync(false);
	OrderDetailManager.getCustomerProductCount(getCountFun,carrierIds,channelModelParam,sDate,eDate,userId,userName,isPrint);	
    DWREngine.setAsync(true);
    
	function getCountFun(size){ count =  size;}
	
	return count;
}
CustomerProduct.prototype.getIndustryTypeCount = function(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint){
	var count;
	
	DWREngine.setAsync(false);
	OrderDetailManager.getIndustryTypeProductCount(getCountFun,channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint);	
    DWREngine.setAsync(true);
    
	function getCountFun(size){ count =  size;}
	
	return count;
}
CustomerProduct.prototype.getAdvTypeCount = function(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint){
	var count;
	
	DWREngine.setAsync(false);
	OrderDetailManager.getAdvTypeProductCount(getCountFun,channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint);	
    DWREngine.setAsync(true);
    
	function getCountFun(size){ count =  size;}
	
	return count;
}
CustomerProduct.prototype.fillTable_Customer = function (objs){
	var OBJ = this;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("customerName", rowData.customerName);
	 	row.setAttribute("matterName", rowData.matterName);
	 	row.setAttribute("relIncome", rowData.relIncome);
	 	row.setAttribute("orderCode", rowData.orderCode);
	 }	
	 
	//一行中，各单元格返回的内容
	var cellTable=[
				function(obj){return obj.customerName},
				function(obj){return obj.matterName},
				function(obj){return obj.relIncome},
//				function(obj){return obj.orderCode},
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

CustomerProduct.prototype.getIndustryTypeProductByBeginAndEndDate = function(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint,callBackFun){
//	var OBJ    = this;
//	var obj    = this.obj;
//	var page   = this.page;
//	
//	if (page.pageSize > 0){
//		var size = this.getIndustryTypeCount(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint);
//		page.size = size;
//		page.MakePageNav(page.pageIndex);
	
		OrderDetailManager.getIndustryTypeProductByBeginAndEndDate(callBackFun,channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint);	
//	}
}

CustomerProduct.prototype.getIndustryTypeProductByBeginAndEndDateXML = function(channelModelParam,sDate,eDate,userId,carrierNames,userName,isPrint,callBackFun){

		OrderDetailManager.getIndustryTypeProductByBeginAndEndDateXML(callBackFun,channelModelParam,sDate,eDate,userId,carrierNames,userName,isPrint);	

}
CustomerProduct.prototype.getIndustryTypeProductChannelByBeginAndEndDateXML = function(channelModelParam,sDate,eDate,userId,carrierNames,userName,isPrint,callBackFun){

		OrderDetailManager.getIndustryTypeProductChannelByBeginAndEndDateXML(callBackFun,channelModelParam,sDate,eDate,userId,carrierNames,userName,isPrint);	

}
CustomerProduct.prototype.getIndustryTypeProductTotalBrowser = function(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint,callBackFun){
	var OBJ    = this;
	var obj    = this.obj;
//	OBJ.pageInfo = "pageInfoTotalBrowser";
//	OBJ.pageSize 	= "20";
//	OBJ.page   = new Page(OBJ.pageInfo,OBJ.pageSize);
//	var page   = OBJ.page;
	
//	if (page.pageSize > 0){
//		var size = this.getIndustryTypeCount(sDate,eDate,userId,carrierName,userName,isPrint);
//		alert(size);
//		page.size = size;
//		page.MakePageNav(page.pageIndex);
//	
		OrderDetailManager.getIndustryTypeProductTotalBrowser(callBackFun,channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint);	
//	}
}

//CustomerProduct.prototype.getIndustryTypeProductTotalBrowserXML = function(channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint,callBackFun){
//
//		OrderDetailManager.getIndustryTypeProductTotalBrowserXML(callBackFun,channelModelParam,sDate,eDate,userId,carrierName,userName,isPrint);	
//}


CustomerProduct.prototype.fillTable_IndustryTotalBrowser = function (objs){
	var OBJ = this;
//	var tBody  = this.tBody;
	var tBody  = $("totalBrowserBody");
	var color1 = this.color1;
	var color2 = this.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("industryType", rowData.industryType);
	 	row.setAttribute("matterName", rowData.matterName);
	 	row.setAttribute("relIncome", rowData.relIncome);
	 	row.setAttribute("orderCode", rowData.orderCode);
	 }	
	 
	//一行中，各单元格返回的内容
	var cellTable=[
				function(obj){return obj.industryType},
				function(obj){return obj.relIncome},
				function(obj){return obj.used},
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



CustomerProduct.prototype.fillTable_Industry = function (objs){
	var OBJ = this;
	var tBody  = this.tBody;
	var color1 = this.color1;
	var color2 = this.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("industryType", rowData.industryType);
	 	row.setAttribute("matterName", rowData.matterName);
	 	row.setAttribute("relIncome", rowData.relIncome);
	 	row.setAttribute("orderCode", rowData.orderCode);
	 }	
	 
	//一行中，各单元格返回的内容
	var cellTable=[
				function(obj){return obj.industryType},
				function(obj){return obj.matterName},
				function(obj){return obj.relIncome},
				function(obj){return obj.putOn},
				function(obj){return obj.relIncome-obj.putOn},
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



CustomerProduct.prototype.getTreeGridSum = function(searchString,callBackFun){
	OrderDayInfoManager.getTreeGridSum(searchString,callBackFun);
}



