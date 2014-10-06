
var org = new SysOrg();
var customer = new Customer();
var income = new Income();
var carrier = new Carrier();
var moreChannelNoPullParam;
var report = new MyPrint();
var loginUser;
//Ext.onReady(
//	function(){
//	
//		buildcustomerCommand();
//	}
//);

callOnLoad(init);	

function init(){

	moreChannelNoPullParam = _app_params.sysParam.moreChannelNoPullParam;		
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
 	loginUser =  _app_params.user.username;	
    tvNameParam =  _app_params.sysParam.tvNameParam;   
    config_serviceDate = _app_params.serviceDate.def;
    	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    
    
	setIncomePara(income);
	setCustomerPara(customer);
	setCarrierPara(carrier);

//	getCustomerAutoComplt();
 	buttonEventFill();
 	
// 	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear);
 	
 	getDate();
 	

 	
 	 _make_org_select("orgId2",120,"submitIncomeListForm");	
 	 
      if($("orgId").value >0)$("orgId2").value = $("orgId").value;
         
 
 	 
 	 buildcustomerCommand(setValueByQueryWhere);

 	
 	var fct = function(){}
 	initCarrier(fct);
 	
    this.ctxPath = _app_params.ctxPath;
  	this.report.buildButtons_bak(this,"printReportDiv",[0,1,2],70);
  	
//  	this.ctxPath = ctxPath;
//	this.report.buildButtons(this,"printReportDiv",[0,1,2],70);

 	
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
 function inti_set_customer(id,customerName){
	var rc1 = Ext.data.Record.create(customer.fileds);
    var rc = new rc1({
           id : id,
           customerName:customerName
     });
     

       customer.customerCommand.clearValue(); 
   	   customer.customerCommand.store.add(rc);
   	   customer.customerCommand.setValue(id);  
	   $("customerId").value = id;
}
 
 
  function buildcustomerCommand(func){

  	
  	customer.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$('orgId2').value;
 	customer.obj.loginUser = loginUser;
// 	customer.obj.version = $("year").value;
 	customer.obj.model = "2";
 	
 	
 	var callBackFun = function(){};
 	if(!customer.customerCommand){
	 	customer.customerCommand = customer.getCustomerRemote("extCustomerDiv","customerName1",140,callBackFun);
	// 	cmd.on("select",getIncomeDetailList,this);	
 	}
	 
  }
 


 
 
 function setValueByQueryWhere(fct){
 	

 	
 	if($("incomeCode").value !=""){
 		 $("income_code").value = $("incomeCode").value;
 	}
 	
 	
 	if($("incomePullDate").value !=""){
 		var month = $("incomePullDate").value;
 		$("month").value =  month==null?0:month.substring(4);        
    }
    
    if($("orgId").value !=""){
    	    $("orgId2").value = $("orgId").value;  
    }
    
    if($("customerName").value == 'null')  $("customerName").value ="";
	if($("customerName").value !="" )  {
			    	inti_set_customer($("customerId").value,$("customerName").value);
//		 });

	}	 
  
  	
  }
 function initCarrier(fct){
    	carrier.obj.nodeLevel =1;
	//根据是否分频道，取得频道下拉列表
	function fnct(){
		var carrierId = getParamFromUrl(window.location.href,"resourceCarrierId");
		if(moreChannelNoPullParam == 1) {
			$("carrierName2").value = carrierId;
		}else{
			$("putToChannel").value = carrierId;
			var month = getParamFromUrl(window.location.href,"incomePullDate");
			$("month").value =  month==null?0:month.substring(4);        
		}
		if(fct) fct();
	}
	
	

	
	if(moreChannelNoPullParam == 1){
//		$("putToChannel").hide();
//		$("month").hide();
		
// 		carrier.makeSelectItemAnalyze3(carrier,"carrierName2","submitIncomeListForm",100,false,fnct);
        if(tvNameParam !='xmtv'){
			carrier.makeSelectItemAnalyze5(carrier,"carrierName2","submitIncomeListForm",100,false,loginUser,fnct);
        }

	}else{
		$("carrierName2").hide();
		fnct();
	}	
	
	
	
	
	
//	  if(tvNameParam =='xmtv') $("putToChannel").hide();
		
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
	Calendar.setup({
		inputField  : "beginDatePull",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "beginDatePull"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "overDatePull",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDatePull"	// id of the button
	});
	$("beginDate").value = $("startDate").value==""?"":getFormatDay($("startDate").value,'y/m/d');
	$("overDate").value=$("endDate").value==""?"":getFormatDay($("endDate").value,'y/m/d');
	  
	$("beginDatePull").value = $("incomeModeName").value==""?"":getFormatDay($("incomeModeName").value,'y/m/d');
	$("overDatePull").value=$("incomePurposeName").value==""?"":getFormatDay($("incomePurposeName").value,'y/m/d');
}
 
function buttonEventFill(){
//	var orderAllSelect = $("orderAllSelect");
//	orderAllSelect.onclick = allSelectCheckBox;	
//	orderAllSelect.setAttribute("parnetObjName",order.tableName);	
//	
	var Btn_searche = $("btn_searche");
	Btn_searche.onclick = displaySearchDiv;
	
	var Btn_searche_close = $("btn_searche_close");
	Btn_searche_close.onclick = closeSearchDiv;	
		
	var Btn_addIncome = $("Btn_addIncome");
	Btn_addIncome.setAttribute("href","javascript:void 0");
	Btn_addIncome.onclick = addIncome;		
	
	
	var Btn_query = $("query");
	Btn_query.onclick = submitIncomeListForm;
//	Btn_query.onclick = updateOrderStates;
	
//	var Btn_customerName = $("customerName1");
//	Btn_customerName.onclick = resetText;
//	Btn_customerName.onkeypress = getCustomerAutoCompltByName;
	
	
//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_print_export;
	
	$("putToChannel").onchange = submitIncomeListForm;
	$("month").onchange = submitIncomeListForm;
	
}

function displaySearchDiv(){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
}
function closeSearchDiv(){
	var oDiv = $("theDivSearch");
	oDiv.style.visibility = "hidden";	
}

function addIncome(){
//	var urlPara = window.location.href;
//	var param ="";
//	if(urlPara.indexOf("?")>-1) {
//		param = urlPara.substring(urlPara.indexOf("?")+1,urlPara.length);
//	}
//	
//	if(param != ""){
//		param= param+"&orgId=" +$("orgId").value;
//	}else{
//		param = "orgId=" +$("orgId").value;
//	}
//
//	parent.location.href ="editIncome.html?"+param;

	parent.location.href ="editIncome.html?orgId="+$("orgId2").value;

}



//function getCustomerAutoCompltByName(ev){
//	var customerName =$("customerName1").value;
//	customer.obj.customerName = customerName;
//	
//	if(ev.keyCode == 13){
//		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
//		$("customerName1").value="";
//	}
//}
//
//function customerAutoComplete(objs)
//{
//	var oText = $("customerName1");
//	var oDiv = $("theDivCustomerName");
//
//	var indexColumName_customerName = ["helpCode"];
//	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
//	var hidenColumName = ["id","customerCategoryId","helpCode"];
//	var allColumsTitle = ["客户名称","客户类别"];
//	
//	var onDivMouseDown_customerId = function(ev){
//
//		var tr = getElementByEvent(ev);
//		$("customerId").value = getCellValue(tr,0);
//		$("customerName1").value = getCellValue(tr,2);
//		$("customerName").value = getCellValue(tr,2);
//		$("customerCategoryId").value = getCellValue(tr,3);
//		
//		oText.value = getCellValue(tr,2);
//	}
//	
//	var onTextBlur = function(ev){
//
//		oDiv.style.visibility = "hidden";
//		
//		if(trim(oText.value) == "" ){
//			$("customerId").value = '';
//			$("customerCategoryId").value = '';
//			$("customerName1").value = '';
//			$("customerName").value = '';
//		}
//	}
//   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
//}
function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "income_report";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "income_report";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "income_report";
	 button_print();
}
function button_print(){
//	 alert(Ext.getCmp('customerName1').value);

//	$("customerIdForm").value = Ext.getCmp('customerName1').value;
//	$("customerNameForm").value =  Ext.fly('customerName1').getValue();
	
	
	var customerName1 = Ext.getCmp('customerName1').getValue();

	
	$("customerIdForm").value = customerName1;
//	$("customerNameForm").value = customerName1 == ''?null: Ext.fly('customerName1').getValue();
	
	$("customerNameForm").value =$("customerName").value
	

	
	
	
//	$("resourceCarrierIdForm").value = $("resourceCarrierId").value;  
//	if(moreChannelNoPullParam == 0){
//		$("resourceCarrierIdForm").value = $("resourceCarrierId").value==0?-100:$("resourceCarrierId").value;
//	}
	
    if(moreChannelNoPullParam == 1){
		$("resourceCarrierIdForm").value = $("carrierName2").value;
	}else{
		$("resourceCarrierIdForm").value =$("putToChannel").value;
	}
	
	$("startDateForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endDateForm").value = getFormatDay($("overDate").value,'ymd');
	$("startDatePullForm").value = getFormatDay($("beginDatePull").value,'ymd');
	$("endDatePullForm").value = getFormatDay($("overDatePull").value,'ymd');
	$("currentUser").value = loginUser; 
	$("incomePullDateForm").value = $("incomePullDate").value;
	$("incomeCodeForm").value = $("income_code").value;
	
	$("orgIdForm").value = $("orgId2").value;
	
	
	
	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}


function submitIncomeListForm(){
	$("startDate").value = getFormatDay($("beginDate").value,'ymd');
	$("endDate").value = getFormatDay($("overDate").value,'ymd');  
	$("incomeModeName").value = getFormatDay($("beginDatePull").value,'ymd');//开始时间划账
	$("incomePurposeName").value = getFormatDay($("overDatePull").value,'ymd');//结束时间划账
	
	var customerName1 = Ext.getCmp('customerName1').getValue();
	$("customerId").value = customerName1;
	$("customerName").value = customerName1 == ''?null: Ext.fly('customerName1').getValue();
	

	$("currentUser").value = loginUser;	
	$("incomeCode").value = $("income_code").value;
	$("orgId").value = $("orgId2").value;
		
	$("incomePullDate").value =$("beginDatePull").value.substring(0,4) + $("month").value; 
	
	if(moreChannelNoPullParam == 1){
		$("resourceCarrierId").value = $("carrierName2").value;
	}else{
		$("resourceCarrierId").value =$("putToChannel").value;
			
	}
	  
	var incomeSubmit = $("incomeListForm");
	
	
	incomeSubmit.submit();
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function setIncomePara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "income";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "incomeList";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
}

function resetText(ev){
	 $("customerName").value = null;
	 $("customerName1").value = null;
	 $("customerId").value = null;
	 
}
