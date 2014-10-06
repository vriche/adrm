
function IncomeUsed(){

	this.obj = {
		incomeId:null,
	    incomePullId:null,
	    contractId:null,
	    orderId:null,
	    orderDetailId:null,
	    orderDayInfoId:null,
	    publishDate:null,
	    moneyIn:null,
		 incomeMoney:null,
		 carrierName:null,
		 orderCode:null,
		 incomeDate:null,
		 incomeCode:null,
		 firstName:null,
		 lastName:null,
		 customerName:null,
		 fullName:null,
	    incomePublic:null,
		id:null,
	    version:null,
	    moneyPull:null,
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
IncomeUsed.prototype.reset = function(){
  	this.obj.incomeId = null;
  	this.obj.incomePullId = null;
  	this.obj.contractId = null;
  	this.obj.orderId = null;
  	this.obj.orderDetailId = null;
  	this.obj.orderDayInfoId = null;
  	this.obj.publishDate = null;
  	this.obj.moneyIn = null;
  	this.obj.incomeMoney=null;
	 this.obj.carrierName=null;
	 this.obj.orderCode=null;
	this.obj.incomeDate=null;
	this.obj.incomeCode=null;
	this.obj.firstName=null;
	this.obj.lastName=null;
	 this.obj.customerName=null;
	 this.obj.fullName=null;
  	this.obj.incomePublic=null;
	this.obj.id = null;
  	this.obj.version = null;
  	this.obj.moneyPull = null;
}
IncomeUsed.prototype.usedFillTalbe = function(objs){

	var OBJ = incomeUsed;
	var obj = OBJ.obj;
	var tBody  = incomeUsed.tBody;
	var color1 = incomeUsed.color1;
	var color2 = incomeUsed.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
//	 	row.setAttribute("row",OBJ.IdPrefix + rowData.id);
//	 	row.setAttribute("paraId", rowData.id);
//	 	row.setAttribute("incomeDate", rowData.incomeDate);
//	 	row.setAttribute("incomeCode", rowData.incomeCode);
//	 	row.setAttribute("incomeMoney", rowData.incomeMoney);
//	 	row.setAttribute("customerId", rowData.customerId);
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
//	alert(1);
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.incomePublic.carrierName},
					function(obj){ return obj.incomePublic.incomeMoney},
					function(obj){ return obj.incomePublic.usedMoney},
					

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

IncomeUsed.prototype.getChannelIncomeList = function(start,end,customerId,carrierId,channelModelParam,userName){


	IncomeUsedManager.getChannelIncomeList(this.usedFillTalbe,start,end,customerId,carrierId,channelModelParam,userName);	

}
IncomeUsed.prototype.getIncomeUseds = function(o,func){

	IncomeUsedManager.getIncomeUseds(func,obj);	

}
IncomeUsed.prototype.removeIncomeUsedsByIdList = function(idList){
	
	IncomeUsedManager.removeIncomeUseds(idList);
	
}	
IncomeUsed.prototype.getIncomeDetailList=function(customerId,version){

		IncomeUsedManager.getIncomeDetail(this.fillTalbe,customerId,version);
}


IncomeUsed.prototype.fillTalbe = function(objs){

	var OBJ = incomeUsed;
	var obj = OBJ.obj;
	var tBody  = incomeUsed.tBody;
	var color1 = incomeUsed.color1;
	var color2 = incomeUsed.color2;
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
//	 	row.setAttribute("row",OBJ.IdPrefix + rowData.id);
//	 	row.setAttribute("paraId", rowData.id);
//	 	row.setAttribute("incomeDate", rowData.incomeDate);
//	 	row.setAttribute("incomeCode", rowData.incomeCode);
//	 	row.setAttribute("incomeMoney", rowData.incomeMoney);
//	 	row.setAttribute("customerId", rowData.customerId);
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
//	alert(1);
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return obj.customerName},
					function(obj){ return obj.incomeCode},
					function(obj){ return obj.incomeMoney},
					function(obj){ return obj.incomePublic.carrierName},
					//划帐金额
					function(obj){ return obj.moneyPull},
					function(obj){ return obj.orderCode},
					//分配金额
					function(obj){ return obj.moneyIn},
					function(obj){ 
						var incomeDate = obj.incomeDate==null?"":getFormatDay(obj.incomeDate,'y/m/d');
						return incomeDate;
						},
					
					function(obj){ return obj.contractId},
					function(obj){ return obj.fullName},

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

IncomeUsed.prototype.getIncomeDetailCount = function(customerId){
	var count;
	DWREngine.setAsync(false);
	IncomeUsedManager.getIncomeDetailCount(getCountFun,customerId);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}


IncomeUsed.prototype.getIncomeDetailXML = function(customerId,version,func){
	IncomeUsedManager.getIncomeDetailXML(func,customerId,version);
}

IncomeUsed.prototype.getIncomeChannelXML = function(orgId,start,end,customerId,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,userId,callBackFun){
	IncomeUsedManager.getIncomeChannelXML(orgId,start,end,customerId,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,userId,callBackFun);
}

