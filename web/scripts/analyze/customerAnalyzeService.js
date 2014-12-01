


var orderdayinfo =new OrderDayInfo();
var org = new SysOrg();
var branch = new Branch();
//var category =new Category();
var user = new User();
var carrier = new Carrier();
var customer = new Customer();
var customer2 = new Customer();
var incomePurpose = new IncomePurpose();
var resourceType = new ResourceType();
var loginUser;
var loginUserId;
var myDate = new MyDate();
var config_serviceDate;
var myprint =new MyPrint();
var queryWindow;
var ctxPath;
var search_brand_win;




// Ext.onReady(function() {
// 	  var _button= new Ext.Button({
//        id:'search_button_id',
//        text:'button_text',
//        iconCls:'iconCls',
//        renderTo: 'button_search_div'
// 	  })
// 	  
// 	  _button.on('click', function(){queryWindow.show();});
//
//});



callOnLoad(init);

function init(){

	ctxPath = _app_params.ctxPath;	
	tvNameParam =  _app_params.sysParam.tvNameParam;	
	config_serviceDate = _app_params.serviceDate.def;	
	 	
	loginUser =  _app_params.user.username;
	loginUserId =  _app_params.user.id;
	isDisplayChartParam = _app_params.sysParam.isDisplayChartParam;
	channelModelParam = _app_params.sysParam.channelModelParam;

 	config_isDisplayStandPrice = _app_params.sysParam.isDisplayStandPrice;
	config_useCarrierAliname = _app_params.sysParam.useCarrierAliname;
    config_useMoreCarrierSortParam = _app_params.sysParam.useMoreCarrierSortParam;
    config_withResourceSort = _app_params.sysParam.withResourceSort;//是否启用播出入点(启用1,不启用0)系统参数默认是0;
	
 	_make_adrm_sys_year_select("order_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
    _make_org_select("orgId",120,"resetStore");	
    
    
    
    config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}
    
//  if(config_oneOrgMoreSuborgsParam == '1'){
//		orgId =  '1'; 
//		orgIdRel = getParamFromUrl(window.location.href,"orgId")+'';
//	}else{
//		orgId =  getParamFromUrl(window.location.href,"orgId")+'';
//	}
    
    	
	setOrderDayInfoPara(orderdayinfo);
//	setCarrierPara(carrier);
	setCustomerPara(customer);
	setUserPara(user);
	setPurposePara(incomePurpose);
//	getCustomerAutoComplt();
	carrier.obj.nodeLevel =1;
//	hiddenChartButton();
//	makeCarrierSelectItem();
//	getCarrierTree(carrier);
	buttonEventFill();
	if(config_isDisplayStandPrice == 1){
		initGrid();
	}else{
		initGrid2();
	}
 	
 	getDate(_app_params.serviceDate.year, _app_params.serviceDate.def);
 	
 	resetHeigth();
 	
 	this.myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
 	

 	this.myprint.getWeekCheckBox("weekDiv","weekCheckBox","星期",80,"");
 	
 	
 	
// 	if(tvNameParam == 'fztv' || tvNameParam == 'xmtv'){
// 		setCategoryPara(category);
		setOrgPara(org);
		setBranchPara(branch);
//		getCustomerCategoryTree(category);
		getOrgTree(org);
		$("userSelect").hide();
//		$("customerNameTd").hide();
//	}else{
//		$('orgTreeBox').hide();
////		$('categotyBox').hide();
//		user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);
//	}
// 	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
	    incomePurpose.obj.version = $("order_year").value;
	 	incomePurpose.makeOptionsCallBackFun(incomePurpose.obj,fillFun);	

	function fillFun(objs){
		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);     
	}
	
	
//	function callBackFun(){
//		if(config_useMoreCarrierSortParam == 0 || $('orgId').options.length<2){
//				$('orgId_td').hide();
//		}	
//		show_cut_win();	
//	}
//	org.makeSelect(org.obj,"orgId","reset_searche_tree",callBackFun);	

    
    
    if(config_withResourceSort == 1){
		var paramObj3 ={};
	 	paramObj3.version = $("order_year").value;
	 	paramObj3.orgId =  $('orgId').value;
	 	resourceType.obj = paramObj3;
	    var resourceTypeCmd = resourceType.getResourceTypeForCmd("resourceType_div","resourceTypeId",100,function(){});
    }else{
    	  $('resourceType_table').hide();
    }
    

	
	
	
	
// 	new dhtmlXGridFromTable('customerAnalyzeTable');

   show_cut_win();	
 	
}

 function resetStore(){
 	 var orgId = $("orgId").value;
 	 var version =  $("order_year").value;

	 if(config_withResourceSort == 1){
		var cmd3 =  Ext.getCmp('resourceTypeId');
		var store3 = cmd3.getStore();	
		store3.baseParams.dwrParams[0].orgId = orgId;
		store3.baseParams.dwrParams[0].version = version;
		store3.reload();	
		cmd3.clearValue(); 
	 }
	 
	if(queryWindow){
//		queryWindow.owner.orgId = $("orgId").value;
		queryWindow.tree.getLoader().params[1].orgId = orgId;
		queryWindow.tree.root.reload(); 
	}
 }


//function reset_searche_tree(){
//    var orgId = $("orgId").value;
//
//	if(queryWindow){
////		queryWindow.owner.orgId = $("orgId").value;
//		queryWindow.tree.getLoader().params[1].orgId = orgId;
//		queryWindow.tree.root.reload(); 
//	}
//	resetStore();
//	
//
//
//
////	self.tree.getLoader().params[0].date = cbo.value;
//           
//            
//	
////	queryWindow.tree.loader.reload();
//}







function getCustomerCombox(){
	var mode ='remote';
	var cmdId ='test_custComdbox_id';
	var treeId ='test_custComdboxTree_id';
	var checkBox =true;
	var renderTo ='test_custComdboxTree_div';
	var width ='260';
	customer2.obj.orgId = $('orgId').value;
	var params = customer2.obj;
	customer2.getComboboxTree2(mode,cmdId,treeId,params,checkBox,renderTo,width)
}


function show_cut_win(){
	customer.obj.orgId = $("orgId").value;
	var params =[{accountName:'',accountBank:'',customerName:'',orgId:$("orgId").value},{orgId:$("orgId").value}];
	
	
	function setvalue(ids){
		
		var isMoreCustomer = $("isMoreCustomer").checked;

		if(isMoreCustomer){
			$("customerName").value = $("customerName").value+"," +ids;
		}else{
			$("customerName").value = ids;
		}
		
	}
	customer.showWin('customerName',params,loginUser,true,setvalue);
}

function reset_cut_win(){
	 customer.obj.orgId = $("orgId").value; 
//	 customer.customerTypeCommand.setValue(0);
//	 customer.obj.customerTypeId = customer.customerTypeCommand.getValue();
	 customer.treeCommandNameTypeReload();
	 
//     customer.customerCommand.store.reload();
//    
//
//    if(customer.tree){
//	    customer.tree.getLoader().params =[{},{orgId:$("orgId").value}];
//		customer.tree.root.reload(); 
//    }
//    
      
    $("customerName").value ="";
    $("userOwner1").value ="";
    $("carrierName").value ="";

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

function getCarrierTree(obj){
	obj.tree = new Tree('carrierTree'); 
	var obj_tree = obj.tree.dhtmlTree;
	
	obj_tree.dadmode=2;
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(true);
	obj_tree.setOnClickHandler(doOnTreeSelect);//set function to call on dbl click
//	obj_tree.setDragHandler(doOnBeforeDrop);
	
	var getxml = function(strXML){
		obj_tree.loadXMLString(strXML);
		obj_tree.setSubChecked('root',true); 
	}

	carrier.getTree(loginUser,getxml);
}
function doOnTreeSelect(itemId){
	if(itemId == "root") return false;
	var isItemChecked = carrier.tree.dhtmlTree.isItemChecked(itemId);
	carrier.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked); 
}

function displayCarrierTree(){
	var oDiv = $("carrierTree");
	oDiv.style.visibility = "visible";
}
function confirmCarrierTree(){
		
	var resourceIds = new Array();
	var texts = new Array();

	var allCheckedIds = carrier.tree.getAllCheckedBranches("sub");
	if(allCheckedIds!=null){
		$("carrierName").value = allCheckedIds.join(',');
	}else{
		$("carrierName").value ='';
	}
	
	closeCarrierTree();
}

function closeCarrierTree(){
	var oDiv = $("carrierTree");
	oDiv.style.visibility = "hidden";
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
function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.selectName =  "customerId";
}

//function hiddenChartButton(){
//	if(isDisplayChartParam!=1){
//		$("displayChar").hide();
//	}else{
//		$("displayChar").show();
//	}
//}
function setCategoryPara(obj){
	 obj.className ="category";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}
function setOrgPara(obj){
	 obj.className  = "sysOrg";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}
function setBranchPara(obj){
	 obj.className  = "branch";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName  = "branchId";
}
function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userOwner"; 
	 obj.IdPrefix 	= obj.className + "Id";
}
function setPurposePara(obj){
	 obj.className ="incomepurpose";
	 obj.checkBoxName = obj.className +"RN";
}
function setUserSelected(){
	 	var id  = $("userId").value;
	 	if(id > 0){
	 		$(user.selectName).value = id;
	 	}
}


//function resetHeigth(){
//    var dialogcontent = $("dialogcontentDiv");
//    var gridbox = $("gridbox");
//    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
//    if(mygrid){
//    	  mygrid.setSizes();	
//    }
//} 
function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("gridbox");
    if(mygrid){
    	gridbox.style.height = dialogcontent.offsetHeight * 0.86 +"px";	
    	mygrid.setSizes();
    }
} 

function convertMonthCN2Num(m){
	switch(m){
		case "一月":
			return 1;break;
		case "二月":
			return 2;break;				
	}
}

//function getCustomerCategoryTree(OBJ){
//	var obj_tree = OBJ.tree.dhtmlTree;
//	obj_tree.enableCheckBoxes(true);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableThreeStateCheckboxes(true);
//	obj_tree.enableDragAndDrop(true);
//			
//	obj_tree.setOnClickHandler(doOnSelect);
//	obj_tree.setOnDblClickHandler(doOnDblClick);
//	
//	OBJ.reset();
//	function getxml(treeXML){
//		obj_tree.loadXMLString(treeXML);
//	} 
//	OBJ.getCategoryTreeXML(OBJ,customer.IdPrefix,getxml);
//}

//获得树信息
function getOrgTree(obj){
	obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableDragAndDrop(true);
		
	obj_tree.setOnClickHandler(doOnSelect);
	obj_tree.setOnDblClickHandler(doOnDblClick);
	//加载数据
	obj.reset();
	obj.obj.id = 1;
	
	obj.getTreeXML2(branch.IdPrefix,user.IdPrefix,loginUser,callbackFun);
	function callbackFun(treeXML){
		obj_tree.loadXMLString(treeXML);
	}
	
}
function doOnSelect(itemId){
	if(itemId == "root") return false;
	var isItemChecked = org.tree.dhtmlTree.isItemChecked(itemId);
	org.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked); 
}
function doOnDblClick(itemId){
	        var isOpenState = this.getOpenState(itemId);
	        if(isOpenState == -1){
	        	this.openItem(itemId);	
	        }else{
	        	this.closeItem(itemId);
		}	
}
function displayUsersTree(){
	var oDiv = $("sysOrgTreebox");
	oDiv.style.visibility = "visible";
}
function closeUsersTree(){
	var oDiv = $("sysOrgTreebox");
	oDiv.style.visibility = "hidden";
}
function confirmUsers(){
		
	var resourceIds = new Array();
	var texts = new Array();

	var allCheckedIds = org.tree.getAllCheckedBranches("userId");
	if(allCheckedIds!=null){
		$("userOwner1").value = allCheckedIds.join(',');
	}else{
		$("userOwner1").value ='';
	}
	closeUsersTree();
}
//function displayCustomersTree(){
//	var oDiv = $("categoryTreebox");
//	oDiv.style.visibility = "visible";
//}
//function closeCustomersTree(){
//	var oDiv = $("categoryTreebox");
//	oDiv.style.visibility = "hidden";
//}
//function confirmCustomers(){
//		
//	var resourceIds = new Array();
//	var texts = new Array();
//
//	var allCheckedIds = org.tree.getAllCheckedBranches("customerId");
//	if(allCheckedIds!=null){
//		$("customerName1").value = allCheckedIds.join(',');
//	}else{
//		$("customerName1").value ='';
//	}
//	closeCustomersTree();
//}
function buttonEventFill(){
	
//	var Bt_search2 = $("btnSearche2");
//	Bt_search2.setAttribute("href","javascript:void 0");
//	Bt_search2.onclick = function(){
//		
//		var params = {orgId:$('orgId').value,searchTarg:['A','B','C','D','E'],loginUserId:loginUserId,searchFunction:init};
//		
//		if(!queryWindow){
//			queryWindow = new QueryWindow({params:params});
//		}else{
//			queryWindow.tree.getLoader().params[1]= params;
//		}
//		queryWindow.show();
//	};
//	

	var btn_searche = $("btnSearche");
	btn_searche.onclick = displayDiv;
	
	var btn_searche_close = $("btnSearcheClose");
	btn_searche_close.onclick = closeDiv;
	
	var query = $("query");
	query.onclick = getAllMonthInfosByStartAndend;
	
		
	//	显示业务员资源树
	var userOwner = $("userOwner1");
	userOwner.onclick = displayUsersTree2; 
	
	var btn_treeConfirm = $("btn_treeConfirm");
	btn_treeConfirm.onclick = confirmUsers; 
	
	var btn_treeCancel = $("btn_treeCancel");
	btn_treeCancel.onclick = closeUsersTree;
	
	
	var carrierName2 = $("carrierName");
	carrierName2.onclick = displayCarrierTree2; 
	
	var btn_treeConfirm2 = $("btn_carrierTreeConfirm");
	btn_treeConfirm2.onclick = confirmCarrierTree; 
	
	var btn_treeCancel2 = $("btn_carrierTreeCancel");
	btn_treeCancel2.onclick = closeCarrierTree;
	
	
	var change_order_year = $("order_year");
	change_order_year.onchange = rest_query_order;
		
	var Btn_reset_query = $("btn_reset_query");
	Btn_reset_query.onclick =resetQueryWhere;	
	
	
//	//	显示客户资源树
//	var userOwner = $("customerName1");
//	userOwner.onclick = displayCustomersTree; 
//	
//	var btn_treeConfirm = $("btn_treeConfirm1");
//	btn_treeConfirm.onclick = confirmCustomers; 
//	
//	var btn_treeCancel = $("btn_treeCancel1");
//	btn_treeCancel.onclick = closeCustomersTree; 

}

function rest_query_order(){
	var year = $("order_year").value;
	 
//	 getDate(year);
    
     var end = year + ''+ $("overDate").value.substring(5,7)+''+$("overDate").value.substring(8,10);
     
     getDate(year,end);
	
	 var beginDate= $("beginDate").value;
	 var overDate= $("overDate").value;
	 beginDate = year  + beginDate.substring(4,beginDate.length);
	 overDate = year  + overDate.substring(4,overDate.length);
	 $("beginDate").value = beginDate;
	 $("overDate").value = overDate;
	 
	 $("customerName").value = null;
	 $("customerId").value = null;	 
	 resetStore();

	  
//	 getAllMonthInfosByStartAndend();
}

function displayCarrierTree2(){
  var ids = $("carrierName").value;
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



function displayUsersTree2(){
  var ids = $("userOwner1").value;
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


//function getCustomerAutoCompltByName(ev){
//	var customerName =$("customerName").value;
//	customer.obj.customerName = customerName;
//	
//	if(ev.keyCode == 13){
//		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
//		$("customerName").value="";
//	}
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
function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
	
	closeCarrierTree();
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

function resetQueryWhere(){
	
	 var year = $("order_year").value;
//	 var year =_app_params.serviceDate.year;
	 var month =_app_params.serviceDate.month;
	 
	 $("beginDate").value = getFormatDay(year+ month + '01','y/m/d');
	 $("overDate").value= getFormatDay(year+ month +'31','y/m/d');
	 
	 $("isPutYear").checked = false;
	 $("isNotReturnValue").checked = false;
	 
	 $("customerName").value = null;
	 $("customerId").value = null;
	 $("carrierName").value=null;
	 $("userOwner1").value =null;
     if(config_withResourceSort == 1){
     	    var cmd = Ext.getCmp('resourceTypeId');
     		if(cmd) Ext.getCmp('resourceTypeId').setValue('');
     }
     
     var cmd2= Ext.getCmp('weekCheckBox');
     if(cmd2)  Ext.getCmp('weekCheckBox').setValue('');
}




function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
}

function button_view_order(){button_print('view');}	
function button_print_order(){button_print('print');}
function button_print_export(){button_print('export');}

function button_print(model){

//                var nowUser=userName;
                var channelModeId=channelModelParam;
                var customerId=$("customerName").value==''?null:$("customerName").value;
                var beginDate=getFormatDay($("beginDate").value,'ymd');
                var endDate=getFormatDay($("overDate").value,'ymd');
                var userIdForm=$(user.selectName).value==0?null:$(user.selectName).value;
				userIdForm = $('userOwner1').value;
                var carrierName=$("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
                var sortStr=mygrid.getSortingState().join(',');
        
                var putYear=$("isPutYear").checked == true?1:0;
                
                var purpose = getCheckBoxValues("incomePur",1);
				if(purpose == '') purpose.push(-1);  purpose=purpose.toString();
               
                var returnValue=$("isNotReturnValue").checked == true?1:0;
                
                
			  	if(config_withResourceSort == 1){
				 	var resourceTypeId =  Ext.getCmp('resourceTypeId').getValue();
				 	 orderdayinfo.obj.resourceType = resourceTypeId;
				 }              
                
                var weekStr = Ext.getCmp('weekCheckBox').getCheckedValue();
	   
		var a = {
				 	model: model,
				 	title:'客户区间统计',
	                reportType: "customerAnalyze",
	                reportFile:'',
	                headers:"客户名称,到账金额,投放金额,分配金额,欠款,时间",
	                displaySumColum:"0,1,1,1,1,1",
	                
	                colAlign:"left,right,right,right,right,right",
	            	widthsP:"25,15,15,15,15,15", 
	            	
	                isSum:false,
	                isVertical:false,	            	
	            
	                resourceTypeId:orderdayinfo.obj.resourceType,
	                nowUser:loginUser,
	                channelModeId:channelModeId,
	                customerId:customerId,
	                startDate:beginDate,
	                endDate:endDate,
	                userIdForm:userIdForm,
	                carrierName:carrierName,
	                userName:loginUser,
	                sortStr:sortStr,
	                putYear:putYear,
	                incomPurs:purpose,
	                returnValue:returnValue,
	                weekStr:weekStr,
	                orgId:$("orgId").value
			};	
 
	    if(config_isDisplayStandPrice == 1){
	    	a.headers = "客户名称,到账金额,刊例金额,投放金额,分配金额,欠款,时间";
	    	a.displaySumColum = "0,1,1,1,1,1,1";
	    	a.colAlign = "left,right,right,right,right,right,right";
	        a.widthsP = "25,15,15,15,10,10,10";
	    }else{
			a.headers = "客户名称,到账金额,投放金额,分配金额,欠款,时间";
	    	a.displaySumColum = "0,1,1,1,1,1";
	    	a.colAlign = "left,right,right,right,right,right";
	        a.widthsP = "25,15,15,15,15,15";
	    }

        myprint.loadApplet(a,ctxPath,800,500);	
	
	
	//orderdayinfo.obj.resourceSpecific = purpose;
	

//	alert(userName);
	
//	var tarForm =  $("tarForm");
//	var reportForm = $("ReportForm");
//
//	reportForm.target = tarForm;
//	reportForm.action="reports/jsp/common_reports.jsp";
//	reportForm.submit(); 	
}

function setOrderDayInfoPara(obj){
	obj.className ="orderdayinfo";
	obj.IdPrefix = obj.className + "Id";
	obj.fillObjName = "orderdayinfoBody";
	obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	obj.tBody 		= $(obj.fillObjName);
//	obj.pageSize 	= "10000";
//	obj.pageInfo 	= "pageInfo" + obj.className;
//	obj.page = new Page(obj.pageInfo,obj.pageSize);
}
//function getDate(){
//	
//	Calendar.setup({
//		inputField  : "beginDate",	  // id of the input field
//		//ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "beginDate"	// id of the button
//	});
//	
//	Calendar.setup({
//		inputField  : "overDate",	  // id of the input field
//		//ifFormat	: "%Y%m%d",	  // the date format
//		singleClick	  : true,
//		button	  : "overDate"	// id of the button
//	});
////	$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
////	$("overDate").value = getFormatDay(theYear+'1231','y/m/d');
//	
//	
//	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
//	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
//}


function getDate(order_year,serviceDate){
	

	$("order_year").value = order_year;
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(serviceDate),'y/m/d');
	$("overDate").value=   getFormatDay(myDate.getNewDayEndDay1(serviceDate),'y/m/d');

	
	function dateDisabledFunc(date,i){
		if(i == 1){
		   var pval = ''+$("overDate").value; 
		   pval = pval.replace("/",'')*1;
		   var calDate = date.print("%Y%m%d")*1;
		   return !(date.getFullYear() == order_year && calDate < pval);
		}else{
		   var pval = $("beginDate").value;
		   pval = pval.replace("/",'')*1;
		   var calDate = date.print("%Y%m%d")*1;
		   return !(date.getFullYear() == order_year && calDate > pval);
		}

//		 return (date.getFullYear() != order_year);
	}

	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		range:[order_year],
		firstDay:1,
		singleClick	  : true,
		button	  : "beginDate",// id of the button
		dateDisabledFunc : function(date) {
//                      dateDisabledFunc(date,1);
		}
	});
	
	Calendar.setup({
		inputField  : "overDate",	  // id of the input field
		range:[order_year],
		firstDay:1,
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "overDate",	// id of the button
		dateDisabledFunc : function(date) {
//                     dateDisabledFunc(date,2);
		}
	});


}



function attachHeaderNew(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	var cl_1 = (rows == 0)?"": grid.cells2(lastId,1).getValue();
	var cl_2 = (rows == 0)?"": grid.cells2(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells2(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells2(lastId,4).getValue();
	var cl_5 = (rows == 0)?"": grid.cells2(lastId,5).getValue();
	var cl_6 = (rows == 0)?"": grid.cells2(lastId,6).getValue();
	
	
//	var cl_1 = grid.getUserData(lastId,"income");
//	var cl_2 = grid.getUserData(lastId,"standPrice");
//	var cl_3 = grid.getUserData(lastId,"realIncom");
//	var cl_4 = grid.getUserData(lastId,"relPuton");
//	var cl_5 = grid.getUserData(lastId,"qiankuan");
//	var cl_6 = grid.getUserData(lastId,"useTimeSum");

	var htm ="#rspan*"+ cl_1 +"*"+ cl_2 +"*"+ cl_3 +"*"+ cl_4 +"*"+ cl_5+"*"+ cl_6 +"";

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


function attachHeaderNew2(grid){
	var rows = grid.getRowsNum();
	var lastId = grid.getRowId(rows-1);
	var cl_1 = (rows == 0)?"": grid.cells2(lastId,1).getValue();
	var cl_2 = (rows == 0)?"": grid.cells2(lastId,2).getValue();
	var cl_3 = (rows == 0)?"": grid.cells2(lastId,3).getValue();
	var cl_4 = (rows == 0)?"": grid.cells2(lastId,4).getValue();
	var cl_5 = (rows == 0)?"": grid.cells2(lastId,5).getValue();
	
//	var cl_1 = grid.getUserData(lastId,"income");
//	var cl_2 = grid.getUserData(lastId,"realIncom");
//	var cl_3 = grid.getUserData(lastId,"relPuton");
//	var cl_4 = grid.getUserData(lastId,"qiankuan");
//	var cl_5 = grid.getUserData(lastId,"useTimeSum");

	
	
	
//					sb.append("<userdata name=\"useTimeSum\"><![CDATA["+ adSumTimes  +"]]></userdata>");
//				sb.append("<userdata name=\"standPrice\"><![CDATA["+ standPrice  +"]]></userdata>");
//				sb.append("<userdata name=\"realIncom\"><![CDATA["+ realIncom  +"]]></userdata>");
//				sb.append("<userdata name=\"RelPuton\"><![CDATA["+ RelPuton  +"]]></userdata>");
				

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


function getParam(){
	orderdayinfo.reset();
	orderdayinfo.obj.startDate=getFormatDay($("beginDate").value,'ymd');
	orderdayinfo.obj.endDate=getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	if(config_fztvSpecialParam == 1){
		userId = $('userOwner1').value;
//	}
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
//	var customerId = $("customerId").value;
	var customerId = $("customerName").value;
	var sortStr = mygrid.getSortingState();
	//列排序号
	orderdayinfo.obj.resourceSpecific = sortStr[0]+","+sortStr[1];
	orderdayinfo.obj.businessFirstName = $("isPutYear").checked == true?1:0;
	orderdayinfo.obj.businessLastName = $("isNotReturnValue").checked == true?1:0;
	
	
	var purpose = getCheckBoxValues("incomePur",1);
	if(purpose == '') purpose.push(-1);
	orderdayinfo.obj.toaccountTotal = purpose.toString();
	
	 if(config_withResourceSort == 1){
	 	var resourceTypeId =  Ext.getCmp('resourceTypeId').getValue();
	 	 orderdayinfo.obj.resourceType = resourceTypeId;
	 }
	
	orderdayinfo.obj.orgId = $("orgId").value;  
	
	orderdayinfo.obj.weekStr = Ext.getCmp('weekCheckBox').getCheckedValue();

	
	
	return orderdayinfo;
}
function getAllMonthInfosByStartAndend(){
	closeDiv();
//    displayTableProty();
//	var func=function(objs){
//	}
	
	var orderdayinfo =  getParam();
	
	userId = $('userOwner1').value;
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	var customerId = $("customerName").value;	 
	
	 var func = function(xml){
//		 	incomePull.incomeMoneyFillTalbe(objs);
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				//if(mygrid.ftr.rows[0]) mygrid.ftr.rows[0].remove();
				//alert(mygrid.getRowsNum());
                                //  alert(mygrid.getRowId(mygrid.getRowsNum()-1));
				if(config_isDisplayStandPrice == 1){
					attachHeaderNew(mygrid);
				}else{
					attachHeaderNew2(mygrid);
				}
				

				Ext.getBody().unmask();
				
			    mygrid.setSizes();	
				
		 }
	
	
	if($("beginDate").value=="" || $("overDate").value=="" ){
		alert("请先选择日期");
	}else{
		Ext.getBody().mask('数据加载中……', 'x-mask-loading');
		orderdayinfo.getOrderDayInfosXML(orderdayinfo.obj,userId,carrierName,customerId,channelModelParam,loginUser,func);
	}
}

function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
//	var customerId = $("customerId").value==0?null:$("customerId").value;
	var customerId = $("customerName").value==''?null:$("customerName").value;
	
	
	 //userName为登陆用户名
	window.open("customerAnalyzeChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+customerId+"*"+channelModelParam+"!"+loginUser,"dispalyChart","");

	//window.location.href ="customerAnalyzeChart.html?startDate=" + startDate + "&" + endDate+"$" + carrierName+"?"+userId+"@"+customerId+"*"+channelModelParam ;
}
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
//	var flds = "序号,客户名称,投放金额,平账金额,投放时长,欠款";
	var flds = "客户名称,到账金额,刊例金额,投放金额,分配金额,欠款,时间";
	mygrid.setHeader(flds);
	var columnIds = "cuctomerName,stat_count,daokuan,toufangshichang,qiankuan,qiankuan2";
	mygrid.setColumnIds(columnIds);
	

    mygrid.setInitWidthsP("25,15,15,15,10,10,10");
	mygrid.setColAlign("left,right,right,right,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed");
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
    mygrid.setColSorting("str,int,int,int,int,int,int") ;
    mygrid.enableAlterCss("even","uneven"); 
//    mygrid.setOnRowDblClickedHandler(onRowDblClicked,true);
//     mygrid.ftr.rows[0].remove();
// mygrid.attachHeader(0,0,"#rspan,Title,Author,#rspan,#rspan,#rspan,Bestseller,Published");
// mygrid.attachFooter('aaaaaaaaaa,sum{#stat_count},#cspan1,#cspan2,#cspan3,#cspan4',[]);
//mygrid.attachHeader('aaaaaaaaaa,sum{#daokuan},#cspan1,#cspan2,#cspan3,#cspan4',[],'_aFoot');

//    mygrid.dynScroll = true;
//	mygrid.recordsNoMore = false;
//	mygrid.dynScrollPos = 0;
//	mygrid.rowsBufferOutSize = 10;
// mygrid.setDynScrollPageSize();
    
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	mygrid.attachFooter('合计:, , , , , , ',['text-align:center;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	mygrid.setSizes();	
	 //mygrid.ftr.rows[0].hide();
	//mygrid.attachHeader('aaaaaaaaaa,sum{#daokuan},#cspan1,#cspan2,#cspan3,#cspan4',[],'_aFoot');
}



function initGrid2(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	

	var flds = "客户名称,到账金额,投放金额,分配金额,欠款,时间";
	mygrid.setHeader(flds);
	var columnIds = "cuctomerName,stat_count,daokuan,toufangshichang,qiankuan";
	mygrid.setColumnIds(columnIds);
	
//	mygrid.groupBy(3);
	

    mygrid.setInitWidthsP("25,15,15,15,15,15");
	mygrid.setColAlign("left,right,right,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed");
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);

    mygrid.setSkin("modern2");
    mygrid.setColSorting("str,int,int,int,int,int") ;
    mygrid.enableAlterCss("even","uneven"); 
// 	mygrid.setOnRowDblClickedHandler(onRowDblClicked,true);
    
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	mygrid.attachFooter('合计:, , , , , ',['text-align:center;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
	mygrid.setSizes();	
}



 
 
 
 
 
 


function getFusionChartObjs(){
	
	var orderdayinfo =  getParam();

	var sortStr=mygrid.getSortingState().join(',');    
	var channelModeId=channelModelParam;
    userId = $('userOwner1').value;              
	var carrierName = $("carrierName").value==null||$("carrierName").value==''?0:$("carrierName").value;
	var customerId = $("customerName").value;
	

	
	function func(objs){
		fusionChartObjects = objs;
	}



	if($("beginDate").value=="" || $("overDate").value=="" ){
		alert("请先选择日期");
	}else{
		
		var a = {
			    resourceTypeId:orderdayinfo.obj.resourceType,
			 	startDate: orderdayinfo.obj.startDate,
                endDate: orderdayinfo.obj.endDate,
                sorCol: sortStr[0],
                sorType: sortStr[1],
                putYear: orderdayinfo.obj.businessFirstName,
                userId: userId,
                carrierName: carrierName,
                customerId: customerId,
                channelModelParam: channelModelParam,
                theUser: loginUser,
                incomPurs: orderdayinfo.obj.toaccountTotal,
                returnValue: orderdayinfo.obj.businessLastName,
                weekStr:orderdayinfo.obj.weekStr,
                orgId:orderdayinfo.obj.orgId
		};		
		

        //now transform it into a hash encodeURI
        var h = $H(a);
//        alert(h.toQueryString()); //displays: first=10&second=20&third=30
//		var url = encodeURI("customerAnalyzeChart.html?"+h.toQueryString());
		var url = "customerAnalyzeChart.html?"+h.toQueryString();
//		 alert(url);
		window.open(url);
		//FusionChartsManager.getCustomerChartObjs(orderdayinfo.obj,userId,carrierName,customerId,channelModelParam,theUser,func);
	}
	
	
}





//
//function close_search_brand_win(p,my_grid_matter){
//		search_brand_win.hide();
//}
// function onRowDblClicked(id,cellInd){
// 	
//   var urlStr= ctxPath + "selectPopup/selectMatters.html?orgId="+orgId+"&customerId="+customerId+"&version="+$("order_year").value;
//
//   if(!search_brand_win){
//
//   	   var closeBtn ={text: '关闭',handler:close_search_brand_win};
//
//	   search_adver_win =new Ext.Window({
//			   title : '新客户注册',
//			   width : winW,
//			   height : winH,
//			   isTopContainer : true,
//			   modal : true,
//			   resizable : false,
//			   buttons: [regBtn,closeBtn],
//			   contentEl :  $("gridbox_brand")
//		});
//
//		 search_adver_win.on({'close': {fn: close_search_brand_win}});
//
//		 search_adver_win.show(this);
//
//   }else{
//
//   	    callFunction(Ext.getCmp("search_adver_tapecode").params);
//   	    
//   	   	search_adver_win.show(this);
//   }
//   
// }
 
// function initGrid3(){
//	mygrid3 = new dhtmlXGridObject('gridbox_brand');
//	mygrid3.selMultiRows = true;
//	mygrid3.setImagePath("image/grid/");
//	var flds = "品牌名称,投放金额,分配金额,欠款,使用时间";
//	mygrid3.setHeader(flds);
//	var columnIds = "brandName,real,daokuan,toufangshichang,qiankuan";
//	mygrid3.setColumnIds(columnIds);
//    mygrid3.setInitWidthsP("25,25,25,25,25,25");
//	mygrid3.setColAlign("center,center,center,center,center,center");
//	mygrid3.setColTypes("ed,ed,ed,ed,ed");
//    mygrid3.setMultiLine(false);
//	mygrid3.setEditable(false);
//    mygrid3.setSkin("modern2");
//    mygrid3.setColSorting("str,int,int,int,int") ;
//    mygrid3.enableAlterCss("even","uneven"); 
//	mygrid3.init();	 
//	mygrid3.setSortImgState(true,0,"ASC"); 
//	mygrid3.setSizes();	
//}











