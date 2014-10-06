//*****************************
//  fillTable    orderDetail
//*****************************
var rowNum = 1;

callOnLoad(init);

function init() {
	DWRUtil.useLoadingMessage();
	update();
	otherFill();
}

//function init() {Element.show('progressMsg');update();}
 

var cellFunctions = [
  	function(orderDetail) { return rowNum++; },
  	function(orderDetail) { return orderDetail.resourceMap[0].resourceName },
 	function(orderDetail) { return orderDetail.matterMap[0].name },
 	function(orderDetail) { return orderDetail.matterMap[0].length },
    function(orderDetail) { return orderDetail.publishStartDate },
  	function(orderDetail) { return orderDetail.publishEndDate },
    function(orderDetail) { return orderDetail.sumTimes },
    function(orderDetail) { return orderDetail.isCkecked },
    function(orderDetail) { return '<img onClick="readOrderDetail('+orderDetail.id+')"" src="image/EDIT.GIF" >';},
    function(orderDetail) { return '<img onClick="deleteOrderDetail('+orderDetail.id+',\''+ rowNum +'\')"" src="image/button_delete.gif" >';}
];

function update(orderDetailId) {
    rowNum = 1;
	var orderId = $("orderId").value;
	if(orderId != ''){
		OrderDetailManager.getOrderDetailByOrderId(fillTable,orderId);
	}
	dest = orderDetailDest;	
	readOrderCategorySub();	
	readResourceInfos();
	
	if(!isUndefined(orderDetailId)){
       $("dtId").value = orderDetailId;
      
       //批处理开始
       //DWREngine.beginBatch();      
       saveOrderDayInfo();
      //批处理结束
      // DWREngine.endBatch();        
          
       alert("合同保存成功！");
    }
    //Effect.Fade('progressMsg');
}

function fillTable(orderDetails) {
	DWRUtil.removeAllRows("orderDetailBody");
	DWRUtil.addRows("orderDetailBody", orderDetails,cellFunctions,
	{  
	  rowCreator:function(options) {  
	    var row = document.createElement("tr");  
	    var rowIndex = options.rowIndex;
	    var index = options.rowIndex * 50;  
	    //alert('rowIndex:'+options.rowIndex);
	    //alert('rowNum:'+options.rowNum);
	    //alert('rowData:'+options.rowData.id);
	    //row.style.color = "rgb(" + index + ",0,0)";  
	    var preColor;
	    row.onmouseover=function(){ preColor = row.style.cssText; row.style.cssText = "background-color:buttonface;";}
	    row.onmouseout=function(){row.style.cssText = preColor;}
	    if(rowIndex%2 == 0) { row.style.cssText="BACKGROUND-COLOR: #ECEFF4"}else{row.style.cssText="BACKGROUND-COLOR: #f5f5f5"}
	    //DWRUtil.alternateRowColors();
	    
	    if(options.rowNum == 0){
	      readOrderDetail(options.rowData.id);
	      //row.style.cssText = "background-color:buttonface;"
	    }
	    
	    row.style.cursor="hand";
	    return row;  
	  },  
	  cellCreator:function(options) {  
	    var td = document.createElement("td");  
	    var index = 255 - (options.rowIndex * 50);  
	    //alert('cellNum:'+options.cellNum);
	    //td.style.backgroundColor = "rgb(" + index + ",255,255)";  
	    //td.style.fontWeight = "bold";  
	    //td.style.cursor="hand";

	    return td;  
	  }  

	});
	
	DWRUtil.setValue("totalRecords",orderDetails.length);
	//$("orderDetailBody").style.visibility = "visible";
	//$("orderDetailBody").style.visibility = "hidden";
}


function deleteOrderDetail(orderDetailId, name) {
 // if (confirm("Are you sure you want to delete " + name + "?"))
  if (confirmDelete('OrderDetail number: ' + name +' ')){
   //OrderDetailManager.removeOrderDetail(update, { id:orderDetailId });
   OrderDetailManager.removeOrderDetail(update, orderDetailId);
   orderDetailDest = clearOrderDetailDest();
   DWRUtil.setValues(orderDetailDest);
   
  }
}


function saveOrder() {
   var orid = $("orderId").value;
   
  // $("alert").style.display = "inline";
   setTimeout("unsubmitFunction();", 1000);
   
   if (orid == ''){
       //DWREngine.setOrdered(true);
	   //DWREngine.beginBatch();
	   //DWREngine.endBatch({async:true});  
	   var o = setOrder();
	   OrderManager.saveOrder(o,saveOrderFun);
   }else{
		saveOrderDetail();
   }  
   
}

function saveOrderDetail(){
	  var dt = DWRUtil.getValues(orderDetailDest);
	  var od = setOrderDetail(dt);
	  OrderDetailManager.saveOrderDetail(od,update);
}

function saveOrderFun(id) {
    //bCancel=false;
	if (id) {
	   $("orderId").value = id;
	   $("dtOrderId").value = id;
	   saveOrderDetail();
	   //alert("合同保存成功！");
	}else {
	  	alert("合同保存失败！");
	}
} 



function unsubmitFunction()
{
   //$("alert").style.display = "none";
}



//******************************
//  public function
//  order Service 
//******************************	

function submitFunction(chose) {
//新签订单
 if (chose == 0) {
    //$("orderDetailBody").style.visibility = "hidden";
    DWRUtil.removeAllRows("orderDetailBody");
	DWRUtil.addRows("orderDetailBody");
	
	order = resetOrder();
    DWRUtil.setValues(order);
    orderDetailDest = clearOrderDetailDest();
    DWRUtil.setValues(orderDetailDest);

//增加播出
  }else{
    orderDetailDest = clearOrderDetailDest();
    DWRUtil.setValues(orderDetailDest);
  }
  
  //初试化月播出排期表
  //initMonthInfo();
  
  //删除广告排期表
  DWRUtil.removeAllRows("monthInfosBody");
    
}


function readOrderDetail(id) {
 OrderDetailManager.getOrderDetail(orderDetailFillForm,id);
}

function orderDetailFillForm(ret) {
    dest = setDest(ret);
    SelectListManager.getResourceInfoMap(resourceInfoFillForm,ret.carrierId);
    readOrderCategorySub();
    DWRUtil.setValues(dest);
    //读取月信息
    readMonthInfo(ret);
}



function readResourcePrice(){}

function readSpeRate(){}


function readOrderCategorySub(){
  SelectListManager.getOrderCategoryLevelSecondMap(categoryFillForm,DWRUtil.getValue("orderCategoryMain"));
}

function readResourceInfos(){
    SelectListManager.getResourceInfoMap(resourceInfoFillForm,$("dtCarrierId").value);
}


//根据载体读取位置信息
function resourceInfoFillForm(resourceInfoMap){
  var sel = dest.dtResourceInfoId;
  DWRUtil.removeAllOptions("dtResourceInfoId");
  DWRUtil.addOptions("dtResourceInfoId", resourceInfoMap);
  DWRUtil.setValue("dtResourceInfoId", sel);
  
  //初始化排期
  //initMonthInfo();
}

//根据第一级读取二级信息
function categoryFillForm(categorySub) {
  var sel = dest.dtOrderCategoryId;
  DWRUtil.removeAllOptions("dtOrderCategoryId");
  DWRUtil.addOptions("dtOrderCategoryId", categorySub);
  DWRUtil.setValue("dtOrderCategoryId", sel);
}



//******************************
//  define obj
//******************************
 
var order = 
	{
	orderCode:"", 					//orderCode
	relationCode:"",				//orderRelationCode
	categoryId:0, 					//orderCategoryMain
	orderMeno:"", 					//orderMeno
	publishMemo:"", 				//orderPublishMemo
	userId:0,						//orderRelation
	sumTimes:0,						//orderMoneySum
	contractId:-1,					//orderContractId
	id:null,							//orderId
	customerId:-1,					//orderCustomerId
	moneyIn:0,						//orderMoneyIn
	isCkecked:0,					//orderIsCkecked
	createBy:"",					//orderCreateBy
	modifyBy:"",					//orderModifyBy
	publishStartDate:"19991231",	//orderPublishStartDate
	publishEndDate:"19991231",		//orderPublishEndDate
	moneySum:0,						//orderSumTimes
	createDate:"19991231",			//orderSumTimes
	modifyDate:"19991231"			//orderSumTimes
	};

var orderDetail = 
	{
	appRate:null,					//dtAppRate
    carrierId:null,					//dtCarrierId
    createBy:null,					//dtCreateBy
    createDate:null,				//dtCreateDate
    execPrice:null,					//dtExecPrice
    favourRate:null,				//dtFavourRate
    id:null,						//dtId
    industryTypeId:null,			//dtIndustryTypeId
    isCkecked:null,					//dtIsCkecked
    matterId:null,					//dtMatterId
    matterLength:null,				//dtMatterLength
    matteType:null,					//dtMatteType
    modifyBy:null,					//dtModifyBy
    modifyDate:null,				//dtModifyDate
    moneyBalance:null,				//dtMoneyBalance
    moneyIn:null,					//dtMoneyIn
    moneyRealpay:null,				//dtMoneyRealpay
    orderCategoryId:null,			//dtOrderCategoryId
    orderId:null,					//dtOrderId
    publishMemo:null,				//dtPublishMemo
    resourceInfoId:null,			//dtResourceInfoId
    resourcePriceType:null,			//dtResourcePriceType
    resourceSpecificId:null,		//dtResourceSpecificId
    resourceType:null,				//dtResourceType
    resourceWorkspanId:null,		//dtResourceWorkspanId
    moneyBase:null,					//dtMoneyBase
    sumTimes:null,					//dtSumTimes
    sysPrice:null,					//dtSysPrice
    publishEndDate:null,			//dtPublishEndDate
    publishStartDate:null,	        //dtPublishStartDate
    monthInfoMap:null               //monthInfoMap
	};
	
var orderDetailDest = 
	{
	dtAppRate:0,					//appRate
    dtCarrierId:0,					//carrierId
    dtExecPrice:0,					//execPrice
    dtFavourRate:0,					//favourRate
    dtIndustryTypeId:0,				//industryTypeId
    dtMatterId:null,					//matterId
    dtMatterCode:"",				//
    dtMatterName:"",				//
    dtMatterEdit:"",				//    
    dtMatterLength:0,				//matterLength
    dtOrderCategoryId:0,			//orderCategoryId
    dtOrderId:null,					//orderId
    dtPublishMemo:"",				//publishMemo
    dtResourceInfoId:0,				//resourceInfoId
    dtResourcePriceType:0,			//resourcePriceType
    dtResourceSpecificId:0,			//resourceSpecificId
    
    dtResourceType:0,				//resourceType
    dtMoneyBase:0,					//moneyBase
    dtSumTimes:0,					//sumTimes
    dtSysPrice:0,					//sysPrice
    dtPublishStartDate:"19991231",	//publishStartDate   
    dtPublishEndDate:"19991231",	//publishEndDate
    dtId:null,						//id
    dtMatteType:0,					//matteType   
    dtIsCkecked:0,					//isCkecked
    dtMoneyIn:0,					//moneyIn
    dtMoneyRealpay:0,				//moneyRealpay
    dtMoneyBalance:0,				//moneyBalance
    dtResourceWorkspanId:-1,		//resourceWorkspanId
    dtCreateBy:1,					//createBy
    dtCreateDate:"19991231",		//createDate
    dtModifyBy:1,					//modifyBy
    dtModifyDate:"19991231",		//modifyDate
    dtMonthInfoMap:null   
	};
		

var matter = 
	{
	name:null,
	edit:null,
	length:0,
	brandId:-1,
	customerId:-1,
	matterType:-1
	};

//******************************
//  private function
//******************************


function setDest(ret){
    var dt = orderDetailDest;
	dt.dtAppRate = ret.appRate;
    dt.dtExecPrice = ret.execPrice;
    dt.dtFavourRate=ret.favourRate;
    dt.dtIndustryTypeId = ret.industryTypeId;
    dt.dtMatterId = ret.matterMap[0].id;
    dt.dtMatterCode = ret.matterMap[0].tapeCode;
    dt.dtMatterName = ret.matterMap[0].name;
    dt.dtMatterEdit = ret.matterMap[0].edit;
    dt.dtMatterLength = ret.matterMap[0].length;
    dt.dtOrderCategoryId = ret.orderCategoryId;
    dt.dtOrderId = ret.orderId;
    dt.dtPublishMemo = ret.publishMemo;
    
    dt.dtCarrierId = ret.carrierId;
    dt.dtResourceInfoId = ret.resourceInfoId;
    dt.dtResourcePriceType = ret.resourcePriceType;
    dt.dtResourceSpecificId = ret.resourceSpecificId;
    
    dt.dtResourceType = ret.resourceType;
    dt.dtMoneyBase = ret.moneyBase;
    dt.dtSumTimes = ret.sumTimes;
    dt.dtSysPrice = ret.sysPrice;
    dt.dtPublishStartDate = ret.publishStartDate;  
    dt.dtPublishEndDate = ret.publishEndDate;
    dt.dtId = ret.id;
    dt.dtMatteType = ret.matteType;
    dt.dtIsCkecked = ret.isCkecked;
    dt.dtMoneyIn = ret.moneyIn;
    dt.dtMoneyRealpay = ret.moneyRealpay;
    dt.dtMoneyBalance = ret.moneyBalance;
    dt.dtResourceWorkspanId = ret.resourceWorkspanId;
    dt.dtCreateBy = ret.createBy;
    dt.dtCreateDate = ret.createDate;
    dt.dtModifyBy = ret.modifyBy;
    dt.dtModifyDate = ret.modifyDate;
    dt.dtMonthInfoMap = ret.monthInfoMap;
    //alert(dt.dtMonthInfoMap);
    //fillMonthInfos2(dt.dtMonthInfoMap);
    return dt;
}	


function setOrderDetail(dt){
    var od = orderDetail;
	od.appRate = dt.dtAppRate;
    od.carrierId = dt.dtCarrierId;
    od.createBy = dt.dtCreateBy;

    od.execPrice = dt.dtExecPrice;
    od.favourRate = dt.dtFavourRate;
    od.id = dt.dtId;
    od.industryTypeId = dt.dtIndustryTypeId;
    od.isCkecked = dt.dtIsCkecked;
    od.matterId = dt.dtMatterId;
    od.matterLength = dt.dtMatterLength;
    od.matteType = dt.dtMatteType;
    od.modifyBy = dt.dtModifyBy;
    od.moneyBalance = dt.dtMoneyBalance;
    od.moneyIn = dt.dtMoneyIn;
    od.moneyRealpay = dt.dtMoneyRealpay;
    od.orderCategoryId = dt.dtOrderCategoryId;
    od.orderId = dt.dtOrderId;
    od.publishMemo = dt.dtPublishMemo;
    od.resourceInfoId = dt.dtResourceInfoId;
    od.resourcePriceType = dt.dtResourcePriceType;
    od.resourceSpecificId = dt.dtResourceSpecificId;
    od.resourceType = dt.dtResourceType;
    od.resourceWorkspanId = dt.dtResourceWorkspanId;
    od.moneyBase = dt.dtMoneyBase;
    od.sumTimes = dt.dtSumTimes;
    od.sysPrice = dt.dtSysPrice;
    od.publishStartDate = dt.dtPublishStartDate;
    od.publishEndDate = dt.dtPublishEndDate;
    //od.createDate = dt.dtCreateDate;
    //od.modifyDate = dt.dtModifyDate;
    od.monthInfoMap =dt.dtMonthInfoMap;
    return od;
}	


function clearOrderDetailDest(){
    var dt = orderDetailDest;
	dt.dtAppRate=0,						//appRate
    dt.dtCarrierId = 0,					//carrierId
    dt.dtExecPrice = 0,					//execPrice
    dt.dtFavourRate = 0,					//favourRate
    dt.dtIndustryTypeId = 0,				//industryTypeId
    dt.dtMatterId = -1,					//matterId
    dt.dtMatterCode = "",				//
    dt.dtMatterName = "",				//
    dt.dtMatterEdit = "",				//    
    dt.dtMatterLength = 5,				//matterLength
    dt.dtOrderCategoryId = {0:"   "},	//orderCategoryId
    dt.dtOrderId = $("orderId").value,					//orderId
    dt.dtPublishMemo = "",				//publishMemo
    dt.dtResourceInfoId = {0:"    "},	//resourceInfoId
    dt.dtResourcePriceType = 0,			//resourcePriceType
    dt.dtResourceSpecificId = 0,		//resourceSpecificId
    
    dt.dtResourceType = 0,				//resourceType
    dt.dtMoneyBase = 0,					//moneyBase
    dt.dtSumTimes = 0,					//sumTimes
    dt.dtSysPrice = 0,					//sysPrice
    dt.dtPublishStartDate = curDate,	//publishStartDate   
    dt.dtPublishEndDate = curDate,	//publishEndDate
    dt.dtId = "",						//id
    dt.dtMatteType = 0,					//matteType   
    dt.dtIsCkecked = 0,					//isCkecked
    dt.dtMoneyIn = 0,					//moneyIn
    dt.dtMoneyRealpay = 0,				//moneyRealpay
    dt.dtMoneyBalance = 0,				//moneyBalance
    dt.dtResourceWorkspanId = -1,		//resourceWorkspanId
    dt.dtCreateBy = 1,					//createBy
    dt.dtCreateDate = "19991231",		//createDate
    dt.dtModifyBy = 1,					//modifyBy
    dt.dtModifyDate = "19991231",		//modifyDate  
    
   // dt.dtMonthInfoMap ={};
    
    //DWRUtil.removeAllOptions("dtOrderCategoryId");    
    DWRUtil.removeAllOptions("dtResourceInfoId");
    //DWRUtil.setValue("dtOrderCategoryId","0")
    //DWRUtil.setValue("dtResourceInfoId","0")
    DWRUtil.addOptions("dtResourceInfoId", {0:""});
     //DWRUtil.removeAllOptions("dtResourceInfoId");
     
    rowNum = 0;
     
    return dt;
}	

function resetOrder(){
    var or = order;
	or.orderCode = "", 						//orderCode 
	or.orderRelationCode = "",				// relationCode
	or.orderCategoryMain = 0, 				// categoryId
	or.orderMeno = "", 						// orderMeno
	or.orderPublishMemo = "", 				// publishMemo
	or.orderContractCode = "", 					//orderContractCode
	or.orderCustomerName = "", 					//orderCustomerName
	or.orderRelation = 0,					// userId
	or.orderMoneySum = 0,					// sumTimes
	or.orderContractId = -1,				// contractId
	//or.orderId = null,						// contractId
	or.orderCustomerId = -1,				// customerId
	or.orderMoneyIn = 0,					// moneyIn
	or.orderIsCkecked = 0,					// isCkecked
	or.orderCreateBy = "",					// createBy
	or.orderModifyBy = "",					// modifyBy
	or.orderPublishStartDate = curDate,	// publishStartDate
	or.orderPublishEndDate = curDate,		// publishEndDate
	or.orderSumTimes = 0,					// moneySum
	or.orderSumTimes = "19991231",			// createDate
	or.orderSumTimes = "19991231"			// modifyDate
	return or;
}



function setOrder(){
    var or = order;
	or.orderCode = $("orderCode").value;
	or.relationCode = $("orderRelationCode").value;	
	or.categoryId = $("orderCategoryMain").value;	
	or.orderMeno = $("orderMeno").value;	
	or.publishMemo = $("orderPublishMemo").value;	
	or.userId = $("orderRelation").value;	
	or.moneySum = $("orderMoneySum").value;	
	or.contractId = $("orderContractId").value;
	or.id = $("orderId").value;	
	or.customerId = $("orderCustomerId").value;	
	or.moneyIn = $("orderMoneyIn").value;	
	or.isCkecked = $("orderIsCkecked").value;
	or.createBy = $("orderCreateBy").value;	
	or.modifyBy = $("orderModifyBy").value;	
	or.publishStartDate = $("orderPublishStartDate").value;
	or.publishEndDate = $("orderPublishEndDate").value;	
	or.sumTimes = $("orderSumTimes").value;		
	return or;
}






