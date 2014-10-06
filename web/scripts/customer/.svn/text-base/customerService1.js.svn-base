var customer = new Customer();
var payment = new PayMent();
var customerAddress = new CustomerAddress();
var linkman = new LinkMan();
var linkHistory = new LinkHistory();
var contract = new Contract();
var order = new Order();
var income = new Income();
var matter = new Matter();
var feedbackInfo = new FeedbackInfo();
var user = new User();
var popupcenter = new Popupcenter();
var config_customerOwnerParam;
 
callOnLoad(init);

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var picBank = $("pic_bank");
    
//    tabcontainer.style.width = dialogcontent.offsetWidth -73 +"px";
//    tabcontainer.style.height = dialogcontent.offsetHeight * 0.9 +"px";	
//    var divkk = $("tabcontainer");
////    $("tabsDiv").style.height =  tabcontainer.offsetWidth - 20 +"px";
////alert(tabcontainer.offsetHeight+"  1  "+dialogcontent.offsetHeight);
	picBank.style.height = dialogcontent.offsetHeight * 0.45 +"px";
} 

function init(){
	
	 config_customerOwnerParam = _app_params.sysParam.customerOwnerParam;
	if(config_customerOwnerParam == 0) $("customer_Rel").style.cssText ="display:none;"
	
	
	
	setCustomerPara(customer);
	setUserPara(user);
	buttonEventFill();
	resetHeigth();
	var radioId = getRadioIdByURL();
	if(radioId > 0&& radioId != 1) $("customerCategory").value = radioId;

	
	
}

function getPageIndexByURL(){
	var url = window.location.href;
	var start = url.indexOf("&");
//	alert(startPos + "     "+url);
	var end = url.length;
	var str = url.substring(start+1,end);
	var startPos = str.indexOf("=");
	var endPos = str.indexOf("&");
	var pageIndex = null;
	pageIndex = str.substring(startPos+1,endPos)*1;
	pageIndex = pageIndex>0?pageIndex:1;
//	alert(startPos+"         "+endPos+"    "+pageIndex);
	return pageIndex;
	
}

function getRadioIdByURL(){
	var url = window.location.href;
	var startPos = url.length-1;
	var endPos = url.length;
	var radioId = null;
	radioId = url.substring(startPos,endPos)*1;
	return radioId;
	
}

function closePopup(ev){
//	alert(0);
	popupcenter.closePopup(popupcenter);
}

function selectCustomerRel(){
	var customrerId = $("customerId").value;
//	 alert(customrerId);
	if(customrerId =='' || customrerId ==null){
	   	alert("请先保存客户基本信息，再执行此操作！");
	   	return false;
    }
	popupcenter.url ="selectPopup/selectCustomerRel.html?id=" +customrerId;
	popupcenter.model = 6;
	popupcenter.popupcenter(popupcenter);
}
function selectCustomerCarrierRel(){
	var customrerId = $("customerId").value;
//	 alert(customrerId);
	if(customrerId =='' || customrerId ==null){
	   	alert("请先保存客户基本信息，再执行此操作！");
	   	return false;
    }
	popupcenter.url ="selectPopup/customerCarrierRel.html?id=" +customrerId;
	popupcenter.model = 8;
	popupcenter.popupcenter(popupcenter);
}

function selectOrderDetail(){
	var customrerId = $("customerId").value;
//	 alert(customrerId);
	if(customrerId =='' || customrerId ==null){
	   	alert("请先保存客户基本信息，再执行此操作！");
	   	return false;
    }
	popupcenter.url ="selectPopup/orderDetails.html?id=" +customrerId;
	popupcenter.model = 100;
	popupcenter.popupcenter(popupcenter);
}

function buttonEventFill(){
	
	var Bt_save = $("Btn_save");
	Bt_save.setAttribute("href","javascript:void 0");
	Bt_save.onclick = saveCustomer;
	
	var Btn_del = $("Btn_del");
	Btn_del.setAttribute("href","javascript:void 0");
	Btn_del.onclick = delCustomer;
	
	var Btn_cancel = $("Btn_cancel");
	Btn_cancel.setAttribute("href","javascript:void 0");
	Btn_cancel.onclick = cancelCustomer;
	
	var Btn_add = $("Btn_add");
	Btn_add.setAttribute("href","javascript:void 0");
	Btn_add.onclick = addCustomer;			
	
	var Bt_addNewContract = $("Bt_addNewContract");
	Bt_addNewContract.setAttribute("href","javascript:void 0");
	Bt_addNewContract.onclick = addNewContract;
	
//	var Bt_addNewOrder = $("Bt_addNewOrder");
//	Bt_addNewOrder.setAttribute("href","javascript:void 0");
//	Bt_addNewOrder.onclick = addNewOrder;
	
//	var Bt_addNewIncome = $("Bt_addNewIncome");
//	Bt_addNewIncome.setAttribute("href","javascript:void 0");
//	Bt_addNewIncome.onclick = addNewIncome;
	
//	var Bt_addNewMatter = $("Bt_addNewMatter");
//	Bt_addNewMatter.setAttribute("href","javascript:void 0");
//	Bt_addNewMatter.onclick = addNewMatter;
	
//	var Bt_addFeedbackInfo = $("Bt_addNewFeedbackInfo");
//	Bt_addFeedbackInfo.setAttribute("href","javascript:void 0");
//	Bt_addFeedbackInfo.onclick = addNewFeedbackInfo;
	
	var Bt_customer_Rel = $("customer_Rel");
	Bt_customer_Rel.setAttribute("href","javascript:void 0");
	Bt_customer_Rel.onclick = selectCustomerRel;
	
	var Bt_customer_carrier_Rel = $("customer_carrier_Rel");
	Bt_customer_carrier_Rel.setAttribute("href","javascript:void 0");
	Bt_customer_carrier_Rel.onclick = selectCustomerCarrierRel;
	
	var Bt_order_detail = $("order_detail");
	Bt_order_detail.setAttribute("href","javascript:void 0");
	Bt_order_detail.onclick = selectOrderDetail;
	
	document.body.onfocus = closePopup;
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setUserPara(obj){
	 obj.className  = "user";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setPayMentPara(obj){
	 obj.className = "payment";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setCustomerAddressPara(obj){
	 obj.className = "customerAddress";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setLinkManPara(obj){
	 obj.className = "linkman";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setLinkHistoryPara(obj){
	 obj.className = "linkHistory";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setContractPara(obj){
	 obj.className = "contract";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setOrderPara(obj){
	 obj.className = "order";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setIncomePara(obj){
	 obj.className = "income";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setMatterPara(obj){
	 obj.className = "matter";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setFeedbackInfoPara(obj){
	 obj.className = "feedbackInfo";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}


//获得列表
function getPayMentTable(){
//	setPayMentPara(payment);
	var func = function(objs){
		payment.fillTalbeCus(objs);
	}
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
	payment.reset();
	payment.obj.customerId = customerId;
	payment.getPaymentByCustomer(payment,func);
}

//获得列表
function getCustomerAddressTable(){
//	setCustomerAddressPara(customerAddress);
	var func = function(objs){
		customerAddress.fillTable(objs);
	}
	
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
	customerAddress.reset();
	customerAddress.obj.customerId = customerId;
	customerAddress.getCustomerAddresss(customerAddress,func);
}

function getLinkManTable(){	
//	setLinkManPara(linkman);
	
	var func = function(objs){
		linkman.fillTable(objs);
	}
	
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
//	alert(customerId);
	linkman.reset();	
	linkman.obj.customerId = customerId;
	linkman.getLinkMans(linkman,func);
}
function getLinkHistoryTable(){
//	setLinkHistoryPara(linkHistory);
	
	var func = function(objs){
		linkHistory.fillTable(objs);
	}
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
	linkHistory.reset();
	linkHistory.obj.customerId = customerId;
	linkHistory.getLinkHistorys(linkHistory,func);
}
function getContractTable(){
//	setContractPara(contract);
	
	var func = function(objs){
		customerAddress.obj.customerId = $("customerId").value;
		contract.fillTalbeByCusId(objs);
	}
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
	contract.reset();
	contract.obj.customerId = customerId;
	contract.getContractsByCusId(contract,func);
}
function getOrderTable(){
//	setOrderPara(order);
	var func = function(objs){
		order.fillTalbeByCusId(objs);
	}
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
	var customerName = $("customerName").value;
	
	if(customerName !=''){
		order.reset();
	//	order.obj.customerId = customerId;
		order.obj.customer = (new Customer()).obj;
		order.obj.orderPublic = (new OrderPublic).obj;
	//	order.obj.orderPublic.publishStartDate =20080101;
	//	order.obj.orderPublic.publishEndDate =20081231;
		order.obj.orderPublic.publishStartDate = -1;
		order.obj.customer.customerName = customerName;
		order.getOrdersReport(order,func);
	//	order.getOrdersByCusId(order,func);
	}

}


function editOrderInfo(orderId){
	popupcenter.url = "editOrder.html?id="+orderId+"&";
	popupcenter.model = 8;
	popupcenter.popupcenter(popupcenter);
}

function getIncomeTable(){
//	setIncomePara(income);
	
	var func = function(objs){
		income.fillTalbeByCusId(objs);
	}
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
	if(customerId > 0){
		income.reset();
//		income.obj.resourceCarrierId = 0;
		income.obj.customerId = customerId;
		income.getIncomesByCustomerId(income,func);	
	}
}
function getMatterTable(){
//	setMatterPara(matter);
	
	var func = function(objs){
		matter.fillTableByCustomerId(objs);
	}
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
	matter.reset();
	matter.obj.customerId = customerId;
	matter.getMattersByCustomerId(matter,func);
}
function getFeedbackInfoTable(){
//	setFeedbackInfoPara(feedbackInfo);
	
	var func = function(objs){
		feedbackInfo.fillTable(objs);
	}
	var customerId = $("customerId").value == '' ? -1 : $("customerId").value;
	feedbackInfo.reset();
	feedbackInfo.obj.customerId = customerId;
	feedbackInfo.getFeedbackInfos(feedbackInfo,func);
}

function button_add_new_obj(type){
	if(type == 0){
		customerAddress.addNewRow('new',null);
	}
	if(type == 1){

		linkman.addNewRow('new',null);

	}	
	if(type == 2){
		linkHistory.addNewRow('new',null);
		getDate();
	}		
}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == customerAddress.pageInfo){
		var page = new Page(customerAddress.pageInfo,customerAddress.pageSize);
		page.goNextPage(pageIndex);
		customerAddress.page = page;
		getCustomerAddressTable()
	}
	
	if(pageInfoName == linkman.pageInfo){
		var page = new Page(linkman.pageInfo,linkman.pageSize);
		page.goNextPage(pageIndex);
		linkman.page = page;
		getLinkManTable();
	}
	
	if(pageInfoName == linkHistory.pageInfo){
		var page = new Page(linkHistory.pageInfo,linkHistory.pageSize);
		page.goNextPage(pageIndex);
		linkHistory.page = page;
		getLinkHistoryTable();
	}
	
	if(pageInfoName == payment.pageInfo){
		var page = new Page(payment.pageInfo,payment.pageSize);
		page.goNextPage(pageIndex);
		payment.page = page;
		getPayMentTable();
	}
	
	if(pageInfoName == contract.pageInfo){
		var page = new Page(contract.pageInfo,contract.pageSize);
		page.goNextPage(pageIndex);
		contract.page = page;
		loadPrices($("resourceId").value);
		getContractTable();
	}
	
	if(pageInfoName == order.pageInfo){
		var page = new Page(order.pageInfo,order.pageSize);
//		alert(pageIndex);
		page.goNextPage(pageIndex);
//		alert(pageInfoName);
		order.page = page;
		getOrderTable();
	}
	
	if(pageInfoName == income.pageInfo){
		var page = new Page(income.pageInfo,income.pageSize);
		page.goNextPage(pageIndex);
		income.page = page;
		getIncomeTable();
	}
	
	if(pageInfoName == matter.pageInfo){
		var page = new Page(matter.pageInfo,matter.pageSize);
		page.goNextPage(pageIndex);
		matter.page = page;
		getMatterTable();
	}
	
	if(pageInfoName == feedbackInfo.pageInfo){
		var page = new Page(feedbackInfo.pageInfo,feedbackInfo.pageSize);
		page.goNextPage(pageIndex);
		feedbackInfo.page = page;
		getFeedbackInfoTable();
	}
}

function editInfo(contractId){
	parent.location.href ="editContract.html?id="+contractId;
}
//function editOrderInfo(orderId){
//	parent.location.href ="editOrder.html?id="+orderId+"&";
//}
function addNewContract(){
	parent.location.href ="editContract.html?type=1";
}
function addNewOrder(){
	parent.location.href ="editOrder.html";
}
//function addNewIncome(){
//	parent.location.href ="editIncome.html";
//}
function addNewMatter(){
	parent.location.href ="editMatter.html";
}
function addNewFeedbackInfo(){
	parent.location.href ="editFeedbackInfo.html";
}
function cannelAddandEdit(){
	$("hiddenArea").appendChild($("country"));
	$("hiddenArea").appendChild($("province"));
	getCustomerAddressTable();
}
function saveAddandEditCustomerAddress(event){
	var e = event || window.event;
	var saveImgTd = Event.element(e);	
	var id = saveImgTd.getAttribute("paraId");
	
	$("hiddenArea").appendChild($("country"));
	$("hiddenArea").appendChild($("province"));

	var customerId = $("customerId").value;
	
	if(customerId == ''){
		
		var func = function(cusId){
			$("customerId").value = cusId;
			saveAddress(cusId,id);
		}
		
		var parentId = $("parentId").value ;
		parentId = parentId != '' ? parentId :'0';
		var cusName = $("customerName").value;
		
		if(cusName == ''){
			alert("帐户名称不能为空");
			return false;
		}else{
			DWRUtil.getValues(customer.obj);
			customer.obj.id = $("customerId").value;
			customer.obj.industryTypeId = $("industryTypeId").value;
			customer.obj.parentId = parentId;
			
			customer.saveCustomerForm(customer.obj,func);
		}
	}else{
		saveAddress($("customerId").value,id);
	}

}

function saveAddress(cusId,id){
		var funct = function(){
			getCustomerAddressTable();
		}
			
		DWRUtil.getValues(customerAddress.obj);
		customerAddress.obj.id = id;
		customerAddress.obj.customerId = cusId;
		
		customerAddress.saveCustomerAddress(customerAddress.obj,funct);
}

function delCustomerAddress(deleImg){
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	customerAddress.removeCustomerAddress(id,delRow);
	
	getCustomerAddressTable();
}
function cannelAddandEditLinkMan(){
	getLinkManTable();
}
function saveAddandEditLinkMan(event){
	var e = event || window.event;
	var saveImgTd = Event.element(e);	
	var id = saveImgTd.getAttribute("paraId");
	
	var customerId = $("customerId").value;
	
	if(customerId == ''){
		
		var func = function(cusId){
			$("customerId").value = cusId;
			saveLinkMan(cusId,id);
		}
		
		var parentId = $("parentId").value ;
		parentId = parentId != '' ? parentId :'0';
		var cusName = $("customerName").value;
		
		if(cusName == ''){
			alert("帐户名称不能为空");
			return false;
		}else{
			DWRUtil.getValues(customer.obj);
			customer.obj.id = $("customerId").value;
			customer.obj.industryTypeId = $("industryTypeId").value;
			customer.obj.parentId = parentId;
			
			customer.saveCustomerForm(customer.obj,func);
		}
	}else{
		saveLinkMan($("customerId").value,id);
	}

}

function saveLinkMan(customerId,id){
	var func = function(){
		getLinkManTable();
	}
	
	DWRUtil.getValues(linkman.obj);
	linkman.obj.id = id;
	linkman.obj.customerId = customerId;
	
	var Btn_SaveLinkMan = $("Btn_SaveLinkMan");
	var tr =Btn_SaveLinkMan.parentNode.parentNode;
	
	var value = getRadioValue(tr);

	value = value == 0 ? 1 : '';

	if(value == 1){
		var func2 = function(){}
		linkman.resetMainLinkMan($("customerId").value,func2);
	}

	linkman.obj.isCustomerMain = value;
	linkman.saveLinkMan(linkman.obj,func);
}

function delLinkMan(deleImg){
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	linkman.removeLinkMan(id,delRow);
	
	getLinkManTable();
}
function cannelAddandEditLinkHistory(){
	$("hiddenArea").appendChild($("linkManId"));
	getLinkHistoryTable();
}
function saveAddandEditLinkHistory(event){
	var e = event || window.event;
	var saveImgTd = Event.element(e);	
	var id = saveImgTd.getAttribute("paraId");
	
	
	
	var customerId = $("customerId").value;
	var cusName = $("customerName").value;
	
	if(customerId == ''){
		
		var func = function(cusId){
			$("customerId").value = cusId;
			saveHistory(cusId,id);
		}
		
		var parentId = $("parentId").value ;

		parentId = parentId != '' ? parentId :'0';
		
		if(cusName == ''){
			alert("帐户名称不能为空");
			return false;
		}else{
			DWRUtil.getValues(customer.obj);
			customer.obj.id = $("customerId").value;
			customer.obj.industryTypeId = $("industryTypeId").value;
			customer.obj.parentId = parentId;
			
			customer.saveCustomerForm(customer.obj,func);
		}
	}else{
		saveHistory($("customerId").value,id)
	}
}
function saveHistory(cusId,id){

	$("hiddenArea").appendChild($("linkManId"));
	
	var func = function(objs){
		getLinkHistoryTable();
	}
	
	DWRUtil.getValues(linkHistory.obj);
	linkHistory.obj.id = id;
	linkHistory.obj.customerId = $("customerId").value;
	

	linkHistory.saveLinkHistory(linkHistory.obj,func);
}
function deletLinkHistory(deleImg){
	var id = deleImg.getAttribute("paraId"); 
	var delRow = deleImg.parentNode.parentNode;
	linkHistory.removeLinkHistory(id,delRow);

	getLinkHistoryTable();
}

function getDate(){
	Calendar.setup({
		inputField  : "linkDate",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		button	  : "linkDate"	// id of the button
	});
}

//按纽点击事件

function saveCustomer(){
	
	var func = function(cusId){
		
		$("customerId").value = cusId;
		
		var Btn_SaveLinkMan = $("Btn_SaveLinkMan");
		var Btn_SaveCustomerAddress = $("Btn_SaveCustomerAddress");
		var Btn_SaveHisotry = $("Btn_SaveLinkHisotry");
	
		if(!isUndefined(Btn_SaveLinkMan)){
			
	        var paraId = Btn_SaveLinkMan.getAttribute("paraId");
	        
	        saveLinkMan(cusId,paraId);
		}
		if(!isUndefined(Btn_SaveCustomerAddress)){
			
	        var paraId = Btn_SaveCustomerAddress.getAttribute("paraId");
	        
	        saveAddress(cusId,paraId);
		}
		if(!isUndefined(Btn_SaveHisotry)){
			
	        var paraId = Btn_SaveHisotry.getAttribute("paraId");
	        saveHistory(cusId,paraId);
		}
		alert("保存成功！")
	}
	
	var parentId = $("parentId").value ;
	parentId = parentId != '' ? parentId :'0';


	var customerName = $("customerName").value;
	
	if(customerName == ''){
		alert("帐户名称不能为空");
		return false;
	}else{

		DWRUtil.getValues(customer.obj);
		customer.obj.id = $("customerId").value;
		customer.obj.industryTypeId = $("industryTypeId").value;
		customer.obj.parentId = parentId;
		
		customer.saveCustomerForm(customer.obj,func);
	}
}

function delCustomer(){
	var id = $("customerId").value;
	
	var func = function(){
		parent.location.href ="customers.html";
	}
	
	customer.removeCustomer(id,func);
}

function cancelCustomer(){
//	alert(getRadioIdByURL());
//	var radioId = getRadioIdByURL();
	
	var radioId = $("customerCategory").value;
//	alert("第二"+getPageIndexByURL());
	parent.location.href ="customers.html?pageIndex="+getPageIndexByURL()+"&radioId="+getRadioIdByURL();
}

function addCustomer(){
	parent.location.href ="editCustomer.html";
}

