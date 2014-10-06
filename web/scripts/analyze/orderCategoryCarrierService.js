//实锟斤拷锟斤拷锟?
//var income = new Income();
var analyzeClass = new AnalyzeClass();
var customer = new Customer();
var category = new Category();
var orderDayInfo = new OrderDayInfo();
var user = new User();
var carrier = new Carrier();
var userName ;
var yearOrQuarter;
var order_year;
var config_serviceDate;
var incomePurpose = new IncomePurpose();
var myDate = new MyDate();
var myprint =new MyPrint();


callOnLoad(init);	
  
function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var treebox = $("categoryTreebox");    
    $("mainTable").style.height = dialogcontent.offsetHeight*0.6+"px";
    treebox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
    $("gridbox").style.height = dialogcontent.offsetHeight * 0.85 +"px";	
} 
  
function init(){ 
	
	
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;	
	userName =  _app_params.user.username;	
	
	  _make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	_make_org_select("orgId",120,"getCustomerCategoryTree");	
		
	get_cur_year();
	
//	setyearAnalyzePara(orderDayInfo);
	setAnalyzeClassPara(analyzeClass);
	setCustomerPara(customer);
	setCategoryPara(category);

	setUserPara(user);
	setPurposePara(incomePurpose);
	setCarrierPara(carrier);
	carrier.obj.nodeLevel =1;
	makeCarrierSelectItem();
//	hiddenChartButton();
	//carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);
     
     
    initCustomerTree(); 
	getCustomerCategoryTree(category);
	
 	buttonEventFill();
 	
// 	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
 	initGrid();
 	getDate();
 	
 	resetHeigth();
 	
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
 	 	
//	incomePurpose.makeOptionsCallBackFun(incomePurpose,fillFun);	
//
//	function fillFun(objs){
//		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);     
//	}

}



function getDate(){
	
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
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}


function sort_custom(a,b,order){ 
	var n= convertMonthCN2Num(a); 
	var m= convertMonthCN2Num(b); 
	if(order=="asc") return n>m?1:-1; else return n<m?1:-1; 
} 


function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "订单类别,刊例总价,投放金额,优惠金额,时间,折扣,刊例比例";
	mygrid.setHeader(flds);
//	var columnIds = "cuctomerName,toufangjine,daokuan,toufangshichang,qiankuan";
//	mygrid.setColumnIds(columnIds);
	mygrid.setInitWidthsP("16,14,14,14,14,14,14");
	mygrid.setColAlign("left,right,right,right,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("sort_custom,int,int,int,int,int,int") ;
	mygrid.setCustomSorting(sort_custom,0);
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
	mygrid.attachFooter('合计:, , , , , , ',['text-align:center;','text-align:left;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	
}

function get_cur_year(){
	resource_year =  _app_params.serviceDate.year;
	$("order_year").value = resource_year;
}

function makeCarrierSelectItem(){
	//根据是否分频道，取得频道下拉列表
	if(channelModelParam!=1){
		carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
	}else{
		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",setCarrierSelect);
	}
}
function setCarrierSelect(){
	var id  = $("carrierName").value;
	 	if(id > 0){
	 		$(carrier.selectName).value = id;
	 	}
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}

function setUserSelected(){
	 	var id  = $("userId").value;
	 	if(id > 0){
	 		$(user.selectName).value = id;
	 	}
}

function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userOwner"; 
}


function buttonEventFill(){
	var Btn_searchCustomerYear = $("searchCustomerYear");
	Btn_searchCustomerYear.onclick = showTable;	
	
	var btn_searche = $("btnSearche");
	btn_searche.onclick=displayDiv;
	
	var btn_searche_close=$("btnSearcheClose");
	btn_searche_close.onclick=closeDiv;
	
//	var Bt_displayChar = $("displayChar");
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
	
//	var Btn_customerName = $("customerName");
//	Btn_customerName.onclick = resetText;
//	Btn_customerName.onkeypress = getCustomerAutoCompltByName;
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


function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
}

function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
}
function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
} 



function button_view_order(){button_print('view');}	
function button_print_order(){button_print('print');}
function button_print_export(){button_print('export');}

function button_print(model){
	$("model").value = model;
//	$("type").value = $("query").value;
	$("reportType").value = "orderCategoryCarrier_report";
	$("customerIdsForm").value = category.tree.getAllCheckedBranches(customer.IdPrefix);
	$("yearForm").value = $("order_year").value;
	$("startDate").value = getFormatDay($("beginDate").value,'ymd');
	$("endDate").value = getFormatDay($("overDate").value,'ymd');
	$("userId").value  = $(user.selectName).value==0?null:$(user.selectName).value;
	$("carrierNameForm").value = $("carrierName").value==null?0:$("carrierName").value;
	$("userName").value=userName;
	$("channelModelParam").value = channelModelParam;
	var sortStr = mygrid.getSortingState();
	$("sortStr").value= sortStr[0]+","+sortStr[1];
//	$("putYear").value= $("isPutYear").checked == true?1:0;	
//	$("returnValue").value= $("isNotReturnValue").checked == true?1:0;
	
//	
//	var purpose = getCheckBoxValues("incomePur",1);
//	if(purpose == '') purpose.push(-1);
//	$("incomPurs").value= purpose.toString();
	
	if($("customerIdsForm").value=='') return false;
	
//	if(yearOrQuarter==undefined){
//		alert("请选择打印类型");
//		return false;
//	}
//	$("yearOrQuarterForm").value = yearOrQuarter;
//	alert($("customerIdsForm").value+"   "+$("yearForm").value );

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}

function setAnalyzeClassPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className = "analyzeClass";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setPurposePara(obj){
	 obj.className ="incomepurpose";
	 obj.checkBoxName = obj.className +"RN";
}
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
//	 obj.selectName =  "customerId";
//	 obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox); 
}
function setCategoryPara(obj){
	 obj.className ="category";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
	 
}

function initCustomerTree(obj){
	obj_tree = category.tree.dhtmlTree;	
	
//	obj_tree.enableCheckBoxes(true);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableDragAndDrop(false);
//	obj_tree.enableThreeStateCheckboxes(true);
	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	
	
//	obj_tree.setOnClickHandler(doOnSelectGetRes);
//	getCustomerTree();
}

//function getCustomerTree(){
//	var state = getRadioValue($(category.radioName));
//	customer.reset();
//	customer.obj.parentId = 0;
//	customer.obj.customerCategoryId = state;
//	function getxml(treeXML){
//		customer.tree.dhtmlTree.loadXMLString(treeXML);
//	} 
//    
//	customer.getTreeXML(customer,getxml);
//}

function getCustomerCategoryTree(){
	var OBJ = category;
	var obj_tree = OBJ.tree.dhtmlTree;

	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	OBJ.reset();
	OBJ.obj.orgId = $("orgId").value;
	
	function getxml(treeXML){
		obj_tree.deleteChildItems(0);	
		obj_tree.loadXMLString(treeXML);
		Ext.getBody().unmask();
	} 

	OBJ.getCategoryTreeXML(OBJ,customer.IdPrefix,getxml);
}

function doOnSelect(itemId){
	//if(itemId == "root") return false;
	
	var isItemChecked = category.tree.dhtmlTree.isItemChecked(itemId);
	category.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
}

function getTree(){
	var rootId = customer.tree.getItemIdByIndex(0);
	customer.tree.dhtmlTree.deleteItem(rootId);
	getCustomerTree();
}
function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	var cl_1 = (rows == 0)?"": grid.cells2(lastId,1).getValue()*1;
	var cl_2 = (rows == 0)?"": grid.cells2(lastId,2).getValue()*1;
	var cl_3 = (rows == 0)?"": grid.cells2(lastId,3).getValue()*1;
	var cl_4 = (rows == 0)?"": grid.cells2(lastId,4).getValue()*1;
	var cl_5 = (rows == 0)?"": grid.cells2(lastId,5).getValue()*1;

	var htm ="#rspan,"+ cl_1 +","+ cl_2 +","+ cl_3 +","+ cl_4 +","+ cl_5 +"";

	var h = htm.split(",");
	//alert(h.length);
	var z =  grid.ftr.rows[1];
	
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
	
	grid.deleteRow(lastId);
	
}
//显示查询结果
function showTable(){
	closeDiv();
    var year = $("order_year").value;
	var orgId = $("orgId").value;
    var customerIds = category.tree.getAllCheckedBranches(customer.IdPrefix);
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	
	var sortStr = mygrid.getSortingState();
	analyzeClass.reset();
	analyzeClass.obj.resourceMeno = sortStr[0]+","+sortStr[1];
//	orderDayInfo.obj.businessFirstName = $("isPutYear").checked == true?1:0;
//	orderDayInfo.obj.businessLastName = $("isNotReturnValue").checked == true?1:0;
	analyzeClass.obj.startDate=getFormatDay($("beginDate").value,'ymd');
	analyzeClass.obj.endDate=getFormatDay($("overDate").value,'ymd');
//	
//	var purpose = getCheckBoxValues("incomePur",1);
//	if(purpose == '') purpose.push(-1);
//	analyzeClass.obj.businessFullName = purpose.toString();
	
	if(customerIds=='') return false;
	if(analyzeClass.obj.startDate != '' && analyzeClass.obj.endDate != ''){
		if(analyzeClass.obj.startDate > analyzeClass.obj.endDate){
			alert("开始日期不能大于结束日期");
			DWRUtil.removeAllRows(analyzeClass.tBody);
			return false;
		}
		var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				attachHeaderNew(mygrid);
				Ext.getBody().unmask();
		}
		
    if(customerIds != null){
    	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		analyzeClass.getCustomerByYearXML(func,analyzeClass.obj,year,customerIds,userId,carrierName,channelModelParam,userName);  
    }else{
    	alert("请选择客户后进行查询！");
    }
	}
}
function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);

 var cl_1 = (rows == 0)?"": grid.cells(lastId,1).getValue();
	var cl_2 = (rows == 0)?"": grid.cells(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells(lastId,4).getValue();
		var cl_5 = (rows == 0)?"": grid.cells(lastId,5).getValue();

	var htm ="#rspan*"+ cl_1 +"*"+ cl_2 +"*"+ cl_3+"*"+ cl_4+"*"+ cl_5;

	var h = htm.split("*");
	//alert(h.length);
	var z =  grid.ftr.rows[1];
	
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
	
	grid.deleteRow(lastId);
	
}

//function getCustomerAutoComplt(){
//	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
//}
//
//function payCustomerAutoComplet(objs)
//{
//	var oText_customerId = $("customerName");
//	var oDiv_customerId = $("theDivCustomerName");
//	
//	var indexColumName_customerId = ["customerName"];
//	var allColumsName_customerId =["id","customerName"];
//	
//	var onDivMouseDown_customerId = function(ev){
//		var tr = getElementByEvent(ev);
//		
//		$("customerId").value = getCellValue(tr,0);
//		$("customerName").value = getCellValue(tr,1);
//		
//		oText_customerId.value = getCellValue(tr,1);
//		
//		
//
//		customer.tree.loadDataTreeArray1(customer.IdPrefix,getCellValue(tr,0));
//		showTable();
//	}
//	
//	var hidenColumName = ["id"];
//	
//	var onTextBlur = function(ev){
//		oDiv_customerId.style.visibility = "hidden";
//		
//		if(trim(oText_customerId.value) == "" ){
//			$("customerId").value = '0';
//			customer.tree.refreshTree();
//			
//    		DWRUtil.removeAllRows(analyzeClass.tBody);
//		}
//	}
//   new AutoComplete(objs,oText_customerId,oDiv_customerId,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerId,allColumsName_customerId);
//}
//	
function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var type = $("query").value;
    var year = $("order_year").value;
    var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
    var customerIds = category.tree.getAllCheckedBranches(customer.IdPrefix);
    if(customerIds=='') return false;
    
//    if(yearOrQuarter==undefined){
//    	alert("请选择显示类型！");
//    	return false;
//    }
//	parent.location.href ="yearAnalyzeChart.html?startDate=" + year + "&" + customerIds+"$" + carrierName+"?"+userId+"@"+yearOrQuarter+"*"+channelModelParam+"!"+userName;
	window.open("yearAnalyzeChart.html?startDate="+ startDate + "&" + endDate+"$" + year + "&" + customerIds+"$" + carrierName+"?"+userId+"@"+type+"*"+channelModelParam+"!"+userName,"dispalyChart","")
}

function getFusionChartObjs(){

	var year = $("order_year").value;
	var orgId = $("orgId").value;
    var customerIds = category.tree.getAllCheckedBranches(customer.IdPrefix);
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	
	var sortStr = mygrid.getSortingState();
	analyzeClass.reset();
	analyzeClass.obj.resourceMeno = sortStr[0]+","+sortStr[1];
	analyzeClass.obj.startDate=getFormatDay($("beginDate").value,'ymd');
	analyzeClass.obj.endDate=getFormatDay($("overDate").value,'ymd');
	
	if(customerIds=='') return false;
	
	function func(objs){
		fusionChartObjects = objs;
//		alert(fusionChartObjects.length);
	}
	

	
//analyzeClass.obj,year,customerIds,userId,carrierName,channelModelParam,userName
	if($("beginDate").value=="" || $("overDate").value=="" ){
		alert("请先选择日期");
	}else{
		
		var a = {
			 	year: year,
			 	startDate: analyzeClass.obj.startDate,
			 	endDate: analyzeClass.obj.endDate,
                sortStr: analyzeClass.obj.resourceMeno,
                userId: userId,
                customerIds: customerIds.toString(),
                userName: userName,
                carrierName: carrierName,
                orgId: orgId,
                channelModelParam: channelModelParam
                
		};		
		
        var h = $H(a);

		var url = "orderCategoryCarrierChart.html?"+h.toQueryString();
//		 alert(url);
		window.open(url);
	}
}

