var editMode;
var ctxPath;
//var customerAddress = new CustomerAddress();
var contract = new Contract();
callOnLoad(init);


function init(){
	ctxPath = getCtxPath();	
	$("CusId").value = getParamFromUrl(document.location.href,"cusId");
//	initToolbar();
    initGrid();
    
    getLinkHisotryByCustomerId();

}

	
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath(imagePath);
//合同编号   	合同总金额   	已投放金额   	平帐金额   	开始日期   	结束日期   	状态
	var flds = "合同编号,合同总金额,已投放金额,平帐金额,开始日期,结束日期,状态";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("16,14,14,14,14,14,13");
	mygrid.setColAlign("left,right,right,right,right,right,right");
	mygrid.setColTypes("link,ed,ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str,str,str,str") ;
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
//	mygrid.setOnRowSelectHandler(onRowSelectd,true);

    resetHeigth();
}

function resetHeigth(){

    var dialogcontent = parent.document.getElementById("details");
    
    var gridbox = $("gridbox");
 
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
   
} 
	
function onRowSelectd(rowId){
			window.location.href=ctxPath+"editContract.html?id="+rowId;
}

function getLinkHisotryByCustomerId(){
	var cusId = $("CusId").value ==null||$("CusId").value ==""?0:$("CusId").value;
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	
	contract.reset();
	contract.obj.customerId = cusId;
	contract.getcontractXML(contract.obj,func);
	
}

function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		
		aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
		aToolBar.setOnClickHandler(onButtonClick);

		aToolBar.loadXML(toolbarDataPath,callBack);
		
		function callBack(){
			aToolBar.hideButtons(); 
			
			if(editMode){
				$("CusId").value = getParamFromUrl(document.location.href,"cusId");
	         	aToolBar.showButtons("1_new,2_delete,3_save");  
		        aToolBar.showButtons("div_1,div_2,div_3"); 
		               
			}else{
				
				aToolBar.showButtons("1_new,3_save");  
		        aToolBar.showButtons("div_1,div_3"); 
		                
			}
	       aToolBar.setBarAlign("right");
		}
  
                aToolBar.showBar();   
	}
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new') btnAddRow();
		if(itemId=='2_delete') btnDeleteRow();
		if(itemId=='3_save') saveCustomerAddress();
	}
	
function btnAddRow(){
	
		mygrid.addRow((new Date()).valueOf(),["","","",""],mygrid.getRowsNum()+1);
}

function btnDeleteRow(){
	var id = mygrid.getSelectedId();
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
//		customerAddress.removeProPublishPlan(id);
		mygrid.deleteSelectedItem(); 
	    } 
	}
}

//function saveCustomerAddress(){  
//
//		var rowId = mygrid.getSelectedId();
//		if(rowId > 0){
//			
//			customerAddress.reset();
//			if(rowId.length>10){
//				customerAddress.obj.id = null;
//			}else{
//				customerAddress.obj.id = rowId;
//			}
//			customerAddress.obj.customerId = 110;
//			customerAddress.obj.addressType = getCellValue(rowId,0);
//			customerAddress.obj.address = getCellValue(rowId,1);
//			customerAddress.obj.city = getCellValue(rowId,2);
//			customerAddress.obj.country = getCellValue(rowId,3);
//			customerAddress.obj.postalCode = getCellValue(rowId,4)
//			customerAddress.obj.province = getCellValue(rowId,5)
//		
//				var func = function(id){
//				mygrid.changeRowId(rowId,id);
//				alert("保存成功！！！");
//			}
//			
//			customerAddress.saveCustomerAddress(customerAddress.obj,func);
//	    	
//		}else{
//			alert("请选择要保存的数据");
//		}
//	 
//	}


function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}

function getFormatDate(shortDate,format){
	var m =  shortDate.substring(0,2);
	var d =  shortDate.substring(3,5);
	var y =  shortDate.substring(6,10);
	shortDate = y + m + d;
	return shortDate;
}