var carrier =new  Carrier();
var carrierType = new CarrierType();
var resource = new Resource();
var analyzeClass = new AnalyzeClass();

callOnLoad(init);

function init(){
	
	channelModelParam = _app_params.sysParam.channelModelParam;
	initGrid();
	setCarrierTypePara(carrierType);
	setCarrierPara(carrier);
	setResourcePara(resource);
	setAnalyCarrierMatter(analyzeClass);
	getCarrierTypeTree(carrierType);
	getDate();
	
	buttonEventFill();
	resetHeigth();
}
function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	
	var flds = "广告名称,投放时长,投放金额";
	mygrid.setHeader(flds);
	var columnIds = "matter,times,money";
	mygrid.setColumnIds(columnIds);
	

    mygrid.setInitWidthsP("50,25,25");
	mygrid.setColAlign("left,right,right");
	mygrid.setColTypes("ed,ed,ed");
    
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	 //mygrid.enableLightMouseNavigation(true);
//	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
	mygrid.enableDragAndDrop(false);
	
    // mygrid.setOnRowSelectHandler(getOrderDetail);
      // mygrid.setOnRowSelectHandler(onRowSelectd);
//        mygrid.setOnBeforeRowDeletedHandler(onBeforeRowRemove);
//    mygrid.setOnRowDblClickedHandler(doOnReturn);
       mygrid.setSkin("modern2");
	mygrid.init();	 
}
//function onRowSelectd(rowId,colIndex){
//	
//	var rowIndex = mygrid.getRowIndex(rowId);
//	drawColorOrderDetailTable(rowIndex);
//
//}
//function drawColorOrderDetailTable(rowIndex){
//		
//     var trnum = mygrid.getRowsNum();
//     var cssText;
//     var cssTextSelected = "BACKGROUND-COLOR:#CCCCCC;CURSOR: pointer;";
//     for (var i = 0;i<trnum;i++){
//          if(i%2 == 0){
//          	cssText = "BACKGROUND-COLOR: #ECEFF4;CURSOR: pointer;";
//          }else{
//        	cssText = "BACKGROUND-COLOR: #f5f5f5;CURSOR: pointer;";
//	  }
//	  var rowId = mygrid.getRowId(i);
//	  mygrid.setRowTextStyle(rowId,cssText);	
//     }	
//     
//     if(trnum>0){
//          var curRowId = mygrid.getRowId(rowIndex);
//	     //alert(curRowId);
//	     mygrid.setRowTextStyle(mygrid.getRowId(rowIndex),cssTextSelected);	
//     }
//}
function setAnalyCarrierMatter(obj){
	 obj.className ="analyzeClass";
	 obj.IdPrefix = obj.className + "Id";
	 obj.fillObjName = "analyCarrierMatterBody";
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.pageSize 	= "10000";
	 obj.pageInfo 	= "pageInfoAnalyCarrierMatter";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}
function hiddenTableProty(){
	$("analyCarriermatter_div").style.cssText="position:relative;OVERFLOW: auto;width:880px;visibility:hidden;border:solid white 2px;background-color:#f5f5f5;z-index:1";
	resetHeigth();
}
function displayTableProty(){
	$("analyCarriermatter_div").style.cssText="position:relative;OVERFLOW: auto;width:880px;visibility:show;border:solid white 2px;background-color:#f5f5f5;z-index:1";
	resetHeigth();
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
function setCarrierTypePara(obj){
	obj.className  = "carrierType";
	obj.IdPrefix   = obj.className + "Id";
	obj.treebox	   = obj.className + "Treebox";
	obj.tree = new Tree(obj.treebox); 
}
function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("carrierTypeTreebox");
    var carrierScopeAnalyze_div = $("analyCarriermatter_div");
        
    var Btn_Search = $("search");
    var v = Btn_Search.offsetHeight*4;
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	
    carrierScopeAnalyze_div.style.height = 	treebox.style.height;
} 
function getCarrierTypeTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	obj.reset();
	obj.obj.parentId = 0;
	//obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
	//分频道显示树
	if(channelModelParam!=1){
			obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
	}else{
			obj.getTreeXMLForChannel(carrier.IdPrefix,resource.IdPrefix,channelModelParam);
	}
	
	obj_tree.loadXMLString(obj.tree.treeXML);
}
function doOnSelect(itemId){
	        if(itemId == "root") return false;
	        var isItemChecked = carrierType.tree.dhtmlTree.isItemChecked(itemId);
		carrierType.tree.dhtmlTree.setSubChecked(itemId,!isItemChecked);
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
	$("beginDate").value = getFormatDay(_app_params.serviceDate.year+'0101','y/m/d');
	$("overDate").value= getFormatDay(_app_params.serviceDate.year+'1231','y/m/d');
}

function buttonEventFill(){
	var btn_search=$("search");
	btn_search.onclick=search;
	
	var btn_displayChar=$("displayChar");
	btn_displayChar.onclick=displayChar;
	
	var Btn_view_order = $("Btn_view_order");
	Btn_view_order.onclick = button_view_order;

	var Btn_print_order = $("Btn_print_order");
	Btn_print_order.onclick = button_print_order;	
	
	var Btn_export_order = $("Btn_export_order");
	Btn_export_order.onclick = button_print_export;	
	
	
}

function button_view_order(){
	 $("model").value = "view";
	 $("reportType").value = "analyCarrierMatter_report";
	 button_print();
}
function button_print_order(){
	 $("model").value = "print";
	 $("reportType").value = "analyCarrierMatter_report";
	 button_print();
}
function button_print_export(){
	 $("model").value = "export";
	 $("reportType").value = "analyCarrierMatter_report";
	 button_print();
}
function button_print(){
	
	$("resourceIdForm").value = getBuildResourceIds();
	$("startForm").value = getFormatDay($("beginDate").value,'ymd');
	$("endForm").value = getFormatDay($("overDate").value,'ymd');

	var tarForm =  $("tarForm");
	var reportForm = $("ReportForm");
	
	reportForm.target = tarForm;

	reportForm.action="reports/jsp/analyCarrierMatter_report.jsp";
	reportForm.submit(); 	
}
function displayChar(){
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	var resourceIds = getBuildResourceIds();
	if(resourceIds == null) {
		alert("请选择资源后进行查询");
	}else{
		parent.location.href ="analyCarrierMatterChart.html?startDate=" + startDate + "&" + endDate+"$" + resourceIds;
	}
}
function getBuildResourceIds(){
	var allCheckedIds = carrierType.tree.getAllCheckedBranches(resource.IdPrefix);
	var selectId =  carrierType.tree.dhtmlTree.getSelectedItemId();
	var myIds = carrierType.tree.dhtmlTree.getAllSubItems(selectId);
	var resourceIds = new Array();
	var all = myIds.split(",");
//	alert(all.length);
	for(var i = 0; i< allCheckedIds.length;i++){
		for(var j=0;j<all.length;j++){
			var onemyId = all[j].substring(10,all[j].length);
//			if(myIds.indexOf(allCheckedIds[i]) >-1)
			if(onemyId==allCheckedIds[i])
				
			 resourceIds.push(allCheckedIds[i]);
			}
	}
//	alert("3   "+myIds);
//	alert("1   "+allCheckedIds);
//	alert("2   "+selectId);
//	alert("4   "+resourceIds);
	return resourceIds;
}
function search(){
//getSelectedItemId(carrier.IdPrefix);		
//	var userId = $(user.selectName).value==0?null:$(user.selectName).value;
//	var carrierName = $("carrierName").value==0?null:$("carrierName").value;

	
	var resourceIds = getBuildResourceIds();
	var startDate = getFormatDay($("beginDate").value,'ymd');
	var endDate = getFormatDay($("overDate").value,'ymd');
	
	if(startDate !=null && endDate !=null){
		
	    if(resourceIds != null){
	    	
	    	var func = function(xml){
//				analyzeClass.fillTable(objs);
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				Ext.getBody().unmask();
			
		}
	    	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
			analyzeClass.getAnalyCarrierMatterByDate(startDate,endDate,resourceIds,func);  
		
	    }else{
	        alert("请选择资源后进行查询");
	    }
	}
}