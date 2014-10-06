var customerProduct = new CustomerProduct();
var totalOrdetail;
var user = new User();
var carrier =new  Carrier();
var userName ;
var isPrint;
var mygrid;
var mygrid2;
var myDate = new MyDate();
var config_serviceDate;
var myprint =new MyPrint();

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
	makeCarrierSelectItem();
//	hiddenChartButton();
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	
 	buttonEventFill();
 	getDate();
// 	$("industryDetailed").show();
// 	$("totalBrowser").hide();
 	initGrid();
// 	initGrid2();
 	
 	resetHeigth();
 	
 	 this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
	
	
}
function initGrid(){
	mygrid = new dhtmlXGridObject('industryProductAnalyze_gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	

//	var flds = "行业类别,广告品牌,投放金额,分配金额,欠款,时间";
	var flds = "行业类别,广告品牌,投放金额,分配金额,时间,投放比例";
	
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("16,28,14,14,14,14");
	mygrid.setColAlign("left,left,right,right,right,right");
	mygrid.setColTypes("tree,ed,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);

	mygrid.setSkin("modern2");
//	mygrid.setColSorting("str,str,int,int,int") ;
	mygrid.enableAlterCss("even","uneven"); 
	
mygrid.attachFooter('合计:, , , , , ',['text-align:center;','text-align:left;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	
	mygrid.init();	 
//	mygrid.setSortImgState(true,0,"ASC"); 
}

function hiddenChartButton(){
	if(isDisplayChartParam!=1){
		$("displayChar").hide();
	}else{
		$("displayChar").show();
	}
}

//function initGrid2(){
//	mygrid2 = new dhtmlXGridObject('industryTotalBrowserAnalyze_gridbox');
//	mygrid2.selMultiRows = true;
//	mygrid2.setImagePath("image/grid/");
//	
//
////	var flds = "行业类别,广告品牌,投放金额,分配金额,欠款,时间";
//	var flds = "行业类别,投放金额,投放比例";
//	
//	mygrid2.setHeader(flds);
//
//	mygrid2.setInitWidthsP("40,30,30");
//	mygrid2.setColAlign("left,right,right");
//	mygrid2.setColTypes("ed,ed,ed,");
//    
//	mygrid2.setMultiLine(false);
//	mygrid2.setEditable(false);
//
//	mygrid2.setSkin("modern2");
////	mygrid2.setColSorting("str,int,int") ;
//	mygrid2.enableAlterCss("even","uneven"); 
//
//	mygrid2.init();	 
////	mygrid2.setSortImgState(true,0,"ASC"); 
//}

function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
//	if(channelModelParam!=1){
//		carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	}else{
//		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",setCarrierSelect);
//	}
	carrier.makeSelectItemAnalyze5(carrier,"carrierName","",100,false,userName,setCarrierSelect);  
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
//    var industryProductAnalyze_div = $("industryProductAnalyze_div");
//    industryProductAnalyze_div.style.width = dialogcontent.offsetWidth -73 +"px";
//    industryProductAnalyze_div.style.height = dialogcontent.offsetHeight * 0.8 +"px";	
//    
//    var industryTotalBrowserAnalyze_div = $("industryTotalBrowserAnalyze_div");
//    industryTotalBrowserAnalyze_div.style.width = dialogcontent.offsetWidth -73 +"px";
//    industryTotalBrowserAnalyze_div.style.height = dialogcontent.offsetHeight * 0.8 +"px";	
//    
//    $("industryProductTable").style.width =  industryProductAnalyze_div.offsetWidth - 20 +"px";
//    $("industryTotalBrowserTable").style.width =  industryTotalBrowserAnalyze_div.offsetWidth - 20 +"px";
    
    var gridbox1 = $("industryProductAnalyze_gridbox");
    gridbox1.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
     
//        var gridbox2 = $("industryTotalBrowserAnalyze_gridbox");
//    gridbox2.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
//    

     
    
} 

function buttonEventFill(){

	var btn_search = $("search");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick = queryList;	
	
	
//	
//	var btn_search = $("search");
//	btn_search.setAttribute("href","javascript:void 0");
//	btn_search.onclick = queryList;
//
//	var btn_totalBrowser = $("totalBrowserBtn");
//	btn_totalBrowser.setAttribute("href","javascript:void 0");
//	btn_totalBrowser.onclick = totalBrowser;

//	var Bt_displayChar = $("displayChar");
//	Bt_displayChar.setAttribute("href","javascript:void 0");
//	Bt_displayChar.onclick = getFusionChartObjs;	
//	
////	var Bt_title_div = $("title_div");
////	Bt_title_div.onclick = hiddenTableProty;	
//	
//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_print_export;	
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
		button_export_order();
	}
	
	if(mode =="chart"){
		getFusionChartObjs();
	}	
   
}

function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "industryTypeProduct";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "industryTypeProduct";
	 button_print();
}
function button_export_order(){
	 $("model").value = "export";
	 $("reportType").value = "industryTypeProduct";
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
	if(totalOrdetail==undefined){
		alert("请选择打印类型");
		return false;
	}
	$("totalOrdetailForm").value = totalOrdetail;
//	alert($("customerIdsForm").value+"   "+$("yearForm").value );

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}

//function hiddenTableProty(){
//     $("industryDetailed").hide();
//     $("totalBrowser").show();
//}
//function displayTableProty(){
//     $("industryDetailed").show();
//     $("totalBrowser").hide();
//}

//function tableProtySearch(){
//	var type = $("query").value;
//	if(type == 1){
//        queryList();
//	}else{
//        totalBrowser()
//		}
//}
//function getFusionChartObjs(){
//	var type = $("query").value;
//	if(type == 1){
//        getqueryListChartObjs();
//	}else{
//       gettotalBrowserChartObjs()
//		}
//}

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
//	displayTableProty();
	customerProduct.reset();

	totalOrdetail="true";
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
								attachHeaderNew(mygrid)
				Ext.getBody().unmask();
		}
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//		customerProduct.getIndustryTypeProductByBeginAndEndDate(channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint,func);
		customerProduct.getIndustryTypeProductByBeginAndEndDateXML(channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint,func);
		
	}else{
		alert("请选择日期");
		mygrid.clearAll();
	}
}

function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	


	var cl_2 = (rows == 0)?"": grid.cells(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells(lastId,4).getValue();
	var cl_5 = (rows == 0)?"": grid.cells(lastId,5).getValue();

	var htm ="#rspan*#rspan*"+ cl_2 +"*"+ cl_3+"*"+ cl_4+"*"+ cl_5;

	var h = htm.split("*");
	//alert(h.length);
	var z =  grid.ftr.rows[1];
	
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
	
	grid.deleteRow(lastId);
	
}
//function totalBrowser(){
//	 hiddenTableProty();
//	customerProduct.reset();
//
//	totalOrdetail="false";
//	
//	var beginDate = getFormatDay($("beginDate").value,'ymd');
//	var endDate = getFormatDay($("overDate").value,'ymd');
//
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
//	isPrint="false";
//	
//	if(beginDate != '' && endDate != ''){
//		if(beginDate > endDate){
//			alert("开始日期不能大于结束日期");
//			DWRUtil.removeAllRows($("totalBrowserBody"));
//			return false;
//		}
//		var func = function(xml){
//				mygrid2.clearAll();
//				mygrid2.loadXMLString(xml);	
//		}
//		
////		customerProduct.getIndustryTypeProductTotalBrowser(channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint,func);
//		customerProduct.getIndustryTypeProductTotalBrowserXML(channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint,func);
//		
//	}else{
//		alert("请选择日期");
//		mygrid2.clearAll();
//	}
//}


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
	
//	parent.location.href ="industryProductRelChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+ totalOrdetail+"*"+channelModelParam+"!"+userName;
	window.open("industryProductRelChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+ totalOrdetail+"*"+channelModelParam+"!"+userName,"dispalyChart","")
}
function getFusionChartObjs(){

	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	isPrint="false";
//	var type = $("query").value;
	
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
                isPrint: isPrint,
//                type:type
		};		
		
        var h = $H(a);

		var url = "industryProductRelChart.html?"+h.toQueryString();
//		 alert(url);
		window.open(url);
	}
}
//function gettotalBrowserChartObjs(){
//
//	var beginDate = getFormatDay($("beginDate").value,'ymd');
//	var endDate = getFormatDay($("overDate").value,'ymd');
//
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
//	isPrint="false";
//	
//	function func(objs){
//		fusionChartObjects = objs;
//		alert(fusionChartObjects.length);
//	}
//	
//
//	
////carrierIds,channelModelParam,beginDate,endDate,userId,userName,isPrint
//	if($("beginDate").value=="" || $("overDate").value=="" ){
//		alert("请先选择日期");
//	}else{
//		
//		var a = {
//			 	beginDate: beginDate,
//                endDate: endDate,
//                userId: userId,
//                carrierIds: carrierIds.toString(),
//                userName: userName,
//                channelModelParam: channelModelParam,
//                isPrint: isPrint
//		};		
//		
//        var h = $H(a);
//
//		var url = "industryProductRelChart.html?"+h.toQueryString();
////		 alert(url);
//		window.open(url);
//	}
//}
