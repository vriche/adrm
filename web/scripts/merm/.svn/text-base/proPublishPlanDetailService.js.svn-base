var proProgram = new ProProgram();
var ctxPath;
var comboProName;
var config_serviceDate;
var proPublishPlan = new ProPublishPlan();
var myDate = new MyDate();

callOnLoad(init);

function init(){
	ctxPath = $F("ctxPath");
	initToolbar();
	initGrid();  
  	var srcStr = window.location.href;
	var DetaiId = getParamFromUrl(srcStr,"DetaiId");
	winW = getParamFromUrl(srcStr,"winW");
	winH = getParamFromUrl(srcStr,"winH");
	resetHeigth();
  	getProPublishPlanDetail(DetaiId);
}
function buttonEventFill(){
    var btn_searche = $("search");
	btn_searche.onclick=getProgramSearchList;	
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

  function resetHeigth(){
         var gridbox = $("gridbox");
         
        gridbox.style.width = winW*0.85 +"px";	
        gridbox.style.height = winH*0.75 +"px";
         
  } 

function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
	aToolBar.setOnClickHandler(onButtonClick);
	aToolBar.loadXML(toolbarDataPath,callBack);
	 
	function callBack(){
		aToolBar.hideButtons(); 
        aToolBar.showButtons("3_save");  
        aToolBar.showButtons("div_3"); 
	}
	aToolBar.showBar();  
}

function onButtonClick(itemId,itemValue){ 
	if(itemId=='3_save') btnSavePlanDetail();
	if(itemId=='5_print') alert('this method is 5_print');
	if(itemId=='6_view') alert('this method is 6_view');
	if(itemId=='7_export') alert('this method is 7_export');
}
	
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "序号,播出日期,是否有效";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("25,49,25");
	mygrid.setColAlign("left,left,left");
	mygrid.setColTypes("ro,ro,ch");
	mygrid.enableAlterCss("even","uneven"); 
   	mygrid.setMultiLine(false);
	mygrid.setEditable(true);
   	mygrid.setSkin("modern2");
	mygrid.init();	 
}
function getProPublishPlanDetail(DetaiId){
	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	proPublishPlan.getProPublishPlanDetailXML(DetaiId,func);
}

function btnSavePlanDetail(){
	var rows = mygrid.getRowsNum();
   		var ids = new Array();
		for(var i=0;i<rows;i++){
				var rowId = mygrid.getRowId(i);
			var isTrue = getCellValue(rowId,2);
			if(isTrue ==0){
				var id = getCellValue(rowId,0);
				ids.push(id);
			}
			
		}
			
		var func = function(xml){
				alert("修改成功");
		 }
		
				proPublishPlan.removeProPublishPlanDetail(ids,func);
			
		}

function getPlanDetailIds(){
	var rowId = mygrid.getSelectedId();
   	var ids = new Array();
   		ids.push(mygrid.getSelectedId());
	return ids;
}

function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}