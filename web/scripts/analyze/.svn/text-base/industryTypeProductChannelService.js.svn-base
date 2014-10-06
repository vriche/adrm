var customerProduct = new CustomerProduct();
var totalOrdetail;
var user = new User();
var carrier =new  Carrier();
var resourceChannel = new ResourceChannel();
var userName ;
var isPrint;
var mygrid;
var mygrid2;
var myDate = new MyDate();
var config_serviceDate;
var headers;
var displaySumColum;
var isDetail=0;

callOnLoad(init);	

function init(){
	winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98;
	

	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;		

	userName =  _app_params.user.username;	
	
	setCustomerProduct(customerProduct);
	setCarrierPara(carrier);
	setUserPara(user);

	carrier.obj.nodeLevel =1;
	makeCarrierSelectItem();
	hiddenChartButton();
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

 	buttonEventFill();
 	getDate();
 		
	var callback =function(objs){
		initGrid(objs);
 		resetHeigth(); 
	}
	
	resourceChannel.obj.enable =1;
	resourceChannel.getResourceChannels(resourceChannel.obj,callback);

}
function initGrid(objs){
	mygrid = new dhtmlXGridObject('industryProductAnalyze_gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	var flds='品类,品牌名称,投播量,';
	var initWidthsP = '10,12,10,';
	var colAlign = 'left,left,left,';
	var colTypes = 'tree,ed,ed,';
	
	displaySumColum = '0,0,1,';
	for(var i=0;i<objs.length;i++){
		flds+=objs[i].name+',';
		initWidthsP+='9,';
		colAlign+='right,';
		colTypes +='ed,';
		displaySumColum +='1,';
	}
	flds += "到款,投放时间,投放比例,备注";
	initWidthsP+='9,7,7,';
	colAlign +='right,right,right,left';
	colTypes +='ed,ed,ed,ed,ed';
	displaySumColum +='1,1,0,0';
	var sum=0;
	for(var i =0;i<initWidthsP.split(',').length;i++){
			sum+=initWidthsP.split(',')[i]-0; 
	}
	if(sum>95){
		initWidthsP+=5;
	}else{
		initWidthsP+=(100-sum);
	}  
	headers = flds;
	
	mygrid.setHeader(flds);
	mygrid.setInitWidthsP(initWidthsP);
	mygrid.setColAlign(colAlign);
	mygrid.setColTypes(colTypes);
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.setSkin("modern2");
	mygrid.enableAlterCss("even","uneven"); 

	mygrid.init();
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
    var gridbox1 = $("industryProductAnalyze_gridbox");
    gridbox1.style.height = dialogcontent.offsetHeight * 0.85 +"px";
} 

function buttonEventFill(){
	var btn_search = $("searchTotalBrowser");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick = queryList;

	var Bt_displayChar = $("displayChar");
	Bt_displayChar.setAttribute("href","javascript:void 0");
	Bt_displayChar.onclick = getFusionChartObjs;	

	var Btn_view_order = $("Btn_view_order");
	Btn_view_order.onclick = button_view_order;

	var Btn_print_order = $("Btn_print_order");
	Btn_print_order.onclick = button_print_order;	
	
	var Btn_export_order = $("Btn_export_order");
	Btn_export_order.onclick = button_print_export;	
}

//function button_view_order(){
//	 $("model").value = "view";
//	 $("reportType").value = "industryTypeChannelProduct";
//	 button_print();
//}	
//function button_print_order(){
//	 $("model").value = "print";
//	 $("reportType").value = "industryTypeChannelProduct";
//	 button_print();
//}
//function button_print_export(){
//	 $("model").value = "export";
//	 $("reportType").value = "industryTypeChannelProduct";
//	 button_print();
//}
//function button_print(){
//	var msg = "是否显示明细 ?";
//	if(confirm(msg)){
//		$("isDetail").value = 1;
//	}
//	
//	$("startDate").value = getFormatDay($("beginDate").value,'ymd');
//	$("endDate").value = getFormatDay($("overDate").value,'ymd');
//
//    $("isPrint").value = "true";
//	$("userId").value  = $(user.selectName).value==0?null:$(user.selectName).value;
//	$("carrierNameForm").value = $("carrierName").value==null?0:$("carrierName").value;
//	$("userName").value=userName;
//	$("channelModelForm").value = channelModelParam;
//	if(totalOrdetail==undefined){
//		alert("请选择打印类型");
//		return false;
//	}
//	$("totalOrdetailForm").value = totalOrdetail;
//
//	var tarForm =  $("tarForm");
//	var reportForm = $("ReportForm");
//	
//	reportForm.target = tarForm;
//	reportForm.action="reports/jsp/common_reports.jsp";
//	reportForm.submit(); 	
//}
function button_print_order(){

		if(confirm("是否显示明细 ?")){
			isDetail = 1;
		}else{
			isDetail = 0;
		}
		var title ="";  
		var urlStr = getReportURL('print');
		window.open(urlStr);
//		openNewWin(title,urlStr);			
}	
function button_view_order(){
		if(confirm("是否显示明细 ?")){
			isDetail = 1;
		}else{
			isDetail = 0;
		}
		var title ="";
		var urlStr = getReportURL('view');window.open(urlStr);
//		openNewWin(title,urlStr);					
}
function button_print_export(){
		if(confirm("是否显示明细 ?")){
			isDetail = 1;
		}else{
			isDetail = 0;
		}
		window.location.href=getReportURL('export');
}
function getFusionChartObjs(){
		window.open(getReportURL('chart',true));
}
function openNewWin(title,urlStr,w,h) {
   
   w = w > 0?w:winWidth;
   h = h > 0?w:winHeight;

   var parameters ={
	   	title:"<strong>" + title +"</strong>",
	   	className:"alphacube",
		width:w,
		height:h,
		draggable:false,
		minimizable:false,
		maximizable:false,
		closable:true
   };

	myWin = new Window(parameters);
	myWin.setURL(urlStr);
	myWin.showCenter(true);
	
}
function getReportURL(model,isChart){
	
        var url = $('ctxPath').value;
		
		var a = {
			 	model: model,
                reportType: "industryTypeChannelProduct_report",
                headers:headers,
                displaySumColum:displaySumColum,
                isSum:true,
                isVertical:false,
                startDate:getFormatDay($("beginDate").value,'ymd'),
                endDate:getFormatDay($("overDate").value,'ymd'),
                isPrint:'true',
                userId:$(user.selectName).value==0?null:$(user.selectName).value,
                carrierId:$("carrierName").value==null?0:$("carrierName").value,
                userName:userName,
                channelModelParam:channelModelParam,
                isDetail:isDetail
		};		
		var h = $H(a); 
		if(isChart){        
			url = url +"industryProductChannelChart.html?"+encodeURI(h.toQueryString());	
		}else{
			url = url +"reports/printServlet?"+ encodeURI(h.toQueryString());	
		} 

		return url;
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
				Ext.getBody().unmask();
		}
		 Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		customerProduct.getIndustryTypeProductChannelByBeginAndEndDateXML(channelModelParam,beginDate,endDate,userId,carrierName,userName,isPrint,func);
		
	}else{
		alert("请选择日期");
		mygrid.clearAll();
	}
}

//function goNextPage(pageIndex,pageInfoName){
//	if(pageInfoName == customerProduct.pageInfo){
//		var page = new Page(customerProduct.pageInfo,customerProduct.pageSize);
//		page.goNextPage(pageIndex);
//		customerProduct.page = page;
//	}
//}	
//
//function displayChar(){
//	var startDate = getFormatDay($("beginDate").value,'ymd');
//	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
//	
//	window.open("industryProductRelChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+ totalOrdetail+"*"+channelModelParam+"!"+userName,"dispalyChart","")
//}
//function getFusionChartObjs(){
//
//	var beginDate = getFormatDay($("beginDate").value,'ymd');
//	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
//	isPrint="false";
//	
//	function func(objs){
//		fusionChartObjects = objs;
//		alert(fusionChartObjects.length);
//	}
//	
//	if($("beginDate").value=="" || $("overDate").value=="" ){
//		alert("请先选择日期");
//	}else{
//		
//		var a = {
//			 	beginDate: beginDate,
//                endDate: endDate,
//                userId: userId,
//                carrierName: carrierName,
//                userName: userName,
//                channelModelParam: channelModelParam,
//                isPrint: isPrint,
////                type:type
//		};		
//		
//        var h = $H(a);
//
//		var url = "industryProductRelChart.html?"+h.toQueryString();
//		window.open(url);
//	}
//}
