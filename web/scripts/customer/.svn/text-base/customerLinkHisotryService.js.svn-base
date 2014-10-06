var editMode;
var ctxPath;
//var customerAddress = new CustomerAddress();
var linkHistory = new LinkHistory();
var user = new User();
callOnLoad(init);


function init(){
	ctxPath = getCtxPath();	
//	$("CusId").value = getParamFromUrl(document.location.href,"cusId");
	setUserPara(user);
//	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);
	initToolbar();
    initGrid();
     resetHeigth();

}

function resetHeigth(){

    var dialogcontent = parent.document.getElementById("details");
    
    var gridbox = $("gridbox");
 
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
   
} 	
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath(imagePath);
//主题   	联系时间   	接洽人   	联系人编号
	var flds = "主题,联系时间,接洽人,联系人编号";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("40,20,20,19");
	mygrid.setColAlign("left,right,right,right");
	mygrid.setColTypes("ed,calendar,coro,ed");
	mygrid.setDateFormat("y/m/d");
	user.makeSelectAnalyze(user,user.selectName,"",getCarrierCombo);
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str") ;
    
	mygrid.setMultiLine(false);
//	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
}

function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userName"; 
}

function getLinkHisotryByCustomerId(){
	var cusId = $("CusId").value ==null||$("CusId").value ==""?0:$("CusId").value;
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	
	linkHistory.reset();
	linkHistory.obj.customerId = cusId;
	linkHistory.getlinkHistoryXML(linkHistory.obj,func);
	
}

function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		
		aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
		aToolBar.setOnClickHandler(onButtonClick);

		aToolBar.loadXML(toolbarDataPath,callBack);
		
		function callBack(){
			aToolBar.hideButtons(); 
			
				$("CusId").value = getParamFromUrl(document.location.href,"cusId");
	         	aToolBar.showButtons("1_new,2_delete,3_save");  
		        aToolBar.showButtons("div_1,div_2,div_3"); 
		        
    			getLinkHisotryByCustomerId();
		     
	       aToolBar.setBarAlign("right");
		}
  
                aToolBar.showBar();   
	}
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new') btnAddRow();
		if(itemId=='2_delete') btnDeleteRow();
		if(itemId=='3_save') saveCustomerLinkHisotry();
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
		linkHistory.removeCustomerAddressById(id);
		mygrid.deleteSelectedItem(); 
	    } 
	}
}

function saveCustomerLinkHisotry(){  

		var rowId = mygrid.getSelectedId();
		if(rowId > 0){
			
			linkHistory.reset();
			if(rowId.length>10){
				linkHistory.obj.id = null;
			}else{
				linkHistory.obj.id = rowId;
			}
			linkHistory.obj.customerId = $("CusId").value;
			linkHistory.obj.subject = getCellValue(rowId,0);
			linkHistory.obj.linkDate = getFormatDate(getCellValue(rowId,1),'ymd');
			linkHistory.obj.linkManId = getCellValue(rowId,2);
			linkHistory.obj.counterpartMan = getCellValue(rowId,3);
			linkHistory.obj.version = 0;
		
				var func = function(id){
				mygrid.changeRowId(rowId,id);
				alert("保存成功！！！");
			}
			
			linkHistory.saveCustomerLinkHisotry(linkHistory.obj,func);
	    	
		}else{
			alert("请选择要保存的数据");
		}
	 
	}


function getCarrierCombo(){
	var el = $(user.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(2);
//	var arr = getCarrierIds();
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
	    if(ip.value!=0){
		command.put(ip.value,el.options[ip.index].text);

	   }	
	});
}
 function getCarrierIds(){
	var rows = mygrid.getRowsNum();
   	 var ids = new Array();
	for(var i=0;i<rows;i++){
		var id = mygrid.getRowId(i); 
		ids.push(getCellValue(id,5));
	}
	return ids;
}
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