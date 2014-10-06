var proOrder = new ProOrder();
var proCustomer = new ProCustomer();
var proProgram = new ProProgram();
var ctxPath;
var proCusId;

callOnLoad(init);



function init(){
	ctxPath = $F("ctxPath");
	proCusId = getParamFromUrl(document.location.href,"cusId");
	proOrderTypeId = getParamFromUrl(document.referrer,"orderTypeId");
        initGrid3();
       if(proCusId!=0){ 
       		getNameByCustomerId();
       	}
}




function initGrid3(){
	var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("节目名称,客户名称,应付金额,付款金额,业务员,应付日期,付款日期");
		mygrid.setInitWidthsP("25,25,10,10,10,10,10")
		mygrid.setColAlign("left,left,right,right,left,right,right")
		mygrid.setColTypes("ro,ro,ro,ro,ro,ro,ro");
		mygrid.setColSorting("str,str,str,int,str,str,str")
		mygrid.enableMultiselect(true)
		mygrid.init();
		//mygrid.loadXML("sampleData/order_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
}
function getNameByCustomerId(){
	 function func(objs){
		 	
		 		$("proCusName").value = objs.customerName;
				getProOrderList();
   				    }
   				    
		                proCustomer.getProCustomer(proCusId,func);
}
function getProOrderList(){

	 function getFun(xml){
    	    mygrid.clearAll();
	        mygrid.loadXMLString(xml);
    }	
	proOrder.reset();
	var programs ={proCustomer:{customerName:$("proCusName").value}};
	proOrder.obj.program =programs;
	proOrder.obj.orderTypeId=proOrderTypeId;
	proOrder.getProOrderXML(proOrder.obj,getFun);
	
}

