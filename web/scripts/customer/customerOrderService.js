var editMode;
var ctxPath;
var customer = new Customer();
var order = new Order();
callOnLoad(init);


function init(){
	ctxPath = getCtxPath(); 	
	$("CusId").value = getParamFromUrl(document.location.href,"cusId");
	
	

	
    initGrid();
    
    getOrderByCustomerId();
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
//序   	订单编号   	合同编号   	开始日期  	结束日期   	应付金额   	分配金额   	审核
	var flds = "序,订单编号,合同编号,开始日期,结束日期,应付金额,分配金额,审核";
	mygrid.setHeader(flds);

	mygrid.setInitWidthsP("11,13,13,13,13,13,13,11");
	mygrid.setColAlign("left,left,left,left,left,left,left,left");
	mygrid.setColTypes("ed,link,ed,ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
	mygrid.setColSorting("str,str,str,str,str,str,str,str") ;
    
	mygrid.setMultiLine(false);
	mygrid.setEditable(false);
	//mygrid.enableDragAndDrop(false);
	mygrid.setSkin("modern2");
	mygrid.init();	 
	mygrid.setSortImgState(true,0,"ASC"); 
	
}

function getOrderByCustomerId(){
	var cusId = $("CusId").value ==null||$("CusId").value ==""?0:$("CusId").value;
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	
	
		order.reset();
		order.obj.customerId = cusId;
		order.obj.customer = (new Customer()).obj;
		order.obj.orderPublic = (new OrderPublic).obj;
//		order.obj.orderPublic.publishStartDate = -1;
		order.getOrderListXML(order.obj,func);
	
}
