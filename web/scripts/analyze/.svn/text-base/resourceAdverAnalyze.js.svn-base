var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var orderdayinfo =new OrderDayInfo();
var user = new User();
var analyzeClass = new AnalyzeClass();
var customer = new Customer();
var myprint =new MyPrint();

var userName ;
var isPrint;

callOnLoad(init);	

function init(){
	
	get_cur_year();
	channelModelParam = _app_params.sysParam.channelModelParam;
	userName =  _app_params.user.username;
	
 	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);		
	_make_org_select("orgId",120,"resetCustomerStore");	
	
	setCarrierTypePara(carrierType);
	setOrderdayinfoPara(orderdayinfo);
	setCarrierPara(carrier);
	setResourcePara(resource);
	setUserPara(user);
	setAnalyzeClassPara(analyzeClass);
	setCustomerPara(customer);
//	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
	
	
	
	var callBackFun = function(){};
 	var cmd = customer.getCustomerRemote("theDivCustomerName","customer_name",130,callBackFun);
// 	cmd.on("select",getIncomeDetailList,this);	
 	
	
	
	carrier.obj.nodeLevel =1;
	//carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	
	//getCarrierTypeTree(carrierType);
	initResourceTree(carrierType);
	initGrid();
	buttonEventFill();
 	resetHeigth();
 	getDate();
 	
 	 this.myprint.buildButtons(this,"printReportDiv",[0,1,2],80);
 	 
 
 	 this.myprint.getWeekCheckBox("weekDiv","weekCheckBox","星期",110,"");
 	 	
}




 function resetCustomerStore(){
 	
	var orgId =  $("orgId").value;
	var version = $("resource_year").value;

	var cmd4 =  Ext.getCmp('customer_name');
	var store4 = cmd4.getStore();	
	if(store4.baseParams.dwrParams){
		store4.baseParams.dwrParams.orgId = orgId;
		store4.baseParams.dwrParams.version = version; 
		store4.reload();
		if(cmd4.mode == 'local'){
			store4.clearValue(); 
		}else{
			cmd4.setValue('');
		}
			
	}	
	
	getResourceTree();
	
}


function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	//var flds = "开始,结束,月份,规定";
	var flds = "单号,段位,联系,类,客户,广告名,版本,长,磁带,开始,结束,次,应付,归属,状态";
	mygrid.setHeader(flds);
	mygrid.setInitWidthsP("6,6,7,5,9,9,10,5,7,7,7,4,6,6,6");
	mygrid.setColAlign("left,left,center,right")
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
//	mygrid.enableRowsHover(true,'grid_hover')
//	mygrid.setOnRowSelectHandler(doOnRowSelected);
//	mygrid.enableDragAndDrop(false);
//  mygrid.lockRow(3,true);

	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setSkin("modern2");
	mygrid.init();	 
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("carrierTypeTreebox");
    var adResCount_div = $("adResCount");
    var gridbox = $("gridbox");     
    var Btn_Search = $("search");
    var v = Btn_Search.offsetHeight*4;
    treebox.style.height = dialogcontent.offsetHeight*0.85+"px";	
    gridbox.style.height = dialogcontent.offsetHeight*0.85 + "px";	
//    adResCount_div.style.height = dialogcontent.offsetHeight*0.82+"px";
    
    
} 
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
	//obj.page = new Page(obj.pageInfo,obj.pageSize);

}
function setAnalyzeClassPara(obj){
	obj.className = "analyzeClass";
	obj.IdPrefix 	= obj.className + "Id";
	obj.pageInfo 	= "pageInfoAnalyzeClass";
	obj.pageSize = 18;
	obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
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
	btn_search.onclick = queryResourceAdver;


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
	
//	var Btn_customerName = $("customer_name");
//	Btn_customerName.onkeypress= getCustomerAutoCompltByName;
//	Btn_customerName.onclick = resetText;
}

function resetText(ev){
//	 $("customer_name").value = null;
	  Ext.getCmp("customer_name").setValue('');

	
}


function get_cur_year(){
	resource_year =  _app_params.serviceDate.year;
	$("resource_year").value = resource_year;
}

function initResourceTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
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


//function button_view_order(){ button_print("view");}	
//function button_print_order(){ button_print("print");}
//function button_print_export(){ button_print("export");}


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
	$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
	$("overDate").value= getFormatDay(theYear+'1231','y/m/d');
}

function queryResourceAdver(){
	  analyzeClass.page.pageIndex = 1;
	  getResourceAdverTable();
}	




function printReport(model){
	$("model").value = model;
	$("reportType").value = "resourceAdverAnalyze_report";
//	var customerName =$("customer_name").value;
	var customerName = Ext.getCmp("customer_name").getRawValue(); 
	customerName = customerName==''?null:customerName;
	var resourceIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	if(!resourceIds){ return false; }
	
	$("startForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endForm").value = getFormatDay($("overDate").value,'ymd');
	$("carrierIdsForm").value = resourceIds;
	
	$("customerNameForm").value = customerName;
	$("userId").value  = $(user.selectName).value;
	$("userName").value = userName;
	$("version").value = $("resource_year").value;
	$("weekStrForm").value = Ext.getCmp('weekCheckBox').getCheckedValue();;
	

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}
		
function getResourceAdverTable(){
	

	//用carrierIds传递resourceIds
	var resourceIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);//getSelectedItemId(carrier.IdPrefix);		
	var userId = $(user.selectName).value;
	//var carrierName = $("carrierName").value==0?null:$("carrierName").value;
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var customerName = Ext.getCmp("customer_name").getRawValue(); 
	customerName = customerName==''?null:customerName;
	
	if(!resourceIds){
		mygrid.clearAll();     
		return false; 
	}
	
	

	
	isPrint="false";
	
	if(startDate !=null && endDate !=null){
		
		var weekStr = Ext.getCmp('weekCheckBox').getCheckedValue();
		
		analyzeClass.obj.startDate = startDate;
		analyzeClass.obj.endDate = endDate;
		analyzeClass.obj.resourceIds = resourceIds;
		analyzeClass.obj.curUserName = userName;
		analyzeClass.obj.weekStr = weekStr;

		analyzeClass.obj.order = new Order();
		analyzeClass.obj.customer = new Customer();
		
		analyzeClass.obj.order.userId = userId;
		analyzeClass.obj.customer.customerName = customerName;
		
        
		function getFun(xml){
//			mygrid.clearAll();
				mygrid.loadXMLString(xml);
				Ext.getBody().unmask();
			//alert(mygrid.globalActiveDHTMLGridObject);
			//mygrid.appendChild($("pageInfoAnalyzeClass"));
        }
        
        
	  if(resourceIds.length >0){
	    	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	    	mygrid.clearAll();      
				analyzeClass.getResourceAdverXML(getFun);  
		}else{
	    alert("请选择时段后进行查询");
	    }
	}else{
			alert("请选择日期后进行查询");
	}
}	
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == analyzeClass.pageInfo){
		var page = new Page(analyzeClass.pageInfo,analyzeClass.pageSize);
		page.goNextPage(pageIndex);
		analyzeClass.page = page;
		getResourceAdverTable();
	}
	
}		
//function displayChar(){
//	var startDate = getFormatDay($("beginDate").value,'ymd');
//	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
////	var carrierName = $("carrierName").value==0?null:$("carrierName").value;
////用carrierIds传递resourceIds
//	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
//	
////	parent.location.href ="carrierScopAnalyzeChart.html?startDate=" + startDate + "&" + endDate +"$" + carrierIds+"?"+userId;
//	window.open("carrierScopAnalyzeChart.html?startDate=" + startDate + "&" + endDate +"$" + carrierIds+"?"+userId+"!"+userName,"dispalyChart","")
//}
function getCustomerAutoCompltByName(ev){
	var customerName =$("customer_name").value;
	customer.obj.customerName = customerName;

	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
		$("customer_name").value="";
	}
}


function payCustomerAutoComplet(objs)
{
	var oText = $("customer_name");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
	var hidenColumName = ["id","customerCategoryId","helpCode"];
	var allColumsTitle = ["客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		//$("customerId").value = getCellValue(tr,0);
		oText.value = getCellValue(tr,2);

	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			//$("customerId").value = '';
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);

}