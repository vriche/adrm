var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var customerProduct = new CustomerProduct();
var customerCategory = new Category();
var user = new User();
//var customer = new Customer();
var resource_year;
var config_serviceDate;
var fusionCharts = new Charts();
var fusionChartObjects;
var contPath;
var chartWidth = 0;
var chartHeight = 0;
var mygrid;

callOnLoad(init);	

function init(){
	
	tvNameParam =  _app_params.sysParam.tvNameParam;
	ctxPath =  _app_params.ctxPath;	 
	
	$("carrier_displayMode").hide();
	
	initGrid();
	
	var srcStr = window.location.href;
		winW = getParamFromUrl(srcStr,"winW");
		winH = getParamFromUrl(srcStr,"winH");
		dialogcontentHeight = getParamFromUrl(srcStr,"dialogcontentHeight");
		resource_year = getParamFromUrl(srcStr,"resource_year");
		if(winW == null) winW = 1200;
		if(winH == null) winH = 600;
		
	

	config_serviceDate =_app_params.serviceDate.def;
//	resource_year = _app_params.serviceDate.year;
    channelModelParam = _app_params.sysParam.channelModelParam;
//	_make_adrm_sys_year_select("resource_year",resource_year);
    _make_org_select("orgId",120,"getResourceTree");
	setCarrierTypePara(carrierType);
	setCarrierPara(carrier);
	setResourcePara(resource);
	initResourceTree(carrierType);
//	initResourceTree();

//	var userCmd = user.getUsersByOrgLimit("extUserIdDiv","userId",145,setCurUserId,null);
//	userCmd.on('select', function(e,r,index) {getCheckedResByUser(e,r,index);});
	
	var customerCmd = customerCategory.getCmd("extUserIdDiv","userId",145,null,null);
	customerCmd.on('select', function(e,r,index) {getCheckedResByUser(e,r,index);});
	

	
//	userCmd.conf.select = function(e,r,index) {alert(index);};

	buttonEventFill();
 	resetHeigth();
	
	contPath = $F("contPath");
	
	

}

//创建客户类别
function initCusCat(){
	
	function fillFun(objs){
		makeOptionsHtml(objs,"select","regCustomerCategoryName","categoryName","id","","",[1]);
	}	
	customerCategory.makeOptionsCallBackFun(customerCategory,fillFun);	

}


function setTreeCheckedByUser(e,r,index){
	var year  = resource_year
	var uid = r.get('id');
	resource.getResourceIdsByYearUser(year,uid,loadUserResRel);

	function loadUserResRel(ids){
		var IdPrefix = "resourceId";
		carrierType.tree.loadDataTreeArray1(IdPrefix,ids);	
	}
}
function getCheckedResByUser(e,r,index){
	var year  = resource_year
	var cid = r.get('id');
	resource.getResourceIdsByYearUser(year,cid,loadTable);
	function loadTable(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);	
	}
}

function getCheckedResByUser2(year,uid){
	resource.getResourceIdsByYearUser(year,uid,loadTable);
	function loadTable(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);	
	}
}


function save(){
	var IdPrefix = "resourceId";
	var year  = resource_year
	var uid =  Ext.getCmp('userId').getValue();	
	var	resourceIds =  carrierType.tree.getAllCheckedBranches(IdPrefix);
	var rate  = $("rate").value;
	
	if(resourceIds == null){
		alert('请选择段位!');
	}
	
	var ids = resourceIds.join(",");
	
	if(uid==''){
		alert('请选择用户!');
	}
	
	var isd = isDigit(rate);
    if(!isd){  
    	$("rate").value ="";
    	alert('必须数字!');
    	return false;
    }
    

    
	
	
	function callBackFun(){
		getCheckedResByUser2(year,uid)
	}

	if(rate >0 && resourceIds.length>0 && uid>0){
		resource.saveResourceIdsYearUser(ids,uid,rate,callBackFun);
	}
	
}
function remove(){
	var year  = resource_year
	var uid =  Ext.getCmp('userId').getValue();	
	var ids = new Array();
	for(var i=0; i< mygrid.getRowsNum();i++){
		var v = mygrid.cells2(i,0).getValue();
		if(v >0){
			ids.push(mygrid.getRowId(i));
		}
	}
	
	
	function callBackFun(){
		getCheckedResByUser2(year,uid)
	}
	
	if(ids.length>0 ){
		resource.removeResourceIdsYearUser(ids.join(","),callBackFun);
	}
	
}


function setCurUserId(){
	var id = getParamFromUrl(srcStr,"parentUserId");
	var cmd = Ext.getCmp("userId");
	cmd.setValue(id);  
}




//*****************************************************

 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function get_cur_year(){
	config_serviceDate = $("config_serviceDate").value
	resource_year = getDayPar(config_serviceDate,'y');
}

//function resetHeigth(){ 
//    var adResCount = $("adResCount");
//    var carrierTypeTreebox = $("carrierTypeTreebox");
//    var gridbox = $("gridbox");
//    
//    adResCount.style.height = winH*0.82 +"px";	
//    carrierTypeTreebox.style.height = winH*0.82 +"px";	
//    gridbox.style.height = winH * 0.85 +"px";		
//    chartWidth = gridbox.offsetWidth;
//	chartHeight = gridbox.offsetHeight;
//} 


function resetHeigth(){

    var gridbox = $("gridbox");
    if(mygrid){
    	gridbox.style.height = dialogcontentHeight * 0.86 +"px";	
    	mygrid.setSizes();
    }
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
	
	var func = function(treeXml){
		obj_tree.loadXMLString(treeXml);
	}
	//分频道显示树
	if(channelModelParam!=1){
			obj.getTreeXMLFromMap(carrier.IdPrefix,resource.IdPrefix,func);
	}else{
			obj.getTreeXMLForChannel(carrier.IdPrefix,resource.IdPrefix,channelModelParam);
			obj_tree.loadXMLString(obj.tree.treeXML);
	}
	
	
////	obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
//	obj.getTreeXMLFromMap(carrier.IdPrefix,resource.IdPrefix,func);
}

function initResourceTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	

	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	
	//obj_tree.setDragHandler(doOnBeforeDrop);
	getResourceTree(obj);
}

//function initResourceTree(){
//	var obj_tree = carrierType.tree.dhtmlTree;
//	obj_tree.dadmode=2;
//	obj_tree.enableCheckBoxes(false);
//	obj_tree.enableThreeStateCheckboxes(true);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableDragAndDrop(true);
//	getResourceTree(carrierType);
//}
function getResourceTree(obj){
	var getxml = function(strXML){ 
		obj.tree.dhtmlTree.loadXMLString(strXML);
	} 
	obj.reset();
	obj.obj.parentId = 0;
	obj.obj.orgId = $("orgId").value;
	obj.obj.memo = $("carrier_displayMode").value;
	obj.getTreeXMLFromMapByYear2(carrier.IdPrefix,resource.IdPrefix,resource_year,true,getxml);
}

function doOnSelect(itemId){
	        if(itemId == "root") return false;
	        var isItemChecked = carrierType.tree.dhtmlTree.isItemChecked(itemId);
		carrierType.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);	
}


function setCustomerProductPara(obj){
	obj.enableEdit	= true;
	obj.enableDel	= true;
	 
	obj.className = "customerProduct";
	obj.IdPrefix 	= obj.className + "Id";
	obj.tableName   = obj.className + "List";
//	obj.fillObjName = obj.className + "TBody";
	obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
//	obj.tBody 		= $(obj.fillObjName);
	 
	obj.pageInfo 	= "pageInfo_" + obj.className;
	obj.pageSize 	= "20";
	 
	obj.page = new Page(obj.pageInfo,obj.pageSize);

}
function setCarrierPara(obj){
	obj.className  = "carrier";
	obj.IdPrefix 	= obj.className + "Id";
}
function setResourcePara(obj){
	obj.className  = "resource";
 	obj.IdPrefix 	= obj.className + "Id";
}

function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName =  "customerId";
	// obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox); 
} 



function buttonEventFill(){
	
//	var change_resource_year = $("resource_year");
//	change_resource_year.onchange = rest_resource_tree;
	
	var carrier_displayMode = $("carrier_displayMode");
	carrier_displayMode.onchange = rest_resource_tree;
	
	
	var btn_save = $("save");
	btn_save.onclick = save;
	
	var btn_remove = $("remove");
	btn_remove.onclick = remove;
	
	var btn_print = $("print");
	btn_print.onclick = print;
	
//	var btn_search=$("searchRes");
//	btn_search.onclick=getFusionChartObjects;
	
//	var change_resource_year = $("searchDate");
//	change_resource_year.onchange = rest_resource_tree;
}

//<a href="General/DisplayReport.jsp?report=resourceUseRate4.grf&amp;data=/data/xmlUser2.jsp?ids=1548,1626" target="_blank">
function print(){
	var reportPath = ctxPath+"grid_report/";
	var IdPrefix = "resourceId";
	var	resourceIds =  carrierType.tree.getAllCheckedBranches(IdPrefix);
	if(resourceIds == null||resourceIds.length<0){
		alert("请选择段位!");
	}
	var ids = resourceIds.join(",");
	var printTarForm =  $("form2");
	var src = reportPath+"General/DisplayReport.jsp?report=resourceUseRate6.grf&amp;data=/data/xmlUser2.jsp?ids="+ids;
//	printTarForm.action = reportPath+"printTarForm.jsp?ids="+ids;
	printTarForm.action = reportPath+"printTarForm.jsp";
//	printTarForm.action = src;
	printTarForm.url.value = src;
	printTarForm.target = "_blank";
	printTarForm.submit();
	
}

function rest_resource_tree(){
	 var searchDate = resource_year;
	 if(resource_year==searchDate) return false;
	 resource_year = searchDate;
	 reLoadTree(carrierType);
}	

function reLoadTree(obj){
	obj.tree.dhtmlTree.deleteChildItems(0);
	getResourceTree(obj);
}


function selectCheckBoxAll(){
	var allValue = $("incPullAllSelect").checked;
	var rows = mygrid.getRowsNum();
	for(var i=0; i< rows;i++){
		mygrid.cells2(i,0).setValue(allValue);
	}	
	

}


function initGrid(){ 
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(ctxPath+"image/grid/");
	var flds = "<center><input type='checkBox' id='incPullAllSelect' value='0' onclick= 'javascript:selectCheckBoxAll(1)'></center>,频道一级,频道一级,段位编码,段位描述,使用比率"
	var columnIds = "start1,start,end,brotime1,brotime2,brotime3";
	mygrid.setColumnIds(columnIds);
	mygrid.setHeader(flds);
	mygrid.setInitWidthsP("5,15,20,20,20,20");
	mygrid.setColAlign("centercenter,center,center,center,center");
	mygrid.setColTypes("ch,ed,ed,ed,ed,ed");
	mygrid.selMultiRows = true;
//	mygrid.enableMathEditing(true); 
	mygrid.enableAlterCss("even","uneven");
	mygrid.setOnRowSelectHandler(onRowSelected,true);
//	mygrid.setOnEditCellHandler(doOnCellEdit);
	mygrid.init();	
//	mygrid.setSkin("modern2");
	mygrid.setSizes();
}


function onRowSelected(id,cellInd){
		var cell = mygrid.cells(id,0);
		var v = cell.getValue()==0?1:0;
		cell.setValue(v);	
		return v;
}
//function getResourceTree(){
//	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
//	var obj_tree = carrierType.tree.dhtmlTree;
//	var getxml = function(strXML){
//		obj_tree.deleteChildItems(0);	
//		carrierType.tree.dhtmlTree.loadXMLString(strXML);
//		Ext.getBody().unmask();
//	}
//	carrierType.reset();
//	carrierType.obj.parentId = 0;
//	carrierType.obj.nodeLevel = 0;
//	carrierType.obj.orgId = $("orgId").value;
//	carrierType.obj.memo = $("carrier_displayMode").value;
//	carrierType.tree.dhtmlTree.enableDragAndDrop(false);
//	carrierType.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);		
//}       

