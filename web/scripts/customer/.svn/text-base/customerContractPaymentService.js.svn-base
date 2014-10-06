var editMode;
var ctxPath;
var payment = new PayMent();
callOnLoad(init);


function init(){
	ctxPath = getCtxPath();	
	$("CusId").value = getParamFromUrl(document.location.href,"cusId");
    initGrid();
    
    getContractPaymentByCustomerId();

}

	
function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.selMultiRows = true;
	mygrid.setImagePath(imagePath);
//次数   	应付款日期   	合同编号   	订单编号  	应付金额   	平帐金额
	var flds = "次数,应付款日期,合同编号,订单编号,应付金额,平帐金额";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("15,17,17,17,17,16");
	mygrid.setColAlign("left,left,left,left,left,left");
	mygrid.setColTypes("ed,ed,link,link,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str,str,str") ;
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
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

function getContractPaymentByCustomerId(){
	var cusId = $("CusId").value ==null||$("CusId").value ==""?0:$("CusId").value;
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	
		payment.reset();
		payment.obj.customerId = cusId;
		payment.getPaymentListXML(payment.obj,func);	

	
}
