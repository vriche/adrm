var orderDetail =new OrderDetail();
var org = new SysOrg();
var branch = new Branch();
//var category =new Category();
var user = new User();
var carrier = new Carrier();
var customer = new Customer();
var incomePurpose = new IncomePurpose();
var userName ;
var myDate = new MyDate();
var config_serviceDate;

callOnLoad(init);

function init(){
	
	config_serviceDate = _app_params.serviceDate.def;	
//	isDisplayChartParam = $("config_isDisplayChartParam").value;
//	channelModelParam = $("config_channelModelParam").value;
//	config_serviceDate = $("config_serviceDate").value;
//	config_fztvSpecialParam = $("config_fztvSpecialParam").value;
//	setOrderDayInfoPara(orderdayinfo);
//	setCarrierPara(carrier);
//	setCustomerPara(customer);
//	setUserPara(user);
//	setPurposePara(incomePurpose);
//	carrier.obj.nodeLevel =1;
//	hiddenChartButton();
//	makeCarrierSelectItem();
//	userName = $("config_username").value;
//	buttonEventFill();
// 	initGrid();
// 	getDate();
// 	resetHeigth();
// 	if(config_fztvSpecialParam == 1){
//		setOrgPara(org);
//		setBranchPara(branch);
//		getOrgTree(org);
//		$("userSelect").hide();
//	}else{
//		$('orgTreeBox').hide();
//		user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);
//	}
// 	customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
//
// 	incomePurpose.makeOptionsCallBackFun(incomePurpose,fillFun);	
//
//	function fillFun(objs){
//		makeOptionsCheckBoxHtml(objs,"checkbox",incomePurpose.checkBoxName,"name","id","","",[]);     
//	}
initGrid();
 	getAllMonthInfosByStartAndend();
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

function hiddenChartButton(){
	if(isDisplayChartParam!=1){
		$("displayChar").hide();
	}else{
		$("displayChar").show();
	}
}
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


function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var gridbox = $("gridbox");
    
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
   
} 

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
	obj.getTreeXML(branch.IdPrefix,user.IdPrefix);
	obj_tree.loadXMLString(obj.tree.treeXML);
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
function buttonEventFill(){
	var query = $("query");
	query.onclick = getAllMonthInfosByStartAndend;

}
function getCustomerAutoCompltByName(ev){
	var customerName =$("customerName").value;
	customer.obj.customerName = customerName;
	
	if(ev.keyCode == 13){
		customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
		$("customerName").value="";
	}
}
function customerAutoComplete(objs)
{
	var oText = $("customerName");
	var oDiv = $("theDivCustomerName");

	var indexColumName_customerName = ["helpCode"];
	var allColumsName_customerName =["id","helpCode","customerName","customerCategoryId","category.categoryName"];
	var hidenColumName = ["id","customerCategoryId","helpCode"];
	var allColumsTitle = ["客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		$("customerId").value = getCellValue(tr,0);
		$("customerName").value = getCellValue(tr,2);
		$("customerCategoryId").value = getCellValue(tr,3);
		
		oText.value = getCellValue(tr,2);
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '';
			$("customerCategoryId").value = '';
		
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);
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
//	$("beginDate").value = getFormatDay(theYear+'0101','y/m/d');
//	$("overDate").value = getFormatDay(theYear+'1231','y/m/d');
	
	
	$("beginDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("overDate").value = getFormatDay(myDate.getNewDayEndDay1(config_serviceDate),'y/m/d');
}

function getAllMonthInfosByStartAndend(){
	var callback = function(xml){
		mygrid.loadXMLString(xml);
		Ext.getBody().unmask();
	}
	orderDetail.obj.resourceSortId=16;
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	orderDetail.getOrderDetailsAnalyze(orderDetail.obj,callback);
}         

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
	var flds = "序,订单编号,客户名称,广告名称,广告长度,频道,资源,开始日期,结束日期,投放金额,次数";
	mygrid.setHeader(flds);
	var columnIds = "order,orderCode,cusomerName,matterName,matterlength,carrierName,resourceMemo,publishStart,publishEnd,money,times";
	mygrid.setColumnIds(columnIds);
	

    mygrid.setInitWidthsP("5,10,20,20,5,10,5,10,10,10,10");
	mygrid.setColAlign("center,left,right,right,right,right,right,right,right,right,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.setSkin("modern2");
	mygrid.setColSorting("int,str,str,str,int,str,str,date,date,int,int") ;
	mygrid.enableAlterCss("even","uneven"); 
    
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
//	mygrid.attachFooter('合计:, , , , , ',['text-align:center;','text-align:right;','text-align:right;','text-align:right;','text-align:right;','text-align:right;']);
}








