var ctxPath;
var proCustomer = new ProCustomer();
var proOrder = new ProOrder();
var proCusId;
callOnLoad(init);


function init(){
		ctxPath = $F("ctxPath");
		proCusId= getParamFromUrl(document.location.href,"cusId");
		proOrderTypeId = getParamFromUrl(document.referrer,"orderTypeId");
        initGrid4();
        
		 if(proCusId!=0){ 
		 	getNameByCustomerId();
		 	}
}

	
function initGrid4(){
		var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("订单号,客户名称,业务员,应付金额,应付时间,已付金额,已付时间,欠款金额");
		mygrid.setInitWidthsP("12,16,12,12,12,12,12,12")
		mygrid.setColAlign("left,left,left,right,right,right,right,right")
		mygrid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro");
		mygrid.setColSorting("int,str,str,str,str,str,str,str")
		mygrid.setMultiLine(false);
		mygrid.setEditable(false);
		mygrid.init();
//		mygrid.loadXML("sampleData/payment_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		//mygrid.setOnRowDblClickedHandler(rowDblClick);
}
function getNameByCustomerId(){
	 function func(objs){
		 	
		 		$("proCusName").value = objs.customerName;
				getPaymentListByCustomer();
   				    }
   				    
		                proCustomer.getProCustomer(proCusId,func);
}

function getPaymentListByCustomer(){
	
		proOrder.reset();
		proOrder.obj.orderTypeId=proOrderTypeId;
		var programs={proCustomer:{customerName:$("proCusName").value}};
		
		proOrder.obj.program=programs;
		 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proOrder.getPaymentByCustomerXML(proOrder.obj,func);
}