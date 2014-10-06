var editMode;
var ctxPath;
var matter = new Matter();
callOnLoad(init);


function init(){
	ctxPath =getCtxPath(); 	
	$("CusId").value = getParamFromUrl(document.location.href,"cusId");
    initGrid();
    
    getContractPaymentByCustomerId();
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
//广告名称   	版本   	长度   	磁带编号
	var flds = "广告名称,版本,长度,磁带编号";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("30,30,20,20");
	mygrid.setColAlign("left,left,left,left");
	mygrid.setColTypes("ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str") ;
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
}

function getContractPaymentByCustomerId(){
	var cusId = $("CusId").value ==null||$("CusId").value ==""?0:$("CusId").value;
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	
		matter.reset();
		matter.obj.customerId = cusId;
		matter.getMattersListXML(matter.obj,func);	

	
}
