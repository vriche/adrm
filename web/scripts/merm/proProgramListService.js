var proProgram = new ProProgram();
var proCustomer = new ProCustomer();
var ctxPath;
var proCusId;
callOnLoad(init2);


function init2(){

	ctxPath = $F("ctxPath");
	proCusId = getParamFromUrl(document.location.href,"cusId");
	proOrderTypeId=getParamFromUrl(document.referrer,"orderTypeId");
    initGrid2();
    if(proOrderTypeId==1){
      if(proCusId!=0){
    	
    	getNameByCustomerId();
       }
   }
}

	
function initGrid2(){
	   var imagePath = ctxPath + "image/grid/";
	
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds = "节目名称,客户名称,版权号,发行单位,节目类型,版权期限";
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("15,23,15,21,13,13");
	mygrid.setColAlign("left,left,right,left,left,right");
	mygrid.setColTypes("ed,ed,ed,ed,ed,ed");
	mygrid.enableAlterCss("even","uneven"); 
    mygrid.setMultiLine(false);
	mygrid.setEditable(false);
//	mygrid.enableDragAndDrop(false);
    mygrid.setSkin("modern2");
	mygrid.init();	 
}

function getNameByCustomerId(){
	 function func(objs){
		 	
		 		$("proCusName").value = objs.customerName;
					getProgramSearchList();
   				    }
   				    
		                proCustomer.getProCustomer(proCusId,func);
}
function getProgramSearchList(){
	proProgram.reset() ;
	var cusName = $("proCusName").value;
	
	var func = function(xml){
		mygrid.clearAll();
		mygrid.loadXMLString(xml);
	}
	proProgram.getProgramByCustomerXML(cusName,func) ;

	
}