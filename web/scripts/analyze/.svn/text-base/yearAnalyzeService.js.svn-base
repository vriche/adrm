//实锟斤拷锟斤拷锟?
//var income = new Income();
//var yearAnalyze =new YearAnalyze();
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
var myprint =new MyPrint();
var org = new SysOrg();
var resourceType = new ResourceType();
var queryWindow;



callOnLoad(init);	
  


  
function init(){ 

	ctxPath = _app_params.ctxPath;	
	tvNameParam =  _app_params.sysParam.tvNameParam;  	
	config_serviceDate = _app_params.serviceDate.def;		
	
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;

	userName =  _app_params.user.username;	
	config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
 
	config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
	
		_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);	   
	get_cur_year();
	
	
	
	setyearAnalyzePara(orderDayInfo);
//	setCustomerPara(customer);
//	setCategoryPara(category);

//	setUserPara(user);
	setPurposePara(incomePurpose);
	setCarrierPara(carrier);
	carrier.obj.nodeLevel =1;
//	makeCarrierSelectItem();
	//carrier.makeSelectItemAnalyze(carrier.obj,"carrierName","");
//	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);

//	getCustomerCategoryTree(category);
//	hiddenChartButton();
 	buttonEventFill();
// 	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
 	initGrid();
 	
 	resetHeigth();
 	
//	incomePurpose.makeOptionsCallBackFun(incomePurpose,fillFun);	
	
	incomePurpose.obj.version = $("order_year").value;
	incomePurpose.makeOptionsCallBackFun(incomePurpose.obj,fillFun);		

	function fillFun(objs){
		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);     
	}
	

   	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80); 
   	
//    function callBackFun(){
//		if(config_useMoreCarrierSortParam == 0 || $('orgId').options.length<2){
//				$('orgId_td').hide();
//		}	
//		
//		var orgId = $('orgId').value;
//		var par2 = [{},{orgId:orgId}];
//		
//		
//		var bb ={
//                    text     : '确定',
//                    handler  : function(){
//                
//                    }
//                };
//                
//        customer.obj.orgId =orgId; 
//	    customer.tree = customer.getTree('customerTree',par2,true,"customer_tree_div",getTreeWidth(),{});
//	}
//	
//	org.makeSelect(org.obj,"orgId","reset_cut_win",callBackFun);

	_make_org_select("orgId",120,"resetStore");		
	
	    config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
	
	
	var orgId = $('orgId').value;
	var par2 = [{},{orgId:orgId}];	
	
//    customer.obj.orgId =orgId; 
//	customer.tree = customer.getTree('customerTree',par2,true,"customer_tree_div",getTreeWidth(),{});	
	
	
	
	if(config_withResourceSort == 1){
		var paramObj3 ={};
//	 	paramObj3.version = comYear.getValue();
		paramObj3.version = $("order_year").value;
	 	paramObj3.orgId =  $('orgId').value;
	 	resourceType.obj = paramObj3;
	    var resourceTypeCmd = resourceType.getResourceTypeForCmd("resourceType_div","resourceTypeId",90,function(){});
    }else{
    	  $('resourceType_table').hide();
    }
    
    
    show_cut_win();	
	
}


 function resetStore(){
 	
 	 
 	 var orgId = $("orgId").value;
 	 var version =  $("order_year").value;
 	 
 	
 	 
 	if(queryWindow){
		queryWindow.tree.getLoader().params[1].orgId = orgId;
		queryWindow.tree.root.reload(); 
	}	 
 	 

	 if(config_withResourceSort == 1){
		var cmd3 =  Ext.getCmp('resourceTypeId');
		var store3 = cmd3.getStore();	
		store3.baseParams.dwrParams[0].orgId = orgId;
		store3.baseParams.dwrParams[0].version = version;
		store3.reload();	
		cmd3.clearValue(); 
	 }
 }

function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("gridbox");
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
} 

function show_cut_win(){
	customer.obj.orgId = $("orgId").value;
	var params =[{accountName:'',accountBank:'',customerName:'',orgId:$("orgId").value},{orgId:$("orgId").value}];
	function setvalue(ids){$("customerName").value = ids;}
	customer.showWin('customerName',params,userName,true,setvalue);
}

function getTreeWidth(){
	  var dialogcontent = $("dialogcontentDiv");
	  return dialogcontent.offsetWidth*0.2;
}


//function reset_cut_win(){
//	var orgId = $("orgId").value;
////	 customer.obj.orgId = $("orgId").value; 
////	 customer.customerTypeCommand.setValue(0);
////	 customer.obj.customerTypeId = customer.customerTypeCommand.getValue();
////	 customer.treeCommandNameTypeReload();
//    resetStore();
////	var cmd3 =  Ext.getCmp('resourceTypeId');
////	var store3 = cmd3.getStore();	
////	store3.baseParams.dwrParams[0].orgId = orgId;
////	store3.reload();	
////	cmd3.clearValue(); 
//
//}

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

function sort_custom(a,b,order){ 
	var n= convertMonthCN2Num(a); 
	var m= convertMonthCN2Num(b); 
	if(order=="asc") return n>m?1:-1; else return n<m?1:-1; 
} 

function sort_custom2(a,b,order){ 
	var n= convertQuarterCN2Num(a); 
	var m= convertQuarterCN2Num(b); 
	if(order=="asc") return n>m?1:-1; else return n<m?1:-1; 
} 

function sort_customer(){
	if($("query").value == 1){
		
		mygrid.setColSorting("sort_custom,int,int,int,int,int") ;
	    mygrid.setCustomSorting(sort_custom,0);
	}else{
		
		mygrid.setColSorting("sort_custom2,int,int,int,int,int") ;
	    mygrid.setCustomSorting(sort_custom2,0);
	}
}
//function hiddenChartButton(){
//	if(isDisplayChartParam!=1){
//		$("displayChar").hide();
//	}else{
//		$("displayChar").show();
//	}
//}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "月份,到帐金额,投放金额,分配金额,欠款,时间";
	mygrid.setHeader(flds);
//	var columnIds = "cuctomerName,toufangjine,daokuan,toufangshichang,qiankuan";
//	mygrid.setColumnIds(columnIds);
	mygrid.setInitWidthsP("25,15,15,15,15,15");
	mygrid.setColAlign("left,right,right,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
//	mygrid.setColSorting("sort_custom,int,int,int,int,int") ;
//	mygrid.setCustomSorting(sort_custom,0);
    sort_customer();
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	mygrid.attachFooter('合计:, , , , , ',['text-align:center;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	mygrid.setSizes();	
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

//function setUserSelected(){
//	 	var id  = $("userId").value;
//	 	if(id > 0){
//	 		$(user.selectName).value = id;
//	 	}
//}

function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userOwner"; 
}


function buttonEventFill(){
	var Btn_searchCustomerYear = $("searchCustomerYear");
	Btn_searchCustomerYear.onclick = showTable;
	
	var query = $("query");
	query.onchange=sort_customer;	
	
//    var Btn_searchCustomerQuarter = $("searchCustomerQuarter");
//	Btn_searchCustomerQuarter.onclick = showTable2;	
	
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
	
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 
	
	
		//	显示业务员资源树
	var userOwner = $("userOwner1");
	userOwner.onclick = displayUsersTree2; 
	
	
	var change_order_year = $("order_year");
	change_order_year.onchange = resetStore;
	
}


function displayUsersTree2(){
  var ids = $("userOwner1").value;
  var loginUser =  userName;
  var parentUserId = 0;
  var urlStr="selectPopup/selectUserRel.html?mode=1&loginUser="+loginUser+"&ids="+ids+"&orgId="+$("orgId").value;
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

function displayCarrierTree2(){
  var ids = $("carrierName").value;
  var loginUser =  userName;
//  var urlStr="selectPopup/selectUserCarrierRel.html?mode=2&loginUser="+loginUser+"&ids="+ids;
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

//function resetText(ev){
//	 $("customerName").value = null;
//	 $("customerId").value = null;
//}

function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
}

function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
} 

//function getCustomerAutoCompltByName(ev){
//	var customerName =$("customerName").value;
//	customer.obj.customerName = customerName;
//	
//	
//	if(ev.keyCode == 13){
//		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
//		$("customerName").value="";
//		//getSelectCustomerToTree();
//	}
//}
//function getSelectCustomerToTree(){
//	var id = $("customerId").value;
//	category.tree.refreshTree();
//	var parentId = category.tree.getItemIdByIndex(0);
//	category.tree.dhtmlTree.closeAllItems(parentId);
//	category.tree.dhtmlTree.setCheck(customer.IdPrefix+id,true);
//	//category.tree.dhtmlTree.selectItem(customer.IdPrefix+id,true);
//	category.tree.dhtmlTree.focusItem(customer.IdPrefix+id);
//}
//function customerAutoComplete(objs)
//{
//	var oText = $("customerName");
//	var oDiv = $("theDivCustomerName");
//
//	var indexColumName_customerName = ["helpCode"];
//	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
//	var hidenColumName = ["id","customerCategoryId","helpCode"];
//	var allColumsTitle = ["客户名称","客户类别"];
//	
//	var onDivMouseDown_customerId = function(ev){
//
//		var tr = getElementByEvent(ev);
//		$("customerId").value = getCellValue(tr,0);
//		$("customerName").value = getCellValue(tr,2);
//		$("customerCategoryId").value = getCellValue(tr,3);
//		
//		oText.value = getCellValue(tr,2);
//		getSelectCustomerToTree();
//	}
//	
//	var onTextBlur = function(ev){
//
//		oDiv.style.visibility = "hidden";
//		
//		if(trim(oText.value) == "" ){
//			$("customerId").value = '';
//			$("customerCategoryId").value = '';
//		
//		}
//	}
//   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
//}

function button_view_order(){button_print('view');}	
function button_print_order(){button_print('print');}
function button_print_export(){button_print('export');}

function button_print(model){
	$("model").value = model;
	$("type").value = $("query").value;
	$("reportType").value = "yearAnalyze_report";
//	$("customerIdsForm").value = customer.tree.getAllCheckedIds(2);
	$("customerIdsForm").value = $("customerName").value;    

	$("yearForm").value = $("order_year").value;
	$("userId").value  = $("userOwner1").value==0?null:$("userOwner1").value;
	$("carrierNameForm").value = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	$("userName").value=userName;
	$("channelModelParam").value = channelModelParam;
	var sortStr = mygrid.getSortingState();
	$("sortStr").value= sortStr[0]+","+sortStr[1];
	$("putYear").value= $("isPutYear").checked == true?1:0;	
	$("returnValue").value= $("isNotReturnValue").checked == true?1:0;
	
	
	 $("orgIdForm").value = $("orgId").value;
	
	if(config_withResourceSort == 1){
		var resourceTypeId =  Ext.getCmp('resourceTypeId').getValue();
		$("resourceSortId").value = resourceTypeId;
	} 
	

	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	$("incomPurs").value= purpose.toString();
	
	
	
//	if($("customerIdsForm").value=='') return false;
	
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

function setyearAnalyzePara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 
	 obj.className = "orderDayInfo";
	 obj.IdPrefix 	= obj.className + "Id";
//	 obj.tableName   = "orderDayInfoList";
//	 obj.fillObjName = obj.className + "TBody";
//	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
//	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
//	 obj.tBody 		= $(obj.fillObjName);
//	 
//	 obj.pageInfo 	= "pageInfo_" + obj.className;
//	 obj.pageSize 	= "0";
//	 obj.page = new Page(obj.pageInfo,obj.pageSize);
	// obj.incomePurpose = new IncomePurpose();
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
//function setCategoryPara(obj){
//	 obj.className ="category";
//	 obj.IdPrefix 	= obj.className + "Id";
//	 obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox); 
//	 
//}

function initCustomerTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj_tree.enableThreeStateCheckboxes(true);
//	obj_tree.setOnClickHandler(doOnSelectGetRes);
	getCustomerTree();
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

function getCustomerCategoryTree(OBJ){
	var obj_tree = OBJ.tree.dhtmlTree;
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	
	
	OBJ.reset();
	function getxml(treeXML){
		obj_tree.loadXMLString(treeXML);
		
	} 
//	alert("ssss");
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
	var cl_1 = (rows == 0)?"": grid.cells2(lastId,1).getValue();
	var cl_2 = (rows == 0)?"": grid.cells2(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells2(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells2(lastId,4).getValue();
	var cl_5 = (rows == 0)?"": grid.cells2(lastId,5).getValue();

	var htm ="#rspan*"+ cl_1 +"*"+ cl_2 +"*"+ cl_3 +"*"+ cl_4 +"*"+ cl_5 +"";

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
//显示查询结果
function showTable(){
	closeDiv();
	var type = $("query").value;
    var year = $("order_year").value;

//     var customerIds = customer.tree.getAllCheckedIds(2);
     
      var customerIds =$("customerName").value;


	var userId = $("userOwner1").value==0?null:$("userOwner1").value;
//	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	var sortStr = mygrid.getSortingState();
	orderDayInfo.reset();
	orderDayInfo.obj.resourceSpecific = sortStr[0]+","+sortStr[1];
	orderDayInfo.obj.businessFirstName = $("isPutYear").checked == true?1:0;
	orderDayInfo.obj.id = type;
	orderDayInfo.obj.businessLastName = $("isNotReturnValue").checked == true?1:0;
	orderDayInfo.obj.orgId = $("orgId").value;
	
	if(config_withResourceSort == 1){
		var resourceTypeId =  Ext.getCmp('resourceTypeId').getValue();
		orderDayInfo.obj.resourceType = resourceTypeId;
	}   
	
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	orderDayInfo.obj.businessFullName = purpose.toString();
	
//	if(customerIds=='') return false;
	
	var func = function(xml){

//			var z =  mygrid.ftr.rows[1];
			var z =  mygrid.hdr.rows[1];
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(0)]:0];
		
			if(type == 1){
				c.innerHTML = "<div class=\"hdrcell\">月份</div>";
			}else{
				c.innerHTML = "<div class=\"hdrcell\">季度</div>";
			}
		
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
		attachHeaderNew(mygrid);
		
		Ext.getBody().unmask();
	}

    if(customerIds != null){
    	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		orderDayInfo.getCustomerByYearXML(func,orderDayInfo.obj,year,customerIds.split(","),userId,carrierName,channelModelParam,userName);  
    }else{
    	alert("请选择客户后进行查询！");
    }
}


function getCustomerAutoComplt(){
	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
}
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
//    		DWRUtil.removeAllRows(orderDayInfo.tBody);
//		}
//	}
//   new AutoComplete(objs,oText_customerId,oDiv_customerId,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerId,allColumsName_customerId);
//}
	
function displayChar(){
	var type = $("query").value;
    var year = $("order_year").value;
    var userId = $("userOwner1").value==0?null:$("userOwner1").value;
//	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
//     var customerIds = customer.tree.getAllCheckedIds(2);
      var customerIds = $("customerName").value;
    if(customerIds=='') return false;
    
//    if(yearOrQuarter==undefined){
//    	alert("请选择显示类型！");
//    	return false;
//    }
//	parent.location.href ="yearAnalyzeChart.html?startDate=" + year + "&" + customerIds+"$" + carrierName+"?"+userId+"@"+yearOrQuarter+"*"+channelModelParam+"!"+userName;
	window.open("yearAnalyzeChart.html?startDate=" + year + "&" + customerIds+"$" + carrierName+"?"+userId+"@"+type+"*"+channelModelParam+"!"+userName,"dispalyChart","")
}
function getFusionChartObjs(){
	orderDayInfo.reset();
	var type = $("query").value;
    var year = $("order_year").value;
    
//    var customerIds = category.tree.getAllCheckedBranches(customer.IdPrefix);
    

//     var customerIds = customer.tree.getAllCheckedIds(2);

 	var customerIds = $("customerName").value;    
 	
	var userId = $("userOwner1").value==0?null:$("userOwner1").value;
//	var carrierName = $("carrierName").value==null?0:$("carrierName").value;
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	var theUser = userName;
	var sortStr = mygrid.getSortingState();
	
	orderDayInfo.obj.resourceSpecific = sortStr[0]+","+sortStr[1];
	orderDayInfo.obj.businessFirstName = $("isPutYear").checked == true?1:0;
	orderDayInfo.obj.id = type;
	orderDayInfo.obj.businessLastName = $("isNotReturnValue").checked == true?1:0;
	orderDayInfo.obj.orgId = $("orgId").value;
	
	
	
	if(config_withResourceSort == 1){
		var resourceTypeId =  Ext.getCmp('resourceTypeId').getValue();
		orderDayInfo.obj.resourceType = resourceTypeId;
	}   
	
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	orderDayInfo.obj.businessFullName = purpose.toString();
	
	
//	if(customerIds=='') return false;
	
	function func(objs){
		fusionChartObjects = objs;
//		alert(fusionChartObjects.length);
	}
		
		var a = {
			    orgId:$("orgId").value,
                year: year,
                resourceTypeId:orderDayInfo.obj.resourceType,
                sortStr: orderDayInfo.obj.resourceSpecific,
                putYear: orderDayInfo.obj.businessFirstName,
                userId: userId,
                carrierName: carrierName,
                customerId: customerIds.toString(),
                channelModelParam: channelModelParam,
                theUser: theUser,
                type: orderDayInfo.obj.id,
                incomPurs: orderDayInfo.obj.businessFullName,
                returnValue: orderDayInfo.obj.businessLastName
		};		
		

        //now transform it into a hash encodeURI
        var h = $H(a);
		var url = "yearAnalyzeChart.html?"+h.toQueryString();
		window.open(url);

}