var carrierType = new CarrierType();
var carrier =new  Carrier();
var resource = new Resource();
var customerProduct = new CustomerProduct();
//var customer = new Customer();
var resource_year;
var config_serviceDate;
var fusionCharts = new Charts();
var fusionChartObjects;
var contPath;
var chartWidth = 0;
var chartHeight = 0;

callOnLoad(init);	

function init(){
	var srcStr = window.location.href;
		winW = getParamFromUrl(srcStr,"winW");
		winH = getParamFromUrl(srcStr,"winH");
		if(winW == null) winW = 1200;
		if(winH == null) winH = 600;
		
		    _make_org_select("orgId",120,"getResourceTree");	
		    
//	winHeight = self.innerHeight*0.93; 
//	winWidth = self.innerWidth*0.98;
//	getServiceDate();
	config_serviceDate =_app_params.serviceDate.def;
	resource_year = _app_params.serviceDate.year;
    channelModelParam = _app_params.sysParam.channelModelParam;
//	get_cur_year();

	setCarrierTypePara(carrierType);
	setCarrierPara(carrier);
	setResourcePara(resource);
	initResourceTree(carrierType);
	
	getDate();
	
	buttonEventFill();
 	resetHeigth();
// 	$("btn_display").hide();
//	$("btn_hidden").show();
	
	contPath = $F("contPath");
	
	$("caption").value = "资源查询";
	
	//如果 args2="" 则不显示
//	var  args2 ="占用时长,剩余时长,超出时长";
//	fusionCharts.makeColunmCheck($("clums"),"clums2",args2,true);

	var defChartType = "scrollstackedcolumn2d";
	fusionCharts.makeStyleCommand($("chartTypeDiv"),"chartType",100,defChartType);
	
	var defFontSie = "12";
	fusionCharts.makeFontSizeCommand($("baseFontSizeDiv"),"baseFontSize",40,defFontSie);
    
    //加载时就获得所有数据
	//getFusionChartObjects();
}

function replaceCaption() {
        var caption = window.prompt("请输入新标题如果有子标题请用逗号隔开","");
        $("caption").value = caption;
        renderFromQS();
  }
//图表部分
//*********
function getFusionChartObjects(){

	function func(objs){
		fusionChartObjects = objs;
		renderFromQS();
	}

	var resourceIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	if(resourceIds != null && resourceIds!=''){
		var searchDate = getFormatDay($("searchDate").value,'ymd');

		
//		changeButtonHidden();
		FusionChartsManager.getResourceChartObjs(resourceIds,searchDate,func);
	}else{
		alert("请选择要查询的广告资源!");
	}
	
 	
}
function buildCustomXML(){
	var customXML ="";
	
   customXML ="<styles>"
      customXML +="<definition>";
         customXML +="<style name='myFont' type='font' isHTML='1' bold='1' size='15' color='333333' />";
         customXML +="<style name='myShadow' type='shadow' color='333333' angle='45' strength='2'/>";
      customXML +="</definition>";
      customXML +="<application>";
         //customXML +="<apply toObject='YAxisValues' styles='myFont,myShadow' />";
         //customXML +="<apply toObject='DataLabels' styles='myFont,myShadow' />";
        // customXML +="<apply toObject='DataValues' styles='myFont,myShadow' />";
         customXML +="<apply toObject='Caption' styles='myFont,myShadow' />";
      customXML +="</application>";
   customXML +="</styles>";
   
	return customXML;
}


function renderFromQS(){
	var FCharts = new Charts();
	//chart属性
	FCharts.Chart.objs = fusionChartObjects;
	FCharts.Chart.transparent = "fasle" //true>>transparent false>>Opaque 
	FCharts.Chart.name = "myChart";
	FCharts.Chart.chartdiv = "chartdiv";
	FCharts.Chart.contPath = contPath;
	FCharts.Chart.chartType = "scrollcombidy2d";
	FCharts.Chart.chartWidth = chartWidth;
	FCharts.Chart.chartHeight = chartHeight;
	FCharts.Chart.imageSave = 1;
	FCharts.Chart.imageSaveURL = contPath+"fusionChartsSave";
	FCharts.Chart.customXML = buildCustomXML(); //自定义风格

	//chart参数
	//labelDisplay='WRAP'
	//labelDisplay='ROTATE'
	//labelDisplay='Rotate' slantLabels='1'
	//labelDisplay='Stagger' staggerLines='n' caption
	var captions =  ($("caption").value).split(",");
	var caption ="";var subCation ="";
	if(!isUndefined(captions[0])) caption = captions[0];
	if(captions.length >1) subCation = captions[1];
	
	FCharts.ChartParams.caption = caption; 
	FCharts.ChartParams.subCaption = subCation;
	FCharts.ChartParams.labelDisplay = "WRAP";
	FCharts.ChartParams.slantLabels = 5;
	FCharts.ChartParams.baseFontSize = 12; 
	FCharts.ChartParams.showValues = $("showValues").checked == true?0:1;
//	FCharts.ChartParams.bgColor = "FFFFFF";
	
	
	//Data 及 lable 
	//列名
	FCharts.LabelsData.cols =["","占用时长","剩余时长","超出时长"];
	//显示列
	FCharts.LabelsData.displays = ['false','true','true','true'];
	//alert(z.getSelectedValue());
	//parentYAxis=P
	FCharts.LabelsData.parentYAxisP = [1,2,3];
	//parentYAxis=S
	FCharts.LabelsData.parentYAxisS =[ ];	

	FCharts.buildFusionCharts();
}

	function saveChart(){
         //Get chart from its ID
         var chartToPrint = getChartFromId("myChart");
         chartToPrint.saveAsImage();
      }


	function printChart(){
		//Get chart from its ID
		var chartToPrint = getChartFromId("chart1Id");
		chartToPrint.print();
	}
	

	
function showHidden(){
	var oDiv = $("clums2");	
	var display = !(oDiv.style.visibility == "hidden")
	oDiv.style.visibility = display?"hidden":"visible";
	
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

function resetHeigth(){ 
    var adResCount = $("adResCount");
    var carrierTypeTreebox = $("carrierTypeTreebox");
    var chartdiv = $("chartdiv");
    
    adResCount.style.height = winH*0.82 +"px";	
    carrierTypeTreebox.style.height = winH*0.82 +"px";	
    chartdiv.style.height = winH * 0.85 +"px";		
    chartWidth = chartdiv.offsetWidth;
	chartHeight = chartdiv.offsetHeight;
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
	obj.obj.orgId = $("orgId").value;
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

function getDate(){
	
	Calendar.setup({
		inputField  : "searchDate",	  // id of the input field
//		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "searchDate"	// id of the button
	});

	//$("searchDate").value = getFormatDay(myDate.getNewDayStartDay1(config_serviceDate),'y/m/d');
	$("searchDate").value = getFormatDay(config_serviceDate,'y/m/d');
}

function buttonEventFill(){
//	var btn_search=$("searchRes");
//	btn_search.onclick=getFusionChartObjects;
	
	var change_resource_year = $("searchDate");
	change_resource_year.onchange = rest_resource_tree;
}

function rest_resource_tree(){
	 var searchDate = $("searchDate").value.substring(0,4);
	 if(resource_year==searchDate) return false;
	 resource_year = searchDate;
	 reLoadTree(carrierType);
}	

function reLoadTree(obj){
	obj.tree.dhtmlTree.deleteChildItems(0);
	getResourceTree(obj);
}

function resetText(ev){
	 $("customer_name").value = null;
	 $("customerId").value = null;
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

