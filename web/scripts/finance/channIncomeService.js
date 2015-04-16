var orderdayinfo =new OrderDayInfo();
//var user = new User();
var carrier = new Carrier();
var customer = new Customer();
var incomeUsed = new IncomeUsed();
var incomePurpose = new IncomePurpose();
var myprint =new MyPrint();
var user = new User();
var userName;
var myDate = new MyDate();
var config_serviceDate;
var mygrid;
var queryWindow;
callOnLoad(init);

function init(){
	
	resetHeigth();
	
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;
	config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
	

	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	
	 _make_org_select("orgId",120,"");	
	 
    config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}	 
	 
	 
	 $("order_year").value =  _app_params.serviceDate.year;	
	
	setIncomeUsedPara(incomeUsed);
	setCarrierPara(carrier);
	setPurposePara(incomePurpose);
	
	setUserPara(user);
	carrier.obj.nodeLevel =1;
	//carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	hiddenChartButton();
//	makeCarrierSelectItem();
//	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	buttonEventFill();
	//getCustomerAutoComplt();
	getDate(_app_params.serviceDate.year, _app_params.serviceDate.def);	
 	
//	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
	
//	incomePurpose.makeOptionsCallBackFun(incomePurpose,fillFun);	
	incomePurpose.obj.version = $("order_year").value;
	incomePurpose.makeOptionsCallBackFun(incomePurpose.obj,fillFun);
	function fillFun(objs){
		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);     
	}
	
	initGrid();
	
	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
	
	 show_cut_win();	
 
// 	new dhtmlXGridFromTable('customerAnalyzeTable');
 	
}

function rest_query_order(){
	var year = $("order_year").value;

    
     var end = year + ''+ $("overDate").value.substring(5,7)+''+$("overDate").value.substring(8,10);
     
     getDate(year,end);
	
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = year  + beginDate.substring(4,beginDate.length);
	 overDate = year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;
	 
	 $("customerName").value = null;
	 $("customerId").value = null;	 
	 resetStore();

	  
//	 getAllMonthInfosByStartAndend();
}


 function resetStore(){
 	 var orgId = $("orgId").value;
 	 var version =  $("order_year").value;

	 
	if(queryWindow){
//		queryWindow.owner.orgId = $("orgId").value;
		queryWindow.tree.getLoader().params[1].orgId = orgId;
		queryWindow.tree.root.reload(); 
	}
 }
 
function show_cut_win(){
	customer.obj.orgId = $("orgId").value;
	var params =[{accountName:'',accountBank:'',customerName:'',orgId:$("orgId").value},{orgId:$("orgId").value}];
	function setvalue(ids){$("customerName").value = ids;}
	customer.showWin('customerName',params,userName,true,setvalue);
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
	
	if(mode =="chart"){
		getFusionChartObjs();
	}	
	
	   
}
function hiddenChartButton(){
	if(isDisplayChartParam!=1){
		$("displayChar").hide();
	}else{
		$("displayChar").show();
	}
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
	
		//	显示业务员资源树
	var userOwner = $("userOwner");
	userOwner.onclick = displayUsersTree2; 
	
//	var Btn_view_channIncome = $("Btn_view_channIncome");
//	Btn_view_channIncome.onclick = btn_view_channIncome;
//
//	var Btn_print_channIncome = $("Btn_print_channIncome");
//	Btn_print_channIncome.onclick = btn_print_channIncome;	
//	
//	var Btn_export_channIncome = $("Btn_export_channIncome");
//	Btn_export_channIncome.onclick = btn_export_channIncome;
	
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 
	
	var change_order_year = $("order_year");
	change_order_year.onchange = rest_query_order;		
	
}



function displayUsersTree2(){
  var ids = $("customerName").value;
  var loginUser =  userName;
  var parentUserId = 0;
  var urlStr="selectPopup/selectUserRel.html?mode=1&loginUser="+loginUser+"&ids="+ids+"&orgId="+$("orgId").value;
  var cleanBtn ={text: '重置',handler: function(){document.getElementById('userReliframe').contentWindow.refreshTree();}};	
  var closeBtn ={text: '确定',handler: function(){removeWin();}};
  
        
 var winUser = new Ext.Window({
   title : '选择用户',
   //maximizable : true,
   // maximized : true,
   width : 350,
   height : 400,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [cleanBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  winUser.show(); 
  
     function removeWin(){
    	var ids = document.getElementById('userReliframe').contentWindow.getCheckedIds();
    	if(ids!=null && ids.length>0){
			$("userOwner").value = ids.join(',');
		}else{
			$("userOwner").value ='';
		}
 
  		winUser.destroy();
   	} 
   winUser.on({'close': {fn: removeWin}});   
    
}

function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  userName;
//  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids;
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

function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
} 
function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
}

function getCustomerAutoCompltByName(ev){
	var customerName =$("customerName").value;
	customer.obj.customerName = customerName;
	
	
	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
		$("customerName").value="";
		//getSelectCustomerToTree();
	}
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
//		getSelectCustomerToTree();
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
function button_view_order(){
	 $("model").value = "view";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 button_print();
}

function button_print(){
	$("beginDateForm").value = getFormatDay($("beginDate").value,'ymd');
	$("overDateForm").value = getFormatDay($("overDate").value,'ymd');
//	$("carrierNameForm").value =$(carrier.selectName).value;
	$("carrierNameForm").value = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	
    $("customerIdForm").value =  $("customerId").value;
    $("channelModelForm").value = channelModelParam;
    $("userNameForm").value = userName;
    $("putYear").value= $("isPutYear").checked == true?1:0;
	$("returnValue").value= $("isNotReturnValue").checked == true?1:0;
	$("userIdForm").value  = $(user.selectName).value==0?null:$(user.selectName).value;
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	$("purpose").value= purpose.toString();
	
	$("orgIdForm").value  = $("orgId").value; 

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");


	reportForm.target = tarForm;
	reportForm.action="reports/jsp/channIncome_print.jsp";
	reportForm.submit(); 	
}
function getChannelIncomeList(){
	closeDiv();
	var start = getFormatDay($("beginDate").value,'ymd');
	var end = getFormatDay($("overDate").value,'ymd');
	var customerId = $("customerId").value;
	var carrierId = $$("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	
	var isPutYear = $("isPutYear").checked == true?1:0;
	var isNotReturnValue = $("isNotReturnValue").checked == true?1:0;
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	purpose = purpose.toString();
	
//	alert(purpose)
	
	var orgId = $("orgId").value;
	
	
    function getFun(xml){
    	    mygrid.clearAll();
			mygrid.loadXMLString(xml);
			Ext.getBody().unmask();
			mygrid.setSizes();	
    }	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	incomeUsed.getIncomeChannelXML(orgId,start,end,customerId,carrierId,channelModelParam,userName,isPutYear,isNotReturnValue,purpose,userId,getFun)
	
}
function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
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
//function getDate(){
//	
//	Calendar.setup({
//		inputField  : "beginDate",	  // id of the input field
////		ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "beginDate"	// id of the button
//	});
//	
//	Calendar.setup({
//		inputField  : "overDate",	  // id of the input field
////		ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "overDate"	// id of the button
//	});
////	$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
////	$("overDate").value= getFormatDay(theYear+'1231','y/m/d');
//	
//	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
//	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
//}

function getDate(order_year,serviceDate){
	

	$("order_year").value = order_year;
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(serviceDate),'y/m/d');
	$("overDate").value=   getFormatDay(myDate.getNewDayEndDay1(serviceDate),'y/m/d');

	
	function dateDisabledFunc(date,i){
		if(i == 1){
		   var pval = ''+$("overDate").value; 
		   pval = pval.replace("/",'')*1;
		   var calDate = date.print("%Y%m%d")*1;
		   return !(date.getFullYear() == order_year && calDate < pval);
		}else{
		   var pval = $("beginDate").value;
		   pval = pval.replace("/",'')*1;
		   var calDate = date.print("%Y%m%d")*1;
		   return !(date.getFullYear() == order_year && calDate > pval);
		}

//		 return (date.getFullYear() != order_year);
	}

	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		range:[order_year],
		firstDay:1,
		singleClick	  : true,
		button	  : "beginDate",// id of the button
		dateDisabledFunc : function(date) {
//                      dateDisabledFunc(date,1);
		}
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		range:[order_year],
		firstDay:1,
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate",	// id of the button
		dateDisabledFunc : function(date) {
//                     dateDisabledFunc(date,2);
		}
	});


}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	//var flds = "开始,结束,月份,规定";
	var flds = "频道名称,到账金额";
	
	if(config_withResourceSort == 1){
		flds = "分类,到账金额";
	}
//	var flds = "频道名称,到账金额,投放金额,分配金额,欠款金额,投放时间";
	mygrid.setHeader(flds);
//	mygrid.setInitWidthsP("10,18,18,18,18,18");
//	mygrid.setColAlign("left,right,right,right,right,right")
//	mygrid.setColTypes("ed,ed,ed,ed,ed,ed");

    mygrid.setInitWidthsP("50,50");
	mygrid.setColAlign("left,right")
	mygrid.setColTypes("ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,int") ;
	mygrid.setSkin("modern2");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.setOnRowDblClickedHandler(onRowSelectd,true);
//	mygrid.enableDragAndDrop(false);
	mygrid.init();	  
}

function onRowSelectd(rowId,colIndex){
	var tarURL = mygrid.getUserData(rowId,"tarURL");
//	window.parent.location.href = tarURL;
	window.top.location.href=tarURL;
}

function getFusionChartObjs(){

	var start = getFormatDay($("beginDate").value,'ymd');
	var end = getFormatDay($("overDate").value,'ymd');
	var customerId = $("customerId").value;
//	var carrierId = $(carrier.selectName).value==null?0:$(carrier.selectName).value;
	var carrierId = $$("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	var isPutYear = $("isPutYear").checked == true?1:0;
	var isNotReturnValue = $("isNotReturnValue").checked == true?1:0;
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	purpose = purpose.toString();
	
	function func(objs){
		fusionChartObjects = objs;
		alert(fusionChartObjects.length);
	}

		var a = {
			    orgId:$("orgId").value,
                start: start,
                end: end,
                isPutYear:isPutYear,
                userId: userId,
                carrierId: carrierId,
                customerId: customerId,
                channelModelParam: channelModelParam,
                userName: userName,
                isNotReturnValue:isNotReturnValue,
                purpose: purpose
		};		
		

        //now transform it into a hash encodeURI
        var h = $H(a);
		var url = "channIncomeChart.html?"+h.toQueryString();
		window.open(url);

}
