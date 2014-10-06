var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var customerProduct = new CustomerProduct();
var customer = new Customer();
var myDate = new MyDate();
var config_serviceDate;

var mygrid;

callOnLoad(init);	

function init(){
	
	channelModelParam = _app_params.sysParam.channelModelParam;
	config_serviceDate = _app_params.serviceDate.def;
	
	resetHeigth();
	
	
	 _make_adrm_sys_year_select("resource_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
    
    
	get_cur_year();

	//setCarrierTypePara(carrierType);
	setCarrierPara(carrier);
	setResourcePara(resource);
	setCustomerProductPara(customerProduct);
	setCustomerPara(customer);
	customer.getCustomerAutoComplet(payCustomerAutoComplet,customer.obj);
	//getCarrierTypeTree(carrierType); 
	//initResourceTree(carrierType);
	getDate();
	carrier.obj.nodeLevel =1;
	makeCarrierSelectItem();
	buttonEventFill();
	initGrid();
//	changeButton(false);
}

function get_cur_year(){

	var yyyy = getDayPar(config_serviceDate,'y');
	setSelectByValue($("resource_year"),yyyy);
	resource_year = $("resource_year").value;
}

function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");

	var flds = "位置,开始,结束,月份,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,标准,总规定,总使用,饱和度";
	mygrid.setHeader(flds);
	
	var columnIds = "resourceName,resourceName1,resourceName2,month,dayTimes[0]," 
					+"dayTimes[1],dayTimes[2],dayTimes[3],dayTimes[4],dayTimes[5],"
					+"dayTimes[6],dayTimes[7],dayTimes[8],dayTimes[9],dayTimes[10],"
					+"dayTimes[11],dayTimes[12],dayTimes[13],dayTimes[14],dayTimes[15],"
					+"dayTimes[16],dayTimes[17],dayTimes[18],dayTimes[19],dayTimes[20],"
					+"dayTimes[21],dayTimes[22],dayTimes[23],dayTimes[24],dayTimes[25],"
					+"dayTimes[26],dayTimes[27],dayTimes[28],dayTimes[29],dayTimes[30],"
					+"total,sumUsed,full";
	mygrid.setColumnIds(columnIds);

// mygrid.setInitWidths("100,20,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,68,68,50");
	mygrid.setInitWidthsP("5,5,5,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,6,6,6,6");
	mygrid.setColAlign("left,left,left,center,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right,right")
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed");
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
//	mygrid.enableRowsHover(true,'grid_hover')
//	mygrid.setOnRowSelectHandler(doOnRowSelected);
	mygrid.enableDragAndDrop(false);
//    mygrid.setDragHandler(do_drag);
//    mygrid.setDropHandler(do_drop);
//  mygrid.lockRow(3,true);
//mygrid.setSkin("modern2");
	mygrid.init();
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var adResCount = $("adResCount");
 
    var customerProduct_div = $("customerProduct_div");
    
    adResCount.style.height = (dialogcontent.offsetHeight -dialogcontent.offsetTop)*0.9 +"px";	

   customerProduct_div.style.height = dialogcontent.offsetHeight*0.77 + "px";
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
//	obj_tree.enableCheckBoxes(true);
//	obj_tree.enableThreeStateCheckboxes(true);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableDragAndDrop(true);
//	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
//	obj_tree.setOnDblClickHandler(doOnDblClick);//set function to call on dbl click

//    obj_tree.enableItemEditor(false);
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	
	//obj_tree.setDragHandler(doOnBeforeDrop);
	getResourceTree(obj);
}
function getResourceTree(obj){
	var getxml = function(strXML){ 
		obj.tree.dhtmlTree.loadXMLString(strXML);
	} 
	obj.reset();
	obj.obj.parentId = 0;
	obj.getTreeXMLFromMapByYear2(carrier.IdPrefix,resource.IdPrefix,resource_year,true,getxml);
}

function doOnSelect(itemId){
	        if(itemId == "root") return false;
	        var isItemChecked = carrierType.tree.dhtmlTree.isItemChecked(itemId);
		carrierType.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
}
//function doOnDblClick(itemId){
//	        var isOpenState = this.getOpenState(itemId);
//	        if(isOpenState == -1){
//	        	this.openItem(itemId);	
//	        }else{
//	        	this.closeItem(itemId);
//		}	
//}

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
	obj.selectName = obj.className+"Name";
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

function getDate(){

//    var month = theMonth-1;
//	var endDay = getMonthEndDay(theYear,month);
	
	Calendar.setup({
		inputField  : "beginDate",	  // id of the input field
//		ifFormat	: "%Y%        m%d",	  // the date format
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
//function getMonthEndDay(theYear,month){
//	//Date._MD = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
//	var days = new Array();
//	days.push(31);
//	days.push(28);
//	days.push(31);
//	days.push(30);
//	days.push(31);
//	days.push(30);
//	days.push(31);
//	days.push(31);
//	days.push(30);
//	days.push(31);
//	days.push(30);
//	days.push(31);
//	if (typeof month == "undefined") {
//		month = this.getMonth();
//	}
//	if (((0 == (theYear % 4)) && ( (0 != (theYear % 100)) || (0 == (theYear % 400)))) && month == 1) {
//		return 29;
//	} else {
//		return days[month];
//	}
//}
function closeDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "hidden";
} 
function displayDiv(ev){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
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
function buttonEventFill(){
	
	var btn_searche = $("btnSearche");
	btn_searche.onclick=displayDiv;
	
	
	var btn_searche_close=$("btnSearcheClose");
	btn_searche_close.onclick=closeDiv;
	
	
	var Btn_query = $("query");
	Btn_query.onclick =search;
	
	var Btn_view_queryAdre = $("Btn_view_queryAdre");
	Btn_view_queryAdre.onclick = btn_view_queryAdre;

	var Btn_print_queryAdre = $("Btn_print_queryAdre");
	Btn_print_queryAdre.onclick = btn_print_queryAdre;	
	
	var Btn_export_queryAdre = $("Btn_export_queryAdre");
	Btn_export_queryAdre.onclick = btn_export_queryAdre;	
	
	
	var Btn_customerName = $("customer_name");
	Btn_customerName.onkeypress= getCustomerAutoCompltByName;
	Btn_customerName.onclick = resetText;
}


function resetText(ev){
	 $("customer_name").value = null;
	 $("customerId").value = null;
}

function btn_view_queryAdre(){
	 $("model").value = "view";
	// $("reportType").value = "queryAdre_report";
	 button_print();
}	
function btn_print_queryAdre(){
	 $("model").value = "print";
	 //$("reportType").value = "queryAdre_report";
	 button_print();
}
function btn_export_queryAdre(){
	 $("model").value = "export";
	// $("reportType").value = "queryAdre_report";
	 button_print();
}
function button_print(){

	$("startDateForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endDateForm").value = getFormatDay($("overDate").value,'ymd');
	$("startTimeForm").value = $("startTime_h").value*3600+$("startTime_m").value*60;
	$("endTimeForm").value =  $("endTime_h").value*3600+$("endTime_m").value*60;
	$("customerName").value = $("customerId").value;
	$("carrierIdForm").value = $("carrierName").value;
	$("mode").value  = $("seach_type").value;
	$("type").value  = 1;
	$("resourceIdForm").value="";

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");

//	alert(22);
	reportForm.target = tarForm;
	reportForm.action="reports/jsp/queryAdress_print.jsp";
	reportForm.submit(); 	
}

function search(){
	closeDiv();
	var beginDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var startTime = $("startTime_h").value*3600+$("startTime_m").value*60;
	var endTime =   $("endTime_h").value*3600+$("endTime_m").value*60;
	var customerId = $("customerId").value;
	var carrierId = $("carrierName").value;
	var mode = $("seach_type").value;
		var mode = $("seach_type").value;
var orderBy =2;
		if(beginDate != '' && endDate != ''){
			if(beginDate > endDate){
				alert("开始日期不能大于结束日期");
				return false;
			}
			
			var func = function(xml){
			    	mygrid.clearAll();
				mygrid.loadXMLString(xml);
				setFontColor();
			}

		customerProduct.getResourceLimit61(beginDate,endDate,startTime,endTime,carrierId,customerId,mode,orderBy,func);
			
		}else{
			alert("请选择日期");
		}
}


function  setFontColor(){
	var mode = $("seach_type").value;
	var rows = mygrid.getRowsNum();
	if(mode =="1"){
		for(var i=0;i<rows-1;i++){
			var standTime = mygrid.cells2(i,33).getValue();
			
			for(var j=2;j<33;j++){
				var usedTime = mygrid.cells2(i,j).getValue()*1;
				
				var dayStandard =  mygrid.getUserData(mygrid.getRowId(i),"dayStandard"+(j-2))*1;
				
				if(dayStandard - usedTime < 0 && dayStandard>0){
				  	mygrid.cells2(i,j).setTextColor("red");
				}
				if(dayStandard - usedTime > 0 && usedTime>0){
				  	mygrid.cells2(i,j).setTextColor("green");
				}
				
				if(dayStandard - usedTime == 0 && usedTime>0){
				  	mygrid.cells2(i,j).setTextColor("black");
				}
				
			}
		}	
	}else{
		for(var i=0;i<rows-1;i++){
			var standTime = mygrid.cells2(i,33).getValue();
			
			for(var j=2;j<33;j++){
				var usedTime = mygrid.cells2(i,j).getValue()*1;
				
				var dayStandard =  mygrid.getUserData(mygrid.getRowId(i),"dayStandard"+(j-2))*1;
				
				if(usedTime < 0 && dayStandard>0){
				  	mygrid.cells2(i,j).setTextColor("red");
				}
				if(usedTime > 0 && dayStandard>0){
				  	mygrid.cells2(i,j).setTextColor("green");
				}
				
				if(dayStandard == usedTime && dayStandard>0){
				  	mygrid.cells2(i,j).setTextColor("black");
				}
				
			}
		}		
	
	
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
	var hidenColumName = ["id","customerCategoryId","helpCode"];
	var allColumsTitle = ["客户名称","客户类别"];
	
	var onDivMouseDown_customerId = function(ev){

		var tr = getElementByEvent(ev);
		$("customerId").value = getCellValue(tr,0);
		oText.value = getCellValue(tr,2);
	}
	
	var onTextBlur = function(ev){

		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("customerId").value = '';
		}
	}
   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown_customerId,onTextBlur,hidenColumName,indexColumName_customerName,allColumsName_customerName,allColumsTitle);

}

