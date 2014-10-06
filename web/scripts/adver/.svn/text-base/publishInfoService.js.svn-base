var mygrid;
var carrierType = new CarrierType();
var resource = new Resource();
var carrier = new Carrier();
var publishedInfo = new PublishedInfo();


callOnLoad(init);

function init(){
	
	$("bro_date").value =  _app_params.serviceDate.format1;;
	
	setCarrierTypePara(carrierType);
	setResourcePara(resource);
	setCarrierPara(carrier);
	setPublishedInfo(publishedInfo);
	
	getCarrierTypeTree(carrierType);
	
	init_Grid();
	buttonEventFill();
	
	resetHeigth();
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("carrierTypeTreebox");
    var bro_date = $("bro_date");
	var gridbox = $("gridbox");
    
    var v = bro_date.offsetHeight*7;
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	
    
    gridbox.style.height = treebox.offsetHeight *1.2 + "px";	
} 

function buttonEventFill(){
	
	var Btn_build_bro = $("Btn_build_bro");
	Btn_build_bro.onclick=button_build_bro;
	
	var Btn_save_bro = $("Btn_save_bro");
	Btn_save_bro.onclick=removePublishInfo;
	
	var Btn_print_bro = $("Btn_print_bro");
	Btn_print_bro.onclick=button_print_bro;

	var Btn_preView_bro = $("Btn_preView_bro");
	Btn_preView_bro.onclick=button_preView_bro;	
}

function getDate(){
	Calendar.setup({
		inputField  : "bro_date",	  // id of the input field
		ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "bro_date"	// id of the button
	});
}

function setCarrierTypePara(obj){
	 obj.className  = "carrierType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}
function setResourcePara(obj){
	 obj.className  = "resource";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setCarrierPara(obj){
	 obj.className  = "carrier";
	 obj.IdPrefix 	= obj.className + "Id";
}
function setPublishedInfo(obj){
	 obj.className  = "publishedInfo";
	 obj.IdPrefix 	= obj.className + "Id";
}

function getCarrierTypeTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(false);
	obj.reset();
	obj.obj.parentId = 0;
	obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
	obj_tree.loadXMLString(obj.tree.treeXML);
}


function init_Grid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
	var flds = "序号,播出时段,播出时间,时长,广告内容";
	mygrid.setHeader(flds);
	mygrid.setInitWidths("50,100,100,80,615");

    mygrid.enableLightMouseNavigation(true);
	mygrid.setColAlign("center,center,center,center,left");
	mygrid.setColTypes("ed,ed,ed,ed,ed");
    mygrid.setColTypes("ro,ro,ro,ro,ro");
    mygrid.setMultiLine(false);
	mygrid.setOnGridReconstructedHandler(setRow_style);
	mygrid.setDragBehavior("complex");
	
	mygrid.enableDragAndDrop(true);

	mygrid.init();	
}



//给行上色
function setRow_style(){
	var rowCount = mygrid.getRowsNum();
	for (var i=0;i<rowCount;i++){
		var row_id = mygrid.getRowId(i);
		var type = getRowCellData(row_id,0);
		var cssText="";
		if(i%2 == 0) { cssText="BACKGROUND-COLOR: #ECEFF4"}else{cssText="BACKGROUND-COLOR: #66FF00"};
			
		mygrid.setRowTextStyle(row_id,cssText);
	}
}
function getRowCellData(row_id,col){
	return mygrid.cells(row_id,col).getValue();
}
function getGridXML(gridXML){ 
	if(gridXML !=''&&!isUndefined(gridXML)) {
		loadGrid(gridXML); 
	}else{
		mygrid.clearAll();
		alert("这一天无相关的广告数据!");
	}
}  
function loadGrid(gridXML){

	mygrid.clearAll();
	mygrid.loadXMLString(gridXML,setRow_style);
}	
//建立前先判断是否已经编排过，如果有则提示是否重新编排	
function button_build_bro(){
	var resourceIds= getCheckedresourceIds();
	var dateStr = $("bro_date").value;
	
	if(resourceIds == ''){
		alert("请选择广告资源!");
		return false;
	}else{
		//建立前先判断是否已经编排过，如果有则提示是否重新编排
		var func = function(count){
			build_bro(count);	
		}
		
		publishedInfo.getPublishedCount(resourceIds,dateStr,func);
	}
}
function build_bro(count){
	var resourceIds= getCheckedresourceIds();
	var dateStr = $("bro_date").value;

	var model =0;

	if(count>0)	{
			if(confirm("这一天已经编排过，是否重新编排?")){
				model = 0;	
			}else{
				model = 1;	
			}
	}else{
			model = 0;	
	}
	
	var func = function(gridXML){
		
		getGridXML(gridXML);
	}
	
    publishedInfo.getInfosByResourceIdsXML(resourceIds,dateStr,model,func);	

}
function getCheckedresourceIds(){
	var obj_tree = carrierType.tree.dhtmlTree;
	
  	var list = obj_tree.getAllChecked();
  	var resourceIds='';
  	
  	if(list != ''){
		var ids = list.split(",");
		var size = ids.length;
		for (var i=0;i<size;i++){
			var idStr = ids[i];
			var  intIndex = idStr.search('re');
			if (intIndex > -1){
				 var id = carrierType.tree.getIdByPrefix(idStr,resource.IdPrefix);
				 
				 resourceIds += id +",";
			}
		}
//		alert(resourceIds);
		return resourceIds;
  	}else{
  		return '';
  	}
}

function removePublishInfo(){
  	var resourceIds= getCheckedresourceIds();
  	var broDate = $("bro_date").value;
  	
  	if(resourceIds !=''){
  		
  		var func = function(){
  			savePublishInfo();
  		}
  		
  		publishedInfo.removePublishedInfosByResDate(resourceIds,broDate,func);
  	}
}	

function savePublishInfo(){
  	var RowsNum = mygrid.getRowsNum();
	var range = $R(0, RowsNum, true);
	
	DWREngine.beginBatch(); 	
	
	range.each(function(value, index){
		var row_id = mygrid.getRowId(value);
		var publish = setGridToObj(row_id);
		
		
		
		var func = function(){}
		publishedInfo.savePublishedInfo(publish,func);
	});	 

    DWREngine.endBatch();  
}

function setGridToObj(row_id){ 

	
  	publishedInfo.publishOrder = getRowCellData(row_id,0);
	publishedInfo.publishDate = mygrid.getUserData(row_id,"publishDate");
	publishedInfo.orderId 	   = mygrid.getUserData(row_id,"orderId");
	publishedInfo.adverMatterId = mygrid.getUserData(row_id,"adverMatterId");
	publishedInfo.carrierId = mygrid.getUserData(row_id,"carrierId");
	publishedInfo.resourceType = mygrid.getUserData(row_id,"resourceType");
	publishedInfo.orderDayInfoId = mygrid.getUserData(row_id,"orderDayInfoId");
	publishedInfo.linkUserId = mygrid.getUserData(row_id,"linkUserId");
	publishedInfo.customerId = mygrid.getUserData(row_id,"customerId");
	publishedInfo.tapeCode = mygrid.getUserData(row_id,"tapeCode");
	publishedInfo.matterName = mygrid.getUserData(row_id,"matterName");
	publishedInfo.matterEdit = mygrid.getUserData(row_id,"matterEdit");
	publishedInfo.matterLength = mygrid.getUserData(row_id,"matterLength");
	publishedInfo.appPosition = getRowCellData(row_id,3);
	publishedInfo.linkUser = mygrid.getUserData(row_id,"linkUser");
	publishedInfo.customerName = mygrid.getUserData(row_id,"customerName");
	publishedInfo.adResourceId = mygrid.getUserData(row_id,"resourceId");
	publishedInfo.resourceCarrier = mygrid.getUserData(row_id,"resourceCarrier");
	publishedInfo.orderCode = mygrid.getUserData(row_id,"orderCode");
	//修改添加的
	publishedInfo.publishMemo = getRowCellData(row_id,2);	
	publishedInfo.position = getRowCellData(row_id,1);
	publishedInfo.adContent = getRowCellData(row_id,4);
	
	return publishedInfo;
}

function button_preView_bro(event){
	var obj_tree = carrierType.tree.dhtmlTree;
	var resourceIds = getCheckedresourceIds();
	var publishDate = $("bro_date").value;
	
	var selectId = obj_tree.getSelectedItemId();
	var type = getNodeType(selectId);

	if (type != 2){
		alert("请选择载体名称,做为报表的标题.");
		return false;
	}
	
	if(mygrid.getRowsNum()<1){
		alert("没有需要打印的数据");
		return false;
	}
	
	var carrierName = obj_tree.getSelectedItemText().replace(/ +/g,"");

	if(resourceIds !='' && publishDate !=''){
	
		$("action").value= "preView";
					
		$("carrierName").value= carrierName;
		$("resourceIds").value= resourceIds;
		$("publishDate").value = publishDate;
		
		var reportForm = $("ReportForm");
		reportForm.target = tarForm;
		reportForm.action="reports/jsp/info_preView.jsp";
		reportForm.submit();        	
	}
}

function getNodeType(itemId){
  	var obj_tree = carrierType.tree.dhtmlTree;
	return obj_tree.getUserData(itemId,"type");
}	

function button_print_bro(){
	var obj_tree = carrierType.tree.dhtmlTree;
    var resourceIds = getCheckedresourceIds();
    var publishDate = $("bro_date").value;
    
    var selectId = obj_tree.getSelectedItemId();
    var type = getNodeType(selectId);

    if (type != 2){
    	alert("请选择载体名称,做为报表的标题.");
    	return false;
    }
    
    if(mygrid.getRowsNum()<2){
    	alert("没有需要打印的数据");
    	return false;
    }

    var carrierName = obj_tree.getSelectedItemText().replace(/ +/g,"");
    
    
    if(resourceIds !='' && publishDate !=''){

        $("action").value= "print";
        $("carrierName").value= carrierName;
        $("resourceIds").value= resourceIds;
        $("publishDate").value = publishDate;
        
        var reportForm = $("ReportForm");
        reportForm.target = tarForm;
        reportForm.action="reports/jsp/info_print.jsp";
	    reportForm.submit();        	
    }
}

