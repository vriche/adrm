var orderdayinfo =new OrderDayInfo();
var financeTarget = new FinanceTarget();
//var user = new User();
var carrier = new Carrier();
var customer = new Customer();
var incomeUsed = new IncomeUsed();
var incomePurpose = new IncomePurpose();
var user = new User();
var userName;
var myDate = new MyDate();
var config_serviceDate;
var myprint =new MyPrint();

var mygrid;

callOnLoad(init);

function init(){
	
	resetHeigth();
	
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;	
	
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;

 	config_isDisplayStandPrice = _app_params.sysParam.isDisplayStandPrice;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
    config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
    config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
		config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
		
		
		
	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear);
		
		
	 _make_org_select("orgId",120,"");	
	 
	get_cur_year();

	
	
	setIncomeUsedPara(incomeUsed);
	setCarrierPara(carrier);
	setPurposePara(incomePurpose);
	
	setUserPara(user);
	carrier.obj.nodeLevel =1;
	//carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	hiddenChartButton();
//	makeCarrierSelectItem();
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	buttonEventFill();
	//getCustomerAutoComplt();
	initCustomerCmd();
 	getDate();
 	
//	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
	
	incomePurpose.makeOptionsCallBackFun(incomePurpose,fillFun);	

	function fillFun(objs){
		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);     
	}
	
	initGrid();
	
	 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80); 
 
// 	new dhtmlXGridFromTable('customerAnalyzeTable');
 	
}



function initCustomerCmd(){

    	var customerName = "";
		var categoryId = 0;
        var mode = 'remote';
    customer.obj.orgId = config_oneOrgMoreSuborgsParam == 1?1:$("orgId").value;
    	customer.storeCustomer = customer.getStoreCustomersAnalyze(mode,customer.obj);   
	   if(!customer.customerCommand){
//	   //模板
        var tpl2= customer.getCustomerCmdTemple1();

		customer.customerCommand = new Ext.form.ClearableComboBox({
		 	  id:'customerName',
		 	  name:'customerName',
			  renderTo:'theDivCustomerName',
			  tiggerAction:'all',
			  listWidth:300,
			  store:customer.storeCustomer,
			  editable: true,
			  triggerAction: 'all', //query all
			  lastQuery:'1',
			  displayField:'customerName',
			  valueField:'id',
			  mode:mode,
			   width:144,
//			   typeAhead: true,
//			   forceSelection:false, 
			  allowBlank:false,
			  lazyRender: false,
			  forceAll: true,
			  emptyText:'请选择...',
			  minChars:2,
			  hiddenName:'customerCategoryId', //提交传过去的值 
			  filterFiled:'customerName',
			  filterFiled2:'helpCode',
			  params:customer.obj,
			  tpl:tpl2,
			  listeners:{
			  	beforequery:customer.comboFilterBy2.createDelegate(this)}
		 });
	   }
};




function get_cur_year(){
	var yyyy = getDayPar(config_serviceDate,'y');
	setSelectByValue($("order_year"),yyyy);
	order_year = $("order_year").value;
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
//	$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
//	$("overDate").value = getFormatDay(theYear+'1231','y/m/d');
	
	
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}

//function hiddenChartButton(){
//	if(isDisplayChartParam!=1){
//		$("displayChar").hide();
//	}else{
//		$("displayChar").show();
//	}
//}
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
function setIncomeUsedPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "incomeUsed";	
	 obj.IdPrefix 	 = obj.className + "Id";

}

function buttonEventFill(){
	var btn_searche = $("btnSearche");
	btn_searche.onclick=displayDiv;
	
	
	var btn_searche_close=$("btnSearcheClose");
	btn_searche_close.onclick=closeDiv;
	
	
	var Btn_query = $("query");
	Btn_query.onclick =getChannelIncomeList;

//	var Bt_displayChar = $("displayChar");
//	Bt_displayChar.onclick = getFusionChartObjs;

//	var Btn_customerName = $("customerName");
//	Btn_customerName.onclick = resetText;
//	Btn_customerName.onkeypress = getCustomerAutoCompltByName;
	
//	var Btn_view_channIncome = $("Btn_view_channIncome");
//	Btn_view_channIncome.onclick = btn_view_channIncome;
//
//	var Btn_print_channIncome = $("Btn_print_channIncome");
//	Btn_print_channIncome.onclick = btn_print_channIncome;	
//	
//	var Btn_export_channIncome = $("Btn_export_channIncome");
//	Btn_export_channIncome.onclick = btn_export_channIncome;	
	
    var order_year = $("order_year");
	order_year.onchange = getNewOrder_year;
	
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 	
}

function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  userName;
  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids +"&useCarrierAliname="+config_useCarrierAliname+"&orgId="+$("orgId").value;
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
    	if(ids!=null && ids.length>0){
			$("carrierName").value = ids.join(',');
		}else{
			$("carrierName").value ='';
		}
 
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});   
    
}


function getNewOrder_year(){
	 order_year = $("order_year").value;
	
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = order_year  + beginDate.substring(4,beginDate.length);
	 overDate = order_year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;
}


function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
} 
function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
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
	if(mode =="chart"){
		getFusionChartObjs();
	}	
	   
}

function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "carrierTarget";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "carrierTarget";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "carrierTarget";
	 button_print();
}
function button_print(){
	var msg = "是否显示明细 ?";
		ans = confirm(msg);
		if(ans){
			var isDetail = 1;
		}
	$("isDetail").value = isDetail;
	$("startDate").value = getFormatDay($("beginDate").value,'ymd');
	$("endDate").value = getFormatDay($("overDate").value,'ymd');
	$("yearForm").value =$("order_year").value;
	$("carrierNameForm").value =$("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
    $("customerIdForm").value =    Ext.getCmp('customerName').getValue();
    $("channelModelForm").value = channelModelParam;
    $("userNameForm").value = userName;
    $("putYear").value= $("isPutYear").checked == true?1:0;
	$("returnValue").value= $("isNotReturnValue").checked == true?1:0;
	$("userIdForm").value  = $(user.selectName).value==0?null:$(user.selectName).value;
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	$("purpose").value= purpose.toString();
	$("orgIdForm").value = $("orgId").value;;
	
	

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");


	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}
function getChannelIncomeList(){
	closeDiv();
	var start = getFormatDay($("beginDate").value,'ymd');
	var end = getFormatDay($("overDate").value,'ymd');
	var year = $("order_year").value;
	var customerId =  Ext.getCmp('customerName').getValue();
	if(customerId =='') customerId = null;
	var carrierId = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	
	var userId=$(user.selectName).value==0?null:$(user.selectName).value;
	
	var isPutYear = $("isPutYear").checked == true?1:0;
	var isNotReturnValue = $("isNotReturnValue").checked == true?1:0;
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	purpose = purpose.toString();
	var orgId = $("orgId").value;
	
	
    function getFun(xml){
    	    mygrid.clearAll();
			mygrid.loadXMLString(xml);
			Ext.getBody().unmask();
    }	
	
	
	if($("beginDate").value=="" || $("overDate").value=="" ){
		alert("请先选择日期");
	}else{
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		financeTarget.getCarrierTargetXML(orgId,userId,year,start,end,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,customerId,getFun)
	}
	
}
function resetText(ev){
//	 $("customerName").value = null;
	 Ext.getCmp('customerName').setValue("");
//	 $("customerId").value = null;
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
function setPurposePara(obj){
	 obj.className ="incomepurpose";
	 obj.checkBoxName = obj.className +"RN";
}

function setUserSelected(){
//	 	var id  = $("userId").value;
//	 	if(id > 0){
//	 		$(user.selectName).value = id;
//	 	}
}



function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
   	$("bbos").style.height = dialogcontent.offsetHeight*0.81+"px";
} 

function setOrderDayInfoPara(obj){
	obj.className ="orderdayinfo";
	obj.IdPrefix = obj.className + "Id";
	obj.fillObjName = "orderdayinfoBody";
	obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	obj.tBody 		= $(obj.fillObjName);
//	obj.pageSize 	= "10000";
//	obj.pageInfo 	= "pageInfo" + obj.className;
//	obj.page = new Page(obj.pageInfo,obj.pageSize);
}


function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	//var flds = "开始,结束,月份,规定";
//	var flds = "频道名称,到账金额";
	var flds = "频道名称,月份,投放金额,到帐金额,指标,投放指标比例,到账指标比例";
	mygrid.setHeader(flds);
	mygrid.setInitWidthsP("16,14,14,14,14,14,14");
	mygrid.setColAlign("left,right,right,right,right,right,right")
	mygrid.setColTypes("tree,ed,ed,ed,ed,ed,ed");

//    mygrid.setInitWidthsP("50,50");
//	mygrid.setColAlign("left,right")
//	mygrid.setColTypes("ed,ed");
//	mygrid.enableAlterCss("even","uneven"); 
//	mygrid.setColSorting("str,int") ;
	mygrid.setSkin("modern2");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.enableDragAndDrop(false);
	mygrid.init();	 
}

function getFusionChartObjs(){

	var year = $("order_year").value;
    var startDate=getFormatDay($("beginDate").value,'ymd');
	var endDate=getFormatDay($("overDate").value,'ymd');
	var carrierId = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	var userId=$(user.selectName).value==0?null:$(user.selectName).value;
	
	var isPutYear = $("isPutYear").checked == true?1:0;
	var isNotReturnValue = $("isNotReturnValue").checked == true?1:0;
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	purpose = purpose.toString();
	
	function func(objs){
		fusionChartObjects = objs;
//		alert(fusionChartObjects.length);
	}

		var a = {
                userId:userId,
                year:year,
                isPutYear:isPutYear,
                startDate: startDate,
                endDate: endDate,
                carrierId: carrierId,
                channelModelParam: channelModelParam,
                userName: userName,
                isNotReturnValue:isNotReturnValue,
                purpose: purpose
		};		
		

        //now transform it into a hash encodeURI
        var h = $H(a);
		var url = "carrierTargetChart.html?"+h.toQueryString();
		window.open(url);

}
