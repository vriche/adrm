 
 
var customer = new Customer();
var order = new Order();
var popupcenter = new Popupcenter();
var carrier = new Carrier();
var matter = new Matter(); 
var channelModelParam;
var org = new SysOrg(); 
var orgId = 1;
var userName;
var config_serviceDate;
var report = new MyPrint();
var ctxPath;
var report = new MyPrint();
var user = new User();

callOnLoad(init);	
  
 function init(){
 	ctxPath = _app_params.ctxPath;	
 	channelModelParam = _app_params.sysParam.channelModelParam;
 	useMoreCarrierSortParam =_app_params.sysParam.useMoreCarrierSortParam;
	userName =  _app_params.user.username;
	config_serviceDate = _app_params.serviceDate.def;	
	
	config_year = _app_params.serviceDate.year;	
	
//	function callBackFun(){
//		
//		if(useMoreCarrierSortParam == 0 || $('orgIdCmd').options.length<2){
//				$('orgId_td').hide();
//		}
//		
//		
//	}

//	org.makeSelect(org.obj,"orgIdCmd","",callBackFun);		
	 _make_org_select("orgIdCmd",120,"makeCarrierSelectItem");	
	 
  
 	
 	setOrderPara(order);
 	setCarrierPara(carrier);
 	setCustomerPara(customer);
 	setMatterPara(matter);
// 	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
 	getDate();
 	
// 	order.getOrders(order);
 	
 	buttonEventFill();
	makeCarrierSelectItem();
	//user.makeSelectWidth(user,user.selectName,"",width1,setUserSelected);
// 	 show_cut_win();	
// 	getOrderTable(order);

	 buildcustomerCommand();
	 
	 user.getUsersFromOrder("signUserDiv","userOwner",100,function(){});	
	 
	 search();
	 
    this.ctxPath = ctxPath;
	this.report.buildButtons(this,"printReportDiv",[0,1,2],80);	 
	 
	 
//	 this.ctxPath = ctxPath;
//	 this.report.buildButtons(this,"printReportDiv",[0,1,2],80);
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
 
function buildcustomerCommand(){
  	
  	
  	customer.obj.orgId = $("orgIdCmd").value;
 	customer.obj.loginUser = userName;
// 	customer.obj.version = 2011;
 	customer.obj.model = "1";
 	
 	
 	var callBackFun = function(){};
 	if(!customer.customerCommand){
	 	customer.customerCommand = customer.getCustomerRemote("extCustomerDiv","customerName",140,callBackFun);
	// 	cmd.on("select",getIncomeDetailList,this);	
 	}
	 
  }
 
  function makeCarrierSelectItem(){
  	var fuc = function(){}
	//根据是否分频道，取得频道下拉列表
//	if(channelModelParam!=1){
//		carrier.makeSelectItemFromMapOrderList(carrier.obj,"carrierName","",fuc);
//	}else{
		var orgId = $("orgIdCmd").value;

		carrier.obj.orgId = orgId;
	
		carrier.makeSelectItemAnalyze6(carrier.obj,carrier.selectName,"",138,false,userName,fuc);
//	}
}
  function setMatterPara(obj){
	 obj.className  = "matter";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "matterId";
}
 function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
 
 function setOrderPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className = "order";	
	 obj.IdPrefix 	= obj.className + "Id";
	 
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "orderList";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 
	 obj.pageInfo 	= "pageInfo" + obj.className;
	 obj.pageSize 	= "19";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
	 obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox); 
}

function buttonEventFill(){
	var Submit = $("Submit");
	Submit.onclick = search;	
	
//	document.body.onfocus = closePopup;
	
	var Btn_matterName = $("matterName");
	Btn_matterName.onclick = resetMatterNameText;
	Btn_matterName.onkeypress = getMatterAutoCompltByName;
	
//	var Btn_customerName = $("customerName");
//	Btn_customerName.onclick = resetText;
//	Btn_customerName.onkeypress = getCustomerAutoCompltByName;
	
	var Btn_searche = $("btn_searche");
	Btn_searche.onclick = displaySearchDiv;	
	
	var Btn_searche_close = $("btn_searche_close");
	Btn_searche_close.onclick = closeSearchDiv;	
	
	
//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_print_export;	
	
}
function displaySearchDiv(){
	var oDiv = $("theDivSearch");	
	if(oDiv.style.visibility == "hidden"){
		oDiv.style.visibility = "visible";
	}else{
		oDiv.style.visibility = "hidden";
	}
	
}

function closeSearchDiv(){
	var oDiv = $("theDivSearch");
	oDiv.style.visibility = "hidden";	
}
function getMatterAutoCompltByName(ev){
	
	matter.obj.name = $("matterName").value;
	if(ev.keyCode == 13){
//		matter.getMatterAutoComplet(mattersAutoComplete,matter.obj);
		matter.getMatterAutoCompletDIV(mattersAutoComplete,matter.obj);
		$("matterName").value="";
	}

}
function mattersAutoComplete(objs)
{
	var oText_name = $("matterName");
	var oDiv_name = $("theDivMatterName");
	var indexColumName_name = ["name"];
	var allColumsName_name =["id","name"];
	var allColumsTitle_name = ["广告名称"];
	var onDivMouseDown_name = function(ev){
		var tr = getElementByEvent(ev);
//		$("dt_matter.id").value = getCellValue(tr,0);
		$("matterName").value = getCellValue(tr,1);
		oText_name.value = getCellValue(tr,1);
		
		
//		searchMatterName();
	}
	
	var hidenColumName = ["id"];
	
	var onTextBlur = function(ev){
		oDiv_name.style.visibility = "hidden";
		
//		if(trim(oText_name.value) == "" ) $("matter.name").value = "";
		
		if(trim(oText_name.value) == ""){
//			$("dt_matter.id").value = '0';
			$("matterName").value = "";
//			searchMatterName();
		}	
	}
	
   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,hidenColumName,indexColumName_name,allColumsName_name,allColumsTitle_name);
}
function getCustomerAutoCompltByName(ev){
//	var customerName =$("customerName").value;
		var customerName = Ext.fly('customerName').getValue();
	customer.obj.customerName = customerName;
	
	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
		$("customerName").value="";
		
	}
}
function resetText(ev){
	$("customerName").value=null;
	$("customerId").value=null;
}
//function mattersAutoComplete(objs)
//{
//	var oText_name = $("matterName");
//	var oDiv_name = $("theDivMatterName");
//	var indexColumName_name = ["name"];
//	var allColumsName_name =["id","name"];
//	var allColumsTitle_name = ["广告名称"];
//	var onDivMouseDown_name = function(ev){
//		var tr = getElementByEvent(ev);
////		$("dt_matter.id").value = getCellValue(tr,0);
//		$("matterName").value = getCellValue(tr,1);
//		oText_name.value = getCellValue(tr,1);
//		
//		
////		searchMatterName();
//	}
//	
//	var hidenColumName = ["id"];
//	
//	var onTextBlur = function(ev){
//		oDiv_name.style.visibility = "hidden";
//		
////		if(trim(oText_name.value) == "" ) $("matter.name").value = "";
//		
//		if(trim(oText_name.value) == ""){
////			$("dt_matter.id").value = '0';
//			$("matterName").value = "";
////			searchMatterName();
//		}	
//	}
//	
//   new AutoComplete(objs,oText_name,oDiv_name,-1,onDivMouseDown_name,onTextBlur,hidenColumName,indexColumName_name,allColumsName_name,allColumsTitle_name);
//}
function resetMatterNameText(ev){
	 //$("matterId").value=null;
	 $("matterName").value = null;
}
function closePopup(ev){
	popupcenter.closePopup(popupcenter);
}

function editOrderInfo(orderId){
	var url = "editOrder.html?id="+orderId+"&orgId="+$("orgIdCmd").value;;
//	parent.location.href = url;
	popupcenter.url = url;
	popupcenter.model = 11;
	popupcenter.popupcenter(popupcenter);
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


function show_cut_win(){
	customer.obj.orgId = $("orgIdCmd").value;
	var params =[{accountName:'',accountBank:'',customerName:'',orgId:$("orgIdCmd").value},{orgId:$("orgIdCmd").value}];
	function setvalue(ids){$("customerName").value = ids;}
	customer.showWin('customerName',params,userName,true,setvalue);
}

function search(){
	order.page.pageIndex = 1;
	var customerName =  Ext.getCmp('customerName').getValue();
	customerName =(customerName==""|| customerName=='')?null:customerName;
	

	
	var matterName = $("matterName").value;

	var beginDate = getFormatDay($("startDate").value,'ymd');
	var endDate = getFormatDay($("endDate").value,'ymd');
	var customerId = $("customerId").value==0?null:$("customerId").value;
	var carrierId = $(carrier.selectName).value;
    customerId = (customerId==""|| customerId=='')?"0":customerId;
    	
	order.reset();
	if(matterName == "") matterName = null;
	
	var isPass = searchyear(beginDate,endDate);
	if(!isPass) return false;
	
	//alert(carrierId);
	//alert(matterName==null);
	order.obj.orderPublic = (new OrderPublic()).obj;
//	order.obj.customerId = (customerId==null)?"0":customerId;
	order.obj.orderPublic.publishStartDate = beginDate;
	order.obj.orderPublic.publishEndDate = endDate;
	order.obj.orderPublic.matterName = matterName;
	order.obj.carrierId  = carrierId;
	order.obj.orderStates ="";
//	order.obj.customer = (new Customer()).obj;
//	order.obj.customer.customerName = customerName;
	order.obj.orgId =  $("orgIdCmd").value;
	


	order.obj.userId =  Ext.getCmp('userOwner').getValue();
	
//	alert('408_'+order.obj.userId)

	order.obj.customerIds = customerName;
	

	//用createBy代替carrierID
	//order.obj.createBy = carrierID;
	
	var func = function(objs){
		order.fillTalbeReport(objs);
	}
	order.getOrdersReport(order,func);
	
	closeSearchDiv();
}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == order.pageInfo){
		var page = new Page(order.pageInfo,order.pageSize);
		page.goNextPage(pageIndex);
		order.page = page;
		getOrderTable(order);
	}
}

function getOrderTable(order){
//	alert(order.obj.name);
	var func = function(objs){
		order.fillTalbeReport(objs);
	}
	order.getOrdersReport(order,func);
	
}


function drawColorOrderTable(rowIndex,orderId){	
	$(order.fillObjName).curRowIndx = rowIndex;
	$(order.fillObjName).orderId = orderId;
	var trs = $(order.fillObjName).getElementsByTagName("tr");
	var row = trs[rowIndex];
	//alert(row.obj.orderPublic.publishEndDate);
	

	$("printDateStart").value =getFormatDay(row.obj.orderPublic.publishStartDate+"",'y/m/d');
	$("printDate").value =getFormatDay(row.obj.orderPublic.publishEndDate+"",'y/m/d');
	
	var len=$("orderBody").rows.length;
	for(id=0;id<len;id++){
		if(id%2 == 0) { 
	          		trs[id].style.cssText="BACKGROUND-COLOR: #white";
	          }else{
	          		trs[id].style.cssText="BACKGROUND-COLOR: #eee";
	          }
	}
	var co = trs[rowIndex].style.cssText;
     if(co =="background-color: rgb(160, 205, 111);"){
	          if(rowIndex%2 == 0) { 
	          		trs[rowIndex].style.cssText="BACKGROUND-COLOR: #white";
	          }else{
	          		trs[rowIndex].style.cssText="BACKGROUND-COLOR: #eee";
	          }
	}else{
		trs[rowIndex].style.cssText="BACKGROUND-COLOR: #a0cd6f";
		
	}
	
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
	Calendar.setup({
		inputField  : "printDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "printDate"	// id of the button
	});
	Calendar.setup({
		inputField  : "printDateStart",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "printDateStart"	// id of the button
	});	
	
	$("startDate").value = getFormatDay(theYear+'0101','y/m/d');
	$("endDate").value= getFormatDay(theYear+'1231','y/m/d');

	$("printDateStart").value= getFormatDay(config_serviceDate,'y/m/d');
	$("printDate").value= getFormatDay(config_serviceDate,'y/m/d');
	
}

//function editOrderInfo(id){
//	parent.location.href ="editOrder.html?id="+id;
//}
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
function button_view_order(){
	 $("model").value = "view";
	 $("copys").value = "1";
	 button_print();
}	

function button_print_order(){
	 $("model").value = "print";
	 $("copys").value = "1";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("copys").value = "1";
	 button_print();
	 
}
function button_print(){
	
//   var man_date = $("man_date").checked;
//   
//   if(man_date){
//   		var start = getFormatDay($("printDateStart").value,'ymd');
//   }
    var orderId = $(order.fillObjName).orderId;

    if(orderId == null ||orderId == '' ){
    	extjMessage('请选择订单信息!');
    	return false;
    }

	var start = getFormatDay($("printDateStart").value,'ymd');
    var end = getFormatDay($("printDate").value,'ymd');
  

	$("orderId").value = orderId;
	$("beginDate_bro").value =  start;
	$("endDate_bro").value = end;
	$("isRelPrice").value = $("isRelPriceCheck").checked;
	$("isCustomer").value = $("iscustomerCheck").checked;
	$("carrierId").value = $(carrier.selectName).value;
	$("matterNameForm").value = $("matterName").value;
	$("orgId").value = $("orgIdCmd").value;
	if(end*1 < start*1){
		alert("证明截止日期，不能小于开播日期!");
		return false;		
	}
	
	
	if(orderId == null || orderId =="" || orderId=="NaN"){
		alert("没有数据，不能执行此操作!");
		return false;
	}
	
	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

   // alert($("orderId").value);
   // alert($("beginDate_bro").value);
   // alert($("endDate_bro").value);
	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/bro_print.jsp";
	reportForm.submit(); 	
	
}




