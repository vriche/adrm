function OrderDetailColl(){

	this.obj ={
		advName:null,
		advVer:null,
		tapCode:null,
		carrier:null,
		resource:null,
		specific:null,
		length:null,
		month:null,
		monthSysPrice:null,
		monthTimes:null,
		monthRelPrice:null,
		day1:null,
		day2:null,
		day3:null,
		day4:null,
		day5:null,
		day6:null,
		day7:null,
		day8:null,
		day9:null,
		day10:null,
		day11:null,
		day12:null,
		day13:null,
		day14:null,
		day15:null,
		day16:null,
		day17:null,
		day18:null,
		day19:null,
		day20:null,
		day21:null,
		day22:null,
		day23:null,
		day24:null,
		day25:null,
		day26:null,
		day27:null,
		day28:null,
		day29:null,
		day30:null,
		day31:null
		
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
	
	this.pageInfo = null;
	this.pageSize = null;
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	this.rowNum = 1;

	return this;

}

OrderDetailColl.prototype.reset = function(){
	
		this.obj.advName=null;
		this.obj.advVer=null;
		this.obj.tapCode=null;
		this.obj.carrier=null;
		this.obj.resource=null;
		this.obj.specific=null;
		this.obj.length=null;
		this.obj.month=null;
		this.obj.monthSysPrice=null;
		this.obj.monthTimes=null;
		this.obj.monthRelPrice=null;
		this.obj.day1=null;
		this.obj.day2=null;
		this.obj.day3=null;
		this.obj.day4=null;
		this.obj.day5=null;
		this.obj.day6=null;
		this.obj.day7=null;
		this.obj.day8=null;
		this.obj.day9=null;
		this.obj.day10=null;
		this.obj.day11=null;
		this.obj.day12=null;
		this.obj.day13=null;
		this.obj.day14=null;
		this.obj.day15=null;
		this.obj.day16=null;
		this.obj.day17=null;
		this.obj.day18=null;
		this.obj.day19=null;
		this.obj.day20=null;
		this.obj.day21=null;
		this.obj.day22=null;
		this.obj.day23=null;
		this.obj.day24=null;
		this.obj.day25=null;
		this.obj.day26=null;
		this.obj.day27=null;
		this.obj.day28=null;
		this.obj.day29=null;
		this.obj.day30=null;
		this.obj.day31=null;
	
}


OrderDetailColl.prototype.getOrderDetailXml = function(orgId,orderId,callBackFun){
	OrderDetailManager.getOrderDetailXml(orgId,orderId,callBackFun);
	function setFun(treeGridXML){ callBackFun(treeGridXML);} 
}

OrderDetailColl.prototype.saveOrderDetailCheckState = function(orderId,orderDetailIds,state,sumCount,passCount,callBackFun){
	OrderDetailManager.saveOrderDetailCheckState(orderId,orderDetailIds,state,sumCount,passCount,callBackFun);
}



//OrderDetailColl.prototype.fillTable = function(objs){
//	var OBJ = orderDetailColl;
//	var obj = OBJ.obj;
//	var tBody  = orderDetailColl.tBody;
//	var color1 = orderDetailColl.color1;
//	var color2 = orderDetailColl.color2;
////	OBJ.rowNum =(OBJ.page.pageIndex-1)*OBJ.page.pageSize*1+1;
//	
//	
//	 //把行的数据放到行的属性里
//	 //row 是创建的行对象  options是行数据
//	 function putRowDataInHidden(row,rowData){
//	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
//	 	row.setAttribute("paraId", rowData.id);
////	 	row.setAttribute("publishMemo", rowData.publishMemo);
////	 	row.setAttribute("resourceInfoId", rowData.resourceInfoId);
////	 	row.setAttribute("version", rowData.version);
////	 	row.setAttribute("matterLength", rowData.matterLength);
////	 	row.setAttribute("publishStartDate", rowData.publishStartDate);
////	 	row.setAttribute("publishEndDate", rowData.publishEndDate);
////	 	row.setAttribute("sumTimes", rowData.sumTimes);
//	 	
//	 	row.setAttribute("rowData", rowData);
//	 	row.rowData = rowData;
//	 }	
//	 
//	//编辑图标的触发的事件
//	
//	 
//	 
//	
//	//一行中，各单元格返回的内容
//	var cellTable=[			
//					function(obj){return obj.advName},
//					function(obj){return obj.tapCode},
//					function(obj){return obj.carrier},
//					function(obj){return obj.resource},
//					function(obj){return obj.specific},
//					function(obj){return obj.length},
//					function(obj){return obj.month},
//					function(obj){return obj.day1},
//					function(obj){return obj.day2},
//					function(obj){return obj.day3},
//					function(obj){return obj.day4},
//					function(obj){return obj.day5},
//					function(obj){return obj.day6},
//					function(obj){return obj.day7},
//					function(obj){return obj.day8},
//					function(obj){return obj.day9},
//					function(obj){return obj.day10},
//					function(obj){return obj.day11},
//					function(obj){return obj.day12},
//					function(obj){return obj.day13},
//					function(obj){return obj.day14},
//					function(obj){return obj.day15},
//					function(obj){return obj.day16},
//					function(obj){return obj.day17},
//					function(obj){return obj.day18},
//					function(obj){return obj.day19},
//					function(obj){return obj.day20},
//					function(obj){return obj.day21},
//					function(obj){return obj.day22},
//					function(obj){return obj.day23},
//					function(obj){return obj.day24},
//					function(obj){return obj.day25},
//					function(obj){return obj.day26},
//					function(obj){return obj.day27},
//					function(obj){return obj.day28},
//					function(obj){return obj.day29},
//					function(obj){return obj.day30},
//					function(obj){return obj.day31},
//					function(obj){return obj.monthTimes}
//
//			];	
//	
//	//先删除 tbody		
//	DWRUtil.removeAllRows(tBody);
//	//再重新构造新的表
//
//	DWRUtil.addRows(tBody,objs,cellTable,{
//				rowCreator:function(options) { 
//						   var row = document.createElement("tr");
//						   var rowIndex = options.rowIndex;			
//						   row.setAttribute("onclick","javascript:changeColor("+ rowIndex +")");
//				           putRowDataInHidden(row,options.rowData);
//						   return row;  
//					  },  
//					  
//				cellCreator:function(options) {  
//						    var td = document.createElement("td"); 
//						    return td;  
//					  }  
//				});
//				
////	DWRUtil.addRows(tBody,objs,cellTable,{
////				rowCreator:function(options) {  
////						   var row = document.createElement("tr");
////						   var rowIndex = options.rowIndex;			
////						     
////						   row.setAttribute("detailRowId",options.rowData.id);
//////						   row.setAttribute("onclick","javascript:"getOrderDetail(this)");
////						   row.setAttribute("onclick","javascript:getOrderDetail("+ options.rowData.id +")");
//////						   row.setAttribute("ondblclick","javascript:getOrderDetailCompages(this)");
//////					       row.onmousedown = OBJ.orderDetailMouseDown;							    
////				           putRowDataInHidden(row,options.rowData);
////						   return row;  
////					  },  
////					  
////				cellCreator:function(options) {  
////						    var td = document.createElement("td"); 
////						    td.style.cssText = "cursor: pointer;";	 
////						    return td;  
////					  }  
////				});
//	setColors(tBody, color1, color2);
//}

