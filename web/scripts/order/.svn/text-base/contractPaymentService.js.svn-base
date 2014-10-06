//实例化对象
var payment = new PayMent();
var resourceType = new ResourceType();
var orderDetail = new OrderDetail();
var config_serviceDate;
var tvNameParam;
var orderMainType;
var orgId = 1;
var year;
//var addImag;
 
callOnLoad(init);	
 
function init(){
	

	tag_order_paymentbtn =  _app_params.rights.tag_order_paymentbtn;
	config_withResourceSort =  _app_params.sysParam.withResourceSort;
	tag_orderDetail_save =  _app_params.rights.tag_orderDetail_save;
    
 	setPayMentPara(payment); 	//设置常量
 	
// 	addImag = $("orderImgAdd");
 	

 	
 	
 	var url = window.location.href;
 	orgId = getParamFromUrl(url,"orgId");
 	year = getParamFromUrl(url,"year");
	config_serviceDate = getParamFromUrl(url,"serDate");
	tvNameParam = getParamFromUrl(url,"tvNameParam");
	orderMainType = getParamFromUrl(url,"orderMainType");
	
//	if(tvNameParam == 'xmtv' && orderMainType == 2){
	if(config_withResourceSort == 1){
 		 $("xmtvBranch").style.display ="block";
 		 resourceType.obj.orgId = orgId;
 		 resourceType.obj.space = true;
 		 resourceType.obj.version = year;
 		 resourceType.makeSelectItemAnalyze(resourceType.obj,"resourceType",null);
 	}
 	
 	getPayMentTable(payment); //获得表
 	
 	
// 	if(tvNameParam =='qztv'){
		if(tag_order_paymentbtn){
			getDiscount(payment);   //获得折扣
		}
//	}else{
//			getDiscount(payment);   //获得折扣
//	}		
 	
 
	
//	if(tvNameParam == 'xmtv' && orderMainType == 2){
// 		 $("xmtvBranch").style.display ="block";
// 	}
    
//    alert(orderMainType);

 	
 	
 	
	
	 // alert(tvNameParam);
	
 	
// 	getOrderIdURL();
//	getMoneyRealPayByURL();
// 	getContractIdByURL();
 }
 
 
 function saveCuiKuanByNortomOrder( modle, isMid, pId,orderId, customerId, year,clear,func){
 	check_Eeit_State();
// 	setTimeout(func,8000);
	payment.saveCuiKuanByNortomOrder(modle, isMid, pId,orderId, customerId, year,clear,func);  
}

function refreshPaymentsTable(pay){
//	if(paymentId == 0) {pay.obj.id = null};
	
//	var orderCkecked = getOrderCkeckedByURL();
//	if(orderCkecked == 0 || orderCkecked == 4){
//		payment.enableEdit = true;
//		payment.enableDel = true;
//		$("orderImgAdd").show();
//	}else{
//		payment.enableEdit = false;
//		payment.enableDel = false;
//		$("orderImgAdd").hide();
//	
//	}	
	
//	getPayMentTable(pay);
	payment.getContractPaymentsTable(pay.obj);  
	
//	getPayMentTable(payment);
}




function getOrderIdURL(){
	var ifContractId = getContractIdByURL();
	var orderId = 0;
	if(ifContractId==0){
		var url = window.location.href;
		orderId = getParamFromUrl(url,"orderId");
	}
	
	return  orderId;
}
function getContractIdByURL(){
	var url = window.location.href;
	var contractId = getParamFromUrl(url,"contractId");
	return  contractId;
}
function getMoneyRealPayByURL(){
	var url = window.location.href;
	var moneyRealpay = getParamFromUrl(url,"moneyRealpay");
	return  moneyRealpay;
}
function getCustomerIdByURL(){
	var url = window.location.href;
	var customerId = getParamFromUrl(url,"customerId");
	return  customerId;
}
function getOrderCkeckedByURL(){
	var url = window.location.href;
	var orderCkecked = getParamFromUrl(url,"orderCkecked");
	return  orderCkecked;
}
function getVersionByURL(){
	var url = window.location.href;
	var version = getParamFromUrl(url,"version");
	return  version;
}
function getPaymentIdByURL(){
	var url = window.location.href;
	var paymentId = getParamFromUrl(url,"paymentId");
	return  paymentId;
}

function getOrderDetailIdURL(){
	var url = window.location.href;
	var orderDetailId = getParamFromUrl(url,"orderDetailId");
	return  orderDetailId;
}



 //设置常量
function setPayMentPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className = "payment";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "0";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 obj.incomePurpose = new IncomePurpose();
}
 
 
//动作填充 
function button_add_new_obj(type){
	var contractId = getContractIdByURL();
	if(contractId > 0) return false;
	if(type == 0){
		payment.addNewRow('new',null);
	}
	$("incomePurposeId").value = "1";
}


//获得列表
function getPayMentTable(payment){
	var orderId = getOrderIdURL();
	var contractId = getContractIdByURL();
	var orderCkecked = getOrderCkeckedByURL();
  


	if((orderCkecked == 0 || orderCkecked == 4) && tag_orderDetail_save){
		payment.enableEdit = true;
		payment.enableDel = true;
		$("orderImgAdd").show();
	}else{
		payment.enableEdit = false;
		payment.enableDel = false;
		$("orderImgAdd").hide();
	
	}

	 
	payment.reset();
	payment.obj.orderId = orderId;
	payment.obj.contractId = contractId;
	payment.obj.orderCkecked = orderCkecked;
	payment.obj.withResourceSort = config_withResourceSort;

	var paymentId = getPaymentIdByURL(); 
	

	

	
	if(orderMainType == 0 && paymentId>0){ 
		payment.obj.id = paymentId;
	}	
	
	
	payment.getContractPaymentsTable(payment.obj);  
}

function getDiscount(payment){
	
	var url = window.location.href;
	var orderId = getParamFromUrl(url,"orderId");

	payment.reset();
	payment.obj.orderId = orderId;
	
					var func = function(str){
//								$("persent").value = str;
								DWRUtil.setValue("persent",str);
					}
	
	payment.getContractPaymentDiscount(payment.obj,func);  
}




function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == payment.pageInfo){
		var page = new Page(payment.pageInfo,payment.pageSize);
		page.goNextPage(pageIndex);
		payment.page = page;
		getPayMentTable(payment);
	}
}

function savePayment(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var paymentId = saveImgTd.getAttribute("paraId");
		var orderDetailId = getOrderDetailIdURL();
		var orderId = getOrderIdURL();
		var contractId = getContractIdByURL();
		var customerId = getCustomerIdByURL();
		var version = getVersionByURL();
		var moneyPay = $("moneyPay").value;
		var payDate = $("payDate").value;
		var resourceType = $("resourceType").value;
		var url_paymentId =  getPaymentIdByURL();
//	   if(orderMainType == 2) paymentId = 0;
		
//		alert('orderId'+orderId);
		
		if($("moneyPay").value == "" || $("moneyPay").value == 0) {alert("应付金额不能为0"); return false;}
			
       if(mode != 'new'){
	        var obj = saveImgTd.parentNode.parentNode.obj;
	        
			if(obj.moneyIn > 0 && moneyPay != obj.moneyPay ){
							alert("已有分配金额，请通知财务"); 
							return false;
			}else{
				         
							if(moneyPay != obj.moneyPay||resourceType != obj.resourceTypeId){
//								alert(moneyPay);alert(paymentId);
								var fnc = function(){
//								    getOrderDetail(orderDetailId);
//									getOrderTable(order);
//                                     alert(parent.document.init);
								}
                                if(resourceType != obj.resourceTypeId){
//                                    if(num ==1){
//                                    	orderDetail.saveContractPayMent(fnc,orderMainType,0,contractId,orderId,url_paymentId,obj.resourceTypeId*1);
//                                    }
                                	
                                	orderDetail.saveContractPayMent(fnc,orderMainType,moneyPay,contractId,orderId,url_paymentId,resourceType*1);
                                }else{
                                	orderDetail.saveContractPayMent(fnc,orderMainType,moneyPay,contractId,orderId,url_paymentId,resourceType*1);
                                }
								
//									
							}
			}
       }

//		var newMoneyPay = $("moneyPay").value*1;
//		
//		var moneyIn = getMoneyIn(paymentId,mode);
//		
//		if (mode == 'new'){
//			if((newMoneyPay == "" || newMoneyPay == 0)) {alert("应付金额不能为0"); return false;}
//			
//		}else{
//			if($("moneyPay").value*1 < moneyIn*1){alert("应付金额不能小于已分配金额"); return false;}		
//
//		}
//		var realMoneyPay = getMoneyRealPayByURL();
//		var moneyPaySum = getMoneyPaySum(paymentId,mode);
//		var isPass = checkMoneyPay(moneyPaySum,realMoneyPay,contractId);
//		if(!isPass) return false;
		
//		alert(parent.getElementById("customerId"));
//		alert(parent.document.getElementById("customerId"));
		
		payment.obj.id = paymentId;
		payment.obj.orderId = orderId;
		payment.obj.contractId = contractId;
		
	
		
		payment.obj.customerId = customerId;
		payment.obj.version = version;
		payment.obj.payDate = payDate;
		payment.obj.moneyPay = moneyPay;

//        alert(moneyPay);
		
//		payment.obj.memo = $("resourceType").value;
		payment.obj.resourceTypeId = $("resourceType").value;
		
		payment.savePayMent(payment.obj,mode);
		
		getPayMentTable(payment);
}

function delePayment(deleImg){
	var contractId = getContractIdByURL();
	if(contractId > 0) return false;
	var id = deleImg.getAttribute("paraId");
	var delRow = deleImg.parentNode.parentNode;
	
	var url = window.location.href;
	var ordId = getParamFromUrl(url,"orderId");
	payment.removePayMentNum(id,delRow,ordId);
	getPayMentTable(payment);

	
}
function cannelPayment(){
	$("hiddenArea").appendChild($("incomePurposeId"));
	$("hiddenArea2").appendChild($("resourceType"));
	
	getPayMentTable(payment);
}


function check_Eeit_State(){
	if(!isUndefined($('btn_SavePayment'))){
		cannelPayment();
	}
}

function getMoneyPaySum(id,mode){
	var trs = payment.tBody.getElementsByTagName("tr");
	var moneyPay = 0;
	var sumMoney = 0;
	var trId ;
	
	for(var i = 0;i<trs.length;i++){
		trId = mode == 'new' ? 0 : trs[i].obj.id;
		if(trId == id && id != ''){
			moneyPay = $("moneyPay").value == null?0:$("moneyPay").value*1;
			sumMoney += moneyPay;
		}else{
			if(i == trs.length-1 && mode == 'new'){
				moneyPay = $("moneyPay").value == null?0:$("moneyPay").value*1;
			}else{
				moneyPay = trs[i].obj.moneyPay*1;
			}
			sumMoney += moneyPay;
		}
	}
	return sumMoney;	
}
function getMoneyIn(id,mode){
	var trs = payment.tBody.getElementsByTagName("tr");
	var moneyIn = 0;
	
	for(var i = 0;i<trs.length;i++){
		trId = mode == 'new' ? 0 : trs[i].obj.id;
		
		if(trId == id && id != ''){
			
//			if(tvNameParam == 'xmtv' && orderMainType == 2){
			if(config_withResourceSort == 1){
				moneyIn = getCellValue(trs[i],5);
			}else{
				moneyIn = getCellValue(trs[i],4);
			}
			
		}else{
			moneyIn = 0;
		}
	}
	return moneyIn;
}
function checkMoneyPay(sumMoney,realMoneyPay,contractId){
//      alert(contractId);
	if(sumMoney > realMoneyPay && contractId ==0 ){
		alert("应付金额总和大于实际金额！实际金额为 " + realMoneyPay);
		return false;
	}else{
		return true;
	}
	
}
//function getDate(){
//	alert(0);
////	Calendar.setup({
////		inputField  : "payDate",	  // id of the input field
////		ifFormat	: "%Y-%m-%d",	  // the date format
////		button	  : "payDate"	// id of the button
////	});
//}


