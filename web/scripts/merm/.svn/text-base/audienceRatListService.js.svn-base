var proAudienceRat = new ProAudienceRat();
var carrier = new Carrier();
var _js_prefix="dhtmlxTreeGrid/";
var ctxPath;
var mygrid;
var config_serviceDate;
var headers = "频道,日期,时段,收视率";

var myWin;

callOnLoad(init);


function init(){
		
	 winHeight = self.innerHeight*0.93; 
	 winWidth = self.innerWidth*0.98; 	

   config_serviceDate = 20120505;
	 
	getDate();
		
	ctxPath = $F("ctxPath");

	channelModelParam = $("config_channelModelParam").value;
	setProAudienceRatPara(proAudienceRat);
	setCarrierPara(carrier);
	
	initGrid();
	resetHeigth();
	initToolbar();
	intiCarrierSelect(callBakFun);

	function callBakFun(){
		    proAudienceRat.paramClass = new ParamClass();
			loadData(proAudienceRat);
	}


	
	buttonEventFill();
}

function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
}

function ParamClass(){ 
	    this.carrierId = $F("carrierName");
		this.startDate = getFormatDay($("beginDate").value,'ymd');
		this.endDate =  getFormatDay($("overDate").value,'ymd');	
		this.startTime = ($("startTime_h").value*3600+$("startTime_m").value*60)*1000;
		this.endTime = ($("endTime_h").value*3600+$("endTime_m").value*60)*1000;
		return this;	
}

function setProAudienceRatPara(obj){
	 obj.className  = "proAudienceRat";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "16";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function buttonEventFill(){
	var btn_searche = $("btnSearch");
	btn_searche.onclick= searchDialog;
	
	var btn_close = $("btnClose");
	btn_close.onclick= searchClose;	
	
	
//	var btn_importData = $("importData");
//	btn_importData.onclick= importData;
	
}
function getDate(){
	
//	config_serviceDate = getServiceDate();
	
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
	//$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
	//$("overDate").value = getFormatDay(theYear+'1231','y/m/d');
	
	
//	$("beginDate").value = getFormatDay(config_serviceDate,'y/m/d');
	$("beginDate").value = getFormatDay(getFormatDay(config_serviceDate,'y')+'0101','y/m/d');
	$("overDate").value = getFormatDay(config_serviceDate,'y/m/d');
}

function intiCarrierSelect(callBack){
	//根据是否分频道，取得频道下拉列表
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,carrier.selectName,"",callBack);
	}else{
		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",callBack);
	}
//	function setCarrierSelect(){}
}

function loadData(obj,callBackFun){
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
		if(callBackFun) callBackFun();
	}
	proAudienceRat.getProAudienceRatsPageXML(obj,func);
}


function searchDialog(){
	proAudienceRat.reset();
	setProAudienceRatPara(proAudienceRat);
//	proAudienceRat.carrierId = $("carrierName").value>0?$("carrierName").value:null;
	proAudienceRat.paramClass = new ParamClass();
	loadData(proAudienceRat);
	
	searchClose();
}


	
function initGrid(){
	 	var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader(headers);
		mygrid.setInitWidthsP("25,25,25,25")
		mygrid.setColAlign("left,right,right,right")
		mygrid.setColTypes("ed,ed,ed,ed");
		mygrid.setColSorting("str,str,str,str")
		mygrid.enableMultiselect(true)
		mygrid.init();
		//mygrid.loadXML("sampleData/customer_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		mygrid.setOnRowDblClickedHandler(rowDblClick);
}
	
function rowDblClick(id){
	     window.location.href= ctxPath +"merm/editCustomer.jsp?id="+id;
}

function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
		aToolBar.setOnClickHandler(onButtonClick);

		//aToolBar.addItem(new dhtmlXImageTextButtonObject('dhtmlXToolbar/imgs/iconNewNewsEntry.gif',"新添",100,25,0,'0_new','新添','','','dhtmlXToolbar/imgs/iconNewNewsEntry_dis.gif'));
                //aToolBar.addItem(new dhtmlXToolbarDividerXObject('b_'+(new Date()).valueOf()));		
		
		aToolBar.loadXML(toolbarDataPath,callBack);
		 
		function callBack(){
			aToolBar.hideButtons(); 
	                aToolBar.showButtons("2_delete,4_search,5_print,6_view,7_export,13_import,14_chart");  
	                aToolBar.showButtons("div_2,div_4,div_5,div_6,div_7,div_13,div_14"); 
	                
		}
		
		 aToolBar.showBar();  
 
}
	
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new')  window.location.href= ctxPath +"merm/editCustomer.jsp";
		if(itemId=='2_delete') deleteRow();
		if(itemId=='3_save') alert('this method is save');
		if(itemId=='4_search') search();
		if(itemId=='5_print') print();
		if(itemId=='6_view') printView();
		if(itemId=='7_export') printExport();
		if(itemId=='13_import') importData();
		if(itemId=='14_chart') displayChart();
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

function displayChart(){
		//window.location.href=getReportURL('chart',true);
		 var title ="";
		 var urlStr = getReportURL('chart',true);
		 openNewWin(title,urlStr);		
}

function importData(){
	         var title ="导入收视率";
		 var urlStr = ctxPath + 'merm/audienceRatImport.jsp';	
		  window.location.href = urlStr;
		 //openNewWin(title,urlStr,400,200);		
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
	
	   var param = new ParamClass();
	   
       var url = ctxPath;
       
		var a = {
			 	model: model,
                reportType: "audienceRate_report",
                headers:headers,
                displaySumColum:"0,0,0,1",
                isSum:true,
                isVertical:true,
                carrierId: param.carrierId,
                startDate: param.startDate,
                endDate: param.endDate,
                startTime: param.startTime,
                endTime: param.endTime
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/audienceRatChart.jsp?"+ encodeURI(h.toQueryString());	
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}

		return url;
}

	
	
function deleteRow()
	{  
	    var id = mygrid.getSelectedId();
	    
	    if(id == null) return false;
	   //if (confirm("Do you want to delete  ")) mygrid.deleteSelectedItem(); 
	   //WindowCloseKey.init(); 
	    Dialog.confirm("请确认是否删除", {className: "alphacube", width:300, height:80,okLabel: "确定",cancelLabel: "取消",
	     onOk:function(win){               
	             Dialog.closeInfo();
	             //var id = mygrid.getSelectedId();
	  				 proAudienceRat.removeProAudienceRat(id);
	  				 mygrid.deleteSelectedItem();
	         }});
	  
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
 
 
 function search() {
 	

 	
 	$("searcheDiv").show();
 	
//   var parameters ={
//   	title:"<strong>搜索收视率</strong>",
//   	className:"alphacube",
//	width:400,
//	draggable:false,
//	minimizable:false,
//	maximizable:false,
//	closable:false
//   	// parameters.effectOptions = {className: "popup_effect1"};
//   	 };
//
//	myWin = new Window(parameters);
//	myWin.setContent("searcheDiv");
//	myWin.showCenter(true);
	
}

 function searchClose() {
// 	if(!isUndefined(myWin)) myWin.close();
 	
}


	
	
//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == proAudienceRat.pageInfo){
		var page = new Page(proAudienceRat.pageInfo,proAudienceRat.pageSize);
		page.goNextPage(pageIndex);
		proAudienceRat.page = page;
		var func =function(){

		}
		loadData(proAudienceRat,func);
	}

}		

