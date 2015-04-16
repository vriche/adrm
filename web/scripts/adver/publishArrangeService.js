var mygrid;
var carrierType = new CarrierType();
var resource = new Resource();
var carrier = new Carrier();
var arrange = new PublishArrange();
var detail = new PublishArrangeDetail();
var user = new User();
var order = new Order();
var matter = new Matter();
var matterType = new MatterType();
var curUserId;
var curUserName;
//var publishOld = 0;
var config_stridePositionParam; //是否跨段位调整广告
var config_specArowMoveParam;   //有指定也允许调整
var config_piblishModelParam;   //编播出单格式	
var config_serviceDate;
var right_brosave = 0;
var treeObj;
var rowIds=[];
var userName;
var report = new MyPrint();


callOnLoad(init);

function init(){
	
	

	srcStr = window.location.href;
	
    tvNameParam =  _app_params.sysParam.tvNameParam;
    config_stridePositionParam =  _app_params.sysParam.stridePositionParam;
    config_specArowMoveParam =  _app_params.sysParam.specArowMoveParam;
    config_piblishModelParam =  _app_params.sysParam.piblishModelParam;
    
    	tag_publish_arrange =  _app_params.rights.tag_publish_arrange;
    	tag_publish_arrangeforce =  _app_params.rights.tag_publish_arrangeforce;
    
	config_serviceDate = _app_params.serviceDate.def;
	userName =   _app_params.user.fullName;
	curUserName =  _app_params.user.username;
	curUserId=  _app_params.user.id;
	
	
//	config_withResourceSort = $("config_withResourceSort").value;


 
    _make_org_select("orgId",120,"reload");	
    
    config_oneOrgMoreSuborgsParam= _app_params.sysParam.oneOrgMoreSuborgsParam;
    if(config_oneOrgMoreSuborgsParam == '1'){$('orgId').hide();}	
	
	$("bro_date").value =  _app_params.serviceDate.format1;
	$("bro_date_history").value = _app_params.serviceDate.format1;
	
	

//	if(tvNameParam =='fztv' && srcStr.indexOf("publishDate")>0){
//			publishDate = getParamFromUrl(srcStr,"publishDate");
//			$("bro_date").value = getFormatDay(publishDate,'y/m/d'); ;
//			$("buttonImport").show();
//	}else{
		$("buttonImport").hide();
//	}
	
//	if(tvNameParam ='fztv' ){
//		$("buttonImport").style="display:block";
//	}else{
//		$("buttonImport").style="display:none";
//	}
	
	
	
	
	setCarrierTypePara(carrierType);
	setResourcePara(resource);
	setCarrierPara(carrier);
	setUserPara(user);
	setPublishedInfo(arrange);
	setPublishArrangeCol(arrange);
	setPublishArrangeDetailCol(detail);
	setMatterPara(matter);
	setMatterTypePara(matterType);
	getCarrierTypeTree(carrierType);
	getMatterTypeTree(matterType);

	initGrid();
	buttonEventFill();
//	isDisplay(true);
	resetHeigth();
	getDate("bro_date","bro_date");
//	$("bro_date").value = curDate;
//	$("bro_date_view").value = myFormatDate(curDate);
	
//	publishOld=$("bro_date").value;



    
//    if(tvNameParam=='fztv'){
//    	$('buttonImport').hide(); 
//    }
    
    
     if(tvNameParam !='hntv' || tvNameParam !='fztv'){
     	$('Btn_removeRow').show(); 
     }
    
  	this.ctxPath = _app_params.ctxPath;
	this.report.buildButtons(this,"printReportDiv",[0,1,2],70); 
    
    document.oncontextmenu=function stop(){return false;};
}
   function reload(){
    	loadCarrTree();
    	getMatterTypeTree();
    }
function getContractPayMentsAutoComplete(){
	var payment = new PayMent();
	payment.obj.version=config_serviceDate.substr(0,4); 
	payment.getContractPaymentAutoComplet(payment,contractCodeAutoComplete);
}
function getCellValues(row,cellIndex){
	var cells =  row.getElementsByTagName("td");
	for(var i = 0;i < cells.length; i++){ 
		if( i == cellIndex) return cells[i].innerHTML;
	}
}
function contractCodeAutoComplete(objs)
{
	var oText = $("contractCode");
	var oDiv = $("theDiv");
	var hidenColumName = ["id","contractId","customerId","customerCategoryId","contractMoneySum","contractSort"];
	var indexColumName = ["contractCode","payDate","id","customerId","contractSort"];
	var allColumsName =["id","contractId","contractCode","payDate","moneyPay","customerId","customerName","customerCategoryId","contractMoneySum","contractSort"];
	var allColumsTitle = ["合同编号","付款日期","付款金额","客户名称"];
	
	var onDivMouseDown = function(ev){
		var tr = getElementByEvent(ev);
		$("paymentId").value = getCellValues(tr,0);
		$("contractId").value = getCellValues(tr,1);
		$("moneyPay").value = getCellValues(tr,4);
		$("customerId").value = getCellValues(tr,5);
		$("customerName").value = getCellValues(tr,6);
		$("userId").value = curUserId ;  
		oText.value = getCellValues(tr,2);
		$("publishDates").value = getFormatDay($("bro_date").value,'ymd');
		$("carrierIds").value = carrierType.tree.dhtmlTree.getSelectedItemId();
	}
	
	var onTextBlur = function(ev){
		oDiv.style.visibility = "hidden";
		
		if(trim(oText.value) == "" ){
			$("paymentId").value = "";
			$("contractId").value = "";	
		    $("moneyPay").value = 0;
		    $("customerName").value ="";
		}else{
			var paymentId =$("paymentId").value;
			if(paymentId == ''){
				alert("请选择合同号的下拉列表！")
			}
		}
	}

   new AutoComplete(objs,oText,oDiv,-1,onDivMouseDown,onTextBlur,hidenColumName,indexColumName,allColumsName,allColumsTitle);
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
	var treebox = $("carrierTypeTreebox");
	var tree_box = $("matterTypeTreebox");
	var bro_date = $("bro_date");
	var gridbox = $("gridbox");
	var build_bro= $("Btn_build_bro");
//	var bro_table_div= $("bro_table_div");
	

	
//	var r = getAbsolutePos(gridbox);
//	var b = getAbsolutePos(build_bro);


	var v = bro_date.offsetHeight*6;
	treebox.style.height = dialogcontent.offsetHeight*0.85 +"px";	
	tree_box.style.height =treebox.style.height;
	gridbox.style.height = tree_box.style.height;	
	
	mygrid.setSizes();	 
	
//	alert(gridbox.style.height);
	
//	treebox.style.width = gridbox.offsetWidht*0.5+ "px";	
//	tree_box.width = treebox.width;

} 


function getCarrierTypeTree(obj){
	var obj_tree = obj.tree.dhtmlTree;	
//	obj_tree.enableCheckBoxes(true);
//	obj_tree.enableThreeStateCheckboxes(true);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableDragAndDrop(false);
//	obj_tree.setDragBehavior("nextSibling"); //nextSibling complex
//	
//	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
//	obj_tree.setOnDblClickHandler(doOnDblClick);//set function to call on dbl click


//    obj_tree.enableItemEditor(false);
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	obj_tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
	
    loadCarrTree();
	
}

function loadCarrTree(){
	var obj = carrierType;
	var obj_tree = obj.tree.dhtmlTree;	
	var publishDate = getFormatDay($("bro_date").value,'ymd');
	
	obj.reset();
	obj.obj.orgId = $("orgId").value;
	obj.obj.parentId = 0;
//	obj.getTreeXML(carrier.IdPrefix,resource.IdPrefix);
//	obj.getTreeXMLForArrange(carrier.IdPrefix,resource.IdPrefix);
	var fuc = function(xml){
		if(obj_tree.getSubItems(0) == 'root'){
			obj_tree.deleteChildItems(0);	
		}
		obj_tree.loadXMLString(xml);
//		if(tvNameParam =='fztv' &&srcStr.indexOf("publishDate")>0){ 
//			var carrierId = getParamFromUrl(srcStr,"carrierId");
//			if(carrierId!=''){				               
//					obj_tree.selectItem(carrierId);
//					doOnSelect(carrierId);
//					button_build_bro();
//			}
//		}
		
		Ext.getBody().unmask();
	}
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	obj.getTreeXMLForArrange(carrier.IdPrefix,resource.IdPrefix,publishDate,fuc);
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

function setMatterTypePara(obj){
	 obj.className  = "matterType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
	 treeObj = obj.tree.dhtmlTree;
}

//function setDate(){
//	var v = $("bro_date").value;
//	$("bro_date_view").value = myFormatDate(v);
//}

function setPublishArrangeCol(obj){
//	if(tvNameParam =='fztv'){
//			obj.col_resName = 2;
//			obj.col_resMeno = 3;
//			obj.col_resTotalTimes = 6;
//	}else{
			obj.col_resName = 1;
			obj.col_resMeno = 2;
			obj.col_resTotalTimes = 3;
//	}
//	obj.col_resName = 1;
//	obj.col_resMeno = 2;
	obj.col_2 = 0;
//	obj.col_resTotalTimes = 3;
	obj.col_resUsedTimes = 4;
	obj.col_resLeave = 5;
	obj.col_6 = 6;
	obj.col_7 = 7;
	obj.col_meno = 8;
	obj.col_resId = 9;
	obj.col_filePath = 10;
	obj.col_createBy = 11;
	obj.col_createDate = 12;
	obj.col_id = 13;
	obj.col_isLocked = 14;     
	obj.col_beforehand = 16;     
}

function setPublishArrangeDetailCol(obj){
	obj.col_publishSort = 0;
	obj.col_tapeCode = 1;
	obj.col_matterName = 2;
	obj.col_matterEdit = 3;
	obj.col_matterLength = 4;
	obj.col_specificName = 5;
	obj.col_publishMemo = 6;	
	obj.col_specificValue = 7;
	obj.col_orderDayId = 8;
	obj.col_resourceId = 9;
	obj.col_customerName = 10;
	obj.col_ownerUserName = 11;
	obj.col_id = 12;
	obj.col_isArranged = 13;
	obj.col_isLocked = 14;
//    obj.col_ownerUserId = 15;
    
}
function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		button_view_bro();
	}
	if(mode =="print"){
		button_print_bro();
	}
	if(mode =="excel"){
		button_export_bro();
	}
	   
}

function buttonEventFill(){

	var Btn_build_bro = $("Btn_build_bro");
	Btn_build_bro.onclick = button_build_bro;
	
	var Btn_save_bro = $("Btn_save_bro");
	if(!isUndefined(Btn_save_bro)){
		Btn_save_bro.onclick = savePublishArrange;
	}
	
	
//	var Btn_print_bro = $("Btn_print_bro");
//	Btn_print_bro.onclick = button_print_bro;
//
//	var Btn_preView_bro = $("Btn_preView_bro");
//	Btn_preView_bro.onclick = button_view_bro;	
//
//	var Btn_export_bro = $("Btn_export_bro");
//	Btn_export_bro.onclick = button_export_bro;


	
	
	
	var Btn_import = $("btn_import");
	Btn_import.onclick = displaySearchDiv;
	
	var Btn_importFile = $("btn_importFile");
	Btn_importFile.onclick = importFile;
	
	var Btn_cancelImport = $("btn_cancelImport");
	Btn_cancelImport.onclick = closeSearchDiv;
	
	var Btn_exportFile = $("btn_exportFile");
	Btn_exportFile.onclick = exportFile;
	
	var Btn_cancelExport = $("btn_cancelExport");
	Btn_cancelExport.onclick = closeExportDiv;
	
	var Btn_deleteImport = $("btn_deleteImport");
	Btn_deleteImport.onclick = deleteImport;
	
	
	var Radio_btn1 = $("radiobutton1");		
	Radio_btn1.onclick = swiitchTree;
	
	var Radio_btn2 = $("radiobutton2");		
	Radio_btn2.onclick = swiitchTree;
	

	var Btn_move_up = $("Btn_move_up");		
	Btn_move_up.onclick = move_up;
	
	var Btn_move_down = $("Btn_move_down");		
	Btn_move_down.onclick = move_down;	
	
	
	var Btn_load_history = $("Btn_load_history");		
	Btn_load_history.onclick = load_history;	
	
	
	var Btn_removeRow = $("Btn_removeRow");		
	Btn_removeRow.onclick = removeRow;	
	
//	var Btn_bro_date = $("bro_date");		
//	Btn_bro_date.onchange = setDate;
	

//	var DisplayTree = $("displayTree");		
//	DisplayTree.onclick = displayTree;
	
	var Lable_radiobutton1 = $("Lable_radiobutton1");		
	Lable_radiobutton1.onclick = function(){
	    $("radiobutton1").checked =true; 
		swiitchTree(); 
	}
	
	var Lable_radiobutton2 = $("Lable_radiobutton2");		
	Lable_radiobutton2.onclick =  function(){
	   $("radiobutton2").checked =true; 
		swiitchTree(); 
	}
	
	var Btn_forPrint = $("Btn_forPrint");
	if(!isUndefined(Btn_forPrint)){
	Btn_forPrint.onclick = forPrint;	
	}
}

function swiitchTree(){
	

	
	
	if($("radiobutton1").checked){
		 $("matterTypeTreebox").hide();
		 $("carrierTypeTreebox").show();
		 $("buttonTable").show();
	}
	
	if($("radiobutton2").checked){
		 $("carrierTypeTreebox").hide();
		 $("buttonTable").hide();
		 $("matterTypeTreebox").show();
	}	
}



function importFile(){
//	if($("paymentId").value==''||$("contractCode").value==''){
//		alert("请选择合同号！"); return false;    
//	}
	 var File1 =  document.getElementById('file1');
	 $("publishDates").value = getFormatDay($("bro_date").value,'ymd');
	 $("carrierIds").value = carrierType.tree.dhtmlTree.getSelectedItemId();
	 $("userId").value = curUserId;
	 if(File1.value !=""&&ckeckFileType(File1)){
	 		document.myform.submit();
	 }
	closeSearchDiv();
}

function displaySearchDiv(){
	var oDiv = $("theDivSearch");	
	oDiv.style.visibility = "visible";
	
//	$("myform").target = $("targetForm");
}
function closeSearchDiv(){
	var oDiv = $("theDivSearch");
	oDiv.style.visibility = "hidden";
	
	var File1 =  document.getElementById('file1');
	File1.value='';
//	$("contractCode").value = "";
}

function exportFile(){
	closeExportDiv(); 
	if($('allExport').checked) $('importType').value  = 0;
	if($('importExport').checked) $('importType').value  = 1;
	if($('timeExport').checked){
		var startH = $('startTimeExportH').value*3600;
		var startM = $('startTimeExportM').value*60;
		var endH = $('endTimeExportH').value*3600;
		var endM = $('endTimeExportM').value*60;
		
		$('startTime').value = startH+startM;
		$('endTime').value =  endH+endM;
		$('importType').value  = 2;
	}
			 		
	$("model").value = "export";
   	button_print();  

}

function displayExportDiv(){
	var oDiv = $("theDivExport");	  
	oDiv.style.visibility = "visible";
}
function closeExportDiv(){
	var oDiv = $("theDivExport");
	oDiv.style.visibility = "hidden";
}

function ckeckFileType(el){
	 var AllowExt=".xls|"  //允许上传的文件类型 ?为无限制 每个扩展名后边要加一个"|" 小写字母表示  
	 var File1 =  el;
	 
	 var index = File1.value.lastIndexOf(".");

	 var FileExt=File1.value.substr(index).toLowerCase();  
	 
	 if(AllowExt!=0&&AllowExt.indexOf(FileExt+"|")==-1)  //判断文件类型是否允许上传  
   	{  
	     var ErrMsg="\n该文件类型不允许上传。请上传 "+AllowExt+" 类型的文件，当前文件类型为"+FileExt;  
	     alert(ErrMsg);  
	     return false;  
  	}else{
	  	 var num = parseFloat(File1.value)+''; 
		 var index1 = num.indexOf(".");
		 if(File1.value.substring(index1+2,index1+3)==0){ 
		 	num=num+"0";
		 }      
		 var month = num.substr(0,index1);
		 var day = num.substr(index1+1);
		 
		 month= month.length==1?'0'+month:month;
		 day= day.length==1?'0'+day:day;
		 var publishDate =  getFormatDay($("bro_date").value,'ymd');
		 if(publishDate.substr(4)!=month+day){
		 	alert('导入文件日期与编排日期不符，请核查!');
		 	return false; 
		 }
  	     return true;
  	
	}
}

function deleteImport(){
	var publishDate =  getFormatDay($("bro_date").value,'ymd');
	var carrierName = carrierType.tree.dhtmlTree.getSelectedItemText();
	var func = function(){
		button_build_bro();
		$("btn_deleteImport").disabled=false;
	}
	if(carrierName.indexOf('频道')==-1){
		extjMessage('请选择频道级别！');
	}else{
			if(confirm('确认删除《'+carrierType.tree.dhtmlTree.getSelectedItemText()+'》在'+$("bro_date").value+'的导入广告?')){
				$("btn_deleteImport").disabled=true;
				OrderDetailManager.removeImportOrderByPublishMemo(publishDate+carrierName,func);
			}  
			
	}

	
}
function reLoadTree(){
	carrierType.tree.dhtmlTree.deleteChildItems(0);
	getCarrierTypeTree(carrierType);
	this.hide();
}

function displayTree(){
	
	if($("displayTree").value=="显示"){
		$("treeBoxTd").show();
		$("displayTree").setAttribute("value","隐藏");
	}else{
		$("treeBoxTd").hide();
		$("displayTree").setAttribute("value","显示");
	}
}


function move_up(){
	mygrid.moveRow(mygrid.getSelectedId(),"up");
}
function move_down(){
	mygrid.moveRow(mygrid.getSelectedId(),"down");
}





function getDate(name,btn){
	Calendar.setup({
		inputField  : name,	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		onClose : reLoadTree,
		button	  : btn	// id of the button
	});
	
}

function setCarrierTypePara(obj){
	 obj.className  = "carrierType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
}
function setMatterPara(obj){
	 obj.className  = "matter";
	 obj.IdPrefix 	= obj.className + "Id";
//	 obj.treebox	= obj.className + "Treebox";
//	 obj.tree 		= new Tree(obj.treebox); 
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
	 obj.className  = "user";
	 obj.IdPrefix 	= obj.className + "Id";
}

function setPublishedInfo(obj){
	 obj.className  = "arrange";
	 obj.IdPrefix 	= obj.className + "Id";
}


function getMatterTypeTree(){
	var OBJ = matterType;
	var obj_tree = OBJ.tree.dhtmlTree;
	obj_tree.enableDragAndDrop(true);	
	obj_tree.enableMercyDrag(true);
	
	OBJ.reset();
	var func = function(treeXML){
		obj_tree.deleteChildItems(0);	
		obj_tree.loadXMLString(treeXML);
		}
	OBJ.getMatterTypeXML(OBJ,matter.IdPrefix,func);
	
	
//	obj_tree = obj.tree.dhtmlTree;	
//	obj_tree.enableCheckBoxes(false);
//	obj_tree.enableItemEditor(false);
//	obj_tree.enableThreeStateCheckboxes(false);
	//obj_tree.enableDragAndDrop(true);
	//obj_tree.setOnClickHandler(doOnSelectOrgTree);
	//obj_tree.setDragHandler(doOnBeforeDropOrgTree);
//	//加载数据
//	obj.reset();
//	obj.obj.id = 1;
//	obj.getTreeXML(branch.IdPrefix,user.IdPrefix);
//	obj_tree.loadXMLString(obj.tree.treeXML);
	
}



function initGrid(){
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath("image/grid/");
//	var flds = "序号,磁带号,广告名称,版本,长度,指定,备注,指定参数,日播编号,资源编号,客户名称,业务员,明细编号,编号/广告编排状态,锁定";
	var flds = "序,磁带号,广告名称,版本,长度,指定,备注,,,,,,,,,订单号,预留";

//	if(tvNameParam =='fztv'){
//		flds = "序,,广告名称,版本,长度,指定,备注,,,,客户名称,业务员,,,,订单号"; 
//		mygrid.setInitWidthsP("3,0,23,20,6,6,11,0,0,0,16,8,0,0,0,8");  
//	}else{
		mygrid.setInitWidthsP("3,12,22,21,7,7,11,0,0,0,0,0,0,0,0,10,7");  
//	}
//	var flds = "序号,磁带号,广告名称,版本,长度,指定,备注,,,";
	mygrid.setHeader(flds);
	
	var columnIds = "publishSort,tapeCode,matterName,matterEdit,matterLength," 
					+"specificName,publishMemo,specificValue,orderDayId,resourceId,"
					+"customerName,ownerUserName,id,isArranged,isLocked,orderId,beforehand";
	mygrid.setColumnIds(columnIds);

//	mygrid.setInitWidths("150,70,210,200,80,80,100,60,60,60,60,60,60,60,60")
//	mygrid.setInitWidthsP("17,12,30,26,9,10,11,0,0,0,0,0,0,0,0,14")

//    mygrid.enableLightMouseNavigation(true);
	mygrid.setColAlign("left,left,left,left,left,left,left,left,left,left,left,left,left,left,left,left,left");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,ed,link,coro"); 

	mygrid.setMultiLine(false);
//	mygrid.setEditable(true);
	mygrid.setDragBehavior("nextSibling"); //nextSibling complex
//	mygrid.enableRowsHover(true,'grid_hover')
	//mygrid.enableLightMouseNavigation(true);
	mygrid.setOnEditCellHandler(do_onEditCell);
	
//	if(tvNameParam =='fztv'){
//			mygrid.enableDragAndDrop(false);
//			mygrid.setOnRightClick(do_rightClick);
//			mygrid.setOnRowDblClickedHandler(do_dblClick);  
//	}else{
		mygrid.enableDragAndDrop(true);
		mygrid.setDragHandler(do_drag);
		mygrid.setDropHandler(do_drop);
//	}

	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setSkin("modern2");
	//  mygrid.lockRow(3,true);
	mygrid.init();	 
	
	
	var command= mygrid.getCombo(arrange.col_beforehand);
    for(var i = 29 ;i>0;i--){
    		command.put(i,i);
    }

}

var sortFunction =function(a,b){  
	return a.firstChild.textContent-b.firstChild.textContent;
}




 function do_onEditCell(stage,id,index){
 	
         //stage = 0 start edit Shipping column
         //stage = 2 for finishing edit  mygrid.getCombo(5).restore();        //restore combo state
        var ind = mygrid.getColumnId(index);

        if(ind =='beforehand'  && id.indexOf("_") == -1 ){
//        	    if(stage==2)  mygrid.getCombo(arrange.col_beforehand).restore();        //restore combo state
        	  return true;
        }else{
        	return false;
        }

    }


function do_rightClick(id){
	 var row  = mygrid.getRowById(id);
	 if(row.childNodes.length>0) mygrid.doClick(row.childNodes[0],true,2);
	 rowIds= mygrid.selectedRows;
	 rowIds.sort(sortFunction);
}
function do_dblClick(id){
	var row2 = mygrid.getRowById(id);
	for(var i=0;i<rowIds.length;i++){
		var row = rowIds[i]; 
		if(handleBefore(row.idd,row2.idd)){  
			row.parentNode.insertBefore(row,row2);
			handleAfter(row.idd,row2.idd);    
		}
	}
	mygrid.clearSelection();
	rowIds.clear();
}
function handleBefore(r1,r2){
	var type =  treeObj.getUserData(r1,"type"); 
    var isFromTree = checkIsFomTree(type);
    if(type == 0||type == 1) return false;
      
        
    if(isFromTree) r1 = r1+ arrange.IdPrefix;
	var r1_isAdver = isAdverNode(r1);
	var r2_isAdver = isAdverNode(r2);

	//源和目标都是段位
	if(!r1_isAdver && !r2_isAdver) return false;
	//源是段位目标是广告
	if(!r1_isAdver && r2_isAdver) return false;
	    
	//不能跨段位调整!
	var dragInParId_rel =  getParentId(r2,detail.col_resourceId);
	var dragParId_rel = isFromTree?dragInParId_rel:getParentId(r1,detail.col_resourceId);
	if(config_stridePositionParam == 0){
		if(dragParId_rel != dragInParId_rel) return false;
	}
	
	    
 	//源或是指定广告不能拖动  alert("指定位置的广告，不能调整位置");
	//广告锁定  alert("已锁定的广告，不能调整位置");
        var v1 = "";var v2 = "";
        if(isFromTree){
        	v1 = treeObj.getUserData(r1,"specificValue");
        }else{
        	v1 = getCellValue(r1,detail.col_specificValue);
        }
        v2 = getCellValue(r2,detail.col_isLocked);
	v1 = (v1 == '' || v1 == null || isUndefined(v1))? "&":v1.Trim();
	v2 = (v2 == '' || v2 == null || isUndefined(v2))? "&":v2.Trim();

	if(config_specArowMoveParam==0&&myComparator(v1,"123456789ABCDEFGHI"))return false;
	if(myComparator(v2,"true"))return false;
	
	return true;
}
function handleAfter(r1,r2){
		
	var type =  treeObj.getUserData(r1,"type"); 
    var isFromTree = checkIsFomTree(type);	


	//垫片广告时，不需要处理
	var dragInParId_rel =  getParentId(r2,detail.col_resourceId);
	var dragParId_rel = isFromTree?dragInParId_rel:getParentId(r1,detail.col_resourceId);

	if(isFromTree){
		mygrid.cells(r1,detail.col_resourceId).setValue(dragInParId_rel);
		var seconds = (new Date()).getSeconds();
		var r1_new  =  dragInParId_rel +"_" + arrange.IdPrefix + seconds;
		mygrid.changeRowId(r1,r1_new);
		r1 = r1_new;
	}


 	var dragParId = resource.IdPrefix +"" + dragParId_rel;
	var dragInParId = resource.IdPrefix +"" + dragInParId_rel;
	//var is2AdverMove = (dragParId == dragInParId);
    
	//如果是跨段调整，需要改变两个资源的信息
	if(config_stridePositionParam == 1){
		mygrid.cells(r1,detail.col_resourceId).setValue(dragInParId_rel);
		mygrid.changeRowId(r1,resource.IdPrefix+dragInParId_rel+'_'+arrange.IdPrefix +(new Date()).getTime());
		
		setResourceAdverOrder(dragParId,detail.col_publishSort,detail.col_resourceId);
		changeUsedTime(dragParId);
	}
	
	changeUsedTime(dragInParId);
	setResourceAdverOrder(dragInParId,detail.col_publishSort,detail.col_resourceId);
}
function addNewRowFromTree(gridRowId){
	//var treeObj = matterType.tree.dhtmlTree;	
	var treeNodeId = treeObj.getSelectedItemId();
	var cells = mygrid.treeToGridElement(treeObj,treeNodeId,gridRowId);
	var insertPost = mygrid.getRowIndex(gridRowId);
	//alert(treeObj);alert(treeNodeId);alert(cells);alert(insertPost);
	mygrid.addRow(treeNodeId,cells,insertPost);
}


function checkIsFomTree(type){
	if(type == 0||type == 1||type == 2) return true;
	return false;	
}

function do_drag(r1,r2){
    	if(isUndefined(r1)) return false;
    	if(isUndefined(r2)) return false;
    	
    	var r1s = r1.split(",");
    	for(var i =0;i<r1s.length;i++)
    	r1 = r1s[i];
	var type =  treeObj.getUserData(r1,"type"); 
        var isFromTree = checkIsFomTree(type);
        if(type == 0||type == 1) return false;
      
        
        if(isFromTree) r1 = r1+ arrange.IdPrefix;
	var r1_isAdver = isAdverNode(r1);
	var r2_isAdver = isAdverNode(r2);

	//源和目标都是段位
	if(!r1_isAdver && !r2_isAdver) return false;
	//源是段位目标是广告
	if(!r1_isAdver && r2_isAdver) return false;
	    
	//不能跨段位调整!
	var dragInParId_rel =  getParentId(r2,detail.col_resourceId);
	var dragParId_rel = isFromTree?dragInParId_rel:getParentId(r1,detail.col_resourceId);
	if(config_stridePositionParam == 0){
		if(dragParId_rel != dragInParId_rel) return false;
	}
	
	    
 	//源或是指定广告不能拖动  alert("指定位置的广告，不能调整位置");
	//广告锁定  alert("已锁定的广告，不能调整位置");
        var v1 = "";var v2 = "";
        if(isFromTree){
        	v1 = treeObj.getUserData(r1,"specificValue");
        }else{
        	v1 = getCellValue(r1,detail.col_specificValue);
        }
        v2 = getCellValue(r2,detail.col_isLocked);
	v1 = (v1 == '' || v1 == null || isUndefined(v1))? "&":v1.Trim();
	v2 = (v2 == '' || v2 == null || isUndefined(v2))? "&":v2.Trim();

//	if(tvNameParam !='fztv' && myComparator(v1,"123456789ABCDEFGHI"))return false;  
	if(myComparator(v1,"123456789ABCDEFGHI"))return false;  
			
	if(myComparator(v2,"true"))return false;	
	
				

	return true;
   
}




function do_drop(r1,r2){
	//var isInsertRow = $("radiobutton2").checked;
	if(isUndefined(r1)) return false;
	if(isUndefined(r2)) return false;

    	var r1s = r1.split(",");
    	for(var i =0;i<r1s.length;i++)
    	r1 = r1s[i];
	//alert(r1);
	
	//var treeObj = matterType.tree.dhtmlTree;
	var type =  treeObj.getUserData(r1,"type"); 
        var isFromTree = checkIsFomTree(type);	

 
	//垫片广告时，不需要处理
	var dragInParId_rel =  getParentId(r2,detail.col_resourceId);
	var dragParId_rel = isFromTree?dragInParId_rel:getParentId(r1,detail.col_resourceId);

	if(isFromTree){
		mygrid.cells(r1,detail.col_resourceId).setValue(dragInParId_rel);
		var seconds = (new Date()).getSeconds();
		var r1_new  =  dragInParId_rel +"_" + arrange.IdPrefix + seconds;
		mygrid.changeRowId(r1,r1_new);
		r1 = r1_new;
	}


 	var dragParId = resource.IdPrefix +"" + dragParId_rel;
	var dragInParId = resource.IdPrefix +"" + dragInParId_rel;
	//var is2AdverMove = (dragParId == dragInParId);
    
	//如果是跨段调整，需要改变两个资源的信息
	if(config_stridePositionParam == 1){
		mygrid.cells(r1,detail.col_resourceId).setValue(dragInParId_rel);
		setResourceAdverOrder(dragParId,detail.col_publishSort,detail.col_resourceId);
		changeUsedTime(dragParId);
	}

	changeUsedTime(dragInParId);
	setResourceAdverOrder(dragInParId,detail.col_publishSort,detail.col_resourceId);
   
	return true;
}

function changeUsedTime(parentId){
	var ids = getChiledByParentId(parentId,detail.col_resourceId);
	var dragParCellUsed = mygrid.cells(parentId,arrange.col_resUsedTimes);
	var dragParCellLeave = mygrid.cells(parentId,arrange.col_resLeave);
	var sumUsed = 0;
	var sumTotle =  mygrid.cells(parentId,arrange.col_resTotalTimes).getValue()*1;
	var sumLeave = 0;

	for(var i = 0; i< ids.length;i++){
		var v = mygrid.cells(ids[i],arrange.col_resUsedTimes).getValue()*1;
		sumUsed = sumUsed + v;
	}
	sumLeave = sumTotle - sumUsed;
	
	
	//改变颜色
	dragParCellUsed.setValue(sumUsed);
	dragParCellLeave.setValue(sumLeave);
	setResourceRowCss(parentId,sumLeave);
}

//function onGridReconstructed(){
//   //改变序号
//   var col_order = 0;
//   var itemIds = getResourceIds();
//   for(var i = 0; i< itemIds.length;i++){
//		var id = itemIds[i];
//        setResourceAdverOrder(id,col_order);
//   }  
//}


function isAdverNode(id){  
   var nodeType = id.indexOf(arrange.IdPrefix);
   if(nodeType == -1) return false;
   return true;
} 

function setResourceRowCss(rowId,resourceLeave){
	var cssText = "font-weight:bold;";
	if(resourceLeave == 0) cssText = "font-weight:bold;" +" background-color: #CCCCCC;";
	if(resourceLeave > 0) cssText = "font-weight:bold;" +" background-color: #99FF66;";
	if(resourceLeave < 0) cssText = "font-weight:bold;" +" background-color: #FFFF00;";
	mygrid.setRowTextStyle(rowId,cssText);
}

function setResourceAdverOrder(rowId,col_order,col_resourceId){
	var itemIds = getChiledByParentId(rowId,col_resourceId);
	
	var cssText ="cursor: pointer;";

	for(var i = 0; i< itemIds.length;i++){
		var id = itemIds[i];
		var cell = mygrid.cells(id,col_order);
		cell.setValue(i+1);
		mygrid.setRowTextStyle(id,cssText);
	}
}

function getChiledByParentId(parentId,col_resourceId){
	var rows = mygrid.getRowsNum();
    var ids = new Array();
//    if(tvNameParam =='fztv'){
//		var itemIds =mygrid.getRowById(parentId).parentNode.childNodes; 
//		for(var i=1;i<itemIds.length;i++){    
//			var id = itemIds[i].idd;
//			if(id.indexOf(parentId+"_")>-1) ids.push(id);
//		}
//	}else{ 
		for(var i=0;i<rows;i++){
		var pid = resource.IdPrefix +""+ mygrid.cells2(i,col_resourceId).getValue();
		var id = mygrid.getRowId(i);
		if( pid == parentId && id.indexOf("_")>-1) ids.push(mygrid.getRowId(i));
		}
//	}

	return ids;
}


function getParentId(adverId,col_parentId){
	var value ="";
	if(isAdverNode(adverId)){
	   var cell = mygrid.cells(adverId,col_parentId);	
	   value = cell.getValue();
	}else{
		value = adverId.replace(resource.IdPrefix,'');
	}
	return value;
}


//function getChiledByParentId(parentId){
//	var rows = mygrid.getRowsNum();
//    var ids = new Array();
//	for(var i=0;i<rows;i++){
//		var id = mygrid.getRowId(i);
//		var j = id.indexOf(parentId+"_");
//		if (j > -1) ids.push(id);
//	}
//	return ids;
//}


function getResourceIds(){
	var rows = mygrid.getRowsNum();
    var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i);
		var j = id.indexOf("_");
		if (j == -1) ids.push(id);
	}
	return ids;
}
//function changeParentId(r1_parent,r2_parent,r1,col_parentId){
//	var cell = mygrid.cells(r1,col_parentId).setValue(r2_parent);
//	cell.setValue(r2_parent);
//}
function myComparator(v,comparatorValue){
	if(comparatorValue.indexOf(v) == -1) return false;
	return true;
}



function getRowCellData(row_id,col){
	return mygrid.cells(row_id,col).getValue();
}

function removeRow(){
//  if(tvNameParam !='fztv'){
    var id = mygrid.getSelectedId();
     //alert(id);
    var id_isAdver = isAdverNode(id);	
    if(id_isAdver){
    	 var parId_rel = getParentId(id,detail.col_resourceId);
    	 var pid = resource.IdPrefix +""+ parId_rel;
    	 mygrid.deleteSelectedItem();
    	 changeUsedTime(pid);
    	 setResourceAdverOrder(pid,detail.col_publishSort,detail.col_resourceId);
//    	 window.setTimeout("mygrid.deleteRow("+data[0]+");",200);
    	 window.setTimeout("mygrid.deleteSelectedItem();",200);
    	 //changeUsedTime(parentId);
    }
//  }else{
//  
//     removeRowFZTV();
//  
//  }
}
function removeRowFZTV(){
	var usedTimes=getRowCellData(-1,arrange.col_resUsedTimes)-0;
	var lineNums=getRowCellData(-1,arrange.col_resMeno)-0;
//    var id = mygrid.getSelectedId();
//     //alert(id);
//    var id_isAdver = isAdverNode(id);	
//    if(id_isAdver){
//    	 var parId_rel = getParentId(id,detail.col_resourceId);
//    	 var pid = resource.IdPrefix +""+ parId_rel;
//    	 mygrid.deleteSelectedItem();
//    	 changeUsedTime(pid);
//    	 setResourceAdverOrder(pid,detail.col_publishSort,detail.col_resourceId);
////    	 window.setTimeout("mygrid.deleteRow("+data[0]+");",200);
//    	 window.setTimeout("mygrid.deleteSelectedItem();",200);
//    	 //changeUsedTime(parentId);
//    }
     var ids = mygrid.getSelectedId().split(',');
     for(var i =0;i<ids.length;i++){
 		var id=ids[i];  	
 	    var id_isAdver = isAdverNode(id);
		if(id_isAdver){
			 usedTimes-=getRowCellData(id,detail.col_matterLength);
			 lineNums--;
	    	 var parId_rel = getParentId(id,detail.col_resourceId);
	    	 var pid = resource.IdPrefix +""+ parId_rel;
	    	 mygrid.deleteRow(id);
	    	 changeUsedTime(pid); 
	    	 setResourceAdverOrder(pid,detail.col_publishSort,detail.col_resourceId);
		}
	}
	mygrid.cells(-1,arrange.col_resUsedTimes).setValue(usedTimes);
	mygrid.cells(-1,arrange.col_resMeno).setValue(lineNums);
}



function loadGridXML(xml,callBackFun){
	mygrid.clearAll();
	if(xml ==''||isUndefined(xml)){ extjMessage('这一天没有广告播出!');	return false;	}
	mygrid.loadXMLString(xml,callBackFun);
}



//载入历史数据时，只载入没被锁定的段位，
function resetResourceIds(callBackFun){
		var resourceIds = getBuildResourceIds();
		var publishDate =  getFormatDay($("bro_date").value,'ymd');
		
		var func = function(objs){
		    var isLockeds = getArrayFromObjs(objs,"isLocked","resourceId",true);
//		    var isLockeds = getArrayFromObjs(objs,"isLocked","resourceId",true);

		    var arr = new Array();
		    for(var i = 0;i<resourceIds.length;i++){
		    	if(isLockeds.indexOf(resourceIds[i]) ==-1) arr.push(resourceIds[i]);
		    }

            if(isLockeds.length > 0){
//            	 var msg = "";  
//            	 msg += "已经锁定的段位[" + carrierType.tree.getNodeTxtByRelIds(resource.IdPrefix,isLockeds) +"]不能重新编排" +'\n';
   			 	 var msg = carrierType.tree.getNodeTxtByRelIds(resource.IdPrefix,isLockeds).join("<br>");
	  			var msg2="<div style='width:280px;height:300px;OVERFLOW-y:auto;OVERFLOW-x:hidden;OVERFLOW: scroll;'>"+msg+"<div>";
				Ext.MessageBox.hide(); 
				Ext.MessageBox.show(
							{title:'系统提示,已经锁定的段位,不能重新编排?',msg:msg2,width:350,heigth:300,buttons: Ext.MessageBox.OK,icon: Ext.MessageBox.INFO}
				);          	 

//            	 alert(msg);
            }
            
//            alert("resourceIds"+resourceIds);
//            alert("arr"+arr);
        
            if(arr.length>0){
          	   callBackFun(arr,isLockeds);   	
            }
  
			
		}
        arrange.reset();
		arrange.obj.resourceIds = resourceIds;
		arrange.obj.publishDate = publishDate;
		arrange.obj.orgId = $('orgId').value;
		arrange.getPublishArrangesByIdListFromHistory(arrange.obj,func);
		
}

function load_history(){
	var historyDate = $("bro_date_history").value;
//	if(historyDate == null || historyDate == ''){
//	   alert("请选择参照日期!");
//	   return false;
// 	}
	mygrid.clearAll();
	
	
	
	function loadTodayNoLock(ids,lockedIds){
		var rebuild = false;
		var isRoll = true;	
		var onlyHistory = true;	
		
        arrange.reset();
        arrange.obj.isArranged = true;
        arrange.obj.isEnable = false;  
		arrange.obj.resourceIds = ids;
		arrange.obj.publishDate = historyDate;
	    var selectId =  carrierType.tree.dhtmlTree.getSelectedItemId();
	    arrange.obj.carrierName =  carrierType.tree.dhtmlTree.getParentId(selectId);
		arrange.obj.orgId = $('orgId').value;
		
		function loadXmlFun(){
			
			 //获得历史资源编号
			 var historyResorceIds = new Array();
			 var rowCount = mygrid.getRowsNum();
			 for(var i = 0;i< rowCount;i++){
			 	var rowId = mygrid.getRowId(i);
			 	var isResourceRow = !isAdverNode(rowId);
			 	if(isResourceRow){
			 		var resourceId = mygrid.cells(rowId,arrange.col_resId).getValue();
			 		historyResorceIds.push(resourceId);
			 	}	 
			 }
			 
			 
//			 alert("historyResorceIds" + historyResorceIds);
	
            //设置当前已编排过的段位序号
			var changeArrangeIdFun = function(objs){
				
				//当前日期 已排过的资源
				var todayIsArragedResorceIds = getArrayFromObjs(objs,"isArranged","resourceId",true);
				
//				alert("todayIsArragedResorceIds" + todayIsArragedResorceIds);
				
                //获得在历史资源中，当前已经编排过的 资源编号 
                var curModifyResorceIds  = new Array();
                for(var i = 0;i<todayIsArragedResorceIds.length;i++){
                	if(historyResorceIds.indexOf(todayIsArragedResorceIds[i]) >-1 ) curModifyResorceIds.push(todayIsArragedResorceIds[i]);
                }
                
//                alert("curModifyResorceIds" + curModifyResorceIds);
                
				
				//清空获得历史资源编号
				for(var i = 0;i<historyResorceIds.length;i++){
					var rowId = resource.IdPrefix + historyResorceIds[i];
	//				alert("resourceId" +resourceId);
					mygrid.cells(rowId,arrange.col_id).setValue("0");
				}
			   
			    //修改历史资源中  当前已经编排过的编号
				for(var i =0;i<objs.length;i++){
					var resourceId =  objs[i].resourceId;
//					alert("resourceId" +resourceId);
					if(curModifyResorceIds.indexOf(resourceId) >-1 ){
						var rowId = resource.IdPrefix + resourceId;
						var arrangeId = objs[i].id;
						
//						alert("arrangeId" +arrangeId);
						mygrid.cells(rowId,arrange.col_id).setValue(arrangeId);
					}
				}				
				
				if(lockedIds.length > 0) loadTodayLocked(lockedIds);
				
			}

			arrange.obj.publishDate =  getFormatDay($("bro_date").value,'ymd');
			arrange.obj.orgId = $('orgId').value;
			arrange.getPublishArrangesByIdListFromHistory(arrange.obj,changeArrangeIdFun);
		}
		
		
		
		function getFun(xml){
			if(xml ==''||isUndefined(xml)){
//				alert("这一天没有广告播出!");
				return false;	
			}else{
				mygrid.loadXMLString(xml,loadXmlFun);
			}
		}
		
		arrange.getTreeGrid(arrange.obj,resource.IdPrefix,arrange.IdPrefix,rebuild,isRoll,onlyHistory,getFun);
	}
	
	
	
	
	
	function loadTodayLocked(ids){
		var rebuild = false;
		var isRoll = true;	
		var onlyHistory = true;	
		
        arrange.reset();
        arrange.obj.isArranged = true;
        arrange.obj.isEnable = false;
		arrange.obj.resourceIds = ids;
		arrange.obj.publishDate =  getFormatDay($("bro_date").value,'ymd');
	    var selectId =  carrierType.tree.dhtmlTree.getSelectedItemId();
	    arrange.obj.carrierName =  carrierType.tree.dhtmlTree.getParentId(selectId);
		arrange.obj.orgId = $('orgId').value;
		
		function loadXmlFun(){
            var changeArrangeIdFun = function(objs){}
			arrange.obj.publishDate =  getFormatDay($("bro_date").value,'ymd');
			arrange.getPublishArrangesByIdListFromHistory(arrange.obj,changeArrangeIdFun);
		}
		
		
		
		function getFun(xml){
			if(xml ==''||isUndefined(xml)){
				return false;	
			}else{
				mygrid.loadXMLString(xml,loadXmlFun);
			}
		}
		
		arrange.getTreeGrid(arrange.obj,resource.IdPrefix,arrange.IdPrefix,rebuild,isRoll,onlyHistory,getFun);
	}
		
	
	
	
	//排除锁定
    resetResourceIds(loadTodayNoLock);	
	
}


function isBuildLevel(){
	var obj_tree = carrierType.tree.dhtmlTree;
	var selectId = obj_tree.getSelectedItemId();
    var type = getNodeType(selectId);

    if (type != 2){
    	 extjMessage('请选择载体名称!');
    	return false;
    } 
    if (type == 2){
    	
//    	var curCarrierId =  carrierType.tree.getIdByPrefix(isFztv(selectId),carrier.IdPrefix);
    	var curCarrierId =  carrierType.tree.getIdByPrefix(selectId,carrier.IdPrefix);
    	var can = carrier.getCarrierBuildLevel(curCarrierId);
    	if(can == false) {
    		 extjMessage('请选择正确的载体级别建立串联单!');
    		return false;
    	}else{
//    		 $("selectedCarrierId").value = curCarrierId;
    		 
    		//判断是否 选择了载体名称
    		getCarrierName();
//	        if(!getCarrierName()) return false;
    	}
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
	
//建立前先判断是否已经编排过，如果有则提示是否重新编排	
function button_build_bro(){
	var dateStr =  getFormatDay($("bro_date").value,'ymd');
	var rebuild = false
	var isRoll = true;
//	if(tvNameParam =='fztv') isRoll=false;
	var onlyHistory = false;	
	//判断是否选择建立级别
	if(isBuildLevel() == false) return false;
	
	var Btn_save_bro = $("Btn_save_bro");
	if(!isUndefined(Btn_save_bro)){
	    	Btn_save_bro.disabled= true;	
	}

     
	var resourceIds = getBuildResourceIds();
	
	var isContinued=false;
	
	var callback=function(obj){
		if(obj.length>0){
			var dialogcontent = $("dialogcontentDiv");
			var dialogcontentW = dialogcontent.offsetWidth;
			var dialogcontentH = dialogcontent.offsetHeight;
			var winW= dialogcontentW * 0.6;
			var winH = dialogcontentH*0.8;
			var title = "下面列出了今天需要播出但还没有审核的订单:";
			  
			var urlStr = "selectPopup/checkForm.html?dateStr="+dateStr+"&resourceIds="+resourceIds+"&orgId="+ $('orgId').value;
//			openWindow(urlStr,title,'width='+winW+',height='+winH);	  
			
			
			var closeBtn ={text: '关闭',handler: function(){win.hide();}};
			  
			        
			 var win = new Ext.Window({
			   title : '下面列出了今天需要播出但还没有审核的订单',
			   //maximizable : true,
			   // maximized : true,
			   width : winW,
			   height : winH,
			   // autoScroll : true,
			   // bodyBorder : true,
			   // draggable : true,
			   isTopContainer : true,
			   modal : true,
			   resizable : false,
			    buttons: [closeBtn],
			   contentEl : Ext.DomHelper.append(document.body, {
			    tag : 'iframe',
			    style : "border 0px none;scrollbar:true",
			    src : urlStr,
			    height : "100%",
			    width : "100%"
			   })
			  })
			  

				win.show(); 					
			
			 
			
			
			
			
			
			
			
			
			 
//			var str="下列订单审批后该载体才能编排:	"+obj[0].orderCode;
//			for(var i=1;i<obj.length;i++){
//				str=str+","+obj[i].orderCode;
//			}
//			alert(str);isContinued=true;
//			mygrid.clearAll();

//			getArrangeType(resourceIds,dateStr,callBackFun);
			
			if(!tag_publish_arrangeforce){ 
				isContinued=true;
				mygrid.clearAll();
				Ext.getBody().unmask();
			}else{
				getArrangeType(resourceIds,dateStr,callBackFun);
			}
			
			
//			if(tvNameParam !='fztv'){
//				isContinued=true;
//				mygrid.clearAll();
//				Ext.getBody().unmask();
//			}else{
//				getArrangeType(resourceIds,dateStr,callBackFun);
//			}
		}else{
			getArrangeType(resourceIds,dateStr,callBackFun);
		}
	}
	if(resourceIds=="") resourceIds =0;
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
	order.getOrderCodeByCheckState1(1,dateStr,resourceIds,callback);
	
//	if(!tag_publish_arrangeforce){ 
//			order.getOrderCodeByCheckState1(1,dateStr,resourceIds,callback);
//	}else{
//		getArrangeType(resourceIds,dateStr,callBackFun);
//	}
	
	
//	if(tag_publish_arrange){
//			order.getOrderCodeByCheckState1(1,dateStr,resourceIds,callback);
//	}else{
//			isContinued=true;
//			mygrid.clearAll();
//			getArrangeType(resourceIds,dateStr,callBackFun);
//	}
	
	


	if(isContinued) {        
		if(!isUndefined(Btn_save_bro)) {Btn_save_bro.disabled= false;}		
		return false;				
	}
	
	arrange.reset();
//	arrange.obj.isArranged = false;
	
//	//判断是否编排方式
//	var type = getArrangeType(resourceIds,dateStr,callBackFun);


	function callBackFun(type){
		arrange.obj.isEnable = false;//福州台要求保存后的编排不能变，故借用这个变量。

		if(type == 0) return false;
		if(type == 1){
			  arrange.obj.isArranged = false;
			  rebuild = true;
//			  if(tvNameParam =='fztv') {
//			  	rebuild =false;  
//			  	arrange.obj.isArranged = true;
//			  	arrange.obj.isEnable = true;
//			  }
		}
		if(type == 2)  arrange.obj.isArranged = false;
		if(type == 3)  arrange.obj.isArranged = true;
	
		var func  = function(xml){
			mygrid.clearAll();
			Ext.getBody().unmask();	
			if(xml ==''||isUndefined(xml)){
			   extjMessage('这一天没有广告播出!');
//			   Ext.getBody().unmask();	
			   return false;	
			}
			
			var fnc = function(){
					if(!isUndefined(Btn_save_bro)){
					    	Btn_save_bro.disabled= false;	
					}
				Ext.getBody().unmask();
				}
			mygrid.loadXMLString(xml,fnc);
			
//			Ext.getBody().unmask();
		}
		var selectId =  carrierType.tree.dhtmlTree.getSelectedItemId();
		arrange.obj.carrierName =  carrierType.tree.dhtmlTree.getParentId(selectId);
		arrange.obj.resourceIds = resourceIds;
		arrange.obj.publishDate = dateStr;
		arrange.obj.orgId = $('orgId').value;
//		arrange.obj.createBy = 0;
//		arrange.obj.modifyBy = 0;
	  arrange.obj.arrangeforce= tag_publish_arrangeforce == true?"1":"0";
//	    alert(arrange.obj.isArranged);
		arrange.getTreeGrid(arrange.obj,resource.IdPrefix,arrange.IdPrefix,rebuild,isRoll,onlyHistory,func);	
	}
		

}

function getArrangeType(resourceIds,publishDate,callBackFun){
	var state = 0;
     	
	if(resourceIds == ''){
		extjMessage('请选择广告资源!');
		Ext.getBody().unmask();
	}else{
		//建立前先判断是否已经编排过，如果有则提示是否重新编排
		
		var func = function(objs){
			
            var isArrangeds = getArrayFromObjs(objs,"isArranged","resourceId",true);
            var isLockeds = getArrayFromObjs(objs,"isLocked","resourceId",true);
            
//            alert(isArrangeds);alert(isLockeds);

            var msg = ""; 
//            if(isArrangeds.length > 0) msg ="已经编排过的段位[" + carrierType.tree.getNodeTxtByRelIds(resource.IdPrefix,isArrangeds) +"]" +'\n';;
//            if(isLockeds.length > 0) msg += "已经锁定的段位[" + carrierType.tree.getNodeTxtByRelIds(resource.IdPrefix,isLockeds) +"]不能编排" +'\n';
//            msg += "是否重新编排?" +'\n';
            
            if(isArrangeds.length > 0){
            	var nodeTextArray =carrierType.tree.getNodeTxtByRelIds(resource.IdPrefix,isArrangeds);
            	 msg = "<b>已经编排过的段位</b><br>"+ nodeTextArray.join("<br>");
            }
           
            if(isLockeds.length > 0){
            	var nodeTextArray =carrierType.tree.getNodeTxtByRelIds(resource.IdPrefix,isLockeds);
            	var nodeText = " <b>已经锁定的段位</b><br>"+nodeTextArray.join("<br>");
            	msg  = msg + "<br><br>"+nodeText;
            	
            }
            
           
            if(isArrangeds.length > 0){
	  			var msg2="<div style='width:280px;height:300px;OVERFLOW-y:auto;OVERFLOW-x:hidden;OVERFLOW: scroll;'>"+msg+"<div>";
				Ext.MessageBox.hide(); 
				Ext.getBody().unmask();
				Ext.MessageBox.show(
							{title:'系统提示,是否重新编排?',msg:msg2,width:350,heigth:300,buttons: Ext.MessageBox.YESNO,icon: Ext.MessageBox.QUESTION,
								fn: function(btn){
										if(btn == 'yes') {
											state = 1;
											
										}else{
											state = 3;
										}
										Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	 								    callBackFun(state);
								}
							
							}
				); 
            };
            
            if(isArrangeds.length == 0 && isLockeds.length == 0){
            	 state = 2; callBackFun(state);
            }

            
//            if(isArrangeds.length > 0){if(confirm(msg)){state = 1;}else{state = 3;}}
//            if(isArrangeds.length == 0 && isLockeds.length == 0) state = 2;
//            callBackFun(state);
		}
		
        
        arrange.reset();
		arrange.obj.resourceIds = resourceIds;
		arrange.obj.publishDate = publishDate;
		arrange.obj.orgId = $('orgId').value;
		arrange.getPublishArrangesByIdListFromHistory(arrange.obj,func);

	}	

	
	return state;
}
 

function checkArrangeLocked(arrange,callBackFun){

		var func = function(objs){
			 var isLockeds = getArrayFromObjs(objs,"isLocked","resourceId",true);
			 if(isLockeds.length >0 ){
			 	 msg = carrierType.tree.getNodeTxtByRelIds(resource.IdPrefix,isLockeds).join("<br>");
	  			var msg2="<div style='width:280px;height:300px;OVERFLOW-y:auto;OVERFLOW-x:hidden;OVERFLOW: scroll;'>"+msg+"<div>";
				Ext.MessageBox.hide(); 
				Ext.MessageBox.show(
							{title:'系统提示,已经锁定的段位',msg:msg2,width:350,heigth:300,buttons: Ext.MessageBox.OK,icon: Ext.MessageBox.INFO}
				); 
//			 	msg = "已经锁定的段位[" + carrierType.tree.getNodeTxtByRelIds(resource.IdPrefix,isLockeds) +"]不能编排" +'\n'; alert(msg);
			 }

			 for(var i =0 ; i< isLockeds.length; i++){
			 	var resourceRowId = resource.IdPrefix + isLockeds[i];
//			 	var row = mygrid.cells(resourceRowId,arrange.col_isLocked);
			 	mygrid.cells(resourceRowId,arrange.col_isLocked).setValue("true");
			 }
			 
			 callBackFun();
		}
		
		arrange.obj.isLocked = true;
		arrange.obj.orgId = $('orgId').value;
		arrange.getPublishArrangesByIdListFromHistory(arrange.obj,func);	
}

function savePublishArrange(){
	
	Ext.getBody().mask('数据加载中……', 'x-mask-loading');
	
//	var selectId = carrierType.tree.dhtmlTree.getSelectedItemId();
//    var curCarrierId =  carrierType.tree.getIdByPrefix(selectId,carrier.IdPrefix); 
//    var buildCarrierId = $("selectedCarrierId").value ;
//    if(curCarrierId != buildCarrierId){
//    	alert("建立的载体与打印的载体名称不同!");
//    }
     var selectId =  carrierType.tree.dhtmlTree.getSelectedItemId();
//	 if(selectId.substring(0,1)!=3) {alert("非普通广告不得保存!");return false;}   

//	//判断是否 选择了载体名称
//	 if(!getCarrierName()) return false;
     var Btn_save_bro = $("Btn_save_bro");
     Btn_save_bro.disabled= true;
       
	 var resourceIds = getBuildResourceIds();
	 var publishDate =  getFormatDay($("bro_date").value,'ymd');
	 var isRoll = true; 
//	 if(tvNameParam =='fztv') isRoll=false;
	 var rebuid = false;
	 var onlyHistory = false;	
	 
	 arrange.reset();
	 arrange.obj.isArranged = true;
	 arrange.obj.isEnable = false;
	 arrange.obj.resourceIds = resourceIds;
	 arrange.obj.publishDate = publishDate;
	 arrange.obj.carrierName =  carrierType.tree.dhtmlTree.getParentId(selectId);
	 arrange.obj.orgId = $('orgId').value;

	//检测资源是否锁定
	checkArrangeLocked(arrange,callBackFun);
	
	function callBackFun(){
		
	    var publishArranges = getPublishArrangeFromGrid();
	
		function func(){
			var callBackFun =function(){Btn_save_bro.disabled= false;}
			function getFun(xml){loadGridXML(xml,callBackFun);Ext.getBody().unmask();Ext.MessageBox.hide(); extjMessage('保存完毕!');}
			arrange.getTreeGrid(arrange.obj,resource.IdPrefix,arrange.IdPrefix,rebuid,isRoll,onlyHistory,getFun);	
		}
//		DWREngine.setOrdered(true);
//	    DWREngine.beginBatch(); 
		arrange.savePublishArrangeObjArray(publishArranges,func);
//		DWREngine.endBatch(); 	
	}
	
}

function getCarrierName(){
	var obj_tree = carrierType.tree.dhtmlTree;
	var selectId = obj_tree.getSelectedItemId();
    var type = getNodeType(selectId);

//    if (type != 2){
//    	alert("请选择载体名称,做为报表的标题.");
//    	return false;
//    }  

	 var name = obj_tree.getSelectedItemText();
	 var arr = new Array();
	 arr.push(name);
	 getCarrierParent(selectId,arr); 
	 return true; 
}

function getCarrierParent(itemId,arr){
	var obj_tree = carrierType.tree.dhtmlTree;
	var parentId = obj_tree.getParentId(itemId);
	var type = getNodeType(parentId);

	if (type == 2){
		var txt = obj_tree.getItemText(parentId);
		arr.push(txt);
	 	getCarrierParent(parentId,arr)
	}
	
	
	if (type == 1){
		 setCarrierIdLevelFirst(itemId);
		 var carrierNames = "";
		 arr.reverse(true);
		 for(var i =0;i< arr.length;i++){
		 	if(i< arr.length-1){
		 		carrierNames +=  arr[i] +"_";
		 	}else{
		 		carrierNames +=  arr[i];
		 	}
//			carrierNames +=  arr[i];
		 }
//		 alert(carrierNames);

		 $("carrierName").value = carrierNames; 
	}
	
	
	
	function setCarrierIdLevelFirst(itemId){
//		 $("carrierLevelFirstId").value =  carrierType.tree.getIdByPrefix(isFztv(itemId),carrier.IdPrefix); 
		 $("carrierLevelFirstId").value =  carrierType.tree.getIdByPrefix(itemId,carrier.IdPrefix); 
//		 alert($("carrierLevelFirstId").value);
	}
	
	
}
//function isFztv(selectId){
//	if(tvNameParam =='fztv'){
//		return selectId.substring(selectId.indexOf('_')+1); 
//	}
//	return selectId;
//}


function getPublishArrangeFromGrid(){ 
	var publishArranges = new Array();
	var resourceIds = getResourceIds();
	var publishDate =  getFormatDay($("bro_date").value,'ymd');
	var carrierName = $("carrierName").value; 
	var carrierLevelFirstId = $("carrierLevelFirstId").value;
	var selectId =  carrierType.tree.dhtmlTree.getSelectedItemId(); 

//	alert(curUserId);
//	alert(resourceIds);
	
	for(var i =0;i< resourceIds.length;i++){
		var row_id = resourceIds[i];
		var isLocked = (getCellValue(row_id,arrange.col_isLocked) == "true");
		
//		alert(isLocked);
		
		if(!isLocked){
	  		var arr = (new PublishArrange()).obj;
		    
		    with (arrange) {
		    	
		    	var idd = getCellValue(row_id,col_id);
		    	var isNew = idd >0 ? false:true;
		    	
//  	    	alert(idd);alert(isNew);
				arr.resourceName = getCellValue(row_id,col_resName); 
				arr.resourceMeno = getCellValue(row_id,col_resMeno);
				arr.resourceTotalTimes = getCellValue(row_id,col_resTotalTimes);
				arr.resourceUsedTimes = getCellValue(row_id,col_resUsedTimes);
				arr.memo = getCellValue(row_id,col_meno);
			  	arr.resourceId = getCellValue(row_id,col_resId);
				arr.filePath = getCellValue(row_id,col_filePath);
				arr.createBy = isNew ? curUserId :getCellValue(row_id,col_createBy);
//				arr.createDate = isNew ?new Date():getCellValue(row_id,col_createDate);
				arr.id = isNew ? null:getCellValue(row_id,col_id);
				arr.isLocked = isNew ? false: getCellValue(row_id,col_isLocked);
				
				
				
				arr.carrierId = carrierLevelFirstId;
			  	arr.publishDate = publishDate;
			  	arr.carrierName = carrierName;
			  	arr.isEnable = true;
				arr.modifyBy = curUserId;
//			  	arr.modifyDate = new Date();
			  	arr.version = 0;
			  	arr.isArranged = true;
//			  	if(tvNameParam =='fztv' && selectId.substring(0,1)!=3){
//			  		arr.isArranged = false;
//			  	}	 
			  	
			  	arr.beforehand = getCellValue(row_id,col_beforehand);
			  	
//			  	alert(isUndefined(arr.beforehand));

			  	if(arr.beforehand == null || arr.beforehand == '') arr.beforehand = 0;
  
			  	
	//		  	alert(arr.toString());
	//		  	DWRUtil.toDescriptiveString(arr,1,2);
	
				//通过资源查找广告
	//			arr.publishArrangeDetails =[];
	// 			arr.publishArrangeDetails =	getPublishArrangeDetailByParent(row_id,arr.id);
	            arr.details =	getPublishArrangeDetailByParent(row_id,arr.id);
			}
			publishArranges.push(arr);
		}
		
	  
    }

	//修改添加的
	return publishArranges;
}

function getPublishArrangeDetailByParent(parentId,publishArrangeId){ 
	var publishArrangeDetails = new Array();
	var adverIds = getChiledByParentId(parentId,detail.col_resourceId);
	for(var i =0;i< adverIds.length;i++){
		var row_id = adverIds[i];
		var det = (new PublishArrangeDetail()).obj;
        with (detail) {
//	 		det.id = getCellValue(row_id,col_id);
	 		det.id = null;
			det.publishArrangeId = publishArrangeId;  
			
			det.publishSort = getCellValue(row_id,col_publishSort);
			det.orderDayId = getCellValue(row_id,col_orderDayId);
			det.specificValue = getCellValue(row_id,col_specificValue);
			det.ownerUserName = getCellValue(row_id,col_ownerUserName);
			det.firstName = getCellValue(row_id,col_ownerUserName);
			det.lastName = '';
			det.customerName = getCellValue(row_id,col_customerName);
			det.tapeCode = getCellValue(row_id,col_tapeCode);
			det.matterName = getCellValue(row_id,col_matterName);
			det.matterEdit = getCellValue(row_id,col_matterEdit);
			det.matterLength = getCellValue(row_id,col_matterLength);
//			det.adverTimes = getCellValue(row_id,col_adverTimes);
			det.adverTimes = 1;
			det.publishMemo = getCellValue(row_id,col_publishMemo);
			det.specificName = getCellValue(row_id,col_specificName);	
//			det.ownerUserId = getCellValue(row_id,col_ownerUserId);
			
			
        }
        publishArrangeDetails.push(det);
	}	
	
	return publishArrangeDetails;
}   

function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}


















function getNodeType(itemId){
  	var obj_tree = carrierType.tree.dhtmlTree;
	return obj_tree.getUserData(itemId,"type");
}	


function showTree(){
	isDisplay(true);
}

function changeTree(){
	isDisplay(false);
}

function isDisplay(bln){
	if(bln){		
		$("carrierTypeTreeTable").show();
		$("buttonTable").show();
		$("matterTypeTreeboxTable").hide();
	}else{
		$("carrierTypeTreeTable").hide();
		$("buttonTable").hide();
		$("matterTypeTreeboxTable").show();
	}
}




function button_view_bro(){
//	 var selectId =  carrierType.tree.dhtmlTree.getSelectedItemId();
//	if(fztvSpecialParam==1&&selectId.substring(0,1)!=3){
//		 window.location.href=getReportURL('export');
//	}else{
		 $("model").value = "view";
   		 button_print(); 
//	}
}
function button_print_bro(){
//	 var selectId =  carrierType.tree.dhtmlTree.getSelectedItemId();
//	 if(fztvSpecialParam==1&&selectId.substring(0,1)!=3){
//		 window.location.href=getReportURL('print');
//	 }else{
		 $("model").value = "print";
   		 button_print();    
//	 }
}
function button_export_bro(){
//	if(tvNameParam =='fztv'){
//		 displayExportDiv();
//	}else{
		 $("model").value = "export";
   		 button_print();
//	}

}
function button_print(){
	
	
	
	var obj_tree = carrierType.tree.dhtmlTree;
    var resourceIds = getBuildResourceIds();
    var publishDate =  getFormatDay($("bro_date").value,'ymd');
//	curUserName = user.getUserFullName(userName);
	getCarrierName();

	var selectId = obj_tree.getSelectedItemId();
//	var carrierId = carrierType.tree.getIdByPrefix(isFztv(selectId),carrier.IdPrefix); 
	var carrierId = carrierType.tree.getIdByPrefix(selectId,carrier.IdPrefix); 
	var parentName =  carrierType.tree.dhtmlTree.getParentId(selectId);
    
	var carrierName = $("carrierName").value;

    if(resourceIds !='' && publishDate !=''){
        $("carrierId").value= carrierId;
        $("carrierName").value= carrierName;
        $("parentName").value= parentName; 
        $("resourceIds").value= resourceIds; 
        $("publishDate").value = publishDate;
        $("bianpainame").value = userName;
					 $("printOrgid").value = $("orgId").value;
					 
//					 $("arrangeforce").value = $("orgId").value;
					
        var tarForm= $("tarForm");
        
        var reportForm = $("ReportForm");
        reportForm.target = tarForm;
        reportForm.action="reports/jsp/arrange_print.jsp";
	    reportForm.submit();        	
    }
    
    
}
function forPrint(){
	$("model").value = "print";
	var obj_tree = carrierType.tree.dhtmlTree;
    var resourceIds = getBuildResourceIds();
    var publishDate =  getFormatDay($("bro_date").value,'ymd');
//	curUserName = user.getUserFullName(userName);
	getCarrierName();
	
	var selectId = obj_tree.getSelectedItemId(); 
//	var carrierId = carrierType.tree.getIdByPrefix(isFztv(selectId),carrier.IdPrefix);
	var carrierId = carrierType.tree.getIdByPrefix(selectId,carrier.IdPrefix);
	var parentName =  carrierType.tree.dhtmlTree.getParentId(selectId);
	
	if(carrierId==null||carrierId==""){
			extjMessage('请选择载体名称!');
	}else{
			var carrierName = $("carrierName").value;
	    
		    if(resourceIds !='' && publishDate !=''){
		        $("carrierId").value= carrierId;
		        $("carrierName").value= carrierName;
		        $("parentName").value= parentName; 
		        $("resourceIds").value= resourceIds;
		        $("publishDate").value = publishDate;
		        $("bianpainame").value = userName;
		        $("printOrgid").value = $("orgId").value;
		        var tarForm= $("tarForm");
		        
		        var reportForm = $("ReportForm");
		        reportForm.target = tarForm;
		        reportForm.action="reports/jsp/publishArrange_print.jsp";
			reportForm.submit();    
		}    	
    }	
}
function getReportURL(model){
		var obj_tree = carrierType.tree.dhtmlTree;
	    var resourceIds = getBuildResourceIds();
	    var publishDate =  getFormatDay($("bro_date").value,'ymd');
//		curUserName = user.getUserFullName(userName);
//		getCarrierName();
	
//		var selectId = obj_tree.getSelectedItemId();
//		var carrierId = carrierType.tree.getIdByPrefix(isFztv(selectId),carrier.IdPrefix); 
//		var parentName =  carrierType.tree.dhtmlTree.getParentId(selectId);
		
//		var carrierName = $("carrierName").value;

	    var carrierName = '';
		if(resourceIds.length>0){
			carrierName = obj_tree.getItemText('resourceId'+resourceIds[0]);
			var i = carrierName.indexOf('(');
			carrierName = carrierName.substring(i+1,carrierName.length-1);
		}
         
	    if(resourceIds !='' && publishDate !=''){
	        var url = $('ctxPath').value;
			var a = {
				 	model: model,
	                reportType: "publishArrange_report",
	                headers:'资源名称,广告名称,广告版本,长度,业务员',
	                displaySumColum:'0,0,0,1,0',
	                isSum:true,
	                isVertical:false,
	                carrierName:carrierName,
	                resourceIds:resourceIds.toString(),  
	                publishDate:publishDate,
	                orgId:$("orgId").value
			};		
			var h = $H(a); 
			url = url +"reports/printServlet?"+ encodeURI(h.toQueryString());	
			return url;
	    }
}
