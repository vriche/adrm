var editMode;
var ctxPath;
//var customerAddress = new CustomerAddress();
var linkman = new LinkMan();
callOnLoad(init);


function init(){
	ctxPath = getCtxPath();
//	$("CusId").value = getParamFromUrl(document.location.href,"cusId");
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
//住宅电话   	工作电话   	移动电话  	首选电子信箱  	主要联系人
	var flds = "序号,联系人姓名,住宅电话,工作电话,移动电话,首选电子信箱,主要联系人";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("10,16,16,16,16,16,10");
	mygrid.setColAlign("left,left,left,left,left,left,left");
	mygrid.setColTypes("link,ed,ed,ed,ed,ed,ra");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str,str,str,str") ;
    
	mygrid.setMultiLine(false);
//	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
//	mygrid.setOnRowSelectHandler(onRowSelectd,true);
}
	
function onRowSelectd(rowId){
			window.location.href=ctxPath+"proOrderEdit.jsp?type="+rowId;
	
}

function getLinkmanByCustomerId(){
	var cusId = $("CusId").value ==null||$("CusId").value ==""?0:$("CusId").value;
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	
	linkman.reset();
	linkman.obj.customerId = cusId;
	linkman.getLinkManXML(linkman.obj,func);
	
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
		        
    			getLinkmanByCustomerId(); 
		   
	       aToolBar.setBarAlign("right");
		}
  
                aToolBar.showBar();   
	}
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new') btnAddRow();
		if(itemId=='2_delete') btnDeleteRow();
		if(itemId=='3_save') saveCustomerLinkMan();
	}
	
function btnAddRow(){
	
		mygrid.addRow((new Date()).valueOf(),["","","","","","","0"],mygrid.getRowsNum()+1);
}

function btnDeleteRow(){
	var id = mygrid.getSelectedId();
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
		linkman.removeCustomerLinkMan(id);
		mygrid.deleteSelectedItem(); 
	    } 
	}
}

function saveCustomerLinkMan(){  

		var rowId = mygrid.getSelectedId();
		if(rowId > 0){
			
			linkman.reset();
			if(rowId.length>10){
				linkman.obj.id = null;
			}else{
				linkman.obj.id = rowId;
			}
			// homeTel:null, officeTel:null,mobile:
			linkman.obj.customerId = $("CusId").value;
			linkman.obj.linkmanName = getCellValue(rowId,1);
			linkman.obj.homeTel = getCellValue(rowId,2);
			linkman.obj.officeTel = getCellValue(rowId,3);
			linkman.obj.mobile = getCellValue(rowId,4);
			linkman.obj.favorEmail = getCellValue(rowId,5)
			linkman.obj.isCustomerMain = getCellValue(rowId,6)
			linkman.obj.version = 0;
			
					if(linkman.obj.isCustomerMain=1){
						var cusMainId = $("CusId").value;
						
						var funcMain = function(){
							
							var func = function(id){
								mygrid.changeRowId(rowId,id);
								getLinkmanByCustomerId(); 
								alert("保存成功！！！");
							}
							
							linkman.saveCustomerLinkMan(linkman.obj,func);
							
						}
						
						linkman.resetMainLinkMan(cusMainId,funcMain);
						
					}else{
						
						var func = function(id){
						mygrid.changeRowId(rowId,id);
						getLinkmanByCustomerId(); 
						alert("保存成功！！！");
						}
					
						linkman.saveCustomerLinkMan(linkman.obj,func);
					}
		
		}else{
			alert("请选择要保存的数据");
		}
	 
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