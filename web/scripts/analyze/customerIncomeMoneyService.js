//var orderdayinfo =new OrderDayInfo();
var user = new User();
var carrier = new Carrier();
var customer = new Customer();
var incomePurpose = new IncomePurpose();
var incomePull = new IncomePull();
var myprint = new MyPrint();
var userName ;
var myDate = new MyDate();
var config_serviceDate;

callOnLoad(init);

function init(){
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
	userName =  _app_params.user.username;
	
		
//		_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);	  
	 _make_org_select("orgId",120,"resetCustomerStore");	
	 
	     config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	 
	 
//	  $("order_year").value =  _app_params.serviceDate.year;	
	initGrid();

    setIncomePullPara(incomePull);
    setPurposePara(incomePurpose);
	setCustomerPara(customer);
	setCarrierPara(carrier);
	setUserPara(user);
	carrier.obj.nodeLevel =1;
//	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	makeCarrierSelectItem();
//	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	buttonEventFill();
//	getCustomerAutoComplt();
 	getDate(_app_params.serviceDate.year, _app_params.serviceDate.def);
// 	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
    
// 	incomePurpose.makeOptionsCallBackFun(incomePurpose,fillFun);	
//	incomePurpose.obj.version = $("order_year").value;
	incomePurpose.makeOptionsCallBackFun(incomePurpose.obj,fillFun);
 	
 	var callBackFun = function(){};
 	
 	var cmd = customer.getCustomerRemote("theDivCustomerName","customerName",140,callBackFun);
// 	cmd.on("select",getIncomeDetailList,this);	
 	
 	

	function fillFun(objs){
		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);   
		
//		getIncomeMoneyList();  
	}
 	
	resetHeigth();
	
	this.myprint.buildButtons(this,"printReportDiv",[0,1,2],80); 
	
//	 show_cut_win();
	
}
 
 function resetCustomerStore(){
 	
 
	var orgId =  $("orgId").value;
//	var version = $("year").value;

	var cmd4 =  Ext.getCmp('customerName');
	var store4 = cmd4.getStore();	
	if(store4.baseParams.dwrParams){
		store4.baseParams.dwrParams.orgId = orgId;
//		store4.baseParams.dwrParams.version = version; 
		store4.reload();
		if(cmd4.mode == 'local'){
			store4.clearValue(); 
		}else{
			cmd4.setValue('');
		}
			
	}	
	
	mygrid.clearAll();
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
}
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
	var flds = "到款日期,发票号,发票金额,频道,划帐金额,分配金额,剩余金额,客户名称,业务员,付款类型,到款用途,收款人,备注,";
	mygrid.setHeader(flds);
	var columnIds = "incomeDate,incomeDetailId,datefapiao,channel,pinzhang,yifenpei,shengyu,customer,user,fkType,yongtu,shoukren,memo,";
	mygrid.setColumnIds(columnIds);
	

    mygrid.setInitWidthsP("8,6,8,7,8,8,8,8,7,8,8,8,8,");
	mygrid.setColAlign("center,right,right,left,right,right,right,left,right,right,right,right,left");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,");
	mygrid.enableAlterCss("even","uneven"); 
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
	mygrid.init();	 
}
//function makeCarrierSelectItem(){
//	//根据是否分频道，取得频道下拉列表
//	if(channelModelParam!=1){
//		carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	}else{
//		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",setCarrierSelect);
//	}
//}
function setCarrierSelect(){
	var id  = $("carrierName").value;
	 	if(id > 0){
	 		$(carrier.selectName).value = id;
	 	}
}
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
//    var customerAnalyze_div = $("gridbox");
    
    $("gridbox").style.height = dialogcontent.offsetHeight * 0.8 +"px";	
    
//    customerAnalyze_div.style.height = dialogcontent.offsetHeight * 0.8 +"px";	
//    customerAnalyze_div.style.width = dialogcontent.offsetWidth -73 +"px";
    
} 
function setIncomePullPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "incomePull";	
	 obj.IdPrefix 	 = obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName   = "incomeMoneyTable";
	 obj.tBody 		 = $(obj.fillObjName);
	 obj.color1 	 = "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 	 = "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.radioName = obj.className +"RN";

//	 obj.pageInfo 	 = "pageInfo" + obj.className;
//	 obj.pageSize 	 = "4";
//	 obj.page        = new Page(obj.pageInfo,obj.pageSize);
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.selectName =  "customerId";

}

function setPurposePara(obj){
	 obj.className ="incomepurpose";
	 obj.checkBoxName = obj.className +"RN";
}

function buttonEventFill(){
	var Btn_query = $("query");
	Btn_query.onclick =getIncomeMoneyList;
	
//	var Btn_order_year = $("order_year");
//	Btn_order_year.onchange =getIncomeMoneyList;
	
	
	
	var btn_searche = $("btnSearche");
	btn_searche.onclick=displayDiv;
	
	var btn_searche_close=$("btnSearcheClose");
	btn_searche_close.onclick=closeDiv;

//	var Btn_customerName = $("customerName");
//	Btn_customerName.onclick = resetText;
//	Btn_customerName.onkeypress = getCustomerAutoCompltByName;
	
//	var Btn_view_customerIncomeMoney = $("Btn_view_customerIncomeMoney");
//	Btn_view_customerIncomeMoney.onclick = btn_view_customerIncomeMoney;
//
//	var Btn_print_customerIncomeMoney = $("Btn_print_customerIncomeMoney");
//	Btn_print_customerIncomeMoney.onclick = btn_print_customerIncomeMoney;	
//	
//	var Btn_export_customerIncomeMoney = $("Btn_export_customerIncomeMoney");
//	Btn_export_customerIncomeMoney.onclick = btn_export_customerIncomeMoney;	
		//	显示业务员资源树
	var userOwner = $("userOwner");
	userOwner.onclick = displayUsersTree2; 
		
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 
	
//	var Btn_reset_query = $("order_year");
//	Btn_reset_query.onchange =resetQueryWhere;	
	
}


//function resetQueryWhere(){
//
//	 var year = $("order_year").value;
////	 var year =_app_params.serviceDate.year;
//	 var month =_app_params.serviceDate.month;
//	 
//	 var end = year + ''+ $("overDate").value.substring(5,7)+''+$("overDate").value.substring(8,10);
//	 
//	  getDate(year,end);
//	  
////	 var beginDate= $("beginDate").value;
////	 var overDate= $("overDate").value;
////	 beginDate = year  + beginDate.substring(4,beginDate.length);
////	 overDate = year  + overDate.substring(4,overDate.length);
////	 $("beginDate").value = beginDate;
////	 $("overDate").value = overDate;	  
//	  
//	 
//	 $("beginDate").value = getFormatDay(year+ '01' + '01','y/m/d');
//	 $("overDate").value= getFormatDay(year+ '12' +'31','y/m/d');
//	 
//	 getIncomeMoneyList();
//}

function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
} 
function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
	}
	
	
	
function displayUsersTree2(){
  var ids =  $("userOwner").value;
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

function getCustomerAutoCompltByName(ev){
	var customerName =$("customerName").value;
	customer.obj.customerName = customerName;
	
	
	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
		$("customerName").value="";
		//getSelectCustomerToTree();
	}
}
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
	$("orgIdForm").value =  $("orgId").value;
    $("customerIdForm").value = Ext.getCmp("customerName").getValue(); 
    $("startDateForm").value =  getFormatDay($("beginDate").value,'ymd');
    $("endDateForm").value =  getFormatDay($("overDate").value,'ymd');
    $("userOwnerForm").value =   $("userOwner").value;
       
    $("carrierNameForm").value = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
    $("incomepurposeForm").value =  getCheckBoxValues("incomePur",1);
    $("arrearsForm").value =  getRadioValue($("radiobutton"));
    $("channelModelParam").value = channelModelParam;
    $("usrNameForm").value = userName;
    $("putYear").value= $("isPutYear").checked == true?1:0;

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	reportForm.target = tarForm;
	reportForm.action="reports/jsp/customerIncomeMoney_print.jsp";
	reportForm.submit(); 	
}
function getIncomeMoneyList(){
	
	     closeDiv();
	     var orgId = $("orgId").value; 
		 var customerName = Ext.getCmp("customerName").getValue(); 
	     var start = getFormatDay($("beginDate").value,'ymd');
	     var end = getFormatDay($("overDate").value,'ymd');
	     var userId = $("userOwner").value;
	     var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	     var putYear = $("isPutYear").checked == true?1:0;
	     var purpose = getCheckBoxValues("incomePur",1);
	     
	
	     
	      if(purpose == '') purpose.push(-1);
//		 alert(purpose);
		 var arrears =getRadioValue($("radiobutton"));
		 var func = function(xml){
//		 	incomePull.incomeMoneyFillTalbe(objs);
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
//				Ext.getBody().unmask();
		 }
//		 Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		 incomePull.getIncomeMoneyList(orgId,putYear,userName,channelModelParam,customerName,carrierName,userId,start,end,purpose,arrears,func);	
		
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

function setUserSelected(){
	 	var id  = $("userId").value;
	 	if(id > 0){
	 		$(user.selectName).value = id;
	 	}
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
//	
//}

function getDate(order_year,serviceDate){

//	$("order_year").value = order_year;
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
//		range:[order_year],
		firstDay:1,
		singleClick	  : true,
		button	  : "beginDate",// id of the button
		dateDisabledFunc : function(date) {
//                      dateDisabledFunc(date,1);
		}
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
//		range:[order_year],
		firstDay:1,
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate",	// id of the button
		dateDisabledFunc : function(date) {
//                     dateDisabledFunc(date,2);
		}
	});


}
