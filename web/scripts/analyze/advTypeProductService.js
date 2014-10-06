
var customerProduct = new CustomerProduct();
var user = new User();
var carrier = new Carrier();
var userName ;
var isPrint;
var myDate = new MyDate();
var config_serviceDate;

callOnLoad(init);	

function init(){ 	
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;
		
	setCustomerProduct(customerProduct);
	setUserPara(user);
	setCarrierPara(carrier);
	
	carrier.obj.nodeLevel =1;
	makeCarrierSelectItem();
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);	

 	buttonEventFill();
 	getDate();
	
	resetHeigth();

}
function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
	}else{
		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",setCarrierSelect);
	}
}
function setCarrierSelect(){
	var id  = $("carrierName").value;
	 	if(id > 0){
	 		$(carrier.selectName).value = id;
	 	}
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userOwner"; 
}

function setUserSelected(){
	 	var id  = $("userId").value;
	 	if(id > 0){
	 		$(user.selectName).value = id;
	 	}
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var advTypeProductAnalyze_div = $("advTypeProductAnalyze_div");
      
    advTypeProductAnalyze_div.style.width = dialogcontent.offsetWidth -73 +"px";
    advTypeProductAnalyze_div.style.height = dialogcontent.offsetHeight * 0.8 +"px";	
    
    $("advTypeProductTable").style.width =  advTypeProductAnalyze_div.offsetWidth - 20 +"px";
} 

function buttonEventFill(){
	var btn_search = $("search");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick = queryList;

	var Bt_displayChar = $("displayChar");
	Bt_displayChar.setAttribute("href","javascript:void 0");
	Bt_displayChar.onclick = displayChar;	
	
	//var Bt_title_div = $("title_div");
	//Bt_title_div.onclick = hiddenTableProty;
	var Btn_view_order = $("Btn_view_order");
	Btn_view_order.onclick = button_view_order;

	var Btn_print_order = $("Btn_print_order");
	Btn_print_order.onclick = button_print_order;	
	
	var Btn_export_order = $("Btn_export_order");
	Btn_export_order.onclick = button_print_export;	
}

function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "advTypeProductRelIncome_report";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "advTypeProductRelIncome_report";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "advTypeProductRelIncome_report";
	 button_print();
}
function button_print(){
	$("startForm").value =  getFormatDay($("beginDate").value,'ymd');
	$("endForm").value =  getFormatDay($("overDate").value,'ymd');
	$("userId").value  = $(user.selectName).value==0?null:$(user.selectName).value;
	$("carrierNameForm").value = $("carrierName").value==null?0:$("carrierName").value;
	$("userName").value=userName;
	$("channelModelForm").value=channelModelParam;
//	if(isPutOn==undefined){
//		alert("请选择打印类型");
//		return false;
//	}
//	$("isPutOnORIncomeForm").value = isPutOn;


	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}

function hiddenTableProty(){
	$("advTypeProductAnalyze_div").style.cssText="position:relative;OVERFLOW: auto;width:880px;visibility:hidden;border:solid white 2px;background-color:#f5f5f5;z-index:0";
	resetHeigth();
}
function displayTableProty(){
	$("advTypeProductAnalyze_div").style.cssText="position:relative;OVERFLOW: auto;width:880px;visibility:show;border:solid white 2px;background-color:#f5f5f5;z-index:0";
	resetHeigth();
}

function setCustomerProduct(obj){
	 obj.className ="customerProduct";
	 obj.IdPrefix = obj.className + "Id";
	 obj.fillObjName = "customerProductBody";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageSize 	= "10000";
	 obj.pageInfo 	= "pageInfocustomerProduct";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function getDate(){
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "beginDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate"	// id of the button
	});
	
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}

function queryList(){
	displayTableProty();
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	isPrint="false";
	if(beginDate != '' && endDate != ''){
		if(beginDate > endDate){
			alert("开始日期不能大于结束日期");
			DWRUtil.removeAllRows(customerProduct.tBody);
			return false;
		}
		var func = function(objs){
			if(objs.length == 0){
				alert("没有记录");
				DWRUtil.removeAllRows(customerProduct.tBody);
			}else{
				customerProduct.fillTable_AdvType(objs);
			}
			
			Ext.getBody().unmask();
		}
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		customerProduct.getAdvTypeProductByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint,func);
		
	}else{
		alert("请选择日期");
		DWRUtil.removeAllRows(customerProduct.tBody);
	}
}

function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	
//	parent.location.href ="advTypeProductRelChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+userName+"*"+ channelModelParam;
	window.open("advTypeProductRelChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+userName+"*"+ channelModelParam,"dispalyChart")
}