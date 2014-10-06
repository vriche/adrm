var customerProduct = new CustomerProduct();
var user = new User();
var carrier =new  Carrier();
var userName ;
var isPrint;
var mygrid;
var mygrid2;
var myDate = new MyDate();
var config_serviceDate;
var myprint = new MyPrint();
var analyzeClass = new AnalyzeClass();



callOnLoad(init);	

function init(){ 
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;
	
	 _make_org_select("orgId",120,"");	
	 			
	setCustomerProduct(customerProduct);
	setCarrierPara(carrier);
	setUserPara(user);
	carrier.obj.nodeLevel =1;
//	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	makeCarrierSelectItem();
//	hiddenChartButton();
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	
 	buttonEventFill();
 	getDate();
 	initGrid();
 	
 	resetHeigth();
 	
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80); 
	
	
}
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	

//	var flds = "行业类别,广告品牌,投放金额,分配金额,欠款,时间";
	var flds = "频道名称,段位名称,投放金额,时间,投放比例";
	
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("20,20,20,20,20");
	mygrid.setColAlign("left,left,right,right,right");
	mygrid.setColTypes("tree,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);

	mygrid.setSkin("modern2");
//	mygrid.setColSorting("str,str,int,int,int") ;
	mygrid.enableAlterCss("even","uneven"); 

	mygrid.init();	 
//	mygrid.setSortImgState(true,0,"ASC"); 
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
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    
    var gridbox = $("gridbox");
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	

} 

function buttonEventFill(){
	var btn_search = $("search");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick = queryList;

//	var Bt_displayChar = $("displayChar");
//	Bt_displayChar.onclick = getFusionChartObjs;	
//	
//	
//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_print_export;	
	
//	var btn_treeCancel2 = $("btn_carrierTreeCancel");
//	btn_treeCancel2.onclick = closeCarrierTree;
	
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 
	
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
//
//function displayCarrierTree2(){
//  var ids = $("carrierName").value;
//  var loginUser =  $("config_username").value;
//  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids;
//  var cleanBtn ={text: '重置',handler: function(){document.getElementById('userCarrReliframe').contentWindow.refreshTreeCarriers();}};	
//  var closeBtn ={text: '确定',handler: function(){removeWin();}};
//  
//        
// var win = new Ext.Window({
//   title : '选择频道',
//   //maximizable : true,
//   // maximized : true,
//   width : 400,
//   height : 300,
//   // autoScroll : true,
//   // bodyBorder : true,
//   // draggable : true,
//   isTopContainer : true,
//   modal : true,
//   resizable : false,
//    buttons: [cleanBtn,closeBtn],
//   contentEl : Ext.DomHelper.append(document.body, {
//    tag : 'iframe',
//     id : 'userCarrReliframe',
//    style : "border 0px none;scrollbar:true",
//    src : urlStr,
//    height : "100%",
//    width : "100%"
//   })
//  })
//  win.show(); 
//  
//     function removeWin(){
//    	var ids = document.getElementById('userCarrReliframe').contentWindow.getCheckedCarriers();
//    	if(ids!=null && ids.length>0){
//			$("carrierName").value = ids.join(',');
//		}else{
//			$("carrierName").value ='';
//		}
// 
//  		win.destroy();
//   	} 
//   win.on({'close': {fn: removeWin}});   
//    
//}


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


function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "carrierBasalAnalyze";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "carrierBasalAnalyze";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "carrierBasalAnalyze";
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
	isPrint="true";
    $("isPrint").value = isPrint;
	$("userId").value  = $(user.selectName).value==0?null:$(user.selectName).value;
	$("carrierNameForm").value = $("carrierName").value==null?0:$("carrierName").value;
	$("userName").value=userName;
	$("channelModelForm").value = channelModelParam;

//	alert($("customerIdsForm").value+"   "+$("yearForm").value );

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}


function setCustomerProduct(obj){
	 obj.className ="customerProduct";
	 obj.IdPrefix = obj.className + "Id";
	 obj.fillObjName = "customerProductBody";
	 obj.color1 		= "BACKGROUND-COLOR: white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageSize 	= "10000";
	 obj.pageInfo 	= "pageInfocustomerProduct";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
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
	
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}

function queryList(){
	customerProduct.reset();
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	isPrint="false";
	
	if(beginDate != '' && endDate != ''){
		if(beginDate > endDate){
			alert("开始日期不能大于结束日期");
			DWRUtil.removeAllRows(customerProduct.tBody);
			return false;
		}

	 	var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);	
				Ext.getBody().unmask();
		}
		 Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//		customerProduct.getIndustryTypeProductByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint,func);
		analyzeClass.getCarrierBasalByBeginAndEndDateXML(channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint,func);
		
	}else{
		alert("请选择日期");
		mygrid.clearAll();
	}
}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == customerProduct.pageInfo){
		var page = new Page(customerProduct.pageInfo,customerProduct.pageSize);
		page.goNextPage(pageIndex);
		customerProduct.page = page;
	}
}	

function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;

	window.open("industryProductRelChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+"*"+channelModelParam+"!"+userName,"dispalyChart","")
}

function getFusionChartObjs(){
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	isPrint="false";
	
	
	function func(objs){
		fusionChartObjects = objs;
		alert(fusionChartObjects.length);
	}
	
//channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint
	if($("beginDate").value=="" || $("overDate").value=="" ){
		alert("请先选择日期");
	}else{
		
		var a = {
			 	beginDate: beginDate,
                endDate: endDate,
                userId: userId,
                carrierName: carrierName,
                userName: userName,
                channelModelParam: channelModelParam,
                isPrint: isPrint
		};		
		
        var h = $H(a);

		var url = "carrierBasalChart.html?"+h.toQueryString();
//		 alert(url);
		window.open(url);
	}
}
