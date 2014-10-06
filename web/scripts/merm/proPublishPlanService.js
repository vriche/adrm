var proProgram = new ProProgram();
var proPublishPlan = new ProPublishPlan();
var popupBroadCastDetail = new Popupcenter();
var carrier = new Carrier();
var myDate = new MyDate();
var ctxPath;
var comboProName;
var config_serviceDate;
var headers="序号,节目名称,频道,开始日期,结束日期,开始时间,结束时间,播出轮次,集数";

callOnLoad(init);

function init(){
	winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98; 	
	ctxPath = $F("ctxPath");
	channelModelParam = $("config_channelModelParam").value;	
	initToolbar();
	setProPublishPlanPara(proPublishPlan);
	setCarrierPara(carrier);
	setProgramPara(proProgram);
	initGrid();
	resetHeigth();
	comboEvent(); 
	buttonEventFill();  
	//getDate();
	getDates();
	search();
}
function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
} 
function buttonEventFill(){
   
	
	var btn_searche = $("btnSearch");
	btn_searche.onclick= searchDialog;
	
	var btn_close = $("btnClose");
	btn_close.onclick= searchClose;	
}

function searchDialog(){
	var proName = comboProName.getComboText();
	proPublishPlan.reset();
	proPublishPlan.startDate = getFormatDay($("beginDate").value,'ymd');
	proPublishPlan.endDate = getFormatDay($("overDate").value,'ymd');
		var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	proPublishPlan.getProPublishPlanPageXML(proName,proPublishPlan,func);
	
	searchClose();
}

 function searchClose() {
 	if(!isUndefined(myWin)) myWin.close();
 	
}

function comboEvent(){
	comboProName=new dhtmlXCombo("proName","alfa2",110);

  	comboProName.enableFilteringMode(true);
	proProgram.reset();
	var func = function(xml){
			comboProName.clearAll();
			comboProName.loadXMLString(xml);
	}
	proProgram.getProgramNameXML(proProgram.obj,func);
}

function getDate(){
	config_serviceDate = getServiceDate();
	Calendar.setup({
		inputField  : "startDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "startDate"	// id of the button
	});
	
	Calendar.setup({
		inputField  : "endDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "endDate"	// id of the button
	});

	$("startDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("endDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}

function getDates(){
	config_serviceDate = getServiceDate();
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

	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}

 function getServiceDate(){
  	var dd;
 	var fuc = function(d){
 		dd =  d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 	return dd;
 }
 

function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
	aToolBar.setOnClickHandler(onButtonClick);
	aToolBar.loadXML(toolbarDataPath,callBack);
	 
	function callBack(){
		aToolBar.hideButtons(); 
        aToolBar.showButtons("4_search,5_print,6_view,7_export");  
        aToolBar.showButtons("div_4,div_5,div_6,div_7"); 
         aToolBar.setBarAlign("right");    
	}
	aToolBar.showBar(); 
}

function onButtonClick(itemId,itemValue){ 
	//if(itemId=='1_new') btnAddRow();
	//if(itemId=='2_delete') btnDeleteRow();
	//if(itemId=='3_save') btnSaveRow();
	if(itemId=='4_search') search();
	if(itemId=='5_print') print();
	if(itemId=='6_view') printView();
	if(itemId=='7_export') printExport();
}

 function search() {
 	
   var parameters ={
   	title:"<strong>搜索播出计划</strong>",
   	className:"alphacube",
	width:400,
	draggable:false,
	minimizable:false,
	maximizable:false,
	closable:false
   	// parameters.effectOptions = {className: "popup_effect1"};
   	 };

	myWin = new Window(parameters);
	myWin.setContent("searcheDiv");
	myWin.showCenter(true);
	
}

function print(){
		//window.location.href=getReportURL('print')	
		var title ="";
		var urlStr = getReportURL('print');
		openNewWin(title,urlStr);			
}	
function printView(){
		//window.location.href=getReportURL('view')
		var title ="";
		var urlStr = getReportURL('view');
		 openNewWin(title,urlStr);					
}
function printExport(){
		window.location.href=getReportURL('export');
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
   	// parameters.effectOptions = {className: "popup_effect1"};
   };

	myWin = new Window(parameters);
	myWin.setURL(urlStr);
	myWin.showCenter(true);
	
}
function getReportURL(model,isChart){
	
        var url = ctxPath;
		
		var a = {
			 	model: model,
                reportType: "proPublishPlan_report",
                headers:headers,
                displaySumColum:"0,0,0,0,0,0,0,0,0",
                isSum:true,
                isVertical:true,
                startDate: getFormatDay($("beginDate").value,'ymd'),
                endDate: getFormatDay($("overDate").value,'ymd'),
                programName: comboProName.getComboText()
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/proPublishPlanChart.jsp?"+ encodeURI(h.toQueryString());	
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}

		return url;
}
	
function initGrid(){
//	var toolbarDataPath = ctxPath+"merm/toolbarData/publishPlan_grid.xml";
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "序号,节目名称,频道,开始日期,结束日期,开始时间,结束时间,播出轮回,集数";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("11,12,11,11,11,11,11,11,11");
	mygrid.setColAlign("center,left,left,left,left,left,left,left,left");
	mygrid.setColTypes("ro,coro,coro,ro,ro,ro,ro,ro,ro");
	mygrid.setColSorting("int,str,str,date,date,str,str,int,int");
	makeCarrierSelectItem();
	makePublishPlanSelectItem();
	
	mygrid.enableAlterCss("even","uneven"); 
   	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
   	mygrid.setSkin("modern2");
	mygrid.init();
//	mygrid.loadXML(toolbarDataPath);
	mygrid.setOnRowSelectHandler(onRowSelectd,true);
//	mygrid.setOnRowDblClickedHandler(rowDblClick);
}
function rowDblClick(id){
	     window.location.href=ctxPath +"merm/editCustomer.jsp?id="+id;
}

function setProPublishPlanPara(obj){
	 var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "proPublishPlan";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}

function getPaymentListByCustomer(){
	var proName = comboProName.getComboText();
	proPublishPlan.reset();
	proPublishPlan.startDate = getFormatDay($("startDate").value,'ymd');
	proPublishPlan.endDate = getFormatDay($("endDate").value,'ymd');
	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proPublishPlan.getProPublishPlanPageXML(proName,proPublishPlan,func);
}

function onRowSelectd(rowId,colIndex){
	var DetailId = mygrid.getSelectedId();
	displayOrderDetail(DetailId,rowId);
}
function displayOrderDetail(id,rowId){
	popupBroadCastDetail.url = "proBroadCastDetail.jsp?id=" + id+"&programId="+getCellValue(rowId,1);

	popupBroadCastDetail.popupcenter(popupBroadCastDetail);
}
function showPlanDetai(DetaiId){
	var winW= 600;
	var winH = 550;
	var title = "节目播出明细";
	var theme = "leopard"; //vista mac_os_x lighting black_hud leopard window
	var draggable = false;
	var minimize = false;
	var maximize = false;
	var close =  'destroy';
	var resizable = false;
	var urlStr = ctxPath+'merm/proPublishPlanDetail.jsp?DetaiId='+DetaiId+'&winW='+winW+'&winH='+winH;
	openWindowDetail('mywin',urlStr,winW,winH,title,theme,draggable,minimize,maximize,close,resizable);
}	


function btnAddRow(){
	var rows = mygrid.getRowsNum() + 1;
	
		mygrid.addRow((new Date()).valueOf(),[rows],mygrid.getRowsNum()+1);
}

function btnDeleteRow(){
	var id = mygrid.getSelectedId();
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
		proPublishPlan.removeProPublishPlan(id);
		mygrid.deleteSelectedItem(); 
	    } 
	}
}

function ParamClass(){ 
	    this.carrierId = $F("carrierName");
		this.startDate = getFormatDay($("beginDate").value,'ymd');
		this.endDate =  getFormatDay($("overDate").value,'ymd');	
		this.startTime = ($("startTime_h").value*3600+$("startTime_m").value*60)*1000;
		this.endTime = ($("endTime_h").value*3600+$("endTime_m").value*60)*1000;
		return this;	
}

function btnSaveRow(){
		var rowId = mygrid.getSelectedId();
		if(rowId > 0){
			
			proPublishPlan.reset();
			proPublishPlan.obj.id = rowId;
			proPublishPlan.obj.programId = getCellValue(rowId,1);
			proPublishPlan.obj.carrierId = getCellValue(rowId,2);
			proPublishPlan.obj.startDate = getFormatDate(getCellValue(rowId,3),'ymd');
			proPublishPlan.obj.endDate = getFormatDate(getCellValue(rowId,4),'ymd');
			if(proPublishPlan.obj.startDate>proPublishPlan.obj.endDate){
				alert("开始日期不应早于结束日期!");
				return false;
			}
			var startTime = getCellValue(rowId,5);
			var endTime = getCellValue(rowId,6);

			proPublishPlan.obj.weeksPlan = getCellValue(rowId,7)
			
			if(startTime.length==5 && endTime.length==5){
				proPublishPlan.obj.startTime = (startTime.substring(0,2)*3600 + startTime.substring(5,3)*60)*1000;
				proPublishPlan.obj.endTime = (endTime.substring(0,2)*3600 + endTime.substring(5,3)*60)*1000;
			    if(proPublishPlan.obj.startTime>proPublishPlan.obj.endTime){
				    alert("开始时间不应早于结束时间!");
				    return false;
			}
				var func = function(id){
				mygrid.changeRowId(rowId,id);
				alert("保存成功！！！");
			}
				proPublishPlan.saveProPublishPlanById(proPublishPlan.obj,func);
			}else{
				alert("请确认开始时间和结束时间的格式(例如：08:06)");
			}
	    	
		}else{
			alert("请选择要保存的数据");
		}
}
function getFormatTime(shortDate,format){
	shortDate +='';
	var len = shortDate.length;
	if(len == 0)return null;
	var isFmtt = false;
	if(len > 8) isFmtt = true;
	var y =  shortDate.substring(0,4);
	var m =  isFmtt?shortDate.substring(5,7): shortDate.substring(4,6);
	var d =  isFmtt?shortDate.substring(8,10):shortDate.substring(6,8);
	var isY = format.indexOf("y") > -1;
	var isM = format.indexOf("m") > -1;
	var isD = format.indexOf("d") > -1;
	var sep = "";
	if(format.indexOf("-") > -1) sep="-";
	if(format.indexOf("/") > -1) sep="/";
	if(isY&&isM&&isD) shortDate = y + sep + m + sep + d;
	if(!isY&&isM&&isD) shortDate =  m + sep + d;
	if(isY&&!isM&&!isD) shortDate =  y;
	if(!isY&&isM&&!isD) shortDate =  m;
	if(!isY&&!isM&&isD) shortDate =  d;
	return shortDate;
}

function makePublishPlanSelectItem(){
		proProgram.makeSelectItemAnalyze(proProgram.obj,proProgram.selectName,"",getProProgramCombo);
}

function getProProgramCombo(){
	var el = $(proProgram.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(1);
	var arr = getCarrierIds();
	//alert(arr);
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
		if(ip.value!=0){
				command.put(ip.value,el.options[ip.index].text);

		}	
		}
	);
}

function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,carrier.selectName,"",getCarrierCombo);
	}else{
		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",getCarrierCombo);
	}
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function setProgramPara(obj){
	 obj.className  = "proProgram";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function getCarrierCombo(){
	var el = $(carrier.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(2);
	var arr = getCarrierIds();
	//alert(arr);
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
		if(ip.value!=0){
			
				command.put(ip.value,el.options[ip.index].text);

		}	
		}
	);
}
 function getCarrierIds(){
	var rows = mygrid.getRowsNum();
   	 var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i); 
		ids.push(getCellValue(id,0));
	}
	return ids;
}


function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}

function getFormatDate(shortDate,format){
	var m =  shortDate.substring(0,2);
	var d =  shortDate.substring(3,5);
	var y =  shortDate.substring(6,10);
	shortDate = y + m + d;
	return shortDate;
}
