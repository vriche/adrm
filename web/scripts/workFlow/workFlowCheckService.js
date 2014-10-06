//实例化对象
 var user = new User();
 var contract = new Contract();
 var order = new Order();
 var checkState = new OaWorkFlowCheckState();
 var workFlowType = new OaWorkFlowType();
 var checkResult = new OaWorkFlowCheckResult();
 var workFlowCheck = new OaWorkFlowCheck();
 var workFlow = new OaWorkFlow();
 var popupcenter = new Popupcenter();
 var carrier = new  Carrier();
 var customer = new Customer();
 var orderCode;
 var workFlowId1 ;
 var state1;
 var ispage;
 var order_year;
 var config_serviceDate;
 var channelModelParam;
 
 callOnLoad(init);	
 
 function init(){	
 	config_serviceDate = _app_params.serviceDate.def;
 	tvNameParam =  _app_params.sysParam.tvNameParam;	
 	channelModelParam = _app_params.sysParam.channelModelParam;
 	loginUserName =  _app_params.user.username;
 	
 	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
 	_make_org_select("orgId",120,"getTable");	

 	get_cur_year();
 	
 	setUserPara(user);
 	setWorkFlowPara(workFlow);//主任审批
	setContractPara(contract); 	
	setOrderPara(order);				
	setWorkFlowTypePara(workFlowType);
	setCheckStatePara(checkState);
	setCheckResultPara(checkResult);
	setCarrierPara(carrier);
	setCustomerPara(customer);
	



	getUserAutoComplt();
	getCustomerAutoComplt();
	
	user.makeCurrentUserSelect(user.selectName,"");
	workFlowType.makeSelect(workFlowType.selectName,"");//订单和合同
    
	$(workFlowType.selectName).value = 2;
	
	setWorkFlowSelect();
	

	//checkResult.makeOptions(checkResult.radioName,"radio","","",[]);//同意和不同意
	//checkState.makeOptions(checkState.radioName,"radio","getTable","",[2]);

	buttonEventFill();
	
//	$("orderPageInfo1").value="业务员"	;


     
	var fct = function(){
 		//category.makeOptionsCallBackFun(category,fillFun);
 				   
 		getTable();					//获得列表	
 	}
 	
	if(channelModelParam == 1){

 	    initCarrier(fct);
 	}else{
 	    $("carrierName").hide();

 	    getTable();					//获得列表	
	}
	
}


function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
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
//	if(channelModelParam!=1){
//		carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName","",fnct);
//	}else{
////		carrier.makeSelectItemAnalyze3(carrier,carrier.selectName,"onCheckStateChanged",100,false,fnct);
//		carrier.makeSelectItemAnalyze5(carrier,"carrierName","onCheckStateChanged",100,false,userName,fnct); 
//	}	
	
	carrier.makeSelectItemAnalyze5(carrier,"carrierName","onCheckStateChanged",100,false,loginUserName,fnct); 
		
}




function get_cur_year(){
	var yyyy = getDayPar(config_serviceDate,'y');
	setSelectByValue($("order_year"),yyyy);
	order_year = $("order_year").value;
}

function buttonEventFill(){
	var contractAllSelect = $("contractAllSelect");
	contractAllSelect.onclick = allSelectCheckBox;		
	contractAllSelect.setAttribute("parnetObjName",contract.tableName);
	
	
	var orderAllSelect = $("orderAllSelect");
	orderAllSelect.onclick = allSelectCheckBox;		
	orderAllSelect.setAttribute("parnetObjName",order.tableName);
	
	//var btn_sav_chechResult = $("btn_sav_chechResult");
	//btn_sav_chechResult.onclick = saveChechResult;	
	
	
	var btn_sav_agree = $("btn_agree");
	btn_sav_agree.onclick = saveChechResult3;	
	
	
	var btn_sav_dissent = $("btn_dissent");
	btn_sav_dissent.onclick = saveChechResult4;			
	
	
	
	var btn_chose_workFlowType = $(workFlowType.selectName);
//	btn_chose_workFlowType.onclick = getTable;	
//	btn_chose_workFlowType.onchange = setWorkFlowSelect;
//	btn_chose_workFlowType.onclick = getTable;	
	btn_chose_workFlowType.onchange = getTable;
		
	var btn_chose_workFlow = $(workFlow.selectName);
	btn_chose_workFlow.onchange = workFlowSelectChange;
	
	var btn_search_order = $("searchOrder");
	btn_search_order.onclick = searchOrderBtn;
	
	var Btn_orderName = $("order_code");
	if(!isUndefined(Btn_orderName)){
		Btn_orderName.onclick = resetOrderText;
		Btn_orderName.onkeypress=onkeypressOrderCode;
	}
	var Btn_userName = $("userName");
	if(!isUndefined(Btn_userName)){
		Btn_userName.onclick = resetUserText;
	}
	
	
	var Btn_customerName = $("customer_name");
	if(!isUndefined(Btn_customerName)){
		Btn_customerName.onkeypress= getCustomerAutoCompltByName;
		Btn_customerName.onclick = resetCustomerName;
//		Btn_customerName.onchange = onCheckStateChanged;
	 }	
	
	var change_order_year = $("order_year");
	change_order_year.onchange = rest_order_year;
	
	
	document.body.onfocus = closePopup;
}
function resetCustomerName(ev){
	 $("customer_name").value = null;
	// onCheckStateChanged();
}
function rest_order_year(){
	order_year = $("order_year").value;
	contract.page.pageIndex =1;
	order.page.pageIndex =1;
	getTable();
}

 function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	obj.selectName = obj.className+"Name";
}
 

function getUserAutoComplt(){
	user.getUserAutoComplt(user.obj,payUserAutoComplet);
}
function payUserAutoComplet(objs)
{
//	alert(objs);
	var oText = $("userName");
	var oDiv = $("theDivuserName");

	var indexColumName_customerName = ["fullName"];
	var allColumsName_customerName =["id","fullName"];
	var hidenColumName = ["id"];
	var allColumsTitle = ["业务员"];
	
	var onDivMouseDown_userId = function(ev){

		var tr = getElementByEvent(ev);
		$("userId").value = getCellValue(tr,0);
//		alert(getCellValue(tr,0)+"   "+getCellValue(tr,1));
		$("userName").value = getCellValue(tr,1);
		
		oText.value = getCellValue(tr,1);
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("userId").value = '0';
//			getTable();
		
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_userId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
//   var index =  $("userId").value;
//   if(index > 0){
//   		$("userName").value =  getColValueFromObjs(objs,index,"id","fullName");
//   }else{
//   		$("userName").value = null;
//   }

}

function resetOrderText(ev){
	 $("order_code").value = null;
	 $("id").value = null;
}

function resetUserText(ev){
	 $("userName").value = null;
	 $("userId").value = null;
}

function closePopup(ev){
	popupcenter.closePopup(popupcenter);
}
function setContractPara(obj){
	 obj.className ="contract";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.checkBoxName = obj.className +"Check";
	 obj.color1 		= "BACKGROUND-COLOR: #white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 obj.enableEdit	= true;
	 obj.enableDel	= true;	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "9";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function setOrderPara(obj){
	 obj.className ="order";
	 obj.IdPrefix 	= obj.className +"Id";
	 obj.tableName   = obj.className +"Table";
	 obj.fillObjName = obj.className +"Tbody";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.checkBoxName = obj.className +"Check";
	 obj.color1 		= "BACKGROUND-COLOR: #white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 obj.enableEdit	= true;
	 obj.enableDel	= true;	 
	 obj.pageInfo 	= obj.className +"PageInfo";
	 obj.pageSize 	= "12";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function setUserPara(obj){
	 obj.className ="user";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "checkUserId"; 
}

function setCheckStatePara(obj){
	 obj.className ="OaWorkFlowCheckState";
	 obj.radioName = obj.className +"RN";
//	 obj.checkBoxTarg 	= $(obj.className +"CheckBox");
//	 obj.checkBoxName = obj.className +"CN";
//	 
//	 obj.selectTarg =  $(obj.className +"Select");
//	 obj.selectName =  obj.className + "SN";
}

function setWorkFlowTypePara(obj){
	 obj.className ="OaWorkFlowType";
//	 obj.selectName =  obj.className + "SN";
	 obj.selectName =  "workFlowTypeId";
}

function setCheckResultPara(obj){
	 obj.className ="OaWorkFlowCheckResult";
	 obj.radioName =  obj.className + "RN";
}

function setWorkFlowPara(obj){
	 obj.className ="workFlow";
	 obj.selectName =  "workFlowId";
}

function onCheckStateChanged(){
	contract.page.pageIndex =1;
	order.page.pageIndex =1;
	getTable();	
}

function setWorkFlowSelect(){
	var type =  $(workFlowType.selectName).value;
    var userId = $(user.selectName).value;
    
    workFlow.makeSelect(type,userId,workFlow.selectName,"");
    var workFlowId = $(workFlow.selectName).value;
    
//    alert(workFlowId);
    
    if(workFlowId != ""){
    	
    	var obj = workFlow.getOaWorkFlow($(workFlow.selectName).value);	
		DWRUtil.setValues(workFlow.obj);
		
		
		
		if(workFlow.obj.isEndPoint){
			// DWRUtil.removeAllOptions($(checkState.radioName));
			 checkState.makeOptions(checkState.radioName,"radio","onCheckStateChanged","",[0,2,4,5,6,7]);
		}else{
//			 DWRUtil.removeAllOptions($(checkState.radioName));
			checkState.makeOptions(checkState.radioName,"radio","onCheckStateChanged","",[0,2,5,6,7]);
		}
//		alert(workFlow.obj.isEndPoint);
//		$("isEndPoint").value = workFlow.obj.isEndPoint;
		
    }
    
//    getTable();

}

function workFlowSelectChange(){
	 var workFlowId = $(workFlow.selectName).value;
	 
	 if(workFlowId != ""){
    	var obj = workFlow.getOaWorkFlow($(workFlow.selectName).value);	
    	DWRUtil.setValues(workFlow.obj);
    	getTable();
    }
}


function payOrderAutoComplet(objs)
{
	var oText_orderId = $("order_code");
	var oDiv_orderId = $("theDivorderCode");
	
	var indexColumName_orderId = ["orderCode"];
	var allColumsName_orderId =["id","orderCode"];
	var allColumsTitle_order = [];

	var onDivMouseDown_orderId = function(ev){
		var tr = getElementByEvent(ev);
		$("id").value = getCellValue(tr,0);
		$("orderCode").value = getCellValue(tr,1);
//		var orderCode = getCellValue(tr,1);
		oText_orderId.value = getCellValue(tr,1);
		
//		searchOrder(orderCode);
		
	}
	
	var hidenColumName = ["id"];
	
	var onTextBlur = function(ev){
		oDiv_orderId.style.visibility = "hidden";
		if(trim(oText_orderId.value) == "" ){
			$("id").value = null;
		    $("orderCode").value = null;
//		    getTable();
// 			order.getContractsByWorkFlowPage(workFlowId,state,payOrderAutoComplet); 	
		}
	}
    new AutoComplete(objs,oText_orderId,oDiv_orderId,-1,onDivMouseDown_orderId,onTextBlur,hidenColumName,indexColumName_orderId,allColumsName_orderId,allColumsTitle_order);
  
   //给文本写数值
//   var index =  $("id").value;//alert(index);
//   if(index > 0){
//  	 	$("order_code").value =  getColValueFromObjs(objs,index,"id","orderCode");
//   }else{
//   		$("orderCode").value = null;
//   }
}
function getTable(){
	
//	ispage="getTable";
	var type =  $(workFlowType.selectName).value;//1合同 2订单
	var userId = $(user.selectName).value;
	workFlow.makeSelect(type,userId,workFlow.selectName,"");//随type的改变而改变
	
	workFlowId1 =  $(workFlow.selectName).value;//主任
	
	

	state1 = getRadioValue($(checkState.radioName));//4种状态
	
	var userId=$("userId").value;
	var carrierId = $("carrierName").value;
	
	var	orderCode = $("order_code").value;
	if(userId==0)userId=null;
	if(orderCode=="==订单编号==")orderCode=null;
	
	var customerName = $("customer_name").value;
	if(customerName.indexOf("=") > -1) customerName = null;
	order.obj.customer = (new Customer()).obj;
	
	if(state1 == "") state1 =1;
	//if(state1 == 1 &&fztvSpecialParam==1) state1="0";
	//alert(type);alert(workFlowId1);alert(state1);alert(userId);


	if(type == 1){
		$(contract.tableName).show();
		$(order.tableName).hide();
	}
		 
	if(type == 2){
		$(order.tableName).show();
		$(contract.tableName).hide();
	}

	if(workFlowId1 !="" && state1 !=""){
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		function fnc(){
			Ext.getBody().unmask();
		}
		

		
        if(type == 1){
        	 contract.getContractsByWorkFlowPage(workFlowId1,state1,fnc);  

        }
		if(type == 2) {
			//order.reset();
			order.obj.isCkecked = state1;
			order.obj.userId = userId;
			order.obj.orderCode = orderCode;
			order.obj.version = order_year;
			order.obj.customer.customerName = customerName;
			order.obj.orgId= $("orgId").value;
	
	
			if(channelModelParam == 1){
				order.obj.carrierId = carrierId;
			}
			
			order.getContractsByWorkFlowPage(workFlowId1,order,fnc); 	
			
		}	
	}
}




function searchOrderBtn(){
	contract.page.pageIndex =1;
	order.page.pageIndex =1;
	getTable();
//	searchOrder(true);
}

function searchOrder(isFirstPage){
	ispage="searchOrder";
	orderCode = $("order_code").value;
//	var carrierId = $("carrierName").value;
	var userId=$("userId").value;
	
	if(orderCode=="==订单编号==")orderCode=null;
	if(userId==0)userId=null;
//	alert(orderCode+"   ");
//	if(orderCode==0)orderCode=null;
//	order.obj.orderCode = orderCode;

        
	if(isFirstPage) order.page.pageIndex = 1;
	
	
	order.getOrdersByWorkFlowPageSearch(workFlowId1,state1,orderCode,userId);
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == order.pageInfo){
		var page = new Page(order.pageInfo,order.pageSize);
		page.goNextPage(pageIndex);
//		order.reset();
		order.page = page;
//		if(ispage=="getTable"){
			getTable();	
//		}
//	if(ispage=="searchOrder"){
//		         
//			searchOrder(false);
//		}
	}
	if(pageInfoName == contract.pageInfo){
		var page = new Page(contract.pageInfo,contract.pageSize);
		page.goNextPage(pageIndex);
		contract.page = page;
		getTable(contract);	
	}	
}

function saveChechResult3(){
	var type =  $(workFlowType.selectName).value;
	if(type == 1){
		 var contracts = getCheckBoxValues(contract.tBody,1);	
		 if(contracts.length == 0) return false;
	}	
	if(type == 2){
		 var orders = getCheckBoxValues(order.tBody,1);	
		  if(orders.length == 0) return false;
	}	
	if(type == 3){
		  var applys = getCheckBoxValues(order.tBody,1);
		   if(applys.length == 0) return false;	
	}
	
	
	var state1 = getRadioValue($(checkState.radioName));//4种状态
	if(state1 == 3){
	   alert("已经是通过的订单，不需要重复确认!");
	   return false;
	}
	var msg = "请确认是否 通过 ?";
	ans = confirm(msg);
	if(ans) saveChechResult(3);
}

function saveChechResult4(){
	var type =  $(workFlowType.selectName).value;
	if(type == 1){
		 var contracts = getCheckBoxValues(contract.tBody,1);	
		 if(contracts.length == 0) return false;
	}	
	if(type == 2){
		 var orders = getCheckBoxValues(order.tBody,1);	
		  if(orders.length == 0) return false;
	}	
	if(type == 3){
		  var applys = getCheckBoxValues(order.tBody,1);
		   if(applys.length == 0) return false;	
	}	
	
	
	
	var msg = "请确认是否 退回 ?";
	ans = confirm(msg);	
	if(ans) saveChechResult(4);
}

function saveChechResult(chechResultPara){
	var type =  $(workFlowType.selectName).value;
	var obj = workFlowCheck.obj;
	var  state = getRadioValue($(checkState.radioName));
	DWRUtil.getValues(obj);
	
	if(type == 1){
		 obj.contracts = getCheckBoxValues(contract.tBody,1);	
	}	
	if(type == 2){
		 obj.orders = getCheckBoxValues(order.tBody,1);	
	}	
	if(type == 3){
		 obj.applys = getCheckBoxValues(order.tBody,1);	
	}
	


	//obj.checkStateId = getCheckStateByResult();
	obj.checkStateId = chechResultPara;
	
	if(obj.checkStateId==null||obj.checkStateId==0){
		alert("请选择审批意见！");
		return false;
}

	if(!isUndefined(obj.checkStateId) && obj.contracts !=""){
		if(state == 3 && $("isEndPoint").value =="false"){
	      alert("上级已同意不允许再提交，请与上级联系!");
	      return false;
		}		
//		alert(obj.workFlowTypeId);
//		alert(obj.checkIdea);
//		alert(obj.checkStateId);
		workFlowCheck.saveCheckResult("new");	
		//alert("提交完成!");
		getTable()
	}
}


function getCheckStateByResult(){
	var  rt = getRadioValue($(checkResult.radioName));
	if(rt == 1) return  3;
	if(rt == 2) return 4;
}

function editInfo(contractId){
	parent.location.href ="editContract.html?id="+contractId;
}



function autoBroArrange(contractId){
	popupcenter.url = "selectPopup/selectCheckResult.html?id=" + contractId;
	popupcenter.model = 6;
	popupcenter.popupcenter(popupcenter);

}

function editOrderInfo(orderId){
//	parent.location.href ="editOrder.html?id="+orderId+"&d-3682230-p=1";
	popupcenter.url = "editOrder.html?id="+orderId+"&";
	popupcenter.model = 8;
	popupcenter.popupcenter(popupcenter);
}


function autoOrderArrange(orderId){
//	popupcenter.url = "selectPopup/selectOrderCheckResult.html?id=" + orderId+"&";
//	popupcenter.model = 6;
//	popupcenter.popupcenter(popupcenter);
	
	var dialogcontent = $("dialogcontentDiv");
	var dialogcontentW = dialogcontent.offsetWidth;
	var dialogcontentH = dialogcontent.offsetHeight;
	var winW= dialogcontentW * 0.6;
	var winH = dialogcontentH*0.8;
	var title = "审批结果";
	var theme = "leopard"; //vista mac_os_x lighting black_hud leopard window
	var draggable = false;
	var minimize = false;
	var maximize = false;
	var close =  'destroy';
	var resizable = false;
	var urlStr = 'selectPopup/selectOrderCheckResult.html?orderId='+orderId+'&winW='+winW+'&winH='+winH;
	openWindow('mywin',urlStr,winW,winH,title,theme,draggable,minimize,maximize,close,resizable);

}






function onkeypressOrderCode(ev){
	if(ev.keyCode == 13){
		contract.page.pageIndex =1;
		order.page.pageIndex =1;
		getTable();
	}
}

function getCustomerAutoCompltByName(ev){
	var customerName =$("customer_name").value;
	customer.obj.customerName = customerName;

	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
		$("customer_name").value="";
	}
}





function getCustomerAutoComplt(){
		customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
}


function payCustomerAutoComplet(objs)
{
	var oText = $("customer_name");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","customerName","customerCategoryId","category.categoryName"];
	var hidenColumName = ["id","customerCategoryId","helpCode"];
	var allColumsTitle = ["客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
//		$("customerId").value = getCellValue(tr,0);
		$("customer_name").value = getCellValue(tr,1);
//		$("customerCategoryId").value = getCellValue(tr,2);
		
		oText.value = getCellValue(tr,1);
		onCheckStateChanged();
//		searchCustomerName();
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			onCheckStateChanged();
//			searchCustomerName();
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);

}



	