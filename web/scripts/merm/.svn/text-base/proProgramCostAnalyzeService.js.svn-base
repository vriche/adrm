var proProgram = new ProProgram();
var proOrder = new ProOrder();
var ctxPath;
var mygrid;
var comboProName;
var headers=" 节目名称,应付金额";
callOnLoad(init);

function init(){
	winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98; 	
	ctxPath = $F("ctxPath");
	initToolbar();
	initGrid();
	resetHeigth();  
	comboEvent(); 
	buttonEventFill();  
}
function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
}
function buttonEventFill(){
    var btn_searche = $("search");
	btn_searche.onclick=getSearchList;	
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
	var flds = "节目名称,应付金额";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("50,49");
	mygrid.setColAlign("left,right");
	mygrid.setColTypes("ed,ed");
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
		var a = {
			 	model: model,
                reportType: "costAnalyze_report",
                headers:headers,
                displaySumColum:"0,1",
                isSum:true,
                isVertical:true,
                programName: comboProName.getComboText()
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/proProgramCostAnalyzeChart.jsp?"+ encodeURI(h.toQueryString());
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}

		return url;
}	
	
function search() {
	Dialog.confirm($('login').innerHTML,
	 {className:"alphacube", width:300, okLabel: "确定", cancelLabel: "取消",
	         onOk:function(win){              
	             Dialog.closeInfo();
	             return getCostByProgramName();	
	 	}
	});
}
function getCostByProgramName(){
	paramClass = new ParamClass();
	paramClass.programName = $("proName").value ;
	setProAnalyzePara(paramClass);
	loadData(paramClass);
}
function getSearchList(){
	paramClass = new ParamClass();
	paramClass.programName = comboProName.getComboText() ;
	setProAnalyzePara(paramClass);
	loadData(paramClass);
}
function ParamClass(){
		this.programName=null;
		return this;	
}
function setProAnalyzePara(obj){
	var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "proCost";	
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
	getProCostAnalyzeList(obj,func);
}
function getProCostAnalyzeList(obj,callBackFun){
	 var obj = obj;
	    var page = obj.page;	
	    if (page.pageSize > 0){
	    		function getCountFun(size){
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ProAnalyzeManager.getCostByProgramName(callBackFun,obj,page.pageIndex-1,page.pageSize);
			}
			ProAnalyzeManager.getProCostAnalyzeCount(getCountFun,obj);	
	    }else{
			ProAnalyzeManager.getProCostAnalyzes(callBackFun,obj);	
	    }
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


