var proProgramType = new ProProgramType();
var proProgram = new ProProgram();
var proCustomer = new ProCustomer();
var ctxPath;
var mygrid;
var myWin;
var comboCopyrightNum ;
var comboProName;
var comboCusName ;
var config_serviceDate;
var headers = "节目名称,客户名称,版权号,制作单位,节目类型,版权期限(年),采购金额,销售收入,节目状态,审核状态";

callOnLoad(init);

function init(){
	
	winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98; 	
	ctxPath = $F("ctxPath");
	initToolbar();
	initGrid();
	resetHeigth();
	getServiceDate();
	config_serviceDate = $("config_serviceDate").value; 
	setProgramPara(proProgram);
	proProgramType.getProgramTypesXML($("programTypeDiv"),"proType","150");
	proProgramType.getProgramStatusXML($("programStatusDiv"),"programStatus","150");
	comboEvent(); 
	getDate();
	buttonEventFill();  
	getProgramList();
	 
}
function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
} 
function setProgramPara(obj){
	
	 var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "proProgram";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}
function buttonEventFill(){
	
	var btn_searchediv = $("btnSearch");
	btn_searchediv.onclick= getProgramSearchList;
	
	var btn_close = $("btnClose");
	btn_close.onclick= searchClose;		
}
 function searchClose() {
 	if(!isUndefined(myWin)) myWin.close();
 	
}
function comboEvent(){
	comboCopyrightNum=new dhtmlXCombo("combo_zone3","alfa2",148);
  	comboCopyrightNum.enableFilteringMode(true);
	proProgram.reset();
	var func = function(xml){
			comboCopyrightNum.clearAll();
			comboCopyrightNum.loadXMLString(xml);
	}
	proProgram.getCopyrightNumXML(proProgram.obj,func);
	
	
	comboProName=new dhtmlXCombo("combo_zone2","alfa2",148);

  	comboProName.enableFilteringMode(true);
	proProgram.reset();
	var func = function(xml){
			comboProName.clearAll();
			comboProName.loadXMLString(xml);
	}
	proProgram.getProgramNameXML(proProgram.obj,func);
	
	
	comboCusName=new dhtmlXCombo("combo_zone1","alfa2",148);
  	comboCusName.enableFilteringMode(true);
  	proCustomer.reset();
  	proCustomer.obj.typeId = 1;
	var func = function(xml){
			comboCusName.clearAll();
			comboCusName.loadXMLString(xml);
	}
	proCustomer.getProCustomersXML(proCustomer.obj,func);
}
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "节目名称,客户名称,版权号,制作单位,节目类型,版权期限,采购金额,销售收入,节目状态,审核状态";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("10,10,10,10,10,10,10,10,10,10");
	mygrid.setColAlign("left,left,right,left,left,right,right,right,left,left");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setOnRowSelectHandler(onRowSelectd,true);
}
function onRowSelectd(id){
//	if(colIndex ==0){
		window.location.href=ctxPath +"merm/proProgramEdit.jsp?id="+id;
//	}
//	if(colIndex ==1){
//		window.location.href=ctxPath +"merm/editCustomer.jsp?id="+id;
//	}
}
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml";
	var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
	aToolBar.setOnClickHandler(onButtonClick);

	aToolBar.loadXML(toolbarDataPath,callBack);
	 
	function callBack(){
		aToolBar.hideButtons(); 
                aToolBar.showButtons("4_search,5_print,6_view,7_export,14_chart");  
                aToolBar.showButtons("div_4,div_5,div_6,div_7,div_14");  
                aToolBar.setBarAlign("right");         
	}
	aToolBar.showBar();  
}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function getDate(){
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
	$("startDate").value = getFormatDay(getFormatDay(config_serviceDate,'y')+'0101','y/m/d');
	$("endDate").value = getFormatDay(getFormatDay(config_serviceDate,'y')+'1230','y/m/d');
}	
function onButtonClick(itemId,itemValue){ 
		if(itemId=='4_search') search();
		if(itemId=='5_print') print();
		if(itemId=='6_view') printView();
		if(itemId=='7_export') printExport();
		if(itemId=='14_chart') printChart();
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
		window.location.href=getReportURL('export')	
}
function printChart(){
		window.location.href=getReportURL('chart',true)	
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
 
 		var dateType = $("dateType").value==null?0:$("dateType").value;
		var proProgramType = {id:($("proType").value)};
		var programStatusId = $("programStatus").value==0?null:$("programStatus").value;
		var copyrightArea =  $("commendLevel").value==0?null:$("commendLevel").value;
	
		var isSell = $("isSell").value==2?null:$("isSell").value;
		var createBy = $("isBuy").value==2?null:$("isBuy").value;
		var isChecked = $("isCheckPass").value==2?null:$("isCheckPass").value;
		var modifyBy = $("isPay").value==2?null:$("isPay").value;
		var startDate = getFormatDay($("startDate").value,'ymd');
		var endDate =  getFormatDay($("endDate").value,'ymd');	
 
		var a = {
			 	model: model,
                reportType: "program_report",
                headers:headers,
                displaySumColum:"0,0,0,0,0,0,1,1,0,0",
                dateType:dateType,
                proProgramType:proProgramType,
                programStatusId:programStatusId,
                copyrightArea:copyrightArea,
                isSell:isSell,
                createBy:createBy,
                isChecked:isChecked,
                modifyBy:modifyBy,
                startDate:startDate,
                endDate:endDate,
                copyrightNum: comboCopyrightNum.getComboText(),
                customerName: comboCusName.getComboText(),
                programName: comboProName.getComboText()
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/proProgramChart.jsp?"+ encodeURI(h.toQueryString());	
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}

		return url;
}	
	
function search() {
	var parameters ={
	   	title:"<strong>节目搜索</strong>",
	   	className:"alphacube",
		width:500,
		draggable:false,
		minimizable:false,
		maximizable:false,
		closable:false
   	};
	myWin = new Window(parameters);
	myWin.setContent("searcheDiv");
	myWin.showCenter(true);
}
function getProgramSearchList(){
	proProgram.reset() ;
	var dateType = $("dateType").value==null?0:$("dateType").value;
	proProgram.copyrightNum = comboCopyrightNum.getComboText();
	proProgram.proName = comboProName.getComboText() ;
	proProgram.proProgramType = {id:($("proType").value)};
	proProgram.programStatusId = $("programStatus").value==0?null:$("programStatus").value;
	proProgram.copyrightArea =  $("commendLevel").value==0?null:$("commendLevel").value;
	
	proProgram.isSell = $("isSell").value==2?null:$("isSell").value;
	proProgram.createBy = $("isBuy").value==2?null:$("isBuy").value;
	proProgram.isChecked = $("isCheckPass").value==2?null:$("isCheckPass").value;
	proProgram.modifyBy = $("isPay").value==2?null:$("isPay").value;
	proProgram.startDate = getFormatDay($("startDate").value,'ymd');
	proProgram.endDate =  getFormatDay($("endDate").value,'ymd');	
	
	var proCustomer ={customerName:comboCusName.getComboText()};
	proProgram.proCustomer = proCustomer;
	setProgramPara(proProgram);
	loadData(proProgram,dateType);
	searchClose();
	
}

function getProgramList(){
	proProgram.reset() ;
	var dateType = $("dateType").value==null?0:$("dateType").value;
//	setProgramPara(proProgram);
	loadData(proProgram,dateType);
}
function loadData(obj,dateType,callBackFun){
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
        if(callBackFun) callBackFun();
	}
	proProgram.getProgramsPageXML(obj,dateType,func);
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == proProgram.pageInfo){
		var page = new Page(proProgram.pageInfo,proProgram.pageSize);
		page.goNextPage(pageIndex);
		proProgram.page = page;
		var func =function(){
		}
		loadData(proProgram,func);
	}
}		

