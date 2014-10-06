var resource = new Resource();
var carrier =new  Carrier();
var specific = new Specific();
var order = new Order();

var carrierType = new CarrierType();
var report = new MyPrint();
var myDate = new MyDate();
var user = new User();
var customer = new Customer();

var ctxPath;
callOnLoad(init);	
  
function init(){ 	
//    if(!check_app_params()) return false;
	ctxPath =  _app_params.ctxPath;
	winHeight = self.innerHeight*0.93; 
	winWidth  = self.innerWidth*0.98;
	

	get_cur_year();   
	channelModelParam =  _app_params.sysParam.channelModelParam;
	config_serviceDate =  _app_params.serviceDate.def;
	userName =  _app_params.user.username;
	
	loginUserId =  _app_params.user.id;
	  _make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);	
	 _make_org_select("orgId",120,"");	
 
	
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	 
	
	setCarrierTypePara(carrierType);
	getDate();
	setOrderPara(order);
	setResourcePara(resource);			
	setSpecificPara(specific);	
	setCarrierPara(carrier)
	carrier.obj.parentId = 0;
	carrier.obj.enable = false;
//	specific.makeSelectFromMap(specific.obj,specific.selectName,"");
	specific.makeSelectFromMap3(specific.obj,"resourceSpecificId","50",null,"");	
	
    
	
	
	initUserCmd();
	initCustomer();
	initResourceTree(carrierType);
 	buttonEventFill();
 	initGrid();
 	resetHeigth();

	this.report.buildButtons(this,"printReportDiv",[0,1,2],80);
}





function initUserCmd(){
	var paramObJ ={};
	paramObJ.orgId =  $("orgId").value;
	paramObJ.loginUser = userName;
	paramObJ.loginUserId = loginUserId;
	user.obj = paramObJ;
	user.getLovCombo('userRenderDiv','userId',100,false,true);
}


function initCustomer(){
	customer.obj.orgId = $("orgId").value;
 	customer.obj.version = $("resource_year").value;
 	customer.obj.loginUser = userName;
 	customer.obj.model = "1";

 	var callBackFun = function(){};
 	customer.getCustomerRemote("customerRenderDiv","customerName",100,function(){});
}
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
	var flds = "日期,订单编号,客户名称,广告位置,指定位置,备注,广告名称,广告版本,广告长度";
	
	mygrid.setHeader(flds);


	mygrid.setInitWidthsP("10,10,10,20,10,10,10,10,10");

	mygrid.setColAlign("center,center,left,left,left,left,left,left,right");
	mygrid.setColTypes("ed,link,ed,ed,ed,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);

    mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str,str,str,str,str,int") ;
	mygrid.setSkin("modern2");
	
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
}
//function resetHeigth(){
//   	var dialogcontent = $("dialogcontentDiv");
//    var treebox = $("carrierTypeTreebox");
//	treebox.style.height = dialogcontent.offsetHeight*0.83+"px";	
//	$("adResCount").style.height = dialogcontent.offsetHeight*0.79+"px";
//} 


function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("carrierTypeTreebox");
    var gridbox = $("gridbox");
	treebox.style.height = dialogcontent.offsetHeight*0.83+"px";	
//	$("adResCount").style.height = dialogcontent.offsetHeight*0.79+"px";
	gridbox.style.height = dialogcontent.offsetHeight*0.85 + "px";	
	
	if(mygrid) mygrid.setSizes();	
} 
function setOrderPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 obj.className = "orderSpecific";	
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "specificList";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";

}
function setCarrierTypePara(obj){
	obj.className  = "carrierType";
	obj.IdPrefix   = obj.className + "Id";
	obj.treebox	   = obj.className + "Treebox";
	obj.tree = new Tree(obj.treebox); 
}
function setSpecificPara(obj){
	 obj.className  = "specfic";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "resourceSpecificId";
}
function setResourcePara(obj){
	obj.className  = "resource";
 	obj.IdPrefix 	= obj.className + "Id";
}
function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
}

function buttonEventFill(){
	var btn_search=$("search");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick=getSpecificTable;

	
	var change_resource_year = $("resource_year");
	change_resource_year.onchange = rest_resource_tree;
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
		button_print_export();
	}
	
	if(mode =="chart"){
		getFusionChartObjs();
	}	
	   
}
function get_cur_year(){
	$("resource_year").value =  _app_params.serviceDate.year;
	resource_year = _app_params.serviceDate.year;
}







//function getSpecificTable_2(){
//
//	var resourceId = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
//	var beginDate = getFormatDay($("beginDate").value,'ymd');
//	var overDate = getFormatDay($("overDate").value,'ymd');
//
//	var specificId = $(specific.selectName).value;
//	specificId = specificId==0?null:specificId;
//	if(resourceId==null){alert("请选择广告资源！"); return false;}
//	var func = function(xml){
//				mygrid.clearAll();
//				mygrid.loadXMLString(xml);	
//				Ext.getBody().unmask();
//	 }
//	var ispass = searchyear(beginDate,overDate);
//	if(ispass){
//		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//		
//		
//		order.getSpecificInfo(beginDate,overDate,resourceId,specificId,func);
//	}
//		
//}

function initResourceTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
//	obj_tree.enableCheckBoxes(true);
//	obj_tree.enableThreeStateCheckboxes(true);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableDragAndDrop(true);


//    obj_tree.enableItemEditor(false);
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	
	getResourceTree(obj);
}

function doOnSelect(itemId){
	        if(itemId == "root") return false;
	        var isItemChecked = carrierType.tree.dhtmlTree.isItemChecked(itemId);
		carrierType.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
}

function rest_resource_tree(){
	 resource_year = $("resource_year").value;
	 reLoadTree(carrierType);
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = resource_year  + beginDate.substring(4,beginDate.length);
	 overDate = resource_year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;
}
function reLoadTree(obj){
	obj.tree.dhtmlTree.deleteChildItems(0);
	getResourceTree(obj);
}

//function getResourceTree(obj){
//	var getxml = function(strXML){ 
//		obj.tree.dhtmlTree.loadXMLString(strXML);
//		Ext.getBody().unmask();
//	} 
//	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//	obj.reset();
//	obj.obj.parentId = 0;
//	obj.getTreeXMLFromMapByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);
//}



function getResourceTree(){
    var obj_tree = carrierType.tree.dhtmlTree;
	var getxml = function(strXML){ 
		obj_tree.deleteChildItems(0);	
		carrierType.tree.dhtmlTree.loadXMLString(strXML);
		Ext.getBody().unmask();
	};
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	carrierType.reset();
	carrierType.obj.parentId = 0;
	carrierType.obj.nodeLevel = 999;
	carrierType.obj.orgId = $("orgId").value;
	
	carrierType.obj.memo = "3";
	carrierType.obj.enable = 0;
	carrierType.obj.fitterCarrier = 1;
	carrierType.obj.loginUser = userName;	
	
	carrierType.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);

}


function button_view_order(){
		var title ="";
		var urlStr = getReportURL('view');
//		if(!urlStr) return false;
//		openNewWin(title,urlStr);					
}

function button_print_order(){
		var title ="";
		var urlStr = getReportURL('print');
//		if(!urlStr) return false;
//		openNewWin(title,urlStr);			
}	
function button_print_export(){
		var urlStr =  getReportURL('export');
		if(!urlStr) return false;
		window.location.href=urlStr;
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



			
function getParam(){
	
	var resourceId = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var overDate = getFormatDay($("overDate").value,'ymd');
	var specificId = $(specific.selectName).value;
	specificId = specificId==0?null:specificId;
	
	
//	var userIds = Ext.getCmp('userId').getCheckedValue();
	
	var userIds =  Ext.getCmp('userId').getValue();

	
	var customerName =  Ext.fly('customerName').dom.value; 
	var publishMemo = $("publishMemo").value;
	publishMemo =  publishMemo==''||publishMemo=='播出备注'?null:publishMemo;
	customerName =  customerName==''||customerName=='请选择客户...'?null:customerName;
	
	
	var param ={};
	param.beginDate = beginDate;
	param.endDate = overDate;
	param.resourceId = resourceId+'';
	param.specificId = specificId;
	
	param.userIds = userIds;
	param.customerName = customerName;
	param.publishMemo = publishMemo;	

    var ispass = searchyear(beginDate,overDate);
 
    return param;
	
}









function getSpecificTable(){

	var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);	
				Ext.getBody().unmask();
	 }    

        var param = getParam();
		var queryStr = $H(param).toQueryString();
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		order.getSpecificInfo2(queryStr,func);
	
	
}

function getReportURL(model,isChart){
        var url = ctxPath;
        var carrierId = $("carrierIdForm").value;
		var paramObj = getParam();
		var printParam = {
 						model:  model,
					 	title:'指定信息查询',
		                reportType: "specificQuery_report",
		                reportFile:'',
		                headers:"日期,订单编号,客户名称,广告位置,指定,备注,广告名称,广告版本,长度",
		                 displaySumColum:"0,0,0,0,0,0,0,0,1",
		                colAlign:"center,center,center,center,center,center,center,center,right",
		                colTypes:"ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed",
		                widthsP:"10,10,10,20,5,10,10,20,5",
		                isSum:true,
		                isVertical:false               
                
		};
		
		var a = Object.extend(paramObj,printParam);

        report.loadApplet(a,ctxPath,800,500);
//		var h = $H(a);	
//		if(isChart){
//			url = ctxPath +"/merm/proOrderChart.jsp?"+ encodeURI(h.toQueryString());	
//		}else{
//			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
//		}
//		return url;
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
//	$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
//	$("overDate").value= getFormatDay(theYear+'1231','y/m/d');
	
	
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}
	
function searchyear(startDate,endDate){
	var startYear = getFormatDay(startDate,'y');
	var endYear = getFormatDay(endDate,'y');
	var ispass = true;
	
	
 	if(startDate == null || endDate == null){
		alert("请选择日期");
		ispass =  false;
		return ispass;
	}	
	
	if(resource_year!=startYear || resource_year!=endYear){
		alert("选定年份应该等于实际年份");
		ispass =  false;
	}
	
	if(startDate>endDate){
		alert("开始日期应该小于结束日期");
		ispass =  false;
	}
	return ispass;
}

