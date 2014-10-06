var ctxPath;
//var myDate = new MyDate();
var user = new User();
var comboCusName ;
var carrier = new Carrier();
var order   = new Order();
var resource=new Resource();
var customerCarrierRel = new CustomerCarrierRel();
var config_serviceDate;
var oaWorkFlowCheckState = new OaWorkFlowCheckState();
var mygrid;
callOnLoad(init);


function init(){
  
    winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98;
	ctxPath =  getCtxPath();
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;
	userId=  _app_params.user.id;
	channelModelParam = _app_params.sysParam.channelModelParam;	
	
	var callBackFun=function(obj){
		customerId=obj[0]==null?0:obj[0];
		getCarrierPageXML();
	}
	 
	order.getCustomerIdByUserId(userId,callBackFun);
	
	setCustomerCarrierRelPara(customerCarrierRel);
	
    initGrid();
   	initToolbar();
    	
}
function initToolbar(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar1=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
	aToolBar1.setOnClickHandler(onButtonClick);
	aToolBar1.loadXML(toolbarDataPath,callBack);
	 
	function callBack(){
		aToolBar1.hideButtons(); 
        aToolBar1.showButtons("1_new");  
        aToolBar1.showButtons("div_1"); 
	}
	aToolBar1.showBar();  
}
function onButtonClick(itemId,itemValue){ 
	if(itemId=='1_new') btnAddRow();
}
function btnAddRow(){
	document.location.href="orderDetails.html?id=" +customerId;
}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "序号,播出日期,应付金额(元),已付金额(元),占用时长(秒),审核结果";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("5,15,20,20,20,20");
	mygrid.setColAlign("center,center,center,center,center,center");
	mygrid.setColTypes("ro,ro,ro,ro,ro,ro");
	mygrid.setDateFormat("y/m/d");
	mygrid.setColSorting("int,date,int,int,int,str");
	mygrid.enableAlterCss("even","uneven"); 
    	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	

//	mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
	mygrid.init();
	
	mygrid.setOnRowSelectHandler(getOrderDetail,true);
}	
function getOrderDetail(rowId){
	var publishDate=getFormatDay(getCellValue(rowId,1),'ymd');
	var payMoney=getCellValue(rowId,2);
	var isChecked=getCellValue(rowId,5);
	var orderId=mygrid.getSelectedId();
	document.location.href="orderDetails.html?id="+customerId+"&orderId="+orderId;
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
function getCarrierPageXML(){
	customerCarrierRel.obj.customerId=customerId;
	loadData(customerCarrierRel.obj);
}
//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == customerCarrierRel.pageInfo){
		var page = new Page(customerCarrierRel.pageInfo,customerCarrierRel.pageSize);
		page.goNextPage(pageIndex);
		customerCarrierRel.page = page;
		var func =function(){
		}
		loadData(customerCarrierRel.obj,func);
	}
}
function loadData(obj,callBackFun){
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
        	if(callBackFun) callBackFun();
	}
	customerCarrierRel.getCarrierPageXMLs(obj,func);
}
function setCustomerCarrierRelPara(obj){
	 var page=Math.round(winHeight* 0.80/20)-3;
	 obj.className  = "customerCarrierRel";
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= page;
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}