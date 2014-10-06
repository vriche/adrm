var carrierType = new CarrierType();
var customerProduct = new CustomerProduct();
var resource = new Resource();
var user = new User();
var carrier =new  Carrier();
var userName ;
var isPrint;
var myDate = new MyDate();
var config_serviceDate;
var analyzeClass = new AnalyzeClass();
var myprint =new MyPrint();

callOnLoad(init);	

function init(){ 
	get_cur_year();

	channelModelParam = _app_params.sysParam.channelModelParam;
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	config_serviceDate =  _app_params.serviceDate.def;
	userName =  _app_params.user.username;	
	
	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	 _make_org_select("orgId",120,"rest_resource_tree");	
	 

	
	setCarrierTypePara(carrierType);
	setCustomerProduct(customerProduct);
	setAnalyzeClass(analyzeClass);
	setCarrierPara(carrier);
	setResourcePara(resource);
//	setUserPara(user);
	
 	resetHeigth();
	
	carrier.obj.nodeLevel =1;
//	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	makeCarrierSelectItem();
//	hiddenChartButton();
//	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	
	//getCarrierTypeTree(carrierType);
	initResourceTree(carrierType);
	
	
 	buttonEventFill();
 	getDate();
 	initGrid();
 		

 		
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2],80);
}


function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "类别名称,客户名称,投放金额,到款金额";
	mygrid.setHeader(flds);


	mygrid.setInitWidthsP("20,40,20,20");
	mygrid.setColAlign("left,left,right,right");
	mygrid.setColTypes("tree,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);

    mygrid.enableAlterCss("even","uneven"); 
//	mygrid.setColSorting("str,str,int") ;
	mygrid.setSkin("modern2");
			mygrid.attachFooter('合计:, , , ',['text-align:center;','text-align:left;','text-align:right;','text-align:right;']);
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
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

function setResourcePara(obj){
	obj.className  = "resource";
 	obj.IdPrefix 	= obj.className + "Id";
}
function setCarrierTypePara(obj){
	obj.className  = "carrierType";
	obj.IdPrefix   = obj.className + "Id";
	obj.treebox	   = obj.className + "Treebox";
	obj.tree = new Tree(obj.treebox); 
}

function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	obj.selectName = obj.className+"Name";
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

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("carrierTypeTreebox");
	treebox.style.height = dialogcontent.offsetHeight*0.83+"px";	
	$("adResCount").style.height = dialogcontent.offsetHeight*0.79+"px";
} 
function buttonEventFill(){
	var btn_search = $("search");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick = queryList;

//	var Bt_displayChar = $("displayChar");
//	Bt_displayChar.onclick = getFusionChartObjs;
//	
//		
//	var Btn_view_order = $("Btn_view_order");
//	Btn_view_order.onclick = button_view_order;
//
//	var Btn_print_order = $("Btn_print_order");
//	Btn_print_order.onclick = button_print_order;	
//	
//	var Btn_export_order = $("Btn_export_order");
//	Btn_export_order.onclick = button_export_order;	
	
	
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
		button_export_order();
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
function doonclick(a1,a2){
	var state = this.isItemChecked(a1);
	state = state == 0?false:true;
	this.setCheck(a1,!state);
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
//	} 
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
	carrierType.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);
	
//	carrierType.getTreeXMLFromMapByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);
}

function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "areaCustomerAnalyze_report";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "areaCustomerAnalyze_report";
	 button_print();
}
function button_export_order(){
	 $("model").value = "export";
	 $("reportType").value = "areaCustomerAnalyze_report";
	 button_print();
}
function button_print(){
//	var msg = "是否显示明细 ?";
//		ans = confirm(msg);
//		if(ans){
//			var isDetail = 1;
//		}

		
		Ext.MessageBox.confirm('系统提示', '是否显示明细？', function(btn) {

				$("isDetail").value = (btn == 'yes')?1:0;
				$("startDate").value = getFormatDay($("beginDate").value,'ymd');
				$("endDate").value = getFormatDay($("overDate").value,'ymd');
				$("yearForm").value = $("resource_year").value;
				isPrint="true";
			    $("isPrint").value = isPrint;
			//	$("userId").value  = $(user.selectName).value==0?null:$(user.selectName).value;
				$("userId").value  = null;
				//$("carrierNameForm").value = $("carrierName").value==null?0:$("carrierName").value;
				$("userName").value=userName;
				$("channelModelForm").value = 1;
				//用carrierIds传递resourceIds
				var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
				
				if(carrierIds.length == 0){
					 return false;
				}
				
				if(carrierIds==null){
					alert("请选择资源！")
				}else{
						$("carrierIdsForm").value=carrierIds;
						var tarForm =  $("tarForm");
						var reportForm = $("ReportForm");
					
						
						reportForm.target = tarForm;
						reportForm.action="reports/jsp/common_reports.jsp";
						reportForm.submit(); 
				}	
              
              
              
//              return false; 	
		 });		
		
		


}

function setCustomerProduct(obj){
	 obj.className ="customerProduct";
	 obj.IdPrefix = obj.className + "Id";
	 obj.fillObjName = "customerProductBody";
	 obj.color1 		= "BACKGROUND-COLOR: white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageSize 	= "10000";
	 obj.pageInfo 	= "pageInfocustomerProduct";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function setAnalyzeClass(obj){
	 obj.className ="analyzeClass";
	 obj.IdPrefix = obj.className + "Id";
	 obj.fillObjName = "analyzeClassBody";
	 obj.color1 		= "BACKGROUND-COLOR: white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageSize 	= "10000";
	 obj.pageInfo 	= "pageInfoanalyzeClass";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
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
	
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}

function searchyear(beginDate,endDate){
	var beginYear = getFormatDay(beginDate,'y');
	var endYear = getFormatDay(endDate,'y');
	var ispass = true;
	
	
 	if(beginDate == null || endDate == null){
		alert("请选择日期");
		ispass =  false;
		return ispass;
	}	
	
	if(resource_year!=beginYear || resource_year!=endYear){
		alert("选定年份应该等于实际年份");
		ispass =  false;
	}

	return ispass;
}
function queryList(){
	resetHeigth();
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var userId  = null;
	//用carrierIds传递resourceIds
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	
	var isPass = searchyear(beginDate,endDate);
	if(!isPass) return false;

	isPrint="false";
	if(beginDate != '' && endDate != ''){
		if(beginDate > endDate){
			alert("开始日期不能大于结束日期");
			DWRUtil.removeAllRows(analyzeClass.tBody);
			return false;
		}
		var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				attachHeaderNew(mygrid);
				mygrid.setSizes();	
				Ext.getBody().unmask();
		}
		
		if(carrierIds==null){
		 	alert("请选择载体后进行查询！")
		}else{
			Ext.getBody().mask('数据加载中……', 'x-mask-loading');
			analyzeClass.getAreaCustomerByCarrierTypeXML(carrierIds,1,beginDate,endDate,userId,userName,isPrint,func);
		}
		
	}else{
		alert("请选择日期");
		DWRUtil.removeAllRows(analyzeClass.tBody);
	}
}

function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	


	var cl_2 = (rows == 0)?"": grid.cells(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells(lastId,3).getValue();


	var htm ="#rspan*#rspan*"+ cl_2 +"*"+ cl_3;

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



function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var userId =   null;
	//var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	//用carrierIds传递resourceIds
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	
	if(carrierIds.length == 0){
		 DWRUtil.removeAllRows(analyzeClass.tBody);
		 return false;
	}
	
	if(carrierIds==null){
		alert("请选择资源！")
	}else{
//		parent.location.href ="customerProductRelChart.html?startDate=" + startDate + "&" + endDate +"$"+userId+"*"+channelModelParam+"?"+carrierIds+"!"+userName;
		window.open("orderCategoryCustomerChart.html?startDate=" + startDate + "&" + endDate +"$"+userId+"*"+channelModelParam+"?"+carrierIds+"!"+userName,"dispalyChart","")
	}
	
}
function getFusionChartObjs(){
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var userId =   null;
	//用carrierIds传递resourceIds
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	
	if(carrierIds.length == 0){
		 return false;
	}
	isPrint="false";
	
	function func(objs){
		fusionChartObjects = objs;
		alert(fusionChartObjects.length);
	}
	

	
//carrierIds,channelModelParam,beginDate,endDate,userId,userName,isPrint
	if($("beginDate").value=="" || $("overDate").value=="" ){
		alert("请先选择日期");
	}else{
		
		var a = {
			 	beginDate: beginDate,
			 	endDate: endDate,
                userId: userId,
                carrierIds: carrierIds.toString(),
                userName: userName,
                isPrint: isPrint,
                channelModelParam: 1
                
		};		
		
        var h = $H(a);

		var url = "areaCustomerChart.html?"+h.toQueryString();
//		 alert(url);
		window.open(url);
	}
}