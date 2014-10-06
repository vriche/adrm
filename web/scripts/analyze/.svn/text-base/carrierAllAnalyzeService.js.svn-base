var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var orderdayinfo =new OrderDayInfo();
var user = new User();
var userName ;
var isPrint;
var mygrid;
var myprint =new MyPrint();

callOnLoad(init);	

function init(){
	get_cur_year();
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	userName =  _app_params.user.username;
	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	_make_org_select("orgId",120,"getResourceTree");	
	
	setCarrierTypePara(carrierType);
	setOrderdayinfoPara(orderdayinfo);
	setCarrierPara(carrier);
	setResourcePara(resource);
	setUserPara(user);
	carrier.obj.nodeLevel =1;
//	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	hiddenChartButton();
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

	initResourceTree(carrierType);
	//getCarrierTypeTree(carrierType); 
	
	buttonEventFill();
	
	initGrid();

	
 	resetHeigth();
 	
 	
 	$("query").hide();
 	
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
 	
 		
}


function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "载体,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月,合计";
	mygrid.setHeader(flds);
	mygrid.setInitWidthsP("9,9,9,9,9,9,9,9,9,9,9,9,9,9");
	mygrid.setColAlign("left,right,right,right,right,right,right,right,right,right,right,right,right,right,right")
	mygrid.setColTypes("tree,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);

    mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,int,int,int,int,int,int,int,int,int,int,int,int,int") ;
	mygrid.setSkin("modern2");
	
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
//	mygrid.attachFooter('合计:, , , , , , , , , , , , , , ',['text-align:center;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	
}


function hiddenChartButton(){
	if(isDisplayChartParam!=1){
		$("displayChar").hide();
	}else{
		$("displayChar").show();
	}
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
	var carrierTypeTreebox = $("carrierTypeTreebox");
    var gridbox = $("gridbox");

	carrierTypeTreebox.style.height = dialogcontent.offsetHeight*0.85+"px";	
	carrierTypeTreebox.style.width = carrierTypeTreebox.offsetWidth+ "px";	
	
//	$("adResCount").style.height = dialogcontent.offsetHeight*0.79+"px";
	gridbox.style.height = dialogcontent.offsetHeight*0.85 + "px";	
	
	
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
	obj.tableName   = "orderDayInfoList";
	obj.fillObjName = obj.className + "TBody";
	obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	obj.tBody 		= $(obj.fillObjName);
	 
	obj.pageInfo 	= "pageInfo_" + obj.className;
	obj.pageSize 	= "10";
	 
//	obj.page = new Page(obj.pageInfo,obj.pageSize);

}
function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
	//obj.selectName = obj.className+"Name";
}
function setResourcePara(obj){
	obj.className  = "resource";
 	obj.IdPrefix 	= obj.className + "Id";
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
	
//	carrierType.getTreeXMLFromMapByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);
}


function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "carrierAllYearAnalyze_report";
	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "carrierAllYearAnalyze_report";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "carrierAllYearAnalyze_report";
	 button_print();
}
function button_print(){
	$("isType").value = $("query").value;
	if($("query").value==1){
		var msg = "是否显示明细 ?";
		ans = confirm(msg);
		if(ans){
			var isDetail = 1;
		}
	}
	$("isDetail").value = isDetail;
	$("yearForm").value = $("resource_year").value;
	//用carrierIds传递resourceIds
	$("carrierIdsForm").value=carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	isPrint="true";
    $("isPrint").value = isPrint;
	$("userId").value  = $(user.selectName).value==0?null:$(user.selectName).value;
	//$("carrierNameForm").value = $("carrierName").value==0?null:$("carrierName").value;
	$("userName").value=userName;
	
	if($("carrierIdsForm").value == '') return false;
	

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

	
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/common_reports.jsp";
	reportForm.submit(); 	
}
function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	var cl_1 = (rows == 0)?"": grid.cells2(lastId,1).getValue()*1;
	var cl_2 = (rows == 0)?"": grid.cells2(lastId,2).getValue()*1;
	var cl_3 = (rows == 0)?"": grid.cells2(lastId,3).getValue()*1;
	var cl_4 = (rows == 0)?"": grid.cells2(lastId,4).getValue()*1;
	var cl_5 = (rows == 0)?"": grid.cells2(lastId,5).getValue()*1;
	var cl_6 = (rows == 0)?"":grid.cells2(lastId,6).getValue()*1;
	var cl_7 = (rows == 0)?"":grid.cells2(lastId,7).getValue()*1;
	var cl_8 = (rows == 0)?"":grid.cells2(lastId,8).getValue()*1;
	var cl_9 = (rows == 0)?"":grid.cells2(lastId,9).getValue()*1;
	var cl_10 = (rows == 0)?"":grid.cells2(lastId,10).getValue()*1;
	var cl_11 = (rows == 0)?"":grid.cells2(lastId,11).getValue()*1;
	var cl_12 = (rows == 0)?"":grid.cells2(lastId,12).getValue()*1;
	var cl_13 = (rows == 0)?"":grid.cells2(lastId,13).getValue()*1;

	var htm ="#rspan,"+ cl_1 +","+ cl_2 +","+ cl_3 +","+ cl_4 +","+ cl_5 +","+ cl_6+","+ cl_7+","+ cl_8+","+ cl_9+","+ cl_10+","+ cl_11+","+ cl_12+","+ cl_13;

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

function getDifferentTypes(){
	if($("query").value==1){
		mygrid.setColTypes("tree,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
	}else{
		mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
	}
}

function search(){
	//用carrierIds传递resourceIds
	var type = $("query").value;
	getDifferentTypes();
	
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);	
	

	
	
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	isPrint="false";
	orderdayinfo.year = $("resource_year").value;
	orderdayinfo.carrierIds = carrierIds;
	
	if(carrierIds.length == 0){
		 mygrid.clearAll();
		 return false;
	}
	
	var func = function(xml){
				//alert(xml);
			    mygrid.clearAll();
//			    			alert(xml)
				mygrid.loadXMLString(xml);
				Ext.getBody().unmask();
//				attachHeaderNew(mygrid);	

	}
    if(carrierIds != null){
    	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		orderdayinfo.getAllYearCarrierXML(orderdayinfo,userId,userName,type,isPrint,func);  

    }else{
    	alert("请选择载体后再进行查询!")
    }
}
function displayChar(){
	var year = $("resource_year").value;
	//用carrierIds传递resourceIds
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var carrierName = $("carrierName").value==0?null:$("carrierName").value;
	
//	parent.location.href ="carrierAllYearAnalyzeChart.html?year=" + year + "&" + carrierIds+"?"+userId;
	window.open("carrierAllYearAnalyzeChart.html?year=" + year + "&" + carrierIds+"?"+userId+"!"+userName,"dispalyChart","")
}

function getFusionChartObjs(){
	orderdayinfo.reset();
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);	
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var isType = $("query").value;
//	var carrierName = $("carrierName").value==0?null:$("carrierName").value;
	isPrint="false";
	orderdayinfo.year = $("resource_year").value;
	orderdayinfo.carrierIds = carrierIds;
	
	if(carrierIds.length == 0){
		 mygrid.clearAll();
		 return false;
	}
	
	function func(objs){
		fusionChartObjects = objs;
		alert(fusionChartObjects.length);
	}
		
		var a = {
			 	year: orderdayinfo.year,
                userId: userId,
                carrierIds: orderdayinfo.carrierIds.toString(),
                userName: userName,
                isPrint: isPrint,
                isType:isType
		};		
		
        var h = $H(a);

		var url = "carrierAllYearAnalyzeChart.html?"+h.toQueryString();
//		 alert(url);
		window.open(url);
}