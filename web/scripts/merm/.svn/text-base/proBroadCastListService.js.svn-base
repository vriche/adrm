var proProgram = new ProProgram();
var proPublishPlan = new ProPublishPlan();
var popupBroadCastDetail = new Popupcenter();
var carrier = new Carrier();
var myDate = new MyDate();
var ctxPath;
var comboProName;
var config_serviceDate;
var mygrid;
callOnLoad(init);


function init(){
        winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98; 	
	ctxPath = $F("ctxPath");
	programId=getParamFromUrl(document.location.href,"programId");
	channelModelParam = $("config_channelModelParam").value;	
	initToolbar();
	//setProPublishPlanPara(proPublishPlan);
	setCarrierPara(carrier);
	initGrid();
	//resetHeigth();
	//comboEvent(); 
	//buttonEventFill();  
	//getDate();
	//getDates();
	getProPublishPlan();
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
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "序号,频道,轮回,开始日期,结束日期,开始时间,结束时间,集数";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("10,20,10,15,15,10,10,10");
	mygrid.setColAlign("center,left,center,left,left,left,left,left");
	mygrid.setColTypes("ro,co,ro,ro,ro,ro,ro,ro");
	//mygrid.setDateFormat("y/m/d");
	mygrid.setColSorting("int,str,int,date,date,str,str,int");
	makeCarrierSelectItem();
	mygrid.enableAlterCss("even","uneven"); 
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	

//	mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
	mygrid.init();
	mygrid.setOnRowSelectHandler(onRowSelectd,true);
}
function onRowSelectd(rowId,colIndex){
	var DetailId = mygrid.getSelectedId();
	displayOrderDetail(DetailId);
}
function displayOrderDetail(id){
	popupBroadCastDetail.url = "proBroadCastDetail.jsp?id=" + id+"&programId="+programId;

	popupBroadCastDetail.popupcenter(popupBroadCastDetail);
}
 function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,carrier.selectName,"",getCarrierCombo);
	}else{
		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",getCarrierCombo);
	}
}
function getCarrierCombo(){
	var el = $(carrier.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(1);
	var arr = getCarrierIds();
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
	    if(ip.value!=0){
		command.put(ip.value,el.options[ip.index].text);

	   }	
	});
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
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar1=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
	aToolBar1.setOnClickHandler(onButtonClick);
	aToolBar1.loadXML(toolbarDataPath,callBack);
	 
	function callBack(){
		aToolBar1.hideButtons(); 
        aToolBar1.showButtons("1_new,2_delete");  
        aToolBar1.showButtons("div_1,div_2"); 
	}
	aToolBar1.showBar();  
}

function onButtonClick(itemId,itemValue){ 
	if(itemId=='1_new') btnAddRow();
	if(itemId=='2_delete') btnDeleteRow();
	//if(itemId=='3_save') btnSaveRow();
}
function btnAddRow(){
	popupBroadCastDetail.url = "proBroadCastDetail.jsp?programId="+programId;

	popupBroadCastDetail.popupcenter(popupBroadCastDetail);
}


function setProPublishPlanPara(obj){
	 var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "proPublishPlan";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}

function getProPublishPlan(){
	proPublishPlan.reset();
        proPublishPlan.obj.programId=programId;
	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proPublishPlan.getProPublishPlanXML(proPublishPlan.obj,func);
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

function btnSaveRow(){
		var rowId = mygrid.getSelectedId();
		if(rowId > 0){
			
			proPublishPlan.reset();
			proPublishPlan.obj.id = rowId;
			proPublishPlan.obj.programId = programId;
			proPublishPlan.obj.carrierId = getCellValue(rowId,1);
			proPublishPlan.obj.weeksPlan = getCellValue(rowId,2);
//			proPublishPlan.obj.startDate = getFormatDate(getCellValue(rowId,3),'ymd');
//			proPublishPlan.obj.endDate = getFormatDate(getCellValue(rowId,4),'ymd');

			var startTime = getCellValue(rowId,5);
			var endTime = getCellValue(rowId,6);

			
			
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

function getFormatDate(shortDate,format){
	var m =  shortDate.substring(0,2);
	var d =  shortDate.substring(3,5);
	var y =  shortDate.substring(6,10);
	shortDate = y + m + d;
	return shortDate;
}
