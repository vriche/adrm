var customer = new Customer();
var income = new Income();
var incomeUsed = new IncomeUsed();
var config_serviceDate;
var myprint = new MyPrint();

callOnLoad(init);	

function init(){ 	
	config_serviceDate = _app_params.serviceDate.def;
	get_cur_year();
	userName =  _app_params.user.username;
	
		 _make_adrm_sys_year_select("year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);	 
	 _make_org_select("orgId",120,"resetCustomerStore");	
	 
	setIncomeUsedPara(incomeUsed);
	setCustomerPara(customer);

	//getCustomerAutoComplt();
 	buttonEventFill();
// 	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
 	
 	customer.obj.orgId = $("orgId").value;
 	customer.obj.loginUser = userName;
 	customer.obj.version = $("year").value;
 	customer.obj.model = "1";
 	
 	var callBackFun = function(){};
 	var cmd = customer.getCustomerRemote("theDivCustomerName","customerName",130,callBackFun);
 	cmd.on("select",getIncomeDetailList,this);	

 	
 	initGrid();
 	resetHeigth();
 	
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2],80); 
// 	getDate();
 }
 
 
 function resetCustomerStore(){
	var orgId =  $("orgId").value;
	var version = $("year").value;
//	var cmd3 =  Ext.getCmp('customerName');
//	var store3 = cmd3.getStore();	
//	store3.baseParams.dwrParams.orgId = orgId;
//	store3.baseParams.dwrParams.version = version;
//	store3.reload();	
//	cmd3.clearValue(); 
	
	
	var cmd4 =  Ext.getCmp('customerName');
	var store4 = cmd4.getStore();	
	if(store4.baseParams.dwrParams){
		store4.baseParams.dwrParams.orgId = orgId;
		store4.baseParams.dwrParams.version = version; 
		store4.reload();
		if(cmd4.mode == 'local'){
			store4.clearValue(); 
		}else{
			cmd4.setValue('');
		}
			
	}	
	
	mygrid.clearAll();
}
 
 function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	//var flds = "开始,结束,月份,规定";
//	var flds = "频道名称,到账金额";
	var flds = "客户名称,发票号,到款金额,频道名称,划帐金额,订单号,己分配金额,到款日期,合同号,业务员";
	mygrid.setHeader(flds);
	mygrid.setInitWidthsP("18,7,9,9,9,12,10,10,10,6");
	mygrid.setColAlign("left,center,right,center,right,center,right,center,center,center")
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");

//    mygrid.setInitWidthsP("50,50");
//	mygrid.setColAlign("left,right")
//	mygrid.setColTypes("ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,int,int,str,int,int,int,int,int,str") ;
	mygrid.setSkin("modern2");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.enableDragAndDrop(false);
	mygrid.init();	 
}
 
function get_cur_year(){

	var yyyy = getDayPar(config_serviceDate,'y');
	setSelectByValue($("year"),yyyy);
}


function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("gridbox");
    gridbox.style.height = dialogcontent.offsetHeight * 0.8 +"px";	
    gridbox.style.width = dialogcontent.offsetWidth -73 +"px";
  
} 
//function getDate(){
//	
//	Calendar.setup({
//		inputField  : "beginDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "beginDate"	// id of the button
//	});
//	
//	Calendar.setup({
//		inputField  : "overDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "overDate"	// id of the button
//	});
//	$("beginDate").value = theYear+'0101';
//	$("overDate").value= theYear+'1231';
//
//}
// 
function buttonEventFill(){

//	var Btn_query = $("query");
//	Btn_query.onclick =getIncomeDetailList;
	
//	var Btn_customerName = $("customerName");
//	Btn_customerName.onclick = resetText;
//    Btn_customerName.onkeypress = getCustomerAutoCompltByName;
    
//    var Btn_view_incomeDetail = $("Btn_view_incomeDetail");
//	Btn_view_incomeDetail.onclick = btn_view_incomeDetail;
//
//	var Btn_print_incomeDetail = $("Btn_print_incomeDetail");
//	Btn_print_incomeDetail.onclick = btn_print_incomeDetail;	
//	
//	var Btn_export_incomeDetail = $("Btn_export_incomeDetail");
//	Btn_export_incomeDetail.onclick = btn_export_incomeDetail;	
	
}
function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		btn_view_incomeDetail();
	}
	if(mode =="print"){
		btn_print_incomeDetail();
	}
	if(mode =="excel"){
		btn_export_incomeDetail();
	}   
}

function btn_view_incomeDetail(){
	 $("model").value = "view";
	 button_print();
}	
function btn_print_incomeDetail(){
	 $("model").value = "print";
	 button_print();
}
function btn_export_incomeDetail(){
	 $("model").value = "export";
	 button_print();
}
function button_print(){
	var customerId = Ext.getCmp("customerName").getValue();
    $("customerIdForm").value =  customerId;
    $("versionFrom").value =  $("year").value;
    
    
    if(customerId==""){
		alert("请选择客户!");
		return false;
	}
	

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	reportForm.target = tarForm;
	reportForm.action="reports/jsp/incomeDetail_print.jsp";
	reportForm.submit(); 	
}
function getIncomeDetailList(){
	var customerId = Ext.getCmp("customerName").getValue();
	var version =  $("year").value;

	if(customerId == ""){
		alert("请选择客户!");
		return false;
	}
	
	var func = function(xml){
			
			mygrid.clearAll();
			mygrid.loadXMLString(xml);
			Ext.getBody().unmask();
	}
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//    incomeUsed.getIncomeDetailList(customerId,version);
    	incomeUsed.getIncomeDetailXML(customerId,version,func);
}
function resetText(ev){
	 Ext.getCmp("customerName").setValue('');
//	 $("customerName").value = null;
//	 $("customerId2").value = null;
	
	 }
	 
function setIncomeUsedPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "incomeUsed";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.tBody 		 = $("incomeDetailBody");
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
}
//function getCustomerAutoCompltByName(ev){
//	var customerName =$("customerName").value;
//	customer.obj.customerName = customerName;
//	
//	
//	if(ev.keyCode == 13){
//		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
//		$("customerName").value="";
//		//getSelectCustomerToTree();
//	}
//}
//function customerAutoComplete(objs)
//{
//	var oText = $("customerName");
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
//		$("customerName").value = getCellValue(tr,2);
//		$("customerCategoryId").value = getCellValue(tr,3);
//		
//		oText.value = getCellValue(tr,2);
////		getSelectCustomerToTree();
//	}
//	
//	var onTextBlur = function(ev){
//
//		oDiv.style.visibility = "hidden";
//		
//		if(trim(oText.value) == "" ){
//			$("customerId").value = '';
//			$("customerCategoryId").value = '';
//		
//		}
//	}
//   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
//}
