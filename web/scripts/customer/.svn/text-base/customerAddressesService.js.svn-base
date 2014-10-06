var editMode;
var ctxPath;
var customerAddress = new CustomerAddress();
var oaAreaCity = new OaAreaCity();
callOnLoad(init);


function init(){
	
	ctxPath = getCtxPath();	 	
	editMode = getParamFromUrl(document.location.href,"cusId");
	setAreaCityPara(oaAreaCity);

	initToolbar();
    initGrid();
    
}
function setAreaCityPara(obj){
	 obj.className  = "oaAreaCity";
	 obj.selectName =  "areaCitys"; 
}
	
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath(imagePath);

	var flds = "地址类别,街道,城市,国家,邮编,直辖市/省";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("16,20,16,15,16,16");
	mygrid.setColAlign("left,left,left,left,left,left");
	mygrid.setColTypes("ed,ed,ed,ro,ed,coro");
	oaAreaCity.makeSelectAnalyze(oaAreaCity,oaAreaCity.selectName,"",getCarrierCombo);
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str,str,str") ;
    
	mygrid.setMultiLine(false);
//	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	resetHeigth();
	
}

function resetHeigth(){

    var dialogcontent = parent.document.getElementById("details");
    
    var gridbox = $("gridbox");
 
    gridbox.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
   
} 


function getAddressByCustomerId(){
	var cusId = $("CusId").value ==null||$("CusId").value ==""?0:$("CusId").value;
	
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	customerAddress.getCustomerAddresssXML(cusId,func) ;
	
}

function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		
		aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
		aToolBar.setOnClickHandler(onButtonClick);

		aToolBar.loadXML(toolbarDataPath,callBack);
		
		function callBack(){
			aToolBar.hideButtons(); 
			
			if(editMode*1>0){
				$("CusId").value = editMode;
	         	aToolBar.showButtons("1_new,2_delete,3_save");  
		        aToolBar.showButtons("div_1,div_2,div_3"); 
		        
    			getAddressByCustomerId();
		               
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
	
		mygrid.addRow((new Date()).valueOf(),["","","","中国","","1"],mygrid.getRowsNum()+1);
}

function btnDeleteRow(){
	var id = mygrid.getSelectedId();
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
	    	
			customerAddress.removeCustomerAddressById(id);
			mygrid.deleteSelectedItem(); 
		
	    } 
	}
}

function saveCustomerAddress(){  

		var rowId = mygrid.getSelectedId();
		if(rowId > 0){
			
			customerAddress.reset();
			if(rowId.length>10){
				customerAddress.obj.id = null;
			}else{
				customerAddress.obj.id = rowId;
			}
			customerAddress.obj.customerId = $("CusId").value;
			customerAddress.obj.addressType = getCellValue(rowId,0);
			customerAddress.obj.address = getCellValue(rowId,1);
			customerAddress.obj.city = getCellValue(rowId,2);
			customerAddress.obj.country = getCellValue(rowId,3);
			customerAddress.obj.postalCode = getCellValue(rowId,4)
			customerAddress.obj.province = getCellValue(rowId,5)
			customerAddress.obj.version = 0;
		
				var func = function(id){
				mygrid.changeRowId(rowId,id);
				alert("保存成功！！！");
			}
			
			customerAddress.saveCustomerAddress(customerAddress.obj,func);
	    	
		}else{
			alert("请选择要保存的数据");
		}
	 
	}

function getCarrierCombo(){
	var el = $(oaAreaCity.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(5);
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