var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var orderdayinfo =new OrderDayInfo();
var user = new User();
var userName ;
var isPrint;
var myDate = new MyDate();
var config_serviceDate;
var myprint =new MyPrint();
 var orderCategory = new OrderCategory();

callOnLoad(init);	

function init(){
	get_cur_year();

	
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	userName =  _app_params.user.username;	
	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	 _make_org_select("orgId",120,"getResourceTree");	
	 
	 config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}

	setCarrierTypePara(carrierType);
	setOrderdayinfoPara(orderdayinfo);
	setCarrierPara(carrier);
	setResourcePara(resource);
	setUserPara(user);
	carrier.obj.nodeLevel =1;
	carrier.obj.orgId =$("orgId").value;
	//carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);
//	hiddenChartButton();

	orderCategory.obj.orgId = $("orgId").value;
 	orderCategory.obj.version = $("resource_year").value;
  	var cmd = orderCategory.makeSubCategoryFromOrder("orderCategoryIdDiv","orderCategoryId",120,function(){});	
  	cmd.emptyText = '请选择订单类别...';
  	
  	
  		
	//getCarrierTypeTree(carrierType);
	initResourceTree(carrierType);
	buttonEventFill();
	getDate();
	initGrid();
	
 	resetHeigth();
 	
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
}
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
	var flds = "载体名称,投放金额,分配金额,投放时长";
	
	mygrid.setHeader(flds);


	mygrid.setInitWidthsP("25,25,25,25");


	mygrid.setColAlign("left,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);

    mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,int,int,int") ;
	mygrid.setSkin("modern2");
	
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
}
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("carrierTypeTreebox");
    var gridbox = $("gridbox");
	treebox.style.height = dialogcontent.offsetHeight*0.85+"px";	
		treebox.style.width = treebox.offsetWidth+ "px";
//	$("adResCount").style.height = dialogcontent.offsetHeight*0.79+"px";
	gridbox.style.height = dialogcontent.offsetHeight*0.85 + "px";	
	
} 

//function hiddenChartButton(){
//	if(isDisplayChartParam!=1){
//		$("displayChar").hide();
//	}else{
//		$("displayChar").show();
//	}
//}

function setCarrierTypePara(obj){
	obj.className  = "carrierType";
	obj.IdPrefix   = obj.className + "Id";
	obj.treebox	   = obj.className + "Treebox";
	obj.tree = new Tree(obj.treebox); 
}
function getCarrierTypeTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj.reset();
	obj.obj.parentId = 0;
	//分频道显示树
	if(channelModelParam!=1){
			obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
	}else{
			obj.getTreeXMLForChannel(carrier.IdPrefix,resource.IdPrefix,channelModelParam);
	}
	
	obj_tree.loadXMLString(obj.tree.treeXML);
}




function setOrderdayinfoPara(obj){
	obj.enableEdit	= true;
	obj.enableDel	= true;
	 
	obj.className = "orderdayinfo";
	obj.IdPrefix 	= obj.className + "Id";
	obj.tableName   = "orderDayInfoList";
	obj.fillObjName = obj.className + "TBody";
	obj.color1 		= "BACKGROUND-COLOR: white";
	obj.color2 		= "BACKGROUND-COLOR: #eee";
	obj.tBody 		= $(obj.fillObjName);
	 
	obj.pageInfo 	= "pageInfo_" + obj.className;
	obj.pageSize 	= "10000";
	 
	obj.page = new Page(obj.pageInfo,obj.pageSize);

}

function setResourcePara(obj){
	obj.className  = "resource";
 	obj.IdPrefix 	= obj.className + "Id";
}
function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
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

function buttonEventFill(){
	var btn_search=$("search");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick=search;

	
//	var Bt_displayChar = $("displayChar");
//	Bt_displayChar.setAttribute("href","javascript:void 0");
//	Bt_displayChar.onclick = getFusionChartObjs;	
//	
//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_print_export;	
	
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
	resource_year =  _app_params.serviceDate.year;
	$("resource_year").value = resource_year;
}


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
	
	getResourceTree();
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
	getResourceTree();
}

function getResourceTree(){
    var obj_tree = carrierType.tree.dhtmlTree;
	var getxml = function(strXML){ 
		obj_tree.deleteChildItems(0);	
		carrierType.tree.dhtmlTree.loadXMLString(strXML);
		Ext.getBody().unmask();
	};
	
//	alert(1)
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//	carrierType.reset();
	carrierType.obj.parentId = 0;
	carrierType.obj.nodeLevel = 999;
	carrierType.obj.orgId = $("orgId").value;
	
	carrierType.obj.memo = "3";
	carrierType.obj.enable = 0;
	carrierType.obj.fitterCarrier = 1;
	carrierType.obj.loginUser = userName;	
	
	carrierType.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);
	
//	carrierType.getTreeXMLFromMapByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);
}


function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "carrierScopeAnalyze_report";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "carrierScopeAnalyze_report";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "carrierScopeAnalyze_report";
	 button_print();
}
function button_print(){
	$("startForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endForm").value = getFormatDay($("overDate").value,'ymd');
	//用carrierIds传递resourceIds
	$("carrierIdsForm").value=carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	isPrint="true";
    $("isPrint").value = isPrint;
	$("userId").value  = $(user.selectName).value==0?null:$(user.selectName).value;
//	$("carrierNameForm").value = $("carrierName").value==0?null:$("carrierName").value;
	$("userName").value=userName;
	
	if($("carrierIdsForm").value == ''){
		 mygrid.clearAll();
		 return false;
	}
		
	$("orderCategoryIdForm").value=  Ext.getCmp('orderCategoryId').getValue();
	
	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
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
	var startDate = getFormatDay(startDate,'y');
	var endYear = getFormatDay(endDate,'y');
	var ispass = true;
	
	
 	if(startDate == null || endDate == null){
		alert("请选择日期");
		ispass =  false;
		return ispass;
	}	
	
	if(resource_year!=startDate || resource_year!=endYear){
		alert("选定年份应该等于实际年份");
		ispass =  false;
	}

	return ispass;
}	
function search(){
	//用carrierIds传递resourceIds
	resetHeigth();
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);//getSelectedItemId(carrier.IdPrefix);		
	

	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	//var carrierName = $("carrierName").value==0?null:$("carrierName").value;
	var startDate=getFormatDay($("beginDate").value,'ymd');
	var endDate=getFormatDay($("overDate").value,'ymd');
	isPrint="false";
	
	var isPass = searchyear(startDate,endDate);
	if(!isPass) return false;
	
	if(carrierIds==null){
		 mygrid.clearAll();
		 return false;
	}
	
	
	var orderCategoryId =  Ext.getCmp('orderCategoryId').getValue();
	
	var func = function(xml){

				mygrid.clearAll();
				mygrid.loadXMLString(xml);	
				Ext.getBody().unmask();
		 }
		 
//	isPrint="false";
	if(startDate != '' && endDate != ''){
		if(startDate > endDate){
			alert("开始日期不能大于结束日期");
			DWRUtil.removeAllRows(orderdayinfo.tBody);
			return false;
		}
		
	    if(carrierIds != null){
//			orderdayinfo.getCarrierByDate(orderdayinfo,userId,userName,isPrint);  
			Ext.getBody().mask('数据加载中……', 'x-mask-loading');
			orderdayinfo.getCarrierByDateXML(startDate,endDate,carrierIds,userId,userName,isPrint,orderCategoryId,func);
	    }else{
	        alert("请选择载体后进行查询");
	    }
	}else{
		alert("请选择日期后进行查询");
	}
}	
		
function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var carrierName = $("carrierName").value==0?null:$("carrierName").value;
//用carrierIds传递resourceIds
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	var orderCategoryId =  Ext.getCmp('orderCategoryId').getValue();
	
//	parent.location.href ="carrierScopAnalyzeChart.html?startDate=" + startDate + "&" + endDate +"$" + carrierIds+"?"+userId;
	window.open("carrierScopAnalyzeChart.html?startDate=" + startDate + "&" + endDate +"$" + carrierIds+"?"+userId+"!"+userName,"dispalyChart","")
}

function getFusionChartObjs(){
	orderdayinfo.reset();
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);//getSelectedItemId(carrier.IdPrefix);		

	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	//var carrierName = $("carrierName").value==0?null:$("carrierName").value;
	var startDate=getFormatDay($("beginDate").value,'ymd');
	var endDate=getFormatDay($("overDate").value,'ymd');
	isPrint="false";

	if(carrierIds==null){
		 mygrid.clearAll();
		 return false;
	}
	
	
	var orderCategoryId =  Ext.getCmp('orderCategoryId').getValue();
	
	function func(objs){
		fusionChartObjects = objs;
//		alert(fusionChartObjects.length);
	}
	

	
//startDate,endDate,carrierIds,userId,userName,isPrint
	if($("beginDate").value=="" || $("overDate").value=="" ){
		alert("请先选择日期");
	}else{
		
		var a = {
			 	startDate: startDate,
                endDate: endDate,
                userId: userId,
                carrierIds: carrierIds.toString(),
                userName: userName,
                orderCategoryId:orderCategoryId,
                isPrint: isPrint
		};		
		
        var h = $H(a);

		var url = "carrierScopAnalyzeChart.html?"+h.toQueryString();
//		 alert(url);
		window.open(url);
	}
}
