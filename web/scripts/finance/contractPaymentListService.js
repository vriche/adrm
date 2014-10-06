var contractPayment = new PayMent();
var customer = new Customer();
var carrier =new  Carrier();
var channelModelParam;
var myDate = new MyDate();
var config_serviceDate;

callOnLoad(init);

function init(){
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	
	setContractPaymentPara(contractPayment);
	setCustomerPara(customer);
	setCarrierPara(carrier);
	
	getDate();
	buttonEventFill();
	//getTable();
	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
	
	
	var fct = function(){

 		//getTable();					//获得列表	
 	}
 	
	if(channelModelParam == 1){
 	    initCarrier(fct);
 	}else{
 	    $("carrierName").hide();
 	   // getTable();					//获得列表	
	}
	
}

function initCarrier(fct){
    carrier.obj.nodeLevel =1;
	carrier.obj.enable = false;
	//根据是否分频道，取得频道下拉列表
	function fnct(){
		var carrierId = getParamFromUrl(window.location.href,"carrierId");
		if(carrierId > 0) $("carrierName").value = carrierId;
		if(fct) fct();
	}
	if(channelModelParam!=1){
		carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName","",fnct);
	}else{
		carrier.makeSelectItemAnalyze3(carrier,carrier.selectName,"",100,true,fnct);
	}	
		
}

 function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	obj.selectName = obj.className+"Name";
}

function setContractPaymentPara(obj){

	 obj.className ="contractPayment";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.pageInfo 	= "contractPaymentPageInfo";
	 obj.pageSize 	= "20";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);

}
function getDate(){
	
	Calendar.setup({
		inputField  : "startDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "startDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "endDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "endDate"	// id of the button
	});
//	$("startDate").value = getFormatDay(theYear+'0101','y/m/d');
//	$("endDate").value= getFormatDay(curDate,'y/m/d');
	
	$("startDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("endDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}
 

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
	 obj.treebox	= obj.className + "Treebox";

}
function buttonEventFill(){
	var Submit = $("Submit");
	Submit.onclick = search;	
	
	var Btn_customerName = $("customerName");
	Btn_customerName.onclick = resetText;
	Btn_customerName.onkeypress = getCustomerAutoCompltByName;
}

function searchyear(beginDate,endDate){
	var beginYear = getFormatDay(beginDate,'y');
	var endYear = getFormatDay(endDate,'y');
	var ispass = true;
	
	
 	if(beginDate == null || endDate == null){
		alert("请选择日期");
		ispass =  false;
		return ispass;
	}
	
	if(beginDate > endDate){
		alert("开始日期不能大于结束日期");
		ispass =  false;
		return ispass;
	}	
	
//	if(resource_year!=beginYear || resource_year!=endYear){
//		alert("选定年份应该等于实际年份");
//		ispass =  false;
//	}

	return ispass;
}
function search(ev){
	var customerName = $("customerName").value;
	var startDate = getFormatDay($("startDate").value,'ymd');
	var endDate = getFormatDay($("endDate").value,'ymd');
	var isPass = searchyear(startDate,endDate);
	if(!isPass) return false;
	
	contractPayment.page.pageIndex=1;
	getContractPaymentTable(customerName,startDate,endDate);
}
function resetText(ev){
	$("customerName").value=null;
	$("customerId").value=null;
}
function getCustomerAutoCompltByName(ev){
	var customerName =$("customerName").value;
	customer.obj.customerName = customerName;
	
	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
		$("customerName").value="";
	}
}
function customerAutoComplete(objs)
{
	var oText = $("customerName");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
	var hidenColumName = ["id","customerCategoryId","helpCode"];
	var allColumsTitle = ["客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		$("customerId").value = getCellValue(tr,0);
		$("customerName").value = getCellValue(tr,2);
		$("customerCategoryId").value = getCellValue(tr,3);
		
		oText.value = getCellValue(tr,2);
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '';
			$("customerCategoryId").value = '';
		
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
}
function getTable(){

    var customerName = "";
	var startDate = "";
	var endDate = "nowDate";
	var carrierId = $("carrierName").value;
	contractPayment.getContractPaymentList(contractPayment.contractFillTalbe,customerName,startDate,endDate);

}
function getContractPaymentTable(customerName,startDate,endDate,carrierId){
    //var carrierId = $("carrierName").value;
//  alert(contractPayment.page.pageIndex);
	contractPayment.getContractPaymentList(contractPayment.contractFillTalbe,customerName,startDate,endDate);
}
function editOrderInfo(id){
	window .open('editOrder.html?id='+id,"","");
}
function goNextPage(pageIndex,pageInfoName){
		
	var customerName = $("customerName").value;
	var startDate = getFormatDay($("startDate").value,'ymd');
	var endDate = getFormatDay($("endDate").value,'ymd');
	var carrierId = $("carrierName").value;
	
	if(pageInfoName == contractPayment.pageInfo){
		var page = new Page(contractPayment.pageInfo,contractPayment.pageSize);
		page.goNextPage(pageIndex);
		contractPayment.page = page;
		getContractPaymentTable(customerName,startDate,endDate);
	}
}