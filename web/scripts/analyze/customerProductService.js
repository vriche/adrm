var carrierType = new CarrierType();
var customerProduct = new CustomerProduct();
var resource = new Resource();
var user = new User();
var carrier =new  Carrier();
var userName ;
var loginUserId;
var isPrint;
var myDate = new MyDate();
var config_serviceDate;
var myprint =new MyPrint();

callOnLoad(init);	

function init(){ 
	
	get_cur_year();
	ctxPath = _app_params.ctxPath;	
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;	
	loginUser =  _app_params.user.username;
	loginUserId =  _app_params.user.id;
	
	_make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	 _make_org_select("orgId",120,"resetStore");	
	  
	config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
//	if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	
	setCarrierTypePara(carrierType);
	setCustomerProduct(customerProduct);
	setCarrierPara(carrier);
	setResourcePara(resource);
	setUserPara(user);
	carrier.obj.nodeLevel =1;
//	carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	makeCarrierSelectItem();
//	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);
//	initUserCmd();
//	hiddenChartButton();

	
	//getCarrierTypeTree(carrierType);
	initResourceTree(carrierType);
 	buttonEventFill();
 	getDate();
 	initGrid();
 	
 	resetHeigth();
 	
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80); 
}

function resetStore(){
	
//		var cmd3 =  Ext.getCmp('userOwner');
//		var store3 = cmd3.getStore();	
//		store3.baseParams.dwrParams[0].orgId = $("orgId").value;
//		store3.baseParams.dwrParams[0].loginUser = userName;
//		store3.baseParams.dwrParams[0].loginUserId = loginUserId;
//		store3.reload();	
//		cmd3.clearValue(); 
		
	 if(config_oneOrgMoreSuborgsParam == '0') getResourceTree();
	 
}
function initUserCmd(){
	var paramObJ ={};
//	paramObJ.orgId =  $("orgId").value;
//	paramObJ.loginUser = userName;
//	paramObJ.loginUserId = loginUserId;
//	user.obj = paramObJ;
//	user.getLovCombo('userRenderDiv','userOwner',100,false,true);

	paramObJ.orgId = $("orgId").value; 
	paramObJ.loginUser = loginUser;
	paramObJ.loginUserId = loginUserId;
	user.obj = paramObJ;
	var userCmd = user.getUsersByOrgLimit("userRenderDiv","userOwner",100,null,null);

}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "客户名称,广告品牌,投放金额,分配金额,投放时长,投放比例,时长比例";
	mygrid.setHeader(flds);


	mygrid.setInitWidthsP("20,18,14,14,14,10,10");
	mygrid.setColAlign("left,left,right,right,right,right,right");
	mygrid.setColTypes("tree,ed,ed,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);

    mygrid.enableAlterCss("even","uneven"); 
//	mygrid.setColSorting("str,str,int") ;
	mygrid.setSkin("modern2");
		mygrid.attachFooter('合计:, , , , , ,',['text-align:center;','text-align:left;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
}

//function hiddenChartButton(){
//	if(isDisplayChartParam!=1){
//		$("displayChar").hide();
//	}else{
//		$("displayChar").show();
//	}
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
	carrierType.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value; 
	carrierType.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);

}
//function getCarrierTypeTree(obj){
//	var obj_tree = obj.tree.dhtmlTree;	
//	obj_tree.enableCheckBoxes(true);
//	obj_tree.enableThreeStateCheckboxes(true);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableDragAndDrop(false);
//	obj.reset();
//	obj.obj.parentId = 0;
//	//分频道显示树
//	if(channelModelParam!=1){
//			obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
//	}else{
//			obj.getTreeXMLForChannel(carrier.IdPrefix,resource.IdPrefix,channelModelParam);
//	}
//	
//	obj_tree.loadXMLString(obj.tree.treeXML);
//}
//function makeCarrierSelectItem(){
//	//根据是否分频道，取得频道下拉列表
//	if(channelModelParam!=1){
//		carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	}else{
//		carrier.makeSelectItemAnalyze2(carrier,carrier.selectName,"",setCarrierSelect);
//	}
//}
//function setCarrierSelect(){
//	var id  = $("carrierName").value;
//	 	if(id > 0){
//	 		$(carrier.selectName).value = id;
//	 	}
//}
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
    var gridbox = $("gridbox");
	treebox.style.height = dialogcontent.offsetHeight*0.85+"px";	
	treebox.style.width = treebox.offsetWidth+ "px";	
//	$("adResCount").style.height = dialogcontent.offsetHeight*0.79+"px";
	gridbox.style.height = dialogcontent.offsetHeight*0.85 + "px";	
} 
function buttonEventFill(){
	var btn_search = $("search");
	btn_search.setAttribute("href","javascript:void 0");
	btn_search.onclick = queryList;
	
	
		var userOwner = $("userOwner1");
	userOwner.onclick = displayUsersTree2; 

//	var Bt_displayChar = $("displayChar");
//	Bt_displayChar.setAttribute("href","javascript:void 0");
//	Bt_displayChar.onclick = getFusionChartObjs;
	
//	var Bt_title_div = $("title_div");
//	Bt_title_div.onclick = hiddenTableProty;
	
		
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



function displayUsersTree2(){

  var ids = $("userOwner1").value;
  

  	
  var parentUserId = 0;
  var orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value;
  var urlStr=ctxPath+"selectPopup/selectUserRel.html?mode=1&loginUser="+loginUser+"&ids="+ids+"&orgId="+orgId;
  var cleanBtn ={text: '重置',handler: function(){document.getElementById('userReliframe').contentWindow.refreshTree();}};	
  var closeBtn ={text: '确定',handler: function(){removeWin();}};
  
        
 
          	
        
 var winUser = new Ext.Window({
   title : '选择用户',
   //maximizable : true,
   // maximized : true,
   width : 350,
   height : 400,
   // autoScroll : true,
   // bodyBorder : true,
   // draggable : true,
   isTopContainer : true,
   modal : true,
   resizable : false,
    buttons: [cleanBtn,closeBtn],
   contentEl : Ext.DomHelper.append(document.body, {
    tag : 'iframe',
     id : 'userReliframe',
    style : "border 0px none;scrollbar:true",
    src : urlStr,
    height : "100%",
    width : "100%"
   })
  })
  
  
    	
  winUser.show(); 
  
  function removeWin(){
    	var ids = document.getElementById('userReliframe').contentWindow.getCheckedIds();
    	if(ids!=null && ids.length>0){
			$("userOwner1").value = ids.join(',');
		}else{
			$("userOwner1").value ='';
		}
 
  		winUser.destroy();
   	} 
   winUser.on({'close': {fn: removeWin}});   
    
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
	carrierType.obj.orgId = config_oneOrgMoreSuborgsParam == '1'?1:$("orgId").value; 
	carrierType.getTreeXMLByYear(carrier.IdPrefix,resource.IdPrefix,resource_year,getxml);

}


function button_view_order(){
	 $("model").value = "view";

	 button_print();
}	
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "customerProduct";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "customerProduct";
	 button_print();
}
function button_print(){
	var msg = "是否显示明细 ?";
		ans = confirm(msg);
		if(ans){
			var isDetail = 1;
		}
	$("isDetail").value = isDetail;
	
	$("startDate").value = getFormatDay($("beginDate").value,'ymd');
	$("endDate").value = getFormatDay($("overDate").value,'ymd');
	isPrint="true";
    $("isPrint").value = isPrint;
//    var userIds =  Ext.getCmp('userOwner').getValue();
     var userIds =  $("userOwner1").value;
	$("userId").value  = userIds==''?null:userIds;
	//$("carrierNameForm").value = $("carrierName").value==null?0:$("carrierName").value;
	$("userName").value=loginUser;
	$("channelModelForm").value = channelModelParam;
	$("orgIdForm").value = $("orgId").value;;
	
	
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
}

function hiddenTableProty(){
	//$("gridbox").style.cssText="position:relative;OVERFLOW: auto;width:700px;visibility:hidden;border:solid white 2px;background-color:#f5f5f5;z-index:0";
	resetHeigth();
}
function displayTableProty(){
	//$("gridbox").style.cssText="position:relative;OVERFLOW: auto;width:700px;visibility:show;border:solid white 2px;background-color:#f5f5f5;z-index:0";
	resetHeigth();
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

function getParams(){
	var params = {};
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userIds =  Ext.getCmp('userOwner').getValue();
	var userIds =  $("userOwner1").value;

		
	var userId = userIds==''?null:userIds;
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	params.carrierIds = carrierIds.join(",");
	params.beginDate = beginDate;
	params.endDate = endDate;

	params.userId = userId;
	params.isPrint = "false";
	params.loginUser = loginUser;
	params.orgId = $("orgId").value;
   
  return params;
	
}



function queryList(){
	
	displayTableProty();
	
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userIds =  Ext.getCmp('userOwner').getValue();
	var userIds =  $("userOwner1").value;
	var userId = userIds==''?null:userIds;
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);	
	
	
 if(carrierIds.length == 0){
		 mygrid.clearAll();
		 return false;
	}
	
		if(carrierIds==null){
		 	alert("请选择载体后进行查询！");
		 	return false;
		}	
	
	
 if(beginDate != '' && endDate != ''){
		if(beginDate > endDate){
			alert("开始日期不能大于结束日期");
			 mygrid.clearAll();
//			DWRUtil.removeAllRows(customerProduct.tBody);
			return false;
		}


		
	}else{
		alert("请选择日期");
		mygrid.clearAll();
		return false;
	}	
	
	


	
	var isPass = searchyear(beginDate,endDate);
	
	
	if(!isPass) return false;

	
	
	var params = getParams();

	var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				attachHeaderNew(mygrid);
				Ext.getBody().unmask();
				mygrid.setSizes();	
	}
		

	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	customerProduct.getOaTeleExpensesByBeginAndEndDateXML2($H(params).toQueryString(),func);
//	customerProduct.getOaTeleExpensesByBeginAndEndDateXML(carrierIds,channelModelParam,beginDate,endDate,userId,userName,isPrint,func);

	
}


function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	


	var cl_2 = (rows == 0)?"": grid.cells(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells(lastId,4).getValue();
	var cl_5 = (rows == 0)?"": grid.cells(lastId,5).getValue();

	var htm ="#rspan*#rspan*"+ cl_2 +"*"+ cl_3+"*"+ cl_4+"*"+ cl_5;

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

//function goNextPage(pageIndex,pageInfoName){
//		
//	if(pageInfoName == customerProduct.pageInfo){
//		var page = new Page(customerProduct.pageInfo,customerProduct.pageSize);
//		page.goNextPage(pageIndex);
//		customerProduct.page = page;
//		queryList();
//	}
//}	

function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	 var userIds =  Ext.getCmp('userOwner').getValue();
	 	var userIds =  $("userOwner1").value;
	 var userId = userIds==''?null:userIds;
	//var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	//用carrierIds传递resourceIds
	var carrierIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	
	if(carrierIds.length == 0){
		 DWRUtil.removeAllRows(customerProduct.tBody);
		 return false;
	}
	
	if(carrierIds==null){
		alert("请选择资源！")
	}else{
//		parent.location.href ="customerProductRelChart.html?startDate=" + startDate + "&" + endDate +"$"+userId+"*"+channelModelParam+"?"+carrierIds+"!"+userName;
		window.open("customerProductRelChart.html?startDate=" + startDate + "&" + endDate +"$"+userId+"*"+channelModelParam+"?"+carrierIds+"!"+loginUser,"dispalyChart","")
	}
	
}
function getFusionChartObjs(){

	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var userIds =  Ext.getCmp('userOwner').getValue();
	var userIds =  $("userOwner1").value;
	var userId = userIds==''?null:userIds;
	 
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
                userName: loginUser,
                orgId:$("orgId"),
                channelModelParam: channelModelParam,
                isPrint: isPrint
		};		
		
        var h = $H(a);

		var url = "customerProductRelChart.html?"+h.toQueryString();
//		 alert(url);
		window.open(url);
	}
}
