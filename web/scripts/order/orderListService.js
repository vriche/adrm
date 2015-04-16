
 var order = new Order();
 var orderCategory = new OrderCategory();
 var checkState = new OaWorkFlowCheckState();
 var user = new User();
 var customer = new Customer();
 var category = new Category();
 var customerType = new CustomerType();
 var matter = new Matter();
 var carrier =new  Carrier();
 var resourceSort = new ResourceSort();
 var carrierType = new CarrierType();
 var report = new MyPrint();
 
 var channelModelParam;
 var config_serviceDate;
 var useCarrierAliname;
 var curSessionId;
 var carrSortIds;
 
callOnLoad(init);	
  
 function init(){
 	ctxPath =  _app_params.ctxPath;
 	config_serviceDate = _app_params.serviceDate.def;
 	userName =  _app_params.user.username;
 	channelModelParam =  _app_params.sysParam.channelModelParam;
 	tvNameParam =  _app_params.sysParam.tvNameParam;
 	withoutSubmit =  _app_params.sysParam.withoutSubmit;
 	useCarrierAliname =  _app_params.sysParam.useCarrierAliname;
 	useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;

 	
 	
 	
 	setRelationCodePara(order);
 	setOrderPara(order);
 	setCheckStatePara(checkState);
 	setUserPara(user);
 	setCustomerPara(customer);
	setOrderCategoryPara(orderCategory);
	setMatterPara(matter);	
	setCarrierPara(carrier);
	setResourceSortPara(resourceSort);
	
	carrier.obj.nodeLevel =1;
	carrier.obj.enable = false;

	
	var width1=100;
 	checkState.makeSelectFromMap(checkState.selectName,"",width1,setCheckStateSelected);
 	user.makeSelectWidth(user,user.selectName,"",width1,setUserSelected);
 	user.makeSelectWidth(user,"createById","",width1,setUserSelected2);
 	orderCategory.makeCategoryFromMap(orderCategory.selectName,setCategoryIdSelected);


 	$("orderCategoryId").setAttribute("style","width:100px;font-size:12px;");
 	resourceSort.makeSelectFromMap2(resourceSort.selectName,null,width1,null);
 	
// 	customerType.makeSelectAnalyze(customerType,"customerTypes","getTable",function(){});
    category.obj.loginUser = userName;
 	category.makeSelectAnalyze("customerCategorys","getTable",function(){});


 	getDate();
	var selectIsArrears = $("isArrears");
 	if(!isUndefined(selectIsArrears)){ 	
		$("isArrears").setAttribute("style","width:100px;font-size:12px;");
	}
	
	var selectmoneyRealpay = $("moneyRPay");
 	if(!isUndefined(selectmoneyRealpay)){
		$("moneyRPay").setAttribute("style","width:100px;font-size:12px;");
	}
	
	$('Btn_myOrder').hide();  
	
	if(withoutSubmit==1){
		$('submitChecked').hide(); 
		$('selectOrder').hide();
 	}else{
 		$('selectOrder').hide();
 		var isCheckedOrder = $("isCheckedOrder");
		if(!isUndefined(isCheckedOrder)){
			$('isCheckedOrder').hide();
		} 	
 	}




// 	if(tvNameParam =='fztv'){
// 		$('selectOrder').show();
// 		$('Btn_myOrder').show();   	
// 	 	var func=function(userId){
//			curSessionId = userId;
//		}
//		user.getCurUserId(userName,func)	
// 	}

	if(tvNameParam =='xmtv'){
		$('TDcarrierType').show();
		$('TDcustomerCategorys').show();
	}

 	buttonEventFill();
 	
 	//提交完查询后，把隐藏区的值设置到查询条件中
 	
 	
 	
 	
 	if(useMoreCarrierSortParam =='1'){
// 		 function(name,event,width,callBack,loginUser,all) 
         function funct(){ 
         	$("carrierName").value =  $("carrierSort").value.split("_")[1];
         	if( $("carrierSort").options.length>1){
         			setValueByQueryWhere();
         		}
         	}
 		 carrierType.makeSelectByLoginUser("carrierSort","onCarrierSortChange",null,setValueByQueryWhere,userName,1);
 	}else{
		setValueByQueryWhere();
 	}
 	
	 //customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
 }
 
function onCarrierSortChange(e){

 		 $("carrierName").value = e.value.split("_")[1];
 		 getTable();
}
 		 
 function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
//	if(channelModelParam!=1){
//		carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName","",setCarrierSelected);
//	}else{
//		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",setCarrierSelected);
//	}
//	
	carrier.makeSelectItemAnalyze5(carrier,"carrierName","",100,false,userName,setCarrierSelected); 
}
 function setRelationCodePara(obj){
	 obj.className  = "order";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "relationCode";
	 
}
 
 function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	obj.selectName = obj.className+"Name";
}
function setResourceSortPara(obj){
	 obj.selectName =  "resourceSortId";
}
 
 function setValueByQueryWhere(){
 	


    if($("customerName").value !=""){
    	$("customer_name").value = $("customerName").value;
    } 
    if($("matterName").value !=""){
    	$("matter.name").value =$("matterName").value;
    }
    if($("orderCode").value != ""){
      	$("order_code").value  =  $("orderCode").value
    }
    if($("contractCode").value != ""){
      	$("contract_code").value  =  $("contractCode").value
    }
    	
    if($("carrierType").value != ""){
      	$("carType").value  =  $("carrierType").value
    }
    if($("cutCates").value != ""){
      	$("customerCategorys").value  =  $("cutCates").value
    }
    

    if(useMoreCarrierSortParam =="1"){
	    if($("carrSort").value != ""){
	      	$("carrierSort").value  =  $("carrSort").value;
	    } 
    }

    
    
    

    var startDate = $("startDate").value;
    var endDate = $("endDate").value;
    if(startDate !=""){
    	if(startDate>0){
    		$("beginDate").value = getFormatDay($("startDate").value,'y/m/d');
    	}else{
    		$("beginDate").value = 0;
    	}
    }   

    if(endDate !=""){
    	if(startDate>0){
    		$("overDate").value =  getFormatDay($("endDate").value,'y/m/d'); 
    	}else{
    		$("overDate").value = 0;
    	}
    	
    } 	
    $("order_year").value = $("version").value;
    
    
    if($("carrIds").value !="" && $("carrIds").value !="0"){
    	$("carrierName").value = $("carrIds").value;
    }    
    
//    if($("carrierId").value !="" && $("carrierId").value !="0"){
//    	$("carrierName").value = $("carrierId").value;
//    }    
    
    
	if($("moneyState").value !=""){
    	$("isArrears").value = $("moneyState").value;
    } 
    
    if($("moneyRealpay").value !=""){
    	$("moneyRPay").value = $("moneyRealpay").value;
    } 
    
    if($("relationCode").value !=""){
    	$("relation_code").value = $("relationCode").value;
    }
    
    if($("publishMemo").value !=""){  
    	$("selectOrder").value = $("publishMemo").value;
    } 	
 }
 
 function setMatterPara(obj){
	 obj.className  = "matter";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "matterId";
}
 
 function setOrderCategoryPara(obj){
	 obj.className  = "orderCategory";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "orderCategoryId";
}

function getDate(){
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "beginDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate"	// id of the button
	});
	
	var yyyy = getDayPar(config_serviceDate,'y');
	$("beginDate").value = getFormatDay(yyyy+'0101','y/m/d');
	$("overDate").value= getFormatDay(yyyy+'1231','y/m/d');
	
//	var version = $("version").value;
//	if(version == ''){
//		alert(version);
		setSelectByValue($("order_year"),yyyy);
//	}
	
}
 
function setCheckStateSelected(){
	 	var id  = $("orderStates").value;
	 	if(id =="0,1,2,4") id = 5;
//	 	if(id > 0){
	 		$(checkState.selectName).value = id;
//	 	}
}

function setUserSelected(){
	 	var id  = $("userId").value;
	 	if(id > 0){
	 		$(user.selectName).value = id;
	 	}
}

function setUserSelected2(){
	 
	
	   $("createById").options[0].text ="==签订人=="
	 	var id  = $("createBy").value;
	 	if(id > 0){
	 		$("createById").value = id;
	 	}
}

function setCategoryIdSelected(){
	 	var categoryId  = $("categoryId").value;

	 	if(categoryId!=0){
	 		$(orderCategory.selectName).value = categoryId;
	 	}
}

function setCarrierSelected(){
	 	var carrierId  = $("carrierId").value;
//alert(carrierId);
	 	if(carrierId!=0){
	 		$(carrier.selectName).value = carrierId;
	 	}
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
	 obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox); 
} 
 


function resetMatterNameText(ev){
	 $("matterId").value=null;
	 $("matter.name").value = null;
}

 
function buttonEventFill(){
	var orderAllSelect = $("orderAllSelect");
	if(!isUndefined(orderAllSelect)){
		orderAllSelect.onclick = allSelectCheckBox;	
		orderAllSelect.setAttribute("parnetObjName",order.tableName);	
	 }

	var Btn_myOrder = $("Btn_myOrder");
	if(!isUndefined(Btn_myOrder)){
		Btn_myOrder.setAttribute("href","javascript:void 0");
		Btn_myOrder.onclick = selectMyOrder;
	 }	
	 
	var Btn_AllOrder = $("Btn_AllOrder");
	if(!isUndefined(Btn_AllOrder)){
		Btn_AllOrder.setAttribute("href","javascript:void 0");
		Btn_AllOrder.onclick = selectAllOrder;
	 }	

	var isCheckedOrder = $("isCheckedOrder");
	if(!isUndefined(isCheckedOrder)){
		isCheckedOrder.setAttribute("href","javascript:void 0");
		isCheckedOrder.onclick = updateOrderStates;
	 }	
	    
	var submitChecked = $("submitChecked");
	if(!isUndefined(submitChecked)){
		submitChecked.setAttribute("href","javascript:void 0");
		submitChecked.onclick = updateOrderStates;
	 }	
	
	var Btn_customerName = $("customer_name");
	if(!isUndefined(Btn_customerName)){
//		Btn_customerName.onkeypress= getCustomerAutoCompltByName;
		Btn_customerName.onclick = resetText;
	 }	
	 
//	 Btn_customerName.onblur = function (){
//	 	alert($("customer_name").value);
//	 	$("customerName").value = $("customer_name").value;
//	 }
	
	
	var Btn_orderName = $("order_code");
	if(!isUndefined(Btn_orderName)){
		Btn_orderName.onclick = resetOrderText;
	}	
	
	var Btn_contractName = $("contract_code");
	if(!isUndefined(Btn_contractName)){
		Btn_contractName.onclick = resetContractText;
	}
	var Btn_relationCode = $("relation_code");
	if(!isUndefined(Btn_orderName)){
		Btn_relationCode.onclick = resetRelationCodeText;
	}
	
	
	var Btn_query = $("query");
	Btn_query.onclick = getTable;
	
	var Btn_view_order = $("Btn_view_order");
	if(!isUndefined(Btn_view_order)){
		Btn_view_order.onclick = button_view_order;
	}
	var Btn_print_order = $("Btn_print_order");
	if(!isUndefined(Btn_print_order)){
		Btn_print_order.onclick = button_print_order;	
	}
	
	var Btn_export_order = $("Btn_export_order");
	if(!isUndefined(Btn_export_order)){
		Btn_export_order.onclick = button_print_export;	
	}
	var Btn_matterName = $("matter.name");
	Btn_matterName.onclick = resetMatterNameText;
	Btn_matterName.onkeypress = getMatterAutoCompltByName;
	
	var Btn_searche = $("btn_searche");
	Btn_searche.onclick = displaySearchDiv;
	
	var Btn_searche_close = $("btn_searche_close");
	Btn_searche_close.onclick = closeSearchDiv;
	
		//新添定单按钮
	var Btn_addNewOrder = $("Btn_addNewOrder");
	if(Btn_addNewOrder!=null){
		Btn_addNewOrder.setAttribute("href","javascript:void 0");
		Btn_addNewOrder.onclick = addNewOrder;
	}
	
//	if(tvNameParam =='fztv'){
//		var Btn_selectOrder = $("selectOrder");
//		Btn_selectOrder.onchange = getTable;
//	} 
	
	
	var change_order_year = $("order_year");
	change_order_year.onchange = rest_query_order;
	
	
	var Btn_carrierType = $("carType");
	if(!isUndefined(Btn_carrierType)){
		Btn_carrierType.onchange = getTable;	
	}	
	
	var Btn_customerCategorys = $("customerCategorys");
	if(!isUndefined(Btn_customerCategorys)){
		Btn_customerCategorys.onchange = getTable;	
	}		
	
//	if(useMoreCarrierSortParam =='1'){
		var carrierName2 = $("carrierName");
		carrierName2.onclick = displayCarrierTree2; 	
//	}

	var Btn_order_code = $("order_code");
	if(!isUndefined(Btn_order_code)){
		Btn_order_code.onkeypress = function a(event){DWRUtil.onReturn(event,getTable);	}
	}	

	var Btn_contract_code = $("contract_code");
	if(!isUndefined(Btn_contract_code)){
		Btn_contract_code.onkeypress = function a(event){DWRUtil.onReturn(event,getTable);	}
	}	
	
	var Btn_relation_code = $("relation_code");
	if(!isUndefined(Btn_relation_code)){
		Btn_relation_code.onkeypress = function a(event){DWRUtil.onReturn(event,getTable);	}
	}		
		
	var Btn_matter_name = $("matter.name");
	if(!isUndefined(Btn_matter_name)){
		Btn_matter_name.onkeypress = function a(event){DWRUtil.onReturn(event,getTable);	}
	}	
	
	var Btn_customer_name = $("customer_name");
	if(!isUndefined(Btn_customer_name)){
		Btn_customer_name.onkeypress = function a(event){DWRUtil.onReturn(event,getTable);	}
	}		
	
    this.ctxPath = ctxPath;
	this.report.buildButtons(this,"printReportDiv",[0,1,2],80);

}   

function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_order();
	}
	if(mode =="print"){
		button_print_order();
	}
	if(mode =="excel"){
		button_print_export();
	}
	   
}
function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  $("config_username").value;
  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids +"&useCarrierAliname="+useCarrierAliname +"&orgId="+ $("carrierSort").value[0];
  var cleanBtn ={text: '重置',handler: function(){document.getElementById('userCarrReliframe').contentWindow.refreshTreeCarriers();}};	
  var closeBtn ={text: '确定',handler: function(){removeWin();}};
  
        
 var win = new Ext.Window({
   title : '选择频道',
   //maximizable : true,
   // maximized : true,
   width : 400,
   height : 300,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [cleanBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userCarrReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
  
     function removeWin(){
     	
    	var ids = document.getElementById('userCarrReliframe').contentWindow.getCheckedCarriers();
    	
//    	if(useMoreCarrierSortParam == 1){
//    		carrSortIds = document.getElementById('userCarrReliframe').contentWindow.getOrgIds();
//    		var index = 0 
//    		if(carrSortIds.length ==1 ){
//				index = getSelectIndexByValu2($("carrierSort"),carrSortIds)	
//    		}
//    		$("carrierSort").options[index].selected = true;
//    	}

    	
    	if(ids!=null && ids.length>0){
			$("carrierName").value = ids.join(',');
		}else{
			$("carrierName").value ='';
		}
 
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});   
    
}
	
function rest_query_order(){
	 var year = $("order_year").value;
	
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = year  + beginDate.substring(4,beginDate.length);
	 overDate = year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;

	 getTable();
	
//	 $("order_year").value = year;
	 $("version").value = year;
}


function addNewOrder(){
	var URLs="";
	
	var state = $(checkState.selectName).value;
	URLs += "orderStates="+ state;

	var userId = $(user.selectName).value;
	URLs += "&userId="+ userId;
	
	var createById = $("createById").value;
	URLs += "&createBy="+ createById;
	
	var ocId = $(orderCategory.selectName).value;
	var carrierId = $(carrier.selectName).value==null||$(carrier.selectName).value==''?0:$(carrier.selectName).value;
   	URLs += "&carrIds="+ carrierId;
   	
	if(ocId==0){
		$("categoryId").value=null;
		$("orderMeno").value=0;
		URLs += "&categoryId=";
		URLs += "&orderMeno=0";
	}else{
		$("orderMeno").value=ocId;
		$("categoryId").value = ocId;
		URLs += "&orderMeno="+ ocId;
		URLs += "&categoryId="+ ocId;
	}

	var customerName = $("customer_name").value;
	if(customerName.indexOf("=") > -1) customerName = "";
	URLs += "&customerForm.customerName="+ customerName;
	
	var orderCode = $("order_code").value;
	if(orderCode.indexOf("=") > -1) orderCode = "";
	URLs += "&orderCode="+ orderCode;
	
	var start = getFormatDay($("beginDate").value,'ymd');
	URLs += "&orderPublicForm.publishStartDate="+ start;
	
	var end = getFormatDay($("overDate").value,'ymd');
	URLs += "&orderPublicForm.publishEndDate="+ end;
	
	
	var relationCode = $("relation_code").value;
	if(relationCode.indexOf("=") > -1) relationCode = "";
	URLs += "&relationCode="+ relationCode;
	
	var matterName = $("matter.name").value;
	if(matterName.indexOf("=") > -1) matterName = "";
	URLs += "&orderPublicForm.matterName="+ matterName;

	
	var isArrear = $("isArrears");
	if(!isUndefined(isArrear)){
		var isArrears = $("isArrears").value;
		URLs += "&orderPublicForm.moneyState="+ isArrears;
		
	}
	
	URLs += "&version="+ $("version").value;
	
	if(tvNameParam =='xmtv'){
			URLs += "&carrierType="+ $("carType").value;
	}
	
	
	
	if(useMoreCarrierSortParam == 1){
		URLs += "&carrSort="+ $("carrierSort").value.split("_")[0];
    }else{
    	URLs += "&carrSort=1";
    }
    


	var url = window.location.href;
	//var id = getParamFromUrl(url,"id");
	var pos = url.indexOf("?");
	var pos1 = url.indexOf("&");
	if(pos>0 && pos1<1){
		url = url.substring(pos+1,url.length);
		URLs = url+URLs;
	}
	
   
	parent.location.href = ctxPath+"editOrder.html?" + URLs;
}


function displaySearchDiv(){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
}

function closeSearchDiv(){
	var oDiv = $("theDivSearch");
	oDiv.style.visibility = "hidden";	
}



function getCustomerAutoCompltByName(ev){
	var customerName =$("customer_name").value;
	

	
	customer.obj.customerName = customerName;

	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
		$("customer_name").value="";
	}
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
		$("customerId").value = getCellValue(tr,0);
		$("customer_name").value = getCellValue(tr,1);
		$("customerCategoryId").value = getCellValue(tr,2);
		
		oText.value = getCellValue(tr,1);
//		searchCustomerName();
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '';
			$("customerCategoryId").value = '';
//			searchCustomerName();
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);

}

function getMatterAutoCompltByName(ev){
	matter.obj.name = $("matter.name").value;
	if(ev.keyCode == 13){
//		matter.getMatterAutoComplet(mattersAutoComplete,matter.obj);
		matter.getMatterAutoCompletDIV(mattersAutoComplete,matter.obj);
		$("matter.name").value="";
	}
}

function mattersAutoComplete(objs)
{
	var oText_name = $("matter.name");
	var oDiv_name = $("theDivMatterName");
	var indexColumName_name = ["name"];
	var allColumsName_name =["id","name"];
	var allColumsTitle_name = ["广告名称"];
	var onDivMouseDown_name = function(ev){
		var tr = getElementByEvent(ev);
//		$("dt_matter.id").value = getCellValue(tr,0);
		$("matter.name").value = getCellValue(tr,1);
		oText_name.value = getCellValue(tr,1);
		
		
//		searchMatterName();
	}
	
	var hidenColumName = ["id"];
	
	var onTextBlur = function(ev){
		oDiv_name.style.visibility = "hidden";
		
//		if(trim(oText_name.value) == "" ) $("matter.name").value = "";
		
		if(trim(oText_name.value) == ""){
//			$("dt_matter.id").value = '0';
			$("matter.name").value = "";
//			searchMatterName();
		}	
	}
	
   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,hidenColumName,indexColumName_name,allColumsName_name,allColumsTitle_name);
} 
function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "orderList";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "orderList";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "orderList";
	 button_print();
}
function button_print(){
	//$("userNameForm").value = userName;
	$("channelModelForm").value=channelModelParam;
	$("orderStatesForm").value = $("orderStates").value;
	
	$("relationCodeForm").value = $("relationCode").value;
	$("userIdForm").value = $("userId").value;
	

	$("createByForm").value = $("createBy").value;
	
	
	$("customerNameForm").value = $("customerName").value;
	$("orderCodeForm").value = $("orderCode").value;
	
	$("contractCodeForm").value = $("contractCode").value;
	$("matterNameForm").value = $("matterName").value;
	var categoryId = $(orderCategory.selectName).value;
//	var carrierId = $(carrier.selectName).value;
	var carrierId = $(carrier.selectName).value==null||$(carrier.selectName).value==''?0:$(carrier.selectName).value;
	if(categoryId==0){
		$("categoryForm").value=null;
	}else{
		$("categoryForm").value = categoryId;
	}
	
	$("carrierIdForm").value = carrierId;
	
	$("startDateForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endDateForm").value = getFormatDay($("overDate").value,'ymd');
	
	$("userNameForm").value = $("config_username").value;
	
	var isArrear = $("isArrears");
	if(!isUndefined(isArrear)){
			$("isArriersForm").value = $("isArrears").value;
		
	}
	
	var moneyRPay = $("moneyRPay");
	if(!isUndefined(moneyRPay)){
		
		$("moneyRPayForm").value = $("moneyRPay").value;
		
	}
//	if(tvNameParam == 'fztv'){
//		$("selectImportOrderForm").value  = $("selectOrder").value;
//	}else{
		$("selectImportOrderForm").value  = 0;  
//	}
	
	
	if(tvNameParam == 'xmtv'){
		$("carrierTypeForm").value  = $("carType").value;
		$("cutCatesForm").value  = $("customerCategorys").value;
	}
	
	if(useMoreCarrierSortParam == 1){
		$("carrSortForm").value  = $("carrierSort").value;
		
    }
	
	
	
	
//	alert($("isArrears").value);
//
//	$("orderCodeForm").value = orderCodeForm;
	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}

function setOrderPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className = "order";	
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "orderList";
	 obj.tBody 		= $(obj.fillObjName);
//	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
//	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
//	 
//	 obj.pageInfo 	= "pageInfo" + obj.className;
//	 obj.pageSize 	= "4";
//	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setCheckStatePara(obj){
	 obj.className ="OaWorkFlowCheckState";
	 obj.selectName = obj.className +"RN";
}

function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userOwner"; 
}

function selectMyOrder(){
	if(!isUndefined(curSessionId)){
		$(user.selectName).value = curSessionId;
		getTable(); 	
	}else{
 	 	var func=function(userId){
			curSessionId = userId;
			$(user.selectName).value = curSessionId;
			getTable(); 	
		}
		user.getCurUserId(userName,func)	
	}
}


function selectAllOrder(){
//	var orderFormSearch = $("orderFormSearch");
//	 window.location.herf = ctxPath + "orders.html";
//	 location.assign(window.location.herf);
	 parent.location.href =ctxPath + "orders.html";
}

function updateOrderStates(){
	var checkeds = getCheckBoxValues(order.tableName,1);
	var changeState = 1;
	if(withoutSubmit == 1 )changeState = 3;

	if(checkeds==""){
		$(checkState.selectName).value = 5;
	}else{
		order.updateOrderStates(checkeds,changeState);
	}
	getTable();  
	
//	if(withoutSubmit==1){
//		if(checkeds==""){
//			$(checkState.selectName).value = 5;
//		}else{
//			order.updateOrderStates(checkeds,3);
//		}
//		getTable();  
//	}else{
//		if(checkeds==""){
//			$(checkState.selectName).value = 5;
//		}else{
//			order.updateOrderStates(checkeds,1);
//		}
//		order.updateOrderStates(checkeds,1);
//		getTable();  
//		location.reload(); 
//	}
	
//    submitOrderForm();
}

function submitOrderForm(){
//	var tarForm =  $("tarForm");
	var orderFormSearch = $("orderFormSearch");
//	orderFormSearch.target = tarForm;
	orderFormSearch.submit(); 
	//	alert("提交成功!");
}

function searchyear(beginDate,endDate){
	var beginYear = getFormatDay(beginDate,'y');
	var endYear = getFormatDay(endDate,'y');
	var ispass = true;
	
 	if(beginDate == "" || endDate == ""){
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
function getTable(){
//	if(tvNameParam == 'fztv'){
//		$('publishMemo').value = $('selectOrder').value;
//	}else{
		$('publishMemo').value = 0;
//	}
	 
	var state = $(checkState.selectName).value;
//	state = (state == 5)?"0,1,2,4":state;
    //后台处理
	$("orderStates").value = state;
	
	var userId = $(user.selectName).value;
	$("userId").value = userId;
	
	var createById = $("createById").value;
	$("createBy").value = createById;

	//var categoryName = $("publishMemo").value;
	
	var ocId = $(orderCategory.selectName).value;
	var carrierId = $(carrier.selectName).value;
	carrierId = carrierId == 'undefined' ||isUndefined(carrierId)||carrierId==null||carrierId==''?0:carrierId;
	
//   $("carrierId").value= carrierId;
   
//    $("carrierId").value= carrierId;
     $("carrIds").value= carrierId;
     
     
    
    
   
    
     
	if(ocId==0){
		$("categoryId").value=null;
		$("orderMeno").value=0;
	}else{
		$("orderMeno").value=ocId;
		$("categoryId").value = ocId;
	}
	var customerName = $("customer_name").value;
	if(customerName.indexOf("=") > -1) customerName = null;
	$("customerName").value = customerName;
	
	var orderCode = $("order_code").value;
	if(orderCode.indexOf("=") > -1) orderCode = null;
	$("orderCode").value = orderCode;
	
	var contractCode = $("contract_code").value;
	if(contractCode.indexOf("=") > -1) contractCode = null;
	$("contractCode").value = contractCode;
	
	var start = getFormatDay($("beginDate").value,'ymd');
	$("startDate").value = start;
	var end = getFormatDay($("overDate").value,'ymd');
	$("endDate").value = end;
	var yyyy = getFormatDay($("beginDate").value,'y');
	$("version").value = yyyy;

	
	var isPass = searchyear($("startDate").value,$("endDate").value);
	if(!isPass) return false;
	
	var relationCode = $("relation_code").value;
	if(relationCode.indexOf("=") > -1) relationCode = null;
	$("relationCode").value = relationCode;
	
	var matterName = $("matter.name").value;
	if(matterName.indexOf("=") > -1) matterName = null;
	$("matterName").value = matterName;
	
	
	

	var moneyRPay = $("moneyRPay");
	if(!isUndefined(moneyRPay)){
		var moneyRPays = $("moneyRPay").value;
		//alert(isArrears);
		
			$("moneyRealpay").value = moneyRPays;
		
	}
	
	var isArrear = $("isArrears");
	if(!isUndefined(isArrear)){
		var isArrears = $("isArrears").value;
		//alert(isArrears);
			$("moneyState").value = isArrears;
	}
	
	
	var cutCates = $("customerCategorys");
	if(!isUndefined(cutCates)){
		var cutCates = $("customerCategorys").value;
		$("cutCates").value = cutCates;
//		alert(cutCates);
	}
	

	var carType = $("carType");
	if(!isUndefined(carType)){
		var carType = $("carType").value;
		$("carrierType").value = carType;
//		alert(carType);
	}
	
	
	var carrierSort = $("carrierSort");
	if(!isUndefined(carrierSort)){
		var carrierSort = $("carrierSort").value;
		$("carrSort").value = carrierSort;
	}
	
	submitOrderForm();
}



function resetText(ev){
	 $("customer_name").value = null;
	 $("customerId").value = null;
}
function resetOrderText(ev){
	 $("order_code").value = null;
	 $("id").value = null;
}
function resetContractText(ev){
	 $("contract_code").value = null;
	 $("contractCode").value = null;
}
function resetRelationCodeText(ev){
	 $("relation_code").value = null;
	 $("relationCode").value = null;
}