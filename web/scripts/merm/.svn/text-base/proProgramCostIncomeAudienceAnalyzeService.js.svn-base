var proProgram = new ProProgram();
var ctxPath;
var mygrid;
var comboProName;
var myWin;
var paramClass ;
var config_serviceDate;
var headers="节目名称,成本,总收入,收视率";

callOnLoad(init);

function init(){
	winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98; 	
	getServiceDate();
	ctxPath = $F("ctxPath");
	initToolbar();
	initGrid();
	resetHeigth();
	config_serviceDate = $("config_serviceDate").value;   
	comboEvent(); 
	buttonEventFill();  
	getDate();
}
function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
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
	
	Calendar.setup({
		inputField  : "beginDate",  // id of the input field
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
	$("beginDate").value = getFormatDay(getFormatDay(config_serviceDate,'y')+'0101','y/m/d');
	$("overDate").value = getFormatDay(getFormatDay(config_serviceDate,'y')+'1230','y/m/d');
}
function buttonEventFill(){
    var btn_searche = $("search");
	btn_searche.onclick=getSearchList;	
	
	var btn_searchediv = $("btnSearch");
	btn_searchediv.onclick= searchDialog;
	
	var btn_close = $("btnClose");
	btn_close.onclick= searchClose;
}
function comboEvent(){
	comboProName=new dhtmlXCombo("combo_zone2","alfa2",150);

  	comboProName.enableFilteringMode(true);
	proProgram.reset();
	var func = function(xml){
		comboProName.clearAll();
		comboProName.loadXMLString(xml);
	}
	proProgram.getProgramNameXML(proProgram.obj,func);
}
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "节目名称,成本,总收入,收视率";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("45,19,18,18");
	mygrid.setColAlign("left,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed");
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
//		window.location.href=ctxPath +"merm/proProgramEdit.jsp?id="+id;
//	}
//	if(colIndex ==1){
//		window.location.href=ctxPath +"merm/editCustomer.jsp?id="+id;
//	}
}
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
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
		window.location.href=getReportURL('export');
}
function printChart(){
		window.location.href=getReportURL('chart',true);
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
        paramClass = new ParamClass();
		var a = {
			 	model: model,
                reportType: "proProgramCostIncomeAudience_report",
                headers:headers,
                displaySumColum:"0,1,1,1",
                isSum:true,
                isVertical:true,
                programName:comboProName.getComboText(),
                startDate:paramClass.startDate,
                endDate:paramClass.endDate   
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/proProgramCostIncomeAudienceChart.jsp?"+ encodeURI(h.toQueryString());	
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}

		return url;
}	
	
function search() {
	var parameters ={
   	title:"<strong>节目成本收入收视对比</strong>",
   	className:"alphacube",
	width:400,
	draggable:false,
	minimizable:false,
	maximizable:false,
	closable:false
   	};
	myWin = new Window(parameters);
	myWin.setContent("searcheDiv");
	myWin.showCenter(true);
}
function searchDialog(){
	paramClass = new ParamClass();
	paramClass.programName = $("proName").value;
	loadData(paramClass);
	searchClose();
}
 function searchClose() {
 	if(!isUndefined(myWin)) myWin.close();
}
function getSearchList(){
	paramClass = new ParamClass();
	paramClass.programName = comboProName.getComboText() ;
	loadData(paramClass);
}
function setProAnalyzePara(obj){
	var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "proCIA";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}
function loadData(obj,callBackFun){
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
        if(callBackFun) callBackFun();
	}
	ProAnalyzeManager.getCostIncomeAudienceAnalyzeList(obj,func);
//	getProIncomeAnalyzeList(obj,func);
}

//function getProIncomeAnalyzeList(obj,callBackFun){
//	 var obj = obj;
//	    var page = obj.page;	
//	    if (page.pageSize > 0){
//	    		function getCountFun(size){
//				page.size = size;
//				page.MakePageNav(page.pageIndex,page.pageInfo);
//				ProAnalyzeManager.getProIncomeAnalyzeList(callBackFun,obj,page.pageIndex-1,page.pageSize);
//			}
//			ProAnalyzeManager.getProAudienceAnalyzeCount(getCountFun,obj);	
//	    }else{
//			ProAnalyzeManager.getProAudienceAnalyzes(callBackFun,obj);	
//	    }
//}
function ParamClass(){
		this.startDate = getFormatDay($("startDate").value,'ymd');
		this.endDate =  getFormatDay($("endDate").value,'ymd');	
		return this;	
}
//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == paramClass.pageInfo){
		var page = new Page(paramClass.pageInfo,paramClass.pageSize);
		page.goNextPage(pageIndex);
		paramClass.page = page;
		var func =function(){
		}
		loadData(paramClass,func);
	}
}


