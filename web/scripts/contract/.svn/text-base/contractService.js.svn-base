  
  
//实例化对象
 var payment = new PayMent();
 var resourceType = new ResourceType();
 var target = new Target();
 var user = new User();
 var order = new Order();
 var contract = new Contract();
 var dayInfo = new OrderDayInfo();
// var customer = new Customer();
 var category = new Category();
 var agentInfo = new AgentInfo();
 var popupcenter = new Popupcenter();
// var carrierType = new CarrierType();
 var carrier = new Carrier(); 
 var customer = new Customer();
 var orderDetail = new OrderDetail();
 var org = new SysOrg();
 var orgId = 1;

 var orderCodeModelParam;
 var channelModelParam;
 var contract_year;
 var config_serviceDate;
 var tvNameParam;
 var regCustomerWin;

 var subTableType;
 
 
 
 
 callOnLoad(init);	
 
 function init(){
 	

 	
	orderCodeModelParam = _app_params.sysParam.orderCodeModelParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;	
	userName =  _app_params.user.username;	
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	onfig_withResourceSort = _app_params.sysParam.withResourceSort;
	tvNameParam =  _app_params.sysParam.tvNameParam;    
	
	_make_adrm_sys_year_select("contract_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	
	var srcStr= window.location.href;	
	orgId  = getParamFromUrl(srcStr,"orgId");	
	contractSort  = getParamFromUrl(srcStr,"contractSort");	
	
     
		
	_make_org_select("orgId",120,"");	
	
	if(orgId > 0 ){
 			  $("orgId").value = orgId;
 	}else{
 			orgId =  $("orgId").value;
 	}
	 

	$("orgId").disabled = true; 
	 
	 getCustomerAutoCompltByName();
	 
	 
	 $("orgId_td").hide();

 	
 	
 	
// 	alert($("categoryId").value);
// 	alert($("customerCategoryId").value);
 
 	


 	
// 	alert($("customer.customerName").value);
 	 	
 	
// 	alert($("contractSort").value);
 	
 	orderMainType = $("contractSort").value;
 	
 	if(onfig_withResourceSort == 1){
 		 $("xmtvBranch").style.display ="block"; 
 	}
 	
// 	if(tvNameParam == 'xmtv' ){

       resourceType.obj.orgId = orgId;
       resourceType.obj.space = true;
 	   resourceType.makeSelectItemAnalyze(resourceType.obj,"resourceType",null);


// 	}
// 	
 
 	get_cur_year();
 	
 	if(orderCodeModelParam != 1){
 		$("code").disabled = false;
 	}
 	
// 	if(channelModelParam == 1){
// 	    initCarrier();
// 	}else{
// 	    $("carrierName").hide();
//	}
 	
 	
 	setUserPara(user);
 	setPayMentPara(payment); 	//设置常量
 	setOrderPara(order); 	   //设置常量
 	setTargetPara(target);
 	setContractPara(contract);
 	setOrderDayInfoPara(dayInfo);
 	setCustomerPara(customer);
 	setAgentInfoPara(agentInfo);
	setCarrierPara(carrier);
	
	
	var a = $("startDate").value;
	var b = $("endDate").value;
	var c = $("osignDate").value;
	var d = $("csignDate").value;
	
	getDate_date("startDate",a);
	getDate_date("endDate",b);
	getDate_date("osignDate",c);
	getDate_date("csignDate",d);

	carrier.reset();
	carrier.obj.parentId = 0;
	carrier.obj.version = contract_year;
	carrier.obj.orgId =$("orgId").value;
	carrier.makeSelectItem(carrier.obj,"carrierId1","");
	
 	disabledDestop();
 	if($("owner").value =="") setCurUser(user);
	getPayMentTable(payment); //获得表
	getTargetTable(target);
	getOrderTable(order);
	getAgentInfoTable(agentInfo);
	buttonEventFill();
//	$("customerName").value=$("customer.customerName").value;
	getDate_new();
	

//	getCustomerAutoComplt();
//	alert($("customerName").value);

        //$("contract_year").value = $("version").value;
        
   
        user.uddi1 = $("owner").value;
        user.uddi2 = $("orderRelation").value;
        user.makeSelectFromMapLimit("owner","",138);
        user.makeSelectFromMapLimit("orderRelation","",138,setCurUserId);

		resetHeigth();
}

function resetHeigth(){
	
   	var dialogcontent = $("dialogcontentDiv");
   	var otherInfoTable = $("otherInfoTable");
   	

	otherInfoTable.style.height =  dialogcontent.offsetHeight*0.55 +"px";	    

       	
       	
} 


function setCurUserId(){
	var contractId = $("id").value;
	

		if(contractId> 0){
		  $("owner").value = user.uddi1;
		  $("orderRelation").value = user.uddi2;
		}else{
		  $("owner").value = _app_params.user.id;
		   $("orderRelation").value =  _app_params.user.id;
		}

}

function get_cur_year(){
	var year = getParamFromUrl(window.location.href,"year");
	var yyyy = getDayPar(config_serviceDate,'y');
	if(year>0) yyyy = year;
	setSelectByValue($("contract_year"),yyyy);
	var version = $("version").value;
	
	if(version == ""){
		contract_year = $("contract_year").value;
		$("contract_year").disabled= false;
	}else{
	        $("contract_year").value = version;
		contract_year = version;
		$("contract_year").disabled= true;
	}
}

//function initCarrier(){
//    	carrier.obj.nodeLevel =1;
//	carrier.obj.enable = false;
//	//根据是否分频道，取得频道下拉列表
//	function fnct(){
//		var carrierId = $("carrierId").value;
//		if(carrierId > 0) $("carrierName").value = carrierId;
//	}
//	
//	if(channelModelParam!=1){
//		carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName","",fnct);
//	}else{
//		carrier.makeSelectItemAnalyze3(carrier,"carrierName","",fnct);
//	}	
//		
//}
	

function buttonEventFill(){
	
	var Bt_save = $("save");
	Bt_save.setAttribute("href","javascript:void 0");
	Bt_save.onclick = saveContact;
	
	var Bt_delete = $("delete");
	Bt_delete.setAttribute("href","javascript:void 0");
	Bt_delete.onclick = dele;	
	
	var Bt_cancel = $("cancel");
	Bt_cancel.setAttribute("href","javascript:void 0");
	Bt_cancel.onclick = cancel;	
	
	
	var change_contract_year = $("contract_year");
	change_contract_year.onchange = rest_contract_year;
	
//	if(onfig_withResourceSort == 1){
//		var contract_sort = $("contractSort"); 
//		contract_sort.onchange = contractSortChange;	
//	}

	
	
	document.body.onfocus = closePopup;	

}



function rest_contract_year(){
	contract_year = $("contract_year").value;
}


function getDate_new(name,defauleValue){
//	alert($("customerName").value=="");
	if($("customerId").value==""){
		getDate("startDate", _app_params.serviceDate.format1);
		getDate("endDate");
		getDate("osignDate");
		getDate("csignDate");
    }
}
function getDate(name,defauleValue){
	Calendar.setup({
		inputField  : name,	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : name	// id of the button
	});
	$(name).value = _app_params.serviceDate.format1;
}
function getDate_date(name,val){
	Calendar.setup({
		inputField  : name,	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : name	// id of the button
	});
	$(name).value = getFormatDay(val,'y/m/d');
}



function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "owner"; 
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setOrderDayInfoPara(obj){
	 obj.className ="dayInfo";
	 obj.IdPrefix 	= obj.className + "Id"; 
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
function setContractPara(obj){		
	 obj.className = "contract";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.customer = new Customer();
}
function setCustomerPara(obj){
	 obj.className = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setAgentInfoPara(obj){
	 obj.className = "agentInfo";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "4";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 
	 obj.carrier = new Carrier();
	 obj.resourceSort = new ResourceSort();
	 obj.category = new Category();
}
//设置常量
function setOrderPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className  = "order";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		 = $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}


function setTargetPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className = "target";
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		 = $(obj.fillObjName);
	 
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "4";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	 obj.carrier = new Carrier();
	 obj.industry = new Industry();

}

function setCurUser(obj){
    function getFun(id){
    	 $("owner").value = id;
    }
	user.getCurUserId($("config_username").value,getFun);
}


function disabledDestop(){
//	$("owner").disabled= "true";
	$("state").disabled= "true";
	var state = $("state").value;

	if(state != '2' || state == '3'){
		$("save").show();
		$("delete").show();
	}else{
		$("save").hide();
		$("delete").hide();
//		alert($("contractTargetTable").disabled);
		$("contractTarget").disabled = true;	
	}
}

//动作填充 
function button_add_new_obj(type){
	if(type == 0){
		payment.addNewRow('new',null);
		var m = getDayPar(config_serviceDate,'m');
		var d = getDayPar(config_serviceDate,'m');
	    contract_year = $("contract_year").value;
	    
	    $("payNumber").value = 1;
		$("payDate").value = contract_year+'/'+m +'/'+d;
	}
	
	if(type == 1){
		target.addNewRow('new',null);
	}
	if(type == 3){
		agentInfo.addNewRow('new',null);
	}
	subTableType = type;
}


//获得列表
function getPayMentTable(payment){
	
	var contractId = $("contractId").value;
	
	contractId = contractId != '' ? contractId : -1;
	
	payment.reset();
	payment.obj.contractId = contractId;
	payment.obj.withResourceSort = onfig_withResourceSort;
	payment.getContractPayments(payment.obj);
}
function getTargetTable(target){
	
	var func = function(objs){
		target.fillTalbe(objs);
		
		showCarrrier(target);
		
	}
	
	target.reset();
	target.obj.contractId = $("contractId").value;
	target.getTargets(func);
}
//获得列表
function getOrderTable(order){
	var contractId = $("contractId").value;
	if(contractId == ''){
		DWRUtil.removeAllRows(order.tBody);
	}else{
		order.reset();
		order.obj.contractId = contractId;
		
		//alert();
		function fct(objs){
			if(objs.length>0){
//				 $("customerName").disabled = true;
				Ext.fly('customerName').dom.disabled = true;
				 $("contractSort").disabled = true;
			}else{
				 $("contractSort").disabled = false;
			}
				
			order.fillTalbe(objs);
		}
		order.getOrders(order,fct);
	}

}
function getAgentInfoTable(agentInfo){
	
	var func = function(objs){
		agentInfo.fillTalbe(objs);
//		showCarrrier();
		showCarrrier(agentInfo);
	}
	
	agentInfo.reset();
	agentInfo.obj.contractId = $("contractId").value;
	agentInfo.getAgentInfosByContractId(agentInfo,func);
}

function showCarrrier(obj){
	var trs = obj.tBody.getElementsByTagName("tr");
	var carrierId1 = $("carrierId1");
	
	for(var k = 0;k<trs.length;k++){
		var cId = trs[k].obj.carrierId;
		carrierId1.value = cId;
		var selectedIndex = carrierId1.selectedIndex;
		var selectName = carrierId1.options[selectedIndex].text;

		setCellValue(trs[k],0,selectName);
	
	}
}

//function showTable(bln){
//	if(bln){
//		$("contractTarget").show();
//		$("contractPayment").hide();
//		$("orderList").show();
//	}else{
//		$("contractTarget").show();
//		$("contractPayment").show();
//		$("orderList").show();
//	}
//}
function contractSortChange(ev){
	orderMainType = $("contractSort").value;
	
	
	
		 
	if(onfig_withResourceSort ==1){
 		 $("xmtvBranch").style.display ="block";
// 		 resourceType.makeSelectItemAnalyze(resourceType.obj,"resourceType",null);
//        alert($("resourceType"));
// 		  $("hiddenArea2").appendChild($("resourceType"));
 	}else{
 		 $("xmtvBranch").style.display ="none";
 		 
 	}
 	
//	
//	if($("contractSort").value == 0){
//		
//		orderMainType = 0;
////		showTable(false);
////		alert(payment.obj.moneyIn);
//	}
//	if($("contractSort").value == 1){
//		
//		orderMainType = 2;
////		showTable(true);
//	}
	
	getPayMentTable(payment); //获得表
}
////翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == payment.pageInfo){
		var page = new Page(payment.pageInfo,payment.pageSize);
		page.goNextPage(pageIndex);
		payment.page = page;
		getPayMentTable(payment);
	}
	
	if(pageInfoName == target.pageInfo){
		var page = new Page(target.pageInfo,target.pageSize);
		page.goNextPage(pageIndex);
		target.page = page;
		getTargetTable(target);
	}
	if(pageInfoName == order.pageInfo){
		var page = new Page(order.pageInfo,order.pageSize);
		page.goNextPage(pageIndex);
		order.page = page;
		getOrderTable(order);
	}
	if(pageInfoName == agentInfo.pageInfo){
		var page = new Page(agentInfo.pageInfo,agentInfo.pageSize);
		page.goNextPage(pageIndex);
		agentInfo.page = page;
		getAgentInfoTable(agentInfo);
	}
}
function savePayment(){
       
        
       
		var Btn_SavePayment = $("btn_SavePayment");
		var paymentId = Btn_SavePayment.getAttribute("paraId");
	    var mode = Btn_SavePayment.getAttribute("mode");
		var moneyIn = getMoneyIn(paymentId,mode) ;
		var moneyPay = $("moneyPay").value;
		var resourceType = 0;
		var contractId = $("contractId").value;
		var orderId = 0 ;
		
        checkCustomer();
	
		
		if($("moneyPay").value == "" || $("moneyPay").value == 0) {alert("应付金额不能为0"); return false;}
		

       if(mode != 'new'){
	        var obj = Btn_SavePayment.parentNode.parentNode.obj;
	        
			if(obj.moneyIn > 0 && moneyPay != obj.moneyPay ){
							alert("已有分配金额，请通知财务"); 
							return false;
			}else{
				
							if(onfig_withResourceSort == 1){
								resourceType  =$("resourceType").value;
								if(resourceType == 0){
									alert("请选择部门"); 
									return false;
								}
								
							}
							
				            var trs = $("orderBody").getElementsByTagName("tr");
							if(moneyPay != obj.moneyPay && trs.length > 0){
//								alert(moneyPay);alert(paymentId);
								var fnc = function(){
									getOrderTable(order);
								}
//                               	alert(5555);alert(orderMainType);
                            
								orderDetail.saveContractPayMent(fnc,orderMainType,moneyPay,contractId,orderId,paymentId,resourceType);
							}
			}
       }


		
		
		function fnct(contractId){
//			var customerId = $("customerId").value;
//			customerId = customerId ==''|| customerId == 0 ?null:customerId;
//			var func = function(obj){
////				alert(obj.id);
//				$("customerId").value = obj.id;
////				customerId = obj.id;
//				save();
//			}
//			
//	
//			if(customerId==null){ 
//				customer.reset();
//				customer.obj.orgId = $("orgId").value;
//				customer.obj.customerName = $("customerName").value;
//				customer.getCustomerByObject(customer.obj,func);
//			}else{
//				save();
//			}

			save();
		
			function save(){
					payment.reset();
					DWRUtil.getValues(payment.obj);
					paymentId = paymentId ==''|| paymentId == 0 ?null:paymentId;
					payment.obj.id = paymentId;
					payment.obj.contractId = contractId;
					payment.obj.orderId = 0;
					payment.obj.customerId =  Ext.getCmp('customerName').getValue();	
					payment.obj.moneyIn =  moneyIn;
					payment.obj.payDate =  getFormatDay(payment.obj.payDate,'ymd'); 
					payment.obj.memo = $("resourceType").value;
					
					
					var osignDate = $("osignDate").value;
					
					payment.obj.version =  contract_year;
					
					//alert(version);
		
					function fnct(paymentId){
						payment.reset();
						payment.obj.contractId = contractId;
						$("hiddenArea").appendChild($("incomePurposeId"));	
						$("hiddenArea2").appendChild($("resourceType"));	
						getPayMentTable(payment);
						
		//				alert(contractId);
		//				payment.getContractPayments(payment.obj);
//						getPayMentTable(payment);
					}	
		//				alert(payment.obj.id);
		//				alert(payment.obj.contractId);
		//				alert(payment.obj.customerId);
		//				alert(payment.obj.moneyIn);
		//				alert(payment.obj.incomePurposeId);
		//				alert(payment.obj.payDate);
		//				alert(payment.obj.payNumber);
		
						
					payment.savePayMentCallBackFun(payment,fnct);
					
			}	
					
        }
        
		

        if($("contractId").value == ''){
        	save_contract(fnct);
        }else{
        	payment.obj.id = paymentId;
			payment.obj.contractId = $("contractId").value;
			payment.obj.customerId =  Ext.getCmp('customerName').getValue();	
			payment.obj.orderId = 0;
			
			var osignDate = $("osignDate").value;
			//var version = osignDate.substring(0,4);
			payment.obj.version =  contract_year;
			//alert(version);
			payment.obj.payDate = getFormatDay($("payDate").value,'ymd')*1; 
//			payment.obj.payDate = getFormatDay(payment.obj.payDate,'ymd')*1; 

			payment.savePayMent(payment.obj,mode);
			
			var trs = payment.tBody.getElementsByTagName("tr");
			if(trs.length > 0){
				function fnc(){
//					getPayMentTable(payment);
					getOrderTable(order);
				}
				orderDetail.saveContractPayMent(fnc,orderMainType,moneyPay,contractId,orderId,paymentId,resourceType);
			}
			
//			payment.getContractPayments(payment.obj);
			getPayMentTable(payment);
        }	
}

function saveTarget(){
	
		var Btn_SaveConTarget = $("btn_SaveConTarget");
		var targetId = Btn_SaveConTarget.getAttribute("paraId");
	    var mode = Btn_SaveConTarget.getAttribute("mode");

		
		function fnct(contractId){
			targetId = targetId ==''|| targetId == 0 ?null:targetId;
			DWRUtil.getValues(target.obj);
			target.obj.id = targetId;
			target.obj.contractId = contractId;
			target.obj.carrierId = $("carrierId1").value ;

			function fnct(targetId){
				target.reset();
				target.obj.contractId = contractId;
				$("hiddenArea").appendChild($("carrierSelect"));
				$("hiddenArea").appendChild($("industryTypeId"));
				getTargetTable(target);
			}	
			target.saveTargetCallBackFun(target,fnct);
        }
        
		

        if($("contractId").value == ''){
        	save_contract(fnct);
        }else{
        	target.obj.id = targetId;
			target.obj.contractId = $("contractId").value;
			target.saveTarget(target.obj,mode);
			getTargetTable(target);
        }		
}

function saveAgentInfo(){
	var Btn_SaveConTarget = $("btn_SaveAgentInfo");
	var agentInfoId = Btn_SaveConTarget.getAttribute("paraId");
	var mode = Btn_SaveConTarget.getAttribute("mode");	

	if($("resourceSortId").value == ''){
		alert("广告类型不能为空");
		return false;
	}
	if($("customerCategoryId").value == ''){
		alert("客户类别不能为空");
		return false;
	}
	
//	$("hiddenArea").appendChild($("carrierSelect"));
//	$("hiddenArea").appendChild($("resourceSortId"));
//	$("hiddenArea").appendChild($("customerCategoryId"));
//	agentInfo.obj.id = agentInfoId;
//	agentInfo.obj.enable = true;
//	agentInfo.saveAgentInfo(agentInfo.obj,mode);
//	getAgentInfoTable(agentInfo);
	

	
		function fnct(contractId){
			agentInfoId = agentInfoId ==''|| agentInfoId == 0 ?null:agentInfoId;
			DWRUtil.getValues(agentInfo.obj);
			agentInfo.obj.id = agentInfoId;
			agentInfo.obj.contractId = contractId;
			agentInfo.obj.enable = true;
			agentInfo.obj.carrierId = $("carrierId1").value;

			function fnct(agentInfoId){
				agentInfo.reset();
				agentInfo.obj.contractId = contractId;
				$("hiddenArea").appendChild($("carrierSelect"));
				$("hiddenArea").appendChild($("resourceSortId"));
				$("hiddenArea").appendChild($("customerCategoryId"));
				getAgentInfoTable(agentInfo);
			}	
			
		
			agntInfo.saveAgentInfoCallBackFun(agentInfo,fnct);
        }
        
		

        if($("contractId").value == ''){
        	save_contract(fnct);
        }else{
        	agentInfo.obj.id = agentInfoId;
        	agentInfo.obj.enable = true;
			agentInfo.obj.contractId = $("contractId").value;
//			agentInfo.obj.carrierId = $("carrierId1").value;
			agentInfo.saveAgentInfo(agentInfo.obj,mode);
			getAgentInfoTable(agentInfo);
        }		
	
}

function getMoneyIn(id,mode){
	var trs = payment.tBody.getElementsByTagName("tr");
	var moneyIn = 0;
	
	for(var i = 0;i<trs.length;i++){
		trId = mode == 'new' ? 0 : trs[i].obj.id;
		
		if(trId == id && id != ''){
			if(onfig_withResourceSort ==1){
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

function delePayment(deleImg){
	var id = deleImg.getAttribute("paraId");
	var delRow = deleImg.parentNode.parentNode;
	
	var func = function(size){
//		alert(size);
		if(size > 0){
			alert("不允许删除");
			return false;
		}else{
			payment.removePayMent(id,delRow);
			getPayMentTable(payment);
		}
	}
	
	order.reset();
	order.obj.paymentId = id;
	order.getOrdersByPaymentId(order.obj,func);
	
}
function cannelPayment(){
	$("hiddenArea").appendChild($("incomePurposeId"));
	$("hiddenArea2").appendChild($("resourceType"));
	getPayMentTable(payment);
}


function delTarget(deleImg){
	var id = deleImg.getAttribute("paraId");
	var delRow = deleImg.parentNode.parentNode;
	
	target.removeTarget(id,delRow);
	
	getTargetTable(target);
}

function cannelTarget(){
	 $("hiddenArea").appendChild($("carrierSelect"));
	 $("hiddenArea").appendChild($("industryTypeId"));
	 getTargetTable(target);
}

function cancel(){
	var type = getParamFromUrl(window.location.href,"type");
	var contractSort = $("contractSort").value;
	var carrierId = getParamFromUrl(window.location.href,"carrierId");
	var pageIndex = getParamFromUrl(window.location.href,"pageIndex");
	if(pageIndex == null || pageIndex =="") pageIndex = 1;
	if(carrierId == null || carrierId =="") carrierId = 0;
	if(type == null || type =="") type = 1;
	var orgId =$("orgId").value;
	
//	alert($("customer.customerName").value);
	parent.location.href ="contracts.html?pageIndex="+ pageIndex +"&type="+type +"&carrierId="+carrierId+"&year="+contract_year+"&orgId="+orgId+"&contractSort="+contractSort;
//	 parent.location.href =document.referrer;
}

function saveContact(){
	
	

	var type = $("type").value;

	function saveContract(id){	
//		subTableType

		var Btn_SavePayment = $("btn_SavePayment");
		
	    if(!isUndefined(Btn_SavePayment)){
	        savePayment();
	    }else{
	    	payment.reset();
	    	payment.obj.contractId = id;
	    	payment.obj.version = contract_year;
	    	payment.saveContractPaymentVersion(payment.obj);
	    }
	    var Btn_SaveConTarget = $("btn_SaveConTarget");
	    if(!isUndefined(Btn_SaveConTarget)){
	        saveTarget();
	    }
	    var Btn_SaveAgentInfo = $("btn_SaveAgentInfo");
	    if(!isUndefined(Btn_SaveAgentInfo)){
	        saveAgentInfo();
	    }
	    
	    $("contractId").value = id;
//		parent.location.href ="contracts.html?pageIndex="+getPageIndexByURL()+"&type="+getTypeByURL();
	}
	save_contract(saveContract);
}



function save_contract(callBackFun){
	var isCheck = isPass(); if(!isCheck) return false;
	
	var conId = $("contractId").value;
//	var customerName=$("customerName").value;
//	var customerId = $("customerId").value;
//	var customerCategoryId = getParamFromUrl(window.location.href,"type");
//	customerCategoryId = customerCategoryId == 1||customerCategoryId == null?2:customerCategoryId;
	
	var carrierId = $("carrierId").value;
	carrierId = carrierId == ''|| carrierId == null?0:carrierId;
	if(channelModelParam != 1) carrierId = 0;
	
//	customerId = customerId == ''|| customerId == '0'?null:customerId;
	DWRUtil.getValues(contract.obj);
	conId = conId == ''|| conId == '0'?null:conId;
	
	contract.obj.id = conId;
	contract.obj.customerId =  Ext.getCmp('customerName').getValue();
	
//	contract.obj.customer = (new Customer()).obj;
//	contract.obj.customer.id  = $("customerId").value;
//	contract.obj.customer.orgId = $("orgId").value;
//	contract.obj.customer.customerName = customerName;
//	contract.obj.customer.customerCategoryId = customerCategoryId;	
	
	contract.obj.startDate = getFormatDay(contract.obj.startDate,'ymd');
	contract.obj.endDate = getFormatDay(contract.obj.endDate,'ymd'); 
	contract.obj.osignDate = getFormatDay(contract.obj.osignDate,'ymd'); 
	contract.obj.csignDate = getFormatDay(contract.obj.csignDate,'ymd'); 
	contract.obj.version =  contract_year;
	contract.obj.carrierId =  carrierId;
	contract.obj.orgId = orgId;
//	contract.obj.state = 3;
//	contract.updateContractStates(conId,3);
	
//	if(customerId == null){
//		 $("customerId").value = customer.getCustomer()
//	}

	
	function saveContract(obj){	
		var id  = obj.id;
		$("contractId").value = id;
//		$("customerId").value = obj.customerId;
		$("code").value = obj.code;
		alert("保存成功");
		callBackFun(id);
	}
	
    
    contract.saveContractReturnObj(contract,saveContract);
	//contract.saveContract(contract,saveContract);
}

function dele(){
	var conId = $("contractId").value;
	var removeFun = function(){
	var type = getParamFromUrl(window.location.href,"type");
	var pageIndex = getParamFromUrl(window.location.href,"pageIndex");
	var carrierId = getParamFromUrl(window.location.href,"carrierId");
//    var contractSort= getParamFromUrl(window.location.href,"contractSort");
    var contractSort = $("contractSort").value;
	
	if(pageIndex == null || pageIndex =="") pageIndex = 1;
	if(carrierId == null || carrierId =="") carrierId = 0;
	if(type == null || type =="") type = 1;
		
	parent.location.href ="contracts.html?pageIndex="+ pageIndex +"&type="+type +"&carrierId="+carrierId+"&contractSort="+contractSort;
	}
	contract.removeContractR(removeFun,conId);
}



function cannelAgentInfo(){
//	alert($("customerCategoryId").value);
	 $("hiddenArea").appendChild($("carrierSelect"));
	 $("hiddenArea").appendChild($("resourceSortId"));
	 $("hiddenArea").appendChild($("customerCategoryId"));
	 getAgentInfoTable(agentInfo);
}

function delAgentInfo(deleImg){
	var id = deleImg.getAttribute("paraId");
	var delRow = deleImg.parentNode.parentNode;
	agentInfo.removeAgentInfo(id,delRow);
	getAgentInfoTable(agentInfo);
}

function checkContract(){
	var contractId = $("contractId").value;
	
	if(contractId == ''){
		alert("请先保存合同！");
		saveContact();
//		return false;
	}else{
		return true;
	}
	return true;
}

function getCustomerAutoComplt_bak(){
	customer.reset();
	var type = getParamFromUrl(window.location.href,"type");
	type=type==1?null:type;
//	customer.obj.customerCategoryId = type; 
	
	function fun(userId){
		customer.getCustomerAutoComplet2(userId,type,payCustomerAutoComplet);
	}
	user.getCurUserId($("config_username").value,function(id){fun(id)});
}

function payCustomerAutoComplet(objs)
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
		$("categoryId").value = getCellValue(tr,3);
		
		oText.value = getCellValue(tr,2);
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '0';
			$("categoryId").value = '0';
		
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
	
//	var oText_customerId = $("customerName");
//	var oDiv_customerId = $("theDivCustomerName");
//	var indexColumName_customerId = ["customerName"];
//	var allColumsName_customerId =["id","customerName"];
//	var onDivMouseDown_customerId = function(ev){
//
//		var tr = getElementByEvent(ev);
//		$("customerId").value = getCellValue(tr,0);
//		$("customerName").value = getCellValue(tr,1);
//		oText_customerId.value = getCellValue(tr,1);
//	}
//	var hidenColumName = ["id"];
//	var onTextBlur = function(ev){
//		oDiv_customerId.style.visibility = "hidden";
//		if(trim(oText_customerId.value) == "" ){
//			$("customerId").value = '0';
//		}
//	}
//   new AutoComplete(objs,oText_customerId,oDiv_customerId,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerId,allColumsName_customerId);
   
   //给文本写数值
//   var index =  $("customerId").value;
//   if(index > 0)$("customerName").value =  getColValueFromObjs(objs,index,"id","customerName");
}

function isPass(){
	
//getFormatDay
	if($("owner").value == ''){alert("合同所有人未填"); return false;}
//	if($("code").value == ''){alert("合同编号未填"); return false;}
//	if($("customerName").value == ''){alert("客户名称未填"); return false;}
	if((getFormatDay($("startDate").value,'ymd')) == ''){alert("开始日期未填"); return false;}
	if((getFormatDay($("endDate").value,'ymd')) == ''){alert("结束日期未填"); return false;}
    
    var customerId =  Ext.getCmp('customerName').getValue();	
	var customerName =  Ext.fly('customerName').dom.value; 

	if((customerId == customerName && customerId !='')||  customerName=='请选择...'){
		if( customerName!='请选择...'){
			checkCustomer();
		}else{
					Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"请选择客户名称!",width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
		}
		
		
		 return false;
	}
    
    
	return true;
}




function autoBroArrange(targetId){
	popupcenter.url = "selectPopup/selectContractTargetMonth.html?id=" + targetId;
	popupcenter.model = 6;
	popupcenter.popupcenter(popupcenter);
}

function closePopup(ev){
	popupcenter.closePopup(popupcenter);
}
function editOrderInfo(orgId,orderId){
//	parent.location.href ="editOrder.html?id="+orderId+"&d-3682230-p=1";
	popupcenter.url = "editOrder.html?id="+orderId+"&orgId=" +orgId;
//	popupcenter.model = 10;
	popupcenter.popupcenter(popupcenter);
}









function getCustomerAutoCompltByName(){


        var mode = 'remote';
        customer.obj.orgId = orgId;
    	customer.storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);    

		customer.customerCommand = new Ext.form.ComboBox({
		 	  id:'customerName',
		 	  name:'customerName',
	//	 	  applyTo: 'extCustomerDiv',
			  renderTo:'extCustomerDiv',
			  tiggerAction:'all',
			  store:customer.storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			  width:138,
			  forceSelection:false, 
			  allowBlank:false,
			  emptyText:'请选择...',
			  minChars:2,
			  hiddenName:'helpCode', //提交传过去的值 
			  filterFiled:'customerName',
			  params:customer.obj,
			  listeners:{
			  	beforequery:customer.comboFilterBy2.createDelegate(this)}
			  	
		 });




       function getcheckCustomer(){
       		checkCustomer();
       }
		
		customer.customerCommand.on("blur",getcheckCustomer,this);	
		
		inti_set_customer(1,$("customerId").value,$("customer.customerName").value,$("customerCategoryId").value);

	

}


function checkCustomer(){
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.3;
	var winH = dialogcontentH*0.3;
	var customerName =  Ext.fly('customerName').dom.value; 
	var customerId =  Ext.getCmp('customerName').getValue();	


//	alert('customerId>>>'+customerId);
//		alert('customerName>>'+customerName);
//	alert('customerId'+$("customerId").value);
//	!isInteger(customerId) && 
	

	if((customerId == customerName && customerId !='')||  customerName=='请选择...'){

			var cut = (new Customer()).obj;
			
			 var closeBtn ={text: '取消',handler: function(){regCustomerWin.hide();}};
			
			 var regBtn ={text: '注册',handler: function(){

			 	    cut.id = null;
			 	    cut.orgId = orgId;
			 	    cut.customerName = Ext.fly('regCustomerName').dom.value.Trim();
			 	    cut.customerCategoryId = getRadioValue($("regCustomerCategoryName_td"));
			 	    cut.parentId = 0;
			 	    
  
			 	    if(cut.customerCategoryId =='' || cut.customerCategoryId == null){
			 	    	Ext.MessageBox.hide(); 
						Ext.MessageBox.show(
								 	{title:'系统提示!',msg:"请选择客户类型!",width:300,heigth:200,buttons: Ext.MessageBox.OK, icon: Ext.MessageBox.INFO}
						);  
			 	    	return false;
			 	    }
			
				   var regcustomerName =  Ext.fly('regCustomerName').dom.value; 
				   var regcustomerId =  Ext.getCmp('regCustomerName').getValue();	
	               if(regcustomerId == regcustomerName && regcustomerId !=''){
	               	  customer.saveCustomerForm(cut,callBakFun);
	               }else{
	               	  callBakFun(regcustomerId);
	               }

			 }};	
			 
			 function callBakFun(id){
//			 	    	alert(id);
			 	    	inti_set_customer(1,id,cut.customerName,cut.customerCategoryId);
//			 	    	order.obj.customerId = id;
			 	    	$("customerId").value = id;
			 	    	regCustomerWin.hide();

			 }	


    
     if(!regCustomerWin){
     	
     	  buildRegCustomer(winW,winH*0.8,customerName);
     	  
		  regCustomerWin = new Ext.Window({
			   title : '此客户还未注册，请为它选择客户类别',
			   width : winW,
			   height : winH,
			   isTopContainer : true,
			   modal : true,
			   resizable : false,
			    buttons: [regBtn,closeBtn],
			   contentEl :  $("regCustomer_table")
		  	})     	
     }else{
     	 customer.regcustomerCommand.setValue(customerName);  

     }


 	regCustomerWin.show(); 	
	
	}
	
}


function inti_set_customer(i,id,customerName,customerCategoryId){
	var rc1 = Ext.data.Record.create(customer.fileds);
    var rc = new rc1({
           id : id,
           customerCategoryId : customerCategoryId,
           customerName:customerName
     });
     
   if(i == 1){
       customer.customerCommand.clearValue(); 
   	   customer.customerCommand.store.add(rc);
   	   customer.customerCommand.setValue(id);  
   }else{
   	   customer.regcustomerCommand.clearValue(); 
   	   customer.regcustomerCommand.store.add(rc);
   	   customer.regcustomerCommand.setValue(id);  
   }
   
	$("customerId").value = id;
//	$("customerCategoryId").value = customerCategoryId;

}



function buildRegCustomer(winW,height,customerName){
//	ctxPath = $("ctxPath").value;
	
	//创建客户类别
	category.makeOptionsCallBackFun(category,fillFun);	
	function fillFun(objs){
			makeOptionsHtml(objs,"radio","regCustomerCategoryName","categoryName","id","","",[1]);
			setRadioCheckedByValue($("regCustomerCategoryName_td"),2);
	}	
	

	regCustomerComboBox(winW,customerName);
	
	
	
	function onRowSelectd(id,cellInd){
		 var customerName = this.getUserData(id,"customerName");
		 var customerCategoryId = this.getUserData(id,"customerCategoryId"); 
		 inti_set_customer(2,id,customerName,customerCategoryId);
	}

     $("gridbox_regCustomer").style.height =  0 +"px";
    $("gridbox_regCustomer").style.width =  winW*0.98 +"px";


}

function regCustomerComboBox(winW,customerName){

        var mode = 'remote';
        customer.obj.orgId = orgId;
    	

        
        if(!customer.regcustomerCommand){
        	var storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);    
 			customer.regcustomerCommand = new Ext.form.ComboBox({
 			  fieldLabel: '待注册客户',
		 	  id:'regCustomerName',
		 	  name:'regCustomerName',
			  renderTo:'regCustomerDiv',
			  tiggerAction:'all',
			  store:storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			  width:winW*0.7,
//			  readOnly:true,
			  forceSelection:false, 
//			  blankText: "不能为空，请填写",
			  allowBlank:false,
			  emptyText:'请选择...',
			  minChars:2,
			  hiddenName:'helpCode', //提交传过去的值 
			  filterFiled:'customerName',
			  params:customer.obj,
//			  valueNotFoundText:"新客户",
			  listeners:{
			  beforequery:customer.comboFilterBy2.createDelegate(this)}
			  	
			 });       	
        }

		 
		 customer.regcustomerCommand.setValue(customerName);  
		 
		function callBack(cbo,e){
		  	    var id = cbo.value;
	            var rec = cbo.store.getById(id)

	    }
	            
//		customer.regcustomerCommand.on("select",callBack,this);	
//		customer.regcustomerCommand.on("collapse",callBack,this);	

}
