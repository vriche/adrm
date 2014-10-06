var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var orderdayinfo =new OrderDayInfo();
var orderDetail =new OrderDetail();
var user = new User();
var analyzeClass = new AnalyzeClass();
var customer = new Customer();
var customer2 = new Customer();
var matter = new Matter();
var myprint =new MyPrint();
var queryWindow;
	 	
var userName ;
var isPrint;

callOnLoad(init);	

function init(){
	resetHeigth();
	get_cur_year();
	channelModelParam = _app_params.sysParam.channelModelParam;
	userName =  _app_params.user.username;
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;

 	config_isDisplayStandPrice = _app_params.sysParam.isDisplayStandPrice;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
    config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
    config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
	
//	setCarrierTypePara(carrierType);
	setOrderdayinfoPara(orderdayinfo);
//	setCarrierPara(carrier);
//	setResourcePara(resource);
//	setUserPara(user);
	setAnalyzeClassPara(analyzeClass);
//	setCustomerPara(customer);
//	setCustomerPara2(customer2);
//	setMatterPara(matter);
//	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
	
	
//	carrier.obj.nodeLevel =1;
	//carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
	user.makeSelectAnalyze(user,"userOwner","",setUserSelected);
	
	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	
	_make_org_select("orgId",120,"");	
	
	//getCarrierTypeTree(carrierType);
//	initResourceTree(carrierType);
	
//	initMatterTree(matter);
	
	initMatter();
	
	initGrid();
	
	buttonEventFill();
 	
 	getDate();
 	
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
 	
    show_cut_win();	
}

function show_cut_win(){
	customer.obj.orgId = $("orgId").value;
	var params =[{accountName:'',accountBank:'',customerName:'',orgId:$("orgId").value},{orgId:$("orgId").value}];
	function setvalue(ids){$("customerName").value = ids;}
	customer.showWin('customerName',params,userName,true,setvalue);
}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	//var flds = "开始,结束,月份,规定";
//	var flds = "序号,品牌名称,投放金额,平账金额,欠款金额,投放时间";
	var flds = "品牌名称,投放金额,分配金额,欠款,时间";
	mygrid.setHeader(flds);
//	mygrid.setInitWidthsP("10,18,18,18,18,18");
	mygrid.setInitWidthsP("20,20,20,20,19");
	mygrid.setColAlign("left,right,right,right,right")
	mygrid.setColTypes("ed,ed,ed,ed,ed");
	
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
//	mygrid.enableRowsHover(true,'grid_hover')
//	mygrid.setOnRowSelectHandler(doOnRowSelected);
//	mygrid.enableDragAndDrop(false);
//  mygrid.lockRow(3,true);
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,int,int,int,int") ;
	mygrid.setSkin("modern2");
	mygrid.init();	 
	
	mygrid.attachFooter('合计:, , , , , ',['text-align:center;','text-align:left;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("carrierTypeTreebox");
    //var matteTreebox = $("matterTypeTreebox");
    
    var adResCount_div = $("adResCount");
        
//    var Btn_Search = $("search");
//    var v = Btn_Search.offsetHeight*4;
    //treebox.style.height = dialogcontent.offsetHeight*0.85+"px";	
    //matteTreebox.style.height = dialogcontent.offsetHeight*0.83+"px";
    
    adResCount_div.style.height = dialogcontent.offsetHeight*0.8+"px";
    //$("customer_name").style.width = treebox.style.width +"px";
    
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

function setCustomerPara2(obj){
	 obj.className  = "customer2";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 	= new Tree(obj.treebox);
}
function setMatterPara(obj){
	 obj.className  = "matter";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 	= new Tree(obj.treebox);
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
function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
	
//	closeCarrierTree();
} 
function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	if(oDiv.style.visibility == "hidden"){
		oDiv.style.visibility = "visible";
	}else{
		oDiv.style.visibility = "hidden";
	}
	
//	resetQueryWhere();
}
function buttonEventFill(){
	var btn_search=$("query");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick = queryResourceAdver;
	
	var btn_searche = $("btnSearch");
	btn_searche.onclick = displayDiv;
	
	var btn_searche_close = $("btnSearcheClose");
	btn_searche_close.onclick = closeDiv;	
	
	
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 

	
	var change_resource_year = $("resource_year");
	change_resource_year.onchange = rest_resource_tree;
	

	
//	var btn_searche3 = $("btnSearche3");
//	btn_searche3.onclick=displayDiv3;
	
//	var btn_searche_close3=$("btnSearcheClose3");
//	btn_searche_close3.onclick=closeDiv3;		
	
	

	
//	var query3 = $("query3");
//	query3.onclick= queryResourceAdver;
		
	
//	var query9 = $("matter_name");
//	query9.onkeypress= loadMatterTree;
	
	
}


function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  userName;
  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids +"&useCarrierAliname="+config_useCarrierAliname+"&orgId="+$("orgId").value;
  var cleanBtn ={text: '重置',handler: function(){document.getElementById('userCarrReliframe').contentWindow.refreshTreeCarriers();}};	
  var closeBtn ={text: '确定',handler: function(){removeWin();}};
  
        
 var win = new Ext.Window({
   title : '选择频道',
   //maximizable : true,
   // maximized : true,
   width : 400,
   height : 300,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [cleanBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userCarrReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  win.show(); 
  
     function removeWin(){
    	var ids = document.getElementById('userCarrReliframe').contentWindow.getCheckedCarriers();
    	if(ids!=null && ids.length>0){
			$("carrierName").value = ids.join(',');
		}else{
			$("carrierName").value ='';
		}
 
  		win.destroy();
   	} 
   win.on({'close': {fn: removeWin}});   
    
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
	
	
   
}





//function closeDiv3(ev){
//	var oDiv = $("theDivSearch3");	
//	oDiv.style.visibility = "hidden";
//} 
//function displayDiv3(ev){
//	var oDiv = $("theDivSearch3");	
//	oDiv.style.visibility = "visible";
//}



//function getBrandTree(){
//	var fnct = function(){
//		
//	}
//	$("matter_name").value ='';
//	
//	loadMatterTree();
//	displayDiv3();
//}


function resetText(ev){
	 $("customer_name").value = null;	
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


function initMatterTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
//    obj_tree.enableItemEditor(false);
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelectMatter);//set function to call on dbl click
	//loadMatterTree(null);
}


function getCustomerTree2(fnct){
	var obj_tree = customer2.tree.dhtmlTree;
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelectedTree);
	getCutTree(customer2,fnct);
}

function doOnSelect(itemId){
//	        if(itemId == "root") return false;
	        var isItemChecked = carrierType.tree.dhtmlTree.isItemChecked(itemId);
		carrierType.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
}

function doOnSelectMatter(itemId){
//	        if(itemId == "root") return false;
	        var isItemChecked = matter.tree.dhtmlTree.isItemChecked(itemId);
		matter.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
}




//function loadMatterTree(){
//	function getxml(treeXML){
//		if(matter.tree.dhtmlTree.getSubItems(0) == 'root'){
//			matter.tree.dhtmlTree.deleteChildItems(0);	
//		}
//		matter.tree.dhtmlTree.loadXMLString(treeXML);
//		//if(fnct) fnct();
//	} 
//
//
//    
//	matter.reset();
//	var userIds = new Array();
//	var name = $("matter_name").value;
//
//	var carrierName = $("carrierName").value;
//	var customerName = $("customerName").value;
//	
//	matter.obj.carrierIds = carrierName.split(',');
////	matter.obj.resourceIds = carrierName.split(',');
//	matter.obj.customerIds = customerName==''?null: customerName.split(',');
//	matter.obj.orgId = $("orgId").value;
//	matter.obj.loginUser = userName;
//	if(matter.obj.carrierIds == null) matter.obj.carrierIds = new Array();
//	if(matter.obj.resourceIds == null) matter.obj.resourceIds = new Array();
//	if(matter.obj.customerIds == null) matter.obj.customerIds = new Array();
//	if($("userOwner").value>0) userIds.push($("userOwner").value);
//	matter.obj.userIds = userIds;
//	if(name !='') matter.obj.name = name;
//	matter.obj.version = resource_year;
//
//	
//	if(matter.obj.customerIds != null){
//		matter.getMatterNameXML(matter.obj,getxml);
//	}else{
//		matter.tree.dhtmlTree.deleteChildItems(0);	
//	}
//	
//
//		  
//}

function initMatter(){

	matter.reset();
	var userIds = new Array();
//	var name = $("matter_name").value;
	var carrierName = $("carrierName").value;
	var customerName = $("customerName").value;
	

	matter.obj.customerIds = customerName==''?null: customerName.split(',');
	
	matter.obj.carrierIds = carrierName.split(',');
//	matter.obj.resourceIds = carrierName.split(',');
//	matter.obj.customerIds =  customerName.split(',');
	matter.obj.orgId = $("orgId").value;
	matter.obj.loginUser = userName;
	if(matter.obj.carrierIds == null) matter.obj.carrierIds = new Array();
	if(matter.obj.resourceIds == null) matter.obj.resourceIds = new Array();
	if(matter.obj.customerIds == null) matter.obj.customerIds = new Array();
	if($("userOwner").value>0) userIds.push($("userOwner").value);
	matter.obj.userIds = userIds;
//	if(name !='') matter.obj.name = name;
	matter.obj.version = resource_year;
	

//	if(matter.obj.customerIds != null){
		matter.getCommand("matterName","matterName_DIV",120);//	}
	

		  
}

function rest_resource_tree(){
	 resource_year = $("resource_year").value;
//	 reLoadTree(carrierType);
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = resource_year  + beginDate.substring(4,beginDate.length);
	 overDate = resource_year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;
	 
	 resetStore();
	 
	 mygrid.clearAll();  
}


 function resetStore(){
 	 var orgId = $("orgId").value;
 	 var version =  $("resource_year").value;


		var cmd3 =  Ext.getCmp('matterName');
		var store3 = cmd3.getStore();	
		store3.baseParams.dwrParams[0].orgId = orgId;
		store3.baseParams.dwrParams[0].version = version;
		store3.reload();	
		cmd3.clearValue(); 
	
	 
	if(queryWindow){
//		queryWindow.owner.orgId = $("orgId").value;
		queryWindow.tree.getLoader().params[1].orgId = orgId;
		queryWindow.tree.root.reload(); 
	}
 }
function reLoadTree(obj){
	obj.tree.dhtmlTree.deleteChildItems(0);
	getResourceTree(obj);
}

function getResourceTree(obj){
	var getxml = function(strXML){ 
		obj.tree.dhtmlTree.loadXMLString(strXML);
		//obj.tree.dhtmlTree.openAllItems(1);
		getCustomerTree2();
	} 
	obj.reset();
	obj.obj.parentId = 0;
	obj.getTreeXMLFromMapByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);
}

function getCutTree(obj,fnct){
	function getxml(treeXML){
		if(obj.tree.dhtmlTree.getSubItems(0) == 'root'){
			obj.tree.dhtmlTree.deleteChildItems(0);	
		}
		obj.tree.dhtmlTree.loadXMLString(treeXML);
		if(fnct) fnct();
	} 
	
	customer2.reset();
//	customer2.obj.resourceIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	customer2.obj.resourceIds =  $("carrierName").value.split(",");
	
	
	
	if(customer2.obj.resourceIds != null){
//		alert(customer2.obj.resourceIds);
		var userIds = new Array();
		if($("userOwner").value>0) userIds.push($("userOwner").value);
		customer2.obj.version = resource_year;
		customer2.obj.userIds = userIds;
		customer2.getTreeXML(getxml);	
	}else{
		customer2.tree.dhtmlTree.deleteChildItems(0);	
	}
}

function button_view_order(){ button_print("view");}	
function button_print_order(){ button_print("print");}
function button_print_export(){ button_print("export");}
function button_print(model){
	$("model").value = model;
	$("reportType").value = "brandAnalyze_report";
	$("startForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endForm").value = getFormatDay($("overDate").value,'ymd');
//	$("carrierIdsForm").value = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	$("carrierIdsForm").value = $("carrierName").value;
	
	if(customer2.tree){
		$("customerIdsForm").value = customer2.tree.getAllCheckedBranches(customer2.IdPrefix);
	}else{
		$("customerIdsForm").value ='';
	}
	
	$("matterNamesForm").value = Ext.getCmp('matterName').getCheckedDisplay();	
	$("userId").value  = $("userOwner").value;
	$("userName").value = userName;
	$("version").value = $("resource_year").value;
	

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
	$("beginDate").value = getFormatDay( _app_params.serviceDate.year +'0101','y/m/d');
	$("overDate").value= getFormatDay( _app_params.serviceDate.year +'1231','y/m/d');
}

function queryResourceAdver(){
	  analyzeClass.page.pageIndex = 1;
	  getResourceAdverTable();
//	  closeDiv3();
	  closeDiv();
}	


		
function getResourceAdverTable(){
	//用carrierIds传递resourceIds
	var startDate=getFormatDay($("beginDate").value,'ymd');
	var endDate=getFormatDay($("overDate").value,'ymd');
	var version = $("resource_year").value;

	isPrint="false";
	
	if(startDate !=null && endDate !=null){
		analyzeClass.obj.version = version;
		analyzeClass.obj.startDate = startDate;
		analyzeClass.obj.endDate = endDate;
		analyzeClass.obj.curUserName = userName;
		analyzeClass.obj.orderDetail = (new OrderDetail()).obj;
		analyzeClass.obj.orderDetail.matter = (new Matter()).obj;
        
    
        
//		analyzeClass.obj.orderDetail.matter.resourceIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
		var carrierName = $("carrierName").value;
		analyzeClass.obj.orderDetail.matter.resourceIds =  carrierName==''?null: $("carrierName").value.split(",");

//		analyzeClass.obj.orderDetail.matter.customerIds = customer2.tree.getAllCheckedBranches(customer2.IdPrefix);
//		analyzeClass.obj.orderDetail.matter.customerIds = $("customerName").value.split(",");
		var customerName = $("customerName").value;
		analyzeClass.obj.orderDetail.matter.customerIds = customerName==''?null: $("customerName").value.split(",");

//		analyzeClass.obj.orderDetail.matter.matterNames = matter.tree.getAllCheckedBranchesText();
		var matterNames =  Ext.getCmp('matterName').getCheckedDisplay();
		matterNames = matterNames ==''?new Array():matterNames.split(",");
//		console.log(matterNames);
//		alert(1)
		analyzeClass.obj.orderDetail.matter.matterNames =  matterNames;
	  
		if(analyzeClass.obj.orderDetail.matter.resourceIds == null) analyzeClass.obj.orderDetail.matter.resourceIds = new Array();
		if(analyzeClass.obj.orderDetail.matter.customerIds == null) analyzeClass.obj.orderDetail.matter.customerIds = new Array();
		
		var userIds = new Array();
		if($("userOwner").value>0) userIds.push($("userOwner").value);
		analyzeClass.obj.orderDetail.matter.userIds = userIds;
		
		//alert(analyzeClass.obj.order.matter.matterNames);
		//analyzeClass.obj.order.matter.matterNames = 

        
        function getFun(xml){
//			mygrid.clearAll();
					mygrid.loadXMLString(xml);
					attachHeaderNew(mygrid);
					Ext.getBody().unmask();
		        }
        
//	    if(analyzeClass.obj.orderDetail.matter.matterNames.length >0){
	    	mygrid.clearAll();  
	    	Ext.getBody().mask('数据加载中……', 'x-mask-loading');    
		   	analyzeClass.getBrandXML(getFun);  
//	    }else{
//	        alert("请选择时段后进行查询");
//	    }
	}else{
		alert("请选择日期后进行查询");
	}
}	

function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);

 var cl_1 = (rows == 0)?"": grid.cells(lastId,1).getValue();
	var cl_2 = (rows == 0)?"": grid.cells(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells(lastId,4).getValue();
	

	var htm ="#rspan*"+ cl_1 +"*"+ cl_2 +"*"+ cl_3+"*"+ cl_4;

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
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == analyzeClass.pageInfo){
		var page = new Page(analyzeClass.pageInfo,analyzeClass.pageSize);
		page.goNextPage(pageIndex);
		analyzeClass.page = page;
		getResourceAdverTable();
	}
	
}		

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
	var hidenColumName = ["id","customerCategoryId","helpCode","category.categoryName"];
	var allColumsTitle = [""];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		//$("customerId").value = getCellValue(tr,0);
		getSelectCustomerToTree(getCellValue(tr,0));
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

function getSelectCustomerToTree(id){
//	var id = $("customerId").value;
	if(customer2.tree.dhtmlTree.getAllLeafs().length ==0) return false;
	//var parentId = customer2.tree.getItemIdByIndex(0);
//	customer2.tree.dhtmlTree.closeAllItems(parentId);
//	customer2.tree.dhtmlTree.selectItem(customer.IdPrefix+id,true);
        customer2.tree.dhtmlTree.setCheck(customer2.IdPrefix+id,true);
	customer2.tree.dhtmlTree.focusItem(customer2.IdPrefix+id);
}

function doOnSelectedTree(itemId){
	if(itemId == 'root') return false;
	var isItemChecked = customer2.tree.dhtmlTree.isItemChecked(itemId);
	customer2.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
	
}